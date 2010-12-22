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

<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="setCampaignPref" var="setCampaignPrefUrl" />

<aui:form action="<%= setCampaignPrefUrl %>" method="POST" name="fm">
	<aui:input name="rowsPerPage" value='<%= prefs.getValue("rowsPerPage","") %>' size="45" type="text" />
	<aui:input name="user" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_POP3_USER,"") %>' size="45" type="text" />
	<aui:input name="password" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PASSWORD,"") %>' size="45" type="text" />
	<aui:input name="host" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_POP3_HOST,"") %>' size="45" type="text" />
	<aui:input name="port" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_POP3_PORT,"") %>' size="45" type="text" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>