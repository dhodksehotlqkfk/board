package kr.or.ddit.board.repository.uploadFile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.UploadFile;

public interface IUploadFileDao {

	List<UploadFile> getPostUploadFileList(SqlSession sqlSession, int postId);

	UploadFile getPostUploadFile(SqlSession sqlSession, int uploadId);

	int deletePostUploadFile(SqlSession sqlSession, int uploadId);

	int insertPostUploadFile(SqlSession sqlSession, UploadFile uploadFile);


}
