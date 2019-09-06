package kr.or.ddit.board.service.uploadFile;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.UploadFile;
import kr.or.ddit.board.repository.uploadFile.IUploadFileDao;
import kr.or.ddit.board.repository.uploadFile.UploadFileDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class UploadFileServiceImpl implements IUploadFileService {

	private IUploadFileDao uploadFileDao;

	public UploadFileServiceImpl() {
		uploadFileDao = new UploadFileDaoImpl();
	}

	@Override
	public List<UploadFile> getPostUploadFileList(int postId) {

		SqlSession sqlSession = MybatisUtil.getSession();

		List<UploadFile> uploadFileList = uploadFileDao.getPostUploadFileList(sqlSession, postId);
		sqlSession.close();
		return uploadFileList;
	}

	@Override
	public UploadFile getPostUploadFile(int uploadId) {
		SqlSession sqlSession = MybatisUtil.getSession();

		UploadFile uploadFile = uploadFileDao.getPostUploadFile(sqlSession, uploadId);
		sqlSession.close();
		return uploadFile;
	}

	@Override
	public int deletePostUploadFile(int uploadId) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = uploadFileDao.deletePostUploadFile(sqlSession, uploadId);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int insertPostUploadFile(UploadFile uploadFile) {
		SqlSession sqlSession = MybatisUtil.getSession();

		int res = uploadFileDao.insertPostUploadFile(sqlSession, uploadFile);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

}
