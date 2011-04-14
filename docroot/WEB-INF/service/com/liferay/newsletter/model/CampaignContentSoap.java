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
public class CampaignContentSoap implements Serializable {
	public static CampaignContentSoap toSoapModel(CampaignContent model) {
		CampaignContentSoap soapModel = new CampaignContentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCampaignContentId(model.getCampaignContentId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static CampaignContentSoap[] toSoapModels(CampaignContent[] models) {
		CampaignContentSoap[] soapModels = new CampaignContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignContentSoap[][] toSoapModels(
		CampaignContent[][] models) {
		CampaignContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignContentSoap[] toSoapModels(
		List<CampaignContent> models) {
		List<CampaignContentSoap> soapModels = new ArrayList<CampaignContentSoap>(models.size());

		for (CampaignContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignContentSoap[soapModels.size()]);
	}

	public CampaignContentSoap() {
	}

	public long getPrimaryKey() {
		return _campaignContentId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignContentId(pk);
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

	private String _uuid;
	private long _campaignContentId;
	private String _title;
	private String _content;
	private Date _createDate;
}