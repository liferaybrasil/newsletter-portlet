package com.liferay.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class ContactClp extends BaseModelImpl<Contact> implements Contact {
    private String _uuid;
    private long _contactId;
    private String _email;
    private String _name;

    public ContactClp() {
    }

    public long getPrimaryKey() {
        return _contactId;
    }

    public void setPrimaryKey(long pk) {
        setContactId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_contactId);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getContactId() {
        return _contactId;
    }

    public void setContactId(long contactId) {
        _contactId = contactId;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Contact toEscapedModel() {
        if (isEscapedModel()) {
            return this;
        } else {
            return (Contact) Proxy.newProxyInstance(Contact.class.getClassLoader(),
                new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
        }
    }

    public Object clone() {
        ContactClp clone = new ContactClp();

        clone.setUuid(getUuid());
        clone.setContactId(getContactId());
        clone.setEmail(getEmail());
        clone.setName(getName());

        return clone;
    }

    public int compareTo(Contact contact) {
        int value = 0;

        value = getEmail().compareTo(contact.getEmail());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ContactClp contact = null;

        try {
            contact = (ContactClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long pk = contact.getPrimaryKey();

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
        sb.append(", contactId=");
        sb.append(getContactId());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.liferay.newsletter.model.Contact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId</column-name><column-value><![CDATA[");
        sb.append(getContactId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
