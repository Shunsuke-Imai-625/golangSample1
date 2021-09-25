<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メインメニュー</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<h1>メインメニュー</h1>


	<p>
		現在の問題数
		<c:out value="${sessionScope.nowQNumber}"></c:out>
	</p>

	<p>問題選択チームは
	<h3>
		<c:out value="${sessionScope.answerTeam}"></c:out>
	</h3>

	・
	<a href="ShowSelectQuestionServlet">問題選択画面へ</a>


</body>
</html>