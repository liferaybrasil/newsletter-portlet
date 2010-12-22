package com.liferay.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.newsletter.service.http.SendCampaignServiceSoap}.
 * </p>
 *
 * @author    Bruno Pinheiro
 * @see       com.liferay.newsletter.service.http.SendCampaignServiceSoap
 * @generated
 */
public class SendCampaignSoap implements Serializable {
    private String _uuid;
    private long _sendCampaignId;
    private Date _sendDate;
    private String _emailSubject;
    private String _senderName;
    private String _senderEmail;
    private long _campaignId;

    public SendCampaignSoap() {
    }

    public static SendCampaignSoap toSoapModel(SendCampaign model) {
        SendCampaignSoap soapModel = new SendCampaignSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setSendCampaignId(model.getSendCampaignId());
        soapModel.setSendDate(model.getSendDate());
        soapModel.setEmailSubject(model.getEmailSubject());
        soapModel.setSenderName(model.getSenderName());
        soapModel.setSenderEmail(model.getSenderEmail());
        soapModel.setCampaignId(model.getCampaignId());

        return soapModel;
    }

    public static SendCampaignSoap[] toSoapModels(SendCampaign[] models) {
        SendCampaignSoap[] soapModels = new SendCampaignSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SendCampaignSoap[][] toSoapModels(SendCampaign[][] models) {
        SendCampaignSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SendCampaignSoap[models.length][models[0].length];
        } else {
            soapModels = new SendCampaignSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SendCampaignSoap[] toSoapModels(List<SendCampaign> models) {
        List<SendCampaignSoap> soapModels = new ArrayList<SendCampaignSoap>(models.size());

        for (SendCampaign model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SendCampaignSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _sendCampaignId;
    }

    public void setPrimaryKey(long pk) {
        setSendCampaignId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getSendCampaignId() {
        return _sendCampaignId;
    }

    public void setSendCampaignId(long sendCampaignId) {
        _sendCampaignId = sendCampaignId;
    }

    public Date getSendDate() {
        return _sendDate;
    }

    public void setSendDate(Date sendDate) {
        _sendDate = sendDate;
    }

    public String getEmailSubject() {
        return _emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        _emailSubject = emailSubject;
    }

    public String getSenderName() {
        return _senderName;
    }

    public void setSenderName(String senderName) {
        _senderName = senderName;
    }

    public String getSenderEmail() {
        return _senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        _senderEmail = senderEmail;
    }

    public long getCampaignId() {
        return _campaignId;
    }

    public void setCampaignId(long campaignId) {
        _campaignId = campaignId;
    }
}
