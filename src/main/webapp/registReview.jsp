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
				<form name="frm" method="post" action="insertReivew">
					<div class="reviewHeader">
						<dl>
							<dt>|번호|</dt>
							<dd><input type="text" name="m_no" value="${m.m_no}" class="underlineRT" readonly></dd>
						</dl>
						<dl>
							<dt>|리뷰 제목 입력|</dt>
							<dd>
								<input type="text" name="r.title" class="underlineRT">
							</dd>
						</dl>
						<dl>
							<dt>|내 평점 입력|</dt>
							<dd>
								<input type="text" name="r.grade" class="underlineR">
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