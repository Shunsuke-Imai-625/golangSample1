<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>解答入力画面</title>
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

		<h1 class="jumbotron">解答入力画面</h1>

		<div style="color: red;font-size: 70px" class="alert">
			<c:out value="${requestScope.errorMessage}"></c:out>
		</div>

		<div style="font-size: 70px">
			<c:out value="${requestScope.message}"></c:out>
		</div>

		<form action="AnswerServlet" method="post">

			<span style="font-size: 70px">選択問題</span>

			<div>
				<label style="font-size: 100px" class="btn btn-default"><input
					style="width: 50px; height: 50px; padding-buttom: 50px"
					type="radio" id="answer1" name="selected" value="A">A </label> <label
					style="font-size: 100px" class="btn btn-default"><input
					style="width: 50px; height: 50px; margin-left: 50px; padding-buttom: 20px"
					type="radio" id="answer2" name="selected" value="B">B </label><label
					style="font-size: 100px" class="btn btn-default"><input
					style="width: 50px; height: 50px; margin-left: 50px; padding-buttom: 20px"
					type="radio" id="answer3" name="selected" value="C">C </label><label
					style="font-size: 100px" class="btn btn-default"><input
					style="width: 50px; height: 50px; margin-left: 50px; padding-buttom: 20px"
					type="radio" id="answer4" name="selected" value="D">D</label>
			</div>
			<br> <span style="font-size: 70px">記述問題</span>
			<div>

				<input style="height: 100px" type="text" size="40" name="writed">

			</div>
			<br> <br> <br>
			<div>
				<input style="width: 300px; height: 120px; font-size: 70px"
					type="submit" value="解答">
			</div>

		</form>



	</div>

</body>
</html>