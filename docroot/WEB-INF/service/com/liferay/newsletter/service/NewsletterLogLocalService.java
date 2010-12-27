package com.liferay.newsletter.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the newsletter log local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see NewsletterLogLocalServiceUtil
 * @see com.liferay.newsletter.service.base.NewsletterLogLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.NewsletterLogLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface NewsletterLogLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link NewsletterLogLocalServiceUtil} to access the newsletter log local service. Add custom service methods to {@link com.liferay.newsletter.service.impl.NewsletterLogLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the newsletter log to the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLog the newsletter log to add
    * @return the newsletter log that was added
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.NewsletterLog addNewsletterLog(
        com.liferay.newsletter.model.NewsletterLog newsletterLog)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new newsletter log with the primary key. Does not add the newsletter log to the database.
    *
    * @param newsletterLogId the primary key for the new newsletter log
    * @return the new newsletter log
    */
    public com.liferay.newsletter.model.NewsletterLog createNewsletterLog(
        long newsletterLogId);

    /**
    * Deletes the newsletter log with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLogId the primary key of the newsletter log to delete
    * @throws PortalException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteNewsletterLog(long newsletterLogId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the newsletter log from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLog the newsletter log to delete
    * @throws SystemException if a system exception occurred
    */
    public void deleteNewsletterLog(
        com.liferay.newsletter.model.NewsletterLog newsletterLog)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query to search with
    * @param start the lower bound of the range of model instances to return
    * @param end the upper bound of the range of model instances to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the newsletter log with the primary key.
    *
    * @param newsletterLogId the primary key of the newsletter log to get
    * @return the newsletter log
    * @throws PortalException if a newsletter log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.newsletter.model.NewsletterLog getNewsletterLog(
        long newsletterLogId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a range of all the newsletter logs.
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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of newsletter logs.
    *
    * @return the number of newsletter logs
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getNewsletterLogsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the newsletter log in the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLog the newsletter log to update
    * @return the newsletter log that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.NewsletterLog updateNewsletterLog(
        com.liferay.newsletter.model.NewsletterLog newsletterLog)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the newsletter log in the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterLog the newsletter log to update
    * @param merge whether to merge the newsletter log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the newsletter log that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.NewsletterLog updateNewsletterLog(
        com.liferay.newsletter.model.NewsletterLog newsletterLog, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogBySendCampaign(
        long sendCampaignId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
