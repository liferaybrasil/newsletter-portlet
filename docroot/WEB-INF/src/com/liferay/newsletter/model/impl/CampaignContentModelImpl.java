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

import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.CampaignContentModel;
import com.liferay.newsletter.model.CampaignContentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the CampaignContent service. Represents a row in the &quot;Newsletter_CampaignContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.newsletter.model.CampaignContentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignContentImpl}.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignContentImpl
 * @see com.liferay.newsletter.model.CampaignContent
 * @see com.liferay.newsletter.model.CampaignContentModel
 * @generated
 */
@JSON(strict = true)
public class CampaignContentModelImpl extends BaseModelImpl<CampaignContent>
	implements CampaignContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign content model instance should use the {@link com.liferay.newsletter.model.CampaignContent} interface instead.
	 */
	public static final String TABLE_NAME = "Newsletter_CampaignContent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "campaignContentId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "articleId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Newsletter_CampaignContent (uuid_ VARCHAR(75) null,campaignContentId LONG not null primary key,title VARCHAR(75) null,content STRING null,createDate DATE null,articleId LONG)";
	public static final String TABLE_SQL_DROP = "drop table Newsletter_CampaignContent";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.newsletter.model.CampaignContent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.newsletter.model.CampaignContent"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CampaignContent toModel(CampaignContentSoap soapModel) {
		CampaignContent model = new CampaignContentImpl();

		model.setUuid(soapModel.getUuid());
		model.setCampaignContentId(soapModel.getCampaignContentId());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());
		model.setCreateDate(soapModel.getCreateDate());
		model.setArticleId(soapModel.getArticleId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CampaignContent> toModels(
		CampaignContentSoap[] soapModels) {
		List<CampaignContent> models = new ArrayList<CampaignContent>(soapModels.length);

		for (CampaignContentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return CampaignContent.class;
	}

	public String getModelClassName() {
		return CampaignContent.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.newsletter.model.CampaignContent"));

	public CampaignContentModelImpl() {
	}

	public long getPrimaryKey() {
		return _campaignContentId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCampaignContentId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignContentId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
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

	@JSON
	public long getCampaignContentId() {
		return _campaignContentId;
	}

	public void setCampaignContentId(long campaignContentId) {
		_campaignContentId = campaignContentId;
	}

	@JSON
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

	@JSON
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

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public long getArticleId() {
		return _articleId;
	}

	public void setArticleId(long articleId) {
		_articleId = articleId;
	}

	public CampaignContent toEscapedModel() {
		if (isEscapedModel()) {
			return (CampaignContent)this;
		}
		else {
			return (CampaignContent)Proxy.newProxyInstance(CampaignContent.class.getClassLoader(),
				new Class[] { CampaignContent.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					CampaignContent.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		CampaignContentImpl campaignContentImpl = new CampaignContentImpl();

		campaignContentImpl.setUuid(getUuid());
		campaignContentImpl.setCampaignContentId(getCampaignContentId());
		campaignContentImpl.setTitle(getTitle());
		campaignContentImpl.setContent(getContent());
		campaignContentImpl.setCreateDate(getCreateDate());
		campaignContentImpl.setArticleId(getArticleId());

		campaignContentImpl.resetOriginalValues();

		return campaignContentImpl;
	}

	public int compareTo(CampaignContent campaignContent) {
		long primaryKey = campaignContent.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
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

		CampaignContent campaignContent = null;

		try {
			campaignContent = (CampaignContent)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = campaignContent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", campaignContentId=");
		sb.append(getCampaignContentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.CampaignContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignContentId</column-name><column-value><![CDATA[");
		sb.append(getCampaignContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _campaignContentId;
	private String _title;
	private String _content;
	private Date _createDate;
	private long _articleId;
	private transient ExpandoBridge _expandoBridge;
}