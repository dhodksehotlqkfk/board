package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;

public interface IUserService {

	/**
    *
    * Method : getUser
    * 작성자 : PC-02
    * 변경이력 :
    * @param sqlSession
    * @param userId
    * @return
    * Method 설명 : 사용자 상세조회
    */
   User getUser(String userId);

}
