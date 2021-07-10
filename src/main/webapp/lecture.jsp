<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${lecture.title}</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<%@ include file="nav.jsp"%>

<div class="title">${lecture.title} 구매 페이지</div>


<div id="container">

<div class="item">
<div class="lecture-image">
<img src="<c:out value="${lecture.image_url}" />">
</div>

<p>주 사용 언어 : <b><c:out value="${lecture.language}" /></b></p>
<p>강좌 가격 : <b><c:out value="${lecture.price}" /></b>원</p>
<p>강좌 상세 설명 : <c:out value="${lecture.description}" /></p>
 
<input type="button" onclick="location.href='<c:url value="/lecture?action=payment&id=${lecture.lecture_id}"/>'" class="list-button" value="강좌 구매 하기">
</div>

</div>

                
</body>
</html>