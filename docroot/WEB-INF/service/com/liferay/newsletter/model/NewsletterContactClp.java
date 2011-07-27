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

package com.liferay.newsletter.model;

import com.liferay.newsletter.service.NewsletterContactLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Brian Wing Shun Chan
 */
public class NewsletterContactClp extends BaseModelImpl<NewsletterContact>
	implements NewsletterContact {
	public NewsletterContactClp() {
	}

	public Class<?> getModelClass() {
		return NewsletterContact.class;
	}

	public String getModelClassName() {
		return NewsletterContact.class.getName();
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public void persist() throws SystemException {
		NewsletterContactLocalServiceUtil.updateNewsletterContact(this);
	}

	@Override
	public NewsletterContact toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (NewsletterContact)Proxy.newProxyInstance(NewsletterContact.class.getClassLoader(),
				new Class[] { NewsletterContact.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		NewsletterContactClp clone = new NewsletterContactClp();

		clone.setContactId(getContactId());
		clone.setEmail(getEmail());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(NewsletterContact newsletterContact) {
		int value = 0;

		value = getEmail().compareTo(newsletterContact.getEmail());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NewsletterContactClp newsletterContact = null;

		try {
			newsletterContact = (NewsletterContactClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = newsletterContact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.NewsletterContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private String _email;
	private String _name;
}