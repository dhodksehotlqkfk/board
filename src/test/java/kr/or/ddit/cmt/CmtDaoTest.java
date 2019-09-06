package kr.or.ddit.cmt;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Cmt;
import kr.or.ddit.board.repository.cmt.CmtDaoImpl;
import kr.or.ddit.board.repository.cmt.ICmtDao;
import kr.or.ddit.util.MybatisUtil;

public class CmtDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(CmtDaoTest.class);

	private ICmtDao cmtDao;
	private SqlSession sqlSession;


	   @Before
	   public void setup() {
	      logger.debug("before");
	      cmtDao = new CmtDaoImpl();
	      sqlSession = MybatisUtil.getSession();
	   }

	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("after");
	      sqlSession.close();
	   }

	@Test
	public void insertCmt() {

		/***Given***/
		Cmt cmt = new Cmt();
		String cmtContent = "asd";
		int postId = 2;
		String userId = "brown";
		cmt.setCmtContent(cmtContent);
		cmt.setPostId(postId);
		cmt.setUserId(userId);

		/***When***/
		int res = cmtDao.insertCmt(sqlSession, cmt);

		/***Then***/
		assertEquals(1, res);


	}

	@Test
	public void deleteCmt() {

		/***Given***/
		int cmtId = 4;

		/***When***/
		int res = cmtDao.deleteCmt(sqlSession, cmtId);

		/***Then***/
		assertEquals(1, res);
	}

	@Test
	public void getPostCmtList() {
		/***Given***/
		int postId = 31;


		/***When***/
		List<Cmt> res = cmtDao.getPostCmtList(sqlSession, postId);

		/***Then***/
		assertEquals(1, res.size());

	}


}
