<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題選択画面</title>
</head>
<body>

	<h1>問題選択画面</h1>
	<div>
		<c:out value="${requestScope.errorMessage}"></c:out>

	</div>

	<form method="post" action="SelectQuestionServlet">

		ジャンル<br> <select name="genre">
			<c:forEach items="${sessionScope.genreList}" var="genre"
				varStatus="status">
				<option value="${pageScope.genre.genreId}"><c:out
						value="${pageScope.genre.genreName}"></c:out></option>
			</c:forEach>
		</select><br> <br> 得点 <select name="point">
			<option value="1">10</option>
			<option value="2">20</option>
			<option value="3">30</option>

		</select> <br> <input type="submit" value="選択">
	</form>


	<br>
	<br>
	<a href="ShowGyakutenQuizServlet">逆転クイズに進む</a>
</body>
</html>