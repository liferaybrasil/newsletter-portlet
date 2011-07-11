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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Bruno Pinheiro
 */
public class ContactFinderUtil {
	public static int countByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByCampaign(campaignId);
	}

	public static int countByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByCampaignContent(campaignContentId);
	}

	public static java.util.List<com.liferay.newsletter.model.Contact> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByEmail(email, start, end);
	}

	public static java.util.List<com.liferay.newsletter.model.Contact> findByNameAndCampaign(
		java.lang.String contactName, long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByNameAndCampaign(contactName, campaignId, start, end);
	}

	public static ContactFinder getFinder() {
		if (_finder == null) {
			_finder = (ContactFinder)PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.getServletContextName(),
					ContactFinder.class.getName());

			ReferenceRegistry.registerReference(ContactFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ContactFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ContactFinderUtil.class, "_finder");
	}

	private static ContactFinder _finder;
}