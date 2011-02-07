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

import com.liferay.newsletter.model.NewsletterLog;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the newsletter log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see NewsletterLogPersistenceImpl
 * @see NewsletterLogUtil
 * @generated
 */
public interface NewsletterLogPersistence extends BasePersistence<NewsletterLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterLogUtil} to access the newsletter log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the newsletter log in the entity cache if it is enabled.
	*
	* @param newsletterLog the newsletter log to cache
	*/
	public void cacheResult(
		com.liferay.newsletter.model.NewsletterLog newsletterLog);

	/**
	* Caches the newsletter logs in the entity cache if it is enabled.
	*
	* @param newsletterLogs the newsletter logs to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.newsletter.model.NewsletterLog> newsletterLogs);

	/**
	* Creates a new newsletter log with the primary key. Does not add the newsletter log to the database.
	*
	* @param newsletterLogId the primary key for the new newsletter log
	* @return the new newsletter log
	*/
	public com.liferay.newsletter.model.NewsletterLog create(
		long newsletterLogId);

	/**
	* Removes the newsletter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLogId the primary key of the newsletter log to remove
	* @return the newsletter log that was removed
	* @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog remove(
		long newsletterLogId)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.newsletter.model.NewsletterLog updateImpl(
		com.liferay.newsletter.model.NewsletterLog newsletterLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the newsletter log with the primary key or throws a {@link com.liferay.newsletter.NoSuchLogException} if it could not be found.
	*
	* @param newsletterLogId the primary key of the newsletter log to find
	* @return the newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog findByPrimaryKey(
		long newsletterLogId)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the newsletter log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsletterLogId the primary key of the newsletter log to find
	* @return the newsletter log, or <code>null</code> if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog fetchByPrimaryKey(
		long newsletterLogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the newsletter logs where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the newsletter logs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @return the range of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the newsletter logs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first newsletter log in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last newsletter log in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the newsletter logs before and after the current newsletter log in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param newsletterLogId the primary key of the current newsletter log
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog[] findByUuid_PrevAndNext(
		long newsletterLogId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the newsletter logs where sendCampaignId = &#63;.
	*
	* @param sendCampaignId the send campaign ID to search with
	* @return the matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
		long sendCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the newsletter logs where sendCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the send campaign ID to search with
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @return the range of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
		long sendCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the newsletter logs where sendCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the send campaign ID to search with
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
		long sendCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first newsletter log in the ordered set where sendCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the send campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog findBySendCampaign_First(
		long sendCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last newsletter log in the ordered set where sendCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the send campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog findBySendCampaign_Last(
		long sendCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the newsletter logs before and after the current newsletter log in the ordered set where sendCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param newsletterLogId the primary key of the current newsletter log
	* @param sendCampaignId the send campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next newsletter log
	* @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog[] findBySendCampaign_PrevAndNext(
		long newsletterLogId, long sendCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the newsletter logs.
	*
	* @return the newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the newsletter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @return the range of newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the newsletter logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter logs to return
	* @param end the upper bound of the range of newsletter logs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletter logs where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletter logs where sendCampaignId = &#63; from the database.
	*
	* @param sendCampaignId the send campaign ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySendCampaign(long sendCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletter logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the newsletter logs where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the newsletter logs where sendCampaignId = &#63;.
	*
	* @param sendCampaignId the send campaign ID to search with
	* @return the number of matching newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countBySendCampaign(long sendCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the newsletter logs.
	*
	* @return the number of newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public NewsletterLog remove(NewsletterLog newsletterLog)
		throws SystemException;
}