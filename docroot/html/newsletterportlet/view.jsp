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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "Campaign");

String tabNames = "Campaign,Sending";

%>
<portlet:renderURL var="renderURL">
		<portlet:param name="tabs1" value="<%= tabs1 %>" />
</portlet:renderURL>

<liferay-ui:tabs
   names="<%= tabNames %>"
   url="<%= renderURL %>"

/>

<c:if test='<%= tabs1.equals("Campaign") %>'>
  <liferay-util:include servletContext="<%= application %>" page="/html/newsletterportlet/view_campaign.jsp" />
</c:if>
<c:if test='<%= tabs1.equals("Sending") %>'>
  <liferay-util:include servletContext="<%= application %>" page="/html/newsletterportlet/view_send.jsp" />
</c:if>