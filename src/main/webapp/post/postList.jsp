<%@page import="kr.or.ddit.board.repository.board.BoardDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/commonJsp/basicLib.jsp"%>
<script>
	// 문서 로딩이 완료되고 나서
	$(document).ready(function() {
		// 사용자 정보 클릭시 이벤트 핸들러
		$(".postTr").on('click', function() {
			var dataValue = $(this).data("postid");
			$('#postId').val(dataValue);
			$('#frm').submit();
		});
		$
	})
</script>
</head>

<!-- header -->
<%@ include file="/commonJsp/header.jsp"%>
<body>
	<form id="frm" action="${cp }/post" method="get">
		<input type="hidden" id="postId" name="postId" />
	</form>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@ include file="/commonJsp/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${board.boardNm}</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>

                        <c:forEach items="${postList}" var="post">
                              <c:choose>
                                 <c:when test="${post.postUse == '미사용' }">
                           <tr data-postId="${post.postId}">
                              <td>${post.postId}<input type="hidden" value="${post.postId}"/></td>
                                    <td>
                                    <c:forEach begin="0" end="${(post.level-1)*2 }">
                                    </c:forEach>
                                    <c:if test="${post.parentPost != 0 }">
                                    	<span class="glyphicon glyphicon-arrow-right"></span>
                                    </c:if>
                                    &nbsp;&nbsp;&nbsp;삭제된 게시글입니다.</td>
                                 </c:when>
                                 <c:otherwise>
                                 <tr class="postTr" data-postId="${post.postId}">
                              <td>${post.postId}<input type="hidden" value="${post.postId}"/></td>
                                    <td>
                                    <c:forEach begin="0" end="${(post.level-1)*2 }">
                                       &nbsp;&nbsp;
                                    </c:forEach>
                                    <c:if test="${post.parentPost != 0 }">
                                    	<span class="glyphicon glyphicon-arrow-right"></span>
                                    </c:if>
                                    ${post.postTitle}</td>
                                 </c:otherwise>
                              </c:choose>
                              <td>${post.userId}</td>
                              <td>${post.postReg_dt}</td>
                           </tr>
                        </c:forEach>
							</table>
						</div>

						<a href="${cp }/writePost?boardId=${board.boardId}" class="btn btn-default pull-right">글 쓰기</a>

						<div class="text-center">
							<ul class="pagination">
								<%-- 이전 페이지 가기 : 지금 있는 페이지에서 한페이지 전으로
                             단 1페이지인 경우는 li 태그에 class="disabled"를 추가하고 이동 경로는 차단
                         --%>
                        <c:choose>
                           <c:when test="${page == 1 }">
                              <li class="disabled">
                                 <a href="#" aria-label="Previous">
                                   <span aria-hidden="true">&laquo;</span>
                                 </a>
                               </li>
                           </c:when>
                           <c:otherwise>
                              <li>
                                   <a href="${cp }/enterBoard?page=1&boardId=${board.boardId}" aria-label="Previous">
                                   <span aria-hidden="true">&laquo;</span>
                                 </a>
                               </li>
                           </c:otherwise>
                        </c:choose>
                        <c:choose>
                           <c:when test="${page == 1 }">
                              <li class="disabled">
                                 <a href="#" aria-label="Previous">
                                   <span aria-hidden="true">&laquo;</span>
                                 </a>
                               </li>
                           </c:when>
                           <c:otherwise>
                              <li>
                                   <a href="${cp }/enterBoard?page=${page-1 }&boardId=${board.boardId}" aria-label="Previous">
                                   <span aria-hidden="true">&laquo;</span>
                                 </a>
                               </li>
                           </c:otherwise>
                        </c:choose>

                        <c:forEach begin="1" end="${paginationSize}" var="pageSize">
                           <%-- 방법1 --%>
                           <c:choose>
                              <c:when test="${pageSize == page}">
                                 <li   class="active"><span>${pageSize }</span></li>
                              </c:when>
                              <c:otherwise>
                                 <li><a href="${cp }/enterBoard?page=${pageSize }&boardId=${board.boardId}">${pageSize }</a></li>
                              </c:otherwise>
                           </c:choose>

                        </c:forEach>

                        <c:choose>
                           <c:when test="${page == paginationSize }">
                               <li class="disabled">
                                 <a href="#" aria-label="Next">
                                   <span aria-hidden="true">&raquo;</span>
                                 </a>
                               </li>
                           </c:when>
                           <c:otherwise>
                              <li>
                                    <a href="${cp }/enterBoard?page=${page+1 }&boardId=${board.boardId}" aria-label="Next">
                                   <span aria-hidden="true">&raquo;</span>
                                 </a>
                               </li>
                           </c:otherwise>
                        </c:choose>
                        <c:choose>
                           <c:when test="${page == paginationSize }">
                               <li class="disabled">
                                 <a href="#" aria-label="Next">
                                   <span aria-hidden="true">&raquo;</span>
                                 </a>
                               </li>
                           </c:when>
                           <c:otherwise>
                              <li>
                                    <a href="${cp }/enterBoard?page=${paginationSize }&boardId=${board.boardId}" aria-label="Next">
                                   <span aria-hidden="true">&raquo;</span>
                                 </a>
                               </li>
                           </c:otherwise>
                        </c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>