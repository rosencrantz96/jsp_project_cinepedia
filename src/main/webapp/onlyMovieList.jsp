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
	<%@ include file="topmenu.jsp"%>
	<section>
		<div class="biggerMain">
			<div class="smallerMain">
				<table class="movie_list">
					<thead>
						<tr>
							<th>번호</th>
							<th>영화 제목</th>
							<th>영화 감독</th>
							<th>영화 장르</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="m" items="${movieList}" varStatus="status">
							<tr>
								<td class="title">${m.m_no}</td>
								<td><a href="./registerdMovie?m_no=${m.m_no}">${m.m_title}</td>
								<td>${m.m_director}</td>
								<td>${m.m_genre}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<script>
		// jstl은 디코딩을 하지 않아도 됨 
		<c:if test="${param.error != null}">
			alert("${param.error}")
		</c:if>
		// getAttribute()로 할 때는 여기서 에러 메시지 호출 ? (get방식으로 할 때는 여기서 에러메시지 ?)
		<c:if test="${error != null}">
			alert("${error}")
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>