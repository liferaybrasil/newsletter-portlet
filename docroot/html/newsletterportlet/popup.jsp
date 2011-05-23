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
String resourceNamespace = ParamUtil.getString(request, "resourceNamespace");
boolean importWebContent = ParamUtil.getString(request, "import").equals("true") ? true : false;
%>


<liferay-portlet:renderURL varImpl="portletURL">
	<portlet:param name="tabs1" value="Popup" />
</liferay-portlet:renderURL>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<liferay-ui:search-form
		page="/html/newsletterportlet/article_search.jsp"
		servletContext="<%= application %>"
	/>
</aui:form>

<div class="separator article-separator"><!-- --></div>

	<liferay-ui:search-container
	searchContainer="<%= new ArticleSearch(renderRequest, portletURL) %>"
>
	<%@ include file="article_search_results.jspf" %>

	<liferay-ui:search-container-results
		results="<%= resultList %>"
		total="<%= totalCount %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portlet.journal.model.JournalArticle"
		keyProperty="articleId"
		modelVar="article"
	>

	<%
	String parentFunctionURL = "javascript:" + resourceNamespace + "setParentWindowsHiddenFieldValue("+ article.getArticleId() + ",'" + article.getTitle(locale) + "'," + importWebContent + ");";
	%>

		<liferay-ui:search-container-column-text
			name="Title"
			value="<%= article.getTitle(locale) %>"
			href="<%= parentFunctionURL %>"
		/>

		<liferay-ui:search-container-column-text
			name="Description"
			value="<%= article.getDescription() %>"
			href="<%= parentFunctionURL %>"
		/>

		<liferay-ui:search-container-column-text
			name="Version"
			value="<%= String.valueOf(article.getVersion()) %>"
			href="<%= parentFunctionURL %>"
		/>

		<%
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		%>

		<liferay-ui:search-container-column-text
			name="Modified Date"
			value="<%= dateFormat.format(article.getModifiedDate()) %>"
			href="<%=parentFunctionURL %>"
		/>

		<liferay-ui:search-container-column-text
			name="Display Date"
			value="<%= dateFormat.format(article.getDisplayDate()) %>"
			href="<%=parentFunctionURL %>"
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