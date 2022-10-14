<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.andrea.trainApp.models.AppUser"%>
<%@ page import="it.andrea.trainApp.util.Constants"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage | TrainApp</title>
</head>
<body>
	<%
	AppUser loggedUser = null;
	String genericMessage = "";
	List<AppUser> allUsers = new ArrayList<>();
	if (session.getAttribute(Constants.LOGGED_USER) != null && session.getAttribute(Constants.STATUS) != null
			&& request.getAttribute(Constants.ALL_USERS) != null) {
		loggedUser = (AppUser) session.getAttribute(Constants.LOGGED_USER);
		genericMessage = (String) session.getAttribute(Constants.STATUS);
	}
	%>

	<%
	if (!genericMessage.isEmpty()) {
	%>
	<div>
		<h1>
			<%=genericMessage%>
			<%=loggedUser.getUsername()%>
		</h1>
	</div>

	<%
	}
	%>


	<table>
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Birth Place</th>
			<th>User Role</th>
		</tr>
		<c:forEach items="${ALL_USERS}" var="user">
			<tr>
				<td>${user.getUsername()}</td>
				<td>${user.getEmail()}</td>
				<td>${user.getAddress()}</td>
				<td>${user.getPhone()}</td>
				<td>${user.getBirthPlace()}</td>
				<td>${user.getUserRole().getName()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>