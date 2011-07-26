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

package com.liferay.newsletter.service.impl;

import com.liferay.newsletter.ContactsException;
import com.liferay.newsletter.EmailSubjectException;
import com.liferay.newsletter.SenderEmailException;
import com.liferay.newsletter.SenderNameException;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.newsletter.util.MailAuthenticator;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Bruno Pinheiro
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	public Campaign addCampaign(
			long campaignContentId, String senderEmail, String senderName,
			String emailSubject, int sentDateMonth, int sentDateDay,
			int sentDateYear, String contacts)
		throws PortalException, SystemException {

		validate(emailSubject, senderEmail, senderName, contacts);

		Date sentDate = PortalUtil.getDate(
			sentDateMonth, sentDateDay,sentDateYear);

		long campaignId = counterLocalService.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		campaign.setSentDate(sentDate);
		campaign.setEmailSubject(emailSubject);
		campaign.setSenderEmail(senderEmail);
		campaign.setSenderName(senderName);
		campaign.setSent(false);

		CampaignContent campaignContent =
			campaignContentLocalService.getCampaignContent(campaignContentId);

		campaign.setContent(campaignContent.getContent());
		campaign.setCampaignContentId(campaignContentId);

		return campaignPersistence.update(campaign, false);
	}

	public void checkCampaigns() throws PortalException, SystemException {
		Date currentDate = new Date();

		List<Campaign> campaigns = getCampaignsBySendDateLT(
			currentDate, false);

		for (Campaign campaign : campaigns) {
			try {
				sendCampaign(campaign);
			}
			catch (IOException ioe) {
				throw new SystemException(ioe);
			}
		}
	}

	public void deleteCampaign(Campaign campaign)
		throws PortalException, SystemException {

		List<NewsletterLog> newsletterLogs =
			newsletterLogLocalService.getNewsletterLogByCampaign(
				campaign.getCampaignId());

		for (NewsletterLog newsletterLog : newsletterLogs) {
			newsletterLogLocalService.deleteNewsletterLog(newsletterLog);
		}

		campaignPersistence.remove(campaign);
	}

	public void deleteCampaign(long campaignId)
		throws PortalException, SystemException {

		Campaign campaign = campaignPersistence.findByPrimaryKey(campaignId);

		deleteCampaign(campaign);
	}

	public Campaign getCampaign(long campaignId)
		throws PortalException, SystemException {

		return campaignPersistence.findByPrimaryKey(campaignId);
	}

	public List<Campaign> getCampaignsByCampaignContent(long campaignContentId)
		throws SystemException{

		return campaignPersistence.findByCampaignContent(campaignContentId);
	}

	public int getCampaignsByCampaignContentCount(long campaignContentId)
		throws SystemException{

		return campaignPersistence.findByCampaignContent(
				campaignContentId).size();
	}

	public List<Campaign> getCampaignsByDate(Date sendDate)
		throws SystemException{

		return campaignPersistence.findBySentDate(sendDate);
	}

	public List<Campaign> getCampaignsBySendDateLT(Date sendDate, boolean sent)
		throws SystemException{

		return campaignPersistence.findBySD_LT(sendDate, sent);
	}

	public List<NewsletterLog> getNewsletterLogs(Campaign campaign)
		throws SystemException{

		return campaignPersistence.getNewsletterLogs(campaign.getCampaignId());
	}

	public void sendCampaign(Campaign campaign)
		throws SystemException, PortalException, IOException {

		List<NewsletterLog> newsletterLogs =
			newsletterLogLocalService.getNewsletterLogByCampaign(
				campaign.getCampaignId());

		for (NewsletterLog newsletterLog : newsletterLogs) {
			sendEmail(newsletterLog.getContactId(), campaign);

			newsletterLog.setSent(true);

			newsletterLogLocalService.updateNewsletterLog(newsletterLog);
		}

		campaign.setSent(true);

		campaignLocalService.updateCampaign(campaign);
	}

	protected void sendEmail(
			long contactId, Campaign campaign)
		throws IOException, PortalException, SystemException {

		String passwordString = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PASSWORD);
		String userString = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);
		String host = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST);
		String port = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_SMTP_PORT);

		if (passwordString.isEmpty()) {
			passwordString = PropsUtil.get(
				PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST);
		}

		if (userString.isEmpty()) {
			userString = PropsUtil.get(PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST);
		}

		if (host.isEmpty()) {
			host = PropsUtil.get(PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST);
		}

		if (port.isEmpty()) {
			port = PropsUtil.get(PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST);
		}

		Properties properties = new Properties();

		properties.put(NewsletterConstants.MAIL_TRANSPORT_PROTOCOL, "smtp");
		properties.put(NewsletterConstants.MAIL_SMTP_HOST, host);
		properties.put(NewsletterConstants.MAIL_SMTP_SOCKET_FACTORY_PORT, port);
		properties.put(NewsletterConstants.MAIL_SMTP_PORT, port);
		properties.put(
			NewsletterConstants.MAIL_SMTP_SOCKET_FACTORY_FALLBACK, "false");
		properties.put(NewsletterConstants.MAIL_SMTP_STARTTLS_ENABLE, "true");
		properties.put(NewsletterConstants.MAIL_SMTP_AUTH, "true");

		MailAuthenticator mailAuthenticator = new MailAuthenticator(
			userString, passwordString);

		Session session = Session.getInstance(properties, mailAuthenticator);

		String senderEmail = campaign.getSenderEmail();
		String emailSubject = campaign.getEmailSubject();
		String content = campaign.getContent();
		String senderName = campaign.getSenderName();
		String from = "\""+senderName+"\" <"+senderEmail+">";

		Contact contact = contactPersistence.findByPrimaryKey(contactId);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipient(
				Message.RecipientType.TO,
				new InternetAddress(contact.getEmail()));
			message.setSentDate(new Date());
			message.setSubject(emailSubject);
			message.setContent(content, "text/html");

			Transport.send(message);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	protected void validate(String emailSubject, String senderEmail,
			String senderName, String contacts)
		throws PortalException {

		if (Validator.isNull(emailSubject)) {
			throw new EmailSubjectException();
		}
		else if (Validator.isNull(senderEmail)) {
			throw new SenderEmailException("x-is-required");
		}
		else if (!Validator.isEmailAddress(senderEmail)) {
			throw new SenderEmailException("x-is-wrong-formated");
		}
		else if (Validator.isNull(senderName)) {
			throw new SenderNameException();
		}
		else if (Validator.isNull(contacts)) {
			throw new ContactsException();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		CampaignLocalServiceImpl.class);

}