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

import java.util.Date;

/**
 * @author Bruno Pinheiro
 */
public class CampaignContentClp extends BaseModelImpl<CampaignContent>
	implements CampaignContent {
	public CampaignContentClp() {
	}

	public Class<?> getModelClass() {
		return CampaignContent.class;
	}

	public String getModelClassName() {
		return CampaignContent.class.getName();
	}

	public long getPrimaryKey() {
		return _campaignContentId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignContentId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignContentId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCampaignContentId() {
		return _campaignContentId;
	}

	public void setCampaignContentId(long campaignContentId) {
		_campaignContentId = campaignContentId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public CampaignContent toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (CampaignContent)Proxy.newProxyInstance(CampaignContent.class.getClassLoader(),
				new Class[] { CampaignContent.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		CampaignContentClp clone = new CampaignContentClp();

		clone.setUuid(getUuid());
		clone.setCampaignContentId(getCampaignContentId());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	public int compareTo(CampaignContent campaignContent) {
		long pk = campaignContent.getPrimaryKey();

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

		CampaignContentClp campaignContent = null;

		try {
			campaignContent = (CampaignContentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = campaignContent.getPrimaryKey();

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
		sb.append(", campaignContentId=");
		sb.append(getCampaignContentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

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

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _campaignContentId;
	private String _title;
	private String _content;
	private Date _createDate;
}