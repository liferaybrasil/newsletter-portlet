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

<%@ page import="com.liferay.portal.kernel.util.StringBundler" %>
<%@ include file="/html/init.jsp" %>

<%
String resourceNamespace = ParamUtil.getString(request, "resourceNamespace");
boolean importWebContent = ParamUtil.getString(request, "import").equals("true") ? true : false;
String keywords = ParamUtil.getString(request, "keywords");

%>

<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param name="tabs1" value="<%= NewsletterConstants.TABS_POPUP %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
			emptyResultsMessage="no-entries-were-found"
			iteratorURL="<%= portletURL %>"
		>
			<div>
				<aui:input id="keywords" inlineField="<%= true %>" label="" name="keywords" size="30" title="search-lists" type="text" />

				<aui:button type="submit" value="search" />
			</div>

			<br />
			<liferay-ui:search-container-results
				results="<%= JournalArticleLocalServiceUtil.search(
				company.getCompanyId(), scopeGroupId, 0l, keywords,	0.0, 
				StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, null, null, 0, null,
				searchContainer.getStart(), searchContainer.getEnd(),
				searchContainer.getOrderByComparator()) %>"

				total="<%= JournalArticleLocalServiceUtil.searchCount(
				company.getCompanyId(), scopeGroupId, 0, keywords,
				0.0, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, null, null, 0, null) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portlet.journal.model.JournalArticle"
				escapedModel="<%= true %>"
				keyProperty="articleId"
				modelVar="article"
			>
				<%
				StringBundler sb = new StringBundler(7);

				sb.append("javascript:");
				sb.append(renderResponse.getNamespace());
				sb.append("setParentWindowsHiddenFieldValue(");
				sb.append(article.getArticleId());
				sb.append(",'");
				sb.append(article.getTitle(locale));
				sb.append("',");
				sb.append(importWebContent);
				sb.append("');");

				String rowURL = sb.toString();
				%>

				<liferay-ui:search-container-column-text
					name="Title"
					value="<%= article.getTitle(locale) %>"
					href="<%= rowURL %>"
				/>

				<liferay-ui:search-container-column-text
					name="Description"
					value="<%= article.getDescription() %>"
					href="<%= rowURL %>"
				/>

				<liferay-ui:search-container-column-text
					name="Version"
					value="<%= String.valueOf(article.getVersion()) %>"
					href="<%= rowURL %>"
				/>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>

<aui:script>
	function <portlet:namespace/>setParentWindowsHiddenFieldValue(articleId, articleTitle, import) {
		var parentWindow = window.parent;
		//var AUI = parentWindow.AUI;

		parentWindow.<%= resourceNamespace %>setCampaignContentValue(articleId, articleTitle, import);

		//AUI().DialogManager.closeByChild();
    }
</aui:script>