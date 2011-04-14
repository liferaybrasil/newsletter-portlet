<%--
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
--%>

<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Campaign campaign = (Campaign)row.getObject();

String name = Campaign.class.getName();
long campaignId = campaign.getCampaignId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<c:if test='<%= permissionChecker.hasPermission(scopeGroupId, name, campaignId, "RESEND") %>'>
		<portlet:actionURL name="resendCampaign" var="resendURL">
			<portlet:param name="cmd" value="resendCampaign" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Campaign" />
		</portlet:actionURL>

		<liferay-ui:icon message="resend" label="true" image="forward" url="<%=resendURL.toString() %>" />
	</c:if>

	<c:if test='<%= permissionChecker.hasPermission(scopeGroupId, name, campaignId, "DETAIL") %>'>
		<portlet:renderURL var="detailURL">
			<portlet:param name="jspPage" value="/html/newsletterportlet/detail_campaign.jsp" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Campaign" />
		</portlet:renderURL>

	<liferay-ui:icon message="Detail" label="true" image="view" url="<%=detailURL.toString() %>" />
	</c:if>

	<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, name, campaignId, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteCampaign" var="deleteURL">
			<portlet:param name="cmd" value="deleteCampaign" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Campaign" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>