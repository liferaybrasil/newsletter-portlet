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

package com.liferay.newsletter.service.base;

import javax.sql.DataSource;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.newsletter.service.CampaignContentLocalService;
import com.liferay.newsletter.service.CampaignContentService;
import com.liferay.newsletter.service.CampaignLocalService;
import com.liferay.newsletter.service.ContactLocalService;
import com.liferay.newsletter.service.ContactService;
import com.liferay.newsletter.service.NewsletterLogLocalService;
import com.liferay.newsletter.service.persistence.CampaignContentFinder;
import com.liferay.newsletter.service.persistence.CampaignContentPersistence;
import com.liferay.newsletter.service.persistence.CampaignPersistence;
import com.liferay.newsletter.service.persistence.ContactFinder;
import com.liferay.newsletter.service.persistence.ContactPersistence;
import com.liferay.newsletter.service.persistence.NewsletterLogPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

/**
 * The base implementation of the contact remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.newsletter.service.impl.ContactServiceImpl}.
 *
 * @author Bruno Pinheiro
 * @see com.liferay.newsletter.service.impl.ContactServiceImpl
 * @see com.liferay.newsletter.service.ContactServiceUtil
 * @generated
 */
public abstract class ContactServiceBaseImpl extends PrincipalBean
	implements ContactService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.newsletter.service.ContactServiceUtil} to access the contact remote service.
	 */

	/**
	 * Gets the campaign local service.
	 *
	 * @return the campaign local service
	 */
	public CampaignLocalService getCampaignLocalService() {
		return campaignLocalService;
	}

	/**
	 * Sets the campaign local service.
	 *
	 * @param campaignLocalService the campaign local service
	 */
	public void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {
		this.campaignLocalService = campaignLocalService;
	}

	/**
	 * Gets the campaign persistence.
	 *
	 * @return the campaign persistence
	 */
	public CampaignPersistence getCampaignPersistence() {
		return campaignPersistence;
	}

	/**
	 * Sets the campaign persistence.
	 *
	 * @param campaignPersistence the campaign persistence
	 */
	public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
		this.campaignPersistence = campaignPersistence;
	}

	/**
	 * Gets the campaign content local service.
	 *
	 * @return the campaign content local service
	 */
	public CampaignContentLocalService getCampaignContentLocalService() {
		return campaignContentLocalService;
	}

	/**
	 * Sets the campaign content local service.
	 *
	 * @param campaignContentLocalService the campaign content local service
	 */
	public void setCampaignContentLocalService(
		CampaignContentLocalService campaignContentLocalService) {
		this.campaignContentLocalService = campaignContentLocalService;
	}

	/**
	 * Gets the campaign content remote service.
	 *
	 * @return the campaign content remote service
	 */
	public CampaignContentService getCampaignContentService() {
		return campaignContentService;
	}

	/**
	 * Sets the campaign content remote service.
	 *
	 * @param campaignContentService the campaign content remote service
	 */
	public void setCampaignContentService(
		CampaignContentService campaignContentService) {
		this.campaignContentService = campaignContentService;
	}

	/**
	 * Gets the campaign content persistence.
	 *
	 * @return the campaign content persistence
	 */
	public CampaignContentPersistence getCampaignContentPersistence() {
		return campaignContentPersistence;
	}

	/**
	 * Sets the campaign content persistence.
	 *
	 * @param campaignContentPersistence the campaign content persistence
	 */
	public void setCampaignContentPersistence(
		CampaignContentPersistence campaignContentPersistence) {
		this.campaignContentPersistence = campaignContentPersistence;
	}

	/**
	 * Gets the campaign content finder.
	 *
	 * @return the campaign content finder
	 */
	public CampaignContentFinder getCampaignContentFinder() {
		return campaignContentFinder;
	}

	/**
	 * Sets the campaign content finder.
	 *
	 * @param campaignContentFinder the campaign content finder
	 */
	public void setCampaignContentFinder(
		CampaignContentFinder campaignContentFinder) {
		this.campaignContentFinder = campaignContentFinder;
	}

	/**
	 * Gets the contact local service.
	 *
	 * @return the contact local service
	 */
	public ContactLocalService getContactLocalService() {
		return contactLocalService;
	}

	/**
	 * Sets the contact local service.
	 *
	 * @param contactLocalService the contact local service
	 */
	public void setContactLocalService(ContactLocalService contactLocalService) {
		this.contactLocalService = contactLocalService;
	}

	/**
	 * Gets the contact remote service.
	 *
	 * @return the contact remote service
	 */
	public ContactService getContactService() {
		return contactService;
	}

	/**
	 * Sets the contact remote service.
	 *
	 * @param contactService the contact remote service
	 */
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * Gets the contact persistence.
	 *
	 * @return the contact persistence
	 */
	public ContactPersistence getContactPersistence() {
		return contactPersistence;
	}

	/**
	 * Sets the contact persistence.
	 *
	 * @param contactPersistence the contact persistence
	 */
	public void setContactPersistence(ContactPersistence contactPersistence) {
		this.contactPersistence = contactPersistence;
	}

	/**
	 * Gets the contact finder.
	 *
	 * @return the contact finder
	 */
	public ContactFinder getContactFinder() {
		return contactFinder;
	}

	/**
	 * Sets the contact finder.
	 *
	 * @param contactFinder the contact finder
	 */
	public void setContactFinder(ContactFinder contactFinder) {
		this.contactFinder = contactFinder;
	}

	/**
	 * Gets the newsletter log local service.
	 *
	 * @return the newsletter log local service
	 */
	public NewsletterLogLocalService getNewsletterLogLocalService() {
		return newsletterLogLocalService;
	}

	/**
	 * Sets the newsletter log local service.
	 *
	 * @param newsletterLogLocalService the newsletter log local service
	 */
	public void setNewsletterLogLocalService(
		NewsletterLogLocalService newsletterLogLocalService) {
		this.newsletterLogLocalService = newsletterLogLocalService;
	}

	/**
	 * Gets the newsletter log persistence.
	 *
	 * @return the newsletter log persistence
	 */
	public NewsletterLogPersistence getNewsletterLogPersistence() {
		return newsletterLogPersistence;
	}

	/**
	 * Sets the newsletter log persistence.
	 *
	 * @param newsletterLogPersistence the newsletter log persistence
	 */
	public void setNewsletterLogPersistence(
		NewsletterLogPersistence newsletterLogPersistence) {
		this.newsletterLogPersistence = newsletterLogPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = contactPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CampaignLocalService.class)
	protected CampaignLocalService campaignLocalService;
	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignContentLocalService.class)
	protected CampaignContentLocalService campaignContentLocalService;
	@BeanReference(type = CampaignContentService.class)
	protected CampaignContentService campaignContentService;
	@BeanReference(type = CampaignContentPersistence.class)
	protected CampaignContentPersistence campaignContentPersistence;
	@BeanReference(type = CampaignContentFinder.class)
	protected CampaignContentFinder campaignContentFinder;
	@BeanReference(type = ContactLocalService.class)
	protected ContactLocalService contactLocalService;
	@BeanReference(type = ContactService.class)
	protected ContactService contactService;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = ContactFinder.class)
	protected ContactFinder contactFinder;
	@BeanReference(type = NewsletterLogLocalService.class)
	protected NewsletterLogLocalService newsletterLogLocalService;
	@BeanReference(type = NewsletterLogPersistence.class)
	protected NewsletterLogPersistence newsletterLogPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
}