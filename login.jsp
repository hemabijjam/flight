<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<form action="login" method="post">
	<h4>User Login Credentials</h4>
		<pre>
			User Name		: <input type="text" name="email" /><br/>
			Password		: <input type="password" name="password" /><br/>
				 			 <input type="submit" value="Login" />
		</pre>
		<br/>
		${message}
	</form>
</body>
</html>