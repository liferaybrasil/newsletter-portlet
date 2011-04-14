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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterLogClp extends BaseModelImpl<NewsletterLog>
	implements NewsletterLog {
	public NewsletterLogClp() {
	}

	public Class<?> getModelClass() {
		return NewsletterLog.class;
	}

	public String getModelClassName() {
		return NewsletterLog.class.getName();
	}

	public long getPrimaryKey() {
		return _newsletterLogId;
	}

	public void setPrimaryKey(long pk) {
		setNewsletterLogId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_newsletterLogId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNewsletterLogId() {
		return _newsletterLogId;
	}

	public void setNewsletterLogId(long newsletterLogId) {
		_newsletterLogId = newsletterLogId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public boolean getSent() {
		return _sent;
	}

	public boolean isSent() {
		return _sent;
	}

	public void setSent(boolean sent) {
		_sent = sent;
	}

	public NewsletterLog toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (NewsletterLog)Proxy.newProxyInstance(NewsletterLog.class.getClassLoader(),
				new Class[] { NewsletterLog.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		NewsletterLogClp clone = new NewsletterLogClp();

		clone.setUuid(getUuid());
		clone.setNewsletterLogId(getNewsletterLogId());
		clone.setCampaignId(getCampaignId());
		clone.setContactId(getContactId());
		clone.setSent(getSent());

		return clone;
	}

	public int compareTo(NewsletterLog newsletterLog) {
		long pk = newsletterLog.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NewsletterLogClp newsletterLog = null;

		try {
			newsletterLog = (NewsletterLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = newsletterLog.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", newsletterLogId=");
		sb.append(getNewsletterLogId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", sent=");
		sb.append(getSent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.NewsletterLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsletterLogId</column-name><column-value><![CDATA[");
		sb.append(getNewsletterLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sent</column-name><column-value><![CDATA[");
		sb.append(getSent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _newsletterLogId;
	private long _campaignId;
	private long _contactId;
	private boolean _sent;
}