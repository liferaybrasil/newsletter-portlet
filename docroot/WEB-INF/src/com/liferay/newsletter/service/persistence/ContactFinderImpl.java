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

import java.util.Iterator;
import java.util.List;

import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.impl.ContactImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
public class ContactFinderImpl
	extends BasePersistenceImpl<Contact> implements ContactFinder{

	public static String FIND_BY_NAME_CAMPAIGN =
		ContactFinder.class.getName() + ".findByNameAndCampaign";

	public static String COUNT_BY_CAMPAIGN =
		ContactFinder.class.getName() + ".countByCampaign";

	public static String COUNT_BY_CAMPAIGN_CONTENT =
		ContactFinder.class.getName() + ".countByCampaignContent";

	public static String FIND_BY_EMAIL =
		ContactFinder.class.getName() + ".findByEmail";

	public List<Contact> findByNameAndCampaign(
		String contactName, long campaignId, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NAME_CAMPAIGN);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Contact", Contact.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(contactName);
			qPos.add(campaignId);

			return (List<Contact>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByCampaign(long campaignId)	throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_CAMPAIGN);

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			qPos.add(campaignId);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByCampaignContent(long campaignContentId)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_CAMPAIGN_CONTENT);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(campaignContentId);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Contact> findByEmail(String email, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_EMAIL);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Contact", ContactImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add("%"+email+"%");

			List<Contact> list = (List<Contact>)QueryUtil.list(
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