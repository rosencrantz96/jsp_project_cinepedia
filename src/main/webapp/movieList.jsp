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
						<li><a href="registerMovie">MOVIE</a></li>
						<li><a href="registerRei">REVIEW</a></li>
						<li><a href="movieList">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
					<table class="board_list">
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
							<tr>
								<!-- <td><input type="checkbox"></td> -->
								<td class="title"><a
									href="./view?board_no=${board.board_no}">${board.title}</a></td>
								<td>${board.user_id}</td>
								<td>${board.reg_date}</td>
								<td>${board.views}</td>
							</tr>
						</tbody>
					</table>
				</section>
				  <div class="btn">
					<a href="#">선택삭제</a>
				  </div>
			</div>
		</div>
	</div>
</body>
</html>