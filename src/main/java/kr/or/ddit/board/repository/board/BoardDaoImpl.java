package kr.or.ddit.board.repository.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public class BoardDaoImpl implements IBoardDao {

	@Override
	public int buildBoard(SqlSession sqlSession, Map<String, String> map) {
		return sqlSession.insert("board.buildBoard", map);
	}

	@Override
	public int updateBoard(SqlSession sqlSession, Map<String, Object> map) {
		return sqlSession.update("board.updateBoard", map);
	}

	@Override
	public List<Board> getAllBoard(SqlSession sqlSession) {
		return sqlSession.selectList("board.getAllBoard");
	}

	@Override
	public Board getBoard(SqlSession sqlSession, int boardId) {
		return sqlSession.selectOne("board.getBoard", boardId);
	}

}
