package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.CastDAOMSI;
import bean.Cast;

public class CastDAOTest {

	@Test
	public void testInsertCast() {
		Cast cast=new Cast(2,8,"—›‘± Actress£® Œ ≤‚ ‘¡˙Ã◊£©");
		CastDAOMSI dao=new CastDAOMSI();
		try {
			dao.insertCast(cast);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateCast() {
		Cast cast=new Cast(9,2,8,"≤‚ ‘µº—› Director");
		CastDAOMSI dao=new CastDAOMSI();
		try {
			dao.updateCast(cast);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteCast() {
		CastDAOMSI dao=new CastDAOMSI();
		try {
			dao.deleteCast(9);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCastByMovieId() {
		CastDAOMSI dao=new CastDAOMSI();
		try {
			ArrayList<Cast> casts=dao.getCastByMovieId(2);
			for(int i=0;i<casts.size();i++)
			{
				System.out.println("castid: "+casts.get(i).getCastid());
				System.out.println("movieid: "+casts.get(i).getMovieid());
				System.out.println("actorid: "+casts.get(i).getActorid());
				System.out.println("role: "+casts.get(i).getRole()+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCastByActorId() {
		CastDAOMSI dao=new CastDAOMSI();
		try {
			ArrayList<Cast> casts=dao.getCastByActorId(8);
			for(int i=0;i<casts.size();i++)
			{
				System.out.println("castid: "+casts.get(i).getCastid());
				System.out.println("movieid: "+casts.get(i).getMovieid());
				System.out.println("actorid: "+casts.get(i).getActorid());
				System.out.println("role: "+casts.get(i).getRole()+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
