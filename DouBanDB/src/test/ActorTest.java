package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.ActorDAOMSI;
import bean.Actor;

public class ActorTest {

	@Test
	public void testInsertActor() {
		Actor actor=new Actor("����Ա","tester","123456","��","2019-1-1","����һ��Actor�������","D:/test/actor/");
		ActorDAOMSI dao=new ActorDAOMSI();
		try {
			dao.insertActor(actor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateActor() {
		Actor actor=new Actor(9,"�޸Ĳ���Ա","updatetester","654321","Ů","2018-12-31","����һ��Actor�޸Ĳ���","D:/test/actor/");
		ActorDAOMSI dao=new ActorDAOMSI();
		try {
			dao.updateActor(actor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteActor() {
		ActorDAOMSI dao=new ActorDAOMSI();
		try {
			dao.deleteActor(9);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetActorById() {
		ActorDAOMSI dao=new ActorDAOMSI();
		try {
			Actor actor=dao.getActorById(6);
			System.out.println("actorid: "+actor.getActorid());
			System.out.println("Chinese name: "+actor.getChinesename());
			System.out.println("name: "+actor.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllActor() {
		ActorDAOMSI dao=new ActorDAOMSI();
		try {
			ArrayList<Actor> actors=dao.getAllActor();
			for(int i=0;i<actors.size();i++)
			{
				System.out.print("actorid: "+actors.get(i).getActorid());
				System.out.print("\tChinese name: "+actors.get(i).getChinesename());
				System.out.println("\tname: "+actors.get(i).getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
