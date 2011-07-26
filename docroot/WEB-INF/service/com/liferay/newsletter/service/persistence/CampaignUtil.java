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
 * @author Brian Wing Shun Chan
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
	* @param campaign the campaign
	*/
	public static void cacheResult(
		com.liferay.newsletter.model.Campaign campaign) {
		getPersistence().cacheResult(campaign);
	}

	/**
	* Caches the campaigns in the entity cache if it is enabled.
	*
	* @param campaigns the campaigns
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
	* @param campaignId the primary key of the campaign
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
	* Returns the campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the campaign
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
	* Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign fetchByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignId);
	}

	/**
	* Returns all the campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns the first campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
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
	* Returns the last campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
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
	* Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid
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
	* Returns all the campaigns that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns that the user has permissions to view where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where uuid = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param uuid the uuid
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
	* Returns all the campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findByCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignContent(campaignContentId);
	}

	/**
	* Returns a range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns an ordered range of all the campaigns where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns the first campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
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
	* Returns the last campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
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
	* Returns the campaigns before and after the current campaign in the ordered set where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param campaignContentId the campaign content ID
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
	* Returns all the campaigns that the user has permission to view where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindByCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCampaignContent(campaignContentId);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns an ordered range of all the campaigns that the user has permissions to view where campaignContentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the campaign content ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where campaignContentId = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param campaignContentId the campaign content ID
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
	* Returns all the campaigns where sentDate = &#63;.
	*
	* @param sentDate the sent date
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySentDate(
		java.util.Date sentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate(sentDate);
	}

	/**
	* Returns a range of all the campaigns where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySentDate(
		java.util.Date sentDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate(sentDate, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySentDate(
		java.util.Date sentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySentDate(sentDate, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySentDate_First(
		java.util.Date sentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate_First(sentDate, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySentDate_Last(
		java.util.Date sentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySentDate_Last(sentDate, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sentDate the sent date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findBySentDate_PrevAndNext(
		long campaignId, java.util.Date sentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySentDate_PrevAndNext(campaignId, sentDate,
			orderByComparator);
	}

	/**
	* Returns all the campaigns that the user has permission to view where sentDate = &#63;.
	*
	* @param sentDate the sent date
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySentDate(
		java.util.Date sentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySentDate(sentDate);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySentDate(
		java.util.Date sentDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySentDate(sentDate, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns that the user has permissions to view where sentDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySentDate(
		java.util.Date sentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySentDate(sentDate, start, end, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where sentDate = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param sentDate the sent date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindBySentDate_PrevAndNext(
		long campaignId, java.util.Date sentDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySentDate_PrevAndNext(campaignId, sentDate,
			orderByComparator);
	}

	/**
	* Returns all the campaigns where sentDate &le; &#63; and sent = &#63;.
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sentDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sentDate, sent);
	}

	/**
	* Returns a range of all the campaigns where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sentDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySD_LT(sentDate, sent, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findBySD_LT(
		java.util.Date sentDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT(sentDate, sent, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySD_LT_First(
		java.util.Date sentDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_First(sentDate, sent, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign findBySD_LT_Last(
		java.util.Date sentDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_Last(sentDate, sent, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param sentDate the sent date
	* @param sent the sent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] findBySD_LT_PrevAndNext(
		long campaignId, java.util.Date sentDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySD_LT_PrevAndNext(campaignId, sentDate, sent,
			orderByComparator);
	}

	/**
	* Returns all the campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @return the matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sentDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sentDate, sent);
	}

	/**
	* Returns a range of all the campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sentDate, boolean sent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindBySD_LT(sentDate, sent, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns that the user has permissions to view where sentDate &le; &#63; and sent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> filterFindBySD_LT(
		java.util.Date sentDate, boolean sent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySD_LT(sentDate, sent, start, end,
			orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	*
	* @param campaignId the primary key of the current campaign
	* @param sentDate the sent date
	* @param sent the sent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.Campaign[] filterFindBySD_LT_PrevAndNext(
		long campaignId, java.util.Date sentDate, boolean sent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindBySD_LT_PrevAndNext(campaignId, sentDate, sent,
			orderByComparator);
	}

	/**
	* Returns all the campaigns.
	*
	* @return the campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.Campaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the campaigns where campaignContentId = &#63; from the database.
	*
	* @param campaignContentId the campaign content ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignContent(campaignContentId);
	}

	/**
	* Removes all the campaigns where sentDate = &#63; from the database.
	*
	* @param sentDate the sent date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySentDate(java.util.Date sentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySentDate(sentDate);
	}

	/**
	* Removes all the campaigns where sentDate &le; &#63; and sent = &#63; from the database.
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySD_LT(java.util.Date sentDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySD_LT(sentDate, sent);
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
	* Returns the number of campaigns where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUuid(uuid);
	}

	/**
	* Returns the number of campaigns where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignContent(campaignContentId);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where campaignContentId = &#63;.
	*
	* @param campaignContentId the campaign content ID
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCampaignContent(campaignContentId);
	}

	/**
	* Returns the number of campaigns where sentDate = &#63;.
	*
	* @param sentDate the sent date
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySentDate(java.util.Date sentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySentDate(sentDate);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where sentDate = &#63;.
	*
	* @param sentDate the sent date
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySentDate(java.util.Date sentDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySentDate(sentDate);
	}

	/**
	* Returns the number of campaigns where sentDate &le; &#63; and sent = &#63;.
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySD_LT(java.util.Date sentDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySD_LT(sentDate, sent);
	}

	/**
	* Returns the number of campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	*
	* @param sentDate the sent date
	* @param sent the sent
	* @return the number of matching campaigns that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountBySD_LT(java.util.Date sentDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountBySD_LT(sentDate, sent);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the newsletter logs associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk);
	}

	/**
	* Returns a range of all the newsletter logs associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogs(pk, start, end);
	}

	/**
	* Returns an ordered range of all the newsletter logs associated with the campaign.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
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
	* Returns the number of newsletter logs associated with the campaign.
	*
	* @param pk the primary key of the campaign
	* @return the number of newsletter logs associated with the campaign
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewsletterLogsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getNewsletterLogsSize(pk);
	}

	/**
	* Returns <code>true</code> if the newsletter log is associated with the campaign.
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
	* Returns <code>true</code> if the campaign has any newsletter logs associated with it.
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