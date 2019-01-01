package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.MovieCommentDAOMSI;
import bean.MovieComment;

public class MovieCommentDAOTest {

	@Test
	public void testInsertMoviecomment() {
		MovieComment mc=new MovieComment(1,2,5,"太喜欢海王里西西里的镜头啦",null,"iphone","看过");
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			dao.insertMoviecomment(mc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMoviecomment() {
		MovieComment mc=new MovieComment(5,1,2,5,"updateTest太喜欢海王里西西里的镜头啦",5,"2018-12-31","android","看过");
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			dao.updateMoviecomment(mc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteMoviecomment() {
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			dao.deleteMoviecomment(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviecommentByUserId() {
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			List<MovieComment>mcs=dao.getMoviecommentByUserId(3);
			for(int i=0;i<mcs.size();i++)
			{
				System.out.print("commentid: "+mcs.get(i).getCommentid());
				System.out.print("\tuserid: "+mcs.get(i).getUserid());
				System.out.print("\tmovieid: "+mcs.get(i).getMovieid());
				System.out.print("\tscore: "+mcs.get(i).getScore());
				System.out.println("\tcommentcontent: "+mcs.get(i).getCommentcontent());	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviecommentByMovieId() {
		MovieCommentDAOMSI dao=new MovieCommentDAOMSI();
		try {
			List<MovieComment>mcs=dao.getMoviecommentByMovieId(6);
			for(int i=0;i<mcs.size();i++)
			{
				System.out.print("commentid: "+mcs.get(i).getCommentid());
				System.out.print("\tuserid: "+mcs.get(i).getUserid());
				System.out.print("\tmovieid: "+mcs.get(i).getMovieid());
				System.out.print("\tscore: "+mcs.get(i).getScore());
				System.out.println("\tcommentcontent: "+mcs.get(i).getCommentcontent());	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
