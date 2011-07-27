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

import com.liferay.newsletter.model.NewsletterContact;
import com.liferay.newsletter.service.base.NewsletterContactLocalServiceBaseImpl;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * @author Bruno Pinheiro
 * @author Marcellus Tavares
 */
public class NewsletterContactLocalServiceImpl
	extends NewsletterContactLocalServiceBaseImpl {

	public NewsletterContact addContact(
			String email, String name, ServiceContext serviceContext)
		throws SystemException, PortalException{

		validate(email);

		long contactId = counterLocalService.increment();

		NewsletterContact contact =
			newsletterContactPersistence.create(contactId);

		contact.setEmail(email);
		contact.setName(name);

		return newsletterContactPersistence.update(contact, false);
	}

	public NewsletterContact getContact(long contactId)
		throws PortalException, SystemException {

		return newsletterContactPersistence.findByPrimaryKey(contactId);
	}

	public NewsletterContact getContact(String email)
		throws PortalException, SystemException {

		return newsletterContactPersistence.findByEmail(email);
	}

	public List<NewsletterContact> search(
			String keywords, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return newsletterContactFinder.findByKeywords(
			keywords, start, end, orderByComparator);
	}

	protected void validate(String email) throws PortalException {
		if (Validator.isEmailAddress(email)) {
			throw new EmailAddressException();
		}
	}

}