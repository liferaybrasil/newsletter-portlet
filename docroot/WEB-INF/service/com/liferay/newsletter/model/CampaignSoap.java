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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class CampaignSoap implements Serializable {
	public static CampaignSoap toSoapModel(Campaign model) {
		CampaignSoap soapModel = new CampaignSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setSendDate(model.getSendDate());
		soapModel.setEmailSubject(model.getEmailSubject());
		soapModel.setSenderName(model.getSenderName());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setContent(model.getContent());
		soapModel.setSent(model.getSent());
		soapModel.setCampaignContentId(model.getCampaignContentId());

		return soapModel;
	}

	public static CampaignSoap[] toSoapModels(Campaign[] models) {
		CampaignSoap[] soapModels = new CampaignSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignSoap[][] toSoapModels(Campaign[][] models) {
		CampaignSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignSoap[] toSoapModels(List<Campaign> models) {
		List<CampaignSoap> soapModels = new ArrayList<CampaignSoap>(models.size());

		for (Campaign model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignSoap[soapModels.size()]);
	}

	public CampaignSoap() {
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignId(pk);
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