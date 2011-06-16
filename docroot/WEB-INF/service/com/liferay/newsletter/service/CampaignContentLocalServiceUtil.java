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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the campaign content local service. This utility wraps {@link com.liferay.newsletter.service.impl.CampaignContentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignContentLocalService
 * @see com.liferay.newsletter.service.base.CampaignContentLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.CampaignContentLocalServiceImpl
 * @generated
 */
public class CampaignContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.newsletter.service.impl.CampaignContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the campaign content to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content to add
	* @return the campaign content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.CampaignContent addCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCampaignContent(campaignContent);
	}

	/**
	* Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	*
	* @param campaignContentId the primary key for the new campaign content
	* @return the new campaign content
	*/
	public static com.liferay.newsletter.model.CampaignContent createCampaignContent(
		long campaignContentId) {
		return getService().createCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContentId the primary key of the campaign content to delete
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignContent(long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignContent(campaignContentId);
	}

	/**
	* Deletes the campaign content from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCampaignContent(campaignContent);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the campaign content with the primary key.
	*
	* @param campaignContentId the primary key of the campaign content to get
	* @return the campaign content
	* @throws PortalException if a campaign content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.CampaignContent getCampaignContent(
		long campaignContentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContent(campaignContentId);
	}

	/**
	* Gets a range of all the campaign contents.
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
	public static java.util.List<com.liferay.newsletter.model.CampaignContent> getCampaignContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContents(start, end);
	}

	/**
	* Gets the number of campaign contents.
	*
	* @return the number of campaign contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getCampaignContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignContentsCount();
	}

	/**
	* Updates the campaign content in the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content to update
	* @return the campaign content that was updated
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.CampaignContent updateCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCampaignContent(campaignContent);
	}

	/**
	* Updates the campaign content in the database. Also notifies the appropriate model listeners.
	*
	* @param campaignContent the campaign content to update
	* @param merge whether to merge the campaign content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the campaign content that was updated
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.CampaignContent updateCampaignContent(
		com.liferay.newsletter.model.CampaignContent campaignContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCampaignContent(campaignContent, merge);
	}

	/**
	* Gets the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<com.liferay.newsletter.model.Campaign> getCampaigns(
		com.liferay.newsletter.model.CampaignContent campaignContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaigns(campaignContent);
	}

	public static java.util.List<com.liferay.newsletter.model.CampaignContent> getCampaignsContentByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignsContentByTitle(title, start, end);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignContentLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignContentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CampaignContentLocalService.class.getName(),
					portletClassLoader);

			_service = new CampaignContentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CampaignContentLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CampaignContentLocalService.class);
		}

		return _service;
	}

	public void setService(CampaignContentLocalService service) {
		MethodCache.remove(CampaignContentLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CampaignContentLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CampaignContentLocalService.class);
	}

	private static CampaignContentLocalService _service;
}