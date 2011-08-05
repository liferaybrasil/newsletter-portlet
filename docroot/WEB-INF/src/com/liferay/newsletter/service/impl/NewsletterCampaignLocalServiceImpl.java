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

import com.liferay.newsletter.NameException;
import com.liferay.newsletter.model.NewsletterCampaign;
import com.liferay.newsletter.model.NewsletterContact;
import com.liferay.newsletter.model.NewsletterContent;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.base.NewsletterCampaignLocalServiceBaseImpl;
import com.liferay.newsletter.util.MailAuthenticator;
import com.liferay.newsletter.util.NewsletterConstants;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

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
public class NewsletterCampaignLocalServiceImpl
	extends NewsletterCampaignLocalServiceBaseImpl {

	public NewsletterCampaign addCampaign(
			long userId, long groupId, long contentId, String emailSubject,
			String senderEmail, String senderName, int sendDateDay,
			int sendDateMonth, int sendDateYear, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(senderEmail, senderName);

		Date sendDate = PortalUtil.getDate(
			sendDateMonth, sendDateDay, sendDateYear);

		long campaignId = counterLocalService.increment();

		NewsletterCampaign campaign = newsletterCampaignPersistence.create(
			campaignId);

		campaign.setUuid(serviceContext.getUuid());
		campaign.setGroupId(groupId);
		campaign.setCompanyId(user.getCompanyId());
		campaign.setUserId(user.getUserId());
		campaign.setUserName(user.getFullName());
		campaign.setCreateDate(serviceContext.getCreateDate(now));
		campaign.setModifiedDate(serviceContext.getModifiedDate(now));
		campaign.setContentId(contentId);
		campaign.setEmailSubject(emailSubject);
		campaign.setSenderEmail(senderEmail);
		campaign.setSenderName(senderName);
		campaign.setSent(false);
		campaign.setSendDate(sendDate);

		return newsletterCampaignPersistence.update(campaign, false);
	}

	public void checkCampaigns() throws PortalException, SystemException {
		Date date = new Date();

		List<NewsletterCampaign> campaigns = getCampaignsBySentDate(
			date, false);

		for (NewsletterCampaign campaign : campaigns) {
			sendCampaign(campaign);
		}
	}

	public void deleteCampaign(NewsletterCampaign campaign)
		throws PortalException, SystemException {

		List<NewsletterLog> logs = campaign.getLogs();

		for (NewsletterLog log : logs) {
			newsletterLogLocalService.deleteLog(log);
		}

		newsletterCampaignPersistence.remove(campaign);
	}

	public void deleteCampaign(long campaignId)
		throws PortalException, SystemException {

		NewsletterCampaign campaign = getCampaign(campaignId);

		deleteCampaign(campaign);
	}

	public NewsletterCampaign getCampaign(long campaignId)
		throws PortalException, SystemException {

		return newsletterCampaignPersistence.findByPrimaryKey(campaignId);
	}

	public List<NewsletterCampaign> getCampaigns(long contentId)
		throws SystemException{

		return newsletterCampaignPersistence.findByContentId(contentId);
	}

	// TODO: MUDAR DE senT pra senD
	public List<NewsletterCampaign> getCampaignsBySentDate(
			Date sentDateLT, boolean sent)
		throws SystemException{

		return newsletterCampaignPersistence.findBySD_S(sentDateLT, sent);
	}
	
	public int getCampaignsCount(long contentId) throws SystemException {
		return newsletterCampaignPersistence.countByContentId(contentId);
	}

	public void sendCampaign(long campaignId)
		throws PortalException, SystemException {

		NewsletterCampaign campaign = getCampaign(campaignId);

		sendCampaign(campaign);
	}

	public void sendCampaign(NewsletterCampaign campaign)
		throws PortalException, SystemException {

		List<NewsletterLog> logs =
			newsletterLogLocalService.getLogsByCampaignId(
				campaign.getCampaignId());

		for (NewsletterLog log : logs) {
			sendEmail(log.getContactId(), campaign);

			log.setSent(true);

			newsletterLogLocalService.updateNewsletterLog(log);
		}

		campaign.setSent(true);

		newsletterCampaignLocalService.updateNewsletterCampaign(campaign);
	}

	protected void sendEmail(
			long contactId, NewsletterCampaign campaign)
		throws PortalException, SystemException {

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

		NewsletterContent content = campaign.getContent();

		String senderName = campaign.getSenderName();
		// TODO: ver padrao pra concatenar, 
		// StringBundler sb
		// usar StringPool
		String from = "\"" + senderName + "\" <" + senderEmail + ">";

		NewsletterContact contact = newsletterContactLocalService.getContact(
			contactId);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipient(
				Message.RecipientType.TO,
				new InternetAddress(contact.getEmail()));
			message.setSentDate(new Date());
			message.setSubject(emailSubject);
			message.setContent(content.getContent(), "text/html");

			Transport.send(message);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	protected void validate(String senderEmail, String senderName)
		throws PortalException {

		if (!Validator.isEmailAddress(senderEmail)) {
			throw new EmailAddressException();
		}
		else if (Validator.isNull(senderName)) {
			throw new NameException();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		NewsletterCampaignLocalServiceImpl.class);

}