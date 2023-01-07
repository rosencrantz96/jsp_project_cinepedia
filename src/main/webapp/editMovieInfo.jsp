<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<li><a href="list">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
					<form name="frm" method="post"
						action="updateMovieInfo?m_no=${m.m_no}">
						<div class="registM">
							<table>
								<tr>
									<th>영화 제목 :</th>
									<td><input type="text" value="${m.m_no}" name="m_title"
										class="underline" /></td>
								</tr>
								<tr>
									<th>주 연 :</th>
									<td><input type="text" value="${m.m_actor}" name="m_actor"
										class="underline" /></td>
								</tr>
								<tr>
									<th>감 독 :</th>
									<td><input type="text" value="${m.m_director}"
										name="m_director" class="underline" /></td>
								</tr>
								<tr>
									<th>국 가 :</th>
									<td><input type="text" value="${m.m_nation}"
										name="m_nation" class="underline" /></td>
								</tr>
								<tr>
									<th>영화 등급 :</th>
									<td><input type="text" value="${m.m_grade}" name="m_grade"
										class="underline" /></td>
								</tr>
								<tr>
									<th>장 르 :</th>
									<td><input type="text" value="${m.m_genre}" name="m_genre"
										class="underline" /></td>
								</tr>
								<tr>
									<th>개봉 일자 :</th>
									<td><input type="date" value="${m.m_date}" name="m_date"
										class="underline" /></td>
								</tr>
							</table>
						</div>
					</form>
				</section>
				<div class="btn">
					<a href="registerdMovie">등록하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>