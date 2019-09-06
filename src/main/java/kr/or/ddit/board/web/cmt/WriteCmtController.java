package kr.or.ddit.board.web.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Cmt;
import kr.or.ddit.board.service.cmt.CmtServiceImpl;
import kr.or.ddit.user.model.User;

@WebServlet("/writeCmt")
public class WriteCmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(WriteCmtController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		CmtServiceImpl cmtService = new CmtServiceImpl();
		User sessionUser =  (User) session.getAttribute("S_USERVO");

		int postId = Integer.parseInt(request.getParameter("postId"));
		String cmtContent = request.getParameter("cmtContent");
		String userId = sessionUser.getUserId();

		Cmt cmt = new Cmt();

		cmt.setPostId(postId);
		cmt.setCmtContent(cmtContent);
		cmt.setUserId(userId);

		logger.debug("cmt = {} ", cmt);

		int res = cmtService.insertCmt(cmt);

		logger.debug("res = {}" , res);

		response.sendRedirect(request.getContextPath() + "/post?postId="+ postId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
