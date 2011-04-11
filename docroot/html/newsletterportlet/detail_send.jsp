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
	long sendCampaignId = ParamUtil.getLong(request, "sendCampaignId");

	SendCampaign sendCampaign = SendCampaignLocalServiceUtil.getSendCampaign(
		sendCampaignId);

	String redirect = ParamUtil.getString(request, "redirect");

	String campaignTitle = CampaignLocalServiceUtil.getCampaign(sendCampaignId).getTitle();
%>

<aui:model-context bean="<%= sendCampaign %>" model="<%= SendCampaign.class %>" />

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Scheduling Detail'
/>

<aui:fieldset>
<aui:input disabled="true" name="emailSubject" label="Email Subject" />

<aui:input disabled="true" name="senderName" label="Sender Name" />

<aui:input disabled="true" name="senderEmail" label="Sender Email" />

<aui:input disabled="true" name="sendDate" label="Send Date" />

<aui:input disabled="true" type="text" name="campaignTitle" label="Campaign"  value="<%= campaignTitle %>" />
</aui:fieldset>
<br />
<liferay-ui:search-container emptyResultsMessage="newsletter-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= NewsletterLogLocalServiceUtil.getContactsBySendCampaign(sendCampaignId) %>"
		total="<%= NewsletterLogLocalServiceUtil.getContactsBySendCampaignCount(sendCampaignId) %>"
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
			value="Sent"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:actionURL name="resendSendCampaign" var="resendURL">
			<portlet:param name="cmd" value="resendSendCampaign" />
			<portlet:param name="sendCampaignId" value="<%= String.valueOf(sendCampaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="Sending" />
</portlet:actionURL>

<aui:button-row>
		<aui:button value="Resend All" onClick="<%= resendURL.toString() %>"/>

		<aui:button value="Resend Failed" />
</aui:button-row>