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

import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Bruno Pinheiro
 */
public class ContactSearchTerms extends ContactDisplayTerms {

	public ContactSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		status = ParamUtil.getString(portletRequest, STATUS);
		name = DAOParamUtil.getString(portletRequest, NAME);
		email = DAOParamUtil.getString(portletRequest, EMAIL);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName(String name) {
		return this.name;
	}

	public String getStatus(String status) {
		return this.status;
	}

	public String getEmail(String email) {
		return this.email;
	}

}