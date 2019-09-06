package kr.or.ddit.board.web.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.service.board.BoardServiceImpl;
import kr.or.ddit.board.service.post.PostServiceImpl;
import kr.or.ddit.user.model.User;

@WebServlet("/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ModifyBoardController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		BoardServiceImpl boardService = new BoardServiceImpl();

		String boardUse = request.getParameter("boardUse");
		int boardId = Integer.parseInt(request.getParameter("boardId"));

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("boardUse", boardUse);
		map.put("boardId", boardId);

		boardService.updateBoard(map);

		doGet(request, response);
	}

}
