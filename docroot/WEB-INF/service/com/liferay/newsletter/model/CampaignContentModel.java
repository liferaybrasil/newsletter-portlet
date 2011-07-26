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

package com.liferay.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CampaignContent service. Represents a row in the &quot;Newsletter_CampaignContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.newsletter.model.impl.CampaignContentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.newsletter.model.impl.CampaignContentImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContent
 * @see com.liferay.newsletter.model.impl.CampaignContentImpl
 * @see com.liferay.newsletter.model.impl.CampaignContentModelImpl
 * @generated
 */
public interface CampaignContentModel extends BaseModel<CampaignContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign content model instance should use the {@link CampaignContent} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign content.
	 *
	 * @return the primary key of this campaign content
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign content.
	 *
	 * @param primaryKey the primary key of this campaign content
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this campaign content.
	 *
	 * @return the uuid of this campaign content
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this campaign content.
	 *
	 * @param uuid the uuid of this campaign content
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the campaign content ID of this campaign content.
	 *
	 * @return the campaign content ID of this campaign content
	 */
	public long getCampaignContentId();

	/**
	 * Sets the campaign content ID of this campaign content.
	 *
	 * @param campaignContentId the campaign content ID of this campaign content
	 */
	public void setCampaignContentId(long campaignContentId);

	/**
	 * Returns the title of this campaign content.
	 *
	 * @return the title of this campaign content
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this campaign content.
	 *
	 * @param title the title of this campaign content
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this campaign content.
	 *
	 * @return the content of this campaign content
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this campaign content.
	 *
	 * @param content the content of this campaign content
	 */
	public void setContent(String content);

	/**
	 * Returns the create date of this campaign content.
	 *
	 * @return the create date of this campaign content
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this campaign content.
	 *
	 * @param createDate the create date of this campaign content
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the article ID of this campaign content.
	 *
	 * @return the article ID of this campaign content
	 */
	public long getArticleId();

	/**
	 * Sets the article ID of this campaign content.
	 *
	 * @param articleId the article ID of this campaign content
	 */
	public void setArticleId(long articleId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CampaignContent campaignContent);

	public int hashCode();

	public CacheModel<CampaignContent> toCacheModel();

	public CampaignContent toEscapedModel();

	public String toString();

	public String toXmlString();
}