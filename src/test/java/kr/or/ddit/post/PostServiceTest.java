package kr.or.ddit.post;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.service.post.IPostService;
import kr.or.ddit.board.service.post.PostServiceImpl;

public class PostServiceTest {

	private IPostService postService;

	@Before
	public void setUp() throws Exception {

		postService = new PostServiceImpl();

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
		int res = postService.updatePost( post);

		/***Then***/
		assertEquals(1, res);

	}


	@Test
	public void getPost() {
		/***Given***/
		int postId = 17;

		/***When***/
		Post post = postService.getPost(postId);

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

		List<Post> res = postService.getPostPagingList(map);

		/***Then***/
		assertEquals(0, res.size());

	}
	@Test
	public void getPostTotalCnt() {
		/***Given***/
		int boardId = 9;

		/***When***/
		int res = postService.getPostTotalCnt(boardId);

		/***Then***/
		assertEquals(11, res);


	}

	@Test
	public void notUsePost() {
		/***Given***/
		int postId = 8;

		/***When***/
		int res = postService.notUsePost(postId);
		/***Then***/
		assertEquals(1, res);

	}


}
