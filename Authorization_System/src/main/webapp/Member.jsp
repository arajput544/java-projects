<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><b>Welcome 
	<%  out.println(session.getAttribute("username")); %>
	to the Members Area</b></h3>
	
	<br/>
	
	<a href="Logout"> Logout </a>

</body>
</html>