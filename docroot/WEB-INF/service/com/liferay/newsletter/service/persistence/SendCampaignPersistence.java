package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.SendCampaign;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the send campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see SendCampaignPersistenceImpl
 * @see SendCampaignUtil
 * @generated
 */
public interface SendCampaignPersistence extends BasePersistence<SendCampaign> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SendCampaignUtil} to access the send campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the send campaign in the entity cache if it is enabled.
    *
    * @param sendCampaign the send campaign to cache
    */
    public void cacheResult(
        com.liferay.newsletter.model.SendCampaign sendCampaign);

    /**
    * Caches the send campaigns in the entity cache if it is enabled.
    *
    * @param sendCampaigns the send campaigns to cache
    */
    public void cacheResult(
        java.util.List<com.liferay.newsletter.model.SendCampaign> sendCampaigns);

    /**
    * Creates a new send campaign with the primary key. Does not add the send campaign to the database.
    *
    * @param sendCampaignId the primary key for the new send campaign
    * @return the new send campaign
    */
    public com.liferay.newsletter.model.SendCampaign create(long sendCampaignId);

    /**
    * Removes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaignId the primary key of the send campaign to remove
    * @return the send campaign that was removed
    * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.SendCampaign remove(long sendCampaignId)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.newsletter.model.SendCampaign updateImpl(
        com.liferay.newsletter.model.SendCampaign sendCampaign, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the send campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchSendCampaignException} if it could not be found.
    *
    * @param sendCampaignId the primary key of the send campaign to find
    * @return the send campaign
    * @throws com.liferay.newsletter.NoSuchSendCampaignException if a send campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.SendCampaign findByPrimaryKey(
        long sendCampaignId)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the send campaign with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param sendCampaignId the primary key of the send campaign to find
    * @return the send campaign, or <code>null</code> if a send campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.SendCampaign fetchByPrimaryKey(
        long sendCampaignId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the send campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign[] findByUuid_PrevAndNext(
        long sendCampaignId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the send campaigns where sendDate = &#63;.
    *
    * @param sendDate the send date to search with
    * @return the matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
        java.util.Date sendDate)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
        java.util.Date sendDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySendDate(
        java.util.Date sendDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findBySendDate_First(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findBySendDate_Last(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign[] findBySendDate_PrevAndNext(
        long sendCampaignId, java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the send campaigns where sendDate &le; &#63; and sent = &#63;.
    *
    * @param sendDate the send date to search with
    * @param sent the sent to search with
    * @return the matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
        java.util.Date sendDate, boolean sent)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
        java.util.Date sendDate, boolean sent, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findBySD_LT(
        java.util.Date sendDate, boolean sent, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findBySD_LT_First(
        java.util.Date sendDate, boolean sent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign findBySD_LT_Last(
        java.util.Date sendDate, boolean sent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.SendCampaign[] findBySD_LT_PrevAndNext(
        long sendCampaignId, java.util.Date sendDate, boolean sent,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchSendCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the send campaigns.
    *
    * @return the send campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the send campaigns where uuid = &#63; from the database.
    *
    * @param uuid the uuid to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the send campaigns where sendDate = &#63; from the database.
    *
    * @param sendDate the send date to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the send campaigns where sendDate &le; &#63; and sent = &#63; from the database.
    *
    * @param sendDate the send date to search with
    * @param sent the sent to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeBySD_LT(java.util.Date sendDate, boolean sent)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the send campaigns from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the send campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the send campaigns where sendDate = &#63;.
    *
    * @param sendDate the send date to search with
    * @return the number of matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the send campaigns where sendDate &le; &#63; and sent = &#63;.
    *
    * @param sendDate the send date to search with
    * @param sent the sent to search with
    * @return the number of matching send campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countBySD_LT(java.util.Date sendDate, boolean sent)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the send campaigns.
    *
    * @return the number of send campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets all the newsletter logs associated with the send campaign.
    *
    * @param pk the primary key of the send campaign to get the associated newsletter logs for
    * @return the newsletter logs associated with the send campaign
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of newsletter logs associated with the send campaign.
    *
    * @param pk the primary key of the send campaign to get the number of associated newsletter logs for
    * @return the number of newsletter logs associated with the send campaign
    * @throws SystemException if a system exception occurred
    */
    public int getNewsletterLogsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the newsletter log is associated with the send campaign.
    *
    * @param pk the primary key of the send campaign
    * @param newsletterLogPK the primary key of the newsletter log
    * @return <code>true</code> if the newsletter log is associated with the send campaign; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsNewsletterLog(long pk, long newsletterLogPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the send campaign has any newsletter logs associated with it.
    *
    * @param pk the primary key of the send campaign to check for associations with newsletter logs
    * @return <code>true</code> if the send campaign has any newsletter logs associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsNewsletterLogs(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
