<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 6.오후 4:54:18</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<form method="post" enctype="multipart/form-data" >
		<input type="file" name="files" >
		<button>ㅁㅁ</button>
	</form>
	
	<script>
	$("form").submit(function() {
		event.preventDefault();
		var formData = new FormData();
		var files = $(":file")[0].files;
		for(var i in files) {
			formData.append("upload", files[i]);
		}
		$.ajax({
			url : '/image/uploadAjax',
			processData : false,
			contentType : false,
			data : formData,
			method : "post",
			success : function(data) {
				console.log(data);
			}
		});
	})
	</script>
</body>
</html>