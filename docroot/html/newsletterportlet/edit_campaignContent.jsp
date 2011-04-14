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
	CampaignContent campaignContent = null;
	String content = "";

	long campaignContentId = ParamUtil.getLong(request, "campaignContentId");

	if (campaignContentId > 0) {
		campaignContent = CampaignContentLocalServiceUtil.getCampaignContent(campaignContentId);
		content = campaignContent.getContent();
	}


	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (campaignContent != null) ? campaignContent.getTitle() : "New Campaign Content" %>'
/>


<aui:model-context bean="<%= campaignContent %>" model="<%= CampaignContent.class %>" />

<portlet:actionURL var="editCampaignContentURL" />

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" varImpl="selectContentPopupURL">
	<portlet:param name="tabs1" value="CampaignContent" />
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="jspPage" value="/html/newsletterportlet/popup.jsp" />
	<portlet:param name="resourceNamespace" value="<%= renderResponse.getNamespace() %>" />
</liferay-portlet:renderURL>


<liferay-portlet:resourceURL varImpl="getArticleContentURL">
	<portlet:param name="cmd" value="<%= NewsletterConstants.GET_ARTICLE_CONTENT %>" />
	<portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
	<portlet:param name="portletResource" value="<portlet:namespace/>" />
</liferay-portlet:resourceURL>

<aui:form action="<%= editCampaignContentURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="<%= campaignContent == null ? "campaignContent" : "editCampaignContent" %>" />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignContentId" value="<%= campaignContentId %>" />

		<aui:input type="hidden" name="articleId" />

		<aui:input type="hidden" name="content" id="content" value="<%= content %>" />

		<aui:input name="title" label="Title" />
		<liferay-ui:error key="campaignContenttitle-required" message="campaignContenttitle-required" />

		<liferay-ui:input-editor name="contentEditor" toolbarSet="liferay-article" width="100%" onChangeMethod='<%= renderResponse.getNamespace() + "changeContent" %>' />
		<liferay-ui:error key="campaignContentcontent-required" message="campaignContentcontent-required" />


		<%
		String webContentPopUpURL = "javascript:Liferay.Util.openWindow({id: '',title: 'Web Content',uri: '" + selectContentPopupURL +"'});";
		%>
		<div class="portlet-msg-info aui-helper-hidden"> 
			<span class="displaying-article-id-holder">
				<liferay-ui:message key="displaying-content" />: <span class="displaying-article-id"> </span>
			</span>
		</div>

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
	function(articleId, articleTitle) {
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
						
						A.one('.portlet-msg-info').show();
						var displayArticleId = A.one('.displaying-article-id');
						displayArticleId.set('innerHTML', articleTitle);
					}
				}
			}
		);
	},
	['aui-io']
);
</aui:script>