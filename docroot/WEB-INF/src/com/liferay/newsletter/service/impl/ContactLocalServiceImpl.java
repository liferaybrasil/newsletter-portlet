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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.NoSuchContactException;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.base.ContactLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * @author Bruno Pinheiro
 */
public class ContactLocalServiceImpl extends ContactLocalServiceBaseImpl {

	public Contact addContact(Contact contact) throws SystemException{
		long contactId = CounterLocalServiceUtil.increment(
			Contact.class.getName());

		contact.setContactId(contactId);

		return super.addContact(contact);
	}

	public List<NewsletterLog> getNewsletterLogs(Contact contact)
		throws SystemException{

		return contactPersistence.getNewsletterLogs(contact.getContactId());
	}

	public Contact getContactByEmail(String contactEmail)
		throws SystemException{

		Contact contact;

		try {
			contact = contactPersistence.findByEmail(contactEmail);
		}
		catch (NoSuchContactException e) {
			contact = null;
		}

		return contact;
	}

}