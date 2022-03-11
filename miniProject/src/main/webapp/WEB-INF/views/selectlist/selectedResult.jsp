<%@page import="miniPjoject.dao.miniProjectlist"%>
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
<%
List<miniProjectlist> list = (List<miniProjectlist>)request.getAttribute("list");
%>
<%= list %>

<p><a href="./index.html" >뒤로 돌아가기</a>

</body>
</html>