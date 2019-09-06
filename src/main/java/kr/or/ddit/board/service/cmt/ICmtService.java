package kr.or.ddit.board.service.cmt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Cmt;

public interface ICmtService {

	int insertCmt(Cmt cmt);

	int deleteCmt(int cmtId);

	List<Cmt> getPostCmtList(int postId);


}
