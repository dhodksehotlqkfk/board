package kr.or.ddit.board.repository.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardDao {

	/**
	 *
	 * Method : getAllBoard
	 * 작성자 : PC-02
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 현재 있는 모든 게시판을 가져온다.
	 */
	public List<Board> getAllBoard(SqlSession sqlSession);

	/**
	 *
	 * Method : buildBoard
	 * 작성자 : PC-02
	 * 변경이력 :
	 * @param sqlSession
	 * @param boardNm
	 * @return
	 * Method 설명 : 게시판 생성하기
	 */
	int buildBoard(SqlSession sqlSession, Map<String, String> map);

	/**
	 *
	 * Method : updateBoard
	 * 작성자 : PC-02
	 * 변경이력 :
	 * @param sqlSession
	 * @param map
	 * @return
	 * Method 설명 : 게시판의 사용여부를 바꾼다.
	 */
	int updateBoard(SqlSession sqlSession, Map<String, Object> map);

	/**
	 *
	 * Method : getBoard
	 * 작성자 : PC-02
	 * 변경이력 :
	 * @param sqlSEssion
	 * @param boardId
	 * @return
	 * Method 설명 : 하나의 게시판 객체를 가져옴
	 */
	Board getBoard(SqlSession sqlSession, int boardId);
}
