package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import bean.Movie;
import dao.MovieDAOMSI;

public class MovieTest {

	@Test
	public void testInsertMovie() {
		Movie movie=new Movie("测试","test","中国","中文",null,"2019-1-1",120,"电影insert测试","test","这是一个movie插入测试","D:/test/");
		MovieDAOMSI dao=new MovieDAOMSI();
		try {
			dao.insertMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testUpdateMovie() {
		Movie movie=new Movie(7,"updaet测试","updateTest","美国/英国","中文","2019-2-1","2019-1-1",120,"电影update测试","test","这是一个movie修改测试","D:/test/");
		MovieDAOMSI dao=new MovieDAOMSI();
		try {
			dao.updateMovie(movie);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteMovie() {
		MovieDAOMSI dao=new MovieDAOMSI();
		try {
			dao.deleteMovie(7);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMovieById() {
		MovieDAOMSI dao=new MovieDAOMSI();
		try {
			Movie movie=dao.getMovieById(2);
			System.out.println("movieid: "+movie.getMovieid());
			System.out.println("movie Chinese name: "+movie.getChinesename());
			System.out.println("movie name: "+movie.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllMovie() {
		MovieDAOMSI dao=new MovieDAOMSI();
		try {
			List<Movie> movies=dao.getAllMovie();
			for(int i=0;i<movies.size();i++)
			{
				System.out.print("movieid: "+movies.get(i).getMovieid());
				System.out.print("\tmovie Chinese name: "+movies.get(i).getChinesename());
				System.out.println("\tmovie name: "+movies.get(i).getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
