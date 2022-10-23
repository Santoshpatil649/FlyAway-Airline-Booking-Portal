<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights List</title>
</head>
<body>
<h3 align="right"><a href="index.html">Back</a></h3>
<h1 align="center">Available Flights</h1>
<table border="1" cellpadding="30%" align="center" bgcolor="skyblue">
<tr>
<th>FlightNumber</th>
<th>Source</th>
<th>Destination</th>
<th>Time</th>
<th>Duration</th>
<th>Price</th>
</tr>
	<c:forEach var="items" items="${flightlist}">
	<tr>
	<td>${items.flightNumber}</td>
	<td>${items.source}</td>
	<td>${items.destination}</td>
	<td>${items.time}</td>
	<td>${items.duration}</td>
	<td>${items.price}</td>
	</tr>
	</c:forEach>
	
</table>
<form action="Payment" method="post" align="center">
Name:<input type="text" name="name"><br><br>
Phone:<input type="number" name="phone"><br><br>
Flight Number:<input type="number" name="flight"><br><br>
<h3>Please Provide Correct Flight Number to avoid further Discrepancies</h3>
<input type="submit" value="Proceed to Payment">
</form>
</body>
</html>
