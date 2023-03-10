<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<%@ include file="topmenu.jsp"%>
	<section>
		<div class="biggerMain">
			<div class="smallerMain">

				<div class="movieInfo">
					<dl>
						<dt>번호:</dt>
						<dd>${m.m_no}</dd>
					</dl>
					<dl>
						<dt>영화 제목:</dt>
						<dd>${m.m_title}</dd>
					</dl>
					<dl>
						<dt>배우:</dt>
						<dd>${m.m_actor}</dd>
					</dl>
					<dl>
						<dt>감독:</dt>
						<dd>${m.m_director}</dd>
					</dl>
					<dl>
						<dt>국가:</dt>
						<dd>${m.m_nation}</dd>
					</dl>
					<dl>
						<dt>등급:</dt>
						<dd>${m.m_grade}</dd>
					</dl>
					<dl>
						<dt>장르:</dt>
						<dd>${m.m_genre}</dd>
					</dl>
					<dl>
						<dt>개봉 일자:</dt>
						<dd>${m.m_date}</dd>
					</dl>
				</div>

				<div class="btn">
					<a href="delete?m_no=${m.m_no}">삭제</a>
				</div>
				<div class="btn">
					<a href="editMovieInfo?m_no=${m.m_no}" style="cursor: pointer">수정</a>
				</div>
			</div>
		</div>
		</div>
	</section>
	<script>
		<c:if test="${param.error != null}">
			alert("${param.error}")
		</c:if>
		<c:if test="${error != null}">
			alert("${error}")
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>