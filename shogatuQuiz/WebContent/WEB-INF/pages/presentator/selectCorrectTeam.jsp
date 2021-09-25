<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>正解者選択</title>
</head>
<body>

	<h1>正解者選択</h1>

	<h3>みんなの解答</h3>
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
	<a href="UpdateNewestAnswerServlet">最新の解答に更新 </a>
	<br>
	<br>正解したチームは？
	<form method="post" action="AddPointServlet">
		<input type="checkbox" name="team" value="1">チームさと <input
			type="checkbox" name="team" value="2">チームまみ <input
			type="checkbox" name="team" value="3">チームじい <input
			type="checkbox" name="team" value="4">チームけーた <input
			type="checkbox" name="team" value="5">チームにーに

			<input type="submit" value="送信" onclick="Window.alert('送信してよろしいですか？')">

	</form>

</body>
</html>