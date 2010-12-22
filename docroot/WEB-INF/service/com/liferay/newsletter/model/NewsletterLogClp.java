package com.liferay.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class NewsletterLogClp extends BaseModelImpl<NewsletterLog>
    implements NewsletterLog {
    private String _uuid;
    private long _newsletterLogId;
    private long _sendCampaignId;
    private long _contactId;

    public NewsletterLogClp() {
    }

    public long getPrimaryKey() {
        return _newsletterLogId;
    }

    public void setPrimaryKey(long pk) {
        setNewsletterLogId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_newsletterLogId);
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

    public NewsletterLog toEscapedModel() {
        if (isEscapedModel()) {
            return this;
        } else {
            return (NewsletterLog) Proxy.newProxyInstance(NewsletterLog.class.getClassLoader(),
                new Class[] { NewsletterLog.class },
                new AutoEscapeBeanHandler(this));
        }
    }

    public Object clone() {
        NewsletterLogClp clone = new NewsletterLogClp();

        clone.setUuid(getUuid());
        clone.setNewsletterLogId(getNewsletterLogId());
        clone.setSendCampaignId(getSendCampaignId());
        clone.setContactId(getContactId());

        return clone;
    }

    public int compareTo(NewsletterLog newsletterLog) {
        long pk = newsletterLog.getPrimaryKey();

        if (getPrimaryKey() < pk) {
            return -1;
        } else if (getPrimaryKey() > pk) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        NewsletterLogClp newsletterLog = null;

        try {
            newsletterLog = (NewsletterLogClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = newsletterLog.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", newsletterLogId=");
        sb.append(getNewsletterLogId());
        sb.append(", sendCampaignId=");
        sb.append(getSendCampaignId());
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.liferay.newsletter.model.NewsletterLog");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>newsletterLogId</column-name><column-value><![CDATA[");
        sb.append(getNewsletterLogId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendCampaignId</column-name><column-value><![CDATA[");
        sb.append(getSendCampaignId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
