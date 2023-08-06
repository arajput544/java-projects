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
			<a href='ListGames'>Games</a> > ${ game } > Review
		</h5>
		<form method="post">
			<input hidden="true" type="text" name="game" value="game"> <input
				hidden="true" type="text" name="id" value="gameID"> Your name: <input
				type="text" name="name"><br> Your rating: 1 <input
				type="radio" id="1" name="rating" value="1"> <input
				type="radio" id="2" name="rating" value="2"> <input
				type="radio" id="3" name="rating" value="3"> <input
				type="radio" id="4" name="rating" value="4"> <input
				type="radio" id="5" name="rating" value="5"> <input
				type="radio" id="6" name="rating" value="6"> <input
				type="radio" id="7" name="rating" value="7"> <input
				type="radio" id="8" name="rating" value="8"> <input
				type="radio" id="9" name="rating" value="9"> <input
				type="radio" id="10" name="rating" value="10">10 <br>

			<textarea name="review" rows="6" cols="40"></textarea>
			<br>
			<button>Save</button>
		</form>
	</div>
</body>
</html>