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
	Campaign campaign = null;
	String content = "";

	long campaignId = ParamUtil.getLong(request, "campaignId");

	if (campaignId > 0) {
		campaign = CampaignLocalServiceUtil.getCampaign(campaignId);
		content = campaign.getContent();
	}


	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (campaign != null) ? campaign.getTitle() : "New Campaign" %>'
/>


<aui:model-context bean="<%= campaign %>" model="<%= Campaign.class %>" />

<portlet:actionURL var="editCampaignURL" />

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" varImpl="selectContentPopupURL">
	<portlet:param name="tabs1" value="Campaign" />
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="jspPage" value="/html/newsletterportlet/popup.jsp" />
	<portlet:param name="resourceNamespace" value="<%= renderResponse.getNamespace() %>" />
</liferay-portlet:renderURL>


<liferay-portlet:resourceURL varImpl="getArticleContentURL">
	<portlet:param name="cmd" value="<%= NewsletterConstants.GET_ARTICLE_CONTENT %>" />
	<portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
	<portlet:param name="portletResource" value="<portlet:namespace/>" />
</liferay-portlet:resourceURL>

<aui:form action="<%= editCampaignURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="<%= campaign == null ? "campaign" : "editCampaign" %>" />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignId" value="<%= campaignId %>" />

		<aui:input type="hidden" name="articleId" />

		<aui:input type="hidden" name="content" id="content" value="<%= content %>" />

		<aui:input name="title" label="Title" />
		<liferay-ui:error key="campaigntitle-required" message="campaigntitle-required" />

		<liferay-ui:input-editor name="contentEditor" toolbarSet="liferay-article" width="100%" onChangeMethod='<%= renderResponse.getNamespace() + "changeContent" %>' />
		<liferay-ui:error key="campaigncontent-required" message="campaigncontent-required" />


		<%
		String webContentPopUpURL = "javascript:Liferay.Util.openWindow({id: '',title: 'Web Content',uri: '" + selectContentPopupURL +"'});";
		%>

		<aui:button value="Select WebContent" onClick="<%= webContentPopUpURL %>"/>
	
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script>

function <portlet:namespace />initEditor() {
	return document.getElementById('<portlet:namespace/>content').value;
}

function <portlet:namespace />changeContent() {
	document.getElementById('<portlet:namespace/>content').value = window.frames['contentEditor'].getHTML();
}

Liferay.provide(
	window,
	'<portlet:namespace/>setCampaignContentValue',
	function(articleId) {
		var A = AUI();
		A.io.request('<%= getArticleContentURL %>',
			{
				data: {
					articleId: articleId
				},

				on: {
					success: function() {
						var instance = this;

						var data = instance.get('responseData');

						window.frames['contentEditor'].setHTML(data);
					}
				}
			}
		);
	},
	['aui-io']
);
</aui:script>