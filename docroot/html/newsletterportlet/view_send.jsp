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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addSendCampaignURL">
		<portlet:param name="jspPage" value="/html/newsletterportlet/edit_send.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="Add Sending" onClick="<%= addSendCampaignURL.toString() %>" />
</aui:button-row>

<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "2")) %>' emptyResultsMessage="newsletter-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= SendCampaignLocalServiceUtil.getSendCampaigns(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= SendCampaignLocalServiceUtil.getSendCampaignsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.newsletter.model.SendCampaign"
		keyProperty="sendCampaignId"
		modelVar="sendCampaign"
	>
	
		<%
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		%>

		<liferay-ui:search-container-column-text
			name="Send Date"
			value="<%= dateFormat.format(sendCampaign.getSendDate()) %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Campaign"
			value="<%= CampaignLocalServiceUtil.getCampaign(sendCampaign.getCampaignId()).getTitle() %>"
		/>
	
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/newsletterportlet/sendcampaign_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>