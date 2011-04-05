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
 * This class is a wrapper for {@link SendCampaign}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       SendCampaign
 * @generated
 */
public class SendCampaignWrapper implements SendCampaign {
	public SendCampaignWrapper(SendCampaign sendCampaign) {
		_sendCampaign = sendCampaign;
	}

	public Class<?> getModelClass() {
		return SendCampaign.class;
	}

	public String getModelClassName() {
		return SendCampaign.class.getName();
	}

	/**
	* Gets the primary key of this send campaign.
	*
	* @return the primary key of this send campaign
	*/
	public long getPrimaryKey() {
		return _sendCampaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this send campaign
	*
	* @param pk the primary key of this send campaign
	*/
	public void setPrimaryKey(long pk) {
		_sendCampaign.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this send campaign.
	*
	* @return the uuid of this send campaign
	*/
	public java.lang.String getUuid() {
		return _sendCampaign.getUuid();
	}

	/**
	* Sets the uuid of this send campaign.
	*
	* @param uuid the uuid of this send campaign
	*/
	public void setUuid(java.lang.String uuid) {
		_sendCampaign.setUuid(uuid);
	}

	/**
	* Gets the send campaign ID of this send campaign.
	*
	* @return the send campaign ID of this send campaign
	*/
	public long getSendCampaignId() {
		return _sendCampaign.getSendCampaignId();
	}

	/**
	* Sets the send campaign ID of this send campaign.
	*
	* @param sendCampaignId the send campaign ID of this send campaign
	*/
	public void setSendCampaignId(long sendCampaignId) {
		_sendCampaign.setSendCampaignId(sendCampaignId);
	}

	/**
	* Gets the send date of this send campaign.
	*
	* @return the send date of this send campaign
	*/
	public java.util.Date getSendDate() {
		return _sendCampaign.getSendDate();
	}

	/**
	* Sets the send date of this send campaign.
	*
	* @param sendDate the send date of this send campaign
	*/
	public void setSendDate(java.util.Date sendDate) {
		_sendCampaign.setSendDate(sendDate);
	}

	/**
	* Gets the email subject of this send campaign.
	*
	* @return the email subject of this send campaign
	*/
	public java.lang.String getEmailSubject() {
		return _sendCampaign.getEmailSubject();
	}

	/**
	* Sets the email subject of this send campaign.
	*
	* @param emailSubject the email subject of this send campaign
	*/
	public void setEmailSubject(java.lang.String emailSubject) {
		_sendCampaign.setEmailSubject(emailSubject);
	}

	/**
	* Gets the sender name of this send campaign.
	*
	* @return the sender name of this send campaign
	*/
	public java.lang.String getSenderName() {
		return _sendCampaign.getSenderName();
	}

	/**
	* Sets the sender name of this send campaign.
	*
	* @param senderName the sender name of this send campaign
	*/
	public void setSenderName(java.lang.String senderName) {
		_sendCampaign.setSenderName(senderName);
	}

	/**
	* Gets the sender email of this send campaign.
	*
	* @return the sender email of this send campaign
	*/
	public java.lang.String getSenderEmail() {
		return _sendCampaign.getSenderEmail();
	}

	/**
	* Sets the sender email of this send campaign.
	*
	* @param senderEmail the sender email of this send campaign
	*/
	public void setSenderEmail(java.lang.String senderEmail) {
		_sendCampaign.setSenderEmail(senderEmail);
	}

	/**
	* Gets the sent of this send campaign.
	*
	* @return the sent of this send campaign
	*/
	public boolean getSent() {
		return _sendCampaign.getSent();
	}

	/**
	* Determines if this send campaign is sent.
	*
	* @return <code>true</code> if this send campaign is sent; <code>false</code> otherwise
	*/
	public boolean isSent() {
		return _sendCampaign.isSent();
	}

	/**
	* Sets whether this send campaign is sent.
	*
	* @param sent the sent of this send campaign
	*/
	public void setSent(boolean sent) {
		_sendCampaign.setSent(sent);
	}

	/**
	* Gets the campaign ID of this send campaign.
	*
	* @return the campaign ID of this send campaign
	*/
	public long getCampaignId() {
		return _sendCampaign.getCampaignId();
	}

	/**
	* Sets the campaign ID of this send campaign.
	*
	* @param campaignId the campaign ID of this send campaign
	*/
	public void setCampaignId(long campaignId) {
		_sendCampaign.setCampaignId(campaignId);
	}

	public boolean isNew() {
		return _sendCampaign.isNew();
	}

	public void setNew(boolean n) {
		_sendCampaign.setNew(n);
	}

	public boolean isCachedModel() {
		return _sendCampaign.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sendCampaign.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sendCampaign.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_sendCampaign.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sendCampaign.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sendCampaign.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sendCampaign.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new SendCampaignWrapper((SendCampaign)_sendCampaign.clone());
	}

	public int compareTo(com.liferay.newsletter.model.SendCampaign sendCampaign) {
		return _sendCampaign.compareTo(sendCampaign);
	}

	public int hashCode() {
		return _sendCampaign.hashCode();
	}

	public com.liferay.newsletter.model.SendCampaign toEscapedModel() {
		return new SendCampaignWrapper(_sendCampaign.toEscapedModel());
	}

	public java.lang.String toString() {
		return _sendCampaign.toString();
	}

	public java.lang.String toXmlString() {
		return _sendCampaign.toXmlString();
	}

	public SendCampaign getWrappedSendCampaign() {
		return _sendCampaign;
	}

	public void resetOriginalValues() {
		_sendCampaign.resetOriginalValues();
	}

	private SendCampaign _sendCampaign;
}