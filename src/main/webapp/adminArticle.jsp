<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>커뮤니티 글 관리</title>
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">커뮤니티 글 관리</div>


<div id="container">



<table class="my-lecture-list">
<tbody>
 <c:forEach items="${articles}" var="article">
                <tr>

                    <td class="list-item list-title"><a class="list-title" href="<c:url value="/articledetail?id=${article.article_id}"/>"><c:out value="${article.title}" /></a></td>
                    <td class="list-item list-language"><a class="list-title" href="<c:url value="articleupdate?action=delete&id=${article.article_id}"/>">게시글 삭제</a></td>
                </tr>
</c:forEach>
</tbody>
</table>

<input type="button" onclick="location.href='<c:url value="admin?page=main"/>'" class="list-button" value="관리자 페이지로 돌아가기">



</div>
</body>
</html>