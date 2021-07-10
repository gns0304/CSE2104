<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>

<body>
<%@ include file="nav.jsp"%>



<div class="title">회원정보 수정</div>

<div class="login-container">
	<form method="post" action="<c:url value ="editinfo"/>" class="login-form">
	
<input type="text" class="textbox" name="id" id="id" required="required" value="<c:out value="${user.id}"/>" readonly="readonly">
<br>
<input type="password" class="textbox" name="password" id="password" required="required" value="<c:out value="${user.password}"/>">
<br>
<input type="text" class="textbox" name="name" id="name" required="required" value="<c:out value="${user.name}"/>">
<br>
<input type="text" class="textbox" name="email" id="email" required="required" value="<c:out value="${user.email}"/>">
<br>
	<input type="submit" class="login-submit" value="회원정보 수정">
	<br>
	<input type="button" onclick="location.href='<c:url value="/editinfo?action=delete"/>'" class="login-submit" value="회원 탈퇴">

	</form>
	</div>


</body>
</html>