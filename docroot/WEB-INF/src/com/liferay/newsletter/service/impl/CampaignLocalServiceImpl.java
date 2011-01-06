/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.service.NewsletterLogLocalServiceUtil;
import com.liferay.newsletter.service.SendCampaignLocalServiceUtil;
import com.liferay.newsletter.service.base.CampaignLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Bruno Pinheiro
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {

	public Campaign addCampaign(Campaign campaign) throws SystemException{
		long campaignId = CounterLocalServiceUtil.increment(
			Campaign.class.getName());

		campaign.setCampaignId(campaignId);

		return super.addCampaign(campaign);
	}

	public List<SendCampaign> getSendCampaigns(Campaign campaign)
		throws SystemException{

		return campaignPersistence.getSendCampaigns(campaign.getCampaignId());
	}
	
	@Override
	public void deleteCampaign(long campaignId) throws SystemException,
		PortalException {
		
		List<SendCampaign> sendCampaignsByCampaign = 
			SendCampaignLocalServiceUtil.getSendCampaignsByCampaign(campaignId);

		if(!sendCampaignsByCampaign.isEmpty()){
			for (SendCampaign sendCampaign : sendCampaignsByCampaign) {
				List<NewsletterLog> newsletterLogBySendCampaign = 
					NewsletterLogLocalServiceUtil.
						getNewsletterLogBySendCampaign(
								sendCampaign.getSendCampaignId());
				
				for (NewsletterLog newsletterLog : newsletterLogBySendCampaign){
					NewsletterLogLocalServiceUtil.deleteNewsletterLog(
						newsletterLog);
				}
				SendCampaignLocalServiceUtil.deleteSendCampaign(sendCampaign);				
			}
		}
		
		super.deleteCampaign(campaignId);
	}
	
}