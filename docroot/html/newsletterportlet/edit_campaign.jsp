<%--
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
--%>

<%@include file="/html/init.jsp" %>

<%
	Campaign campaign = null;

	long campaignId = ParamUtil.getLong(request, "campaignId");

	if (campaignId > 0) {
		campaign = CampaignLocalServiceUtil.getCampaign(campaignId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (campaign != null) ? campaign.getTitle() : "New Campaign" %>'
/>


<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

<portlet:actionURL name='<%= campaign == null ? "addCampaign" : "updateCampaign" %>' var="editCampaignURL" />

<aui:form action="<%= editCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignId" value='<%= campaign == null ? "" : campaign.getCampaignId() %>'/>

		<aui:input name="title" label="Title" />

		<aui:input name="content" label="Content" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>