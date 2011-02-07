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
 * @author    Bruno Pinheiro
 * @generated
 */
public class SendCampaignSoap implements Serializable {
	public static SendCampaignSoap toSoapModel(SendCampaign model) {
		SendCampaignSoap soapModel = new SendCampaignSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSendCampaignId(model.getSendCampaignId());
		soapModel.setSendDate(model.getSendDate());
		soapModel.setEmailSubject(model.getEmailSubject());
		soapModel.setSenderName(model.getSenderName());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setSent(model.getSent());
		soapModel.setCampaignId(model.getCampaignId());

		return soapModel;
	}

	public static SendCampaignSoap[] toSoapModels(SendCampaign[] models) {
		SendCampaignSoap[] soapModels = new SendCampaignSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SendCampaignSoap[][] toSoapModels(SendCampaign[][] models) {
		SendCampaignSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SendCampaignSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SendCampaignSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SendCampaignSoap[] toSoapModels(List<SendCampaign> models) {
		List<SendCampaignSoap> soapModels = new ArrayList<SendCampaignSoap>(models.size());

		for (SendCampaign model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SendCampaignSoap[soapModels.size()]);
	}

	public SendCampaignSoap() {
	}

	public long getPrimaryKey() {
		return _sendCampaignId;
	}

	public void setPrimaryKey(long pk) {
		setSendCampaignId(pk);
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

	private String _uuid;
	private long _sendCampaignId;
	private Date _sendDate;
	private String _emailSubject;
	private String _senderName;
	private String _senderEmail;
	private boolean _sent;
	private long _campaignId;
}