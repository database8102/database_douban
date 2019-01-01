package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.MovieCommentDAOMSI;
import bean.MovieComment;

public class MovieCommentDAOTest {

	@Test
	public void testInsertMoviecomment() {
		MovieComment mc=new MovieComment(1,2,5,"Test太喜欢海王里西西里的镜头啦",null,null,"iphone","看过");
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
