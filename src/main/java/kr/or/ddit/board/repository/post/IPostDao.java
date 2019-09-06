package kr.or.ddit.board.repository.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IPostDao {

	/**
	 *
	 * Method : insertPost 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param post
	 * @return Method 설명 : 게시글 쓰기
	 */
	public int insertPost(SqlSession sqlSession, Post post);

	/**
	 *
	 * Method : updatePost 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @return Method 설명 : 게시글 수정
	 */

	public int updatePost(SqlSession sqlSession, Post post);

	/**
	 *
	 * Method : getUser 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param userId
	 * @return Method 설명 : 게시글 상세조회
	 */
	Post getPost(SqlSession sqlSession, int postId);

	/**
	 *
	 * Method : getUserPagingList 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param page
	 * @return Method 설명 : 해당게시판 페이징 리스트 조회
	 */
	List<Post> getPostPagingList(SqlSession sqlSession, Map<String, Object> map);

	/**
	 *
	 * Method : getUserTotalCnt 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @return Method 설명 : 해당 게시판의 게시글 건수 조회
	 */
	int getPostTotalCnt(SqlSession sqlSession, int boardId);


	/**
	 *
	 * Method : notUsePost
	 * 작성자 : PC-02
	 * 변경이력 :
	 * @param sqlSession
	 * @param postId
	 * @return
	 * Method 설명 : 글 삭제는 아니고 그냥 사용못하게 해버리기
	 */
	int notUsePost(SqlSession sqlSession, int postId);

}
