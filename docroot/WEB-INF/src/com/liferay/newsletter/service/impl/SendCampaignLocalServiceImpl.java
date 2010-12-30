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

package com.liferay.newsletter.service.impl;

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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.SendCampaignLocalServiceUtil;
import com.liferay.newsletter.service.base.SendCampaignLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.util.portlet.PortletProps;

/**
 * @author Bruno Pinheiro
 */
public class SendCampaignLocalServiceImpl
	extends SendCampaignLocalServiceBaseImpl {

	public List<NewsletterLog> getNewsletterLogs(SendCampaign sendCampaign)
		throws SystemException{

		return sendCampaignPersistence.getNewsletterLogs(
			sendCampaign.getSendCampaignId());
	}

	public SendCampaign addSendCampaign(SendCampaign sendCampaign) 
		throws SystemException{

		long sendCampaignId = CounterLocalServiceUtil.increment(
			SendCampaign.class.getName());

		sendCampaign.setSendCampaignId(sendCampaignId);

		return super.addSendCampaign(sendCampaign);
	}
	
	public List<SendCampaign> getSendCampaignsByDate(Date sendDate)
		throws SystemException{

		return sendCampaignPersistence.findBySendDate(sendDate);
	}
	
	public List<SendCampaign> getSendCampaignsBySendDateLT(
		Date sendDate, boolean sent) throws SystemException{

	return sendCampaignPersistence.findBySD_LT(sendDate, sent);
}

	public void job(){
		try {
			Date currentDate = new Date();
			List<SendCampaign> sendCampaigns = getSendCampaignsBySendDateLT(
				currentDate, false);
			
			for (SendCampaign sendCampaign : sendCampaigns) {
				List<NewsletterLog> newsletterLogs = 
					NewsletterLogLocalServiceUtil.
						getNewsletterLogBySendCampaign(
							sendCampaign.getSendCampaignId());

				long campaignId = sendCampaign.getCampaignId();

				Campaign campaign = CampaignLocalServiceUtil.getCampaign(
					campaignId);
				
				for (NewsletterLog newsletterLog : newsletterLogs) {
					long contactId = newsletterLog.getContactId();
					
					Contact contact = ContactLocalServiceUtil.getContact(
						contactId);
					
					_sendEmail(campaign, sendCampaign, contact);
				}
				sendCampaign.setSent(true);
				SendCampaignLocalServiceUtil.updateSendCampaign(sendCampaign);
			}
		} 
		catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void _sendEmail(
		Campaign campaign, SendCampaign sendCampaign, Contact contact) 
		throws AddressException, MessagingException {

		final String password = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD);
		final String user = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_POP3_USER);
		String host = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_POP3_HOST);
		String port = PortletProps.get(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PORT);

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

		String content = campaign.getContent();

		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(senderEmail));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
				contact.getEmail()));
		msg.setSentDate(new Date());
		msg.setSubject(emailSubject);
		msg.setText(content);

		Transport.send(msg);
	}
}