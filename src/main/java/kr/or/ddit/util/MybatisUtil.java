package kr.or.ddit.util;



import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory factory;

	static {
		String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
		try {

			InputStream inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
		}
	}
	public static SqlSession getSession() {
		return factory.openSession();
	}

}
