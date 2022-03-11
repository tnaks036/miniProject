<%@page import="miniPjoject.dao.miniProjectlist"%>
<%@page import="java.util.List"%>
<%@page import="miniPjoject.dao.miniProjectDAOimply"%>
<%@page import="miniPjoject.dao.miniProjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!-- trimDirectiveWhitespaces="true"를 추가안해주면 상단공백존재함  -->
<%
List<miniProjectlist> list = (List<miniProjectlist>)request.getAttribute("list");
String category = (String)request.getParameter("category");
String restaurant = (String)request.getParameter("restaurant");
%>
<!-- list 이걸 보이게 하고 싶으면 < + % list%+> --> 
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
	<form action= "./ms">
	<input type="hidden" name="category" value="<%= category %>">
	<input type="hidden" name="restaurant" value="<%= restaurant %>">
	<table border = "1">
		<!-- 맨위 컬럼명들 -->
		<tr>
			<th>메뉴명</th>
			<th>이거 먹어야지</th>


			
	<!-- 반복문 돌릴것들 -->
	<%
	for (miniProjectlist item: list){
	%>
		<tr>
			<td><%= item.getMenu() %></td>
			<td>				
				<input type='radio'  name = 'menu' value = "<%= item.getMenu() %>"/>
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