package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import dao.MovieTypeDAOMSI;
import bean.MovieType;

public class MovieTypeDAOTest {

	@Test
	public void testInsertMovietype() {
		MovieType mt=new MovieType(6,3);
		MovieTypeDAOMSI dao=new MovieTypeDAOMSI();
		try {
			dao.insertMovietype(mt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMovietype() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMovietype() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMovietypeByMovieId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMovietypeByActorId() {
		fail("Not yet implemented");
	}

}
