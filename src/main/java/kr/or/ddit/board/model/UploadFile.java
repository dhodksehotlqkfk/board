package kr.or.ddit.board.model;

public class UploadFile {

	private int uploadId;
	private String uploadFileNm; //파일명
	private String filePath; //파일 실제 경로
	private int postId;


	public UploadFile() {}

	public UploadFile(String filename, String path, int postId) {
		this.uploadFileNm = filename;
		this.filePath = path;
		this.postId = postId;

	}
	public int getUploadId() {
		return uploadId;
	}
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}
	public String getUploadFileNm() {
		return uploadFileNm;
	}
	public void setUploadFileNm(String uploadFileNm) {
		this.uploadFileNm = uploadFileNm;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	@Override
	public String toString() {
		return "UploadFile [uploadId=" + uploadId + ", uploadFileNm=" + uploadFileNm + ", filePath=" + filePath
				+ ", postId=" + postId + "]";
	}





}
