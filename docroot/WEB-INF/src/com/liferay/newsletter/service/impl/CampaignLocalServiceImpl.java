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

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.CampaignContentLocalServiceUtil;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.newsletter.util.MailAuthenticator;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Bruno Pinheiro
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	public Campaign addCampaign(
			long campaignContentId, String senderEmail, String senderName,
			String emailSubject, int sendDateMonth, int sendDateDay,
			int sendDateYear) 
		throws PortalException, SystemException {

		Date sendDate = PortalUtil.getDate(
			sendDateMonth, sendDateDay,sendDateYear);

		CampaignContent campaignContent = 
			campaignContentLocalService.getCampaignContent(campaignContentId);

		long campaignId = counterLocalService.increment();

		Campaign campaign = campaignPersistence.create(campaignId);

		campaign.setSendDate(sendDate);
		campaign.setCampaignContentId(campaignContentId);
		campaign.setSenderEmail(senderEmail);
		campaign.setSenderName(senderName);
		campaign.setEmailSubject(emailSubject);
		campaign.setSent(false);
		campaign.setContent(campaignContent.getContent());
		campaign.setCampaignId(campaignId);

		campaignPersistence.update(campaign, false);

		return campaign;
	}

	public void checkCampaigns() {
		try {
			Date currentDate = new Date();

			List<Campaign> campaigns = getCampaignsBySendDateLT(
				currentDate, false);

			for (Campaign campaign : campaigns) {
				sendCampaign(campaign);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	public void deleteCampaign(long campaignId)
		throws PortalException, SystemException {

		List<NewsletterLog> newsletterLogByCampaign =
			newsletterLogLocalService.getNewsletterLogByCampaign(campaignId);

		if (!newsletterLogByCampaign.isEmpty()) {
			for (NewsletterLog newsletterLog : newsletterLogByCampaign) {
				NewsletterLogLocalServiceUtil.deleteNewsletterLog(
					newsletterLog);
			}
		}

		super.deleteCampaign(campaignId);
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

		return campaignPersistence.findBySendDate(sendDate);
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
		throws SystemException, PortalException, AddressException,
		MessagingException{

		List<NewsletterLog> newsletterLogs = NewsletterLogLocalServiceUtil.
			getNewsletterLogByCampaign(campaign.getCampaignId());

		long campaignContentId = campaign.getCampaignContentId();

		CampaignContent campaignContent = CampaignContentLocalServiceUtil.
			getCampaignContent(campaignContentId);

		for (NewsletterLog newsletterLog : newsletterLogs) {
			long contactId = newsletterLog.getContactId();

			Contact contact = ContactLocalServiceUtil.getContact(contactId);

			_sendEmail(campaignContent, campaign, contact);
			newsletterLog.setSent(true);
			NewsletterLogLocalServiceUtil.updateNewsletterLog(newsletterLog);
			//Thread.sleep(5000);
		}
		campaign.setSent(true);
		CampaignLocalServiceUtil.updateCampaign(campaign);
	}

	private void _sendEmail(
			CampaignContent campaignContent, Campaign campaign, Contact contact)
		throws AddressException, MessagingException, SystemException {

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

		Properties props = new Properties();
		props.put(NewsletterConstants.MAIL_TRANSPORT_PROTOCOL, "smtp");
		props.put(NewsletterConstants.MAIL_SMTP_HOST, host);
		props.put(NewsletterConstants.MAIL_SMTP_SOCKETFACTORY_PORT, port);
		props.put(NewsletterConstants.MAIL_SMTP_PORT, port);
		props.put(
			NewsletterConstants.MAIL_SMTP_SOCKETFACTORY_FALLBACK, "false");
		props.put(NewsletterConstants.MAIL_SMTP_STARTTLS_ENABLE, "true");
		props.put(NewsletterConstants.MAIL_SMTP_AUTH, "true");

		MailAuthenticator mailAuthenticator = new MailAuthenticator(
			userString, passwordString);
		Session session = Session.getInstance(props, mailAuthenticator);

		String senderEmail = campaign.getSenderEmail();
		String emailSubject = campaign.getEmailSubject();
		String content = campaignContent.getContent();
		String senderName = campaign.getSenderName();
		String from = "\""+senderName+"\" <"+senderEmail+">";

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
				contact.getEmail()));
		msg.setSentDate(new Date());
		msg.setSubject(emailSubject);
		msg.setContent(content, "text/html");

		Transport.send(msg);
	}
	
	private static Log _log = LogFactoryUtil.getLog(
		CampaignLocalServiceImpl.class);

}