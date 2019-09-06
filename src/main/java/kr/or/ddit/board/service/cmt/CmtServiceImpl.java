package kr.or.ddit.board.service.cmt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.model.Cmt;
import kr.or.ddit.board.repository.cmt.CmtDaoImpl;
import kr.or.ddit.board.repository.cmt.ICmtDao;
import kr.or.ddit.util.MybatisUtil;

public class CmtServiceImpl implements ICmtService {

	private ICmtDao cmtDao;

	public CmtServiceImpl() {
		cmtDao = new CmtDaoImpl();
	}

	@Override
	public int insertCmt(Cmt cmt) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = cmtDao.insertCmt(sqlSession, cmt);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int deleteCmt(int cmtId) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = cmtDao.deleteCmt(sqlSession, cmtId);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<Cmt> getPostCmtList(int postId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Cmt> list = cmtDao.getPostCmtList(sqlSession, postId);
		sqlSession.close();
		return list;
	}

}
