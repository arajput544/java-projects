<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
#maintable {width: 800px; margin: 0 auto;}
 #maintable td.orange {color: #ff9933;}
 #maintable td.blue {color:#00F;}

</style>
<title>Display Reading</title>
</head>
<body>
<table border="1">
<tr>
<th>Systolic</th>
<th>Diastolic</th>
<th>Time</th>
</tr>
<tr><td><input type="text" name="s"></td>
<td><input type="text" name ="d">	</td>
<td><button>Add Reading</button></td>
</tr>
<form action='DisplayReading' method='post'>
<c:forEach items="${entries}" var="entry">
<tr>
<c:choose>
						<c:when test="${entry.getS() < 120}">
							<td class="orange">${entry.getS()}</td>
						</c:when>
						<c:otherwise>
							<td class="red">${entry.getS()}</td>
						</c:otherwise>
					</c:choose>


<td>${entry.getD()}</td>
<td>${entry.getTimeframe() }</td>
</tr>
</c:forEach>
</form>
<tr>
</tr>
</table>

</body>
</html>