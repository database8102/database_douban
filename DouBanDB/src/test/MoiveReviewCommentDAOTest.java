package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.MovieReviewCommentDAOMSI;
import bean.MovieReviewComment;

public class MoiveReviewCommentDAOTest {

	@Test
	public void testInsertMoviereviewcomment() {
		MovieReviewComment mrc=new MovieReviewComment(1,1,"test");
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			dao.insertMoviereviewcomment(mrc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMoviereviewcomment() {
		MovieReviewComment mrc=new MovieReviewComment(5,1,1,"2018-12-31","updatetest");
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			dao.updateMoviereviewcomment(mrc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteMoviereviewcomment() {
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			dao.deleteMoviereviewcomment(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewcommentById() {
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			MovieReviewComment mrc=dao.getMoviereviewcommentById(1);
			System.out.println("movieReviewCommentid: "+mrc.getMoviereviewcommentid());
			System.out.println("movieReviewid: "+mrc.getMoviereviewid());
			System.out.println("userid: "+mrc.getUserid());
			System.out.println("createtime: "+mrc.getCreatetime());
			System.out.println("ReviewComment: "+mrc.getRccontent());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewcommentByMovieReviewidId() {
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			List<MovieReviewComment> mrcs=dao.getMoviereviewcommentByMovieReviewidId(1);
			for(int i=0;i<mrcs.size();i++)
			{
				System.out.print("movieReviewCommentid: "+mrcs.get(i).getMoviereviewcommentid());
				System.out.print("\tmovieReviewid: "+mrcs.get(i).getMoviereviewid());
				System.out.print("\tuserid: "+mrcs.get(i).getUserid());
				System.out.print("\tcreatetime: "+mrcs.get(i).getCreatetime());
				System.out.println("\tReviewComment: "+mrcs.get(i).getRccontent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewcommentByUserId() {
		MovieReviewCommentDAOMSI dao=new MovieReviewCommentDAOMSI();
		try {
			List<MovieReviewComment> mrcs=dao.getMoviereviewcommentByUserId(1);
			for(int i=0;i<mrcs.size();i++)
			{
				System.out.print("movieReviewCommentid: "+mrcs.get(i).getMoviereviewcommentid());
				System.out.print("\tmovieReviewid: "+mrcs.get(i).getMoviereviewid());
				System.out.print("\tuserid: "+mrcs.get(i).getUserid());
				System.out.print("\tcreatetime: "+mrcs.get(i).getCreatetime());
				System.out.println("\tReviewComment: "+mrcs.get(i).getRccontent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
