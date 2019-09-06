package kr.or.ddit.board;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.board.BoardDaoImpl;
import kr.or.ddit.board.repository.board.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);


	private IBoardDao boardDao;
	private SqlSession sqlSession;

	   // 테스트에 공통적으로 필요한 자원을 생성 / 초기화
	   @Before
	   public void setup() {
	      logger.debug("before");
	      boardDao = new BoardDaoImpl();
	      sqlSession = MybatisUtil.getSession();
	   }

	   // 테스트에 공통적으로 사용한 자원을 해제
	   @After
	   public void tearDown() {
	      logger.debug("after");
	      sqlSession.close();
	   }


//	@Test
//	public void buildBoard(){
//		/***Given***/
//		Map<String, String> map = new HashMap<String, String>();
//
//		/***When***/
//		map.put("boardNm", "JunitTest");
//		map.put("boardUse", "사용");
//		int res = boardDao.buildBoard(sqlSession, map);
//
//		/***Then***/
//		assertEquals(1, res);
//
//	}

	@Test
	public void getAllBoard() {
		/***Given***/

		/***When***/
		List<Board> list = boardDao.getAllBoard(sqlSession);

		/***Then***/
		assertEquals(6, list.size());
	}

	@Test
	public void updateBoard() {
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();

		/***When***/
		map.put("boardId", "32");
		map.put("boardUse", "미사용");
		int res = boardDao.updateBoard(sqlSession, map);

		/***Then***/
		assertEquals(1, res);
	}

	@Test
	public void getBoard() {
		/***Given***/

		/***When***/
		Board res = boardDao.getBoard(sqlSession, 25);

		/***Then***/
		assertEquals("test", res.getBoardNm());

	}


}
