package kr.or.ddit.board.model;

public class Post {

	private int postId;
	private String postTitle;
	private String postContent;
	private String postReg_dt;
	private String userId;
	private int boardId;
	private int parentPost;
	private String postUse;
	private int gn;
	private int level;




	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostReg_dt() {
		return postReg_dt;
	}
	public void setPostReg_dt(String postReg_dt) {
		this.postReg_dt = postReg_dt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getParentPost() {
		return parentPost;
	}
	public void setParentPost(int parentPost) {
		this.parentPost = parentPost;
	}
	public String getPostUse() {
		return postUse;
	}
	public void setPostUse(String postUse) {
		this.postUse = postUse;
	}
	public int getGn() {
		return gn;
	}
	public void setGn(int gn) {
		this.gn = gn;
	}



}
