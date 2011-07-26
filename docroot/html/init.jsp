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
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.newsletter.util.NewsletterConstants" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.newsletter.model.Campaign" %>
<%@ page import="com.liferay.newsletter.model.Contact" %>
<%@ page import="com.liferay.newsletter.model.CampaignContent" %>
<%@ page import="com.liferay.newsletter.service.CampaignContentLocalServiceUtil" %>
<%@ page import="com.liferay.newsletter.service.CampaignLocalServiceUtil" %>
<%@ page import="com.liferay.newsletter.service.ContactLocalServiceUtil" %>
<%@ page import="com.liferay.newsletter.service.NewsletterLogLocalServiceUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticleDisplay" %>

<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticleConstants" %>
<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.newsletter.search.ArticleDisplayTerms" %>
<%@ page import="com.liferay.newsletter.search.ArticleSearch" %>
<%@ page import="com.liferay.newsletter.search.ArticleSearchTerms" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>

<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.util.portlet.PortletProps" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="java.text.Format" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@ page import="com.liferay.newsletter.search.contact.ContactDisplayTerms" %>
<%@ page import="com.liferay.newsletter.search.contact.ContactSearchTerms" %>
<%@ page import="com.liferay.newsletter.search.contact.ContactSearch" %>

<%@ page import="com.liferay.newsletter.exception.EmailSubjectException" %>
<%@ page import="com.liferay.newsletter.exception.SenderEmailException" %>
<%@ page import="com.liferay.newsletter.exception.SenderNameException" %>
<%@ page import="com.liferay.newsletter.exception.ContactsException" %>
<%@ page import="com.liferay.newsletter.exception.TitleException" %>
<%@ page import="com.liferay.newsletter.exception.ContentException" %>
<%@ page import="com.liferay.newsletter.exception.IdNotFoundException" %>




<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>