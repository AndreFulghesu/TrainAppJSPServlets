<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error | TrainApp</title>
</head>
<body>
<%
    String errorMessage = "";
    if(session.getAttribute("ERROR")!= null){
        errorMessage = (String)session.getAttribute("ERROR");
    }
%>

<% if(!errorMessage.isEmpty()) { %>
        <div>
            <h1> <%= errorMessage %> </h1>
        </div>
        
        <% }%>

</body>
</html>