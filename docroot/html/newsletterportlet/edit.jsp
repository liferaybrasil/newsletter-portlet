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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%@ include file="/html/init.jsp" %>

<portlet:actionURL name="setNewsletterPref" var="setNewsletterPrefUrl" />

<liferay-ui:error key="preferences-added" message="preferences-added" />
<aui:form action="<%= setNewsletterPrefUrl %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="cmd" value="setNewsletterPref" />
		<aui:input name="senderName" label="Sender Name" value='<%= prefs.getValue(NewsletterConstants.SENDER_NAME,"") %>' size="45" type="text" />
		<aui:input name="senderEmail" label="Sender Email" value='<%= prefs.getValue(NewsletterConstants.SENDER_EMAIL,"") %>' size="45" type="text" />
		<aui:input name="smtpHost" label="SMTP Host" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_HOST,"") %>' size="45" type="text" />
		<aui:input name="smtpPort" label="SMTP Port" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_PORT,"") %>' size="45" type="text" />
		<aui:input name="smtpUser" label="SMTP User" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER,"") %>' size="45" type="text" />
		<aui:input name="smtpPassword" label="SMTP Password" value='<%= prefs.getValue(PropsKeys.MAIL_SESSION_MAIL_SMTP_PASSWORD,"") %>' size="45" type="text" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>