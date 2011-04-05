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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Bruno Pinheiro
 */
public class SendCampaignClp extends BaseModelImpl<SendCampaign>
	implements SendCampaign {
	public SendCampaignClp() {
	}

	public Class<?> getModelClass() {
		return SendCampaign.class;
	}

	public String getModelClassName() {
		return SendCampaign.class.getName();
	}

	public long getPrimaryKey() {
		return _sendCampaignId;
	}

	public void setPrimaryKey(long pk) {
		setSendCampaignId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_sendCampaignId);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSendCampaignId() {
		return _sendCampaignId;
	}

	public void setSendCampaignId(long sendCampaignId) {
		_sendCampaignId = sendCampaignId;
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

	public boolean getSent() {
		return _sent;
	}

	public boolean isSent() {
		return _sent;
	}

	public void setSent(boolean sent) {
		_sent = sent;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public SendCampaign toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (SendCampaign)Proxy.newProxyInstance(SendCampaign.class.getClassLoader(),
				new Class[] { SendCampaign.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		SendCampaignClp clone = new SendCampaignClp();

		clone.setUuid(getUuid());
		clone.setSendCampaignId(getSendCampaignId());
		clone.setSendDate(getSendDate());
		clone.setEmailSubject(getEmailSubject());
		clone.setSenderName(getSenderName());
		clone.setSenderEmail(getSenderEmail());
		clone.setSent(getSent());
		clone.setCampaignId(getCampaignId());

		return clone;
	}

	public int compareTo(SendCampaign sendCampaign) {
		int value = 0;

		value = DateUtil.compareTo(getSendDate(), sendCampaign.getSendDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SendCampaignClp sendCampaign = null;

		try {
			sendCampaign = (SendCampaignClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = sendCampaign.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", sendCampaignId=");
		sb.append(getSendCampaignId());
		sb.append(", sendDate=");
		sb.append(getSendDate());
		sb.append(", emailSubject=");
		sb.append(getEmailSubject());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", sent=");
		sb.append(getSent());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.SendCampaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendCampaignId</column-name><column-value><![CDATA[");
		sb.append(getSendCampaignId());
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
			"<column><column-name>sent</column-name><column-value><![CDATA[");
		sb.append(getSent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _sendCampaignId;
	private Date _sendDate;
	private String _emailSubject;
	private String _senderName;
	private String _senderEmail;
	private boolean _sent;
	private long _campaignId;
}