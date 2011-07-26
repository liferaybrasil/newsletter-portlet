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

/**
 * <p>
 * This class is a wrapper for {@link CampaignContent}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignContent
 * @generated
 */
public class CampaignContentWrapper implements CampaignContent {
	public CampaignContentWrapper(CampaignContent campaignContent) {
		_campaignContent = campaignContent;
	}

	public Class<?> getModelClass() {
		return CampaignContent.class;
	}

	public String getModelClassName() {
		return CampaignContent.class.getName();
	}

	/**
	* Returns the primary key of this campaign content.
	*
	* @return the primary key of this campaign content
	*/
	public long getPrimaryKey() {
		return _campaignContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign content.
	*
	* @param primaryKey the primary key of this campaign content
	*/
	public void setPrimaryKey(long primaryKey) {
		_campaignContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this campaign content.
	*
	* @return the uuid of this campaign content
	*/
	public java.lang.String getUuid() {
		return _campaignContent.getUuid();
	}

	/**
	* Sets the uuid of this campaign content.
	*
	* @param uuid the uuid of this campaign content
	*/
	public void setUuid(java.lang.String uuid) {
		_campaignContent.setUuid(uuid);
	}

	/**
	* Returns the campaign content ID of this campaign content.
	*
	* @return the campaign content ID of this campaign content
	*/
	public long getCampaignContentId() {
		return _campaignContent.getCampaignContentId();
	}

	/**
	* Sets the campaign content ID of this campaign content.
	*
	* @param campaignContentId the campaign content ID of this campaign content
	*/
	public void setCampaignContentId(long campaignContentId) {
		_campaignContent.setCampaignContentId(campaignContentId);
	}

	/**
	* Returns the title of this campaign content.
	*
	* @return the title of this campaign content
	*/
	public java.lang.String getTitle() {
		return _campaignContent.getTitle();
	}

	/**
	* Sets the title of this campaign content.
	*
	* @param title the title of this campaign content
	*/
	public void setTitle(java.lang.String title) {
		_campaignContent.setTitle(title);
	}

	/**
	* Returns the content of this campaign content.
	*
	* @return the content of this campaign content
	*/
	public java.lang.String getContent() {
		return _campaignContent.getContent();
	}

	/**
	* Sets the content of this campaign content.
	*
	* @param content the content of this campaign content
	*/
	public void setContent(java.lang.String content) {
		_campaignContent.setContent(content);
	}

	/**
	* Returns the create date of this campaign content.
	*
	* @return the create date of this campaign content
	*/
	public java.util.Date getCreateDate() {
		return _campaignContent.getCreateDate();
	}

	/**
	* Sets the create date of this campaign content.
	*
	* @param createDate the create date of this campaign content
	*/
	public void setCreateDate(java.util.Date createDate) {
		_campaignContent.setCreateDate(createDate);
	}

	/**
	* Returns the article ID of this campaign content.
	*
	* @return the article ID of this campaign content
	*/
	public long getArticleId() {
		return _campaignContent.getArticleId();
	}

	/**
	* Sets the article ID of this campaign content.
	*
	* @param articleId the article ID of this campaign content
	*/
	public void setArticleId(long articleId) {
		_campaignContent.setArticleId(articleId);
	}

	public boolean isNew() {
		return _campaignContent.isNew();
	}

	public void setNew(boolean n) {
		_campaignContent.setNew(n);
	}

	public boolean isCachedModel() {
		return _campaignContent.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_campaignContent.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _campaignContent.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_campaignContent.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignContent.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignContent.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignContent.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignContentWrapper((CampaignContent)_campaignContent.clone());
	}

	public int compareTo(
		com.liferay.newsletter.model.CampaignContent campaignContent) {
		return _campaignContent.compareTo(campaignContent);
	}

	@Override
	public int hashCode() {
		return _campaignContent.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.newsletter.model.CampaignContent> toCacheModel() {
		return _campaignContent.toCacheModel();
	}

	public com.liferay.newsletter.model.CampaignContent toEscapedModel() {
		return new CampaignContentWrapper(_campaignContent.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignContent.toString();
	}

	public java.lang.String toXmlString() {
		return _campaignContent.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignContent.persist();
	}

	public CampaignContent getWrappedCampaignContent() {
		return _campaignContent;
	}

	public void resetOriginalValues() {
		_campaignContent.resetOriginalValues();
	}

	private CampaignContent _campaignContent;
}