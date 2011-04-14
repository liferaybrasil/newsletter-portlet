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
	Campaign campaign = null;

	long campaignId = ParamUtil.getLong(request, "campaignId");

	if (campaignId > 0) {
		campaign = CampaignLocalServiceUtil.getCampaign(campaignId);
	}

	List<CampaignContent> campaignContents = CampaignContentLocalServiceUtil.getCampaignContents(0,CampaignContentLocalServiceUtil.getCampaignContentsCount());

	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (campaign != null) ? "" : "New Campaign" %>'
/>


<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

<portlet:actionURL var="editCampaignURL" />

<aui:form action="<%= editCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="campaign" />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignId" />

		<aui:input name="emailSubject" label="Email Subject" />
		<liferay-ui:error key="campaignemailsubject-required" message="campaignemailsubject-required" />

		<aui:input name="senderName" label="Sender Name" value='<%= prefs.getValue(NewsletterConstants.SENDER_NAME,"") %>'/>
		<liferay-ui:error key="campaignsendername-required" message="campaignsendername-required" />

		<aui:input name="senderEmail" label="Sender Email" value='<%= prefs.getValue(NewsletterConstants.SENDER_EMAIL,"") %>'/>
		<liferay-ui:error key="campaignsenderemail-format-error" message="campaignsenderemail-format-error" />
		<liferay-ui:error key="campaignsenderemail-required" message="campaignsenderemail-required" />

		<aui:input name="sendDate" label="Send Date" />

		<aui:select name="campaignContentId" label="CampaignContent" showEmptyOption="<%= false %>">

	 		<%
				for(CampaignContent campaignContent: campaignContents){
			%>
			<aui:option value="<%= campaignContent.getCampaignContentId() %>" selected="<%= campaign != null && campaignContent.getCampaignContentId() == campaign.getCampaignContentId() %>"><%=campaignContent.getTitle() %></aui:option>
			<%
				}
			%>

		</aui:select>

		<aui:input type="textarea" name="contacts" label="Contacts" />
		<liferay-ui:error key="campaigncontacts-required" message="campaigncontacts-required" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>