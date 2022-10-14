<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify User | TrainApp </title>
</head>
<body>

	<c:if test="${SEARCHED_USER != null}">
	
		<label>Username</label>
		<br>
		<input type="text" value="<c:out value='${SEARCHED_USER.getUsername()}' />" name="username" required="required" />  
		
		<br>
		<label>Password</label>
		<br>
		<input type="password" value="<c:out value='${SEARCHED_USER.getPassword()}' />" name="password" required="required" />  

		<br>
		<label>Email</label>
		<br>
		<input type="text" value="<c:out value='${SEARCHED_USER.getEmail()}' />" name="email" required="required" />  
		
		<br>
		<label>Address</label>
		<br>
		<input type="text" value="<c:out value='${SEARCHED_USER.getAddress()}' />" name="address" required="required" />  
		
		<br>
		<label>User Role</label>
		<br>
		<input type="text" value="<c:out value='${SEARCHED_USER.getUserRole().getName()}' />" name="userRole" required="required" />  
		
		<br>
		<label>Phone</label>
		<br>
		<input type="text" value="<c:out value='${SEARCHED_USER.getPhone()}' />" name="phone" required="required" />  
		
	</c:if>

</body>
</html>