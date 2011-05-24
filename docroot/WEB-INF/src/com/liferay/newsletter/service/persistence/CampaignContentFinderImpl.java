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

import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.impl.CampaignContentImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;
public class CampaignContentFinderImpl
	extends BasePersistenceImpl<CampaignContent>
	implements CampaignContentFinder{

	public static String FIND_BY_TITLE =
		CampaignContentFinder.class.getName() + ".findByTitle";

	public List<CampaignContent> findByTitle(String title, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_TITLE);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("CampaignContent", CampaignContentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add("%"+title+"%");

			List<CampaignContent> list = (List<CampaignContent>)QueryUtil.list(
					q, getDialect(), start, end);
			return list;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}