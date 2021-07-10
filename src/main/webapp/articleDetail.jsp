<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta charset="UTF-8">
<title><c:out value="${article.title}"/></title>
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">커뮤니티 글 보기</div>

<div class="login-container">

	
<input type="text" class="textbox" name="title" id="title" value="<c:out value="${article.title}"/>" readonly="readonly">
<br>
<textarea class="textarea" name="body" id="body" readonly="readonly"><c:out value="${article.body}"/></textarea>
<br>

<input type="button" onclick="location.href='<c:url value="articleupdate?action=edit&id=${article.article_id}"/>'" class="login-submit" value="글 수정">
<br>
<input type="button" onclick="location.href='<c:url value="articleupdate?action=delete&id=${article.article_id}"/>'" class="login-submit" value="글 삭제">

	</div>

</body>
</html>