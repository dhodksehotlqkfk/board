package kr.or.ddit.board.service.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.repository.board.BoardDaoImpl;
import kr.or.ddit.board.repository.board.IBoardDao;
import kr.or.ddit.util.MybatisUtil;

public class BoardServiceImpl implements IBoardService {


	private IBoardDao boardDao;

	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}

	@Override
	public int buildBoard(Map<String, String> map) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = boardDao.buildBoard(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updateBoard(Map<String, Object> map) {
		SqlSession sqlSession = MybatisUtil.getSession();
		int res = boardDao.updateBoard(sqlSession, map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<Board> getAllBoard() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Board> list = boardDao.getAllBoard(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public Board getBoard(int boardId) {

		SqlSession sqlSession = MybatisUtil.getSession();
		Board board = boardDao.getBoard(sqlSession, boardId);
		sqlSession.close();
		return board;
	}
}
