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

package com.liferay.newsletter.service.impl;

import com.liferay.newsletter.ContentException;
import com.liferay.newsletter.TitleException;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * @author Bruno Pinheiro
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContent addCampaignContent(
			long articleId, String title, String content,
			ServiceContext serviceContext)
		throws SystemException, PortalException {

		validate(title, content);

		long campaignContentId = counterLocalService.increment();

		CampaignContent campaignContent =
			campaignContentPersistence.create(campaignContentId);

		campaignContent.setUuid(serviceContext.getUuid());
		campaignContent.setTitle(title);
		campaignContent.setContent(content);

		return campaignContentPersistence.update(campaignContent, false);
	}

	public void deleteCampaignContent(CampaignContent campaignContent)
		throws PortalException, SystemException {

		// Campaign Content

		campaignContentPersistence.remove(campaignContent);

		// Campaigns

		List<Campaign> campaigns =
			campaignLocalService.getCampaignsByCampaignContent(
				campaignContent.getCampaignContentId());

		for (Campaign campaign : campaigns) {
			campaignLocalService.deleteCampaign(campaign);
		}
	}

	public void deleteCampaignContent(long campaignContentId)
		throws SystemException,	PortalException {

		CampaignContent campaignContent =
			campaignContentPersistence.findByPrimaryKey(campaignContentId);

		deleteCampaignContent(campaignContent);
	}

	public List<Campaign> getCampaigns(long campaignContentId)
		throws SystemException{

		return campaignContentPersistence.getCampaigns(campaignContentId);
	}

	public List<CampaignContent> getCampaignsContentByTitle(
		String title, int start, int end) throws SystemException{

		return campaignContentFinder.findByTitle(title, start, end);
	}

	public void validate(String title, String content) throws PortalException {
		if (Validator.isNull(title)) {
			throw new TitleException();
		}
		else if (Validator.isNull(content)) {
			throw new ContentException();
		}
	}

}