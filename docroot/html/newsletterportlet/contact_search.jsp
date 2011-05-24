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
ContactDisplayTerms displayTerms = new ContactDisplayTerms(renderRequest);
%>

<liferay-ui:search-toggle
	id="toggle_id_contact_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input label="Name" name="<%= displayTerms.NAME %>" size="20" type="text" value="<%= displayTerms.getName() %>" />
			<aui:input label="Email" name="<%= displayTerms.EMAIL %>" size="20" type="text" value="<%= displayTerms.getEmail() %>" />
			<aui:select name="<%= displayTerms.STATUS %>">
				<aui:option value=""></aui:option>
				<aui:option label="sent" selected='<%= displayTerms.getStatus().equals("sent") %>' />
				<aui:option label="failed" selected='<%= displayTerms.getStatus().equals("failed") %>' />
			</aui:select>
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>