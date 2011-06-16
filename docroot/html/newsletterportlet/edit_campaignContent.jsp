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
String contentEditorClass = "contentEditor-div";
String displayingArticleContentClass = "displaying-article-content";

long campaignContentId = ParamUtil.getLong(request, "campaignContentId");

if (campaignContentId > 0) {
	campaignContent = CampaignContentLocalServiceUtil.getCampaignContent(campaignContentId);
	content = campaignContent.getContent();

	if(campaignContent.getArticleId()>0){
		contentEditorClass = contentEditorClass + " yui3-aui-helper-hidden";
	}
	else{
		displayingArticleContentClass = displayingArticleContentClass + " yui3-aui-helper-hidden";
	}
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
	<portlet:param name="import" value="false" />
	<portlet:param name="jspPage" value="/html/newsletterportlet/popup.jsp" />
	<portlet:param name="resourceNamespace" value="<%= renderResponse.getNamespace() %>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" varImpl="importContentPopupURL">
	<portlet:param name="tabs1" value="CampaignContent" />
	<portlet:param name="redirect" value="<%= redirect %>" />
	<portlet:param name="import" value="true" />
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
		<aui:input type="hidden" name="cmd" value='<%= campaignContent == null ? "campaignContent" : "editCampaignContent" %>' />

		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="campaignContentId" value="<%= campaignContentId %>" />

		<aui:input type="hidden" name="articleId" />

		<aui:input type="hidden" name="content" id="content" value="<%= content %>" />

		<aui:input name="title" label="Title" />
		<liferay-ui:error key="campaignContenttitle-required" message="campaignContenttitle-required" />

		<div class="separator article-separator"><!-- --></div>
		<% String classMsgInfo = "portlet-msg-info " + (campaignContent == null ? "yui3-aui-helper-hidden" : "") ; %>
		<div class="<%= classMsgInfo %>">
			<span class="displaying-article-id-holder">
				<liferay-ui:message key="displaying-content" />: <span class="displaying-article-id"> </span>
			</span>
		</div>
		<div class="<%= contentEditorClass %>">
			<liferay-ui:input-editor name="contentEditor" toolbarSet="liferay-article" width="100%" onChangeMethod='changeContent' />
		</div>
		<span class="<%=displayingArticleContentClass %>">  <%= content %> </span>

		<liferay-ui:error key="campaignContentcontent-required" message="campaignContentcontent-required" />

		<div class="separator article-separator"><!-- --></div>

		<%
		String importWebContentPopUpURL = "javascript:Liferay.Util.openWindow({id: '',title: 'Web Content',uri: '" + importContentPopupURL +"'});";
		%>
		<aui:button value="Import WebContent" onClick="<%= importWebContentPopUpURL %>" />

		<%
		String webContentPopUpURL = "javascript:Liferay.Util.openWindow({id: '',title: 'Web Content',uri: '" + selectContentPopupURL +"'});";
		%>
		<aui:button value="Select WebContent" onClick="<%= webContentPopUpURL %>" />

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
	document.getElementById('<portlet:namespace/>content').value = window.frames['<portlet:namespace/>contentEditor'].getHTML();
}

Liferay.provide(
	window,
	'<portlet:namespace/>setCampaignContentValue',
	function(articleId, articleTitle, import) {
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
						var displayArticleContent = A.one('.displaying-article-content');
						var fckeditor = A.one('.contentEditor-div');
						if(import){
							fckeditor.hide();
							displayArticleContent.set('innerHTML', data);
							document.getElementById('<portlet:namespace/>content').value = data;
							document.getElementById('<portlet:namespace/>articleId').value = articleId;
							displayArticleContent.show();
						}
						else {
							displayArticleContent.hide();
							window.frames['<portlet:namespace/>contentEditor'].setHTML(data);
							document.getElementById('<portlet:namespace/>articleId').value = 0;
							fckeditor.show();
						}

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