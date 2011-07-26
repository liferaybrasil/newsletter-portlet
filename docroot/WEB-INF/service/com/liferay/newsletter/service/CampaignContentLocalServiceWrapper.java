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

package com.liferay.newsletter.service;

/**
 * <p>
 * This class is a wrapper for {@link CampaignContentLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignContentLocalService
 * @generated
 */
public class CampaignContentLocalServiceWrapper
	implements CampaignContentLocalService {
	public CampaignContentLocalServiceWrapper(
		CampaignContentLocalService campaignContentLocalService) {
		_campaignContentLocalService = campaignContentLocalService;
	}

	/**
	* Adds the campaign content to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was added
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent addCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.addCampaignContent(campaignContent);
	}

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	public com.liferay.newsletter.model.CampaignContent createCampaignContent(
		long campaignContentId) {
		return _campaignContentLocalService.createCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_campaignContentLocalService.deleteCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignContentLocalService.deleteCampaignContent(campaignContent);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the campaign content with the primary key.
	*
	* @param campaignContentId the primary key of the campaign content
	* @return the campaign content
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent getCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getCampaignContent(campaignContentId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaign contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign contents
	* @param end the upper bound of the range of campaign contents (not inclusive)
	* @return the range of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.CampaignContent> getCampaignContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getCampaignContents(start, end);
	}

	/**
	* Returns the number of campaign contents.
	*
	* @return the number of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public int getCampaignContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getCampaignContentsCount();
	}

	/**
	* Updates the campaign content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @return the campaign content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent updateCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.updateCampaignContent(campaignContent);
	}

	/**
	* Updates the campaign content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content
	* @param merge whether to merge the campaign content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the campaign content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.CampaignContent updateCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.updateCampaignContent(campaignContent,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _campaignContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<com.liferay.newsletter.model.Campaign> getCampaigns(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getCampaigns(campaignContent);
	}

	public java.util.List<com.liferay.newsletter.model.CampaignContent> getCampaignsContentByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignContentLocalService.getCampaignsContentByTitle(title,
			start, end);
	}

	public void validate(java.lang.String title, java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException {
		_campaignContentLocalService.validate(title, content);
	}

	public CampaignContentLocalService getWrappedCampaignContentLocalService() {
		return _campaignContentLocalService;
	}

	public void setWrappedCampaignContentLocalService(
		CampaignContentLocalService campaignContentLocalService) {
		_campaignContentLocalService = campaignContentLocalService;
	}

	private CampaignContentLocalService _campaignContentLocalService;
}