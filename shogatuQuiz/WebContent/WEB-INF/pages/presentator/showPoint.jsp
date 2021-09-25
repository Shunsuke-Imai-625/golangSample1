<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>得点表示画面</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<h1 class="jumbotron">みなさんの得点</h1>

	<table border="1">
		<tr>
			<th><c:out value="${requestScope.newestPoint[0].teamName }"></c:out></th>
			<th><c:out value="${requestScope.newestPoint[1].teamName }"></c:out></th>
			<th><c:out value="${requestScope.newestPoint[2].teamName }"></c:out></th>
			<th><c:out value="${requestScope.newestPoint[3].teamName }"></c:out></th>
			<th><c:out value="${requestScope.newestPoint[4].teamName }"></c:out></th>
		</tr>
		<tr>
			<td><c:out value="${requestScope.newestPoint[0].point }"></c:out></td>
			<td><c:out value="${requestScope.newestPoint[1].point }"></c:out></td>
			<td><c:out value="${requestScope.newestPoint[2].point }"></c:out></td>
			<td><c:out value="${requestScope.newestPoint[3].point }"></c:out></td>
			<td><c:out value="${requestScope.newestPoint[4].point }"></c:out></td>
		</tr>

	</table>
	<a href="ShowNewestPointServlet">最新の得点を表示</a>

</body>
</html>