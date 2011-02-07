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
 * This class is a wrapper for {@link SendCampaignLocalService}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       SendCampaignLocalService
 * @generated
 */
public class SendCampaignLocalServiceWrapper implements SendCampaignLocalService {
	public SendCampaignLocalServiceWrapper(
		SendCampaignLocalService sendCampaignLocalService) {
		_sendCampaignLocalService = sendCampaignLocalService;
	}

	/**
	* Adds the send campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaign the send campaign to add
	* @return the send campaign that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.SendCampaign addSendCampaign(
		com.liferay.newsletter.model.SendCampaign sendCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.addSendCampaign(sendCampaign);
	}

	/**
	* Creates a new send campaign with the primary key. Does not add the send campaign to the database.
	*
	* @param sendCampaignId the primary key for the new send campaign
	* @return the new send campaign
	*/
	public com.liferay.newsletter.model.SendCampaign createSendCampaign(
		long sendCampaignId) {
		return _sendCampaignLocalService.createSendCampaign(sendCampaignId);
	}

	/**
	* Deletes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaignId the primary key of the send campaign to delete
	* @throws PortalException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSendCampaign(long sendCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_sendCampaignLocalService.deleteSendCampaign(sendCampaignId);
	}

	/**
	* Deletes the send campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaign the send campaign to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSendCampaign(
		com.liferay.newsletter.model.SendCampaign sendCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		_sendCampaignLocalService.deleteSendCampaign(sendCampaign);
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
		return _sendCampaignLocalService.dynamicQuery(dynamicQuery);
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
		return _sendCampaignLocalService.dynamicQuery(dynamicQuery, start, end);
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
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _sendCampaignLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the send campaign with the primary key.
	*
	* @param sendCampaignId the primary key of the send campaign to get
	* @return the send campaign
	* @throws PortalException if a send campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.SendCampaign getSendCampaign(
		long sendCampaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaign(sendCampaignId);
	}

	/**
	* Gets a range of all the send campaigns.
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
	public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaigns(start, end);
	}

	/**
	* Gets the number of send campaigns.
	*
	* @return the number of send campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int getSendCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaignsCount();
	}

	/**
	* Updates the send campaign in the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaign the send campaign to update
	* @return the send campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.SendCampaign updateSendCampaign(
		com.liferay.newsletter.model.SendCampaign sendCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.updateSendCampaign(sendCampaign);
	}

	/**
	* Updates the send campaign in the database. Also notifies the appropriate model listeners.
	*
	* @param sendCampaign the send campaign to update
	* @param merge whether to merge the send campaign with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the send campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.SendCampaign updateSendCampaign(
		com.liferay.newsletter.model.SendCampaign sendCampaign, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.updateSendCampaign(sendCampaign, merge);
	}

	public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		com.liferay.newsletter.model.SendCampaign sendCampaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getNewsletterLogs(sendCampaign);
	}

	public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaignsByCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaignsByCampaign(campaignId);
	}

	public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaignsByDate(
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaignsByDate(sendDate);
	}

	public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaignsBySendDateLT(
		java.util.Date sendDate, boolean sent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendCampaignLocalService.getSendCampaignsBySendDateLT(sendDate,
			sent);
	}

	public void job() {
		_sendCampaignLocalService.job();
	}

	public void sendSendCampaign(
		com.liferay.newsletter.model.SendCampaign sendCampaign)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.mail.MessagingException, javax.mail.internet.AddressException {
		_sendCampaignLocalService.sendSendCampaign(sendCampaign);
	}

	public SendCampaignLocalService getWrappedSendCampaignLocalService() {
		return _sendCampaignLocalService;
	}

	public void setWrappedSendCampaignLocalService(
		SendCampaignLocalService sendCampaignLocalService) {
		_sendCampaignLocalService = sendCampaignLocalService;
	}

	private SendCampaignLocalService _sendCampaignLocalService;
}