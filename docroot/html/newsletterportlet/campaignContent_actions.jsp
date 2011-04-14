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
CampaignContent campaignContent = (CampaignContent)row.getObject();

String name = CampaignContent.class.getName();
long campaignContentId = campaignContent.getCampaignContentId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, name, campaignContentId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage" value="/html/newsletterportlet/edit_campaignContent.jsp" />
			<portlet:param name="campaignContentId" value="<%= String.valueOf(campaignContentId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
	</c:if>

	<c:if test="<%= permissionChecker.hasPermission(scopeGroupId, name, campaignContentId, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteCampaignContent" var="deleteURL">
			<portlet:param name="cmd" value="deleteCampaignContent" />
			<portlet:param name="campaignContentId" value="<%= String.valueOf(campaignContentId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>