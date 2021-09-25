<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー選択画面</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"
	type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		// 要素を取得してクリックイベントを付与
		var radioLabel = document.getElementsByClassName('btn btn-default');
		for (var i = 0; i < radioLabel.length; i++) {
			radioLabel[i].addEventListener('click', function(event) {
				// 既定の動作をキャンセル(今回はinputにcheckedが入るのをキャンセル)
				event.preventDefault();

				// チェック済みの場合はチェックを外し、未チェックの場合はチェックを入れる
				var inputEl = this.querySelector('input');
				inputEl.checked = (inputEl.checked) ? false : true;
			});
		}
	});
</script>
</head>
<body style="font-size: xx-large">
	<div class="text-center">

		<h1 class="jumbotron">ログイン画面</h1>

		<span style="color: red; font-size: 70px"> <br> <c:out
				value="${requestScope.err}"></c:out></span> <br> <span
			style="font-size: 70px">ユーザーを選択して下さい</span>
		<form action="LoginServlet" method="post">
			<label style="font-size: 80px" class="btn btn-default"><input
				style="width: 50px; height: 50px; padding-buttom: 50px" type="radio"
				name="number" value="1" checked>チームさと</label> <br> <label
				style="font-size: 80px" class="btn btn-default"><input
				style="width: 50px; height: 50px; padding-buttom: 50px" type="radio"
				name="number" value="2">チームさわ</label> <br> <label
				style="font-size: 80px" class="btn btn-default"><input
				style="width: 50px; height: 50px;" type="radio" name="number"
				value="3">チームじい</label> <br> <label style="font-size: 80px"
				class="btn btn-default"><input
				style="width: 50px; height: 50px; padding-buttom: 50px" type="radio"
				name="number" value="4">チームけた</label> <br> <label
				style="font-size: 80px" class="btn btn-default"><input
				style="width: 50px; height: 50px; padding-buttom: 50px" type="radio"
				name="number" value="5">チームに-に</label> <br>


			<p>
				<input style="width: 300px; height: 100px; font-size: 50px"
					type="submit" value="送信">
			</p>
		</form>
	</div>
</body>
</html>