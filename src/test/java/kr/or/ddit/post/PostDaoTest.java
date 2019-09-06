package kr.or.ddit.post;

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

import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.repository.post.IPostDao;
import kr.or.ddit.board.repository.post.PostDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class PostDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);

	private IPostDao postDao;
	private SqlSession sqlSession;

   // 테스트에 공통적으로 필요한 자원을 생성 / 초기화
   @Before
   public void setup() {
      logger.debug("before");
      postDao = new PostDaoImpl();
      sqlSession = MybatisUtil.getSession();
   }

   // 테스트에 공통적으로 사용한 자원을 해제
   @After
   public void tearDown() {
      logger.debug("after");
      sqlSession.close();
   }

//	@Test
//	public void insertPost() {
//		/***Given***/
//		Post post = new Post();
//
//		/***When***/
//		post.setBoardId(3);
//		post.setPostContent("내용입니다");
//		post.setPostTitle("제목입니다");
//		post.setUserId("brown");
//
//		int res = postDao.insertPost(sqlSession, post);
//
//		/***Then***/
//		assertEquals(1, res);
//
//	}
//
	@Test
	public void updatePost() {
		/***Given***/
		int postId = 7;
		String postContent = "asd";
		String postTitle = "asd";

		/***When***/
		Post post = new Post();
		post.setPostContent(postContent);
		post.setPostTitle(postTitle);
		post.setPostId(postId);
		int res = postDao.updatePost(sqlSession, post);

		/***Then***/
		assertEquals(1, res);

	}


	@Test
	public void getPost() {
		/***Given***/
		int postId = 17;

		/***When***/
		Post post = postDao.getPost(sqlSession, postId);

		/***Then***/
		assertEquals(17, post.getPostId());

	}

	@Test
	public void getPostPagingList() {
		/***Given***/
		Map<String, Object> map = new HashMap<String, Object>();
		int postId = 1;

		/***When***/
		map.put("page", 1);
		map.put("pagesize", 10);
		map.put("boardId", 1);

		List<Post> res = postDao.getPostPagingList(sqlSession, map);

		/***Then***/
		assertEquals(0, res.size());

	}
	@Test
	public void getPostTotalCnt() {
		/***Given***/
		int boardId = 9;

		/***When***/
		int res = postDao.getPostTotalCnt(sqlSession, boardId);

		/***Then***/
		assertEquals(11, res);


	}

	@Test
	public void notUsePost() {
		/***Given***/
		int postId = 8;

		/***When***/
		int res = postDao.notUsePost(sqlSession, postId);
		/***Then***/
		assertEquals(1, res);

	}




}
