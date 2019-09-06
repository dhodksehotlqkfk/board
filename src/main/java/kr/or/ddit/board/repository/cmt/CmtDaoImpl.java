package kr.or.ddit.board.repository.cmt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Cmt;

public class CmtDaoImpl implements ICmtDao {

	@Override
	public int insertCmt(SqlSession sqlSession, Cmt cmt) {
		return sqlSession.insert("cmt.insertCmt", cmt);
	}

	@Override
	public int deleteCmt(SqlSession sqlSession, int cmtId) {
		return sqlSession.delete("cmt.deleteCmt", cmtId);
	}

	@Override
	public List<Cmt> getPostCmtList(SqlSession sqlSession, int postId) {
		return sqlSession.selectList("cmt.getPostCmtList", postId);
	}


}
