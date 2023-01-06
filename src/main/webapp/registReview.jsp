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
				<form name="frm" method="post" action="registReview">
					<div class="reviewHeader">
						<dl>
							<dt>|영화 제목|</dt>
							<dd>${review.m_title}</dd>
						</dl>
					</div>
					<div class="reviewHeader">
						<dl>
							<dt>|리뷰 제목 입력|</dt>
							<dd>
								<input class="underlineRT">
							</dd>
						</dl>
						<dl>
							<dt>|내 평점 입력|</dt>
							<dd>
								<input class="underlineR">
							</dd>
						</dl>
					</div>
					<div class="reviewInfo">
						<textarea name="r_content" placeholder="내용 입력" class="cont"></textarea>
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