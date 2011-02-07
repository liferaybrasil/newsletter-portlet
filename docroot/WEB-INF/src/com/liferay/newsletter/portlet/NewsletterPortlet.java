/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.model.impl.CampaignImpl;
import com.liferay.newsletter.model.impl.ContactImpl;
import com.liferay.newsletter.model.impl.NewsletterLogImpl;
import com.liferay.newsletter.model.impl.SendCampaignImpl;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.SendCampaignLocalServiceUtil;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterPortlet extends MVCPortlet {

	public void addCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		Campaign campaign = _campaignFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		if (NewsletterValidator.validateCampaign(campaign, errors)) {
			campaign = CampaignLocalServiceUtil.addCampaign(campaign);

			SessionMessages.add(request, "campaign-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/edit_campaign.jsp");
		}
	}

	public void addSendCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		SendCampaign sendCampaign = _sendCampaignFromRequest(request);

		ArrayList<String> errors = new ArrayList<String>();

		String contacts = ParamUtil.getString(request, "contacts");

		if (NewsletterValidator.validateSendCampaign(
			sendCampaign, contacts, errors)) {
		sendCampaign = SendCampaignLocalServiceUtil.addSendCampaign(
			sendCampaign);

		_registerLog(sendCampaign, contacts, request);

		sendRedirect(request, response);
		SessionMessages.add(request, "sendcampaign-added");
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/edit_send.jsp");
		}
	}

	private void _registerLog(
		SendCampaign sendCampaign, String contacts, ActionRequest request)
		throws PortalException, SystemException, AddressException,
		MessagingException {

		NewsletterLog newsletterLog;

		String[] contactsList = contacts.split(",");

		for (String contactEmail : contactsList) {
			Contact contact = _addContact(contactEmail);

			newsletterLog = new NewsletterLogImpl();
			newsletterLog.setSendCampaignId(sendCampaign.getSendCampaignId());
			newsletterLog.setContactId(contact.getContactId());

			NewsletterLogLocalServiceUtil.addNewsletterLog(newsletterLog);

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

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String cmd = ParamUtil.getString(actionRequest, "cmd");
		try {
			if (cmd.equals("sending")) {
				addSendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("campaign")) {
				addCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("resendSendCampaign")) {
				resendSendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("editCampaign")) {
				deleteCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("deleteSendCampaign")){
				deleteSendCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("deleteCampaign")) {
				deleteCampaign(actionRequest, actionResponse);
			}
			else if (cmd.equals("setNewsletterPref")) {
				setNewsletterPref(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setNewsletterPref(ActionRequest actionRequest,
		ActionResponse actionResponse)
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

		preferences.store();

		sendRedirect(actionRequest, actionResponse);
	}

	public void resendSendCampaign(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		long sendCampaignId = ParamUtil.getLong(
			actionRequest, "sendCampaignId");

		SendCampaign sendCampaign;
		try {
			sendCampaign = SendCampaignLocalServiceUtil.
				getSendCampaign(sendCampaignId);
			sendCampaign.setSent(false);

			SendCampaignLocalServiceUtil.updateSendCampaign(sendCampaign);

			SendCampaignLocalServiceUtil.sendSendCampaign(sendCampaign);

			SessionMessages.add(actionRequest, "campaign-resended");

			sendRedirect(actionRequest, actionResponse);

		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private SendCampaign _sendCampaignFromRequest(ActionRequest request) {
		int sendDateMonth = ParamUtil.getInteger(request, "sendDateMonth");
		int sendDateDay = ParamUtil.getInteger(request, "sendDateDay");
		int sendDateYear = ParamUtil.getInteger(request, "sendDateYear");

		Date sendDate = PortalUtil.getDate(
			sendDateMonth, sendDateDay,sendDateYear);

		SendCampaignImpl sendCampaign = new SendCampaignImpl();

		sendCampaign.setCampaignId(
			ParamUtil.getLong(request, "sendCampaignId"));
		sendCampaign.setSendDate(sendDate);
		sendCampaign.setCampaignId(ParamUtil.getLong(request, "campaignId"));
		sendCampaign.setSenderEmail(
			ParamUtil.getString(request, "senderEmail"));
		sendCampaign.setSenderName(ParamUtil.getString(request, "senderName"));
		sendCampaign.setEmailSubject(
			ParamUtil.getString(request, "emailSubject"));
		sendCampaign.setSent(false);

		return sendCampaign;
	}

	public void deleteCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		if (Validator.isNotNull(campaignId)) {
			CampaignLocalServiceUtil.deleteCampaign(campaignId);
			SessionMessages.add(request, "campaign-deleted");
			sendRedirect(request, response);

		}
		else {
			SessionErrors.add(request, "campaign-cannot-be-removed");
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/view_campaign.jsp");
		}
	}

	public void deleteSendCampaign(
		ActionRequest request, ActionResponse response) throws Exception {

		long sendCampaignId = ParamUtil.getLong(request, "sendCampaignId");

		if (Validator.isNotNull(sendCampaignId)) {
			SendCampaignLocalServiceUtil.deleteSendCampaign(sendCampaignId);

			SessionMessages.add(request, "sendcampaign-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "sendcampaign-cannot-be-removed");
			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter(
				"jspPage", "/html/newsletterportlet/view_send.jsp");
		}
	}

	public void setCampaignPref(
			ActionRequest request, ActionResponse response)
		throws Exception {

		String password = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD);
		String user = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_USER);
		String port = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PORT);
		String host = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_HOST);

		PortletPreferences preferences = request.getPreferences();

		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD, password);
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_USER, user);
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PORT, port);
		preferences.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_HOST, host);

		preferences.store();

		response.setPortletMode(PortletMode.VIEW);
	}

	private Campaign _campaignFromRequest(PortletRequest request) {
		CampaignImpl campaign = new CampaignImpl();

		campaign.setCampaignId(ParamUtil.getLong(request, "campaignId"));
		campaign.setTitle(ParamUtil.getString(request, "title"));
		campaign.setContent(ParamUtil.getString(request, "content"));

		return campaign;
	}

}