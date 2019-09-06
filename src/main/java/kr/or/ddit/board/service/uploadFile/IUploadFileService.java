package kr.or.ddit.board.service.uploadFile;

import java.util.List;

import kr.or.ddit.board.model.UploadFile;

public interface IUploadFileService {

	List<UploadFile> getPostUploadFileList(int postId);

	UploadFile getPostUploadFile(int uploadId);

	int deletePostUploadFile(int uploadId);

	int insertPostUploadFile(UploadFile uploadFile);
}
