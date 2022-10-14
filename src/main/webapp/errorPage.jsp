<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.andrea.trainApp.util.Constants" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error | TrainApp</title>
</head>
<body>
	<h2>Sorry an exception occured!</h2> 
	<h3><c:out value="${Constants.FATAL_ERROR}" /></h3>

</body>
</html>