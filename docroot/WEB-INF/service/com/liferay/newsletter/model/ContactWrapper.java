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
 * This class is a wrapper for {@link Contact}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       Contact
 * @generated
 */
public class ContactWrapper implements Contact {
	public ContactWrapper(Contact contact) {
		_contact = contact;
	}

	/**
	* Gets the primary key of this contact.
	*
	* @return the primary key of this contact
	*/
	public long getPrimaryKey() {
		return _contact.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact
	*
	* @param pk the primary key of this contact
	*/
	public void setPrimaryKey(long pk) {
		_contact.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this contact.
	*
	* @return the uuid of this contact
	*/
	public java.lang.String getUuid() {
		return _contact.getUuid();
	}

	/**
	* Sets the uuid of this contact.
	*
	* @param uuid the uuid of this contact
	*/
	public void setUuid(java.lang.String uuid) {
		_contact.setUuid(uuid);
	}

	/**
	* Gets the contact ID of this contact.
	*
	* @return the contact ID of this contact
	*/
	public long getContactId() {
		return _contact.getContactId();
	}

	/**
	* Sets the contact ID of this contact.
	*
	* @param contactId the contact ID of this contact
	*/
	public void setContactId(long contactId) {
		_contact.setContactId(contactId);
	}

	/**
	* Gets the email of this contact.
	*
	* @return the email of this contact
	*/
	public java.lang.String getEmail() {
		return _contact.getEmail();
	}

	/**
	* Sets the email of this contact.
	*
	* @param email the email of this contact
	*/
	public void setEmail(java.lang.String email) {
		_contact.setEmail(email);
	}

	/**
	* Gets the name of this contact.
	*
	* @return the name of this contact
	*/
	public java.lang.String getName() {
		return _contact.getName();
	}

	/**
	* Sets the name of this contact.
	*
	* @param name the name of this contact
	*/
	public void setName(java.lang.String name) {
		_contact.setName(name);
	}

	public boolean isNew() {
		return _contact.isNew();
	}

	public void setNew(boolean n) {
		_contact.setNew(n);
	}

	public boolean isCachedModel() {
		return _contact.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contact.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contact.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_contact.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contact.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contact.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contact.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new ContactWrapper((Contact)_contact.clone());
	}

	public int compareTo(com.liferay.newsletter.model.Contact contact) {
		return _contact.compareTo(contact);
	}

	public int hashCode() {
		return _contact.hashCode();
	}

	public com.liferay.newsletter.model.Contact toEscapedModel() {
		return new ContactWrapper(_contact.toEscapedModel());
	}

	public java.lang.String toString() {
		return _contact.toString();
	}

	public java.lang.String toXmlString() {
		return _contact.toXmlString();
	}

	public Contact getWrappedContact() {
		return _contact;
	}

	private Contact _contact;
}