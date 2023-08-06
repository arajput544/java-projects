<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SelectUser</title>
</head>
<body>
<form action='SelectUser' method='post'>
<select onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value)">
<option>Select..</option>
<c:forEach items="${entries}" var="entry">
	<option value="UserRecord">${entry.name}</a></option>	
</c:forEach>
</select>


<input type='text' name='name'>
<button>Submit</button>
</form>
</body>
</html>