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
 * The utility for the newsletter content local service. This utility wraps {@link com.liferay.newsletter.service.impl.NewsletterContentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterContentLocalService
 * @see com.liferay.newsletter.service.base.NewsletterContentLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.NewsletterContentLocalServiceImpl
 * @generated
 */
public class NewsletterContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.newsletter.service.impl.NewsletterContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the newsletter content to the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterContent the newsletter content
	* @return the newsletter content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContent addNewsletterContent(
		com.liferay.newsletter.model.NewsletterContent newsletterContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNewsletterContent(newsletterContent);
	}

	/**
	* Creates a new newsletter content with the primary key. Does not add the newsletter content to the database.
	*
	* @param contentId the primary key for the new newsletter content
	* @return the new newsletter content
	*/
	public static com.liferay.newsletter.model.NewsletterContent createNewsletterContent(
		long contentId) {
		return getService().createNewsletterContent(contentId);
	}

	/**
	* Deletes the newsletter content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the newsletter content
	* @throws PortalException if a newsletter content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNewsletterContent(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNewsletterContent(contentId);
	}

	/**
	* Deletes the newsletter content from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterContent the newsletter content
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNewsletterContent(
		com.liferay.newsletter.model.NewsletterContent newsletterContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNewsletterContent(newsletterContent);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
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
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
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
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
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
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the newsletter content with the primary key.
	*
	* @param contentId the primary key of the newsletter content
	* @return the newsletter content
	* @throws PortalException if a newsletter content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContent getNewsletterContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContent(contentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the newsletter content with the UUID in the group.
	*
	* @param uuid the UUID of newsletter content
	* @param groupId the group id of the newsletter content
	* @return the newsletter content
	* @throws PortalException if a newsletter content with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContent getNewsletterContentByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContentByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the newsletter contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter contents
	* @param end the upper bound of the range of newsletter contents (not inclusive)
	* @return the range of newsletter contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterContent> getNewsletterContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContents(start, end);
	}

	/**
	* Returns the number of newsletter contents.
	*
	* @return the number of newsletter contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewsletterContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContentsCount();
	}

	/**
	* Updates the newsletter content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletterContent the newsletter content
	* @return the newsletter content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContent updateNewsletterContent(
		com.liferay.newsletter.model.NewsletterContent newsletterContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewsletterContent(newsletterContent);
	}

	/**
	* Updates the newsletter content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletterContent the newsletter content
	* @param merge whether to merge the newsletter content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the newsletter content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContent updateNewsletterContent(
		com.liferay.newsletter.model.NewsletterContent newsletterContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewsletterContent(newsletterContent, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
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

	public static com.liferay.newsletter.model.NewsletterContent addContent(
		long userId, long groupId, long articleId, java.lang.String title,
		java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContent(userId, groupId, articleId, title, content,
			serviceContext);
	}

	public static void addContentResources(
		com.liferay.newsletter.model.NewsletterContent content,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addContentResources(content, addGroupPermissions,
			addGuestPermissions);
	}

	public static void addContentResources(
		com.liferay.newsletter.model.NewsletterContent content,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addContentResources(content, groupPermissions, guestPermissions);
	}

	public static void deleteContent(
		com.liferay.newsletter.model.NewsletterContent content)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContent(content);
	}

	public static void deleteContent(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContent(contentId);
	}

	public static com.liferay.newsletter.model.NewsletterContent getContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContent(contentId);
	}

	public static java.util.List<com.liferay.newsletter.model.NewsletterContent> search(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, keywords, start, end,
			orderByComparator);
	}

	public static com.liferay.newsletter.model.NewsletterContent updateContent(
		long contentId, long articleId, java.lang.String title,
		java.lang.String content,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContent(contentId, articleId, title, content,
			serviceContext);
	}

	public static void validate(java.lang.String title, java.lang.String content)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().validate(title, content);
	}

	public static void clearService() {
		_service = null;
	}

	public static NewsletterContentLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NewsletterContentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					NewsletterContentLocalService.class.getName(),
					portletClassLoader);

			_service = new NewsletterContentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(NewsletterContentLocalServiceUtil.class,
				"_service");
			MethodCache.remove(NewsletterContentLocalService.class);
		}

		return _service;
	}

	public void setService(NewsletterContentLocalService service) {
		MethodCache.remove(NewsletterContentLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(NewsletterContentLocalServiceUtil.class,
			"_service");
		MethodCache.remove(NewsletterContentLocalService.class);
	}

	private static NewsletterContentLocalService _service;
}