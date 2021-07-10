<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

<%@ include file="nav.jsp"%>


<c:if test="${not empty alert}">
	<div id="alert">
			${alert}
	</div>
</c:if>

<div class="title">관리자 로그인</div>

<div class="login-container">
	<form method="post" action="<c:url value ="adminlogin"/>" class="login-form">
	
	<input type="text" class="textbox" name="id" id="id" required="required" placeholder="아이디">
	<br>
	<input type="password" class="textbox" name="password" id="password" required="required" placeholder="비밀번호">
	<br>

	<input type="submit" class="login-submit" value="로그인">
	<br>
	<input type="button" onclick="location.href='<c:url value="/login"/>'" class="login-submit" value="일반 사용자 로그인">

	</form>
	</div>
	
</body>
</html>