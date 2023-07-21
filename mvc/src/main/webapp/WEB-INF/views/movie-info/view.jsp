<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<td>${movieInfo.uiNum}</td>
	</tr>
	<tr>
		<th>타이틀</th>
		<td>${movieInfo.uiTitle}</td>
	</tr>
	<tr>
		<th>설명</th>
		<td>${movieInfo.uiDesc}</td>
	</tr>
	<tr>
		<th>장르</th>
		<td>${movieInfo.uiGenre}</td>
	</tr>
	<tr>
		<th>시간</th>
		<td>${movieInfo.uiCredat}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${movieInfo.uiCnt}</td>
	</tr>
</table>
</body>
</html>