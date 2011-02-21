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

package com.liferay.newsletter.service;

import com.liferay.newsletter.model.CampaignClp;
import com.liferay.newsletter.model.ContactClp;
import com.liferay.newsletter.model.NewsletterLogClp;
import com.liferay.newsletter.model.SendCampaignClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"newsletter-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to locate deployment context from portlet properties",
						t);
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"newsletter-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isWarnEnabled()) {
						_log.warn("Unable to locate deployment context from portal properties",
							t);
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "newsletter-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CampaignClp.class.getName())) {
			return translateInputCampaign(oldModel);
		}

		if (oldModelClassName.equals(ContactClp.class.getName())) {
			return translateInputContact(oldModel);
		}

		if (oldModelClassName.equals(SendCampaignClp.class.getName())) {
			return translateInputSendCampaign(oldModel);
		}

		if (oldModelClassName.equals(NewsletterLogClp.class.getName())) {
			return translateInputNewsletterLog(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCampaign(BaseModel<?> oldModel) {
		CampaignClp oldCplModel = (CampaignClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.newsletter.model.impl.CampaignImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCampaignId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCampaignId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value2 = oldCplModel.getTitle();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContent",
						new Class[] { String.class });

				String value3 = oldCplModel.getContent();

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputContact(BaseModel<?> oldModel) {
		ContactClp oldCplModel = (ContactClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.newsletter.model.impl.ContactImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setContactId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getContactId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value2 = oldCplModel.getEmail();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value3 = oldCplModel.getName();

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputSendCampaign(BaseModel<?> oldModel) {
		SendCampaignClp oldCplModel = (SendCampaignClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.newsletter.model.impl.SendCampaignImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setSendCampaignId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getSendCampaignId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSendDate",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getSendDate();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setEmailSubject",
						new Class[] { String.class });

				String value3 = oldCplModel.getEmailSubject();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setSenderName",
						new Class[] { String.class });

				String value4 = oldCplModel.getSenderName();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setSenderEmail",
						new Class[] { String.class });

				String value5 = oldCplModel.getSenderEmail();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setSent",
						new Class[] { Boolean.TYPE });

				Boolean value6 = new Boolean(oldCplModel.getSent());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setCampaignId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getCampaignId());

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputNewsletterLog(BaseModel<?> oldModel) {
		NewsletterLogClp oldCplModel = (NewsletterLogClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.newsletter.model.impl.NewsletterLogImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUuid",
						new Class[] { String.class });

				String value0 = oldCplModel.getUuid();

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setNewsletterLogId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getNewsletterLogId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setSendCampaignId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getSendCampaignId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContactId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getContactId());

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.newsletter.model.impl.CampaignImpl")) {
			return translateOutputCampaign(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.newsletter.model.impl.ContactImpl")) {
			return translateOutputContact(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.newsletter.model.impl.SendCampaignImpl")) {
			return translateOutputSendCampaign(oldModel);
		}

		if (oldModelClassName.equals(
					"com.liferay.newsletter.model.impl.NewsletterLogImpl")) {
			return translateOutputNewsletterLog(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputCampaign(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CampaignClp newModel = new CampaignClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getCampaignId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCampaignId(value1);

				Method method2 = oldModelClass.getMethod("getTitle");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTitle(value2);

				Method method3 = oldModelClass.getMethod("getContent");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setContent(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputContact(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ContactClp newModel = new ContactClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getContactId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setContactId(value1);

				Method method2 = oldModelClass.getMethod("getEmail");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setEmail(value2);

				Method method3 = oldModelClass.getMethod("getName");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setName(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputSendCampaign(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				SendCampaignClp newModel = new SendCampaignClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getSendCampaignId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setSendCampaignId(value1);

				Method method2 = oldModelClass.getMethod("getSendDate");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setSendDate(value2);

				Method method3 = oldModelClass.getMethod("getEmailSubject");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setEmailSubject(value3);

				Method method4 = oldModelClass.getMethod("getSenderName");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setSenderName(value4);

				Method method5 = oldModelClass.getMethod("getSenderEmail");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setSenderEmail(value5);

				Method method6 = oldModelClass.getMethod("getSent");

				Boolean value6 = (Boolean)method6.invoke(oldModel,
						(Object[])null);

				newModel.setSent(value6);

				Method method7 = oldModelClass.getMethod("getCampaignId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setCampaignId(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputNewsletterLog(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NewsletterLogClp newModel = new NewsletterLogClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUuid");

				String value0 = (String)method0.invoke(oldModel, (Object[])null);

				newModel.setUuid(value0);

				Method method1 = oldModelClass.getMethod("getNewsletterLogId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setNewsletterLogId(value1);

				Method method2 = oldModelClass.getMethod("getSendCampaignId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setSendCampaignId(value2);

				Method method3 = oldModelClass.getMethod("getContactId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setContactId(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}