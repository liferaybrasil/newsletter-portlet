/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.newsletter.portlet;

import com.liferay.newsletter.model.Campaign;
import com.liferay.newsletter.model.impl.CampaignImpl;
import com.liferay.newsletter.service.CampaignLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

/**
 * @author Bruno Pinheiro
 */
public class NewsletterPortlet extends MVCPortlet {

	public void addCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		Campaign campaign = _campaignFromRequest(request);

		//sendCampaign(request, campaign);

		campaign = CampaignLocalServiceUtil.addCampaign(campaign);

		sendRedirect(request, response);
	}

	public void deleteCampaign(ActionRequest request, ActionResponse response)
		throws Exception {

		long campaignId = ParamUtil.getLong(request, "campaignId");

		CampaignLocalServiceUtil.deleteCampaign(campaignId);

		sendRedirect(request, response);
	}

	public void setCampaignPref(
			ActionRequest request, ActionResponse response)
		throws Exception {

		String password = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD);
		String user = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_USER);
		String port = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_PORT);
		String host = request.getParameter(
			PropsKeys.MAIL_SESSION_MAIL_POP3_HOST);

		PortletPreferences prefs = request.getPreferences();

		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD, password);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_USER, user);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PORT, port);
		prefs.setValue(PropsKeys.MAIL_SESSION_MAIL_POP3_HOST, host);

		prefs.store();

		response.setPortletMode(PortletMode.VIEW);
	}

	private Campaign _campaignFromRequest(PortletRequest request) {
		CampaignImpl campaign = new CampaignImpl();

		campaign.setCampaignId(ParamUtil.getLong(request, "campaignId"));
		campaign.setTitle(ParamUtil.getString(request, "title"));

		return campaign;
	}

}