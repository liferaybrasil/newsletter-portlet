/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.newsletter.model.impl;

import com.liferay.newsletter.model.NewsletterContact;
import com.liferay.newsletter.model.NewsletterContactModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the NewsletterContact service. Represents a row in the &quot;Newsletter_NewsletterContact&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.newsletter.model.NewsletterContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsletterContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterContactImpl
 * @see com.liferay.newsletter.model.NewsletterContact
 * @see com.liferay.newsletter.model.NewsletterContactModel
 * @generated
 */
public class NewsletterContactModelImpl extends BaseModelImpl<NewsletterContact>
	implements NewsletterContactModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a newsletter contact model instance should use the {@link com.liferay.newsletter.model.NewsletterContact} interface instead.
	 */
	public static final String TABLE_NAME = "Newsletter_NewsletterContact";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contactId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "email", Types.VARCHAR },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Newsletter_NewsletterContact (contactId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,email VARCHAR(75) null,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Newsletter_NewsletterContact";
	public static final String ORDER_BY_JPQL = " ORDER BY newsletterContact.email ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Newsletter_NewsletterContact.email ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.newsletter.model.NewsletterContact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.newsletter.model.NewsletterContact"),
			true);

	public Class<?> getModelClass() {
		return NewsletterContact.class;
	}

	public String getModelClassName() {
		return NewsletterContact.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.newsletter.model.NewsletterContact"));

	public NewsletterContactModelImpl() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	public void setEmail(String email) {
		if (_originalEmail == null) {
			_originalEmail = _email;
		}

		_email = email;
	}

	public String getOriginalEmail() {
		return GetterUtil.getString(_originalEmail);
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	@Override
	public NewsletterContact toEscapedModel() {
		if (isEscapedModel()) {
			return (NewsletterContact)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (NewsletterContact)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					NewsletterContact.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		NewsletterContactImpl newsletterContactImpl = new NewsletterContactImpl();

		newsletterContactImpl.setContactId(getContactId());
		newsletterContactImpl.setGroupId(getGroupId());
		newsletterContactImpl.setCompanyId(getCompanyId());
		newsletterContactImpl.setUserId(getUserId());
		newsletterContactImpl.setUserName(getUserName());
		newsletterContactImpl.setCreateDate(getCreateDate());
		newsletterContactImpl.setModifiedDate(getModifiedDate());
		newsletterContactImpl.setEmail(getEmail());
		newsletterContactImpl.setName(getName());

		newsletterContactImpl.resetOriginalValues();

		return newsletterContactImpl;
	}

	public int compareTo(NewsletterContact newsletterContact) {
		int value = 0;

		value = getEmail().compareTo(newsletterContact.getEmail());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NewsletterContact newsletterContact = null;

		try {
			newsletterContact = (NewsletterContact)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = newsletterContact.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		NewsletterContactModelImpl newsletterContactModelImpl = this;

		newsletterContactModelImpl._originalEmail = newsletterContactModelImpl._email;
	}

	@Override
	public CacheModel<NewsletterContact> toCacheModel() {
		NewsletterContactCacheModel newsletterContactCacheModel = new NewsletterContactCacheModel();

		newsletterContactCacheModel.contactId = getContactId();

		newsletterContactCacheModel.groupId = getGroupId();

		newsletterContactCacheModel.companyId = getCompanyId();

		newsletterContactCacheModel.userId = getUserId();

		newsletterContactCacheModel.userName = getUserName();

		String userName = newsletterContactCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			newsletterContactCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			newsletterContactCacheModel.createDate = createDate.getTime();
		}
		else {
			newsletterContactCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			newsletterContactCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			newsletterContactCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		newsletterContactCacheModel.email = getEmail();

		String email = newsletterContactCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			newsletterContactCacheModel.email = null;
		}

		newsletterContactCacheModel.name = getName();

		String name = newsletterContactCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			newsletterContactCacheModel.name = null;
		}

		return newsletterContactCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.liferay.newsletter.model.NewsletterContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
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

	private static ClassLoader _classLoader = NewsletterContact.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			NewsletterContact.class
		};
	private long _contactId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _email;
	private String _originalEmail;
	private String _name;
	private transient ExpandoBridge _expandoBridge;
	private NewsletterContact _escapedModelProxy;
}