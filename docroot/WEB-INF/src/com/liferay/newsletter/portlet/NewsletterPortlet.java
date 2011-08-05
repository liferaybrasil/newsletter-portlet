/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.newsletter.portlet;

import com.liferay.newsletter.ContentException;
import com.liferay.newsletter.NameException;
import com.liferay.newsletter.NoSuchContactException;
import com.liferay.newsletter.NoSuchLogException;
import com.liferay.newsletter.TitleException;
import com.liferay.newsletter.model.NewsletterCampaign;
import com.liferay.newsletter.model.NewsletterContact;
import com.liferay.newsletter.model.NewsletterContent;
import com.liferay.newsletter.service.NewsletterCampaignLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterContentLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.OutputStream;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

/**
 * @author Bruno Pinheiro
 * @author Marcellus Tavares
 */
public class NewsletterPortlet extends MVCPortlet {

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(NewsletterConstants.ADD_CAMPAIGN)) {
				addCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.ADD_CONTENT)) {
				addContent(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.CONFIGURE)) {
				configure(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.DELETE_CAMPAIGN)) {
				deleteCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.DELETE_CONTENT)) {
				deleteContent(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.RESEND)) {
				resendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals(NewsletterConstants.UPDATE_CONTENT)) {
				updateContent(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			// TODO: checar se precisa disso
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			String page = "/html/newsletterportlet/view_content.jsp";

			if (e instanceof EmailAddressException ||
				e instanceof NameException) {

				page = "/html/newsletterportlet/edit_campaign.jsp";
			}
			else if (e instanceof ContentException ||
					 e instanceof TitleException) {

				page = "/html/newsletterportlet/edit_content.jsp";
			}

			SessionErrors.add(actionRequest, e.getClass().getName(), e);

			actionResponse.setRenderParameter("jspPage", page);
		}
	}

	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		// TODO: GET_CONTACTS GET_CAMPAIGN_CONTENT
		try {
			if (cmd.equals(NewsletterConstants.GET_ARTICLE_CONTENT)) {
				getArticleContent(resourceRequest, resourceResponse);
			}
			else if (cmd.equals(NewsletterConstants.GET_CAMPAIGN_CONTENT)) {
				getCampaignContents(resourceRequest, resourceResponse);
			}
			else if (cmd.equals(NewsletterConstants.GET_CONTACT)) {
				getContacts(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			// TODO: usar sempre _log.error
			e.printStackTrace();
		}
	}

	protected void addCampaign(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long scopeGroupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();

		long contentId = ParamUtil.getLong(actionRequest, "contentId");

		int sendDateDay = ParamUtil.getInteger(actionRequest, "sendDateDay");
		int sendDateMonth = ParamUtil.getInteger(
			actionRequest, "sendDateMonth");
		int sendDateYear = ParamUtil.getInteger(actionRequest, "sendDateYear");

		String senderEmail = ParamUtil.getString(actionRequest, "senderEmail");
		String senderName = ParamUtil.getString(actionRequest, "senderName");
		String emailSubject = ParamUtil.getString(
			actionRequest, "emailSubject");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			NewsletterCampaign.class.getName(), actionRequest);

		NewsletterCampaign campaign =
			NewsletterCampaignLocalServiceUtil.addCampaign(
				userId, scopeGroupId, contentId, emailSubject, senderEmail,
				senderName, sendDateDay, sendDateMonth, sendDateYear,
				serviceContext);
		
		// TODO: testar
		String[] emails = ParamUtil.getParameterValues(
			actionRequest, "contacts");

		for (String email : emails) {
			long campaignId = campaign.getCampaignId();

			NewsletterContact contact = null;

			try {
				contact = NewsletterContactLocalServiceUtil.getContact(email);
			}
			// TODO: colocar o add dentro do getContact
			catch (NoSuchContactException e) {
				contact = NewsletterContactLocalServiceUtil.addContact(
					userId,scopeGroupId, email, StringPool.BLANK,
					serviceContext);
			}

			long contactId = contact.getContactId();

			// checar email duplicados antes
			try{
				NewsletterLogLocalServiceUtil.getLog(campaignId, contactId);
			}
			catch (NoSuchLogException e) {
				NewsletterLogLocalServiceUtil.addLog(
					campaignId, contactId, false, serviceContext);
			}
		}

		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void addContent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		long articleId = ParamUtil.getLong(actionRequest, "articleId");

		String title = ParamUtil.getString(actionRequest, "title");
		String content = ParamUtil.getString(actionRequest, "content");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			NewsletterContent.class.getName(), actionRequest);

		NewsletterContentLocalServiceUtil.addContent(
			userId, scopeGroupId, articleId, title, content, serviceContext);

		// TODO: geralmente submeter form j‡ d‡ a msg verdinha
		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void configure(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, ReadOnlyException, ValidatorException {

		PortletPreferences preferences = actionRequest.getPreferences();

		preferences.setValue(
			NewsletterConstants.ROWS_PER_PAGE, ParamUtil.getString(
				actionRequest, "rowsPerPage"));
		preferences.setValue(
			NewsletterConstants.SENDER_EMAIL, ParamUtil.getString(
				actionRequest, "senderEmail"));
		preferences.setValue(
			NewsletterConstants.SENDER_NAME, ParamUtil.getString(
				actionRequest, "senderName"));
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST, ParamUtil.getString(
				actionRequest, "smtpHost"));
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PORT, ParamUtil.getString(
				actionRequest, "smtpPort"));
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_USER, ParamUtil.getString(
				actionRequest, "smtpUser"));
		preferences.setValue(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PASSWORD, ParamUtil.getString(
				actionRequest, "smtpPassword"));

		preferences.store();

		// TODO: tirar esse bloco ou o de cima
		PortletProps.set(NewsletterConstants.ROWS_PER_PAGE, ParamUtil.getString(
			actionRequest, "rowsPerPage"));
		PortletProps.set(NewsletterConstants.SENDER_EMAIL, ParamUtil.getString(
			actionRequest, "senderEmail"));
		PortletProps.set(NewsletterConstants.SENDER_NAME, ParamUtil.getString(
			actionRequest, "senderName"));
		PortletProps.set(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST, ParamUtil.getString(
			actionRequest, "smtpHost"));
		PortletProps.set(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PORT, ParamUtil.getString(
			actionRequest, "smtpPort"));
		PortletProps.set(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_USER, ParamUtil.getString(
			actionRequest, "smtpUser"));
		PortletProps.set(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PASSWORD, ParamUtil.getString(
			actionRequest, "smtpPassword"));

		SessionMessages.add(actionRequest, "preferences-added");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void deleteCampaign(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		NewsletterCampaignLocalServiceUtil.deleteCampaign(campaignId);

		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void deleteContent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long contentId = ParamUtil.getLong(actionRequest, "contentId");

		NewsletterContentLocalServiceUtil.deleteContent(contentId);

		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void getArticleContent(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			"THEME_DISPLAY");

		long groupId = ParamUtil.getLong(resourceRequest, "groupId");

		String articleId = ParamUtil.getString(resourceRequest, "articleId");
		String viewMode = ParamUtil.getString(resourceRequest, "viewMode");
		String languageId = LanguageUtil.getLanguageId(resourceRequest);

		OutputStream os = resourceResponse.getPortletOutputStream();

		JournalArticleDisplay articleDisplay = JournalContentUtil.getDisplay(
			groupId, articleId, viewMode, languageId, themeDisplay);

		try {
			String content = articleDisplay.getContent();

			os.write(content.getBytes());
		}
		finally {
			os.close();
		}
	}

	protected void getCampaignContents(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			"THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		String keywords = ParamUtil.getString(resourceRequest, "keywords");

		List<NewsletterContent> contents =
			NewsletterContentLocalServiceUtil.search(
				companyId, scopeGroupId, keywords, 0, 5, null);

		toJSON(resourceResponse, contents);
	}

	protected void getContacts(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			"THEME_DISPLAY");

		long companyId = themeDisplay.getCompanyId();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		String keywords = ParamUtil.getString(resourceRequest, "keywords");

		List<NewsletterContact> contacts =
			NewsletterContactLocalServiceUtil.search(
				companyId, scopeGroupId, keywords, 0 , 5, null);

		toJSON(resourceResponse, contacts);
	}

	protected void resendCampaign(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long campaignId = ParamUtil.getLong(actionRequest, "campaignId");

		NewsletterCampaignLocalServiceUtil.sendCampaign(campaignId);

		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

	protected void toJSON(ResourceResponse resourceResponse, Object object)
		throws Exception {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(
			JSONFactoryUtil.looseSerialize(object));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("results", jsonArray);

		resourceResponse.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		OutputStream os = resourceResponse.getPortletOutputStream();

		try {
			os.write(jsonObject.toString().getBytes());
		}
		finally {
			os.close();
		}
	}

	public void updateContent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long contentId = ParamUtil.getLong(actionRequest, "contentId");

		long articleId = ParamUtil.getLong(actionRequest, "articleId");

		String title = ParamUtil.getString(actionRequest, "title");
		String content = ParamUtil.getString(actionRequest, "content");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			NewsletterContent.class.getName(), actionRequest);

		NewsletterContentLocalServiceUtil.updateContent(
			contentId, articleId, title, content, serviceContext);

		SessionMessages.add(actionRequest, "request_processed");

		sendRedirect(actionRequest, actionResponse);
	}

}