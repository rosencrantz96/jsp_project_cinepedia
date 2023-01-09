<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
   <div class="wrap">
		<div class="subWrap">
			<div class="headerMenuWrap">
				<nav class="headerMenu">
					<ul class="headerMenuGroup">
						<li><a href="registMovie">MOVIE</a></li>
						<li><a href="registReview">REVIEW</a></li>
						<li><a href="List">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
				<c:forEach var="m" items="${movieInfo}" varStatus="status">
					<!-- <div class="moviePoster">
						<img>
					</div> -->
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
				</c:forEach>
				</section>
				<div class="btn">
					<a href="editMovieInfo?m_no=${m.m_no}">정보수정</a>
				</div>
				<div class="btn">
					<a href="movieReview">리뷰쓰기</a>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>