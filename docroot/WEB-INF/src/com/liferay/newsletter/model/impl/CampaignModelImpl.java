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

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignModel;

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
 * The base model implementation for the Campaign service. Represents a row in the &quot;Newsletter_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.newsletter.model.CampaignModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignImpl}.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignImpl
 * @see com.liferay.newsletter.model.Campaign
 * @see com.liferay.newsletter.model.CampaignModel
 * @generated
 */
public class CampaignModelImpl extends BaseModelImpl<Campaign>
	implements CampaignModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign model instance should use the {@link com.liferay.newsletter.model.Campaign} interface instead.
	 */
	public static final String TABLE_NAME = "Newsletter_Campaign";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "campaignId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Newsletter_Campaign (uuid_ VARCHAR(75) null,campaignId LONG not null primary key,title VARCHAR(75) null,content STRING null)";
	public static final String TABLE_SQL_DROP = "drop table Newsletter_Campaign";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.newsletter.model.Campaign"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.newsletter.model.Campaign"),
			true);

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.newsletter.model.Campaign"));

	public CampaignModelImpl() {
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignId);
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

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_content = content;
	}

	public Campaign toEscapedModel() {
		if (isEscapedModel()) {
			return (Campaign)this;
		}
		else {
			return (Campaign)Proxy.newProxyInstance(Campaign.class.getClassLoader(),
				new Class[] { Campaign.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Campaign.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		CampaignImpl campaignImpl = new CampaignImpl();

		campaignImpl.setUuid(getUuid());
		campaignImpl.setCampaignId(getCampaignId());
		campaignImpl.setTitle(getTitle());
		campaignImpl.setContent(getContent());

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	public int compareTo(Campaign campaign) {
		long pk = campaign.getPrimaryKey();

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

		Campaign campaign = null;

		try {
			campaign = (Campaign)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = campaign.getPrimaryKey();

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
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.Campaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _campaignId;
	private String _title;
	private String _content;
	private transient ExpandoBridge _expandoBridge;
}