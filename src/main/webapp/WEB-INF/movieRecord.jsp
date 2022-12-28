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
		<form action="">
			<div>
				<table>
					<tr>
						<th>영화 제목:</th>
						<td></td>
					</tr>
					<tr>
						<th>주연:</th>
						<td></td>
					</tr>
					<tr>
						<th>감독:</th>
						<td></td>
					</tr>
					<tr>
						<th>국가:</th>
						<td></td>
					</tr>
					<tr>
						<th>영화 등급:</th>
						<td></td>
					</tr>
					<tr>
						<th>장르:</th>
						<td></td>
					</tr>
					<tr>
						<th>개봉 일자</th>
						<td></td>
					</tr>
				</table>
				<div class="btn">
					<a href="movieInfo.jsp">등록하기</a>
				</div>
				<div>
					<a href="#" class="bt first">&lt;&lt;</a> 
					<a href="#" class="bt prev">&lt;</a> 
					<a href="#" class="num on">1</a> 
					<a href="#" class="num">2</a> <a href="#" class="num">3</a> 
					<a href="#" class="num">4</a> 
					<a href="#" class="num">5</a>
					<a href="#" class="bt next">&gt;</a> 
					<a href="#" class="bt last">&gt;&gt;</a>
				</div>
			</div>
		</form>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>