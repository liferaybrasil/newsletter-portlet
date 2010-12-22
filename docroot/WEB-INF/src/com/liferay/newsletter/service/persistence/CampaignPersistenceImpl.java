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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
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
 * The persistence implementation for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
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
            CampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
            CampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByUuid", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
            CampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
            CampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_SENDCAMPAIGNS = new FinderPath(com.liferay.newsletter.model.impl.SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.SendCampaignModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.SendCampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getSendCampaigns",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_GET_SENDCAMPAIGNS_SIZE = new FinderPath(com.liferay.newsletter.model.impl.SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.SendCampaignModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.SendCampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getSendCampaignsSize", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_CONTAINS_SENDCAMPAIGN = new FinderPath(com.liferay.newsletter.model.impl.SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.SendCampaignModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.SendCampaignPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "containsSendCampaign",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_CAMPAIGN = "SELECT campaign FROM Campaign campaign";
    private static final String _SQL_SELECT_CAMPAIGN_WHERE = "SELECT campaign FROM Campaign campaign WHERE ";
    private static final String _SQL_COUNT_CAMPAIGN = "SELECT COUNT(campaign) FROM Campaign campaign";
    private static final String _SQL_COUNT_CAMPAIGN_WHERE = "SELECT COUNT(campaign) FROM Campaign campaign WHERE ";
    private static final String _SQL_GETSENDCAMPAIGNS = "SELECT {Newsletter_SendCampaign.*} FROM Newsletter_SendCampaign INNER JOIN Newsletter_Campaign ON (Newsletter_Campaign.campaignId = Newsletter_SendCampaign.campaignId) WHERE (Newsletter_Campaign.campaignId = ?)";
    private static final String _SQL_GETSENDCAMPAIGNSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_SendCampaign WHERE campaignId = ?";
    private static final String _SQL_CONTAINSSENDCAMPAIGN = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_SendCampaign WHERE campaignId = ? AND sendCampaignId = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "campaign.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "campaign.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(campaign.uuid IS NULL OR campaign.uuid = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "campaign.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Campaign exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Campaign exists with the key {";
    private static Log _log = LogFactoryUtil.getLog(CampaignPersistenceImpl.class);
    @BeanReference(type = CampaignPersistence.class)
    protected CampaignPersistence campaignPersistence;
    @BeanReference(type = ContactPersistence.class)
    protected ContactPersistence contactPersistence;
    @BeanReference(type = SendCampaignPersistence.class)
    protected SendCampaignPersistence sendCampaignPersistence;
    @BeanReference(type = NewsletterLogPersistence.class)
    protected NewsletterLogPersistence newsletterLogPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    protected ContainsSendCampaign containsSendCampaign;

    /**
     * Caches the campaign in the entity cache if it is enabled.
     *
     * @param campaign the campaign to cache
     */
    public void cacheResult(Campaign campaign) {
        EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
            CampaignImpl.class, campaign.getPrimaryKey(), campaign);
    }

    /**
     * Caches the campaigns in the entity cache if it is enabled.
     *
     * @param campaigns the campaigns to cache
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
    public void clearCache() {
        CacheRegistryUtil.clear(CampaignImpl.class.getName());
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
     * @param primaryKey the primary key of the campaign to remove
     * @return the campaign that was removed
     * @throws com.liferay.portal.NoSuchModelException if a campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Campaign remove(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return remove(((Long) primaryKey).longValue());
    }

    /**
     * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param campaignId the primary key of the campaign to remove
     * @return the campaign that was removed
     * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Campaign remove(long campaignId)
        throws NoSuchCampaignException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Campaign campaign = (Campaign) session.get(CampaignImpl.class,
                    new Long(campaignId));

            if (campaign == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignId);
                }

                throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    campaignId);
            }

            return remove(campaign);
        } catch (NoSuchCampaignException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Campaign removeImpl(Campaign campaign) throws SystemException {
        campaign = toUnwrappedModel(campaign);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, campaign);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
            CampaignImpl.class, campaign.getPrimaryKey());

        return campaign;
    }

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
        } catch (Exception e) {
            throw processException(e);
        } finally {
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
        campaignImpl.setTitle(campaign.getTitle());
        campaignImpl.setContent(campaign.getContent());

        return campaignImpl;
    }

    /**
     * Finds the campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the campaign to find
     * @return the campaign
     * @throws com.liferay.portal.NoSuchModelException if a campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Campaign findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignException} if it could not be found.
     *
     * @param campaignId the primary key of the campaign to find
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
     * Finds the campaign with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the campaign to find
     * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Campaign fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the campaign with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param campaignId the primary key of the campaign to find
     * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Campaign fetchByPrimaryKey(long campaignId)
        throws SystemException {
        Campaign campaign = (Campaign) EntityCacheUtil.getResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
                CampaignImpl.class, campaignId, this);

        if (campaign == null) {
            Session session = null;

            try {
                session = openSession();

                campaign = (Campaign) session.get(CampaignImpl.class,
                        new Long(campaignId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (campaign != null) {
                    cacheResult(campaign);
                }

                closeSession(session);
            }
        }

        return campaign;
    }

    /**
     * Finds all the campaigns where uuid = &#63;.
     *
     * @param uuid the uuid to search with
     * @return the matching campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<Campaign> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the campaigns where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @return the range of matching campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<Campaign> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Finds an ordered range of all the campaigns where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
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

        List<Campaign> list = (List<Campaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_CAMPAIGN_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                } else {
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

                list = (List<Campaign>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
                        finderArgs);
                } else {
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
     * Finds the first campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
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
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
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
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the campaigns before and after the current campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param campaignId the primary key of the current campaign
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
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
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CAMPAIGN_WHERE);

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else {
            if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
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
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
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
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
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
            Object[] values = orderByComparator.getOrderByValues(campaign);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Campaign> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the campaigns.
     *
     * @return the campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<Campaign> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the campaigns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @return the range of campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<Campaign> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Finds an ordered range of all the campaigns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<Campaign> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<Campaign> list = (List<Campaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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
            } else {
                sql = _SQL_SELECT_CAMPAIGN;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Campaign>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Campaign>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
                        finderArgs);
                } else {
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
     * @param uuid the uuid to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByUuid(String uuid) throws SystemException {
        for (Campaign campaign : findByUuid(uuid)) {
            remove(campaign);
        }
    }

    /**
     * Removes all the campaigns from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Campaign campaign : findAll()) {
            remove(campaign);
        }
    }

    /**
     * Counts all the campaigns where uuid = &#63;.
     *
     * @param uuid the uuid to search with
     * @return the number of matching campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countByUuid(String uuid) throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CAMPAIGN_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                } else {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
     * Counts all the campaigns.
     *
     * @return the number of campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CAMPAIGN);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
     * Gets all the send campaigns associated with the campaign.
     *
     * @param pk the primary key of the campaign to get the associated send campaigns for
     * @return the send campaigns associated with the campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk) throws SystemException {
        return getSendCampaigns(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Gets a range of all the send campaigns associated with the campaign.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the campaign to get the associated send campaigns for
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @return the range of send campaigns associated with the campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk, int start, int end) throws SystemException {
        return getSendCampaigns(pk, start, end, null);
    }

    /**
     * Gets an ordered range of all the send campaigns associated with the campaign.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the campaign to get the associated send campaigns for
     * @param start the lower bound of the range of campaigns to return
     * @param end the upper bound of the range of campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of send campaigns associated with the campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                pk, String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<com.liferay.newsletter.model.SendCampaign> list = (List<com.liferay.newsletter.model.SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_GET_SENDCAMPAIGNS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETSENDCAMPAIGNS.concat(ORDER_BY_CLAUSE)
                                               .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETSENDCAMPAIGNS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("Newsletter_SendCampaign",
                    com.liferay.newsletter.model.impl.SendCampaignImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.liferay.newsletter.model.SendCampaign>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_SENDCAMPAIGNS,
                        finderArgs);
                } else {
                    sendCampaignPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_SENDCAMPAIGNS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Gets the number of send campaigns associated with the campaign.
     *
     * @param pk the primary key of the campaign to get the number of associated send campaigns for
     * @return the number of send campaigns associated with the campaign
     * @throws SystemException if a system exception occurred
     */
    public int getSendCampaignsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_SENDCAMPAIGNS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETSENDCAMPAIGNSSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_SENDCAMPAIGNS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Determines if the send campaign is associated with the campaign.
     *
     * @param pk the primary key of the campaign
     * @param sendCampaignPK the primary key of the send campaign
     * @return <code>true</code> if the send campaign is associated with the campaign; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsSendCampaign(long pk, long sendCampaignPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, sendCampaignPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_SENDCAMPAIGN,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsSendCampaign.contains(pk,
                            sendCampaignPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_SENDCAMPAIGN,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Determines if the campaign has any send campaigns associated with it.
     *
     * @param pk the primary key of the campaign to check for associations with send campaigns
     * @return <code>true</code> if the campaign has any send campaigns associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsSendCampaigns(long pk) throws SystemException {
        if (getSendCampaignsSize(pk) > 0) {
            return true;
        } else {
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
                    listenersList.add((ModelListener<Campaign>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsSendCampaign = new ContainsSendCampaign(this);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CampaignImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
    }

    protected class ContainsSendCampaign {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsSendCampaign(CampaignPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSSENDCAMPAIGN,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long campaignId, long sendCampaignId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(campaignId), new Long(sendCampaignId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
