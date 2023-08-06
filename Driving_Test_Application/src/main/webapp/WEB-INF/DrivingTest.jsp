<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving Test</title>
</head>
<body>
<p>${question[id].description}</p>
<p>1. ${question[id].answerA}</p>
<p>2. ${question[id].answerB}</p>
<p>3. ${question[id].answerC}</p>
<p>Correct Answer: ${question[id].correctAnswer}</p>
<p><a href="DrivingTestBrowser?id=${id < question.size() - 1?id+1: 0}" 
	style="text-decoration: none;">Next</a></p>
</body>
</html>