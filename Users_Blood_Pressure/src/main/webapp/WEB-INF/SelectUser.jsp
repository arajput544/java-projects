<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select User</title>
</head>
<body>
<form action='AddUser' method='post'>
<select onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value)">
<option>Select..</option>
<c:forEach items="${users}" var="user">
	<option value = "DisplayReading">${user.name}</option>
</c:forEach>

</select>


<input type='text' name='name'>
<button>Submit/Add</button>
</form>

</body>
</html>