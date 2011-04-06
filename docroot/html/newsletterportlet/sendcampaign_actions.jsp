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
SendCampaign sendCampaign = (SendCampaign)row.getObject();

String name = SendCampaign.class.getName();
long sendCampaignId = sendCampaign.getSendCampaignId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<c:if test='<%= permissionChecker.hasPermission(scopeGroupId, name, sendCampaignId, "RESEND") %>'>
		<portlet:actionURL name="resendSendCampaign" var="resendURL">
			<portlet:param name="cmd" value="resendSendCampaign" />
			<portlet:param name="sendCampaignId" value="<%= String.valueOf(sendCampaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Sending" />
		</portlet:actionURL>

		<liferay-ui:icon message="resend" label="true" image="forward" url="<%=resendURL.toString() %>" />
	</c:if>

	<c:if test='<%= permissionChecker.hasPermission(scopeGroupId, name, sendCampaignId, "DETAIL") %>'>
		<portlet:renderURL var="detailURL">
			<portlet:param name="jspPage" value="/html/newsletterportlet/detail_send.jsp" />
			<portlet:param name="sendCampaignId" value="<%= String.valueOf(sendCampaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Sending" />
		</portlet:renderURL>

	<liferay-ui:icon message="Detail" label="true" image="view" url="<%=detailURL.toString() %>" />
	</c:if>

	<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, name, sendCampaignId, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteSendCampaign" var="deleteURL">
			<portlet:param name="cmd" value="deleteSendCampaign" />
			<portlet:param name="sendCampaignId" value="<%= String.valueOf(sendCampaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Sending" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>