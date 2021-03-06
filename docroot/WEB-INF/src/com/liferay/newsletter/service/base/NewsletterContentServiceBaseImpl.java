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

import com.liferay.counter.service.CounterLocalService;

import com.liferay.newsletter.model.NewsletterContent;
import com.liferay.newsletter.service.NewsletterCampaignLocalService;
import com.liferay.newsletter.service.NewsletterCampaignService;
import com.liferay.newsletter.service.NewsletterContactLocalService;
import com.liferay.newsletter.service.NewsletterContentLocalService;
import com.liferay.newsletter.service.NewsletterContentService;
import com.liferay.newsletter.service.NewsletterLogLocalService;
import com.liferay.newsletter.service.persistence.NewsletterCampaignPersistence;
import com.liferay.newsletter.service.persistence.NewsletterContactFinder;
import com.liferay.newsletter.service.persistence.NewsletterContactPersistence;
import com.liferay.newsletter.service.persistence.NewsletterContentFinder;
import com.liferay.newsletter.service.persistence.NewsletterContentPersistence;
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

import javax.sql.DataSource;

/**
 * The base implementation of the newsletter content remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.newsletter.service.impl.NewsletterContentServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.newsletter.service.impl.NewsletterContentServiceImpl
 * @see com.liferay.newsletter.service.NewsletterContentServiceUtil
 * @generated
 */
public abstract class NewsletterContentServiceBaseImpl extends PrincipalBean
	implements NewsletterContentService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.newsletter.service.NewsletterContentServiceUtil} to access the newsletter content remote service.
	 */

	/**
	 * Returns the newsletter campaign local service.
	 *
	 * @return the newsletter campaign local service
	 */
	public NewsletterCampaignLocalService getNewsletterCampaignLocalService() {
		return newsletterCampaignLocalService;
	}

	/**
	 * Sets the newsletter campaign local service.
	 *
	 * @param newsletterCampaignLocalService the newsletter campaign local service
	 */
	public void setNewsletterCampaignLocalService(
		NewsletterCampaignLocalService newsletterCampaignLocalService) {
		this.newsletterCampaignLocalService = newsletterCampaignLocalService;
	}

	/**
	 * Returns the newsletter campaign remote service.
	 *
	 * @return the newsletter campaign remote service
	 */
	public NewsletterCampaignService getNewsletterCampaignService() {
		return newsletterCampaignService;
	}

	/**
	 * Sets the newsletter campaign remote service.
	 *
	 * @param newsletterCampaignService the newsletter campaign remote service
	 */
	public void setNewsletterCampaignService(
		NewsletterCampaignService newsletterCampaignService) {
		this.newsletterCampaignService = newsletterCampaignService;
	}

	/**
	 * Returns the newsletter campaign persistence.
	 *
	 * @return the newsletter campaign persistence
	 */
	public NewsletterCampaignPersistence getNewsletterCampaignPersistence() {
		return newsletterCampaignPersistence;
	}

	/**
	 * Sets the newsletter campaign persistence.
	 *
	 * @param newsletterCampaignPersistence the newsletter campaign persistence
	 */
	public void setNewsletterCampaignPersistence(
		NewsletterCampaignPersistence newsletterCampaignPersistence) {
		this.newsletterCampaignPersistence = newsletterCampaignPersistence;
	}

	/**
	 * Returns the newsletter contact local service.
	 *
	 * @return the newsletter contact local service
	 */
	public NewsletterContactLocalService getNewsletterContactLocalService() {
		return newsletterContactLocalService;
	}

	/**
	 * Sets the newsletter contact local service.
	 *
	 * @param newsletterContactLocalService the newsletter contact local service
	 */
	public void setNewsletterContactLocalService(
		NewsletterContactLocalService newsletterContactLocalService) {
		this.newsletterContactLocalService = newsletterContactLocalService;
	}

	/**
	 * Returns the newsletter contact persistence.
	 *
	 * @return the newsletter contact persistence
	 */
	public NewsletterContactPersistence getNewsletterContactPersistence() {
		return newsletterContactPersistence;
	}

	/**
	 * Sets the newsletter contact persistence.
	 *
	 * @param newsletterContactPersistence the newsletter contact persistence
	 */
	public void setNewsletterContactPersistence(
		NewsletterContactPersistence newsletterContactPersistence) {
		this.newsletterContactPersistence = newsletterContactPersistence;
	}

	/**
	 * Returns the newsletter contact finder.
	 *
	 * @return the newsletter contact finder
	 */
	public NewsletterContactFinder getNewsletterContactFinder() {
		return newsletterContactFinder;
	}

	/**
	 * Sets the newsletter contact finder.
	 *
	 * @param newsletterContactFinder the newsletter contact finder
	 */
	public void setNewsletterContactFinder(
		NewsletterContactFinder newsletterContactFinder) {
		this.newsletterContactFinder = newsletterContactFinder;
	}

	/**
	 * Returns the newsletter content local service.
	 *
	 * @return the newsletter content local service
	 */
	public NewsletterContentLocalService getNewsletterContentLocalService() {
		return newsletterContentLocalService;
	}

	/**
	 * Sets the newsletter content local service.
	 *
	 * @param newsletterContentLocalService the newsletter content local service
	 */
	public void setNewsletterContentLocalService(
		NewsletterContentLocalService newsletterContentLocalService) {
		this.newsletterContentLocalService = newsletterContentLocalService;
	}

	/**
	 * Returns the newsletter content remote service.
	 *
	 * @return the newsletter content remote service
	 */
	public NewsletterContentService getNewsletterContentService() {
		return newsletterContentService;
	}

	/**
	 * Sets the newsletter content remote service.
	 *
	 * @param newsletterContentService the newsletter content remote service
	 */
	public void setNewsletterContentService(
		NewsletterContentService newsletterContentService) {
		this.newsletterContentService = newsletterContentService;
	}

	/**
	 * Returns the newsletter content persistence.
	 *
	 * @return the newsletter content persistence
	 */
	public NewsletterContentPersistence getNewsletterContentPersistence() {
		return newsletterContentPersistence;
	}

	/**
	 * Sets the newsletter content persistence.
	 *
	 * @param newsletterContentPersistence the newsletter content persistence
	 */
	public void setNewsletterContentPersistence(
		NewsletterContentPersistence newsletterContentPersistence) {
		this.newsletterContentPersistence = newsletterContentPersistence;
	}

	/**
	 * Returns the newsletter content finder.
	 *
	 * @return the newsletter content finder
	 */
	public NewsletterContentFinder getNewsletterContentFinder() {
		return newsletterContentFinder;
	}

	/**
	 * Sets the newsletter content finder.
	 *
	 * @param newsletterContentFinder the newsletter content finder
	 */
	public void setNewsletterContentFinder(
		NewsletterContentFinder newsletterContentFinder) {
		this.newsletterContentFinder = newsletterContentFinder;
	}

	/**
	 * Returns the newsletter log local service.
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
	 * Returns the newsletter log persistence.
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
	 * Returns the counter local service.
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
	 * Returns the resource local service.
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
	 * Returns the resource remote service.
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
	 * Returns the resource persistence.
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
	 * Returns the user local service.
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
	 * Returns the user remote service.
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
	 * Returns the user persistence.
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

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
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

	protected Class<?> getModelClass() {
		return NewsletterContent.class;
	}

	protected String getModelClassName() {
		return NewsletterContent.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = newsletterContentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = NewsletterCampaignLocalService.class)
	protected NewsletterCampaignLocalService newsletterCampaignLocalService;
	@BeanReference(type = NewsletterCampaignService.class)
	protected NewsletterCampaignService newsletterCampaignService;
	@BeanReference(type = NewsletterCampaignPersistence.class)
	protected NewsletterCampaignPersistence newsletterCampaignPersistence;
	@BeanReference(type = NewsletterContactLocalService.class)
	protected NewsletterContactLocalService newsletterContactLocalService;
	@BeanReference(type = NewsletterContactPersistence.class)
	protected NewsletterContactPersistence newsletterContactPersistence;
	@BeanReference(type = NewsletterContactFinder.class)
	protected NewsletterContactFinder newsletterContactFinder;
	@BeanReference(type = NewsletterContentLocalService.class)
	protected NewsletterContentLocalService newsletterContentLocalService;
	@BeanReference(type = NewsletterContentService.class)
	protected NewsletterContentService newsletterContentService;
	@BeanReference(type = NewsletterContentPersistence.class)
	protected NewsletterContentPersistence newsletterContentPersistence;
	@BeanReference(type = NewsletterContentFinder.class)
	protected NewsletterContentFinder newsletterContentFinder;
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