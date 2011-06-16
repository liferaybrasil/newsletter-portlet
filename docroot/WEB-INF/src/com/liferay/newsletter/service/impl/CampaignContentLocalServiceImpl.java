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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.base.CampaignContentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the campaign content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.newsletter.service.CampaignContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can
 * only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see com.liferay.newsletter.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.CampaignContentLocalServiceUtil
 */
public class CampaignContentLocalServiceImpl
	extends CampaignContentLocalServiceBaseImpl {

	public CampaignContent addCampaignContent(CampaignContent campaignContent)
		throws SystemException{

		long campaignContentId = CounterLocalServiceUtil.increment(
			CampaignContent.class.getName());

		campaignContent.setCampaignContentId(campaignContentId);

		return super.addCampaignContent(campaignContent);
	}

	@Override
	public CampaignContent updateCampaignContent(
			CampaignContent campaignContent)
		throws SystemException, PortalException {

		CampaignContent getCampaignContent = getCampaignContent(
				campaignContent.getCampaignContentId());
		campaignContent.setCreateDate(getCampaignContent.getCreateDate());
		CampaignContent updateCampaignContent = super.updateCampaignContent(
			campaignContent);
		return updateCampaignContent;
	}

	@Override
	public void deleteCampaignContent(long campaignContentId)
		throws SystemException,	PortalException {

		List<Campaign> campaignsByCampaignContent =
			CampaignLocalServiceUtil.getCampaignsByCampaignContent(
				campaignContentId);

		if (!campaignsByCampaignContent.isEmpty()) {
			for (Campaign campaign : campaignsByCampaignContent) {
				List<NewsletterLog> newsletterLogByCampaign =
					NewsletterLogLocalServiceUtil.
						getNewsletterLogByCampaign(
								campaign.getCampaignId());

				for (NewsletterLog newsletterLog : newsletterLogByCampaign) {
					NewsletterLogLocalServiceUtil.deleteNewsletterLog(
						newsletterLog);
				}
				CampaignLocalServiceUtil.deleteCampaign(campaign);
			}
		}

		super.deleteCampaignContent(campaignContentId);
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

}