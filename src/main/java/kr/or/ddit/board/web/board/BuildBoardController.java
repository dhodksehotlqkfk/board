package kr.or.ddit.board.web.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.control.Alert;
import kr.or.ddit.board.service.board.BoardServiceImpl;
import kr.or.ddit.board.service.board.IBoardService;

@WebServlet("/buildBoard")
public class BuildBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BuildBoardController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		logger.debug("boardNm = {}", request.getParameter("boardNm"));
		logger.debug("boardUse = {}", request.getParameter("boardUse"));

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("boardNm", request.getParameter("boardNm"));
		map.put("boardUse", request.getParameter("boardUse"));
		logger.debug("map = {}", map);

		BoardServiceImpl boardService = new BoardServiceImpl();
		int res = boardService.buildBoard(map);
		logger.debug("res = {}", res);

		request.getRequestDispatcher("/board/manageBoard.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
