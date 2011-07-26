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
 * This class is a wrapper for {@link CampaignContentService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignContentService
 * @generated
 */
public class CampaignContentServiceWrapper implements CampaignContentService {
	public CampaignContentServiceWrapper(
		CampaignContentService campaignContentService) {
		_campaignContentService = campaignContentService;
	}

	public CampaignContentService getWrappedCampaignContentService() {
		return _campaignContentService;
	}

	public void setWrappedCampaignContentService(
		CampaignContentService campaignContentService) {
		_campaignContentService = campaignContentService;
	}

	private CampaignContentService _campaignContentService;
}