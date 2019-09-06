package kr.or.ddit.board.web.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Cmt;
import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.model.UploadFile;
import kr.or.ddit.board.service.cmt.CmtServiceImpl;
import kr.or.ddit.board.service.post.PostServiceImpl;
import kr.or.ddit.board.service.uploadFile.UploadFileServiceImpl;

@WebServlet("/post")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		logger.debug("postId : {}", request.getParameter("postId"));
		int postId = Integer.parseInt(request.getParameter("postId"));


		PostServiceImpl postService = new PostServiceImpl();
		CmtServiceImpl cmtService = new CmtServiceImpl();
		UploadFileServiceImpl uploadService = new UploadFileServiceImpl();
		Post post = postService.getPost(postId);
		List<Cmt> cmtList = cmtService.getPostCmtList(postId);
		List<UploadFile> uploadFileList = uploadService.getPostUploadFileList(postId);
		request.setAttribute("uploadFileList", uploadFileList);
		request.setAttribute("cmtList", cmtList);
		request.setAttribute("post", post);

		request.getRequestDispatcher("/post/post.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
