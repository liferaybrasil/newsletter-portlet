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

import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.NewsletterLogModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the NewsletterLog service. Represents a row in the &quot;Newsletter_NewsletterLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.newsletter.model.NewsletterLogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsletterLogImpl}.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see NewsletterLogImpl
 * @see com.liferay.newsletter.model.NewsletterLog
 * @see com.liferay.newsletter.model.NewsletterLogModel
 * @generated
 */
public class NewsletterLogModelImpl extends BaseModelImpl<NewsletterLog>
	implements NewsletterLogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a newsletter log model instance should use the {@link com.liferay.newsletter.model.NewsletterLog} interface instead.
	 */
	public static final String TABLE_NAME = "Newsletter_NewsletterLog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "newsletterLogId", Types.BIGINT },
			{ "sendCampaignId", Types.BIGINT },
			{ "contactId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Newsletter_NewsletterLog (uuid_ VARCHAR(75) null,newsletterLogId LONG not null primary key,sendCampaignId LONG,contactId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Newsletter_NewsletterLog";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.newsletter.model.NewsletterLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.newsletter.model.NewsletterLog"),
			true);

	public Class<?> getModelClass() {
		return NewsletterLog.class;
	}

	public String getModelClassName() {
		return NewsletterLog.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.newsletter.model.NewsletterLog"));

	public NewsletterLogModelImpl() {
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
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
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

	public long getSendCampaignId() {
		return _sendCampaignId;
	}

	public void setSendCampaignId(long sendCampaignId) {
		_sendCampaignId = sendCampaignId;
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public NewsletterLog toEscapedModel() {
		if (isEscapedModel()) {
			return (NewsletterLog)this;
		}
		else {
			return (NewsletterLog)Proxy.newProxyInstance(NewsletterLog.class.getClassLoader(),
				new Class[] { NewsletterLog.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					NewsletterLog.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		NewsletterLogImpl newsletterLogImpl = new NewsletterLogImpl();

		newsletterLogImpl.setUuid(getUuid());
		newsletterLogImpl.setNewsletterLogId(getNewsletterLogId());
		newsletterLogImpl.setSendCampaignId(getSendCampaignId());
		newsletterLogImpl.setContactId(getContactId());

		newsletterLogImpl.resetOriginalValues();

		return newsletterLogImpl;
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

		NewsletterLog newsletterLog = null;

		try {
			newsletterLog = (NewsletterLog)obj;
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

	public void resetOriginalValues() {
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", newsletterLogId=");
		sb.append(getNewsletterLogId());
		sb.append(", sendCampaignId=");
		sb.append(getSendCampaignId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

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
			"<column><column-name>sendCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSendCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _newsletterLogId;
	private long _sendCampaignId;
	private long _contactId;
	private transient ExpandoBridge _expandoBridge;
}