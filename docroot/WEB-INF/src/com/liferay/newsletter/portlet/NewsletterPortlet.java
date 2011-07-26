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

import com.liferay.newsletter.ContactsException;
import com.liferay.newsletter.ContentException;
import com.liferay.newsletter.EmailSubjectException;
import com.liferay.newsletter.IDNotFoundException;
import com.liferay.newsletter.SenderEmailException;
import com.liferay.newsletter.SenderNameException;
import com.liferay.newsletter.TitleException;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.impl.CampaignContentImpl;
import com.liferay.newsletter.model.impl.ContactImpl;
import com.liferay.newsletter.model.impl.NewsletterLogImpl;
import com.liferay.newsletter.service.CampaignContentLocalServiceUtil;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterPortlet extends MVCPortlet {

	public void addCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		int sendDateMonth = ParamUtil.getInteger(request, "sendDateMonth");
		int sendDateDay = ParamUtil.getInteger(request, "sendDateDay");
		int sendDateYear = ParamUtil.getInteger(request, "sendDateYear");

		long campaignContentId = ParamUtil.getLong(
			request, "campaignContentId");

		String senderEmail = ParamUtil.getString(request, "senderEmail");
		String senderName = ParamUtil.getString(request, "senderName");
		String emailSubject = ParamUtil.getString(request, "emailSubject");

		String contacts = ParamUtil.getString(request, "contacts");

		Campaign campaign =	CampaignLocalServiceUtil.addCampaign(
			campaignContentId, senderEmail, senderName, emailSubject,
			sendDateMonth, sendDateDay, sendDateYear, contacts);

		_registerLog(campaign, contacts, request);

		SessionMessages.add(request, "campaign-added");
		sendRedirect(request, response);
	}

	public void addCampaignContent(
			ActionRequest request, ActionResponse response)
		throws Exception {

		CampaignContent campaignContent = _campaignContentFromRequest(request);
		campaignContent.setCreateDate(new Date());

		campaignContent =
			CampaignContentLocalServiceUtil.addCampaignContent(
				campaignContent);

		SessionMessages.add(request, "campaign-content-added");

		sendRedirect(request, response);
	}

	public void deleteCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

//		if (Validator.isNotNull(campaignId)) {
			CampaignLocalServiceUtil.deleteCampaign(campaignId);

			SessionMessages.add(request, "campaign-deleted");

			sendRedirect(request, response);
//		}
/**		else {
			SessionErrors.add(request, "campaign-cannot-be-removed");
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/view_campaign.jsp");
		}**/
	}

	public void deleteCampaignContent(
			ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignContentId = ParamUtil.getLong(
			request, "campaignContentId");

//		if (Validator.isNotNull(campaignContentId)) {
			CampaignContentLocalServiceUtil.deleteCampaignContent(
				campaignContentId);
			SessionMessages.add(request, "campaign-content-deleted");
			sendRedirect(request, response);

/**		}
		else {
			SessionErrors.add(request, "campaign-content-cannot-be-removed");
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/view_campaignContent.jsp");
		} **/

	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String cmd = ParamUtil.getString(actionRequest, "cmd");

		try {
			if (cmd.equals("campaign")) {
				addCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("campaignContent")) {
				addCampaignContent(actionRequest, actionResponse);
			}
			else if (cmd.equals("resendCampaign")) {
				resendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("resendFailed")) {
				resendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("editCampaignContent")) {
				updateCampaignContent(actionRequest, actionResponse);
			}
			else if (cmd.equals("deleteCampaign")) {
				deleteCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("deleteCampaignContent")) {
				deleteCampaignContent(actionRequest, actionResponse);
			}
			else if (cmd.equals("setNewsletterPref")) {
				setNewsletterPref(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			String page = "/html/newsletterportlet/view_campaignContent.jsp";

			if (e instanceof ContactsException ||
				e instanceof EmailSubjectException ||
				e instanceof SenderNameException ||
				e instanceof SenderEmailException) {

				page = "/html/newsletterportlet/edit_campaign.jsp";
			}
			else if (e instanceof ContentException ||
					 e instanceof TitleException) {

				page = "/html/newsletterportlet/edit_campaignContent.jsp";
			}
			else if (e instanceof IDNotFoundException) {

				page = "/html/newsletterportlet/view_campaign.jsp";
			}

			SessionErrors.add(actionRequest, e.getClass().getName(), e);
			actionResponse.setRenderParameter("jspPage", page);
		}
	}

	public void resendCampaign(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		long campaignId = ParamUtil.getLong(
			actionRequest, "campaignId");

		Campaign campaign;
		try {
			campaign = CampaignLocalServiceUtil.
				getCampaign(campaignId);
			campaign.setSent(false);

			CampaignLocalServiceUtil.updateCampaign(campaign);

			CampaignLocalServiceUtil.sendCampaign(campaign);

			SessionMessages.add(actionRequest, "campaign-resended");

			sendRedirect(actionRequest, actionResponse);

		}
		catch (Exception e) {
// Colocar mensagens no JSP
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		String cmd = ParamUtil.getString(resourceRequest, "cmd");

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
			e.printStackTrace();
		}
	}

	public void updateCampaignContent(
			ActionRequest request, ActionResponse response)
		throws Exception {

		CampaignContent campaignContent = _campaignContentFromRequest(request);

/**		ArrayList<String> errors = new ArrayList<String>();

		if (NewsletterValidator.validateCampaignContent(
				campaignContent, errors)) {**/

			campaignContent =
				CampaignContentLocalServiceUtil.updateCampaignContent(
					campaignContent);

			SessionMessages.add(request, "campaign-content-updated");

			sendRedirect(request, response);

/**		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/edit_campaignContent.jsp");
		}**/
	}

	protected void getArticleContent(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		long groupId = ParamUtil.getLong(resourceRequest, "groupId");
		String articleId = ParamUtil.getString(resourceRequest, "articleId");

		OutputStream os = resourceResponse.getPortletOutputStream();

		JournalArticleDisplay contentDisplay = getArticleContentDisplay(
			resourceRequest, resourceResponse, groupId, articleId);

		try {
			os.write(contentDisplay.getContent().getBytes());
		}
		finally {
			os.close();
		}
	}

	protected JournalArticleDisplay getArticleContentDisplay(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		long groupId, String articleId) {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			"THEME_DISPLAY");

		String viewMode = ParamUtil.getString(resourceRequest, "viewMode");
		String languageId = LanguageUtil.getLanguageId(resourceRequest);

		JournalArticleDisplay articleDisplay = null;

		articleDisplay = JournalContentUtil.getDisplay(
			groupId,articleId,viewMode,languageId,themeDisplay);

		return articleDisplay;
	}

	protected void getCampaignContents(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws SystemException, IOException, JSONException {

		String keywords = ParamUtil.getString(resourceRequest, "keywords");

		if (Validator.isNotNull(keywords)) {
			keywords = StringUtil.replace(
				keywords, StringPool.STAR, StringPool.BLANK);
			List<CampaignContent> campaignContents =
				CampaignContentLocalServiceUtil.getCampaignsContentByTitle(
					keywords, 0, 5);

			JSONArray jsonArr = JSONFactoryUtil.createJSONArray(
					JSONFactoryUtil.looseSerialize(campaignContents));

			JSONObject o = JSONFactoryUtil.createJSONObject();

			o.put("results", jsonArr);

			outputJSON(resourceResponse, o.toString().getBytes());
		}
	}

	protected void getContacts(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws SystemException, IOException, JSONException {

		String keywords = ParamUtil.getString(resourceRequest, "keywords");

		if (Validator.isNotNull(keywords)) {
			keywords = StringUtil.replace(
				keywords, StringPool.STAR, StringPool.BLANK);
			List<Contact> contacts =
				ContactLocalServiceUtil.getContactByEmail(keywords, 0, 5);

			JSONArray jsonArr = JSONFactoryUtil.createJSONArray(
					JSONFactoryUtil.looseSerialize(contacts));

			JSONObject o = JSONFactoryUtil.createJSONObject();

			o.put("results", jsonArr);

			outputJSON(resourceResponse, o.toString().getBytes());
		}
	}

	protected void outputJSON(ResourceResponse resourceResponse, byte[] bytes)
		throws IOException {

		resourceResponse.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		OutputStream os = resourceResponse.getPortletOutputStream();

		try {
			os.write(bytes);
		}
		finally {
			os.close();
		}
	}

	protected void setNewsletterPref(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws ReadOnlyException, ValidatorException, IOException {

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

	private void _registerLog(
			Campaign campaign, String contacts, ActionRequest request)
		throws Exception {

		NewsletterLog newsletterLog;

		String[] contactsList = contacts.split(",");

		for (String contactEmail : contactsList) {
			contactEmail = contactEmail.trim();

			if (Validator.isEmailAddress(contactEmail)) {
				Contact contact = _addContact(contactEmail);

				newsletterLog = new NewsletterLogImpl();
				newsletterLog.setCampaignId(campaign.getCampaignId());
				newsletterLog.setContactId(contact.getContactId());

				NewsletterLogLocalServiceUtil.addNewsletterLog(newsletterLog);
			}
		}
	}

	private Contact _addContact(String contactEmail)
		throws PortalException, SystemException {

		Contact contact = ContactLocalServiceUtil.getContactByEmail(
			contactEmail);

			if (contact == null) {
				contact = new ContactImpl();
				contact.setEmail(contactEmail);

				contact = ContactLocalServiceUtil.addContact(contact);
			}

		return contact;
	}

	private CampaignContent _campaignContentFromRequest(
		PortletRequest request) {

		CampaignContentImpl campaignContent = new CampaignContentImpl();

		campaignContent.setCampaignContentId(ParamUtil.getLong(
			request, "campaignContentId"));
		campaignContent.setTitle(ParamUtil.getString(request, "title"));
		campaignContent.setContent(ParamUtil.getString(request, "content"));
		campaignContent.setArticleId(ParamUtil.getLong(request, "articleId"));

		return campaignContent;
	}

}