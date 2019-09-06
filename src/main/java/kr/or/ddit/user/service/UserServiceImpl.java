package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class UserServiceImpl implements IUserService{

	private IUserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

   @Override
   public User getUser(String userId) {

      SqlSession sqlSession = MybatisUtil.getSession();
      User user = userDao.getUser(sqlSession, userId);
      sqlSession.close();

      return user;
   }
}
