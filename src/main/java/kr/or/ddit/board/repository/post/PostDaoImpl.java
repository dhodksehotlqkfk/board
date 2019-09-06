package kr.or.ddit.board.repository.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.common.model.Page;

public class PostDaoImpl implements IPostDao {

	@Override
	public int insertPost(SqlSession sqlSession, Post post) {
		return sqlSession.insert("post.insertPost", post);
	}

	@Override
	public int updatePost(SqlSession sqlSession, Post post) {
		return  sqlSession.update("post.updatePost", post);
	}


	@Override
	public Post getPost(SqlSession sqlSession, int postId) {
		return sqlSession.selectOne("post.getPost",postId);
	}

	@Override
	public List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.selectList("post.getPostPagingList",map);
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int boardId) {
		return  sqlSession.selectOne("post.getPostTotalCnt", boardId);
	}


	@Override
	public int notUsePost(SqlSession sqlSession, int postId) {
		return sqlSession.update("post.notUsePost", postId);
	}



}
