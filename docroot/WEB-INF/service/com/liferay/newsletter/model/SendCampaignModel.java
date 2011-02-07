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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SendCampaign service. Represents a row in the &quot;Newsletter_SendCampaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.newsletter.model.impl.SendCampaignModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.newsletter.model.impl.SendCampaignImpl}.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see SendCampaign
 * @see com.liferay.newsletter.model.impl.SendCampaignImpl
 * @see com.liferay.newsletter.model.impl.SendCampaignModelImpl
 * @generated
 */
public interface SendCampaignModel extends BaseModel<SendCampaign> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a send campaign model instance should use the {@link SendCampaign} interface instead.
	 */

	/**
	 * Gets the primary key of this send campaign.
	 *
	 * @return the primary key of this send campaign
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this send campaign
	 *
	 * @param pk the primary key of this send campaign
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this send campaign.
	 *
	 * @return the uuid of this send campaign
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this send campaign.
	 *
	 * @param uuid the uuid of this send campaign
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the send campaign ID of this send campaign.
	 *
	 * @return the send campaign ID of this send campaign
	 */
	public long getSendCampaignId();

	/**
	 * Sets the send campaign ID of this send campaign.
	 *
	 * @param sendCampaignId the send campaign ID of this send campaign
	 */
	public void setSendCampaignId(long sendCampaignId);

	/**
	 * Gets the send date of this send campaign.
	 *
	 * @return the send date of this send campaign
	 */
	public Date getSendDate();

	/**
	 * Sets the send date of this send campaign.
	 *
	 * @param sendDate the send date of this send campaign
	 */
	public void setSendDate(Date sendDate);

	/**
	 * Gets the email subject of this send campaign.
	 *
	 * @return the email subject of this send campaign
	 */
	@AutoEscape
	public String getEmailSubject();

	/**
	 * Sets the email subject of this send campaign.
	 *
	 * @param emailSubject the email subject of this send campaign
	 */
	public void setEmailSubject(String emailSubject);

	/**
	 * Gets the sender name of this send campaign.
	 *
	 * @return the sender name of this send campaign
	 */
	@AutoEscape
	public String getSenderName();

	/**
	 * Sets the sender name of this send campaign.
	 *
	 * @param senderName the sender name of this send campaign
	 */
	public void setSenderName(String senderName);

	/**
	 * Gets the sender email of this send campaign.
	 *
	 * @return the sender email of this send campaign
	 */
	@AutoEscape
	public String getSenderEmail();

	/**
	 * Sets the sender email of this send campaign.
	 *
	 * @param senderEmail the sender email of this send campaign
	 */
	public void setSenderEmail(String senderEmail);

	/**
	 * Gets the sent of this send campaign.
	 *
	 * @return the sent of this send campaign
	 */
	public boolean getSent();

	/**
	 * Determines if this send campaign is sent.
	 *
	 * @return <code>true</code> if this send campaign is sent; <code>false</code> otherwise
	 */
	public boolean isSent();

	/**
	 * Sets whether this send campaign is sent.
	 *
	 * @param sent the sent of this send campaign
	 */
	public void setSent(boolean sent);

	/**
	 * Gets the campaign ID of this send campaign.
	 *
	 * @return the campaign ID of this send campaign
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this send campaign.
	 *
	 * @param campaignId the campaign ID of this send campaign
	 */
	public void setCampaignId(long campaignId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(SendCampaign sendCampaign);

	public int hashCode();

	public SendCampaign toEscapedModel();

	public String toString();

	public String toXmlString();
}