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
			<td>${movieInfo.miNum}</td>
		</tr>
		<tr>
			<th>타이틀</th>
			<td>${movieInfo.miTitle}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${movieInfo.miDesc}</td>
		</tr>
		<tr>
			<th>장르</th>
			<td>${movieInfo.miGenre}</td>
		</tr>
		<tr>
			<th>시간</th>
			<td>${movieInfo.miCredat}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${movieInfo.miCnt}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button
					onclick="location.href='/movie-info/update?miNum=${movie.miNum}'"
					type="button">수정</button>
				<button>삭제</button>
			</th>
		</tr>
	</table>
</body>
</html>