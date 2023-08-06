<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rebates</title>
</head>
<body>
	<form action="AddRebates" method="post">
	<table border="1">
		<thead>
			<tr>
				<th>Rebate</th>
				<th>Amount</th>
				<th>Received</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rebates}" var="rebate">
				<tr>
					<td>${rebate.rebate_name}</td>
					<td style="text-align: center;">$ ${rebate.rebate_amnt}</td>
					<c:if test = "${rebate.rebate_details == 'Not Received'}">
						<td><a href="ReceiveRebates?id=${rebate.rebate_id}">${rebate.rebate_details}</a></td>
					</c:if>
					<c:if test = "${rebate.rebate_details != 'Not Received'}">
						<td>${rebate.rebate_details}</td>
					</c:if>
				</tr>
			</c:forEach>
			<tr>
				<td><input name="rebate" type="text"></td>
				<td><input name="amount" type="text"></td>
				<td><input name="add" type="submit" value="Add"></td>
			</tr>
		</tbody>
	</table>
	</form>
	
	<h3>
		<c:set var="totrebate" value="${0}" />
		<c:set var="totrebaterecv" value="${0}" />
			<c:forEach var="rebate" items="${rebates}">
  				<c:set var="totrebate" value="${totrebate + rebate.rebate_amnt}" />
  				<c:if test = "${rebate.rebate_details != 'Not Received'}">
  					<c:set var="totrebaterecv" value="${totrebaterecv + rebate.rebate_amnt}" />
  				</c:if>
			</c:forEach>
			Total: $ <c:out value="${totrebate}"/> <br>
			Total Received: $ <c:out value="${totrebaterecv}"/>
			
	 </h3>
	
</body>
</html>