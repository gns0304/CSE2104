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
	<div id="info">
			구매된 강좌 입니다. 수강 시작 일자 이후 학습 자료와 강좌 내용이 오픈됩니다. 
	</div>
          
                
<div class="title">${lecture.title} 수강 페이지</div>


<div id="container">

<div class="item">
<div class="lecture-image">
<img src="<c:out value="${lecture.image_url}" />">
</div>

<p>주 사용 언어 : <b><c:out value="${lecture.language}" /></b></p>
<p>강좌 상세 설명 : <c:out value="${lecture.description}" /></p>
 
</div>

</div>                
                
                
</body>
</html>