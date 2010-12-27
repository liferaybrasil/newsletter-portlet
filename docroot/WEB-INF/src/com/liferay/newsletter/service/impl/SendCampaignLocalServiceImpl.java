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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.newsletter.model.NewsletterLog;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.service.base.SendCampaignLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Bruno Pinheiro
 */
public class SendCampaignLocalServiceImpl
	extends SendCampaignLocalServiceBaseImpl {

	public List<NewsletterLog> getNewsletterLogs(SendCampaign sendCampaign)
		throws SystemException{

		return sendCampaignPersistence.getNewsletterLogs(
			sendCampaign.getSendCampaignId());
	}

	public SendCampaign addSendCampaign(SendCampaign sendCampaign) 
		throws SystemException{

		long sendCampaignId = CounterLocalServiceUtil.increment(
			SendCampaign.class.getName());

		sendCampaign.setSendCampaignId(sendCampaignId);

		return super.addSendCampaign(sendCampaign);
	}
	
	public List<SendCampaign> getSendCampaignsByDate(Date sendDate)
		throws SystemException{

		return sendCampaignPersistence.findBySendDate(sendDate);
	}

}