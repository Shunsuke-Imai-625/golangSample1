<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>解答表示画面</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="jumbotron">皆さんの解答</h1>

	<table border="1">
		<tr>

			<th
				<c:if test="${requestScope.newestAnswer[0].correctFlag=='0' }"> style="background:red"</c:if>><c:out
					value="${requestScope.newestAnswer[0].teamName }"></c:out>
				<hr> <c:out value="${requestScope.newestAnswer[0].answer }"></c:out></th>
			<th
				<c:if test="${requestScope.newestAnswer[1].correctFlag=='0' }"> style="background:red"</c:if>><c:out
					value="${requestScope.newestAnswer[1].teamName }"></c:out>
				<hr> <c:out value="${requestScope.newestAnswer[1].answer }"></c:out></th>
			<th
				<c:if test="${requestScope.newestAnswer[2].correctFlag=='0' }"> style="background:red"</c:if>><c:out
					value="${requestScope.newestAnswer[2].teamName }"></c:out>
				<hr> <c:out value="${requestScope.newestAnswer[2].answer }"></c:out></th>
		<tr>
		<tr>
			<th
				<c:if test="${requestScope.newestAnswer[3].correctFlag=='0' }"> style="background:red"</c:if>><c:out
					value="${requestScope.newestAnswer[3].teamName }"></c:out>
				<hr> <c:out value="${requestScope.newestAnswer[3].answer }"></c:out></th>
			<th
				<c:if test="${requestScope.newestAnswer[4].correctFlag=='0' }"> style="background:red"</c:if>><c:out
					value="${requestScope.newestAnswer[4].teamName }"></c:out>
				<hr> <c:out value="${requestScope.newestAnswer[4].answer }"></c:out></th>
			<th></th>
		<tr>
	</table>

	<a href="ShowNewestAnswerServlet">最新の解答を表示</a>

</body>
</html>