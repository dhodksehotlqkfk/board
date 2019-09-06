package kr.or.ddit.board.repository.uploadFile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.UploadFile;

public class UploadFileDaoImpl implements IUploadFileDao {

	@Override
	public UploadFile getPostUploadFile(SqlSession sqlSession, int postId) {
		return sqlSession.selectOne("uploadFile.getPostUploadFile", postId);
	}

	@Override
	public int deletePostUploadFile(SqlSession sqlSession, int uploadId) {
		return sqlSession.delete("uploadFile.deletePostUploadFile", uploadId);
	}


	@Override
	public List<UploadFile> getPostUploadFileList(SqlSession sqlSession, int postId) {
		return sqlSession.selectList("uploadFile.getPostUploadFileList",postId);
	}

	@Override
	public int insertPostUploadFile(SqlSession sqlSession, UploadFile uploadFile) {
		return sqlSession.insert("uploadFile.insertPostUploadFile", uploadFile);
	}

}
