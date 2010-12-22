package com.liferay.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the send campaign local service. This utility wraps {@link com.liferay.newsletter.service.impl.SendCampaignLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno Pinheiro
 * @see SendCampaignLocalService
 * @see com.liferay.newsletter.service.base.SendCampaignLocalServiceBaseImpl
 * @see com.liferay.newsletter.service.impl.SendCampaignLocalServiceImpl
 * @generated
 */
public class SendCampaignLocalServiceUtil {
    private static SendCampaignLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.newsletter.service.impl.SendCampaignLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the send campaign to the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaign the send campaign to add
    * @return the send campaign that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.SendCampaign addSendCampaign(
        com.liferay.newsletter.model.SendCampaign sendCampaign)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSendCampaign(sendCampaign);
    }

    /**
    * Creates a new send campaign with the primary key. Does not add the send campaign to the database.
    *
    * @param sendCampaignId the primary key for the new send campaign
    * @return the new send campaign
    */
    public static com.liferay.newsletter.model.SendCampaign createSendCampaign(
        long sendCampaignId) {
        return getService().createSendCampaign(sendCampaignId);
    }

    /**
    * Deletes the send campaign with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaignId the primary key of the send campaign to delete
    * @throws PortalException if a send campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteSendCampaign(long sendCampaignId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteSendCampaign(sendCampaignId);
    }

    /**
    * Deletes the send campaign from the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaign the send campaign to delete
    * @throws SystemException if a system exception occurred
    */
    public static void deleteSendCampaign(
        com.liferay.newsletter.model.SendCampaign sendCampaign)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteSendCampaign(sendCampaign);
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
    * Gets the send campaign with the primary key.
    *
    * @param sendCampaignId the primary key of the send campaign to get
    * @return the send campaign
    * @throws PortalException if a send campaign with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.SendCampaign getSendCampaign(
        long sendCampaignId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSendCampaign(sendCampaignId);
    }

    /**
    * Gets a range of all the send campaigns.
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
    public static java.util.List<com.liferay.newsletter.model.SendCampaign> getSendCampaigns(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSendCampaigns(start, end);
    }

    /**
    * Gets the number of send campaigns.
    *
    * @return the number of send campaigns
    * @throws SystemException if a system exception occurred
    */
    public static int getSendCampaignsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSendCampaignsCount();
    }

    /**
    * Updates the send campaign in the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaign the send campaign to update
    * @return the send campaign that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.SendCampaign updateSendCampaign(
        com.liferay.newsletter.model.SendCampaign sendCampaign)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSendCampaign(sendCampaign);
    }

    /**
    * Updates the send campaign in the database. Also notifies the appropriate model listeners.
    *
    * @param sendCampaign the send campaign to update
    * @param merge whether to merge the send campaign with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the send campaign that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.newsletter.model.SendCampaign updateSendCampaign(
        com.liferay.newsletter.model.SendCampaign sendCampaign, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSendCampaign(sendCampaign, merge);
    }

    public static java.util.List<com.liferay.newsletter.model.NewsletterLog> getNewsletterLogs(
        com.liferay.newsletter.model.SendCampaign sendCampaign)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewsletterLogs(sendCampaign);
    }

    public static void clearService() {
        _service = null;
    }

    public static SendCampaignLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    SendCampaignLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    SendCampaignLocalService.class.getName(), portletClassLoader);

            _service = new SendCampaignLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(SendCampaignLocalServiceUtil.class,
                "_service");
            MethodCache.remove(SendCampaignLocalService.class);
        }

        return _service;
    }

    public void setService(SendCampaignLocalService service) {
        MethodCache.remove(SendCampaignLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(SendCampaignLocalServiceUtil.class,
            "_service");
        MethodCache.remove(SendCampaignLocalService.class);
    }
}
