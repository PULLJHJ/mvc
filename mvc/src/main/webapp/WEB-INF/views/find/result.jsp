<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>시도한 횟수: <%=request.getAttribute("count") %></h3> <!-- FindServlet에서 생성한 set.attribute를 통해 여기서 받아옴  -->
<%=request.getAttribute("msg") %>
</body>
</html>