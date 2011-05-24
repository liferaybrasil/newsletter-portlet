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

package com.liferay.newsletter.service.http;

import com.liferay.newsletter.model.Contact;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

/**
 * @author    Bruno Pinheiro
 * @generated
 */
public class ContactJSONSerializer {
	public static JSONObject toJSONObject(Contact model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("contactId", model.getContactId());
		jsonObject.put("email", model.getEmail());
		jsonObject.put("name", model.getName());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.newsletter.model.Contact[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.newsletter.model.Contact[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.newsletter.model.Contact> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Contact model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}