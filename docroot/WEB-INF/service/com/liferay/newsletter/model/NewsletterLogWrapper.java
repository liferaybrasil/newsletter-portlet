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
 * This class is a wrapper for {@link NewsletterLog}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       NewsletterLog
 * @generated
 */
public class NewsletterLogWrapper implements NewsletterLog {
	public NewsletterLogWrapper(NewsletterLog newsletterLog) {
		_newsletterLog = newsletterLog;
	}

	public Class<?> getModelClass() {
		return NewsletterLog.class;
	}

	public String getModelClassName() {
		return NewsletterLog.class.getName();
	}

	/**
	* Gets the primary key of this newsletter log.
	*
	* @return the primary key of this newsletter log
	*/
	public long getPrimaryKey() {
		return _newsletterLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this newsletter log
	*
	* @param pk the primary key of this newsletter log
	*/
	public void setPrimaryKey(long pk) {
		_newsletterLog.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this newsletter log.
	*
	* @return the uuid of this newsletter log
	*/
	public java.lang.String getUuid() {
		return _newsletterLog.getUuid();
	}

	/**
	* Sets the uuid of this newsletter log.
	*
	* @param uuid the uuid of this newsletter log
	*/
	public void setUuid(java.lang.String uuid) {
		_newsletterLog.setUuid(uuid);
	}

	/**
	* Gets the newsletter log ID of this newsletter log.
	*
	* @return the newsletter log ID of this newsletter log
	*/
	public long getNewsletterLogId() {
		return _newsletterLog.getNewsletterLogId();
	}

	/**
	* Sets the newsletter log ID of this newsletter log.
	*
	* @param newsletterLogId the newsletter log ID of this newsletter log
	*/
	public void setNewsletterLogId(long newsletterLogId) {
		_newsletterLog.setNewsletterLogId(newsletterLogId);
	}

	/**
	* Gets the campaign ID of this newsletter log.
	*
	* @return the campaign ID of this newsletter log
	*/
	public long getCampaignId() {
		return _newsletterLog.getCampaignId();
	}

	/**
	* Sets the campaign ID of this newsletter log.
	*
	* @param campaignId the campaign ID of this newsletter log
	*/
	public void setCampaignId(long campaignId) {
		_newsletterLog.setCampaignId(campaignId);
	}

	/**
	* Gets the contact ID of this newsletter log.
	*
	* @return the contact ID of this newsletter log
	*/
	public long getContactId() {
		return _newsletterLog.getContactId();
	}

	/**
	* Sets the contact ID of this newsletter log.
	*
	* @param contactId the contact ID of this newsletter log
	*/
	public void setContactId(long contactId) {
		_newsletterLog.setContactId(contactId);
	}

	/**
	* Gets the sent of this newsletter log.
	*
	* @return the sent of this newsletter log
	*/
	public boolean getSent() {
		return _newsletterLog.getSent();
	}

	/**
	* Determines if this newsletter log is sent.
	*
	* @return <code>true</code> if this newsletter log is sent; <code>false</code> otherwise
	*/
	public boolean isSent() {
		return _newsletterLog.isSent();
	}

	/**
	* Sets whether this newsletter log is sent.
	*
	* @param sent the sent of this newsletter log
	*/
	public void setSent(boolean sent) {
		_newsletterLog.setSent(sent);
	}

	public boolean isNew() {
		return _newsletterLog.isNew();
	}

	public void setNew(boolean n) {
		_newsletterLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _newsletterLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_newsletterLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _newsletterLog.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_newsletterLog.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _newsletterLog.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _newsletterLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_newsletterLog.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new NewsletterLogWrapper((NewsletterLog)_newsletterLog.clone());
	}

	public int compareTo(
		com.liferay.newsletter.model.NewsletterLog newsletterLog) {
		return _newsletterLog.compareTo(newsletterLog);
	}

	public int hashCode() {
		return _newsletterLog.hashCode();
	}

	public com.liferay.newsletter.model.NewsletterLog toEscapedModel() {
		return new NewsletterLogWrapper(_newsletterLog.toEscapedModel());
	}

	public java.lang.String toString() {
		return _newsletterLog.toString();
	}

	public java.lang.String toXmlString() {
		return _newsletterLog.toXmlString();
	}

	public NewsletterLog getWrappedNewsletterLog() {
		return _newsletterLog;
	}

	public void resetOriginalValues() {
		_newsletterLog.resetOriginalValues();
	}

	private NewsletterLog _newsletterLog;
}