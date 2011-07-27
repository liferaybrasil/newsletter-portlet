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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class NewsletterContactSoap implements Serializable {
	public static NewsletterContactSoap toSoapModel(NewsletterContact model) {
		NewsletterContactSoap soapModel = new NewsletterContactSoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setEmail(model.getEmail());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static NewsletterContactSoap[] toSoapModels(
		NewsletterContact[] models) {
		NewsletterContactSoap[] soapModels = new NewsletterContactSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterContactSoap[][] toSoapModels(
		NewsletterContact[][] models) {
		NewsletterContactSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsletterContactSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterContactSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterContactSoap[] toSoapModels(
		List<NewsletterContact> models) {
		List<NewsletterContactSoap> soapModels = new ArrayList<NewsletterContactSoap>(models.size());

		for (NewsletterContact model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterContactSoap[soapModels.size()]);
	}

	public NewsletterContactSoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _contactId;
	private String _email;
	private String _name;
}