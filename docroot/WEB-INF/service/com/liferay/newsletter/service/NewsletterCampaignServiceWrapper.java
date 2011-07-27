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

package com.liferay.newsletter.service;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterCampaignService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewsletterCampaignService
 * @generated
 */
public class NewsletterCampaignServiceWrapper
	implements NewsletterCampaignService {
	public NewsletterCampaignServiceWrapper(
		NewsletterCampaignService newsletterCampaignService) {
		_newsletterCampaignService = newsletterCampaignService;
	}

	public NewsletterCampaignService getWrappedNewsletterCampaignService() {
		return _newsletterCampaignService;
	}

	public void setWrappedNewsletterCampaignService(
		NewsletterCampaignService newsletterCampaignService) {
		_newsletterCampaignService = newsletterCampaignService;
	}

	private NewsletterCampaignService _newsletterCampaignService;
}