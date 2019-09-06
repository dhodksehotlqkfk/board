<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="../../favicon.ico">
<title>게시판 만들기</title>
<%@ include file="/commonJsp/basicLib.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="/commonJsp/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header">
					<h1 class="blog-title">게시판 만들기</h1>
					<p class="lead blog-description">게시판을 생성할 수 있습니다.</p>
				</div>
				<div class="row">

					<div class="col-sm-8 blog-main">
						<form id="frm" class="form-horizontal" role="form"
							action="${cp }/buildBoard" method="get">
							<label>게시판 이름</label>&nbsp;&nbsp; <input type="text"
								name="boardNm">&nbsp;&nbsp; <select name="boardUse">
								<option value="사용">사용</option>
								<option value="미사용">미사용</option>
							</select>&nbsp;&nbsp;
							<button type="submit">생성</button>
						</form>

						<div class="blog-header">
							<h1 class="blog-title">게시판 수정하기</h1>
							<p class="lead blog-description">게시판의 사용여부를 수정할 수 있습니다.</p>
						</div>
						<c:forEach items="${boardList}" var="board">
							<form id="frm" class="form-horizontal" role="form"
								action="${cp }/modifyBoard" method="post">
								<label>게시판 이름</label>&nbsp;&nbsp; <label>${board.boardNm}</label>&nbsp;&nbsp;
								<select name="boardUse">
									<c:choose>
										<c:when test="${board.boardUse == '미사용'}">
											<option value="사용">사용</option>
											<option value="미사용" selected>미사용</option>
										</c:when>
										<c:otherwise>
											<option value="사용" selected>사용</option>
											<option value="미사용">미사용</option>
										</c:otherwise>
									</c:choose>
								</select>&nbsp;&nbsp; <input type="hidden" name="boardId"
									value="${board.boardId}">
								<button type="submit">수정</button>
							</form>
						</c:forEach>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
