<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 생성</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">강의 생성</div>

<div class="login-container">
	<form method="post" action="<c:url value =""/>" class="login-form">
	
<input type="text" class="textbox" name="title" id="title" required="required" placeholder="강의 제목">
<br>
<input type="text" class="textbox" name="language" id="language" required="required" placeholder="강의 언어">
<br>
<input type="number" class="textbox" name="price" id="price" required="required" placeholder="강의 가격">
<br>
<input type="text" class="textbox" name="image_url" id="image_url" required="required" placeholder="강의 이미지 URL">
<br>
<textarea class="textarea" name="description" id="description" required="required" placeholder="강의 설명"></textarea>
<br>
	<input type="submit" class="login-submit" value="강의 생성">

	</form>
	</div>

</body>
</html>