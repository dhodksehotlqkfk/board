<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon -->
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basic</title>

<%@ include file="/commonJsp/basicLib.jsp"%>
</head>
<!--header  -->
<%@include file="/commonJsp/header.jsp"%>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<!--left  -->
				<%@ include file="/commonJsp/left.jsp"%>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form" action=""
					method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목 :</label>
						<div class="col-sm-6">
							<label class="control-label">${post.postTitle }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글 내용 :</label>
						<div class="col-sm-10">
							<label class="control-label">${post.postContent }</label>

						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부 파일 :</label>
						<div class="col-sm-10">
							<c:forEach items="${uploadFileList}" var="uploadFile">
								<label class="control-label">${uploadFile.uploadFileNm}
								</label><br>
							</c:forEach>
						</div>
						<input type="hidden" name="boardId" value="${post.boardId }">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<a href="${cp }/modifyPost?postId=${post.postId}" class="btn btn-default">글 수정</a>
								<a href="${cp }/deletePost?postId=${post.postId}" class="btn btn-default">글 삭제</a>
								<a href="${cp }/replyPost?postId=${post.postId}" class="btn btn-default">답글 쓰기</a>
							</div>
						</div>
				</form>
						<div class="container">
							<label for="content">comment</label>
							<form name="commentInsert" role="form" action="${cp }/writeCmt" method="get">
								<div class="input-group">
									<input type="hidden" name="postId" value="${post.postId}" />
									<input type="text" class="form-control" id="content" name="cmtContent" placeholder="내용을 입력하세요.">
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit" name="commentInsertBtn">등록</button>
									</span>
								</div>
							</form>
						</div>
						<div class="container">
							<div class="commentList">
							<br>
							<c:forEach items="${cmtList}" var="cmt">
								<c:choose>
									<c:when test = "${cmt.cmtUse == '사용' }">
							<form name="commentDelete" role="form" action="${cp }/deleteCmt" method="get">
 			    				<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">
                				<div class="commentInfo">댓글번호 : ${cmt.cmtId }  / 작성자 :  ${cmt.userId }
                				<input type="hidden" name="cmtId"   value="${cmt.cmtId}"/>
                				<input type="hidden" name="postId"   value="${post.postId}"/>
                					<c:if test="${cmt.userId == S_USERVO.userId }">
                						<button type="submit">삭제</button>
                					</c:if>
               					<div class="commentContent'+value.cno+'"> <p>내용 : ${cmt.cmtContent }</p>
                					</div></div></div>
                			</form>
									</c:when>
									<c:otherwise>
 			    				<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">
                				<div class="commentInfo">댓글번호 : ${cmt.cmtId }  / 작성자 :  ${cmt.userId }
               					<div class="commentContent"> <p>삭제된 댓글입니다.</p>
                					</div></div></div>
									</c:otherwise>
								</c:choose>
                			</c:forEach>
							</div>
						</div>
			</div>
		</div>
	</div>
</body>
</html>