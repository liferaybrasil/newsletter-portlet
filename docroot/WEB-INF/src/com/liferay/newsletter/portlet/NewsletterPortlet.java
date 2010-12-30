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
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterPortlet extends MVCPortlet {

	public void addCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		Campaign campaign = _campaignFromRequest(request);

		campaign = CampaignLocalServiceUtil.addCampaign(campaign);

		sendRedirect(request, response);
	}

	public void addSendCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		SendCampaign sendCampaign = _sendCampaignFromRequest(request);

		sendCampaign = SendCampaignLocalServiceUtil.addSendCampaign(
			sendCampaign);

		String contacts = ParamUtil.getString(request, "contacts");

		_registerLog(sendCampaign, contacts, request);

		sendRedirect(request, response);
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

			//_sendEmail(request, sendCampaign, contact);
		}
	}

	private Contact _addContact(String contactEmail) 
		throws PortalException, SystemException {

		Contact contact = ContactLocalServiceUtil.getContactByEmail(
			contactEmail);

		if(contact == null){
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
			if(cmd.equals("sending")){
				addSendCampaign(actionRequest, actionResponse);
			}else if(cmd.equals("campaign")){
				addCampaign(actionRequest, actionResponse);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void _sendEmail(
		ActionRequest request, SendCampaign sendCampaign, Contact contact) 
		throws AddressException, MessagingException {

		PortletPreferences prefs = request.getPreferences();

		String defaultValue = "";

		final String password = (String)prefs.getValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD, defaultValue);
		final String user = (String)prefs.getValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_USER, defaultValue);
		String host = (String)prefs.getValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_HOST, defaultValue);
		String port = (String)prefs.getValue(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PORT, defaultValue);

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(
			props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
					}
				});

		String senderEmail = sendCampaign.getSenderEmail();
		String emailSubject = sendCampaign.getEmailSubject();

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(senderEmail));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
				contact.getEmail()));
		msg.setSentDate(new Date());
		msg.setSubject(emailSubject);
		msg.setText("Web content");

		Transport.send(msg);
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

		CampaignLocalServiceUtil.deleteCampaign(campaignId);

		sendRedirect(request, response);
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

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD, password);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_USER, user);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PORT, port);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_HOST, host);

		prefs.store();

		response.setPortletMode(PortletMode.VIEW);
	}

	private Campaign _campaignFromRequest(PortletRequest request) {
		CampaignImpl campaign = new CampaignImpl();

		campaign.setCampaignId(ParamUtil.getLong(request, "campaignId"));
		campaign.setTitle(ParamUtil.getString(request, "title"));

		return campaign;
	}

}