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

package com.liferay.newsletter.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * @author Bruno Pinheiro
 */
public class CampaignPermission {

	public static void check(
			PermissionChecker permissionChecker, long groupId, long campaignId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, campaignId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, long campaignId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, _CLASS_NAME, campaignId, actionId);
	}

	private static final String _CLASS_NAME =
		"com.liferay.newsletter.model.NewsletterCampaign";

}