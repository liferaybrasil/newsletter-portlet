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

import com.liferay.newsletter.service.CampaignLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Bruno Pinheiro
 */
public class CampaignClp extends BaseModelImpl<Campaign> implements Campaign {
	public CampaignClp() {
	}

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCampaignId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public String getUuid() {
		return _uuid;
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

	public Date getSendDate() {
		return _sendDate;
	}

	public void setSendDate(Date sendDate) {
		_sendDate = sendDate;
	}

	public String getEmailSubject() {
		return _emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		_emailSubject = emailSubject;
	}

	public String getSenderName() {
		return _senderName;
	}

	public void setSenderName(String senderName) {
		_senderName = senderName;
	}

	public String getSenderEmail() {
		return _senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
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

	public long getCampaignContentId() {
		return _campaignContentId;
	}

	public void setCampaignContentId(long campaignContentId) {
		_campaignContentId = campaignContentId;
	}

	public void persist() throws SystemException {
		CampaignLocalServiceUtil.updateCampaign(this);
	}

	@Override
	public Campaign toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Campaign)Proxy.newProxyInstance(Campaign.class.getClassLoader(),
				new Class[] { Campaign.class }, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		CampaignClp clone = new CampaignClp();

		clone.setUuid(getUuid());
		clone.setCampaignId(getCampaignId());
		clone.setSendDate(getSendDate());
		clone.setEmailSubject(getEmailSubject());
		clone.setSenderName(getSenderName());
		clone.setSenderEmail(getSenderEmail());
		clone.setContent(getContent());
		clone.setSent(getSent());
		clone.setCampaignContentId(getCampaignContentId());

		return clone;
	}

	public int compareTo(Campaign campaign) {
		int value = 0;

		value = DateUtil.compareTo(getSendDate(), campaign.getSendDate());

		value = value * -1;

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

		CampaignClp campaign = null;

		try {
			campaign = (CampaignClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = campaign.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", sendDate=");
		sb.append(getSendDate());
		sb.append(", emailSubject=");
		sb.append(getEmailSubject());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", sent=");
		sb.append(getSent());
		sb.append(", campaignContentId=");
		sb.append(getCampaignContentId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

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
			"<column><column-name>sendDate</column-name><column-value><![CDATA[");
		sb.append(getSendDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailSubject</column-name><column-value><![CDATA[");
		sb.append(getEmailSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderName</column-name><column-value><![CDATA[");
		sb.append(getSenderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sent</column-name><column-value><![CDATA[");
		sb.append(getSent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignContentId</column-name><column-value><![CDATA[");
		sb.append(getCampaignContentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _campaignId;
	private Date _sendDate;
	private String _emailSubject;
	private String _senderName;
	private String _senderEmail;
	private String _content;
	private boolean _sent;
	private long _campaignContentId;
}