<%@include file="/init.jsp"%>

<%
	TraccarUser traccarUserVar = null;
%>

<aui:button-row cssClass="guestbook-buttons">

	<portlet:renderURL var="addTraccarUserURL">
		<portlet:param name="mvcPath" value="/edit_user.jsp" />
	</portlet:renderURL>

	<aui:button onClick="<%=addTraccarUserURL.toString()%>"
		value="Add Traccar User"></aui:button>

</aui:button-row>

<portlet:actionURL var="deleteTraccarUserURL" name="deleteTraccarUser"/>

<liferay-ui:search-container
	total="<%=TraccarUserLocalServiceUtil.getTraccarUsersCount()%>">
	<liferay-ui:search-container-results
		results="<%=TraccarUserLocalServiceUtil.getTraccarUsers(scopeGroupId.longValue(),
						searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.bmstu.users.manager.model.TraccarUser"
		modelVar="traccarUser">

		<liferay-ui:search-container-column-text property="traccarUserId" />

		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text property="password" />

		<liferay-ui:search-container-column-text property="email" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<aui:form action="<%=deleteTraccarUserURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=traccarUserVar%>"
		model="<%=TraccarUser.class%>" />

	<aui:fieldset>

		<aui:input name="traccarUserId" type="clear"/>

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit" value="Delete"></aui:button>

	</aui:button-row>
</aui:form>