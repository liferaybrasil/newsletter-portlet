package com.liferay.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the contact local service. This utility wraps {@link com.liferay.newsletter.service.impl.ContactLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see ContactLocalService
 * @see com.liferay.newsletter.service.base.ContactLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.ContactLocalServiceImpl
 * @generated
 */
public class ContactLocalServiceUtil {
    private static ContactLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.newsletter.service.impl.ContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contact to the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact to add
    * @return the contact that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact addContact(
        com.liferay.newsletter.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContact(contact);
    }

    /**
    * Creates a new contact with the primary key. Does not add the contact to the database.
    *
    * @param contactId the primary key for the new contact
    * @return the new contact
    */
    public static com.liferay.newsletter.model.Contact createContact(
        long contactId) {
        return getService().createContact(contactId);
    }

    /**
    * Deletes the contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contactId the primary key of the contact to delete
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteContact(long contactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteContact(contactId);
    }

    /**
    * Deletes the contact from the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact to delete
    * @throws SystemException if a system exception occurred
    */
    public static void deleteContact(
        com.liferay.newsletter.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteContact(contact);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Counts the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query to search with
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Gets the contact with the primary key.
    *
    * @param contactId the primary key of the contact to get
    * @return the contact
    * @throws PortalException if a contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact getContact(
        long contactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContact(contactId);
    }

    /**
    * Gets a range of all the contacts.
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
    public static java.util.List<com.liferay.newsletter.model.Contact> getContacts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContacts(start, end);
    }

    /**
    * Gets the number of contacts.
    *
    * @return the number of contacts
    * @throws SystemException if a system exception occurred
    */
    public static int getContactsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactsCount();
    }

    /**
    * Updates the contact in the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact to update
    * @return the contact that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact updateContact(
        com.liferay.newsletter.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContact(contact);
    }

    /**
    * Updates the contact in the database. Also notifies the appropriate model listeners.
    *
    * @param contact the contact to update
    * @param merge whether to merge the contact with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contact that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.Contact updateContact(
        com.liferay.newsletter.model.Contact contact, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContact(contact, merge);
    }

    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        com.liferay.newsletter.model.Contact contact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewsletterLogs(contact);
    }

    public static com.liferay.newsletter.model.Contact getContactByEmail(
        java.lang.String contactEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContactByEmail(contactEmail);
    }

    public static void clearService() {
        _service = null;
    }

    public static ContactLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    ContactLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    ContactLocalService.class.getName(), portletClassLoader);

            _service = new ContactLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(ContactLocalServiceUtil.class,
                "_service");
            MethodCache.remove(ContactLocalService.class);
        }

        return _service;
    }

    public void setService(ContactLocalService service) {
        MethodCache.remove(ContactLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(ContactLocalServiceUtil.class,
            "_service");
        MethodCache.remove(ContactLocalService.class);
    }
}
