<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>영화 수정</h3>
<form action="/movie-info/update" method="post">
<input type="hidden" name="miNum" value="${movieInfo.miNum }"><br>
<input type="text" name="miTitle" value="${movieInfo.miTitle}"><br>
<input type="text" name="miDesc" value="${movieInfo.miDesc}"><br>
<input type="text" name="miGenre" value="${movieInfo.miGenre }"><br>
<input type="text" name="miCnt" value="${movieInfo.miCnt}"><br>
<button>수정</button>
</form>
</body>
</html>