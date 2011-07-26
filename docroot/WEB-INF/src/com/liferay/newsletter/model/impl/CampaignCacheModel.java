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

import com.liferay.newsletter.model.Campaign;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.util.Date;

/**
 * The cache model class for representing Campaign in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @generated
 */
public class CampaignCacheModel implements CacheModel<Campaign> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append(", emailSubject=");
		sb.append(emailSubject);
		sb.append(", senderEmail=");
		sb.append(senderEmail);
		sb.append(", senderName=");
		sb.append(senderName);
		sb.append(", content=");
		sb.append(content);
		sb.append(", sent=");
		sb.append(sent);
		sb.append(", campaignContentId=");
		sb.append(campaignContentId);
		sb.append("}");

		return sb.toString();
	}

	public Campaign toEntityModel() {
		CampaignImpl campaignImpl = new CampaignImpl();

		if (uuid == null) {
			campaignImpl.setUuid(StringPool.BLANK);
		}
		else {
			campaignImpl.setUuid(uuid);
		}

		campaignImpl.setCampaignId(campaignId);

		if (sentDate == Long.MIN_VALUE) {
			campaignImpl.setSentDate(null);
		}
		else {
			campaignImpl.setSentDate(new Date(sentDate));
		}

		if (emailSubject == null) {
			campaignImpl.setEmailSubject(StringPool.BLANK);
		}
		else {
			campaignImpl.setEmailSubject(emailSubject);
		}

		if (senderEmail == null) {
			campaignImpl.setSenderEmail(StringPool.BLANK);
		}
		else {
			campaignImpl.setSenderEmail(senderEmail);
		}

		if (senderName == null) {
			campaignImpl.setSenderName(StringPool.BLANK);
		}
		else {
			campaignImpl.setSenderName(senderName);
		}

		if (content == null) {
			campaignImpl.setContent(StringPool.BLANK);
		}
		else {
			campaignImpl.setContent(content);
		}

		campaignImpl.setSent(sent);
		campaignImpl.setCampaignContentId(campaignContentId);

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	public String uuid;
	public long campaignId;
	public long sentDate;
	public String emailSubject;
	public String senderEmail;
	public String senderName;
	public String content;
	public boolean sent;
	public long campaignContentId;
}