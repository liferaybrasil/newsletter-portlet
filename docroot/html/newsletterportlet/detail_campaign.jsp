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

<%@include file="/html/init.jsp" %>

<%
	long campaignId = ParamUtil.getLong(request, "campaignId");

	Campaign campaign = CampaignLocalServiceUtil.getCampaign(
		campaignId);

	String redirect = ParamUtil.getString(request, "redirect");

	String campaignContentTitle = CampaignContentLocalServiceUtil.getCampaignContent(campaignId).getTitle();
%>

<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Scheduling Detail'
/>

<aui:fieldset>
<aui:input disabled="true" name="emailSubject" label="Email Subject" />

<aui:input disabled="true" name="senderName" label="Sender Name" />

<aui:input disabled="true" name="senderEmail" label="Sender Email" />

<aui:input disabled="true" name="sendDate" label="Send Date" />

<aui:input disabled="true" type="text" name="campaignContentTitle" label="Campaign Content"  value="<%= campaignContentTitle %>" />
</aui:fieldset>
<br />
<liferay-ui:search-container emptyResultsMessage="newsletter-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= NewsletterLogLocalServiceUtil.getContactsByCampaign(campaignId) %>"
		total="<%= NewsletterLogLocalServiceUtil.getContactsByCampaignCount(campaignId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.newsletter.model.Contact"
		keyProperty="contactId"
		modelVar="contactNewsletter"
	>

		<liferay-ui:search-container-column-text
			name="Name"
			value="<%= contactNewsletter.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="Email"
			value="<%= contactNewsletter.getEmail() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Status"
			value="<%= NewsletterLogLocalServiceUtil.getNewsletterLogByCampaignAndContact(campaignId, contactNewsletter.getContactId()).isSent() ? "Sent" : "Failed" %>"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:actionURL name="resendCampaign" var="resendURL">
			<portlet:param name="cmd" value="resendCampaign" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Campaign" />
</portlet:actionURL>

<portlet:actionURL name="resendFailed" var="resendFailedURL">
			<portlet:param name="cmd" value="resendFailed" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Campaign" />
</portlet:actionURL>

<aui:button-row>
		<aui:button value="Resend All" onClick="<%= resendURL.toString() %>"/>

		<aui:button value="Resend Failed" onClick="<%= resendFailedURL.toString() %>"/>
</aui:button-row>