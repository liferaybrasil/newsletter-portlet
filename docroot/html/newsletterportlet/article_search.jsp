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
ArticleDisplayTerms displayTerms = new ArticleDisplayTerms(renderRequest);
%>

<liferay-ui:search-toggle
	id="toggle_id_journal_article_search"
	displayTerms="<%= displayTerms %>"
	buttonLabel="search"
>
	<aui:fieldset>
		<aui:column>
			<aui:input label="Title" name="<%= displayTerms.TITLE %>" size="20" type="text" value="<%= displayTerms.getTitle() %>" />

			<aui:select name="<%= displayTerms.TYPE %>">
				<aui:option value=""></aui:option>

				<%
				for (int i = 0; i < JournalArticleConstants.TYPES.length; i++) {
				%>

					<aui:option label="<%= JournalArticleConstants.TYPES[i] %>" selected="<%= displayTerms.getType().equals(JournalArticleConstants.TYPES[i]) %>" />

				<%
				}
				%>

			</aui:select>
		</aui:column>

		<aui:column>
			<aui:input name="<%= displayTerms.DESCRIPTION %>" size="20" type="text" value="<%= displayTerms.getDescription() %>" />

			<c:choose>
				<c:when test="<%= portletName.equals(PortletKeys.JOURNAL) %>">
					<aui:select name="<%= displayTerms.STATUS %>">
						<aui:option value=""></aui:option>
						<aui:option label="draft" selected='<%= displayTerms.getStatus().equals("draft") %>' />
						<aui:option label="pending" selected='<%= displayTerms.getStatus().equals("pending") %>' />
						<aui:option label="approved" selected='<%= displayTerms.getStatus().equals("approved") %>' />
						<aui:option label="expired" selected='<%= displayTerms.getStatus().equals("expired") %>' />
					</aui:select>
				</c:when>
				<c:otherwise>

					<%
					List<Group> myPlaces = user.getMyPlaces();

					List<Layout> scopeLayouts = new ArrayList<Layout>();

					for (Layout curGroupLayout : LayoutLocalServiceUtil.getLayouts(themeDisplay.getParentGroupId(), false)) {
						if (curGroupLayout.hasScopeGroup()) {
							scopeLayouts.add(curGroupLayout);
						}
					}

					for (Layout curGroupLayout : LayoutLocalServiceUtil.getLayouts(themeDisplay.getParentGroupId(), true)) {
						if (curGroupLayout.hasScopeGroup()) {
							scopeLayouts.add(curGroupLayout);
						}
					}
					%>

					<aui:select label="my-places" name="<%= displayTerms.GROUP_ID %>">
						<aui:option label="global" selected="<%= displayTerms.getGroupId() == themeDisplay.getCompanyGroupId() %>" value="<%= themeDisplay.getCompanyGroupId() %>" />

						<%
						for (Group myPlace : myPlaces) {
							if (myPlace.hasStagingGroup() && !myPlace.isStagedRemotely() && myPlace.isStagedPortlet(PortletKeys.JOURNAL)) {
								myPlace = myPlace.getStagingGroup();
							}
						%>

							<aui:option label='<%= myPlace.isUser() ? "my-community" : HtmlUtil.escape(myPlace.getDescriptiveName()) %>' selected="<%= displayTerms.getGroupId() == myPlace.getGroupId() %>" value="<%= myPlace.getGroupId() %>" />

						<%
						}
						%>

						<c:if test="<%= !scopeLayouts.isEmpty() %>">

							<%
							for (Layout curScopeLayout : scopeLayouts) {
							%>

								<%
								Group scopeGroup = curScopeLayout.getScopeGroup();

								String label = HtmlUtil.escape(curScopeLayout.getName(locale));

								if (curScopeLayout.equals(layout)) {
									label = LanguageUtil.get(pageContext, "current-page") + " (" + label + ")";
								}
								%>

								<aui:option label='<%= label %>' selected="<%= displayTerms.getGroupId() == scopeGroup.getGroupId() %>" value="<%= scopeGroup.getGroupId() %>" />

							<%
							}
							%>

						</c:if>
					</aui:select>
				</c:otherwise>
			</c:choose>
		</aui:column>
	</aui:fieldset>
</liferay-ui:search-toggle>