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

package com.liferay.newsletter.search.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.newsletter.model.Contact;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Bruno Pinheiro
 */
public class ContactSearch extends SearchContainer<Contact> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("name");
		headerNames.add("email");
		headerNames.add("status");

		orderableHeaders.put("name", "name");
		orderableHeaders.put("email", "email");
		orderableHeaders.put("status", "status");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-content-were-found";

	public ContactSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new ContactDisplayTerms(portletRequest),
			new ContactSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		ContactDisplayTerms displayTerms =
			(ContactDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			ContactDisplayTerms.NAME, displayTerms.getName());
		iteratorURL.setParameter(
			ContactDisplayTerms.EMAIL, displayTerms.getEmail());
		iteratorURL.setParameter(
			ContactDisplayTerms.STATUS, displayTerms.getStatus());

		setOrderableHeaders(orderableHeaders);
	}

	private static Log _log = LogFactoryUtil.getLog(ContactSearch.class);

}