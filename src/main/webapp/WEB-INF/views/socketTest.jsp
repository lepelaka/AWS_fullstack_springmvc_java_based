<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 3. 27.오후 5:57:53</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<h1>socket</h1>
	
	<textarea rows="10" cols="50" readonly="readonly" id="result"></textarea><br>
	<input id="input">
	<button id="btn">전송</button>
</body>
<script>
	let ws = new WebSocket("ws:localhost/controller/socket")
	
	ws.onopen = function() {
		console.log("opened");
	}
	ws.onmessage = function(e) {
		console.log(e.data);
		$("#result").val($("#result").val() + "\n" + e.data)
	}
	ws.onopen = function() {
		console.log("closed");
	}
	$("#btn").click(function() {
		ws.send($(this).prev().val());
	});
</script>
</html>