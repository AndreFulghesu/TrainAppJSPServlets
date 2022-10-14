<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.andrea.trainApp.util.Constants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TraiApp | Login</title>
</head>
<body>
<%
    String genericMessage = "";
    if(request.getAttribute(Constants.STATUS) != null){
    	genericMessage = (String)request.getAttribute(Constants.STATUS);
    }
%>


<% if(!genericMessage.isEmpty()) { %>
        <div>
            <h1> <%= genericMessage %> </h1>
        </div>
        
<% }%>

	<div>
		<form method="post" action="login">
			<div>
				<label for="username"></label>
				<input type="text" name="username" id="username" placeholder="Your Name" />
			
			</div>
			
			<div>
				<label for="password"></label>
				<input type="password" name="password" id="password" placeholder="Your Password" />
			
			</div>
			
			<div>
				<button type="submit" name="login" id="login" value="Log in">Login</button>
			</div>

		</form>
	</div>
	
	<div>
	
		<a href="registration.jsp" name="registration">Sei nuovo? Registrati</a>
	
	</div>
	

</body>
</html>