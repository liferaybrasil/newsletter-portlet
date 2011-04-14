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

import com.liferay.newsletter.model.Campaign;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the campaign service. This utility wraps {@link CampaignPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignPersistence
 * @see CampaignPersistenceImpl
 * @generated
 */
public class CampaignUtil {
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
	public static void clearCache(Campaign campaign) {
		getPersistence().clearCache(campaign);
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
	public static List<Campaign> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Campaign remove(Campaign campaign) throws SystemException {
		return getPersistence().remove(campaign);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Campaign update(Campaign campaign, boolean merge)
		throws SystemException {
		return getPersistence().update(campaign, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Campaign update(Campaign campaign, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaign, merge, serviceContext);
	}

	/**
	* Caches the campaign in the entity cache if it is enabled.
	*
	* @param campaign the campaign to cache
	*/
	public static void cacheResult(
		com.liferay.newsletter.model.Campaign campaign) {
		getPersistence().cacheResult(campaign);
	}

	/**
	* Caches the campaigns in the entity cache if it is enabled.
	*
	* @param campaigns the campaigns to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.newsletter.model.Campaign> campaigns) {
		getPersistence().cacheResult(campaigns);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static com.liferay.newsletter.model.Campaign create(long campaignId) {
		return getPersistence().create(campaignId);
	}

	/**
	* Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign to remove
	* @return the campaign that was removed
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign remove(long campaignId)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(campaignId);
	}

	public static com.liferay.newsletter.model.Campaign updateImpl(
		com.liferay.newsletter.model.Campaign campaign, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaign, merge);
	}

	/**
	* Finds the campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the campaign to find
	* @return the campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findByPrimaryKey(
		long campaignId)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(campaignId);
	}

	/**
	* Finds the campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the campaign to find
	* @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign fetchByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignId);
	}

	/**
	* Finds all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Finds a range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Finds an ordered range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds the first campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Finds the last campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Finds the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findByUuid_PrevAndNext(
		long campaignId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(campaignId, uuid, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	* Filters by the user's permissions and finds a range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Filters the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindByUuid_PrevAndNext(
		long campaignId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUuid_PrevAndNext(campaignId, uuid,
			orderByComparator);
	}

	/**
	* Finds all the campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID to search with
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignContent(campaignContentId);
	}

	/**
	* Finds a range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByCampaignContent(
		long campaignContentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignContent(campaignContentId, start, end);
	}

	/**
	* Finds an ordered range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByCampaignContent(
		long campaignContentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignContent(campaignContentId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findByCampaignContent_First(
		long campaignContentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignContent_First(campaignContentId,
			orderByComparator);
	}

	/**
	* Finds the last campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findByCampaignContent_Last(
		long campaignContentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignContent_Last(campaignContentId,
			orderByComparator);
	}

	/**
	* Finds the campaigns before and after the current campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param campaignContentId the campaign content ID to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findByCampaignContent_PrevAndNext(
		long campaignId, long campaignContentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignContent_PrevAndNext(campaignId,
			campaignContentId, orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID to search with
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCampaignContent(campaignContentId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByCampaignContent(
		long campaignContentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCampaignContent(campaignContentId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByCampaignContent(
		long campaignContentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCampaignContent(campaignContentId, start, end,
			orderByComparator);
	}

	/**
	* Filters the campaigns before and after the current campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param campaignContentId the campaign content ID to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindByCampaignContent_PrevAndNext(
		long campaignId, long campaignContentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCampaignContent_PrevAndNext(campaignId,
			campaignContentId, orderByComparator);
	}

	/**
	* Finds all the campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySendDate(
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate(sendDate);
	}

	/**
	* Finds a range of all the campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySendDate(
		java.util.Date sendDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate(sendDate, start, end);
	}

	/**
	* Finds an ordered range of all the campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySendDate(
		java.util.Date sendDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySendDate(sendDate, start, end, orderByComparator);
	}

	/**
	* Finds the first campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySendDate_First(
		java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate_First(sendDate, orderByComparator);
	}

	/**
	* Finds the last campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySendDate_Last(
		java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySendDate_Last(sendDate, orderByComparator);
	}

	/**
	* Finds the campaigns before and after the current campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findBySendDate_PrevAndNext(
		long campaignId, java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySendDate_PrevAndNext(campaignId, sendDate,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySendDate(
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySendDate(sendDate);
	}

	/**
	* Filters by the user's permissions and finds a range of all the campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySendDate(
		java.util.Date sendDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySendDate(sendDate, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the campaigns where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySendDate(
		java.util.Date sendDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySendDate(sendDate, start, end, orderByComparator);
	}

	/**
	* Filters the campaigns before and after the current campaign in the ordered set where sendDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sendDate the send date to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindBySendDate_PrevAndNext(
		long campaignId, java.util.Date sendDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySendDate_PrevAndNext(campaignId, sendDate,
			orderByComparator);
	}

	/**
	* Finds all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sendDate, sent);
	}

	/**
	* Finds a range of all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sendDate, sent, start, end);
	}

	/**
	* Finds an ordered range of all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT(sendDate, sent, start, end, orderByComparator);
	}

	/**
	* Finds the first campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySD_LT_First(
		java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_First(sendDate, sent, orderByComparator);
	}

	/**
	* Finds the last campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySD_LT_Last(
		java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_Last(sendDate, sent, orderByComparator);
	}

	/**
	* Finds the campaigns before and after the current campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findBySD_LT_PrevAndNext(
		long campaignId, java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_PrevAndNext(campaignId, sendDate, sent,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sendDate, sent);
	}

	/**
	* Filters by the user's permissions and finds a range of all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sendDate, sent, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sendDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySD_LT(sendDate, sent, start, end,
			orderByComparator);
	}

	/**
	* Filters the campaigns before and after the current campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindBySD_LT_PrevAndNext(
		long campaignId, java.util.Date sendDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySD_LT_PrevAndNext(campaignId, sendDate, sent,
			orderByComparator);
	}

	/**
	* Finds all the campaigns.
	*
	* @return the campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the campaigns where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the campaigns where campaignContentId = &#63; from the database.
	*
	* @param campaignContentId the campaign content ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignContent(campaignContentId);
	}

	/**
	* Removes all the campaigns where sendDate = &#63; from the database.
	*
	* @param sendDate the send date to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySendDate(sendDate);
	}

	/**
	* Removes all the campaigns where sendDate &le; &#63; and sent = &#63; from the database.
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
	* Removes all the campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Filters by the user's permissions and counts all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	* Counts all the campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID to search with
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignContent(campaignContentId);
	}

	/**
	* Filters by the user's permissions and counts all the campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID to search with
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCampaignContent(campaignContentId);
	}

	/**
	* Counts all the campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySendDate(sendDate);
	}

	/**
	* Filters by the user's permissions and counts all the campaigns where sendDate = &#63;.
	*
	* @param sendDate the send date to search with
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySendDate(java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySendDate(sendDate);
	}

	/**
	* Counts all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySD_LT(java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySD_LT(sendDate, sent);
	}

	/**
	* Filters by the user's permissions and counts all the campaigns where sendDate &le; &#63; and sent = &#63;.
	*
	* @param sendDate the send date to search with
	* @param sent the sent to search with
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySD_LT(java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySD_LT(sendDate, sent);
	}

	/**
	* Counts all the campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the newsletter logs associated with the campaign.
	*
	* @param pk the primary key of the campaign to get the associated newsletter logs for
	* @return the newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk);
	}

	/**
	* Gets a range of all the newsletter logs associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign to get the associated newsletter logs for
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @return the range of newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk, start, end);
	}

	/**
	* Gets an ordered range of all the newsletter logs associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign to get the associated newsletter logs for
	* @param start the lower bound of the range of campaigns to return
	* @param end the upper bound of the range of campaigns to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of newsletter logs associated with the campaign
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
	* Gets the number of newsletter logs associated with the campaign.
	*
	* @param pk the primary key of the campaign to get the number of associated newsletter logs for
	* @return the number of newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewsletterLogsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogsSize(pk);
	}

	/**
	* Determines if the newsletter log is associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @param newsletterLogPK the primary key of the newsletter log
	* @return <code>true</code> if the newsletter log is associated with the campaign; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsNewsletterLog(long pk, long newsletterLogPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsNewsletterLog(pk, newsletterLogPK);
	}

	/**
	* Determines if the campaign has any newsletter logs associated with it.
	*
	* @param pk the primary key of the campaign to check for associations with newsletter logs
	* @return <code>true</code> if the campaign has any newsletter logs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsNewsletterLogs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsNewsletterLogs(pk);
	}

	public static CampaignPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignPersistence)PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.getServletContextName(),
					CampaignPersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CampaignPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CampaignUtil.class, "_persistence");
	}

	private static CampaignPersistence _persistence;
}