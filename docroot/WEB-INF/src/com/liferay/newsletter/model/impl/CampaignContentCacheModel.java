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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.util.Date;

/**
 * The cache model class for representing CampaignContent in entity cache.
 *
 * @author Bruno Pinheiro
 * @see CampaignContent
 * @generated
 */
public class CampaignContentCacheModel implements CacheModel<CampaignContent> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", campaignContentId=");
		sb.append(campaignContentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append("}");

		return sb.toString();
	}

	public CampaignContent toEntityModel() {
		CampaignContentImpl campaignContentImpl = new CampaignContentImpl();

		if (uuid == null) {
			campaignContentImpl.setUuid(StringPool.BLANK);
		}
		else {
			campaignContentImpl.setUuid(uuid);
		}

		campaignContentImpl.setCampaignContentId(campaignContentId);

		if (title == null) {
			campaignContentImpl.setTitle(StringPool.BLANK);
		}
		else {
			campaignContentImpl.setTitle(title);
		}

		if (content == null) {
			campaignContentImpl.setContent(StringPool.BLANK);
		}
		else {
			campaignContentImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			campaignContentImpl.setCreateDate(null);
		}
		else {
			campaignContentImpl.setCreateDate(new Date(createDate));
		}

		campaignContentImpl.setArticleId(articleId);

		campaignContentImpl.resetOriginalValues();

		return campaignContentImpl;
	}

	public String uuid;
	public long campaignContentId;
	public String title;
	public String content;
	public long createDate;
	public long articleId;
}