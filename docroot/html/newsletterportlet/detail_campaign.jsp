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

<%@ page import="com.liferay.newsletter.search.NewsletterContactSearch" %>
<%@include file="/html/init.jsp" %>

<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm a");
	long campaignId = ParamUtil.getLong(request, "campaignId");

	NewsletterCampaign campaign = NewsletterCampaignLocalServiceUtil.getNewsletterCampaign(campaignId);

	String redirect = ParamUtil.getString(request, "redirect");

	String campaignContentTitle = NewsletterContentLocalServiceUtil.getNewsletterContent(campaign.getContentId()).getTitle();
%>

<aui:model-context bean="<%= campaign %>" model="<%= NewsletterCampaign.class %>" />

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Scheduling Detail'
/>

<aui:fieldset>
<span class="aui-field-content">
		<label class="aui-field-label"> Email Subject </label>
	<span class="aui-field-element ">
		<%= campaign.getEmailSubject() %>
	</span>
</span>
<span class="aui-field-content">
		<label class="aui-field-label"> Sender Name </label>
	<span class="aui-field-element ">
		<%= campaign.getSenderName() %>
	</span>
</span>
<span class="aui-field-content">
		<label class="aui-field-label"> Sender Email </label>
	<span class="aui-field-element ">
		<%= campaign.getSenderEmail() %>
	</span>
</span>
<span class="aui-field-content">
		<label class="aui-field-label"> Send Date </label>
	<span class="aui-field-element ">
		<%= dateFormat.format(campaign.getSendDate()) %>
	</span>
</span>
<span class="aui-field-content">
		<label class="aui-field-label"> Campaign Content </label>
		<b>Title:</b> <%= campaignContentTitle %>
	<span class="aui-field-element ">
		<%= campaign.getContent().getContent() %>
	</span>
</span>
</aui:fieldset>
<br />
<span class="aui-field-content">
		<label class="aui-field-label"> Contacts </label>
</span>

<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param name="jspPage" value="/html/newsletterportlet/detail_campaign.jsp" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="<%= NewsletterConstants.TABS_CAMPAIGN %>" />
</liferay-portlet:renderURL>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<liferay-ui:search-form
		page="/html/newsletterportlet/contact_search.jsp"
		servletContext="<%= application %>"
	/>
</aui:form>

<liferay-ui:search-container
	searchContainer="<%= new NewsletterContactSearch(renderRequest, portletURL) %>"
>
 	<%@ include file="contact_search_results.jspf" %>

	<liferay-ui:search-container-results
		results="<%= resultList %>"
		total="<%= totalCount %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.newsletter.model.NewsletterContact"
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
			value='<%= NewsletterLogLocalServiceUtil.getLog(campaignId, contactNewsletter.getContactId()).isSent() ? "Sent" : "Failed" %>'
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<portlet:actionURL name="resendCampaign" var="resendURL">
			<portlet:param name="cmd" value="resendCampaign" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="<%= NewsletterConstants.TABS_CAMPAIGN %>" />
</portlet:actionURL>

<portlet:actionURL name="resendFailed" var="resendFailedURL">
			<portlet:param name="cmd" value="resendFailed" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaignId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="tabs1" value="<%= NewsletterConstants.TABS_CAMPAIGN %>" />
</portlet:actionURL>

<aui:button-row>
		<aui:button value="Resend All" onClick="<%= resendURL.toString() %>" />

		<aui:button value="Resend Failed" onClick="<%= resendFailedURL.toString() %>" />
</aui:button-row>