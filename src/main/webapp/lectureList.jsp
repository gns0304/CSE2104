<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 강의 목록</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>



<div class="title">전체 강의 목록</div>


<div id="container">

<table class="my-lecture-list">
<tbody>
 <c:forEach items="${lectures}" var="lecture">
                <tr>
                    <td class="list-item list-pic"><img src="<c:out value="${lecture.image_url}" />"></td>
                    <td class="list-item list-title"><a class="list-title" href="<c:url value="/lecture?action=detail&id=${lecture.lecture_id}"/>"><c:out value="${lecture.title}" /> [<c:out value="${lecture.language}" />]</a></td>
                    <td class="list-item list-language"><c:out value="${lecture.price}" />원</td>
                </tr>
</c:forEach>
</tbody>
</table>
</div>



</body>
</html>