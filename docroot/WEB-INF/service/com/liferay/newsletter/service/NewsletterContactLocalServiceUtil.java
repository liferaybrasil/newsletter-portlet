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
 * The utility for the newsletter contact local service. This utility wraps {@link com.liferay.newsletter.service.impl.NewsletterContactLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterContactLocalService
 * @see com.liferay.newsletter.service.base.NewsletterContactLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.NewsletterContactLocalServiceImpl
 * @generated
 */
public class NewsletterContactLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.newsletter.service.impl.NewsletterContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the newsletter contact to the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterContact the newsletter contact
	* @return the newsletter contact that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContact addNewsletterContact(
		com.liferay.newsletter.model.NewsletterContact newsletterContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNewsletterContact(newsletterContact);
	}

	/**
	* Creates a new newsletter contact with the primary key. Does not add the newsletter contact to the database.
	*
	* @param contactId the primary key for the new newsletter contact
	* @return the new newsletter contact
	*/
	public static com.liferay.newsletter.model.NewsletterContact createNewsletterContact(
		long contactId) {
		return getService().createNewsletterContact(contactId);
	}

	/**
	* Deletes the newsletter contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the newsletter contact
	* @throws PortalException if a newsletter contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNewsletterContact(long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNewsletterContact(contactId);
	}

	/**
	* Deletes the newsletter contact from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterContact the newsletter contact
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNewsletterContact(
		com.liferay.newsletter.model.NewsletterContact newsletterContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNewsletterContact(newsletterContact);
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
	* Returns the newsletter contact with the primary key.
	*
	* @param contactId the primary key of the newsletter contact
	* @return the newsletter contact
	* @throws PortalException if a newsletter contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContact getNewsletterContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContact(contactId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the newsletter contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter contacts
	* @param end the upper bound of the range of newsletter contacts (not inclusive)
	* @return the range of newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.newsletter.model.NewsletterContact> getNewsletterContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContacts(start, end);
	}

	/**
	* Returns the number of newsletter contacts.
	*
	* @return the number of newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int getNewsletterContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNewsletterContactsCount();
	}

	/**
	* Updates the newsletter contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletterContact the newsletter contact
	* @return the newsletter contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContact updateNewsletterContact(
		com.liferay.newsletter.model.NewsletterContact newsletterContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewsletterContact(newsletterContact);
	}

	/**
	* Updates the newsletter contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletterContact the newsletter contact
	* @param merge whether to merge the newsletter contact with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the newsletter contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.newsletter.model.NewsletterContact updateNewsletterContact(
		com.liferay.newsletter.model.NewsletterContact newsletterContact,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNewsletterContact(newsletterContact, merge);
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

	public static com.liferay.newsletter.model.NewsletterContact addContact(
		long userId, long groupId, java.lang.String email,
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addContact(userId, groupId, email, name, serviceContext);
	}

	public static com.liferay.newsletter.model.NewsletterContact getContact(
		long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContact(contactId);
	}

	public static int getContactCountByContent(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactCountByContent(contentId);
	}

	public static int getContactCountByCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactCountByCampaign(campaignId);
	}

	public static com.liferay.newsletter.model.NewsletterContact getContact(
		long userId, long scopeGroupId, java.lang.String email,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getContact(userId, scopeGroupId, email, serviceContext);
	}

	public static java.util.List<com.liferay.newsletter.model.NewsletterContact> search(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, keywords, start, end,
			orderByComparator);
	}

	public static java.util.List<com.liferay.newsletter.model.NewsletterContact> search(
		long companyId, long groupId, long campaignId,
		java.lang.String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, campaignId, keywords, start,
			end, orderByComparator);
	}

	public static java.util.List<com.liferay.newsletter.model.NewsletterContact> search(
		long companyId, long groupId, long campaignId, java.lang.String name,
		java.lang.String email, boolean sent, int start, int end,
		boolean isAndOperator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(companyId, groupId, campaignId, name, email, sent,
			start, end, isAndOperator, orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		long campaignId, java.lang.String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchCount(companyId, groupId, campaignId, keywords,
			start, end, orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		java.lang.String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchCount(companyId, groupId, keywords, start, end,
			orderByComparator);
	}

	public static int searchCount(long companyId, long groupId,
		long campaignId, java.lang.String name, java.lang.String email,
		boolean sent, int start, int end, boolean isAndOperator,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchCount(companyId, groupId, campaignId, name, email,
			sent, start, end, isAndOperator, orderByComparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static NewsletterContactLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NewsletterContactLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					NewsletterContactLocalService.class.getName(),
					portletClassLoader);

			_service = new NewsletterContactLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(NewsletterContactLocalServiceUtil.class,
				"_service");
			MethodCache.remove(NewsletterContactLocalService.class);
		}

		return _service;
	}

	public void setService(NewsletterContactLocalService service) {
		MethodCache.remove(NewsletterContactLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(NewsletterContactLocalServiceUtil.class,
			"_service");
		MethodCache.remove(NewsletterContactLocalService.class);
	}

	private static NewsletterContactLocalService _service;
}