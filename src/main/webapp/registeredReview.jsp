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
	<div class="reWrap">
		<div class="reSubWrap">
			<section>
				<form name="frm" method="post" action="regist">
					<div class="reviewHeader">
						<dl>
							<dt>|영화 제목|</dt>
							<dd>${review.m_title}</dd>
						</dl>
					</div>
					<div class="reviewHeader">
						<dl>
							<dt>|리뷰 제목|</dt>
							<dd>${review.r_title}</dd>
						</dl>
						<dl>
							<dt>|관람 일자|</dt>
							<dd>${review.m_title}</dd>
						</dl>
						<dl>
							<dt>|내 평점|</dt>
							<dd>${review.r_grade}</dd>
						</dl>
					</div>
					<div class="reviewInfo">${review.r_content}</div>
				</form>
			</section>
			<div class="rbtn">
				<div class="Rbtn">
					<a href="#">목록</a>
				</div>
				<div class="Rbtn">
					<a href="#">수정</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>