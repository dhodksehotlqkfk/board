<%@page import="kr.or.ddit.board.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.board.IBoardService"%>
<%@page import="kr.or.ddit.board.service.board.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	IBoardService boardService = new BoardServiceImpl();
	List<Board> boardList = boardService.getAllBoard();
	request.setAttribute("boardList", boardList);
%>

<ul class="nav nav-sidebar">
	<li class="active"><a
		href="<%=request.getContextPath()%>/manageBoard">게시판 만들기</a></li>
	<c:forEach items="${boardList}" var="board">
		<c:if test="${board.boardUse == '사용'}">
			<li class="active">
			<a href="<%=request.getContextPath()%>/enterBoard?boardId=${board.boardId }&page=1&pagesize=10">${board.boardNm}</a>
			</li>
		</c:if>
	</c:forEach>
</ul>

