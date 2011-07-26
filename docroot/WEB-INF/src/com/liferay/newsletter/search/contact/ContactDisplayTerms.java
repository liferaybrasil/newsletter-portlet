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

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

/**
 * @author Bruno Pinheiro
 */
public class ContactDisplayTerms extends DisplayTerms {

	public static final String EMAIL = "email";

	public static final String NAME = "name";

	public static final String STATUS = "status";

	public ContactDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		email = ParamUtil.getString(portletRequest, EMAIL);
		name = ParamUtil.getString(portletRequest, NAME);
		status = ParamUtil.getString(portletRequest, STATUS);
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	protected String email;
	protected String name;
	protected String status;

}