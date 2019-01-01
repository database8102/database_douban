package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

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
		MovieTypeDAOMSI dao=new MovieTypeDAOMSI();
		try {
			dao.updateMovietype(6, 4, 6, 3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteMovietype() {
		MovieTypeDAOMSI dao=new MovieTypeDAOMSI();
		try {
			dao.deleteMovietype(6, 4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMovietypeByMovieId() {
		MovieTypeDAOMSI dao=new MovieTypeDAOMSI();
		try {
			System.out.println("getMovietypeByMovieId():");
			List<MovieType> mts=dao.getMovietypeByMovieId(2);
			for(int i=0;i<mts.size();i++)
			{
				System.out.print("movieid: "+mts.get(i).getMovieid());
				System.out.println("\ttypeid: "+mts.get(i).getTypeid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMovietypeByTypeId() {
		MovieTypeDAOMSI dao=new MovieTypeDAOMSI();
		try {
			System.out.println("getMovietypeByTypeId:");
			List<MovieType> mts=dao.getMovietypeByTypeId(2);
			for(int i=0;i<mts.size();i++)
			{
				System.out.print("movieid: "+mts.get(i).getMovieid());
				System.out.println("\ttypeid: "+mts.get(i).getTypeid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
