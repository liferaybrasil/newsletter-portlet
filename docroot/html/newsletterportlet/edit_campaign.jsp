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

<portlet:actionURL var="editCampaignURL" />

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" varImpl="selectContentPopupURL">
			<portlet:param name="tabs1" value="Campaign" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="jspPage" value="/html/newsletterportlet/popup.jsp" />
			<portlet:param name="" value="<portl"></portlet:param>
</liferay-portlet:renderURL>

<aui:form action="<%= editCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="campaign" />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignId" />

		<aui:input name="title" label="Title" />
		<liferay-ui:error key="campaigntitle-required" message="campaigntitle-required" />

		<aui:input name="content" label="Content" />
		<liferay-ui:error key="campaigncontent-required" message="campaigncontent-required" />
		
		<%
		String webContentPopUpURL = "javascript:Liferay.Util.openIframePopUp('','', '"+selectContentPopupURL+"', '" + renderResponse.getNamespace() + "','WebContent');";
		%>

		<liferay-ui:icon
			message='Select WebContent'
			src="edit"
			url='<%= webContentPopUpURL %>'
			label="Select Webcontent"
		/>
		

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>