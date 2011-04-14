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
 * This class is a wrapper for {@link NewsletterLogLocalService}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       NewsletterLogLocalService
 * @generated
 */
public class NewsletterLogLocalServiceWrapper
	implements NewsletterLogLocalService {
	public NewsletterLogLocalServiceWrapper(
		NewsletterLogLocalService newsletterLogLocalService) {
		_newsletterLogLocalService = newsletterLogLocalService;
	}

	/**
	* Adds the newsletter log to the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLog the newsletter log to add
	* @return the newsletter log that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog addNewsletterLog(
		com.liferay.newsletter.model.NewsletterLog newsletterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.addNewsletterLog(newsletterLog);
	}

	/**
	* Creates a new newsletter log with the primary key. Does not add the newsletter log to the database.
	*
	* @param newsletterLogId the primary key for the new newsletter log
	* @return the new newsletter log
	*/
	public com.liferay.newsletter.model.NewsletterLog createNewsletterLog(
		long newsletterLogId) {
		return _newsletterLogLocalService.createNewsletterLog(newsletterLogId);
	}

	/**
	* Deletes the newsletter log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLogId the primary key of the newsletter log to delete
	* @throws PortalException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNewsletterLog(long newsletterLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_newsletterLogLocalService.deleteNewsletterLog(newsletterLogId);
	}

	/**
	* Deletes the newsletter log from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLog the newsletter log to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNewsletterLog(
		com.liferay.newsletter.model.NewsletterLog newsletterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		_newsletterLogLocalService.deleteNewsletterLog(newsletterLog);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the newsletter log with the primary key.
	*
	* @param newsletterLogId the primary key of the newsletter log to get
	* @return the newsletter log
	* @throws PortalException if a newsletter log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog getNewsletterLog(
		long newsletterLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getNewsletterLog(newsletterLogId);
	}

	/**
	* Gets a range of all the newsletter logs.
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
	public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getNewsletterLogs(start, end);
	}

	/**
	* Gets the number of newsletter logs.
	*
	* @return the number of newsletter logs
	* @throws SystemException if a system exception occurred
	*/
	public int getNewsletterLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getNewsletterLogsCount();
	}

	/**
	* Updates the newsletter log in the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLog the newsletter log to update
	* @return the newsletter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog updateNewsletterLog(
		com.liferay.newsletter.model.NewsletterLog newsletterLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.updateNewsletterLog(newsletterLog);
	}

	/**
	* Updates the newsletter log in the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterLog the newsletter log to update
	* @param merge whether to merge the newsletter log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the newsletter log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterLog updateNewsletterLog(
		com.liferay.newsletter.model.NewsletterLog newsletterLog, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.updateNewsletterLog(newsletterLog,
			merge);
	}

	/**
	* Gets the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _newsletterLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_newsletterLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogByCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getNewsletterLogByCampaign(campaignId);
	}

	public java.util.List<com.liferay.newsletter.model.Contact> getContactsByCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getContactsByCampaign(campaignId);
	}

	public com.liferay.newsletter.model.NewsletterLog getNewsletterLogByCampaignAndContact(
		long campaignId, long contactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getNewsletterLogByCampaignAndContact(campaignId,
			contactId);
	}

	public int getContactsByCampaignCount(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _newsletterLogLocalService.getContactsByCampaignCount(campaignId);
	}

	public NewsletterLogLocalService getWrappedNewsletterLogLocalService() {
		return _newsletterLogLocalService;
	}

	public void setWrappedNewsletterLogLocalService(
		NewsletterLogLocalService newsletterLogLocalService) {
		_newsletterLogLocalService = newsletterLogLocalService;
	}

	private NewsletterLogLocalService _newsletterLogLocalService;
}