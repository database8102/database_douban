package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.MovieCommentDAOMSI;
import bean.MovieComment;

public class MovieCommentDAOTest {

	@Test
	public void testInsertMoviecomment() {
		MovieComment mc=new MovieComment(1,2,5,"Test̫ϲ��������������ľ�ͷ��",null,null,"iphone","����");
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			dao.insertMoviecomment(mc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMoviecomment() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMoviecomment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMoviecommentByUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMoviecommentByMovieId() {
		fail("Not yet implemented");
	}

}
