package kr.or.ddit.uploadFile;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.UploadFile;
import kr.or.ddit.board.repository.uploadFile.IUploadFileDao;
import kr.or.ddit.board.repository.uploadFile.UploadFileDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class UploadFileDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileDaoTest.class);

	private IUploadFileDao uploadFileDao;
	private SqlSession sqlSession;

   // 테스트에 공통적으로 필요한 자원을 생성 / 초기화
   @Before
   public void setup() {
      logger.debug("before");
      uploadFileDao = new UploadFileDaoImpl();
      sqlSession = MybatisUtil.getSession();
   }

   // 테스트에 공통적으로 사용한 자원을 해제
   @After
   public void tearDown() {
      logger.debug("after");
      sqlSession.close();
   }

//	UploadFile getPostUploadFile(SqlSession sqlSession, int uploadId);
//
//	int deletePostUploadFile(SqlSession sqlSession, int uploadId);

	@Test
	public void insertPostUploadFile() {
		/***Given***/
		String path="path";
		int postId = 7;
		String uploadNm = "파일명";
		UploadFile uploadFile = new UploadFile();

		/***When***/

		uploadFile.setFilePath(path);
		uploadFile.setPostId(postId);
		uploadFile.setUploadFileNm(uploadNm);

		logger.debug("uploadFIle = {}" , uploadFile);

		/***Then***/
		uploadFileDao.insertPostUploadFile(sqlSession, uploadFile);

	}

   @Test
   public void getPostUploadFileList() {

		/***Given***/
		int postId = 8;

		logger.debug("postId = {} ", postId);

		/***When***/
		List<UploadFile> fileList = uploadFileDao.getPostUploadFileList(sqlSession, postId);

		logger.debug("fileListSize = {}" , fileList.size());

		/***Then***/
		assertEquals(0, fileList.size());

   }

   @Test
   public void getPostUploadFile() {

		/***Given***/
		int uploadId = 8;


		/***When***/
		UploadFile file = uploadFileDao.getPostUploadFile(sqlSession, uploadId);


		/***Then***/
		assertEquals(8, file.getUploadId());

   }

//   @Test
//   public void deletePostUploadFile() {
//
//		/***Given***/
//		int uploadId = 56;
//
//
//		/***When***/
//		int res = uploadFileDao.deletePostUploadFile(sqlSession, uploadId);
//
//
//		/***Then***/
//		assertEquals(1,res);
//
//   }

}
