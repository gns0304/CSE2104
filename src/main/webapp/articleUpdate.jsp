<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%

request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta charset="UTF-8">
<title><c:out value="${article.title}"/></title>
</head>
<body>

<%@ include file="nav.jsp"%>

<div class="title">커뮤니티 글 수정</div>

<div class="login-container">

		<form method="post" action="<c:url value ="articleupdate"/>" class="login-form">
<input type="text" class="textbox" name="title" id="title" value="<c:out value="${article.title}"/>" >
<input type="hidden" class="textbox" name="article_id" id="article_id" value="<c:out value="${article.article_id}"/>" >
<br>
<textarea class="textarea" name="body" id="body"><c:out value="${article.body}"/></textarea>
<br>


<input type="submit" class="login-submit" value="글 수정">
<br>
<input type="button" onclick="location.href='<c:url value="articleupdate?action=delete&id=${article.article_id}"/>'" class="login-submit" value="글 삭제">
</form>
	</div>

</body>
</html>