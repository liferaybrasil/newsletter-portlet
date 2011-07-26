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
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       Campaign
 * @generated
 */
public class CampaignWrapper implements Campaign {
	public CampaignWrapper(Campaign campaign) {
		_campaign = campaign;
	}

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	/**
	* Returns the primary key of this campaign.
	*
	* @return the primary key of this campaign
	*/
	public long getPrimaryKey() {
		return _campaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign.
	*
	* @param primaryKey the primary key of this campaign
	*/
	public void setPrimaryKey(long primaryKey) {
		_campaign.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this campaign.
	*
	* @return the uuid of this campaign
	*/
	public java.lang.String getUuid() {
		return _campaign.getUuid();
	}

	/**
	* Sets the uuid of this campaign.
	*
	* @param uuid the uuid of this campaign
	*/
	public void setUuid(java.lang.String uuid) {
		_campaign.setUuid(uuid);
	}

	/**
	* Returns the campaign ID of this campaign.
	*
	* @return the campaign ID of this campaign
	*/
	public long getCampaignId() {
		return _campaign.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign.
	*
	* @param campaignId the campaign ID of this campaign
	*/
	public void setCampaignId(long campaignId) {
		_campaign.setCampaignId(campaignId);
	}

	/**
	* Returns the send date of this campaign.
	*
	* @return the send date of this campaign
	*/
	public java.util.Date getSendDate() {
		return _campaign.getSendDate();
	}

	/**
	* Sets the send date of this campaign.
	*
	* @param sendDate the send date of this campaign
	*/
	public void setSendDate(java.util.Date sendDate) {
		_campaign.setSendDate(sendDate);
	}

	/**
	* Returns the email subject of this campaign.
	*
	* @return the email subject of this campaign
	*/
	public java.lang.String getEmailSubject() {
		return _campaign.getEmailSubject();
	}

	/**
	* Sets the email subject of this campaign.
	*
	* @param emailSubject the email subject of this campaign
	*/
	public void setEmailSubject(java.lang.String emailSubject) {
		_campaign.setEmailSubject(emailSubject);
	}

	/**
	* Returns the sender name of this campaign.
	*
	* @return the sender name of this campaign
	*/
	public java.lang.String getSenderName() {
		return _campaign.getSenderName();
	}

	/**
	* Sets the sender name of this campaign.
	*
	* @param senderName the sender name of this campaign
	*/
	public void setSenderName(java.lang.String senderName) {
		_campaign.setSenderName(senderName);
	}

	/**
	* Returns the sender email of this campaign.
	*
	* @return the sender email of this campaign
	*/
	public java.lang.String getSenderEmail() {
		return _campaign.getSenderEmail();
	}

	/**
	* Sets the sender email of this campaign.
	*
	* @param senderEmail the sender email of this campaign
	*/
	public void setSenderEmail(java.lang.String senderEmail) {
		_campaign.setSenderEmail(senderEmail);
	}

	/**
	* Returns the content of this campaign.
	*
	* @return the content of this campaign
	*/
	public java.lang.String getContent() {
		return _campaign.getContent();
	}

	/**
	* Sets the content of this campaign.
	*
	* @param content the content of this campaign
	*/
	public void setContent(java.lang.String content) {
		_campaign.setContent(content);
	}

	/**
	* Returns the sent of this campaign.
	*
	* @return the sent of this campaign
	*/
	public boolean getSent() {
		return _campaign.getSent();
	}

	/**
	* Returns <code>true</code> if this campaign is sent.
	*
	* @return <code>true</code> if this campaign is sent; <code>false</code> otherwise
	*/
	public boolean isSent() {
		return _campaign.isSent();
	}

	/**
	* Sets whether this campaign is sent.
	*
	* @param sent the sent of this campaign
	*/
	public void setSent(boolean sent) {
		_campaign.setSent(sent);
	}

	/**
	* Returns the campaign content ID of this campaign.
	*
	* @return the campaign content ID of this campaign
	*/
	public long getCampaignContentId() {
		return _campaign.getCampaignContentId();
	}

	/**
	* Sets the campaign content ID of this campaign.
	*
	* @param campaignContentId the campaign content ID of this campaign
	*/
	public void setCampaignContentId(long campaignContentId) {
		_campaign.setCampaignContentId(campaignContentId);
	}

	public boolean isNew() {
		return _campaign.isNew();
	}

	public void setNew(boolean n) {
		_campaign.setNew(n);
	}

	public boolean isCachedModel() {
		return _campaign.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_campaign.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _campaign.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_campaign.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _campaign.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaign.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaign.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaign.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignWrapper((Campaign)_campaign.clone());
	}

	public int compareTo(com.liferay.newsletter.model.Campaign campaign) {
		return _campaign.compareTo(campaign);
	}

	@Override
	public int hashCode() {
		return _campaign.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.newsletter.model.Campaign> toCacheModel() {
		return _campaign.toCacheModel();
	}

	public com.liferay.newsletter.model.Campaign toEscapedModel() {
		return new CampaignWrapper(_campaign.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaign.toString();
	}

	public java.lang.String toXmlString() {
		return _campaign.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaign.persist();
	}

	public Campaign getWrappedCampaign() {
		return _campaign;
	}

	public void resetOriginalValues() {
		_campaign.resetOriginalValues();
	}

	private Campaign _campaign;
}