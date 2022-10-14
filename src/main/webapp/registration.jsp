<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="it.andrea.trainApp.util.Constants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration | TrainApp</title>
</head>
<body>

<% 
	String genericMessage = "";
	if(request.getAttribute(Constants.STATUS) != null){
		
		genericMessage = (String)request.getAttribute(Constants.STATUS);
	}

%>

	<form method="post" action="register">
		<div>
			<label for="username"></label> <input type="text" name="username"
				id="username" placeholder="Your Name" />

		</div>

		<div>
			<label for="password"></label> <input type="password" name="password"
				id="password" placeholder="Your Password" />

		</div>

		<div>
			<label for="email"></label> <input type="text" name="email"
				id="email" placeholder="Your email" />

		</div>

		<div>
			<label for="address"></label> <input type="text" name="address"
				id="address" placeholder="Your address" />

		</div>

		<div>
			<label for="birth_place"></label> <input type="text"
				name="birth_place" id="birth_place" placeholder="Your Birth Place" />

		</div>

		<div>
			<label for="phone"></label> <input type="text" name="phone"
				id="phone" placeholder="Your phone number" />

		</div>

		<div>
			<p>Please select your user type registration:</p>
			
			<input type="radio" id="user" name="user_role" value="USER">
			<label for="user">USER</label>   
			
			<input type="radio" id="admin" name="user_role" value="ADMIN">
			<label for="admin">ADMIN</label>

		</div>
		
		<br>
		
		<div>
			<button type="submit" name="register" id="register" value="Register">Register</button>
		</div>
		
		<div>
			<a href="login.jsp">Back to the login page...</a>
		</div>
		
		<% if(!genericMessage.isEmpty()) { %>
        <div>
            <h1> <%= genericMessage %>  </h1>
        </div>
        
		<% }%>

	</form>

</body>
</html>