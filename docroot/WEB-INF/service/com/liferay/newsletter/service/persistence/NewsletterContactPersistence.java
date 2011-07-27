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

package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.NewsletterContact;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the newsletter contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterContactPersistenceImpl
 * @see NewsletterContactUtil
 * @generated
 */
public interface NewsletterContactPersistence extends BasePersistence<NewsletterContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterContactUtil} to access the newsletter contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the newsletter contact in the entity cache if it is enabled.
	*
	* @param newsletterContact the newsletter contact
	*/
	public void cacheResult(
		com.liferay.newsletter.model.NewsletterContact newsletterContact);

	/**
	* Caches the newsletter contacts in the entity cache if it is enabled.
	*
	* @param newsletterContacts the newsletter contacts
	*/
	public void cacheResult(
		java.util.List<com.liferay.newsletter.model.NewsletterContact> newsletterContacts);

	/**
	* Creates a new newsletter contact with the primary key. Does not add the newsletter contact to the database.
	*
	* @param contactId the primary key for the new newsletter contact
	* @return the new newsletter contact
	*/
	public com.liferay.newsletter.model.NewsletterContact create(long contactId);

	/**
	* Removes the newsletter contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the newsletter contact
	* @return the newsletter contact that was removed
	* @throws com.liferay.newsletter.NoSuchContactException if a newsletter contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact remove(long contactId)
		throws com.liferay.newsletter.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.newsletter.model.NewsletterContact updateImpl(
		com.liferay.newsletter.model.NewsletterContact newsletterContact,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter contact with the primary key or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
	*
	* @param contactId the primary key of the newsletter contact
	* @return the newsletter contact
	* @throws com.liferay.newsletter.NoSuchContactException if a newsletter contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact findByPrimaryKey(
		long contactId)
		throws com.liferay.newsletter.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the newsletter contact
	* @return the newsletter contact, or <code>null</code> if a newsletter contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact fetchByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter contact where email = &#63; or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
	*
	* @param email the email
	* @return the matching newsletter contact
	* @throws com.liferay.newsletter.NoSuchContactException if a matching newsletter contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact findByEmail(
		java.lang.String email)
		throws com.liferay.newsletter.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter contact where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching newsletter contact, or <code>null</code> if a matching newsletter contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the newsletter contact where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching newsletter contact, or <code>null</code> if a matching newsletter contact could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.newsletter.model.NewsletterContact fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the newsletter contacts.
	*
	* @return the newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the newsletter contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter contacts
	* @param end the upper bound of the range of newsletter contacts (not inclusive)
	* @return the range of newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the newsletter contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of newsletter contacts
	* @param end the upper bound of the range of newsletter contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.newsletter.model.NewsletterContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the newsletter contact where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmail(java.lang.String email)
		throws com.liferay.newsletter.NoSuchContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the newsletter contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of newsletter contacts where email = &#63;.
	*
	* @param email the email
	* @return the number of matching newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of newsletter contacts.
	*
	* @return the number of newsletter contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public NewsletterContact remove(NewsletterContact newsletterContact)
		throws SystemException;
}