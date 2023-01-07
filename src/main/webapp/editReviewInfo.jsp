<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="reWrap">
		<div class="reSubWrap">
			<section>
				<form name="frm" method="post" action="updateReviewInfo?m_no=${r.m_no}">
					<div class="reviewHeader">
						<dl>
							<dt>|영화 제목|</dt>
							<dd>${r.m_no}</dd>
						</dl>
					</div>
					<div class="reviewHeader">
						<dl>
							<dt>|리뷰 제목 입력|</dt>
							<dd>
								<input type="text" value="${r.r_title}" name="r.title"
									class="underlineRT">
							</dd>
						</dl>
						<dl>
							<dt>|내 평점 입력|</dt>
							<dd>
								<input type="number" value="${r.r_grade}" name="r.grade"
									class="underlineR">
							</dd>
						</dl>
					</div>
					<div class="reviewInfo">
						<textarea name="r_content" placeholder="내용 입력" class="cont">${r.r_content}</textarea>
					</div>
				</form>
			</section>
			<div class="rbtn">
				<div class="Rbtn">
					<a href="registerdReview">등록</a>
				</div>
				<div class="Rbtn">
					<a href="home">취소</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>