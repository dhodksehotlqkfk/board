package kr.or.ddit.cmt;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Cmt;
import kr.or.ddit.board.service.cmt.CmtServiceImpl;
import kr.or.ddit.board.service.cmt.ICmtService;

public class CmtServiceTest {

	private ICmtService cmtService;

	@Before
	public void setUp() throws Exception {

		cmtService = new CmtServiceImpl();

	}

	@Test
	public void insertCmt() {

		/***Given***/
		Cmt cmt = new Cmt();
		String cmtContent = "asd";
		int postId = 2;
		String userId = "brown";
		cmt.setCmtContent(cmtContent);
		cmt.setPostId(postId);
		cmt.setUserId(userId);

		/***When***/
		int res = cmtService.insertCmt(cmt);

		/***Then***/
		assertEquals(1, res);


	}

	@Test
	public void deleteCmt() {

		/***Given***/
		int cmtId = 4;

		/***When***/
		int res = cmtService.deleteCmt(cmtId);

		/***Then***/
		assertEquals(1, res);
	}

	@Test
	public void getPostCmtList() {
		/***Given***/
		int postId = 31;


		/***When***/
		List<Cmt> res = cmtService.getPostCmtList(postId);

		/***Then***/
		assertEquals(1, res.size());

	}

}
