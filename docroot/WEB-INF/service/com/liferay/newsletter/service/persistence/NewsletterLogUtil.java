package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.NewsletterLog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the newsletter log service. This utility wraps {@link NewsletterLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see NewsletterLogPersistence
 * @see NewsletterLogPersistenceImpl
 * @generated
 */
public class NewsletterLogUtil {
    private static NewsletterLogPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(NewsletterLog newsletterLog) {
        getPersistence().clearCache(newsletterLog);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<NewsletterLog> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<NewsletterLog> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<NewsletterLog> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
     */
    public static NewsletterLog remove(NewsletterLog newsletterLog)
        throws SystemException {
        return getPersistence().remove(newsletterLog);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static NewsletterLog update(NewsletterLog newsletterLog,
        boolean merge) throws SystemException {
        return getPersistence().update(newsletterLog, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static NewsletterLog update(NewsletterLog newsletterLog,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(newsletterLog, merge, serviceContext);
    }

    /**
    * Caches the newsletter log in the entity cache if it is enabled.
    *
    * @param newsletterLog the newsletter log to cache
    */
    public static void cacheResult(
        com.liferay.newsletter.model.NewsletterLog newsletterLog) {
        getPersistence().cacheResult(newsletterLog);
    }

    /**
    * Caches the newsletter logs in the entity cache if it is enabled.
    *
    * @param newsletterLogs the newsletter logs to cache
    */
    public static void cacheResult(
        java.util.List<com.liferay.newsletter.model.NewsletterLog> newsletterLogs) {
        getPersistence().cacheResult(newsletterLogs);
    }

    /**
    * Creates a new newsletter log with the primary key. Does not add the newsletter log to the database.
    *
    * @param newsletterLogId the primary key for the new newsletter log
    * @return the new newsletter log
    */
    public static com.liferay.newsletter.model.NewsletterLog create(
        long newsletterLogId) {
        return getPersistence().create(newsletterLogId);
    }

    /**
    * Removes the newsletter log with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLogId the primary key of the newsletter log to remove
    * @return the newsletter log that was removed
    * @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog remove(
        long newsletterLogId)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(newsletterLogId);
    }

    public static com.liferay.newsletter.model.NewsletterLog updateImpl(
        com.liferay.newsletter.model.NewsletterLog newsletterLog, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(newsletterLog, merge);
    }

    /**
    * Finds the newsletter log with the primary key or throws a {@link com.liferay.newsletter.NoSuchLogException} if it could not be found.
    *
    * @param newsletterLogId the primary key of the newsletter log to find
    * @return the newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog findByPrimaryKey(
        long newsletterLogId)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(newsletterLogId);
    }

    /**
    * Finds the newsletter log with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsletterLogId the primary key of the newsletter log to find
    * @return the newsletter log, or <code>null</code> if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog fetchByPrimaryKey(
        long newsletterLogId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(newsletterLogId);
    }

    /**
    * Finds all the newsletter logs where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Finds a range of all the newsletter logs where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @return the range of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Finds an ordered range of all the newsletter logs where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Finds the first newsletter log in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the first matching newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Finds the last newsletter log in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the last matching newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Finds the newsletter logs before and after the current newsletter log in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsletterLogId the primary key of the current newsletter log
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the previous, current, and next newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog[] findByUuid_PrevAndNext(
        long newsletterLogId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(newsletterLogId, uuid,
            orderByComparator);
    }

    /**
    * Finds all the newsletter logs where sendCampaignId = &#63;.
    *
    * @param sendCampaignId the send campaign id to search with
    * @return the matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
        long sendCampaignId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySendCampaign(sendCampaignId);
    }

    /**
    * Finds a range of all the newsletter logs where sendCampaignId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sendCampaignId the send campaign id to search with
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @return the range of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
        long sendCampaignId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySendCampaign(sendCampaignId, start, end);
    }

    /**
    * Finds an ordered range of all the newsletter logs where sendCampaignId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sendCampaignId the send campaign id to search with
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findBySendCampaign(
        long sendCampaignId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySendCampaign(sendCampaignId, start, end,
            orderByComparator);
    }

    /**
    * Finds the first newsletter log in the ordered set where sendCampaignId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sendCampaignId the send campaign id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the first matching newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog findBySendCampaign_First(
        long sendCampaignId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySendCampaign_First(sendCampaignId, orderByComparator);
    }

    /**
    * Finds the last newsletter log in the ordered set where sendCampaignId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sendCampaignId the send campaign id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the last matching newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a matching newsletter log could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog findBySendCampaign_Last(
        long sendCampaignId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySendCampaign_Last(sendCampaignId, orderByComparator);
    }

    /**
    * Finds the newsletter logs before and after the current newsletter log in the ordered set where sendCampaignId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsletterLogId the primary key of the current newsletter log
    * @param sendCampaignId the send campaign id to search with
    * @param orderByComparator the comparator to order the set by
    * @return the previous, current, and next newsletter log
    * @throws com.liferay.newsletter.NoSuchLogException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.NewsletterLog[] findBySendCampaign_PrevAndNext(
        long newsletterLogId, long sendCampaignId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchLogException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySendCampaign_PrevAndNext(newsletterLogId,
            sendCampaignId, orderByComparator);
    }

    /**
    * Finds all the newsletter logs.
    *
    * @return the newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Finds a range of all the newsletter logs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @return the range of newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Finds an ordered range of all the newsletter logs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletter logs to return
    * @param end the upper bound of the range of newsletter logs to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the newsletter logs where uuid = &#63; from the database.
    *
    * @param uuid the uuid to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Removes all the newsletter logs where sendCampaignId = &#63; from the database.
    *
    * @param sendCampaignId the send campaign id to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySendCampaign(long sendCampaignId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySendCampaign(sendCampaignId);
    }

    /**
    * Removes all the newsletter logs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Counts all the newsletter logs where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Counts all the newsletter logs where sendCampaignId = &#63;.
    *
    * @param sendCampaignId the send campaign id to search with
    * @return the number of matching newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static int countBySendCampaign(long sendCampaignId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySendCampaign(sendCampaignId);
    }

    /**
    * Counts all the newsletter logs.
    *
    * @return the number of newsletter logs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static NewsletterLogPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NewsletterLogPersistence) PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.SERVLET_CONTEXT_NAME,
                    NewsletterLogPersistence.class.getName());

            ReferenceRegistry.registerReference(NewsletterLogUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(NewsletterLogPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(NewsletterLogUtil.class,
            "_persistence");
    }
}
