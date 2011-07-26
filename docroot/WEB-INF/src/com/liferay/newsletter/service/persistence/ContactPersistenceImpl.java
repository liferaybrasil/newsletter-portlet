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

import com.liferay.newsletter.NoSuchContactException;
import com.liferay.newsletter.model.Contact;
import com.liferay.newsletter.model.impl.ContactImpl;
import com.liferay.newsletter.model.impl.ContactModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistence
 * @see ContactUtil
 * @generated
 */
public class ContactPersistenceImpl extends BasePersistenceImpl<Contact>
	implements ContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByEmail",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_NAME = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
			FINDER_CLASS_NAME_LIST, "findByName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, ContactImpl.class,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the contact in the entity cache if it is enabled.
	 *
	 * @param contact the contact
	 */
	public void cacheResult(Contact contact) {
		EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey(), contact);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { contact.getEmail() }, contact);

		contact.resetOriginalValues();
	}

	/**
	 * Caches the contacts in the entity cache if it is enabled.
	 *
	 * @param contacts the contacts
	 */
	public void cacheResult(List<Contact> contacts) {
		for (Contact contact : contacts) {
			if (EntityCacheUtil.getResult(
						ContactModelImpl.ENTITY_CACHE_ENABLED,
						ContactImpl.class, contact.getPrimaryKey(), this) == null) {
				cacheResult(contact);
			}
		}
	}

	/**
	 * Clears the cache for all contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contact contact) {
		EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { contact.getEmail() });
	}

	/**
	 * Creates a new contact with the primary key. Does not add the contact to the database.
	 *
	 * @param contactId the primary key for the new contact
	 * @return the new contact
	 */
	public Contact create(long contactId) {
		Contact contact = new ContactImpl();

		contact.setNew(true);
		contact.setPrimaryKey(contactId);

		String uuid = PortalUUIDUtil.generate();

		contact.setUuid(uuid);

		return contact;
	}

	/**
	 * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact
	 * @return the contact that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contact remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact that was removed
	 * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact remove(long contactId)
		throws NoSuchContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contact contact = (Contact)session.get(ContactImpl.class,
					Long.valueOf(contactId));

			if (contact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
				}

				throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					contactId);
			}

			return contactPersistence.remove(contact);
		}
		catch (NoSuchContactException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the contact from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contact the contact
	 * @return the contact that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contact remove(Contact contact) throws SystemException {
		return super.remove(contact);
	}

	@Override
	protected Contact removeImpl(Contact contact) throws SystemException {
		contact = toUnwrappedModel(contact);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contact);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ContactModelImpl contactModelImpl = (ContactModelImpl)contact;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { contactModelImpl.getEmail() });

		EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey());

		return contact;
	}

	@Override
	public Contact updateImpl(com.liferay.newsletter.model.Contact contact,
		boolean merge) throws SystemException {
		contact = toUnwrappedModel(contact);

		boolean isNew = contact.isNew();

		ContactModelImpl contactModelImpl = (ContactModelImpl)contact;

		if (Validator.isNull(contact.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			contact.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contact, merge);

			contact.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey(), contact);

		if (!isNew &&
				(!Validator.equals(contact.getEmail(),
					contactModelImpl.getOriginalEmail()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
				new Object[] { contactModelImpl.getOriginalEmail() });
		}

		if (isNew ||
				(!Validator.equals(contact.getEmail(),
					contactModelImpl.getOriginalEmail()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
				new Object[] { contact.getEmail() }, contact);
		}

		return contact;
	}

	protected Contact toUnwrappedModel(Contact contact) {
		if (contact instanceof ContactImpl) {
			return contact;
		}

		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setNew(contact.isNew());
		contactImpl.setPrimaryKey(contact.getPrimaryKey());

		contactImpl.setUuid(contact.getUuid());
		contactImpl.setContactId(contact.getContactId());
		contactImpl.setEmail(contact.getEmail());
		contactImpl.setName(contact.getName());

		return contactImpl;
	}

	/**
	 * Returns the contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact
	 * @return the contact
	 * @throws com.liferay.portal.NoSuchModelException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact with the primary key or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByPrimaryKey(long contactId)
		throws NoSuchContactException, SystemException {
		Contact contact = fetchByPrimaryKey(contactId);

		if (contact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
			}

			throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactId);
		}

		return contact;
	}

	/**
	 * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact
	 * @return the contact, or <code>null</code> if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact
	 * @return the contact, or <code>null</code> if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact fetchByPrimaryKey(long contactId) throws SystemException {
		Contact contact = (Contact)EntityCacheUtil.getResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
				ContactImpl.class, contactId, this);

		if (contact == _nullContact) {
			return null;
		}

		if (contact == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contact = (Contact)session.get(ContactImpl.class,
						Long.valueOf(contactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contact != null) {
					cacheResult(contact);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
						ContactImpl.class, contactId, _nullContact);
				}

				closeSession(session);
			}
		}

		return contact;
	}

	/**
	 * Returns all the contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Contact> list = (List<Contact>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Contact>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		List<Contact> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last contact in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		int count = countByUuid(uuid);

		List<Contact> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the contacts before and after the current contact in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the primary key of the current contact
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact[] findByUuid_PrevAndNext(long contactId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		Contact contact = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contact[] array = new ContactImpl[3];

			array[0] = getByUuid_PrevAndNext(session, contact, uuid,
					orderByComparator, true);

			array[1] = contact;

			array[2] = getByUuid_PrevAndNext(session, contact, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contact getByUuid_PrevAndNext(Session session, Contact contact,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACT_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(contact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the contact where email = &#63; or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByEmail(String email)
		throws NoSuchContactException, SystemException {
		Contact contact = fetchByEmail(email);

		if (contact == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactException(msg.toString());
		}

		return contact;
	}

	/**
	 * Returns the contact where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact fetchByEmail(String email) throws SystemException {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the contact where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact, or <code>null</code> if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact fetchByEmail(String email, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONTACT_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			query.append(ContactModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				List<Contact> list = q.list();

				result = list;

				Contact contact = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					contact = list.get(0);

					cacheResult(contact);

					if ((contact.getEmail() == null) ||
							!contact.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, contact);
					}
				}

				return contact;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Contact)result;
			}
		}
	}

	/**
	 * Returns all the contacts where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				name,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Contact> list = (List<Contact>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NAME,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Contact>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_NAME,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NAME,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first contact in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		List<Contact> list = findByName(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last contact in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		int count = countByName(name);

		List<Contact> list = findByName(name, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the contacts before and after the current contact in the ordered set where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the primary key of the current contact
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact
	 * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact[] findByName_PrevAndNext(long contactId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		Contact contact = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contact[] array = new ContactImpl[3];

			array[0] = getByName_PrevAndNext(session, contact, name,
					orderByComparator, true);

			array[1] = contact;

			array[2] = getByName_PrevAndNext(session, contact, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contact getByName_PrevAndNext(Session session, Contact contact,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACT_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(contact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contacts.
	 *
	 * @return the contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Contact> list = (List<Contact>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACT.concat(ContactModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Contact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Contact>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contacts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Contact contact : findByUuid(uuid)) {
			contactPersistence.remove(contact);
		}
	}

	/**
	 * Removes the contact where email = &#63; from the database.
	 *
	 * @param email the email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmail(String email)
		throws NoSuchContactException, SystemException {
		Contact contact = findByEmail(email);

		contactPersistence.remove(contact);
	}

	/**
	 * Removes all the contacts where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name) throws SystemException {
		for (Contact contact : findByName(name)) {
			contactPersistence.remove(contact);
		}
	}

	/**
	 * Removes all the contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Contact contact : findAll()) {
			contactPersistence.remove(contact);
		}
	}

	/**
	 * Returns the number of contacts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACT_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmail(String email) throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACT_WHERE);

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else {
				if (email.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (email != null) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACT_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contacts.
	 *
	 * @return the number of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns all the newsletter logs associated with the contact.
	 *
	 * @param pk the primary key of the contact
	 * @return the newsletter logs associated with the contact
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk) throws SystemException {
		return getNewsletterLogs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the newsletter logs associated with the contact.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the contact
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @return the range of newsletter logs associated with the contact
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end) throws SystemException {
		return getNewsletterLogs(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_NEWSLETTERLOGS = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogImpl.class,
			com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getNewsletterLogs",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the newsletter logs associated with the contact.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the contact
	 * @param start the lower bound of the range of contacts
	 * @param end the upper bound of the range of contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletter logs associated with the contact
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.liferay.newsletter.model.NewsletterLog> list = (List<com.liferay.newsletter.model.NewsletterLog>)FinderCacheUtil.getResult(FINDER_PATH_GET_NEWSLETTERLOGS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETNEWSLETTERLOGS.concat(ORDER_BY_CLAUSE)
												.concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETNEWSLETTERLOGS;
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Newsletter_NewsletterLog",
					com.liferay.newsletter.model.impl.NewsletterLogImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.liferay.newsletter.model.NewsletterLog>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_NEWSLETTERLOGS,
						finderArgs);
				}
				else {
					newsletterLogPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_NEWSLETTERLOGS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_NEWSLETTERLOGS_SIZE = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogImpl.class,
			com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getNewsletterLogsSize", new String[] { Long.class.getName() });

	/**
	 * Returns the number of newsletter logs associated with the contact.
	 *
	 * @param pk the primary key of the contact
	 * @return the number of newsletter logs associated with the contact
	 * @throws SystemException if a system exception occurred
	 */
	public int getNewsletterLogsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_NEWSLETTERLOGS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETNEWSLETTERLOGSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_NEWSLETTERLOGS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_NEWSLETTERLOG = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.NewsletterLogImpl.class,
			com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsNewsletterLog",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the newsletter log is associated with the contact.
	 *
	 * @param pk the primary key of the contact
	 * @param newsletterLogPK the primary key of the newsletter log
	 * @return <code>true</code> if the newsletter log is associated with the contact; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsNewsletterLog(long pk, long newsletterLogPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, newsletterLogPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_NEWSLETTERLOG,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsNewsletterLog.contains(pk,
							newsletterLogPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_NEWSLETTERLOG,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the contact has any newsletter logs associated with it.
	 *
	 * @param pk the primary key of the contact to check for associations with newsletter logs
	 * @return <code>true</code> if the contact has any newsletter logs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsNewsletterLogs(long pk) throws SystemException {
		if (getNewsletterLogsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.newsletter.model.Contact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contact>> listenersList = new ArrayList<ModelListener<Contact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contact>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsNewsletterLog = new ContainsNewsletterLog(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignContentPersistence.class)
	protected CampaignContentPersistence campaignContentPersistence;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = NewsletterLogPersistence.class)
	protected NewsletterLogPersistence newsletterLogPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsNewsletterLog containsNewsletterLog;

	protected class ContainsNewsletterLog {
		protected ContainsNewsletterLog(ContactPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSNEWSLETTERLOG,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long contactId, long newsletterLogId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(contactId), new Long(newsletterLogId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_CONTACT = "SELECT contact FROM Contact contact";
	private static final String _SQL_SELECT_CONTACT_WHERE = "SELECT contact FROM Contact contact WHERE ";
	private static final String _SQL_COUNT_CONTACT = "SELECT COUNT(contact) FROM Contact contact";
	private static final String _SQL_COUNT_CONTACT_WHERE = "SELECT COUNT(contact) FROM Contact contact WHERE ";
	private static final String _SQL_GETNEWSLETTERLOGS = "SELECT {Newsletter_NewsletterLog.*} FROM Newsletter_NewsletterLog INNER JOIN Newsletter_Contact ON (Newsletter_Contact.contactId = Newsletter_NewsletterLog.contactId) WHERE (Newsletter_Contact.contactId = ?)";
	private static final String _SQL_GETNEWSLETTERLOGSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE contactId = ?";
	private static final String _SQL_CONTAINSNEWSLETTERLOG = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE contactId = ? AND newsletterLogId = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "contact.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "contact.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(contact.uuid IS NULL OR contact.uuid = ?)";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "contact.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "contact.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(contact.email IS NULL OR contact.email = ?)";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "contact.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "contact.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(contact.name IS NULL OR contact.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactPersistenceImpl.class);
	private static Contact _nullContact = new ContactImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<Contact> toCacheModel() {
				return _nullContactCacheModel;
			}
		};

	private static CacheModel<Contact> _nullContactCacheModel = new CacheModel<Contact>() {
			public Contact toEntityModel() {
				return _nullContact;
			}
		};
}