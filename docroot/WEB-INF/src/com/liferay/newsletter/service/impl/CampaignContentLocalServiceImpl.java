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

import com.liferay.newsletter.exception.ContentException;
import com.liferay.newsletter.exception.IdNotFoundException;
import com.liferay.newsletter.exception.TitleException;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

/**
 * @author Bruno Pinheiro
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContent addCampaignContent(CampaignContent campaignContent)
		throws SystemException, PortalException{

		validate(campaignContent.getTitle(), campaignContent.getContent());

		long campaignContentId = counterLocalService.increment();

		campaignContent.setCampaignContentId(campaignContentId);

		return campaignContentPersistence.update(campaignContent, false);
	}

	@Override
	public void deleteCampaignContent(long campaignContentId)
		throws SystemException,	PortalException {

		if (Validator.isNotNull(campaignContentId)) {
			List<Campaign> campaignsByCampaignContent =
				campaignLocalService.getCampaignsByCampaignContent(
					campaignContentId);

			if (!campaignsByCampaignContent.isEmpty()) {
				for (Campaign campaign : campaignsByCampaignContent) {
					List<NewsletterLog> newsletterLogList =
						newsletterLogLocalService.getNewsletterLogByCampaign(
							campaign.getCampaignId());

					for (NewsletterLog newsletterLog : newsletterLogList) {
						newsletterLogLocalService.deleteNewsletterLog(
							newsletterLog);
					}
					campaignLocalService.deleteCampaign(campaign);
				}
			}

			campaignContentPersistence.remove(campaignContentId);
			}
		else {
			throw new IdNotFoundException();
		}
	}

	public List<Campaign> getCampaigns(CampaignContent campaignContent)
		throws SystemException{

		return campaignContentPersistence.getCampaigns(
					campaignContent.getCampaignContentId());
	}

	public List<CampaignContent> getCampaignsContentByTitle(
			String title, int start, int end)
		throws SystemException{

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