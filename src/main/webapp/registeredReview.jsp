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
	<div class="reWrap">
		<div class="reSubWrap">
			<section>
					<div class="reviewHeader">
						<dl>
							<dt>|번호|</dt>
							<dd>${r.m_no}</dd>
						</dl>
						<dl>
							<dt>|리뷰 제목|</dt>
							<dd>${r.r_title}</dd>
						</dl>
						<dl>
							<dt>|내 평점|</dt>
							<dd>${r.r_grade}</dd>
						</dl>
					</div>
					<div class="reviewInfo">${r.r_content}</div>
			</section>
			<div class="rbtn">
				<div class="Rbtn">
					<a onclick="chkReviewDelete(${r.m_no}); return false;">삭제</a>
				</div>
				<div class="Rbtn">
					<a href="editReviewInfo?m_no=${r.m_no}">수정</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>