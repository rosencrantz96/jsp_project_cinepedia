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
						<li><a href="#">MOVIE</a></li>
						<li><a href="#">REVIEW</a></li>
						<li><a href="#">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
					<form name="" method="post" action="regist">
						<div class="registM">
							<table>
								<tr>
									<th>영화 제목 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>주 연 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>감 독 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>국 가 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>영화 등급 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>장 르 :</th>
									<td><input type="text" class="underline" /></td>
								</tr>
								<tr>
									<th>개봉 일자 :</th>
									<td><input type="date" class="underline" /></td>
								</tr>
							</table>
						</div>
					</form>
				</section>
				<div class="btn">
					<a href="#">등록하기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>