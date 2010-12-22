package com.liferay.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.newsletter.service.http.NewsletterLogServiceSoap}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       com.liferay.newsletter.service.http.NewsletterLogServiceSoap
 * @generated
 */
public class NewsletterLogSoap implements Serializable {
    private String _uuid;
    private long _newsletterLogId;
    private long _sendCampaignId;
    private long _contactId;

    public NewsletterLogSoap() {
    }

    public static NewsletterLogSoap toSoapModel(NewsletterLog model) {
        NewsletterLogSoap soapModel = new NewsletterLogSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setNewsletterLogId(model.getNewsletterLogId());
        soapModel.setSendCampaignId(model.getSendCampaignId());
        soapModel.setContactId(model.getContactId());

        return soapModel;
    }

    public static NewsletterLogSoap[] toSoapModels(NewsletterLog[] models) {
        NewsletterLogSoap[] soapModels = new NewsletterLogSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsletterLogSoap[][] toSoapModels(NewsletterLog[][] models) {
        NewsletterLogSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsletterLogSoap[models.length][models[0].length];
        } else {
            soapModels = new NewsletterLogSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsletterLogSoap[] toSoapModels(List<NewsletterLog> models) {
        List<NewsletterLogSoap> soapModels = new ArrayList<NewsletterLogSoap>(models.size());

        for (NewsletterLog model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsletterLogSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _newsletterLogId;
    }

    public void setPrimaryKey(long pk) {
        setNewsletterLogId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getNewsletterLogId() {
        return _newsletterLogId;
    }

    public void setNewsletterLogId(long newsletterLogId) {
        _newsletterLogId = newsletterLogId;
    }

    public long getSendCampaignId() {
        return _sendCampaignId;
    }

    public void setSendCampaignId(long sendCampaignId) {
        _sendCampaignId = sendCampaignId;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }
}
