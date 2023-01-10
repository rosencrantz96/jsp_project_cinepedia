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
						<li><a href="list">LIST/EDIT</a></li>
						<li><a href="home">HOME</a></li>
					</ul>
				</nav>
			</div>
			<div class="main">
				<section>
					<form name="frm" method="post" action="insertMovie">
						<div class="registM">
							<table class="registMovieTable">
								<tr>
									<th>번호 :</th>
									<td><input type="text" value="${m.m_no}" class="underline"
										name="m_no" readonly /></td>
								</tr>
								<tr>
									<th>영화 제목 :</th>
									<td><input type="text" name="m_title" class="underline" /></td>
								</tr>
								<tr>
									<th>주 연 :</th>
									<td><input type="text" name="m_actor" class="underline" /></td>
								</tr>
								<tr>
									<th>감 독 :</th>
									<td><input type="text" name="m_director" class="underline" /></td>
								</tr>
								<tr>
									<th>국 가 :</th>
									<td><input type="text" name="m_nation" class="underline" /></td>
								</tr>
								<tr>
									<th>영화 등급 :</th>
									<td><input type="text" name="m_grade" class="underline" /></td>
								</tr>
								<tr>
									<th>장 르 :</th>
									<td><input type="text" name="m_genre" class="underline" /></td>
								</tr>
								<tr>
									<th>개봉 일자 :</th>
									<td><input type="date" name="m_date" class="underline" /></td>
								</tr>
							</table>
						</div>
						<div class="btn">
							<a onclick="chkForm(); return false;" style="cursor: pointer"
								class="on">등록하기</a>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
	<script>
		<c:if test="${error != null}">
			alert("${error}")
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>