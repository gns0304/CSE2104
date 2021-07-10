<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    <nav class="navbar navbar-expand  navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="title" href="<c:url value="/"/>">프로그래밍 이러닝 시스템</a>
		</div>
		<div>
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${empty sessionName}">
						<li class="nav-item"><a class="nav-link" href="<c:url value="login"/>">로그인 </a></li>
						<li class="nav-item"><a class="nav-link" href='<c:url value="signup"/>'>회원 가입</a></li>
					</c:when>
					<c:when test="${not empty isAdmin}">
						<li style="margin-right:10px;">${sessionName}님</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/admin?page=main"/>">관리자페이지</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/articlelist"/>">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/editinfo"/>">정보수정</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="logout"/>">로그아웃</a></li>
						</c:when>
					<c:otherwise>
						<li style="margin-right:10px;">${sessionName}님</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/articlelist"/>">커뮤니티</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/editinfo"/>">정보수정</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="logout"/>">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>