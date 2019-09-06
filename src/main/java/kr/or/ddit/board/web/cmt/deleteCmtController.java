package kr.or.ddit.board.web.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.cmt.CmtServiceImpl;

@WebServlet("/deleteCmt")
public class deleteCmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		CmtServiceImpl cmtService = new CmtServiceImpl();

		int cmtId = Integer.parseInt(request.getParameter("cmtId"));
		int postId = Integer.parseInt(request.getParameter("postId"));

		cmtService.deleteCmt(cmtId);

		response.sendRedirect(request.getContextPath() + "/post?postId="+ postId);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
