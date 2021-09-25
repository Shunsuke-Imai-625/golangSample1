<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>逆転クイズ画面</title>
</head>
<body>

	<h1>逆転クイズ画面</h1>
	<form action="DealGyakutenServlet" method="post">
		<input type="radio" id="answer1" name="result" value="0">成功 <input
			type="radio" id="answer1" name="result" value="1">失敗 <br>
		<br> <br> <br> 何ポイントで勝負？？<br> <input type="text"
			name="point"> <br> 勝者チーム<select name="winer">
			<option value="1">チームさと</option>
			<option value="2">チームさわ</option>
			<option value="3">チームけーた</option>
			<option value="4">チームじいちゃん</option>
			<option value="5">チームにーに</option>

		</select> <br> 敗者チーム <select name="loser">
			<option value="1">チームさと</option>
			<option value="2">チームさわ</option>
			<option value="3">チームけーた</option>
			<option value="4">チームじいちゃん</option>
			<option value="5">チームにーに</option>

		</select> <br> <br> <br> <input type="submit" value="送信">

	</form>

</body>
</html>