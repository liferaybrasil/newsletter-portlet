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

<%@ include file="/html/init.jsp" %>

<%
	SendCampaign sendCampaign = null;

	long sendCampaignId = ParamUtil.getLong(request, "sendCampaignId");

	if (sendCampaignId > 0) {
		sendCampaign = SendCampaignLocalServiceUtil.getSendCampaign(sendCampaignId);
	}
	
	List<Campaign> campaigns = CampaignLocalServiceUtil.getCampaigns(0,CampaignLocalServiceUtil.getCampaignsCount());
	
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (sendCampaign != null) ? "" : "New Sending" %>'
/>


<aui:model-context bean="<%= sendCampaign %>" model="<%= SendCampaign.class %>" />

<portlet:actionURL var="editSendCampaignURL" />

<aui:form action="<%= editSendCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="sending" />
		
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="sendCampaignId" />

		<aui:input name="emailSubject" label="Email Subject"/>
		<liferay-ui:error key="sendcampaignemailsubject-required" message="sendcampaignemailsubject-required" />

		<aui:input name="senderName" label="Sender Name"/>
		<liferay-ui:error key="sendcampaignsendername-required" message="sendcampaignsendername-required" />

		<aui:input name="senderEmail" label="Sender Email"/>
		<liferay-ui:error key="sendcampaignsenderemail-format-error" message="sendcampaignsenderemail-format-error" />
		<liferay-ui:error key="sendcampaignsenderemail-required" message="sendcampaignsenderemail-required" />
		
		<aui:input name="sendDate" label="Send Date"/>
		
		<aui:select name="campaignId" label="Campaign" showEmptyOption="<%= false %>">

	 		<%
				for(Campaign campaign: campaigns){
			%>
			<aui:option value="<%= campaign.getCampaignId() %>" selected="<%= sendCampaign != null && campaign.getCampaignId() == sendCampaign.getCampaignId() %>"><%=campaign.getTitle()%></aui:option>
			<%
				}
			%>

		</aui:select>
		
		<aui:input type="text" name="contacts" label="Contacts" />
		<liferay-ui:error key="sendcampaigncontacts-required" message="sendcampaigncontacts-required" />
		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>