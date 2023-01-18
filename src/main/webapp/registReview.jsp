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
<body class="wrap">
	<div class="biggerMainReview">
		<form name="frm" method="post" action="insertReivew">
			<div class="smallerMainReview">
				<div>
					<div class="reviewHeader">
						<table>
							<tr>
								<th>|번호|</th>
								<td><input type="text" name="m_no" value="${r.m_no}"
									class="underlineRT" readonly></td>
							</tr>
							<tr>
								<th>|리뷰 제목 입력|</th>
								<td><input type="text" name="r_title" class="underlineRT"
									placeholder="영화를 등록하기 전에는 리스트에 조회가 되지 않습니다."></td>
							</tr>
							<tr>
								<th>|내 평점 입력|</th>
								<td><input type="text" name="r_grade" class="underlineRT"
									placeholder="1에서 5 사이의 정수로 입력해주세요."></td>
							</tr>
						</table>
					</div>
					<div class="reviewInfoRegist">
						<textarea name="r_content" placeholder="내용 입력" class="cont"></textarea>
					</div>
				</div>
				<!-- <div class="rbtn"> -->
				<div class="Rbtn">
					<a href="home">홈으로</a>
				</div>
				<div class="Rbtn">
					<a onclick="chkReviewForm(); return false;" style="cursor: pointer"
							class="on">등록</a>
				</div>
				<!-- </div> -->
			</div>
		</form>
	</div>
	<script>
		<c:if test="${error != null}">
			alert("${error}")
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>