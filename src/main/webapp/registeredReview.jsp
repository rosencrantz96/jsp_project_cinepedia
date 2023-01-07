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
							<dt>|번호|</dt>
							<dd>${r.m_no}</dd>
						</dl>
					</div>
					<div class="reviewHeader">
						<dl>
							<dt>|리뷰 제목|</dt>
							<dd>${r.r_title}</dd>
						</dl>
						<dl>
							<dt>|관람 일자|</dt>
							<dd>${r.m_title}</dd>
						</dl>
						<dl>
							<dt>|내 평점|</dt>
							<dd>${r.r_grade}</dd>
						</dl>
					</div>
					<div class="reviewInfo">${r.r_content}</div>
				</form>
			</section>
			<div class="rbtn">
				<div class="Rbtn">
					<a href="delete">삭제</a>
				</div>
				<div class="Rbtn">
					<a href="editReviewInfo?m_no=${m.m_no}">수정</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>