<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="registerUser" method="post">
	<h4>User Registration</h4>
		<pre>
			First Name	:<input type="text" name="firstName" /><br/>
			Last Name	:<input type="text" name="lastName" /><br/>
			Email		:<input type="text" name="email" /><br/>
			Password	:<input type="password" name="password" /><br/>
			ConfirmPassword	:<input type="password" name="confirmPassword" /><br/>
						<input type="submit" value="Register" />
	</pre>
	</form>
</body>
</html>
