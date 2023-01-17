<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
				<div>
					<form name="frm" method="post"
						action="updateMovieInfo?m_no=${m.m_no}">
						<div class="registM">
							<dl>
								<dt>번호:</dt>
								<dd>
									<input type="text" value="${m.m_no}" name="m_no" readonly>
								</dd>
							</dl>
							<dl>
								<dt>영화 제목:</dt>
								<dd>
									<input type="text" value="${m.m_title}" name="m_title">
								</dd>
							</dl>
							<dl>
								<dt>배우:</dt>
								<dd>
									<input type="text" value="${m.m_actor}" name="m_actor">
								</dd>
							</dl>
							<dl>
								<dt>감독:</dt>
								<dd>
									<input type="text" value="${m.m_director}" name="m_director">
								</dd>
							</dl>
							<dl>
								<dt>국가:</dt>
								<dd>
									<input type="text" value="${m.m_nation}" name="m_nation">
								</dd>
							</dl>
							<dl>
								<dt>등급:</dt>
								<dd>
									<input type="text" value="${m.m_grade}" name="m_grade">
								</dd>
							</dl>
							<dl>
								<dt>장르:</dt>
								<dd>
									<input type="text" value="${m.m_genre}" name="m_genre">
								</dd>
							</dl>
							<dl>
								<dt>개봉 일자:</dt>
								<dd>
									<input type="text" value="${m.m_date}" name="m_date">
								</dd>
							</dl>
						</div>
						<div class="btn">
							<a onclick="chkForm(); return false" class="on">수정하기</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
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