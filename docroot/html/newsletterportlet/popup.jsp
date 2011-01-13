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
			
		<liferay-ui:search-container-column-text
			name="Title"
			value="<%= article.getTitle() %>"
		/>

		<liferay-ui:search-container-column-text
			name="Version"
			value="<%= String.valueOf(article.getVersion()) %>"
		/>

		<%
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		%>

		<liferay-ui:search-container-column-text
			name="Modified Date"
			value="<%= dateFormat.format(article.getModifiedDate()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="Display Date"
			value="<%= dateFormat.format(article.getDisplayDate()) %>"
		/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>