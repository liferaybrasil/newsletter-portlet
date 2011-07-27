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

package com.liferay.newsletter.model.impl;

import com.liferay.newsletter.model.NewsletterContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

/**
 * The cache model class for representing NewsletterContact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterContact
 * @generated
 */
public class NewsletterContactCacheModel implements CacheModel<NewsletterContact> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public NewsletterContact toEntityModel() {
		NewsletterContactImpl newsletterContactImpl = new NewsletterContactImpl();

		newsletterContactImpl.setContactId(contactId);

		if (email == null) {
			newsletterContactImpl.setEmail(StringPool.BLANK);
		}
		else {
			newsletterContactImpl.setEmail(email);
		}

		if (name == null) {
			newsletterContactImpl.setName(StringPool.BLANK);
		}
		else {
			newsletterContactImpl.setName(name);
		}

		newsletterContactImpl.resetOriginalValues();

		return newsletterContactImpl;
	}

	public long contactId;
	public String email;
	public String name;
}