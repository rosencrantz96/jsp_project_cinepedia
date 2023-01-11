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
	<div class="reWrap">
		<div class="reSubWrap">
			<section>
				<form name="frm" method="post" action="insertReivew">
					<div class="reviewHeader">
						<table>
							<tr>
								<th>|번호|</th>
								<td><input type="text" name="m_no" value="${r.m_no}"
									class="underlineRT" readonly></td>
							</tr>
							<tr>
								<th>|리뷰 제목 입력|</th>
								<td><input type="text" name="r_title" class="underlineRT"></td>
							</tr>
							<tr>
								<th>|내 평점 입력|</th>
								<td><input type="text" name="r_grade" class="underlineRT"></td>
							</tr>
						</table>
					</div>
					<div class="reviewInfo">
						<textarea name="r_content" placeholder="내용 입력" class="cont"></textarea>
					</div>
					<div class="rbtn">
						<div class="Rbtn">
							<a onclick="chkReviewForm(); return false;"
								style="cursor: pointer" class="on">등록</a>
						</div>
						<div class="Rbtn">
							<a href="home">취소</a>
						</div>
					</div>
				</form>
			</section>
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