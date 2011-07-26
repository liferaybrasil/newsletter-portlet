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

import com.liferay.newsletter.NoSuchCampaignException;
import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.impl.CampaignImpl;
import com.liferay.newsletter.model.impl.CampaignModelImpl;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignPersistence
 * @see CampaignUtil
 * @generated
 */
public class CampaignPersistenceImpl extends BasePersistenceImpl<Campaign>
	implements CampaignPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignUtil} to access the campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CAMPAIGNCONTENT = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST, "findByCampaignContent",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNCONTENT = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByCampaignContent",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SENTDATE = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST, "findBySentDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SENTDATE = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countBySentDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SD_LT = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST, "findBySD_LT",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SD_LT = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countBySD_LT",
			new String[] { Date.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the campaign in the entity cache if it is enabled.
	 *
	 * @param campaign the campaign
	 */
	public void cacheResult(Campaign campaign) {
		EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey(), campaign);

		campaign.resetOriginalValues();
	}

	/**
	 * Caches the campaigns in the entity cache if it is enabled.
	 *
	 * @param campaigns the campaigns
	 */
	public void cacheResult(List<Campaign> campaigns) {
		for (Campaign campaign : campaigns) {
			if (EntityCacheUtil.getResult(
						CampaignModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImpl.class, campaign.getPrimaryKey(), this) == null) {
				cacheResult(campaign);
			}
		}
	}

	/**
	 * Clears the cache for all campaigns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the campaign.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Campaign campaign) {
		EntityCacheUtil.removeResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey());
	}

	/**
	 * Creates a new campaign with the primary key. Does not add the campaign to the database.
	 *
	 * @param campaignId the primary key for the new campaign
	 * @return the new campaign
	 */
	public Campaign create(long campaignId) {
		Campaign campaign = new CampaignImpl();

		campaign.setNew(true);
		campaign.setPrimaryKey(campaignId);

		String uuid = PortalUUIDUtil.generate();

		campaign.setUuid(uuid);

		return campaign;
	}

	/**
	 * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign remove(long campaignId)
		throws NoSuchCampaignException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Campaign campaign = (Campaign)session.get(CampaignImpl.class,
					Long.valueOf(campaignId));

			if (campaign == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignId);
				}

				throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					campaignId);
			}

			return campaignPersistence.remove(campaign);
		}
		catch (NoSuchCampaignException nsee) {
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
	 * Removes the campaign from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaign the campaign
	 * @return the campaign that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign remove(Campaign campaign) throws SystemException {
		return super.remove(campaign);
	}

	@Override
	protected Campaign removeImpl(Campaign campaign) throws SystemException {
		campaign = toUnwrappedModel(campaign);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, campaign);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey());

		return campaign;
	}

	@Override
	public Campaign updateImpl(com.liferay.newsletter.model.Campaign campaign,
		boolean merge) throws SystemException {
		campaign = toUnwrappedModel(campaign);

		if (Validator.isNull(campaign.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			campaign.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, campaign, merge);

			campaign.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey(), campaign);

		return campaign;
	}

	protected Campaign toUnwrappedModel(Campaign campaign) {
		if (campaign instanceof CampaignImpl) {
			return campaign;
		}

		CampaignImpl campaignImpl = new CampaignImpl();

		campaignImpl.setNew(campaign.isNew());
		campaignImpl.setPrimaryKey(campaign.getPrimaryKey());

		campaignImpl.setUuid(campaign.getUuid());
		campaignImpl.setCampaignId(campaign.getCampaignId());
		campaignImpl.setSentDate(campaign.getSentDate());
		campaignImpl.setEmailSubject(campaign.getEmailSubject());
		campaignImpl.setSenderEmail(campaign.getSenderEmail());
		campaignImpl.setSenderName(campaign.getSenderName());
		campaignImpl.setContent(campaign.getContent());
		campaignImpl.setSent(campaign.isSent());
		campaignImpl.setCampaignContentId(campaign.getCampaignContentId());

		return campaignImpl;
	}

	/**
	 * Returns the campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign
	 * @throws com.liferay.portal.NoSuchModelException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignException} if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByPrimaryKey(long campaignId)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByPrimaryKey(campaignId);

		if (campaign == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignId);
			}

			throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				campaignId);
		}

		return campaign;
	}

	/**
	 * Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByPrimaryKey(long campaignId)
		throws SystemException {
		Campaign campaign = (Campaign)EntityCacheUtil.getResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImpl.class, campaignId, this);

		if (campaign == _nullCampaign) {
			return null;
		}

		if (campaign == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				campaign = (Campaign)session.get(CampaignImpl.class,
						Long.valueOf(campaignId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (campaign != null) {
					cacheResult(campaign);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImpl.class, campaignId, _nullCampaign);
				}

				closeSession(session);
			}
		}

		return campaign;
	}

	/**
	 * Returns all the campaigns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
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

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

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
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
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

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first campaign in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		List<Campaign> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		int count = countByUuid(uuid);

		List<Campaign> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] findByUuid_PrevAndNext(long campaignId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getByUuid_PrevAndNext(session, campaign, uuid,
					orderByComparator, true);

			array[1] = campaign;

			array[2] = getByUuid_PrevAndNext(session, campaign, uuid,
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

	protected Campaign getByUuid_PrevAndNext(Session session,
		Campaign campaign, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

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
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByUuid(String uuid)
		throws SystemException {
		return filterFindByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns that the user has permission to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByUuid(String uuid, int start, int end)
		throws SystemException {
		return filterFindByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns that the user has permissions to view where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid(uuid, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (uuid != null) {
				qPos.add(uuid);
			}

			return (List<Campaign>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where uuid = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] filterFindByUuid_PrevAndNext(long campaignId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByUuid_PrevAndNext(campaignId, uuid, orderByComparator);
		}

		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = filterGetByUuid_PrevAndNext(session, campaign, uuid,
					orderByComparator, true);

			array[1] = campaign;

			array[2] = filterGetByUuid_PrevAndNext(session, campaign, uuid,
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

	protected Campaign filterGetByUuid_PrevAndNext(Session session,
		Campaign campaign, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
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
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns where campaignContentId = &#63;.
	 *
	 * @param campaignContentId the campaign content ID
	 * @return the matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByCampaignContent(long campaignContentId)
		throws SystemException {
		return findByCampaignContent(campaignContentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByCampaignContent(long campaignContentId,
		int start, int end) throws SystemException {
		return findByCampaignContent(campaignContentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByCampaignContent(long campaignContentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				campaignContentId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CAMPAIGNCONTENT,
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

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignContentId);

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CAMPAIGNCONTENT,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CAMPAIGNCONTENT,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first campaign in the ordered set where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByCampaignContent_First(long campaignContentId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		List<Campaign> list = findByCampaignContent(campaignContentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignContentId=");
			msg.append(campaignContentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign in the ordered set where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByCampaignContent_Last(long campaignContentId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		int count = countByCampaignContent(campaignContentId);

		List<Campaign> list = findByCampaignContent(campaignContentId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignContentId=");
			msg.append(campaignContentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param campaignContentId the campaign content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] findByCampaignContent_PrevAndNext(long campaignId,
		long campaignContentId, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getByCampaignContent_PrevAndNext(session, campaign,
					campaignContentId, orderByComparator, true);

			array[1] = campaign;

			array[2] = getByCampaignContent_PrevAndNext(session, campaign,
					campaignContentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign getByCampaignContent_PrevAndNext(Session session,
		Campaign campaign, long campaignContentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

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
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignContentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns that the user has permission to view where campaignContentId = &#63;.
	 *
	 * @param campaignContentId the campaign content ID
	 * @return the matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByCampaignContent(long campaignContentId)
		throws SystemException {
		return filterFindByCampaignContent(campaignContentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns that the user has permission to view where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByCampaignContent(long campaignContentId,
		int start, int end) throws SystemException {
		return filterFindByCampaignContent(campaignContentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns that the user has permissions to view where campaignContentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignContentId the campaign content ID
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindByCampaignContent(long campaignContentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCampaignContent(campaignContentId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(campaignContentId);

			return (List<Campaign>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where campaignContentId = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param campaignContentId the campaign content ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] filterFindByCampaignContent_PrevAndNext(long campaignId,
		long campaignContentId, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCampaignContent_PrevAndNext(campaignId,
				campaignContentId, orderByComparator);
		}

		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = filterGetByCampaignContent_PrevAndNext(session,
					campaign, campaignContentId, orderByComparator, true);

			array[1] = campaign;

			array[2] = filterGetByCampaignContent_PrevAndNext(session,
					campaign, campaignContentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign filterGetByCampaignContent_PrevAndNext(Session session,
		Campaign campaign, long campaignContentId,
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
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignContentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns where sentDate = &#63;.
	 *
	 * @param sentDate the sent date
	 * @return the matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySentDate(Date sentDate)
		throws SystemException {
		return findBySentDate(sentDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the campaigns where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySentDate(Date sentDate, int start, int end)
		throws SystemException {
		return findBySentDate(sentDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySentDate(Date sentDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				sentDate,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SENTDATE,
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

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			if (sentDate == null) {
				query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentDate != null) {
					qPos.add(CalendarUtil.getTimestamp(sentDate));
				}

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SENTDATE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SENTDATE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first campaign in the ordered set where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findBySentDate_First(Date sentDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		List<Campaign> list = findBySentDate(sentDate, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sentDate=");
			msg.append(sentDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign in the ordered set where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findBySentDate_Last(Date sentDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		int count = countBySentDate(sentDate);

		List<Campaign> list = findBySentDate(sentDate, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sentDate=");
			msg.append(sentDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param sentDate the sent date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] findBySentDate_PrevAndNext(long campaignId,
		Date sentDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getBySentDate_PrevAndNext(session, campaign, sentDate,
					orderByComparator, true);

			array[1] = campaign;

			array[2] = getBySentDate_PrevAndNext(session, campaign, sentDate,
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

	protected Campaign getBySentDate_PrevAndNext(Session session,
		Campaign campaign, Date sentDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
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
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (sentDate != null) {
			qPos.add(CalendarUtil.getTimestamp(sentDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns that the user has permission to view where sentDate = &#63;.
	 *
	 * @param sentDate the sent date
	 * @return the matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySentDate(Date sentDate)
		throws SystemException {
		return filterFindBySentDate(sentDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns that the user has permission to view where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySentDate(Date sentDate, int start, int end)
		throws SystemException {
		return filterFindBySentDate(sentDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns that the user has permissions to view where sentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySentDate(Date sentDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBySentDate(sentDate, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (sentDate != null) {
				qPos.add(CalendarUtil.getTimestamp(sentDate));
			}

			return (List<Campaign>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where sentDate = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param sentDate the sent date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] filterFindBySentDate_PrevAndNext(long campaignId,
		Date sentDate, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBySentDate_PrevAndNext(campaignId, sentDate,
				orderByComparator);
		}

		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = filterGetBySentDate_PrevAndNext(session, campaign,
					sentDate, orderByComparator, true);

			array[1] = campaign;

			array[2] = filterGetBySentDate_PrevAndNext(session, campaign,
					sentDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign filterGetBySentDate_PrevAndNext(Session session,
		Campaign campaign, Date sentDate, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (sentDate != null) {
			qPos.add(CalendarUtil.getTimestamp(sentDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns where sentDate &le; &#63; and sent = &#63;.
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @return the matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySD_LT(Date sentDate, boolean sent)
		throws SystemException {
		return findBySD_LT(sentDate, sent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySD_LT(Date sentDate, boolean sent, int start,
		int end) throws SystemException {
		return findBySD_LT(sentDate, sent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findBySD_LT(Date sentDate, boolean sent, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				sentDate, sent,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SD_LT,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			if (sentDate == null) {
				query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
			}

			query.append(_FINDER_COLUMN_SD_LT_SENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentDate != null) {
					qPos.add(CalendarUtil.getTimestamp(sentDate));
				}

				qPos.add(sent);

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SD_LT,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SD_LT,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findBySD_LT_First(Date sentDate, boolean sent,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		List<Campaign> list = findBySD_LT(sentDate, sent, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sentDate=");
			msg.append(sentDate);

			msg.append(", sent=");
			msg.append(sent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findBySD_LT_Last(Date sentDate, boolean sent,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		int count = countBySD_LT(sentDate, sent);

		List<Campaign> list = findBySD_LT(sentDate, sent, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sentDate=");
			msg.append(sentDate);

			msg.append(", sent=");
			msg.append(sent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] findBySD_LT_PrevAndNext(long campaignId, Date sentDate,
		boolean sent, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getBySD_LT_PrevAndNext(session, campaign, sentDate,
					sent, orderByComparator, true);

			array[1] = campaign;

			array[2] = getBySD_LT_PrevAndNext(session, campaign, sentDate,
					sent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign getBySD_LT_PrevAndNext(Session session,
		Campaign campaign, Date sentDate, boolean sent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
		}

		query.append(_FINDER_COLUMN_SD_LT_SENT_2);

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
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (sentDate != null) {
			qPos.add(CalendarUtil.getTimestamp(sentDate));
		}

		qPos.add(sent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @return the matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySD_LT(Date sentDate, boolean sent)
		throws SystemException {
		return filterFindBySD_LT(sentDate, sent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySD_LT(Date sentDate, boolean sent,
		int start, int end) throws SystemException {
		return filterFindBySD_LT(sentDate, sent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns that the user has permissions to view where sentDate &le; &#63; and sent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> filterFindBySD_LT(Date sentDate, boolean sent,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBySD_LT(sentDate, sent, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
		}

		query.append(_FINDER_COLUMN_SD_LT_SENT_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (sentDate != null) {
				qPos.add(CalendarUtil.getTimestamp(sentDate));
			}

			qPos.add(sent);

			return (List<Campaign>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set of campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] filterFindBySD_LT_PrevAndNext(long campaignId,
		Date sentDate, boolean sent, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findBySD_LT_PrevAndNext(campaignId, sentDate, sent,
				orderByComparator);
		}

		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = filterGetBySD_LT_PrevAndNext(session, campaign,
					sentDate, sent, orderByComparator, true);

			array[1] = campaign;

			array[2] = filterGetBySD_LT_PrevAndNext(session, campaign,
					sentDate, sent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign filterGetBySD_LT_PrevAndNext(Session session,
		Campaign campaign, Date sentDate, boolean sent,
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
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1);
		}

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
		}

		query.append(_FINDER_COLUMN_SD_LT_SENT_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2);
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

		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(CampaignModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, CampaignImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, CampaignImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (sentDate != null) {
			qPos.add(CalendarUtil.getTimestamp(sentDate));
		}

		qPos.add(sent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the campaigns.
	 *
	 * @return the campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGN.concat(CampaignModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Campaign>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Campaign>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the campaigns where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Campaign campaign : findByUuid(uuid)) {
			campaignPersistence.remove(campaign);
		}
	}

	/**
	 * Removes all the campaigns where campaignContentId = &#63; from the database.
	 *
	 * @param campaignContentId the campaign content ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCampaignContent(long campaignContentId)
		throws SystemException {
		for (Campaign campaign : findByCampaignContent(campaignContentId)) {
			campaignPersistence.remove(campaign);
		}
	}

	/**
	 * Removes all the campaigns where sentDate = &#63; from the database.
	 *
	 * @param sentDate the sent date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySentDate(Date sentDate) throws SystemException {
		for (Campaign campaign : findBySentDate(sentDate)) {
			campaignPersistence.remove(campaign);
		}
	}

	/**
	 * Removes all the campaigns where sentDate &le; &#63; and sent = &#63; from the database.
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySD_LT(Date sentDate, boolean sent)
		throws SystemException {
		for (Campaign campaign : findBySD_LT(sentDate, sent)) {
			campaignPersistence.remove(campaign);
		}
	}

	/**
	 * Removes all the campaigns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Campaign campaign : findAll()) {
			campaignPersistence.remove(campaign);
		}
	}

	/**
	 * Returns the number of campaigns where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

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
	 * Returns the number of campaigns that the user has permission to view where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByUuid(String uuid) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByUuid(uuid);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CAMPAIGN_WHERE);

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
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

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
	 * Returns the number of campaigns where campaignContentId = &#63;.
	 *
	 * @param campaignContentId the campaign content ID
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCampaignContent(long campaignContentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { campaignContentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAMPAIGNCONTENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignContentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNCONTENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaigns that the user has permission to view where campaignContentId = &#63;.
	 *
	 * @param campaignContentId the campaign content ID
	 * @return the number of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountByCampaignContent(long campaignContentId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCampaignContent(campaignContentId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(campaignContentId);

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
	 * Returns the number of campaigns where sentDate = &#63;.
	 *
	 * @param sentDate the sent date
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySentDate(Date sentDate) throws SystemException {
		Object[] finderArgs = new Object[] { sentDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SENTDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			if (sentDate == null) {
				query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentDate != null) {
					qPos.add(CalendarUtil.getTimestamp(sentDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SENTDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaigns that the user has permission to view where sentDate = &#63;.
	 *
	 * @param sentDate the sent date
	 * @return the number of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountBySentDate(Date sentDate) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countBySentDate(sentDate);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_CAMPAIGN_WHERE);

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SENTDATE_SENTDATE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (sentDate != null) {
				qPos.add(CalendarUtil.getTimestamp(sentDate));
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
	 * Returns the number of campaigns where sentDate &le; &#63; and sent = &#63;.
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySD_LT(Date sentDate, boolean sent)
		throws SystemException {
		Object[] finderArgs = new Object[] { sentDate, sent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SD_LT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			if (sentDate == null) {
				query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
			}

			query.append(_FINDER_COLUMN_SD_LT_SENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (sentDate != null) {
					qPos.add(CalendarUtil.getTimestamp(sentDate));
				}

				qPos.add(sent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SD_LT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaigns that the user has permission to view where sentDate &le; &#63; and sent = &#63;.
	 *
	 * @param sentDate the sent date
	 * @param sent the sent
	 * @return the number of matching campaigns that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	public int filterCountBySD_LT(Date sentDate, boolean sent)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countBySD_LT(sentDate, sent);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_CAMPAIGN_WHERE);

		if (sentDate == null) {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_SD_LT_SENTDATE_2);
		}

		query.append(_FINDER_COLUMN_SD_LT_SENT_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Campaign.class.getName(), _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (sentDate != null) {
				qPos.add(CalendarUtil.getTimestamp(sentDate));
			}

			qPos.add(sent);

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
	 * Returns the number of campaigns.
	 *
	 * @return the number of campaigns
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGN);

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
	 * Returns all the newsletter logs associated with the campaign.
	 *
	 * @param pk the primary key of the campaign
	 * @return the newsletter logs associated with the campaign
	 * @throws SystemException if a system exception occurred
	 */
	public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
		long pk) throws SystemException {
		return getNewsletterLogs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the newsletter logs associated with the campaign.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the campaign
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of newsletter logs associated with the campaign
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
	 * Returns an ordered range of all the newsletter logs associated with the campaign.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the campaign
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletter logs associated with the campaign
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
	 * Returns the number of newsletter logs associated with the campaign.
	 *
	 * @param pk the primary key of the campaign
	 * @return the number of newsletter logs associated with the campaign
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
	 * Returns <code>true</code> if the newsletter log is associated with the campaign.
	 *
	 * @param pk the primary key of the campaign
	 * @param newsletterLogPK the primary key of the newsletter log
	 * @return <code>true</code> if the newsletter log is associated with the campaign; <code>false</code> otherwise
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
	 * Returns <code>true</code> if the campaign has any newsletter logs associated with it.
	 *
	 * @param pk the primary key of the campaign to check for associations with newsletter logs
	 * @return <code>true</code> if the campaign has any newsletter logs associated with it; <code>false</code> otherwise
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
	 * Initializes the campaign persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.newsletter.model.Campaign")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Campaign>> listenersList = new ArrayList<ModelListener<Campaign>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Campaign>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignImpl.class.getName());
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
		protected ContainsNewsletterLog(CampaignPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSNEWSLETTERLOG,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long campaignId, long newsletterLogId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(campaignId), new Long(newsletterLogId)
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

	private static final String _SQL_SELECT_CAMPAIGN = "SELECT campaign FROM Campaign campaign";
	private static final String _SQL_SELECT_CAMPAIGN_WHERE = "SELECT campaign FROM Campaign campaign WHERE ";
	private static final String _SQL_COUNT_CAMPAIGN = "SELECT COUNT(campaign) FROM Campaign campaign";
	private static final String _SQL_COUNT_CAMPAIGN_WHERE = "SELECT COUNT(campaign) FROM Campaign campaign WHERE ";
	private static final String _SQL_GETNEWSLETTERLOGS = "SELECT {Newsletter_NewsletterLog.*} FROM Newsletter_NewsletterLog INNER JOIN Newsletter_Campaign ON (Newsletter_Campaign.campaignId = Newsletter_NewsletterLog.campaignId) WHERE (Newsletter_Campaign.campaignId = ?)";
	private static final String _SQL_GETNEWSLETTERLOGSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE campaignId = ?";
	private static final String _SQL_CONTAINSNEWSLETTERLOG = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE campaignId = ? AND newsletterLogId = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "campaign.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "campaign.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(campaign.uuid IS NULL OR campaign.uuid = ?)";
	private static final String _FINDER_COLUMN_CAMPAIGNCONTENT_CAMPAIGNCONTENTID_2 =
		"campaign.campaignContentId = ?";
	private static final String _FINDER_COLUMN_SENTDATE_SENTDATE_1 = "campaign.sentDate IS NULL";
	private static final String _FINDER_COLUMN_SENTDATE_SENTDATE_2 = "campaign.sentDate = ?";
	private static final String _FINDER_COLUMN_SD_LT_SENTDATE_1 = "campaign.sentDate <= NULL AND ";
	private static final String _FINDER_COLUMN_SD_LT_SENTDATE_2 = "campaign.sentDate <= ? AND ";
	private static final String _FINDER_COLUMN_SD_LT_SENT_2 = "campaign.sent = ?";
	private static final String _FILTER_SQL_SELECT_CAMPAIGN_WHERE = "SELECT DISTINCT {campaign.*} FROM Newsletter_Campaign campaign WHERE ";
	private static final String _FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {Newsletter_Campaign.*} FROM (SELECT DISTINCT campaign.campaignId FROM Newsletter_Campaign campaign WHERE ";
	private static final String _FILTER_SQL_SELECT_CAMPAIGN_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN Newsletter_Campaign ON TEMP_TABLE.campaignId = Newsletter_Campaign.campaignId";
	private static final String _FILTER_SQL_COUNT_CAMPAIGN_WHERE = "SELECT COUNT(DISTINCT campaign.campaignId) AS COUNT_VALUE FROM Newsletter_Campaign campaign WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "campaign";
	private static final String _FILTER_ENTITY_TABLE = "Newsletter_Campaign";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "campaign.campaignId";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaign.";
	private static final String _ORDER_BY_ENTITY_TABLE = "Newsletter_Campaign.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Campaign exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Campaign exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignPersistenceImpl.class);
	private static Campaign _nullCampaign = new CampaignImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<Campaign> toCacheModel() {
				return _nullCampaignCacheModel;
			}
		};

	private static CacheModel<Campaign> _nullCampaignCacheModel = new CacheModel<Campaign>() {
			public Campaign toEntityModel() {
				return _nullCampaign;
			}
		};
}