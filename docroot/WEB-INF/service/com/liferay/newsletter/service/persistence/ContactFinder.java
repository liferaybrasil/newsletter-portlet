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

package com.liferay.newsletter.service.persistence;

/**
 * @author Bruno Pinheiro
 */
public interface ContactFinder {
	public java.util.List<com.liferay.newsletter.model.Contact> findByNameAndCampaign(
		java.lang.String contactName, long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.newsletter.model.Contact> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;
}