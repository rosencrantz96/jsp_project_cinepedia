<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body class="wrap">
	<div class="biggerMainReview">
        <form name="frm" method="post" action="updateReviewInfo?m_no=${r.m_no}">
            <div class="smallerMainReview">
                <div>
                    <div class="reviewHeader">
                        <dl>
							<dt>|영화 제목|</dt>
							<dd>
								<input type="text" value="${r.m_no}" name="r.title" readonly
									class="underlineRT">
							</dd>
						</dl>
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
								<input type="text" value="${r.r_grade}" name="r.grade"
									class="underlineR">
							</dd>
						</dl>
                    </div>
                    <div class="reviewInfoRegist">
                        <textarea name="r_content" placeholder="내용 입력" class="cont">${r.r_content}</textarea>
                    </div>
                </div>
            </div>
            <!-- <div class="rbtn"> -->
                <div class="RbtnEdit">
                    <a onclick="chkReviewForm(); return false;" class="on" style="cursor: pointer">등록</a>
                </div>
                <div class="RbtnEdit">
                    <a href="home">취소</a>
                </div>
            <!-- </div> -->
        </form>
    </div>
	<script>
		<c:if test="${param.error != null}">
			alert("${param.error}")
		</c:if>
		<c:if test="${error != null}">
			alert("${error}")
		</c:if>
	</script>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>