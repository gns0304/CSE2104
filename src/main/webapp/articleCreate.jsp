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
<title>커뮤니티 글 생성</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">커뮤니티 글 생성</div>

<div class="login-container">
	<form method="post" action="<c:url value ="/createarticle"/>" class="login-form">
	
<input type="text" class="textbox" name="title" id="title" required="required" placeholder="글 제목">
<br>
<textarea class="textarea" name="body" id="body" required="required" placeholder="글 내용"></textarea>
<br>
	<input type="submit" class="login-submit" value="등록">

	</form>
	</div>

</body>
</html>