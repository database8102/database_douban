package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.MovieReviewDAOMSI;
import bean.MovieReview;

public class MovieReviewDAOTest {

	@Test
	public void testInsertMoviereview() {
		MovieReview mr=new MovieReview(1,3,"test");
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			dao.insertMoviereview(mr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateMoviereview() {
		MovieReview mr=new MovieReview(6,1,3,"2018-12-31","updatetest",10,1);
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			dao.updateMoviereview(mr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteMoviereview() {
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			dao.deleteMoviereview(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewById() {
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			MovieReview mr=dao.getMoviereviewById(1);
			System.out.println("moviereviewid: "+mr.getMoviereviewid());
			System.out.println("topicid: "+mr.getTopicid());
			System.out.println("userid: "+mr.getUserid());
			System.out.println("reviewcontent: "+mr.getReviewcontent());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewByTopicId() {
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			List<MovieReview> mrs=dao.getMoviereviewByTopicId(1);
			for(int i=0;i<mrs.size();i++)
			{
				System.out.print("moviereviewid: "+mrs.get(i).getMoviereviewid());
				System.out.print("\ttopicid: "+mrs.get(i).getTopicid());
				System.out.print("\tuserid: "+mrs.get(i).getUserid());
				System.out.println("\treviewcontent: "+mrs.get(i).getReviewcontent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMoviereviewByUserId() {
		MovieReviewDAOMSI dao=new MovieReviewDAOMSI();
		try {
			List<MovieReview> mrs=dao.getMoviereviewByUserId(3);
			for(int i=0;i<mrs.size();i++)
			{
				System.out.print("moviereviewid: "+mrs.get(i).getMoviereviewid());
				System.out.print("\ttopicid: "+mrs.get(i).getTopicid());
				System.out.print("\tuserid: "+mrs.get(i).getUserid());
				System.out.println("\treviewcontent: "+mrs.get(i).getReviewcontent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
