<%@page import="miniPjoject.dao.miniProjectlist"%>
<%@page import="java.util.List"%>
<%@page import="miniPjoject.dao.miniProjectDAOimply"%>
<%@page import="miniPjoject.dao.miniProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!-- trimDirectiveWhitespaces="true"를 추가안해주면 상단공백존재함  -->
<%
String category = (String)request.getParameter("category");
miniProjectDAO dao = new miniProjectDAOimply();
List<miniProjectlist> list = (List<miniProjectlist>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<!-- 스타일 추가하기 --!>
</style>
<title>Insert title here</title>
</head>
<body>
	<form action= "./rs">
	<input type="hidden" name="category" value="<%= category %>">
	<table border = "1">
		<!-- 맨위 컬럼명들 -->
		<tr>
			<th>가게이름</th>
			<th>여기서 먹어야지</th>
			
	<!-- 반복문 돌릴것들 -->
	<%
	for (miniProjectlist item: list){
	%>
		<tr>
			<td><%= item.getRestaurant() %></td>
			<td>				
				<input type='radio'  name = 'restaurant' value = "<%= item.getRestaurant() %>" />
			</td>
		</tr>
	<%
	}
	%>
	<input type = 'submit' name='select' value= 'next'>
	<input type = 'submit' name='select' value= '뒤로 돌아가기'>
	</form>
	</table>
<!-- form에 저장된 radio를 submit -->

</body>
</html>