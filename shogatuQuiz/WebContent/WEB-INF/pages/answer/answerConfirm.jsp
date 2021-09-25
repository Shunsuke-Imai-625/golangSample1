<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>解答確認画面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body style="font-size: xx-large">

	<div class="text-center">

		<h1 class="jumbotron">解答確認画面</h1>
		<h1>以下の解答を送信してもよろしいですか？</h1>

		<br>

		<div style="font-size: 100px">
			<c:out value="${requestScope.answer}"></c:out>
		</div>

		<br> <br> <br>
		<form action="SendAnswerServlet" method="post">
			<input  type="hidden" name="answer" value="${requestScope.answer}">
			<input style="width: 300px; height: 100px; font-size: 50px" type="submit" value="送信">

		</form>
		<form action="BackAnswerServlet" method="post">

			<input type="hidden" name="answer" value="${requestScope.answer}">
			<br> <br> <input style="width: 400px; height: 100px; font-size: 50px" type="submit" value="キャンセル">

		</form>
	</div>
</body>
</html>