package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.Contact;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see ContactPersistenceImpl
 * @see ContactUtil
 * @generated
 */
public interface ContactPersistence extends BasePersistence<Contact> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the contact in the entity cache if it is enabled.
    *
    * @param contact the contact to cache
    */
    public void cacheResult(com.liferay.newsletter.model.Contact contact);

    /**
    * Caches the contacts in the entity cache if it is enabled.
    *
    * @param contacts the contacts to cache
    */
    public void cacheResult(
        java.util.List<com.liferay.newsletter.model.Contact> contacts);

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param contactId the primary key for the new contact
    * @return the new contact
    */
    public com.liferay.newsletter.model.Contact create(long contactId);

    /**
    * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the contact to remove
    * @return the contact that was removed
    * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact remove(long contactId)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.newsletter.model.Contact updateImpl(
        com.liferay.newsletter.model.Contact contact, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the contact with the primary key or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
    *
    * @param contactId the primary key of the contact to find
    * @return the contact
    * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact findByPrimaryKey(long contactId)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the contact to find
    * @return the contact, or <code>null</code> if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact fetchByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the contacts where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds a range of all the contacts where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @return the range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds an ordered range of all the contacts where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the first contact in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the first matching contact
    * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the last contact in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the last matching contact
    * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds the contacts before and after the current contact in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param contactId the primary key of the current contact
    * @param uuid the uuid to search with
    * @param orderByComparator the comparator to order the set by
    * @return the previous, current, and next contact
    * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.newsletter.model.Contact[] findByUuid_PrevAndNext(
        long contactId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds all the contacts.
    *
    * @return the contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds a range of all the contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @return the range of contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Finds an ordered range of all the contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.Contact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts where uuid = &#63; from the database.
    *
    * @param uuid the uuid to search with
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the contacts where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Counts all the contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets all the newsletter logs associated with the contact.
    *
    * @param pk the primary key of the contact to get the associated newsletter logs for
    * @return the newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets a range of all the newsletter logs associated with the contact.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the contact to get the associated newsletter logs for
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @return the range of newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets an ordered range of all the newsletter logs associated with the contact.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the contact to get the associated newsletter logs for
    * @param start the lower bound of the range of contacts to return
    * @param end the upper bound of the range of contacts to return (not inclusive)
    * @param orderByComparator the comparator to order the results by
    * @return the ordered range of newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Gets the number of newsletter logs associated with the contact.
    *
    * @param pk the primary key of the contact to get the number of associated newsletter logs for
    * @return the number of newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public int getNewsletterLogsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the newsletter log is associated with the contact.
    *
    * @param pk the primary key of the contact
    * @param newsletterLogPK the primary key of the newsletter log
    * @return <code>true</code> if the newsletter log is associated with the contact; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsNewsletterLog(long pk, long newsletterLogPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Determines if the contact has any newsletter logs associated with it.
    *
    * @param pk the primary key of the contact to check for associations with newsletter logs
    * @return <code>true</code> if the contact has any newsletter logs associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsNewsletterLogs(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
