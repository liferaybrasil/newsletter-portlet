package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.Campaign;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see CampaignPersistenceImpl
 * @see CampaignUtil
 * @generated
 */
public interface CampaignPersistence extends BasePersistence<Campaign> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CampaignUtil} to access the campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the campaign in the entity cache if it is enabled.
    *
    * @param campaign the campaign to cache
    */
    public void cacheResult(com.liferay.newsletter.model.Campaign campaign);

    /**
    * Caches the campaigns in the entity cache if it is enabled.
    *
    * @param campaigns the campaigns to cache
    */
    public void cacheResult(
        java.util.List<com.liferay.newsletter.model.Campaign> campaigns);

    /**
    * Creates a new campaign with the primary key. Does not add the campaign to the database.
    *
    * @param campaignId the primary key for the new campaign
    * @return the new campaign
    */
    public com.liferay.newsletter.model.Campaign create(long campaignId);

    /**
    * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param campaignId the primary key of the campaign to remove
    * @return the campaign that was removed
    * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Campaign remove(long campaignId)
        throws com.liferay.newsletter.NoSuchCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.newsletter.model.Campaign updateImpl(
        com.liferay.newsletter.model.Campaign campaign, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the campaign with the primary key or throws a {@link com.liferay.newsletter.NoSuchCampaignException} if it could not be found.
    *
    * @param campaignId the primary key of the campaign to find
    * @return the campaign
    * @throws com.liferay.newsletter.NoSuchCampaignException if a campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Campaign findByPrimaryKey(
        long campaignId)
        throws com.liferay.newsletter.NoSuchCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the campaign with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param campaignId the primary key of the campaign to find
    * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Campaign fetchByPrimaryKey(
        long campaignId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.Campaign> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.Campaign findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.Campaign findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.newsletter.model.Campaign[] findByUuid_PrevAndNext(
        long campaignId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchCampaignException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Filters by the user's permissions and finds all the campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching campaigns that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Filters by the user's permissions and finds a range of all the campaigns where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of campaigns to return
    * @param end the upper bound of the range of campaigns to return (not inclusive)
    * @return the range of matching campaigns that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Filters by the user's permissions and finds an ordered range of all the campaigns where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of campaigns to return
    * @param end the upper bound of the range of campaigns to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching campaigns that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Campaign> filterFindByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the campaigns.
    *
    * @return the campaigns
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Campaign> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.Campaign> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.Campaign> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the campaigns where uuid = &#63; from the database.
    *
    * @param uuid the uuid to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the campaigns from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Filters by the user's permissions and counts all the campaigns where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching campaigns that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public int filterCountByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the campaigns.
    *
    * @return the number of campaigns
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets all the send campaigns associated with the campaign.
    *
    * @param pk the primary key of the campaign to get the associated send campaigns for
    * @return the send campaigns associated with the campaign
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of send campaigns associated with the campaign.
    *
    * @param pk the primary key of the campaign to get the number of associated send campaigns for
    * @return the number of send campaigns associated with the campaign
    * @throws SystemException if a system exception occurred
    */
    public int getSendCampaignsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the send campaign is associated with the campaign.
    *
    * @param pk the primary key of the campaign
    * @param sendCampaignPK the primary key of the send campaign
    * @return <code>true</code> if the send campaign is associated with the campaign; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsSendCampaign(long pk, long sendCampaignPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the campaign has any send campaigns associated with it.
    *
    * @param pk the primary key of the campaign to check for associations with send campaigns
    * @return <code>true</code> if the campaign has any send campaigns associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsSendCampaigns(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
