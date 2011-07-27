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
 * @author Brian Wing Shun Chan
 */
public class NewsletterContentFinderUtil {
	public static java.util.List<com.liferay.newsletter.model.NewsletterContent> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByTitle(title, start, end);
	}

	public static NewsletterContentFinder getFinder() {
		if (_finder == null) {
			_finder = (NewsletterContentFinder)PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.getServletContextName(),
					NewsletterContentFinder.class.getName());

			ReferenceRegistry.registerReference(NewsletterContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(NewsletterContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(NewsletterContentFinderUtil.class,
			"_finder");
	}

	private static NewsletterContentFinder _finder;
}