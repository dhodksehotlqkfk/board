package kr.or.ddit.board.web.post;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.service.post.PostServiceImpl;

@WebServlet("/replyPost")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class ReplyPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postId = Integer.parseInt(request.getParameter("postId"));

		PostServiceImpl postService = new PostServiceImpl();
		Post post = postService.getPost(postId);

		request.setAttribute("post", post);

		request.getRequestDispatcher("/post/replyPost.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
