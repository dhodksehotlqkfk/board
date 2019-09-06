package kr.or.ddit.board.web.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.service.board.BoardServiceImpl;
import kr.or.ddit.board.service.board.IBoardService;
import kr.or.ddit.board.service.post.IPostService;
import kr.or.ddit.board.service.post.PostServiceImpl;

@WebServlet("/enterBoard")
public class EnterBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPostService postService;
	private IBoardService boardService;


	private static final Logger logger = LoggerFactory.getLogger(EnterBoardController.class);

	@Override
	public void init() throws ServletException {
		postService = new PostServiceImpl();
		boardService = new BoardServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageStr = request.getParameter("page");
        String pagesizeStr = request.getParameter("pagesize");

        int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
        int pagesize = pagesizeStr == null ? 10 : Integer.parseInt(pagesizeStr);

        request.setAttribute("page", page);
        request.setAttribute("pagesize", pagesize);

        int boardId = Integer.parseInt(request.getParameter("boardId"));

        Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("page", page);
        paramter.put("pagesize", pagesize);
        paramter.put("boardId", boardId);

        List<Post> postList = postService.getPostPagingList(paramter);
        int totalCnt =  postService.getPostTotalCnt(boardId);


        int paginationSize = (int)Math.ceil((double)totalCnt / pagesize);

      request.setAttribute("postList", postList);
      request.setAttribute("paginationSize", paginationSize);

      Board board = boardService.getBoard(boardId);
      request.setAttribute("board", board);

      request.getRequestDispatcher("/post/postList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
