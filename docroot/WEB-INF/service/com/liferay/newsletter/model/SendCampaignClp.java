package com.liferay.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;


public class SendCampaignClp extends BaseModelImpl<SendCampaign>
    implements SendCampaign {
    private String _uuid;
    private long _sendCampaignId;
    private Date _sendDate;
    private String _emailSubject;
    private String _senderName;
    private String _senderEmail;
    private long _campaignId;

    public SendCampaignClp() {
    }

    public long getPrimaryKey() {
        return _sendCampaignId;
    }

    public void setPrimaryKey(long pk) {
        setSendCampaignId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_sendCampaignId);
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

    public SendCampaign toEscapedModel() {
        if (isEscapedModel()) {
            return this;
        } else {
            return (SendCampaign) Proxy.newProxyInstance(SendCampaign.class.getClassLoader(),
                new Class[] { SendCampaign.class },
                new AutoEscapeBeanHandler(this));
        }
    }

    public Object clone() {
        SendCampaignClp clone = new SendCampaignClp();

        clone.setUuid(getUuid());
        clone.setSendCampaignId(getSendCampaignId());
        clone.setSendDate(getSendDate());
        clone.setEmailSubject(getEmailSubject());
        clone.setSenderName(getSenderName());
        clone.setSenderEmail(getSenderEmail());
        clone.setCampaignId(getCampaignId());

        return clone;
    }

    public int compareTo(SendCampaign sendCampaign) {
        int value = 0;

        value = DateUtil.compareTo(getSendDate(), sendCampaign.getSendDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SendCampaignClp sendCampaign = null;

        try {
            sendCampaign = (SendCampaignClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = sendCampaign.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int) getPrimaryKey();
    }

    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", sendCampaignId=");
        sb.append(getSendCampaignId());
        sb.append(", sendDate=");
        sb.append(getSendDate());
        sb.append(", emailSubject=");
        sb.append(getEmailSubject());
        sb.append(", senderName=");
        sb.append(getSenderName());
        sb.append(", senderEmail=");
        sb.append(getSenderEmail());
        sb.append(", campaignId=");
        sb.append(getCampaignId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.liferay.newsletter.model.SendCampaign");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendCampaignId</column-name><column-value><![CDATA[");
        sb.append(getSendCampaignId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendDate</column-name><column-value><![CDATA[");
        sb.append(getSendDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailSubject</column-name><column-value><![CDATA[");
        sb.append(getEmailSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderName</column-name><column-value><![CDATA[");
        sb.append(getSenderName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderEmail</column-name><column-value><![CDATA[");
        sb.append(getSenderEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>campaignId</column-name><column-value><![CDATA[");
        sb.append(getCampaignId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
