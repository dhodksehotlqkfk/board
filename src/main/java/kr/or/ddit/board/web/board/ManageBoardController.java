package kr.or.ddit.board.web.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.board.BoardServiceImpl;
import kr.or.ddit.board.service.board.IBoardService;

@WebServlet("/manageBoard")
public class ManageBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IBoardService boardService = new BoardServiceImpl();

		List<Board> boardList = boardService.getAllBoard();

		request.setAttribute("boardList", boardList);

		request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
