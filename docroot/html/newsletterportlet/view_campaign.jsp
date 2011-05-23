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

	boolean hasAddPermission = permissionChecker.hasPermission(
		scopeGroupId, "com.liferay.newsletter.model",
		scopeGroupId, "ADD_CAMPAIGN");
%>

<aui:button-row>
	<c:if test='<%= hasAddPermission %>'>
		<portlet:renderURL var="addCampaignURL">
			<portlet:param name="jspPage" value="/html/newsletterportlet/edit_campaign.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>

		<aui:button value="Add Campaign" onClick="<%= addCampaignURL.toString() %>" />
	</c:if>
</aui:button-row>
<liferay-ui:error key="campaign-added" message="campaign-added" />
<liferay-ui:error key="campaignContent-resent" message="campaignContent-resent" />
<liferay-ui:error key="campaign-deleted" message="campaign-deleted" />
<liferay-ui:search-container emptyResultsMessage="newsletter-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= CampaignLocalServiceUtil.getCampaigns(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= CampaignLocalServiceUtil.getCampaignsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.newsletter.model.Campaign"
		keyProperty="campaignId"
		modelVar="campaign"
	>

		<%
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		%>

		<liferay-ui:search-container-column-text
			name="Send Date"
			value="<%= dateFormat.format(campaign.getSendDate()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="Campaign Content"
			value="<%= CampaignContentLocalServiceUtil.getCampaignContent(campaign.getCampaignContentId()).getTitle() %>"
		/>

		<liferay-ui:search-container-column-text
			name="# of emails"
			value='<%= ""+ContactLocalServiceUtil.getContactCountByCampaign(campaign.getCampaignId()) %>'
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/newsletterportlet/campaign_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>