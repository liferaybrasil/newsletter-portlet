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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignContentPersistenceImpl
 * @see CampaignContentUtil
 * @generated
 */
public interface CampaignContentPersistence extends BasePersistence<CampaignContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignContentUtil} to access the campaign content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the campaign content in the entity cache if it is enabled.
	*
	* @param campaignContent the campaign content to cache
	*/
	public void cacheResult(
		com.liferay.newsletter.model.CampaignContent campaignContent);

	/**
	* Caches the campaign contents in the entity cache if it is enabled.
	*
	* @param campaignContents the campaign contents to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.newsletter.model.CampaignContent> campaignContents);

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	public com.liferay.newsletter.model.CampaignContent create(
		long campaignContentId);

	/**
	* Removes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content to remove
	* @return the campaign content that was removed
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent remove(
		long campaignContentId)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.newsletter.model.CampaignContent updateImpl(
		com.liferay.newsletter.model.CampaignContent campaignContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the campaign content with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignContentException} if it could not be found.
	*
	* @param campaignContentId the primary key of the campaign content to find
	* @return the campaign content
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent findByPrimaryKey(
		long campaignContentId)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the campaign content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignContentId the primary key of the campaign content to find
	* @return the campaign content, or <code>null</code> if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent fetchByPrimaryKey(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the campaign contents where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the campaign contents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @return the range of matching campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the campaign contents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first campaign content in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign content
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last campaign content in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign content
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the campaign contents before and after the current campaign content in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the primary key of the current campaign content
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign content
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent[] findByUuid_PrevAndNext(
		long campaignContentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds all the campaign contents where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching campaign contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> filterFindByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds a range of all the campaign contents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @return the range of matching campaign contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> filterFindByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and finds an ordered range of all the campaign contents where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> filterFindByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters the campaign contents before and after the current campaign content in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignContentId the primary key of the current campaign content
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign content
	* @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent[] filterFindByUuid_PrevAndNext(
		long campaignContentId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.newsletter.NoSuchCampaignContentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the campaign contents.
	*
	* @return the campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @return the range of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign contents where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the campaign contents where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Filters by the user's permissions and counts all the campaign contents where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching campaign contents that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the campaign contents.
	*
	* @return the number of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the campaigns associated with the campaign content.
	*
	* @param pk the primary key of the campaign content to get the associated campaigns for
	* @return the campaigns associated with the campaign content
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.Campaign> getCampaigns(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the campaigns associated with the campaign content.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign content to get the associated campaigns for
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @return the range of campaigns associated with the campaign content
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.Campaign> getCampaigns(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the campaigns associated with the campaign content.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the campaign content to get the associated campaigns for
	* @param start the lower bound of the range of campaign contents to return
	* @param end the upper bound of the range of campaign contents to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaigns associated with the campaign content
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.Campaign> getCampaigns(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of campaigns associated with the campaign content.
	*
	* @param pk the primary key of the campaign content to get the number of associated campaigns for
	* @return the number of campaigns associated with the campaign content
	* @throws SystemException if a system exception occurred
	*/
	public int getCampaignsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the campaign is associated with the campaign content.
	*
	* @param pk the primary key of the campaign content
	* @param campaignPK the primary key of the campaign
	* @return <code>true</code> if the campaign is associated with the campaign content; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCampaign(long pk, long campaignPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the campaign content has any campaigns associated with it.
	*
	* @param pk the primary key of the campaign content to check for associations with campaigns
	* @return <code>true</code> if the campaign content has any campaigns associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCampaigns(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	public CampaignContent remove(CampaignContent campaignContent)
		throws SystemException;
}