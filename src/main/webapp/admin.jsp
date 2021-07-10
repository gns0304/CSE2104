<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">관리자 페이지</div>

<input type="button" onclick="location.href='<c:url value="admin?page=lecture"/>'" class="list-button" value="강의 관리">
<input type="button" onclick="location.href='<c:url value="admin?page=article"/>'" class="list-button" value="커뮤니티 글 관리">





</body>
</html>