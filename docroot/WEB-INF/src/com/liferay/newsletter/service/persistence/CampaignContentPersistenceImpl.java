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

import com.liferay.newsletter.NoSuchCampaignContentException;
import com.liferay.newsletter.model.CampaignContent;
import com.liferay.newsletter.model.impl.CampaignContentImpl;
import com.liferay.newsletter.model.impl.CampaignContentModelImpl;

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
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the campaign content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignContentPersistence
 * @see CampaignContentUtil
 * @generated
 */
public class CampaignContentPersistenceImpl extends BasePersistenceImpl<CampaignContent>
	implements CampaignContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignContentUtil} to access the campaign content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED,
			CampaignContentImpl.class, FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_TITLE = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED,
			CampaignContentImpl.class, FINDER_CLASS_NAME_LIST, "findByTitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByTitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED,
			CampaignContentImpl.class, FINDER_CLASS_NAME_LIST, "findAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the campaign content in the entity cache if it is enabled.
	 *
	 * @param campaignContent the campaign content
	 */
	public void cacheResult(CampaignContent campaignContent) {
		EntityCacheUtil.putResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentImpl.class, campaignContent.getPrimaryKey(),
			campaignContent);

		campaignContent.resetOriginalValues();
	}

	/**
	 * Caches the campaign contents in the entity cache if it is enabled.
	 *
	 * @param campaignContents the campaign contents
	 */
	public void cacheResult(List<CampaignContent> campaignContents) {
		for (CampaignContent campaignContent : campaignContents) {
			if (EntityCacheUtil.getResult(
						CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
						CampaignContentImpl.class,
						campaignContent.getPrimaryKey(), this) == null) {
				cacheResult(campaignContent);
			}
		}
	}

	/**
	 * Clears the cache for all campaign contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignContentImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the campaign content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignContent campaignContent) {
		EntityCacheUtil.removeResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentImpl.class, campaignContent.getPrimaryKey());
	}

	/**
	 * Creates a new campaign content with the primary key. Does not add the campaign content to the database.
	 *
	 * @param campaignContentId the primary key for the new campaign content
	 * @return the new campaign content
	 */
	public CampaignContent create(long campaignContentId) {
		CampaignContent campaignContent = new CampaignContentImpl();

		campaignContent.setNew(true);
		campaignContent.setPrimaryKey(campaignContentId);

		String uuid = PortalUUIDUtil.generate();

		campaignContent.setUuid(uuid);

		return campaignContent;
	}

	/**
	 * Removes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign content
	 * @return the campaign content that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignContent remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the campaign content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignContentId the primary key of the campaign content
	 * @return the campaign content that was removed
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent remove(long campaignContentId)
		throws NoSuchCampaignContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignContent campaignContent = (CampaignContent)session.get(CampaignContentImpl.class,
					Long.valueOf(campaignContentId));

			if (campaignContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						campaignContentId);
				}

				throw new NoSuchCampaignContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					campaignContentId);
			}

			return campaignContentPersistence.remove(campaignContent);
		}
		catch (NoSuchCampaignContentException nsee) {
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
	 * Removes the campaign content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignContent the campaign content
	 * @return the campaign content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignContent remove(CampaignContent campaignContent)
		throws SystemException {
		return super.remove(campaignContent);
	}

	@Override
	protected CampaignContent removeImpl(CampaignContent campaignContent)
		throws SystemException {
		campaignContent = toUnwrappedModel(campaignContent);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, campaignContent);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentImpl.class, campaignContent.getPrimaryKey());

		return campaignContent;
	}

	@Override
	public CampaignContent updateImpl(
		com.liferay.newsletter.model.CampaignContent campaignContent,
		boolean merge) throws SystemException {
		campaignContent = toUnwrappedModel(campaignContent);

		if (Validator.isNull(campaignContent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			campaignContent.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, campaignContent, merge);

			campaignContent.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
			CampaignContentImpl.class, campaignContent.getPrimaryKey(),
			campaignContent);

		return campaignContent;
	}

	protected CampaignContent toUnwrappedModel(CampaignContent campaignContent) {
		if (campaignContent instanceof CampaignContentImpl) {
			return campaignContent;
		}

		CampaignContentImpl campaignContentImpl = new CampaignContentImpl();

		campaignContentImpl.setNew(campaignContent.isNew());
		campaignContentImpl.setPrimaryKey(campaignContent.getPrimaryKey());

		campaignContentImpl.setUuid(campaignContent.getUuid());
		campaignContentImpl.setCampaignContentId(campaignContent.getCampaignContentId());
		campaignContentImpl.setTitle(campaignContent.getTitle());
		campaignContentImpl.setContent(campaignContent.getContent());
		campaignContentImpl.setCreateDate(campaignContent.getCreateDate());
		campaignContentImpl.setArticleId(campaignContent.getArticleId());

		return campaignContentImpl;
	}

	/**
	 * Returns the campaign content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign content
	 * @return the campaign content
	 * @throws com.liferay.portal.NoSuchModelException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign content with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignContentException} if it could not be found.
	 *
	 * @param campaignContentId the primary key of the campaign content
	 * @return the campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent findByPrimaryKey(long campaignContentId)
		throws NoSuchCampaignContentException, SystemException {
		CampaignContent campaignContent = fetchByPrimaryKey(campaignContentId);

		if (campaignContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignContentId);
			}

			throw new NoSuchCampaignContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				campaignContentId);
		}

		return campaignContent;
	}

	/**
	 * Returns the campaign content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign content
	 * @return the campaign content, or <code>null</code> if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignContentId the primary key of the campaign content
	 * @return the campaign content, or <code>null</code> if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent fetchByPrimaryKey(long campaignContentId)
		throws SystemException {
		CampaignContent campaignContent = (CampaignContent)EntityCacheUtil.getResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
				CampaignContentImpl.class, campaignContentId, this);

		if (campaignContent == _nullCampaignContent) {
			return null;
		}

		if (campaignContent == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				campaignContent = (CampaignContent)session.get(CampaignContentImpl.class,
						Long.valueOf(campaignContentId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (campaignContent != null) {
					cacheResult(campaignContent);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CampaignContentModelImpl.ENTITY_CACHE_ENABLED,
						CampaignContentImpl.class, campaignContentId,
						_nullCampaignContent);
				}

				closeSession(session);
			}
		}

		return campaignContent;
	}

	/**
	 * Returns all the campaign contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign contents where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CampaignContent> list = (List<CampaignContent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_CAMPAIGNCONTENT_WHERE);

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

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<CampaignContent>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first campaign content in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		List<CampaignContent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignContentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign content in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		int count = countByUuid(uuid);

		List<CampaignContent> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignContentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaign contents before and after the current campaign content in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the primary key of the current campaign content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent[] findByUuid_PrevAndNext(long campaignContentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		CampaignContent campaignContent = findByPrimaryKey(campaignContentId);

		Session session = null;

		try {
			session = openSession();

			CampaignContent[] array = new CampaignContentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, campaignContent, uuid,
					orderByComparator, true);

			array[1] = campaignContent;

			array[2] = getByUuid_PrevAndNext(session, campaignContent, uuid,
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

	protected CampaignContent getByUuid_PrevAndNext(Session session,
		CampaignContent campaignContent, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNCONTENT_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaignContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaign contents that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByUuid(String uuid)
		throws SystemException {
		return filterFindByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign contents that the user has permission to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByUuid(String uuid, int start,
		int end) throws SystemException {
		return filterFindByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign contents that the user has permissions to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid(uuid, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

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

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignContentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignContentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (uuid != null) {
				qPos.add(uuid);
			}

			return (List<CampaignContent>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaign contents before and after the current campaign content in the ordered set of campaign contents that the user has permission to view where uuid = &#63;.
	 *
	 * @param campaignContentId the primary key of the current campaign content
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent[] filterFindByUuid_PrevAndNext(
		long campaignContentId, String uuid, OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid_PrevAndNext(campaignContentId, uuid,
				orderByComparator);
		}

		CampaignContent campaignContent = findByPrimaryKey(campaignContentId);

		Session session = null;

		try {
			session = openSession();

			CampaignContent[] array = new CampaignContentImpl[3];

			array[0] = filterGetByUuid_PrevAndNext(session, campaignContent,
					uuid, orderByComparator, true);

			array[1] = campaignContent;

			array[2] = filterGetByUuid_PrevAndNext(session, campaignContent,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignContent filterGetByUuid_PrevAndNext(Session session,
		CampaignContent campaignContent, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

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

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignContentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignContentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaignContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaign contents where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByTitle(String title)
		throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign contents where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign contents where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				title,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CampaignContent> list = (List<CampaignContent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TITLE,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_CAMPAIGNCONTENT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<CampaignContent>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_TITLE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TITLE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first campaign content in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		List<CampaignContent> list = findByTitle(title, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("title=");
			msg.append(title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignContentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign content in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a matching campaign content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		int count = countByTitle(title);

		List<CampaignContent> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("title=");
			msg.append(title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignContentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaign contents before and after the current campaign content in the ordered set where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the primary key of the current campaign content
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent[] findByTitle_PrevAndNext(long campaignContentId,
		String title, OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		CampaignContent campaignContent = findByPrimaryKey(campaignContentId);

		Session session = null;

		try {
			session = openSession();

			CampaignContent[] array = new CampaignContentImpl[3];

			array[0] = getByTitle_PrevAndNext(session, campaignContent, title,
					orderByComparator, true);

			array[1] = campaignContent;

			array[2] = getByTitle_PrevAndNext(session, campaignContent, title,
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

	protected CampaignContent getByTitle_PrevAndNext(Session session,
		CampaignContent campaignContent, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNCONTENT_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaignContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaign contents that the user has permission to view where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByTitle(String title)
		throws SystemException {
		return filterFindByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the campaign contents that the user has permission to view where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByTitle(String title, int start,
		int end) throws SystemException {
		return filterFindByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign contents that the user has permissions to view where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> filterFindByTitle(String title, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByTitle(title, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(2);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignContentImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignContentImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (title != null) {
				qPos.add(title);
			}

			return (List<CampaignContent>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaign contents before and after the current campaign content in the ordered set of campaign contents that the user has permission to view where title = &#63;.
	 *
	 * @param campaignContentId the primary key of the current campaign content
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign content
	 * @throws com.liferay.newsletter.NoSuchCampaignContentException if a campaign content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignContent[] filterFindByTitle_PrevAndNext(
		long campaignContentId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignContentException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByTitle_PrevAndNext(campaignContentId, title,
				orderByComparator);
		}

		CampaignContent campaignContent = findByPrimaryKey(campaignContentId);

		Session session = null;

		try {
			session = openSession();

			CampaignContent[] array = new CampaignContentImpl[3];

			array[0] = filterGetByTitle_PrevAndNext(session, campaignContent,
					title, orderByComparator, true);

			array[1] = campaignContent;

			array[2] = filterGetByTitle_PrevAndNext(session, campaignContent,
					title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignContent filterGetByTitle_PrevAndNext(Session session,
		CampaignContent campaignContent, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignContentImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignContentImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaignContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaign contents.
	 *
	 * @return the campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignContent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CampaignContent> list = (List<CampaignContent>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNCONTENT;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CampaignContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CampaignContent>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the campaign contents where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (CampaignContent campaignContent : findByUuid(uuid)) {
			campaignContentPersistence.remove(campaignContent);
		}
	}

	/**
	 * Removes all the campaign contents where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTitle(String title) throws SystemException {
		for (CampaignContent campaignContent : findByTitle(title)) {
			campaignContentPersistence.remove(campaignContent);
		}
	}

	/**
	 * Removes all the campaign contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CampaignContent campaignContent : findAll()) {
			campaignContentPersistence.remove(campaignContent);
		}
	}

	/**
	 * Returns the number of campaign contents where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNCONTENT_WHERE);

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
	 * Returns the number of campaign contents that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByUuid(String uuid) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUuid(uuid);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CAMPAIGNCONTENT_WHERE);

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

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (uuid != null) {
				qPos.add(uuid);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of campaign contents where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching campaign contents
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNCONTENT_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaign contents that the user has permission to view where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching campaign contents that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByTitle(String title) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByTitle(title);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CAMPAIGNCONTENT_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				CampaignContent.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (title != null) {
				qPos.add(title);
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the number of campaign contents.
	 *
	 * @return the number of campaign contents
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNCONTENT);

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
	 * Returns all the campaigns associated with the campaign content.
	 *
	 * @param pk the primary key of the campaign content
	 * @return the campaigns associated with the campaign content
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.Campaign> getCampaigns(long pk)
		throws SystemException {
		return getCampaigns(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the campaigns associated with the campaign content.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the campaign content
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @return the range of campaigns associated with the campaign content
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.Campaign> getCampaigns(long pk,
		int start, int end) throws SystemException {
		return getCampaigns(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_CAMPAIGNS = new FinderPath(com.liferay.newsletter.model.impl.CampaignModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignImpl.class,
			com.liferay.newsletter.service.persistence.CampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCampaigns",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Returns an ordered range of all the campaigns associated with the campaign content.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the campaign content
	 * @param start the lower bound of the range of campaign contents
	 * @param end the upper bound of the range of campaign contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaigns associated with the campaign content
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.Campaign> getCampaigns(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<com.liferay.newsletter.model.Campaign> list = (List<com.liferay.newsletter.model.Campaign>)FinderCacheUtil.getResult(FINDER_PATH_GET_CAMPAIGNS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETCAMPAIGNS.concat(ORDER_BY_CLAUSE)
										   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETCAMPAIGNS.concat(com.liferay.newsletter.model.impl.CampaignModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("Newsletter_Campaign",
					com.liferay.newsletter.model.impl.CampaignImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<com.liferay.newsletter.model.Campaign>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_CAMPAIGNS,
						finderArgs);
				}
				else {
					campaignPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_CAMPAIGNS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_CAMPAIGNS_SIZE = new FinderPath(com.liferay.newsletter.model.impl.CampaignModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignImpl.class,
			com.liferay.newsletter.service.persistence.CampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCampaignsSize", new String[] { Long.class.getName() });

	/**
	 * Returns the number of campaigns associated with the campaign content.
	 *
	 * @param pk the primary key of the campaign content
	 * @return the number of campaigns associated with the campaign content
	 * @throws SystemException if a system exception occurred
	 */
	public int getCampaignsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_CAMPAIGNS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCAMPAIGNSSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_CAMPAIGNS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_CAMPAIGN = new FinderPath(com.liferay.newsletter.model.impl.CampaignModelImpl.ENTITY_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignModelImpl.FINDER_CACHE_ENABLED,
			com.liferay.newsletter.model.impl.CampaignImpl.class,
			com.liferay.newsletter.service.persistence.CampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCampaign",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns <code>true</code> if the campaign is associated with the campaign content.
	 *
	 * @param pk the primary key of the campaign content
	 * @param campaignPK the primary key of the campaign
	 * @return <code>true</code> if the campaign is associated with the campaign content; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsCampaign(long pk, long campaignPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, campaignPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CAMPAIGN,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCampaign.contains(pk, campaignPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CAMPAIGN,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Returns <code>true</code> if the campaign content has any campaigns associated with it.
	 *
	 * @param pk the primary key of the campaign content to check for associations with campaigns
	 * @return <code>true</code> if the campaign content has any campaigns associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsCampaigns(long pk) throws SystemException {
		if (getCampaignsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the campaign content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.newsletter.model.CampaignContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignContent>> listenersList = new ArrayList<ModelListener<CampaignContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignContent>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsCampaign = new ContainsCampaign(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CampaignContentImpl.class.getName());
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
	protected ContainsCampaign containsCampaign;

	protected class ContainsCampaign {
		protected ContainsCampaign(
			CampaignContentPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCAMPAIGN,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long campaignContentId, long campaignId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(campaignContentId), new Long(campaignId)
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

	private static final String _SQL_SELECT_CAMPAIGNCONTENT = "SELECT campaignContent FROM CampaignContent campaignContent";
	private static final String _SQL_SELECT_CAMPAIGNCONTENT_WHERE = "SELECT campaignContent FROM CampaignContent campaignContent WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNCONTENT = "SELECT COUNT(campaignContent) FROM CampaignContent campaignContent";
	private static final String _SQL_COUNT_CAMPAIGNCONTENT_WHERE = "SELECT COUNT(campaignContent) FROM CampaignContent campaignContent WHERE ";
	private static final String _SQL_GETCAMPAIGNS = "SELECT {Newsletter_Campaign.*} FROM Newsletter_Campaign INNER JOIN Newsletter_CampaignContent ON (Newsletter_CampaignContent.campaignContentId = Newsletter_Campaign.campaignContentId) WHERE (Newsletter_CampaignContent.campaignContentId = ?)";
	private static final String _SQL_GETCAMPAIGNSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_Campaign WHERE campaignContentId = ?";
	private static final String _SQL_CONTAINSCAMPAIGN = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_Campaign WHERE campaignContentId = ? AND campaignId = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "campaignContent.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "campaignContent.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(campaignContent.uuid IS NULL OR campaignContent.uuid = ?)";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "campaignContent.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "campaignContent.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(campaignContent.title IS NULL OR campaignContent.title = ?)";
	private static final String _FILTER_SQL_SELECT_CAMPAIGNCONTENT_WHERE = "SELECT DISTINCT {campaignContent.*} FROM Newsletter_CampaignContent campaignContent WHERE ";
	private static final String _FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Newsletter_CampaignContent.*} FROM (SELECT DISTINCT campaignContent.campaignContentId FROM Newsletter_CampaignContent campaignContent WHERE ";
	private static final String _FILTER_SQL_SELECT_CAMPAIGNCONTENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Newsletter_CampaignContent ON TEMP_TABLE.campaignContentId = Newsletter_CampaignContent.campaignContentId";
	private static final String _FILTER_SQL_COUNT_CAMPAIGNCONTENT_WHERE = "SELECT COUNT(DISTINCT campaignContent.campaignContentId) AS COUNT_VALUE FROM Newsletter_CampaignContent campaignContent WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "campaignContent";
	private static final String _FILTER_ENTITY_TABLE = "Newsletter_CampaignContent";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "campaignContent.campaignContentId";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignContent.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Newsletter_CampaignContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignContent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignContentPersistenceImpl.class);
	private static CampaignContent _nullCampaignContent = new CampaignContentImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<CampaignContent> toCacheModel() {
				return _nullCampaignContentCacheModel;
			}
		};

	private static CacheModel<CampaignContent> _nullCampaignContentCacheModel = new CacheModel<CampaignContent>() {
			public CampaignContent toEntityModel() {
				return _nullCampaignContent;
			}
		};
}