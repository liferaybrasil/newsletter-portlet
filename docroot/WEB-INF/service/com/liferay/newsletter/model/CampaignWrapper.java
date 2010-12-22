package com.liferay.newsletter.model;

/**
 * <p>
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       Campaign
 * @generated
 */
public class CampaignWrapper implements Campaign {
    private Campaign _campaign;

    public CampaignWrapper(Campaign campaign) {
        _campaign = campaign;
    }

    /**
    * Gets the primary key of this campaign.
    *
    * @return the primary key of this campaign
    */
    public long getPrimaryKey() {
        return _campaign.getPrimaryKey();
    }

    /**
    * Sets the primary key of this campaign
    *
    * @param pk the primary key of this campaign
    */
    public void setPrimaryKey(long pk) {
        _campaign.setPrimaryKey(pk);
    }

    /**
    * Gets the uuid of this campaign.
    *
    * @return the uuid of this campaign
    */
    public java.lang.String getUuid() {
        return _campaign.getUuid();
    }

    /**
    * Sets the uuid of this campaign.
    *
    * @param uuid the uuid of this campaign
    */
    public void setUuid(java.lang.String uuid) {
        _campaign.setUuid(uuid);
    }

    /**
    * Gets the campaign id of this campaign.
    *
    * @return the campaign id of this campaign
    */
    public long getCampaignId() {
        return _campaign.getCampaignId();
    }

    /**
    * Sets the campaign id of this campaign.
    *
    * @param campaignId the campaign id of this campaign
    */
    public void setCampaignId(long campaignId) {
        _campaign.setCampaignId(campaignId);
    }

    /**
    * Gets the title of this campaign.
    *
    * @return the title of this campaign
    */
    public java.lang.String getTitle() {
        return _campaign.getTitle();
    }

    /**
    * Sets the title of this campaign.
    *
    * @param title the title of this campaign
    */
    public void setTitle(java.lang.String title) {
        _campaign.setTitle(title);
    }

    /**
    * Gets the content of this campaign.
    *
    * @return the content of this campaign
    */
    public java.lang.String getContent() {
        return _campaign.getContent();
    }

    /**
    * Sets the content of this campaign.
    *
    * @param content the content of this campaign
    */
    public void setContent(java.lang.String content) {
        _campaign.setContent(content);
    }

    public boolean isNew() {
        return _campaign.isNew();
    }

    public void setNew(boolean n) {
        _campaign.setNew(n);
    }

    public boolean isCachedModel() {
        return _campaign.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _campaign.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _campaign.isEscapedModel();
    }

    public void setEscapedModel(boolean escapedModel) {
        _campaign.setEscapedModel(escapedModel);
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _campaign.getPrimaryKeyObj();
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _campaign.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _campaign.setExpandoBridgeAttributes(serviceContext);
    }

    public java.lang.Object clone() {
        return _campaign.clone();
    }

    public int compareTo(com.liferay.newsletter.model.Campaign campaign) {
        return _campaign.compareTo(campaign);
    }

    public int hashCode() {
        return _campaign.hashCode();
    }

    public com.liferay.newsletter.model.Campaign toEscapedModel() {
        return _campaign.toEscapedModel();
    }

    public java.lang.String toString() {
        return _campaign.toString();
    }

    public java.lang.String toXmlString() {
        return _campaign.toXmlString();
    }

    public Campaign getWrappedCampaign() {
        return _campaign;
    }
}
