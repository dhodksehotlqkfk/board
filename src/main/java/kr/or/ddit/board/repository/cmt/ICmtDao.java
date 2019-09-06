package kr.or.ddit.board.repository.cmt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Cmt;

public interface ICmtDao {


	int insertCmt(SqlSession sqlSession, Cmt cmt);

	int deleteCmt(SqlSession sqlSession, int cmtId);

	List<Cmt> getPostCmtList(SqlSession sqlSession, int postId);

}
