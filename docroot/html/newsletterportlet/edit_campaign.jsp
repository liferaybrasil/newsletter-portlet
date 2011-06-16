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

<portlet:resourceURL var="campaignContentResourceURL">
	<portlet:param name="cmd" value="<%= NewsletterConstants.GET_CAMPAIGN_CONTENT %>" />
</portlet:resourceURL>

<portlet:resourceURL var="contactResourceURL">
	<portlet:param name="cmd" value="<%= NewsletterConstants.GET_CONTACT %>" />
</portlet:resourceURL>

<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

<portlet:actionURL var="editCampaignURL" />

<aui:form action="<%= editCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="campaign" />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignId" />

		<aui:input type="hidden" name="campaignContentId" id="campaignContentId" />

		<aui:input type="hidden" name="contacts" id="contacts" />

		<aui:input name="emailSubject" label="Email Subject" />
		<liferay-ui:error key="campaignemailsubject-required" message="campaignemailsubject-required" />

		<aui:input name="senderName" label="Sender Name" value='<%= prefs.getValue(NewsletterConstants.SENDER_NAME,"") %>'/>
		<liferay-ui:error key="campaignsendername-required" message="campaignsendername-required" />

		<aui:input name="senderEmail" label="Sender Email" value='<%= prefs.getValue(NewsletterConstants.SENDER_EMAIL,"") %>'/>
		<liferay-ui:error key="campaignsenderemail-format-error" message="campaignsenderemail-format-error" />
		<liferay-ui:error key="campaignsenderemail-required" message="campaignsenderemail-required" />

		<aui:input name="sendDate" label="Send Date" />

		<span class="aui-field-content">
			<label class="aui-field-label"> Campaign Content </label>
			<div class="autocomplete" id="<portlet:namespace/>autocompleteCampaignContent"></div>
		</span>

		<span class="aui-field-content">
			<label class="aui-field-label"> Contacts </label>
			<div class="autocomplete" id="<portlet:namespace/>autocompleteContact"></div>
		</span>

		<liferay-ui:error key="campaigncontacts-required" message="campaigncontacts-required" />

	<div class="lfr-dynamic-uploader">
		<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
	</div>

	</aui:fieldset>

	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "saveCampaign();" %>' value='Save' />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-autocomplete">

var dataSourceCampaignContent = new A.DataSource.IO(
	{
		source: '<%= campaignContentResourceURL %>&keywords='
	}
)
.plug(
	A.Plugin.DataSourceJSONSchema,
	{
		schema: {
			resultListLocator: 'results',
			resultFields: ['campaignContentId', 'title']
		}
	}
);

var autocompleteCampaignContent = new A.AutoComplete(
	{
		boundingBox: '#<portlet:namespace/>autocompleteCampaignContent',
		dataSource: dataSourceCampaignContent,
		matchKey: 'title',
		on: {
			itemSelect: function(event) {
				document.getElementById('<portlet:namespace/>campaignContentId').value = event._resultData.campaignContentId;
			}
		},
		delimChar: null,
		typeAhead: true,
		button: false
	}
)
.render();


var dataSourceContact = new A.DataSource.IO(
	{
		source: '<%= contactResourceURL %>&keywords='
	}
)
.plug(
	A.Plugin.DataSourceJSONSchema,
	{
		schema: {
			resultListLocator: 'results',
			resultFields: ['contactId', 'name', 'email']
		}
	}
);

var autocompleteContact = new A.AutoComplete(
	{
		boundingBox: '#<portlet:namespace/>autocompleteContact',
		dataSource: dataSourceContact,
		matchKey: 'email',
		delimChar: ',',
		typeAhead: true,
		button: false
	}
)
.render();

Liferay.provide(
		window,
		'<portlet:namespace />saveCampaign',
		function() {

			document.getElementById('<portlet:namespace/>contacts').value = autocompleteContact.inputNode.val();

			submitForm(document.<portlet:namespace />fm);
		},
		['aui-base']
	);

</aui:script>