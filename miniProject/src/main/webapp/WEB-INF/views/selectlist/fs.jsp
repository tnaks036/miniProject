<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>먹고 싶은 음식 종류</title>
</head>
<body>
<form action = "./fs">
오늘 먹고 싶은 음식은?<br>
  <input type='radio' name='category' value='한식' checked/>한식
  <input type='radio' name='category' value='양식' />양식
  <input type='radio' name='category' value='일식' />일식
  <input type='radio' name='category' value='중식' />중식
<br>
<input type = 'submit' name='select' value= '너로 정했다'>
<input type = 'submit' name='select' value= '뒤로 돌아가기'>

</form>

</body>
</html>