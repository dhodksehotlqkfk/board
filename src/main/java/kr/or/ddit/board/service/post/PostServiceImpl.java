package kr.or.ddit.board.service.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.board.repository.post.IPostDao;
import kr.or.ddit.board.repository.post.PostDaoImpl;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class PostServiceImpl implements IPostService {


	private IPostDao postDao;

	public PostServiceImpl() {
		postDao = new PostDaoImpl();
	}

	@Override
	public int insertPost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();

		postDao.insertPost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return post.getPostId();

	}

	@Override
	public int updatePost(Post post) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = postDao.updatePost(sqlSession, post);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Post getPost(int postId) {
	      SqlSession sqlSession = MybatisUtil.getSession();
	      Post post = postDao.getPost(sqlSession, postId);
	      sqlSession.close();

	      return post;
	}

	@Override
	public List<Post> getPostPagingList(Map<String, Object> map) {
		  SqlSession sqlSession = MybatisUtil.getSession();

	      List<Post> postList = postDao.getPostPagingList(sqlSession, map);
	      sqlSession.close();

	      return postList;

	}



	@Override
	public int notUsePost(int postId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.notUsePost(sqlSession, postId);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int getPostTotalCnt(int boardId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = postDao.getPostTotalCnt(sqlSession, boardId);
		sqlSession.close();
		return res;
	}



}
