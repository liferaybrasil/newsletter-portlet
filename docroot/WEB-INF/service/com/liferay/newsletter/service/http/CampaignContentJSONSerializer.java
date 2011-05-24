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

import com.liferay.newsletter.model.CampaignContent;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;

/**
 * @author    Bruno Pinheiro
 * @generated
 */
public class CampaignContentJSONSerializer {
	public static JSONObject toJSONObject(CampaignContent model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("uuid", model.getUuid());
		jsonObject.put("campaignContentId", model.getCampaignContentId());
		jsonObject.put("title", model.getTitle());
		jsonObject.put("content", model.getContent());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObject.put("createDate", createDateJSON);
		jsonObject.put("articleId", model.getArticleId());

		return jsonObject;
	}

	public static JSONArray toJSONArray(
		com.liferay.newsletter.model.CampaignContent[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (CampaignContent model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.newsletter.model.CampaignContent[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (CampaignContent[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.newsletter.model.CampaignContent> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (CampaignContent model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}