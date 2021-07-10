<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

<%@ include file="nav.jsp"%>

<c:if test="${empty sessionName}">
	<div id="alert">
			로그인을 해주시기 바랍니다
	</div>
</c:if>

<c:if test="${not empty sessionName and empty lectures}">
	<div id="info">
			현재 구매한 강의가 없습니다. 전체 강의 목록을 통하여 강의를 구입하여 보세요.
	</div>
</c:if>


<div class="title">구매한 강의목록</div>


<div id="container">

<table class="my-lecture-list">
<tbody>
 <c:forEach items="${lectures}" var="lecture">
                <tr>
                    <td class="list-item list-pic"><img src="<c:out value="${lecture.image_url}" />"></td>
                    <td class="list-item list-title"><a class="list-title" href="<c:url value="mylecture?id=${lecture.lecture_id}"/>"><c:out value="${lecture.title}" /></a></td>
                    <td class="list-item list-language"><c:out value="${lecture.language}" /></td>
                </tr>
</c:forEach>
</tbody>
</table>
<input type="button" onclick="location.href='<c:url value="lecturelist"/>'" class="list-button" value="전체 강의 목록">
</div>



</body>
