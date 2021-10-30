<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="findFlights" method="post">
		<h4>Find Flights :</h4>
			<pre>
				From				: <input type="text" name="from"/><br/>
				To					: <input type="text" name="to"/><br/>
				Departure Date		: <input type="text" name="departureDate"/><br/>
						  <input type="submit" value="Search"/>
			</pre>
	</form>
</body>
</html>