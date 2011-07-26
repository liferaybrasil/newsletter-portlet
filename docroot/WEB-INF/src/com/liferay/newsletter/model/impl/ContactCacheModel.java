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

import com.liferay.newsletter.model.Contact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

/**
 * The cache model class for representing Contact in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contact
 * @generated
 */
public class ContactCacheModel implements CacheModel<Contact> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public Contact toEntityModel() {
		ContactImpl contactImpl = new ContactImpl();

		if (uuid == null) {
			contactImpl.setUuid(StringPool.BLANK);
		}
		else {
			contactImpl.setUuid(uuid);
		}

		contactImpl.setContactId(contactId);

		if (email == null) {
			contactImpl.setEmail(StringPool.BLANK);
		}
		else {
			contactImpl.setEmail(email);
		}

		if (name == null) {
			contactImpl.setName(StringPool.BLANK);
		}
		else {
			contactImpl.setName(name);
		}

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	public String uuid;
	public long contactId;
	public String email;
	public String name;
}