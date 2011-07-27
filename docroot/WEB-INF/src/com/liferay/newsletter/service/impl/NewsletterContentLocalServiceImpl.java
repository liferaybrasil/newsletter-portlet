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

package com.liferay.newsletter.service.impl;

import com.liferay.newsletter.ContentException;
import com.liferay.newsletter.TitleException;
import com.liferay.newsletter.model.NewsletterCampaign;
import com.liferay.newsletter.model.NewsletterContent;
import com.liferay.newsletter.service.base.NewsletterContentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterContentLocalServiceImpl
	extends NewsletterContentLocalServiceBaseImpl {

	public NewsletterContent addContent(
			long userId, long groupId, long articleId, String title,
			String content, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(title, content);

		long contentId = counterLocalService.increment();

		NewsletterContent newsletterContent =
			newsletterContentPersistence.create(contentId);

		newsletterContent.setUuid(serviceContext.getUuid());
		newsletterContent.setGroupId(groupId);
		newsletterContent.setCompanyId(user.getCompanyId());
		newsletterContent.setUserId(user.getUserId());
		newsletterContent.setUserName(user.getFullName());
		newsletterContent.setCreateDate(serviceContext.getCreateDate(now));
		newsletterContent.setModifiedDate(serviceContext.getModifiedDate(now));
		newsletterContent.setTitle(title);
		newsletterContent.setContent(content);

		return newsletterContentPersistence.update(newsletterContent, false);
	}

	public void deleteContent(NewsletterContent content)
		throws PortalException, SystemException {

		// Content

		newsletterContentPersistence.remove(content);

		// Campaigns

		List<NewsletterCampaign> campaigns = content.getCampaigns();

		for (NewsletterCampaign campaign : campaigns) {
			newsletterCampaignLocalService.deleteCampaign(campaign);
		}
	}

	public void deleteContent(long contentId)
		throws SystemException,	PortalException {

		NewsletterContent newsletterContent =
			newsletterContentPersistence.findByPrimaryKey(contentId);

		deleteContent(newsletterContent);
	}

	public NewsletterContent getContent(long contentId)
		throws PortalException, SystemException {

		return newsletterContentPersistence.findByPrimaryKey(contentId);
	}

	public List<NewsletterContent> getContents(
		String title, int start, int end) throws SystemException{

		return newsletterContentPersistence.findByTitle(title, start, end);
	}

	public void validate(String title, String content) throws PortalException {
		if (Validator.isNull(title)) {
			throw new TitleException();
		}
		else if (Validator.isNull(content)) {
			throw new ContentException();
		}
	}

}