package kr.or.ddit.board.model;

public class Board {

	private int boardId;
	private String boardNm;
	private String boardUse;


	public Board() {}


	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getBoardUse() {
		return boardUse;
	}
	public void setBoardUse(String boardUse) {
		this.boardUse = boardUse;
	}




}
