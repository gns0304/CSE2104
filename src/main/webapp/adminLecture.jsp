<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 관리</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">강의 관리</div>


<div id="container">



<table class="my-lecture-list">
<tbody>
 <c:forEach items="${lectures}" var="lecture">
                <tr>
                    <td class="list-item list-pic"><img src="<c:out value="${lecture.image_url}" />"></td>
                    <td class="list-item list-title"><a class="list-title" href="<c:url value="mylecture?id=${lecture.lecture_id}"/>"><c:out value="${lecture.title}" /></a></td>
                    <td class="list-item list-language"><c:out value="${lecture.language}" /></td>
                    <td class="list-item list-language"><a class="list-title" href="<c:url value="lecture?action=delete&id=${lecture.lecture_id}"/>">강의 삭제</a></td>
                </tr>
</c:forEach>
</tbody>
</table>
<input type="button" onclick="location.href='<c:url value="createlecture"/>'" class="list-button" value="강의 추가">
<input type="button" onclick="location.href='<c:url value="admin?page=main"/>'" class="list-button" value="관리자 페이지로 돌아가기">

</div>
</body>
</html>