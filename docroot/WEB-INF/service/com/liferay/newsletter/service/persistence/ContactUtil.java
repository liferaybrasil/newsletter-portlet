package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.Contact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contact service. This utility wraps {@link ContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Bruno Pinheiro
 * @see ContactPersistence
 * @see ContactPersistenceImpl
 * @generated
 */
public class ContactUtil {
    private static ContactPersistence _persistence;

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
    public static void clearCache(Contact contact) {
        getPersistence().clearCache(contact);
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
    public static List<Contact> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Contact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Contact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
     */
    public static Contact remove(Contact contact) throws SystemException {
        return getPersistence().remove(contact);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Contact update(Contact contact, boolean merge)
        throws SystemException {
        return getPersistence().update(contact, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Contact update(Contact contact, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(contact, merge, serviceContext);
    }

    /**
    * Caches the contact in the entity cache if it is enabled.
    *
    * @param contact the contact to cache
    */
    public static void cacheResult(com.liferay.newsletter.model.Contact contact) {
        getPersistence().cacheResult(contact);
    }

    /**
    * Caches the contacts in the entity cache if it is enabled.
    *
    * @param contacts the contacts to cache
    */
    public static void cacheResult(
        java.util.List<com.liferay.newsletter.model.Contact> contacts) {
        getPersistence().cacheResult(contacts);
    }

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param contactId the primary key for the new contact
    * @return the new contact
    */
    public static com.liferay.newsletter.model.Contact create(long contactId) {
        return getPersistence().create(contactId);
    }

    /**
    * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the contact to remove
    * @return the contact that was removed
    * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact remove(long contactId)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(contactId);
    }

    public static com.liferay.newsletter.model.Contact updateImpl(
        com.liferay.newsletter.model.Contact contact, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contact, merge);
    }

    /**
    * Finds the contact with the primary key or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
    *
    * @param contactId the primary key of the contact to find
    * @return the contact
    * @throws com.liferay.newsletter.NoSuchContactException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact findByPrimaryKey(
        long contactId)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(contactId);
    }

    /**
    * Finds the contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contactId the primary key of the contact to find
    * @return the contact, or <code>null</code> if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact fetchByPrimaryKey(
        long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contactId);
    }

    /**
    * Finds all the contacts where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

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
    public static java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

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
    public static java.util.List<com.liferay.newsletter.model.Contact> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

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
    public static com.liferay.newsletter.model.Contact findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

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
    public static com.liferay.newsletter.model.Contact findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

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
    public static com.liferay.newsletter.model.Contact[] findByUuid_PrevAndNext(
        long contactId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_PrevAndNext(contactId, uuid, orderByComparator);
    }

    /**
    * Finds the contact where email = &#63; or throws a {@link com.liferay.newsletter.NoSuchContactException} if it could not be found.
    *
    * @param email the email to search with
    * @return the matching contact
    * @throws com.liferay.newsletter.NoSuchContactException if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact findByEmail(
        java.lang.String email)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email);
    }

    /**
    * Finds the contact where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param email the email to search with
    * @return the matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact fetchByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail(email);
    }

    /**
    * Finds the contact where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param email the email to search with
    * @return the matching contact, or <code>null</code> if a matching contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact fetchByEmail(
        java.lang.String email, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail(email, retrieveFromCache);
    }

    /**
    * Finds all the contacts.
    *
    * @return the contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.Contact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.liferay.newsletter.model.Contact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.liferay.newsletter.model.Contact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contacts where uuid = &#63; from the database.
    *
    * @param uuid the uuid to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Removes the contact where email = &#63; from the database.
    *
    * @param email the email to search with
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEmail(java.lang.String email)
        throws com.liferay.newsletter.NoSuchContactException,
            com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEmail(email);
    }

    /**
    * Removes all the contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Counts all the contacts where uuid = &#63;.
    *
    * @param uuid the uuid to search with
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Counts all the contacts where email = &#63;.
    *
    * @param email the email to search with
    * @return the number of matching contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmail(email);
    }

    /**
    * Counts all the contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Gets all the newsletter logs associated with the contact.
    *
    * @param pk the primary key of the contact to get the associated newsletter logs for
    * @return the newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getNewsletterLogs(pk);
    }

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
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getNewsletterLogs(pk, start, end);
    }

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
    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getNewsletterLogs(pk, start, end, orderByComparator);
    }

    /**
    * Gets the number of newsletter logs associated with the contact.
    *
    * @param pk the primary key of the contact to get the number of associated newsletter logs for
    * @return the number of newsletter logs associated with the contact
    * @throws SystemException if a system exception occurred
    */
    public static int getNewsletterLogsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getNewsletterLogsSize(pk);
    }

    /**
    * Determines if the newsletter log is associated with the contact.
    *
    * @param pk the primary key of the contact
    * @param newsletterLogPK the primary key of the newsletter log
    * @return <code>true</code> if the newsletter log is associated with the contact; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsNewsletterLog(long pk, long newsletterLogPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsNewsletterLog(pk, newsletterLogPK);
    }

    /**
    * Determines if the contact has any newsletter logs associated with it.
    *
    * @param pk the primary key of the contact to check for associations with newsletter logs
    * @return <code>true</code> if the contact has any newsletter logs associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsNewsletterLogs(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsNewsletterLogs(pk);
    }

    public static ContactPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContactPersistence) PortletBeanLocatorUtil.locate(com.liferay.newsletter.service.ClpSerializer.SERVLET_CONTEXT_NAME,
                    ContactPersistence.class.getName());

            ReferenceRegistry.registerReference(ContactUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(ContactPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(ContactUtil.class, "_persistence");
    }
}
