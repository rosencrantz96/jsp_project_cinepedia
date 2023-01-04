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
						<li><a href="movieList">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
					<div class="moviePoster">
						<img>
					</div>
					<div class="movieInfo">
						<dl>
							<dt>영화 제목:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>배우:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>감독:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>국가:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>등급:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>장르:</dt>
							<dd>내용</dd>
						</dl>
						<dl>
							<dt>개봉 일자:</dt>
							<dd>내용</dd>
						</dl>
					</div>
				</section>
				<div class="btn">
					<a href="editMovieInfo">정보수정</a>
				</div>
				<div class="btn">
					<a href="registReview">리뷰쓰기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>