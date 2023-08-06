<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Video Game Review</title>
</head>
<body>
	<div class='container pt-3'>
		<h5 class='m-2'>
			<a href='AddGame'>Add Game</a>
		</h5>
		<table border="1">

			<thead>
				<tr>
					<th scope='col'>Game</th>
					<th scope='col'>Rating</th>
					<th scope='col'></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items='${ gamesList }' var='game'>
					<tr>
						<td><a href='DisplayReview?id=${ game.game_id }'>${ game.game_name }</a></td>
						<td>${ game.rating}</td>
						<td><a href='CreateReview?id=${ game.game_id }'>	Review</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>