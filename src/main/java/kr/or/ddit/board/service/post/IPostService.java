package kr.or.ddit.board.service.post;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Post;
import kr.or.ddit.common.model.Page;

public interface IPostService {

	/**
	 *
	 * Method : insertPost 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param post
	 * @return Method 설명 : 게시글 쓰기
	 */
	public int insertPost(Post post);

	/**
	 *
	 * Method : updatePost 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @return Method 설명 : 게시글 수정
	 */

	public int updatePost(Post post);


	/**
	 *
	 * Method : getUser 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param userId
	 * @return Method 설명 : 게시글 상세조회
	 */
	Post getPost(int postId);

	/**
	 *
	 * Method : getUserPagingList 작성자 : PC-02 변경이력 :
	 *
	 * @param sqlSession
	 * @param page
	 * @return Method 설명 : 해당게시판 페이징 리스트 조회
	 */
	 List<Post> getPostPagingList(Map<String, Object> map);


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
	int notUsePost(int postId);

	int getPostTotalCnt(int boardId);



}
