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

import com.liferay.newsletter.model.SendCampaign;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the send campaign service. This utility wraps {@link SendCampaignPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see SendCampaignPersistence
 * @see SendCampaignPersistenceImpl
 * @generated
 */
public class SendCampaignUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SendCampaign sendCampaign) {
		getPersistence().clearCache(sendCampaign);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SendCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SendCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SendCampaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static SendCampaign remove(SendCampaign sendCampaign)
		throws SystemException {
		return getPersistence().remove(sendCampaign);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SendCampaign update(SendCampaign sendCampaign, boolean merge)
		throws SystemException {
		return getPersistence().update(sendCampaign, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SendCampaign update(SendCampaign sendCampaign, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sendCampaign, merge, serviceContext);
	}

	/**
	* Caches the send campaign in the entity cache if it is enabled.
	*
	* @param sendCampaign the send campaign to cache
	*/
	public static void cacheResult(
		com.liferay.newsletter.model.SendCampaign sendCampaign) {
		getPersistence().cacheResult(sendCampaign);
	}

	/**
	* Caches the send campaigns in the entity cache if it is enabled.
	*
	* @param sendCampaigns the send campaigns to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.newsletter.model.SendCampaign> sendCampaigns) {
		getPersistence().cacheResult(sendCampaigns);
	}

	/**
	* Creates a new send campaign with the primary key. Does not add the send campaign to the database.
	*
	* @param sendCampaignId the primary key for the new send campaign
	* @return the new send campaign
	*/
	public static com.liferay.newsletter.model.SendCampaign create(
		long sendCampaignId) {
		return getPersistence().create(sendCampaignId);
	}

	/**
	* Removes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaignId the primary key of the send campaign to remove
	* @return the send campaign that was removed
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign remove(
		long sendCampaignId)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(sendCampaignId);
	}

	public static com.liferay.newsletter.model.SendCampaign updateImpl(
		com.liferay.newsletter.model.SendCampaign sendCampaign, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sendCampaign, merge);
	}

	/**
	* Finds the send campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchSendCampaignException} if it could not be found.
	*
	* @param sendCampaignId the primary key of the send campaign to find
	* @return the send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findByPrimaryKey(
		long sendCampaignId)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(sendCampaignId);
	}

	/**
	* Finds the send campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sendCampaignId the primary key of the send campaign to find
	* @return the send campaign, or <code>null</code> if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign fetchByPrimaryKey(
		long sendCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(sendCampaignId);
	}

	/**
	* Finds all the send campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Finds a range of all the send campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Finds an ordered range of all the send campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds the first send campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Finds the last send campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Finds the send campaigns before and after the current send campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the primary key of the current send campaign
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign[] findByUuid_PrevAndNext(
		long sendCampaignId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(sendCampaignId, uuid,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the send campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	* Filters by the user's permissions and finds a range of all the send campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the send campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds all the send campaigns where campaignId = &#63;.
	*
	* @param campaignId the campaign ID to search with
	* @return the matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaign(campaignId);
	}

	/**
	* Finds a range of all the send campaigns where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByCampaign(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaign(campaignId, start, end);
	}

	/**
	* Finds an ordered range of all the send campaigns where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findByCampaign(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaign(campaignId, start, end, orderByComparator);
	}

	/**
	* Finds the first send campaign in the ordered set where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findByCampaign_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaign_First(campaignId, orderByComparator);
	}

	/**
	* Finds the last send campaign in the ordered set where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findByCampaign_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaign_Last(campaignId, orderByComparator);
	}

	/**
	* Finds the send campaigns before and after the current send campaign in the ordered set where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the primary key of the current send campaign
	* @param campaignId the campaign ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign[] findByCampaign_PrevAndNext(
		long sendCampaignId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaign_PrevAndNext(sendCampaignId, campaignId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the send campaigns where campaignId = &#63;.
	*
	* @param campaignId the campaign ID to search with
	* @return the matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCampaign(campaignId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the send campaigns where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByCampaign(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCampaign(campaignId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the send campaigns where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindByCampaign(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCampaign(campaignId, start, end,
			orderByComparator);
	}

	/**
	* Finds all the send campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate(sendDate);
	}

	/**
	* Finds a range of all the send campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
		java.util.Date sendDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate(sendDate, start, end);
	}

	/**
	* Finds an ordered range of all the send campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
		java.util.Date sendDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySendDate(sendDate, start, end, orderByComparator);
	}

	/**
	* Finds the first send campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findBySendDate_First(
		java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate_First(sendDate, orderByComparator);
	}

	/**
	* Finds the last send campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findBySendDate_Last(
		java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate_Last(sendDate, orderByComparator);
	}

	/**
	* Finds the send campaigns before and after the current send campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the primary key of the current send campaign
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign[] findBySendDate_PrevAndNext(
		long sendCampaignId, java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySendDate_PrevAndNext(sendCampaignId, sendDate,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the send campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySendDate(
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySendDate(sendDate);
	}

	/**
	* Filters by the user's permissions and finds a range of all the send campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySendDate(
		java.util.Date sendDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySendDate(sendDate, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the send campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySendDate(
		java.util.Date sendDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySendDate(sendDate, start, end, orderByComparator);
	}

	/**
	* Finds all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
		java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sendDate, sent);
	}

	/**
	* Finds a range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sendDate, sent, start, end);
	}

	/**
	* Finds an ordered range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT(sendDate, sent, start, end, orderByComparator);
	}

	/**
	* Finds the first send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findBySD_LT_First(
		java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_First(sendDate, sent, orderByComparator);
	}

	/**
	* Finds the last send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign findBySD_LT_Last(
		java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_Last(sendDate, sent, orderByComparator);
	}

	/**
	* Finds the send campaigns before and after the current send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendCampaignId the primary key of the current send campaign
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next send campaign
	* @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.SendCampaign[] findBySD_LT_PrevAndNext(
		long sendCampaignId, java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchSendCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_PrevAndNext(sendCampaignId, sendDate, sent,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sendDate, sent);
	}

	/**
	* Filters by the user's permissions and finds a range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sendDate, sent, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySD_LT(sendDate, sent, start, end,
			orderByComparator);
	}

	/**
	* Finds all the send campaigns.
	*
	* @return the send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the send campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the send campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.SendCampaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the send campaigns where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the send campaigns where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaign(campaignId);
	}

	/**
	* Removes all the send campaigns where sendDate = &#63; from the database.
	*
	* @param sendDate the send date to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySendDate(sendDate);
	}

	/**
	* Removes all the send campaigns where sendDate &le; &#63; and sent = &#63; from the database.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySD_LT(java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySD_LT(sendDate, sent);
	}

	/**
	* Removes all the send campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the send campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Filters by the user's permissions and counts all the send campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	* Counts all the send campaigns where campaignId = &#63;.
	*
	* @param campaignId the campaign ID to search with
	* @return the number of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaign(campaignId);
	}

	/**
	* Filters by the user's permissions and counts all the send campaigns where campaignId = &#63;.
	*
	* @param campaignId the campaign ID to search with
	* @return the number of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCampaign(campaignId);
	}

	/**
	* Counts all the send campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the number of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySendDate(sendDate);
	}

	/**
	* Filters by the user's permissions and counts all the send campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the number of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySendDate(sendDate);
	}

	/**
	* Counts all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the number of matching send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySD_LT(java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySD_LT(sendDate, sent);
	}

	/**
	* Filters by the user's permissions and counts all the send campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the number of matching send campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySD_LT(java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySD_LT(sendDate, sent);
	}

	/**
	* Counts all the send campaigns.
	*
	* @return the number of send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the newsletter logs associated with the send campaign.
	*
	* @param pk the primary key of the send campaign to get the associated newsletter logs for
	* @return the newsletter logs associated with the send campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk);
	}

	/**
	* Gets a range of all the newsletter logs associated with the send campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the send campaign to get the associated newsletter logs for
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @return the range of newsletter logs associated with the send campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk, start, end);
	}

	/**
	* Gets an ordered range of all the newsletter logs associated with the send campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the send campaign to get the associated newsletter logs for
	* @param start the lower bound of the range of send campaigns to return
	* @param end the upper bound of the range of send campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of newsletter logs associated with the send campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getNewsletterLogs(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of newsletter logs associated with the send campaign.
	*
	* @param pk the primary key of the send campaign to get the number of associated newsletter logs for
	* @return the number of newsletter logs associated with the send campaign
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewsletterLogsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogsSize(pk);
	}

	/**
	* Determines if the newsletter log is associated with the send campaign.
	*
	* @param pk the primary key of the send campaign
	* @param newsletterLogPK the primary key of the newsletter log
	* @return <code>true</code> if the newsletter log is associated with the send campaign; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsNewsletterLog(long pk, long newsletterLogPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsNewsletterLog(pk, newsletterLogPK);
	}

	/**
	* Determines if the send campaign has any newsletter logs associated with it.
	*
	* @param pk the primary key of the send campaign to check for associations with newsletter logs
	* @return <code>true</code> if the send campaign has any newsletter logs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsNewsletterLogs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsNewsletterLogs(pk);
	}

	public static SendCampaignPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SendCampaignPersistence)PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.getServletContextName(),
					SendCampaignPersistence.class.getName());

			ReferenceRegistry.registerReference(SendCampaignUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(SendCampaignPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(SendCampaignUtil.class,
			"_persistence");
	}

	private static SendCampaignPersistence _persistence;
}