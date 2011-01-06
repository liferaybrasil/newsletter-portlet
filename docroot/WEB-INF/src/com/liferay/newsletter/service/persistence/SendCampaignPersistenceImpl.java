package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.NoSuchSendCampaignException;
import com.liferay.newsletter.model.SendCampaign;
import com.liferay.newsletter.model.impl.SendCampaignImpl;
import com.liferay.newsletter.model.impl.SendCampaignModelImpl;

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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the send campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see SendCampaignPersistence
 * @see SendCampaignUtil
 * @generated
 */
public class SendCampaignPersistenceImpl extends BasePersistenceImpl<SendCampaign>
    implements SendCampaignPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SendCampaignUtil} to access the send campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SendCampaignImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByUuid", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CAMPAIGN = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCampaign",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGN = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCampaign", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_SENDDATE = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBySendDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_SENDDATE = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBySendDate", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_SD_LT = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBySD_LT",
            new String[] {
                Date.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_SD_LT = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBySD_LT",
            new String[] { Date.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_NEWSLETTERLOGS = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getNewsletterLogs",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_GET_NEWSLETTERLOGS_SIZE = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getNewsletterLogsSize", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_CONTAINS_NEWSLETTERLOG = new FinderPath(com.liferay.newsletter.model.impl.NewsletterLogModelImpl.ENTITY_CACHE_ENABLED,
            com.liferay.newsletter.model.impl.NewsletterLogModelImpl.FINDER_CACHE_ENABLED,
            com.liferay.newsletter.service.persistence.NewsletterLogPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "containsNewsletterLog",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_SENDCAMPAIGN = "SELECT sendCampaign FROM SendCampaign sendCampaign";
    private static final String _SQL_SELECT_SENDCAMPAIGN_WHERE = "SELECT sendCampaign FROM SendCampaign sendCampaign WHERE ";
    private static final String _SQL_COUNT_SENDCAMPAIGN = "SELECT COUNT(sendCampaign) FROM SendCampaign sendCampaign";
    private static final String _SQL_COUNT_SENDCAMPAIGN_WHERE = "SELECT COUNT(sendCampaign) FROM SendCampaign sendCampaign WHERE ";
    private static final String _SQL_GETNEWSLETTERLOGS = "SELECT {Newsletter_NewsletterLog.*} FROM Newsletter_NewsletterLog INNER JOIN Newsletter_SendCampaign ON (Newsletter_SendCampaign.sendCampaignId = Newsletter_NewsletterLog.sendCampaignId) WHERE (Newsletter_SendCampaign.sendCampaignId = ?)";
    private static final String _SQL_GETNEWSLETTERLOGSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE sendCampaignId = ?";
    private static final String _SQL_CONTAINSNEWSLETTERLOG = "SELECT COUNT(*) AS COUNT_VALUE FROM Newsletter_NewsletterLog WHERE sendCampaignId = ? AND newsletterLogId = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "sendCampaign.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "sendCampaign.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sendCampaign.uuid IS NULL OR sendCampaign.uuid = ?)";
    private static final String _FINDER_COLUMN_CAMPAIGN_CAMPAIGNID_2 = "sendCampaign.campaignId = ?";
    private static final String _FINDER_COLUMN_SENDDATE_SENDDATE_1 = "sendCampaign.sendDate IS NULL";
    private static final String _FINDER_COLUMN_SENDDATE_SENDDATE_2 = "sendCampaign.sendDate = ?";
    private static final String _FINDER_COLUMN_SD_LT_SENDDATE_1 = "sendCampaign.sendDate <= NULL AND ";
    private static final String _FINDER_COLUMN_SD_LT_SENDDATE_2 = "sendCampaign.sendDate <= ? AND ";
    private static final String _FINDER_COLUMN_SD_LT_SENT_2 = "sendCampaign.sent = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "sendCampaign.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SendCampaign exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SendCampaign exists with the key {";
    private static Log _log = LogFactoryUtil.getLog(SendCampaignPersistenceImpl.class);
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
    protected ContainsNewsletterLog containsNewsletterLog;

    /**
     * Caches the send campaign in the entity cache if it is enabled.
     *
     * @param sendCampaign the send campaign to cache
     */
    public void cacheResult(SendCampaign sendCampaign) {
        EntityCacheUtil.putResult(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignImpl.class, sendCampaign.getPrimaryKey(), sendCampaign);
    }

    /**
     * Caches the send campaigns in the entity cache if it is enabled.
     *
     * @param sendCampaigns the send campaigns to cache
     */
    public void cacheResult(List<SendCampaign> sendCampaigns) {
        for (SendCampaign sendCampaign : sendCampaigns) {
            if (EntityCacheUtil.getResult(
                        SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
                        SendCampaignImpl.class, sendCampaign.getPrimaryKey(),
                        this) == null) {
                cacheResult(sendCampaign);
            }
        }
    }

    /**
     * Clears the cache for all send campaigns.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache() {
        CacheRegistryUtil.clear(SendCampaignImpl.class.getName());
        EntityCacheUtil.clearCache(SendCampaignImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    /**
     * Clears the cache for the send campaign.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    public void clearCache(SendCampaign sendCampaign) {
        EntityCacheUtil.removeResult(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignImpl.class, sendCampaign.getPrimaryKey());
    }

    /**
     * Creates a new send campaign with the primary key. Does not add the send campaign to the database.
     *
     * @param sendCampaignId the primary key for the new send campaign
     * @return the new send campaign
     */
    public SendCampaign create(long sendCampaignId) {
        SendCampaign sendCampaign = new SendCampaignImpl();

        sendCampaign.setNew(true);
        sendCampaign.setPrimaryKey(sendCampaignId);

        String uuid = PortalUUIDUtil.generate();

        sendCampaign.setUuid(uuid);

        return sendCampaign;
    }

    /**
     * Removes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the send campaign to remove
     * @return the send campaign that was removed
     * @throws com.liferay.portal.NoSuchModelException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign remove(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return remove(((Long) primaryKey).longValue());
    }

    /**
     * Removes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param sendCampaignId the primary key of the send campaign to remove
     * @return the send campaign that was removed
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign remove(long sendCampaignId)
        throws NoSuchSendCampaignException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SendCampaign sendCampaign = (SendCampaign) session.get(SendCampaignImpl.class,
                    new Long(sendCampaignId));

            if (sendCampaign == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                        sendCampaignId);
                }

                throw new NoSuchSendCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    sendCampaignId);
            }

            return remove(sendCampaign);
        } catch (NoSuchSendCampaignException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SendCampaign removeImpl(SendCampaign sendCampaign)
        throws SystemException {
        sendCampaign = toUnwrappedModel(sendCampaign);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, sendCampaign);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignImpl.class, sendCampaign.getPrimaryKey());

        return sendCampaign;
    }

    public SendCampaign updateImpl(
        com.liferay.newsletter.model.SendCampaign sendCampaign, boolean merge)
        throws SystemException {
        sendCampaign = toUnwrappedModel(sendCampaign);

        if (Validator.isNull(sendCampaign.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            sendCampaign.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, sendCampaign, merge);

            sendCampaign.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
            SendCampaignImpl.class, sendCampaign.getPrimaryKey(), sendCampaign);

        return sendCampaign;
    }

    protected SendCampaign toUnwrappedModel(SendCampaign sendCampaign) {
        if (sendCampaign instanceof SendCampaignImpl) {
            return sendCampaign;
        }

        SendCampaignImpl sendCampaignImpl = new SendCampaignImpl();

        sendCampaignImpl.setNew(sendCampaign.isNew());
        sendCampaignImpl.setPrimaryKey(sendCampaign.getPrimaryKey());

        sendCampaignImpl.setUuid(sendCampaign.getUuid());
        sendCampaignImpl.setSendCampaignId(sendCampaign.getSendCampaignId());
        sendCampaignImpl.setSendDate(sendCampaign.getSendDate());
        sendCampaignImpl.setEmailSubject(sendCampaign.getEmailSubject());
        sendCampaignImpl.setSenderName(sendCampaign.getSenderName());
        sendCampaignImpl.setSenderEmail(sendCampaign.getSenderEmail());
        sendCampaignImpl.setSent(sendCampaign.isSent());
        sendCampaignImpl.setCampaignId(sendCampaign.getCampaignId());

        return sendCampaignImpl;
    }

    /**
     * Finds the send campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the send campaign to find
     * @return the send campaign
     * @throws com.liferay.portal.NoSuchModelException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the send campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchSendCampaignException} if it could not be found.
     *
     * @param sendCampaignId the primary key of the send campaign to find
     * @return the send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByPrimaryKey(long sendCampaignId)
        throws NoSuchSendCampaignException, SystemException {
        SendCampaign sendCampaign = fetchByPrimaryKey(sendCampaignId);

        if (sendCampaign == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + sendCampaignId);
            }

            throw new NoSuchSendCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                sendCampaignId);
        }

        return sendCampaign;
    }

    /**
     * Finds the send campaign with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the send campaign to find
     * @return the send campaign, or <code>null</code> if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Finds the send campaign with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param sendCampaignId the primary key of the send campaign to find
     * @return the send campaign, or <code>null</code> if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign fetchByPrimaryKey(long sendCampaignId)
        throws SystemException {
        SendCampaign sendCampaign = (SendCampaign) EntityCacheUtil.getResult(SendCampaignModelImpl.ENTITY_CACHE_ENABLED,
                SendCampaignImpl.class, sendCampaignId, this);

        if (sendCampaign == null) {
            Session session = null;

            try {
                session = openSession();

                sendCampaign = (SendCampaign) session.get(SendCampaignImpl.class,
                        new Long(sendCampaignId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (sendCampaign != null) {
                    cacheResult(sendCampaign);
                }

                closeSession(session);
            }
        }

        return sendCampaign;
    }

    /**
     * Finds all the send campaigns where uuid = &#63;.
     *
     * @param uuid the uuid to search with
     * @return the matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the send campaigns where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Finds an ordered range of all the send campaigns where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                uuid,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<SendCampaign> list = (List<SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

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
            else {
                query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
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

                list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Finds the first send campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        List<SendCampaign> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last send campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        int count = countByUuid(uuid);

        List<SendCampaign> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the send campaigns before and after the current send campaign in the ordered set where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendCampaignId the primary key of the current send campaign
     * @param uuid the uuid to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign[] findByUuid_PrevAndNext(long sendCampaignId,
        String uuid, OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        SendCampaign sendCampaign = findByPrimaryKey(sendCampaignId);

        Session session = null;

        try {
            session = openSession();

            SendCampaign[] array = new SendCampaignImpl[3];

            array[0] = getByUuid_PrevAndNext(session, sendCampaign, uuid,
                    orderByComparator, true);

            array[1] = sendCampaign;

            array[2] = getByUuid_PrevAndNext(session, sendCampaign, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SendCampaign getByUuid_PrevAndNext(Session session,
        SendCampaign sendCampaign, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

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
        else {
            query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByValues(sendCampaign);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SendCampaign> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the send campaigns where campaignId = &#63;.
     *
     * @param campaignId the campaign id to search with
     * @return the matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByCampaign(long campaignId)
        throws SystemException {
        return findByCampaign(campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Finds a range of all the send campaigns where campaignId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param campaignId the campaign id to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByCampaign(long campaignId, int start, int end)
        throws SystemException {
        return findByCampaign(campaignId, start, end, null);
    }

    /**
     * Finds an ordered range of all the send campaigns where campaignId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param campaignId the campaign id to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findByCampaign(long campaignId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                campaignId,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<SendCampaign> list = (List<SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CAMPAIGN,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

            query.append(_FINDER_COLUMN_CAMPAIGN_CAMPAIGNID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(campaignId);

                list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CAMPAIGN,
                        finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CAMPAIGN,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first send campaign in the ordered set where campaignId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param campaignId the campaign id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByCampaign_First(long campaignId,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        List<SendCampaign> list = findByCampaign(campaignId, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("campaignId=");
            msg.append(campaignId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last send campaign in the ordered set where campaignId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param campaignId the campaign id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findByCampaign_Last(long campaignId,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        int count = countByCampaign(campaignId);

        List<SendCampaign> list = findByCampaign(campaignId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("campaignId=");
            msg.append(campaignId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the send campaigns before and after the current send campaign in the ordered set where campaignId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendCampaignId the primary key of the current send campaign
     * @param campaignId the campaign id to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign[] findByCampaign_PrevAndNext(long sendCampaignId,
        long campaignId, OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        SendCampaign sendCampaign = findByPrimaryKey(sendCampaignId);

        Session session = null;

        try {
            session = openSession();

            SendCampaign[] array = new SendCampaignImpl[3];

            array[0] = getByCampaign_PrevAndNext(session, sendCampaign,
                    campaignId, orderByComparator, true);

            array[1] = sendCampaign;

            array[2] = getByCampaign_PrevAndNext(session, sendCampaign,
                    campaignId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SendCampaign getByCampaign_PrevAndNext(Session session,
        SendCampaign sendCampaign, long campaignId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

        query.append(_FINDER_COLUMN_CAMPAIGN_CAMPAIGNID_2);

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
        else {
            query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(campaignId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(sendCampaign);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SendCampaign> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the send campaigns where sendDate = &#63;.
     *
     * @param sendDate the send date to search with
     * @return the matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySendDate(Date sendDate)
        throws SystemException {
        return findBySendDate(sendDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Finds a range of all the send campaigns where sendDate = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySendDate(Date sendDate, int start, int end)
        throws SystemException {
        return findBySendDate(sendDate, start, end, null);
    }

    /**
     * Finds an ordered range of all the send campaigns where sendDate = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySendDate(Date sendDate, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                sendDate,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<SendCampaign> list = (List<SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SENDDATE,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

            if (sendDate == null) {
                query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SENDDATE,
                        finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SENDDATE,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Finds the first send campaign in the ordered set where sendDate = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findBySendDate_First(Date sendDate,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        List<SendCampaign> list = findBySendDate(sendDate, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sendDate=");
            msg.append(sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last send campaign in the ordered set where sendDate = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findBySendDate_Last(Date sendDate,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        int count = countBySendDate(sendDate);

        List<SendCampaign> list = findBySendDate(sendDate, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sendDate=");
            msg.append(sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the send campaigns before and after the current send campaign in the ordered set where sendDate = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendCampaignId the primary key of the current send campaign
     * @param sendDate the send date to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign[] findBySendDate_PrevAndNext(long sendCampaignId,
        Date sendDate, OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        SendCampaign sendCampaign = findByPrimaryKey(sendCampaignId);

        Session session = null;

        try {
            session = openSession();

            SendCampaign[] array = new SendCampaignImpl[3];

            array[0] = getBySendDate_PrevAndNext(session, sendCampaign,
                    sendDate, orderByComparator, true);

            array[1] = sendCampaign;

            array[2] = getBySendDate_PrevAndNext(session, sendCampaign,
                    sendDate, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SendCampaign getBySendDate_PrevAndNext(Session session,
        SendCampaign sendCampaign, Date sendDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

        if (sendDate == null) {
            query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_1);
        } else {
            query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_2);
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
        else {
            query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sendDate != null) {
            qPos.add(CalendarUtil.getTimestamp(sendDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(sendCampaign);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SendCampaign> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the send campaigns where sendDate &le; &#63; and sent = &#63;.
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @return the matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySD_LT(Date sendDate, boolean sent)
        throws SystemException {
        return findBySD_LT(sendDate, sent, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySD_LT(Date sendDate, boolean sent,
        int start, int end) throws SystemException {
        return findBySD_LT(sendDate, sent, start, end, null);
    }

    /**
     * Finds an ordered range of all the send campaigns where sendDate &le; &#63; and sent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findBySD_LT(Date sendDate, boolean sent,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                sendDate, sent,
                
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<SendCampaign> list = (List<SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SD_LT,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

            if (sendDate == null) {
                query.append(_FINDER_COLUMN_SD_LT_SENDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_SD_LT_SENDDATE_2);
            }

            query.append(_FINDER_COLUMN_SD_LT_SENT_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                qPos.add(sent);

                list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SD_LT,
                        finderArgs);
                } else {
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
     * Finds the first send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @param orderByComparator the comparator to order the set by
     * @return the first matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findBySD_LT_First(Date sendDate, boolean sent,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        List<SendCampaign> list = findBySD_LT(sendDate, sent, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sendDate=");
            msg.append(sendDate);

            msg.append(", sent=");
            msg.append(sent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the last send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @param orderByComparator the comparator to order the set by
     * @return the last matching send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a matching send campaign could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign findBySD_LT_Last(Date sendDate, boolean sent,
        OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        int count = countBySD_LT(sendDate, sent);

        List<SendCampaign> list = findBySD_LT(sendDate, sent, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sendDate=");
            msg.append(sendDate);

            msg.append(", sent=");
            msg.append(sent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendCampaignException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Finds the send campaigns before and after the current send campaign in the ordered set where sendDate &le; &#63; and sent = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sendCampaignId the primary key of the current send campaign
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @param orderByComparator the comparator to order the set by
     * @return the previous, current, and next send campaign
     * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SendCampaign[] findBySD_LT_PrevAndNext(long sendCampaignId,
        Date sendDate, boolean sent, OrderByComparator orderByComparator)
        throws NoSuchSendCampaignException, SystemException {
        SendCampaign sendCampaign = findByPrimaryKey(sendCampaignId);

        Session session = null;

        try {
            session = openSession();

            SendCampaign[] array = new SendCampaignImpl[3];

            array[0] = getBySD_LT_PrevAndNext(session, sendCampaign, sendDate,
                    sent, orderByComparator, true);

            array[1] = sendCampaign;

            array[2] = getBySD_LT_PrevAndNext(session, sendCampaign, sendDate,
                    sent, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SendCampaign getBySD_LT_PrevAndNext(Session session,
        SendCampaign sendCampaign, Date sendDate, boolean sent,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SENDCAMPAIGN_WHERE);

        if (sendDate == null) {
            query.append(_FINDER_COLUMN_SD_LT_SENDDATE_1);
        } else {
            query.append(_FINDER_COLUMN_SD_LT_SENDDATE_2);
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
        else {
            query.append(SendCampaignModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sendDate != null) {
            qPos.add(CalendarUtil.getTimestamp(sendDate));
        }

        qPos.add(sent);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByValues(sendCampaign);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SendCampaign> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Finds all the send campaigns.
     *
     * @return the send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Finds a range of all the send campaigns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Finds an ordered range of all the send campaigns.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of send campaigns
     * @throws SystemException if a system exception occurred
     */
    public List<SendCampaign> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<SendCampaign> list = (List<SendCampaign>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SENDCAMPAIGN);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SENDCAMPAIGN.concat(SendCampaignModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<SendCampaign>) QueryUtil.list(q, getDialect(),
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
     * Removes all the send campaigns where uuid = &#63; from the database.
     *
     * @param uuid the uuid to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByUuid(String uuid) throws SystemException {
        for (SendCampaign sendCampaign : findByUuid(uuid)) {
            remove(sendCampaign);
        }
    }

    /**
     * Removes all the send campaigns where campaignId = &#63; from the database.
     *
     * @param campaignId the campaign id to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeByCampaign(long campaignId) throws SystemException {
        for (SendCampaign sendCampaign : findByCampaign(campaignId)) {
            remove(sendCampaign);
        }
    }

    /**
     * Removes all the send campaigns where sendDate = &#63; from the database.
     *
     * @param sendDate the send date to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeBySendDate(Date sendDate) throws SystemException {
        for (SendCampaign sendCampaign : findBySendDate(sendDate)) {
            remove(sendCampaign);
        }
    }

    /**
     * Removes all the send campaigns where sendDate &le; &#63; and sent = &#63; from the database.
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @throws SystemException if a system exception occurred
     */
    public void removeBySD_LT(Date sendDate, boolean sent)
        throws SystemException {
        for (SendCampaign sendCampaign : findBySD_LT(sendDate, sent)) {
            remove(sendCampaign);
        }
    }

    /**
     * Removes all the send campaigns from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (SendCampaign sendCampaign : findAll()) {
            remove(sendCampaign);
        }
    }

    /**
     * Counts all the send campaigns where uuid = &#63;.
     *
     * @param uuid the uuid to search with
     * @return the number of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countByUuid(String uuid) throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENDCAMPAIGN_WHERE);

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
     * Counts all the send campaigns where campaignId = &#63;.
     *
     * @param campaignId the campaign id to search with
     * @return the number of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countByCampaign(long campaignId) throws SystemException {
        Object[] finderArgs = new Object[] { campaignId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAMPAIGN,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENDCAMPAIGN_WHERE);

            query.append(_FINDER_COLUMN_CAMPAIGN_CAMPAIGNID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(campaignId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the send campaigns where sendDate = &#63;.
     *
     * @param sendDate the send date to search with
     * @return the number of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countBySendDate(Date sendDate) throws SystemException {
        Object[] finderArgs = new Object[] { sendDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SENDDATE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SENDCAMPAIGN_WHERE);

            if (sendDate == null) {
                query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_SENDDATE_SENDDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SENDDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Counts all the send campaigns where sendDate &le; &#63; and sent = &#63;.
     *
     * @param sendDate the send date to search with
     * @param sent the sent to search with
     * @return the number of matching send campaigns
     * @throws SystemException if a system exception occurred
     */
    public int countBySD_LT(Date sendDate, boolean sent)
        throws SystemException {
        Object[] finderArgs = new Object[] { sendDate, sent };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SD_LT,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SENDCAMPAIGN_WHERE);

            if (sendDate == null) {
                query.append(_FINDER_COLUMN_SD_LT_SENDDATE_1);
            } else {
                query.append(_FINDER_COLUMN_SD_LT_SENDDATE_2);
            }

            query.append(_FINDER_COLUMN_SD_LT_SENT_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                qPos.add(sent);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
     * Counts all the send campaigns.
     *
     * @return the number of send campaigns
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

                Query q = session.createQuery(_SQL_COUNT_SENDCAMPAIGN);

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
     * Gets all the newsletter logs associated with the send campaign.
     *
     * @param pk the primary key of the send campaign to get the associated newsletter logs for
     * @return the newsletter logs associated with the send campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk) throws SystemException {
        return getNewsletterLogs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Gets a range of all the newsletter logs associated with the send campaign.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the send campaign to get the associated newsletter logs for
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @return the range of newsletter logs associated with the send campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end) throws SystemException {
        return getNewsletterLogs(pk, start, end, null);
    }

    /**
     * Gets an ordered range of all the newsletter logs associated with the send campaign.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the send campaign to get the associated newsletter logs for
     * @param start the lower bound of the range of send campaigns to return
     * @param end the upper bound of the range of send campaigns to return (not inclusive)
     * @param orderByComparator the comparator to order the results by
     * @return the ordered range of newsletter logs associated with the send campaign
     * @throws SystemException if a system exception occurred
     */
    public List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                pk, String.valueOf(start), String.valueOf(end),
                String.valueOf(orderByComparator)
            };

        List<com.liferay.newsletter.model.NewsletterLog> list = (List<com.liferay.newsletter.model.NewsletterLog>) FinderCacheUtil.getResult(FINDER_PATH_GET_NEWSLETTERLOGS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETNEWSLETTERLOGS.concat(ORDER_BY_CLAUSE)
                                                .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETNEWSLETTERLOGS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("Newsletter_NewsletterLog",
                    com.liferay.newsletter.model.impl.NewsletterLogImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.liferay.newsletter.model.NewsletterLog>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_NEWSLETTERLOGS,
                        finderArgs);
                } else {
                    newsletterLogPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_NEWSLETTERLOGS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Gets the number of newsletter logs associated with the send campaign.
     *
     * @param pk the primary key of the send campaign to get the number of associated newsletter logs for
     * @return the number of newsletter logs associated with the send campaign
     * @throws SystemException if a system exception occurred
     */
    public int getNewsletterLogsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_NEWSLETTERLOGS_SIZE,
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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

    /**
     * Determines if the newsletter log is associated with the send campaign.
     *
     * @param pk the primary key of the send campaign
     * @param newsletterLogPK the primary key of the newsletter log
     * @return <code>true</code> if the newsletter log is associated with the send campaign; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsNewsletterLog(long pk, long newsletterLogPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, newsletterLogPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_NEWSLETTERLOG,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsNewsletterLog.contains(pk,
                            newsletterLogPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
     * Determines if the send campaign has any newsletter logs associated with it.
     *
     * @param pk the primary key of the send campaign to check for associations with newsletter logs
     * @return <code>true</code> if the send campaign has any newsletter logs associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsNewsletterLogs(long pk) throws SystemException {
        if (getNewsletterLogsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the send campaign persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.newsletter.model.SendCampaign")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SendCampaign>> listenersList = new ArrayList<ModelListener<SendCampaign>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SendCampaign>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsNewsletterLog = new ContainsNewsletterLog(this);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SendCampaignImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
    }

    protected class ContainsNewsletterLog {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsNewsletterLog(
            SendCampaignPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSNEWSLETTERLOG,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long sendCampaignId, long newsletterLogId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(sendCampaignId), new Long(newsletterLogId)
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
