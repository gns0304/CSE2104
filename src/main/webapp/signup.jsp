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
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">회원가입</div>

<div class="login-container">
	<form method="post" action="<c:url value ="signup"/>" class="login-form">
	
<input type="text" class="textbox" name="id" id="id" required="required" placeholder="아이디">
<br>
<input type="password" class="textbox" name="password" id="password" required="required" placeholder="비밀번호">
<br>
<input type="text" class="textbox" name="name" id="name" required="required" placeholder="이름">
<br>
<input type="text" class="textbox" name="email" id="email" required="required" placeholder="이메일">
<br>
	<input type="submit" class="login-submit" value="회원가입">

	</form>
	</div>

</body>
</html>