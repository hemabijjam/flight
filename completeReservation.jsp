<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>

	<h2>Complete Reservation</h2>
	AirLines 		: ${flight.operatingAirlines}<br/>
	Departure City 	: ${flight.departureCity}<br/>
	Arrival City 	: ${flight.arrivalCity}<br/>
	
	<form action="completeReservation" method="post">
	
	<h2>Passenger Details</h2>
	First Name		: <input type="text" name="passengerFirstName"/><br/>
	Last Name		: <input type="text" name="passengerLastName"/><br/>
	Email Id		: <input type="text" name="passengerEmail"/><br/>
	Phone Number	: <input type="text" name="passengerPhone"/><br/>
	
	<h2>Card details</h2>
	
	Name on the Card : <input type="text" name="nameOnTheCard"/><br/>
	Card Number		 : <input type="text" name="cardNumber"/><br/>
	Expiration Date : <input type="text" name="expirationDate"/><br/>
	CVV/Security Number : <input type="text" name="securityCode"/><br/>
	
	<input type="hidden" name="flightId" value="${flight.id}"/>
	<input type="submit" value="Confirm">
	
	</form>
	
</body>
</html>