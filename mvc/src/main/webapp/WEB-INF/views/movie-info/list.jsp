<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>영화 리스트</h1>
<table border="">
<tr>
<th>번호</th>
<th>타이틀</th>
<th>설명</th>
<th>장르</th>
<th>시간</th>
<th>조회수</th>
</tr>
<c:forEach items="${movieInfoList}" var="movieInfo">
<tr>
<td>${movieInfo.miNum}</td>
<td><a href="/movie-info/view?miNum=${movieInfo.miNum}">${userInfo.uiTitle}</a></td>
<td>${movieInfo.miDesc}</td>
<td>${movieInfo.miGenre}</td>
<td>${movieInfo.miCredat}</td>
<td>${movieInfo.miCnt}</td>
</tr>
</c:forEach>
</table>
</body>
</html>