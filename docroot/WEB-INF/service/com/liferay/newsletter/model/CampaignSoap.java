package com.liferay.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.newsletter.service.http.CampaignServiceSoap}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       com.liferay.newsletter.service.http.CampaignServiceSoap
 * @generated
 */
public class CampaignSoap implements Serializable {
    private String _uuid;
    private long _campaignId;
    private String _title;
    private String _content;

    public CampaignSoap() {
    }

    public static CampaignSoap toSoapModel(Campaign model) {
        CampaignSoap soapModel = new CampaignSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setCampaignId(model.getCampaignId());
        soapModel.setTitle(model.getTitle());
        soapModel.setContent(model.getContent());

        return soapModel;
    }

    public static CampaignSoap[] toSoapModels(Campaign[] models) {
        CampaignSoap[] soapModels = new CampaignSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CampaignSoap[][] toSoapModels(Campaign[][] models) {
        CampaignSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CampaignSoap[models.length][models[0].length];
        } else {
            soapModels = new CampaignSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CampaignSoap[] toSoapModels(List<Campaign> models) {
        List<CampaignSoap> soapModels = new ArrayList<CampaignSoap>(models.size());

        for (Campaign model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CampaignSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _campaignId;
    }

    public void setPrimaryKey(long pk) {
        setCampaignId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getCampaignId() {
        return _campaignId;
    }

    public void setCampaignId(long campaignId) {
        _campaignId = campaignId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }
}
