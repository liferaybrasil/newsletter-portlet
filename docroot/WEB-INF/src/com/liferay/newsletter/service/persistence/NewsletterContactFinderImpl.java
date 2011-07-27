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

import com.liferay.newsletter.model.NewsletterContact;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.impl.ContactImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Iterator;
import java.util.List;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterContactFinderImpl
	extends BasePersistenceImpl<NewsletterContact> implements NewsletterContactFinder {

	public static String COUNT_BY_CAMPAIGN =
		NewsletterContactFinder.class.getName() + ".countByCampaign";

	public static String COUNT_BY_CAMPAIGN_CONTENT =
		NewsletterContactFinder.class.getName() + ".countByCampaignContent";

	public static String FIND_BY_EMAIL =
		NewsletterContactFinder.class.getName() + ".findByEmail";

	public static String FIND_BY_NAME_CAMPAIGN =
		NewsletterContactFinder.class.getName() + ".findByNameAndCampaign";

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

	public List<NewsletterContact> findByEmail(String email, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_EMAIL);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Contact", ContactImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			// TODO: Cheque se isso est� correto (%email%), eu acho que n�o �
			// assim que se faz
			qPos.add("%"+email+"%");

			return (List<NewsletterContact>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<NewsletterContact> findByNameAndCampaign(
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

			return (List<NewsletterContact>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<NewsletterContact> findByKeywords(
			String keywords,  int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NAME_CAMPAIGN);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Contact", Contact.class);

			QueryPos qPos = QueryPos.getInstance(q);

			return (List<NewsletterContact>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}