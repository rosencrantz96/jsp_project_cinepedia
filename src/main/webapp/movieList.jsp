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
					<table class="movie_list">
						<thead>
							<tr>
								<!-- <th><input type="checkbox"></th> -->
								<th>번호</th>
								<th>영화 제목</th>
								<th>리뷰 제목</th>
								<th>내 평점</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="movie" items="${movieList}" varStatus="status">
								<tr>
									<!-- <td><input type="checkbox"></td> -->
									<td class="title">${m.m_no}</td>
									<td>${m.m_title}</td>
									<td>${m.r_title}</td>
									<td>${m.r_grade}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</section>
				<div class="btn">
					<a href="home">홈으로</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>