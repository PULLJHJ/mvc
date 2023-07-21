<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
<h3>뷰페이지</h3>

<table border="">
    <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
    </tr>
	<c:forEach items="${userInfoList}" var="userInfo">
	<tr>
	<td>${userInfo.uiNum}</td>
	<td>${userInfo.uiName}</td>
	<td>${userInfo.uiId}</td>
	<td>${userInfo.uiPwd}</td>
	</tr>
	
	</c:forEach>
</table>
</body>
</html>