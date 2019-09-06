package kr.or.ddit.board.web.uploadFile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.uploadFile.UploadFileServiceImpl;

@WebServlet("/deleteFile")
public class DeleteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DeleteFileController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.debug("uploadFile = {} ", request.getParameter("uploadFile"));
		logger.debug("postId = {} ", request.getParameter("postId"));


		int uploadId = Integer.parseInt(request.getParameter("uploadFile"));
		int postId = Integer.parseInt(request.getParameter("postId"));

		UploadFileServiceImpl uploadFileService = new UploadFileServiceImpl();

		uploadFileService.deletePostUploadFile(uploadId);

		response.sendRedirect(request.getContextPath() + "/post?postId="+ postId);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
