<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 커뮤니티 글 목록</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>
	<div id="info">
			<a class="info-link" href="<c:url value="/createarticle"/>">자유롭게 글을 쓸 수 있는 커뮤니티 게시판 입니다. 여기를 클릭하여 글을 작성할 수 있습니다.</a>
	</div>


<div class="title">전체 커뮤니티 글 목록</div>





 <c:forEach items="${articles}" var="article">

<div class="article-item">
<a class="list-title" href="<c:url value="/articledetail?id=${article.article_id}"/>"><c:out value="${article.title}" /></a>
</div>
 
</c:forEach>



</body>
</html>