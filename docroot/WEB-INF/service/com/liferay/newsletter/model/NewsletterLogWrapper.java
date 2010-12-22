package com.liferay.newsletter.model;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterLog}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       NewsletterLog
 * @generated
 */
public class NewsletterLogWrapper implements NewsletterLog {
    private NewsletterLog _newsletterLog;

    public NewsletterLogWrapper(NewsletterLog newsletterLog) {
        _newsletterLog = newsletterLog;
    }

    /**
    * Gets the primary key of this newsletter log.
    *
    * @return the primary key of this newsletter log
    */
    public long getPrimaryKey() {
        return _newsletterLog.getPrimaryKey();
    }

    /**
    * Sets the primary key of this newsletter log
    *
    * @param pk the primary key of this newsletter log
    */
    public void setPrimaryKey(long pk) {
        _newsletterLog.setPrimaryKey(pk);
    }

    /**
    * Gets the uuid of this newsletter log.
    *
    * @return the uuid of this newsletter log
    */
    public java.lang.String getUuid() {
        return _newsletterLog.getUuid();
    }

    /**
    * Sets the uuid of this newsletter log.
    *
    * @param uuid the uuid of this newsletter log
    */
    public void setUuid(java.lang.String uuid) {
        _newsletterLog.setUuid(uuid);
    }

    /**
    * Gets the newsletter log id of this newsletter log.
    *
    * @return the newsletter log id of this newsletter log
    */
    public long getNewsletterLogId() {
        return _newsletterLog.getNewsletterLogId();
    }

    /**
    * Sets the newsletter log id of this newsletter log.
    *
    * @param newsletterLogId the newsletter log id of this newsletter log
    */
    public void setNewsletterLogId(long newsletterLogId) {
        _newsletterLog.setNewsletterLogId(newsletterLogId);
    }

    /**
    * Gets the send campaign id of this newsletter log.
    *
    * @return the send campaign id of this newsletter log
    */
    public long getSendCampaignId() {
        return _newsletterLog.getSendCampaignId();
    }

    /**
    * Sets the send campaign id of this newsletter log.
    *
    * @param sendCampaignId the send campaign id of this newsletter log
    */
    public void setSendCampaignId(long sendCampaignId) {
        _newsletterLog.setSendCampaignId(sendCampaignId);
    }

    /**
    * Gets the contact id of this newsletter log.
    *
    * @return the contact id of this newsletter log
    */
    public long getContactId() {
        return _newsletterLog.getContactId();
    }

    /**
    * Sets the contact id of this newsletter log.
    *
    * @param contactId the contact id of this newsletter log
    */
    public void setContactId(long contactId) {
        _newsletterLog.setContactId(contactId);
    }

    public boolean isNew() {
        return _newsletterLog.isNew();
    }

    public void setNew(boolean n) {
        _newsletterLog.setNew(n);
    }

    public boolean isCachedModel() {
        return _newsletterLog.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _newsletterLog.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _newsletterLog.isEscapedModel();
    }

    public void setEscapedModel(boolean escapedModel) {
        _newsletterLog.setEscapedModel(escapedModel);
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _newsletterLog.getPrimaryKeyObj();
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _newsletterLog.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _newsletterLog.setExpandoBridgeAttributes(serviceContext);
    }

    public java.lang.Object clone() {
        return _newsletterLog.clone();
    }

    public int compareTo(
        com.liferay.newsletter.model.NewsletterLog newsletterLog) {
        return _newsletterLog.compareTo(newsletterLog);
    }

    public int hashCode() {
        return _newsletterLog.hashCode();
    }

    public com.liferay.newsletter.model.NewsletterLog toEscapedModel() {
        return _newsletterLog.toEscapedModel();
    }

    public java.lang.String toString() {
        return _newsletterLog.toString();
    }

    public java.lang.String toXmlString() {
        return _newsletterLog.toXmlString();
    }

    public NewsletterLog getWrappedNewsletterLog() {
        return _newsletterLog;
    }
}
