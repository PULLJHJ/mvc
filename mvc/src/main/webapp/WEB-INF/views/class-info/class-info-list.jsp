<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>난 강의 리스트</h3>
<%List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("classInfoList"); 
%>
<table border = "">
<tr>
<th>번호</th>
<th>번호</th>
<th>번호</th>
</tr>
<%
for(Map<String,String> map : list){
%>
<tr>
<td><%=map.get("ciNum") %></td>
<td><a href="/class-info/view"><%=map.get("ciNum")%><%=map.get("ciName") %></td>
<td><%=map.get("ciDesc") %></td>
</tr>
<%
}
%>
</table>
</body>
</html>