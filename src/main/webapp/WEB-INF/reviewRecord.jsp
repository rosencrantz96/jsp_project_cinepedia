<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<section>
		<div class="review_write_wrap">
			<form>
				<div class=review_write>
					<div class="title">
						<dl>
							<dt>리뷰 제목</dt>
							<dd>
								<input type="text" placeholder="제목을 입력해주세요." />
							</dd>
						</dl>
						<dl>
							<dt>내 평점</dt>
							<dd>
								<input type="number" placeholder="평점을 입력해주세요." />
							</dd>
						</dl>
					</div>
					<div class="cont">
						<textarea></textarea>
					</div>
				</div>
			</form>
			<div>
				<a>등록</a>
				<a>취소</a>
			</div>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>