<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video Game Review</title>
</head>
<body>
	<div class='container pt-3'>
		<h5 class='m-2'>
			<a href='ListGames'>Games</a> > ${ game }
		</h5>
		<c:forEach items='${ gamesReview }' var='review'>
			<p>${ review.username } (${ review.rating}) : ${ review.review} </p> 
		</c:forEach>
	</div>
</body>
</html>