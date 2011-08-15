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
JournalArticleDisplayTerms displayTerms = new JournalArticleDisplayTerms(renderRequest);
%>

<liferay-ui:search-toggle
	id="toggle_id_event_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input name="<%= displayTerms.TITLE %>" size="20" value="<%= displayTerms.getTitle() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.CONTENT %>" size="50" value="<%= displayTerms.getContent() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.TYPE %>" size="50" value="<%= displayTerms.getType() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.ARTICLE_ID %>" size="50" value="<%= displayTerms.getArticleId() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.VERSION %>" size="50" value="<%= displayTerms.getVersion() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.DESCRIPTION %>" size="50" value="<%= displayTerms.getDescription() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.STRUCTURE_ID %>" size="50" value="<%= displayTerms.getStructureId() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.TEMPLATE_ID %>" size="50" value="<%= displayTerms.getTemplateId() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.DISPLAY_DATE %>" size="50" value="<%= displayTerms.getDisplayDate() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.REVIEW_DATE %>" size="50" value="<%= displayTerms.getReviewDate() %>" />
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.EXPIRATION_DATE %>" size="50" value="<%= displayTerms.getExpirationDate() %>" />
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>

<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<aui:script>
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace /><%= displayTerms.TITLE %>);
	</aui:script>
</c:if>