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

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.ContactLocalServiceUtil;
import com.liferay.newsletter.service.base.NewsletterLogLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterLogLocalServiceImpl
	extends NewsletterLogLocalServiceBaseImpl {
	
	public List<NewsletterLog> getNewsletterLogBySendCampaign(
		long sendCampaignId) throws SystemException{

		return newsletterLogPersistence.findBySendCampaign(sendCampaignId);
	}
	
	public NewsletterLog addNewsletterLog(NewsletterLog newsletter) 
		throws SystemException{
		
		long newsletterLogId = CounterLocalServiceUtil.increment(
			NewsletterLog.class.getName());

		newsletter.setNewsletterLogId(newsletterLogId);

		return super.addNewsletterLog(newsletter);
	}

	public List<Contact> getContactsBySendCampaign(long sendCampaignId) 
		throws SystemException, PortalException{
			
		List<Contact> contacts = new ArrayList<Contact>();
		
		List<NewsletterLog> newsletterLogBySendCampaign =
			getNewsletterLogBySendCampaign(sendCampaignId);
		
		for (NewsletterLog newsletterLog : newsletterLogBySendCampaign) {
			long contactId = newsletterLog.getContactId();
			Contact contact = ContactLocalServiceUtil.getContact(contactId);
			contacts.add(contact);
		}
		
		return contacts;
		}

	public int getContactsBySendCampaignCount(long sendCampaignId)
			throws SystemException {
		return getNewsletterLogBySendCampaign(sendCampaignId).size();
	}
}