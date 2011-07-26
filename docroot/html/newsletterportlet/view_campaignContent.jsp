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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);

boolean hasAddPermission = permissionChecker.hasPermission(scopeGroupId, "com.liferay.newsletter.model", scopeGroupId, "ADD_CAMPAIGNCONTENT");

SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
%>

<aui:button-row>
	<c:if test='<%= hasAddPermission %>'>
		<portlet:renderURL var="addCampaignContentURL">
			<portlet:param name="jspPage" value="/html/newsletterportlet/edit_campaignContent.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<aui:button value="Add Campaign Content" onClick="<%= addCampaignContentURL.toString() %>" />
	</c:if>
</aui:button-row>
<liferay-ui:error key="campaign-content-added" message="campaign-content-added" />
<liferay-ui:error key="campaign-content-deleted" message="campaign-content-deleted" />
<liferay-ui:search-container emptyResultsMessage="newsletter-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= CampaignContentLocalServiceUtil.getCampaignContents(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= CampaignContentLocalServiceUtil.getCampaignContentsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.newsletter.model.CampaignContent"
		keyProperty="campaignContentId"
		modelVar="campaignContent"
	>
		<liferay-ui:search-container-column-text
			name="Title"
			value="<%= campaignContent.getTitle() %>"
		/>

		<liferay-ui:search-container-column-text
			name="Creation Date"
			value="<%= dateFormat.format(campaignContent.getCreateDate()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="# of campaigns"
			value='<%= ""+CampaignLocalServiceUtil.getCampaignsByCampaignContentCount(campaignContent.getCampaignContentId()) %>'
		/>

		<liferay-ui:search-container-column-text
			name="# of emails"
			value='<%= ""+ContactLocalServiceUtil.getContactCountByCampaignContent(campaignContent.getCampaignContentId()) %>'
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/newsletterportlet/campaignContent_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>