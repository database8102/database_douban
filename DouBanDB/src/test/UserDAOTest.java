package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserDAOMSI;
import bean.User;

public class UserDAOTest {

	@Test
	public void testInsertUser() {
		User testUser=new User("test","123","test","test@qq.com","0086","12345678901",null,null,"66666",null); 
		UserDAOMSI dao=new UserDAOMSI();
		try {
			dao.insertUser(testUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateUser() {
		User testUser=new User(11,"updatetest","123","updatetest","test@qq.com","0086","12345678901","wx_6666",null,null,null); 
		UserDAOMSI dao=new UserDAOMSI();
		try {
			dao.updateUser(testUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteUser() {
		UserDAOMSI dao=new UserDAOMSI();
		try {
			dao.deleteUser(11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetUserById() {
		UserDAOMSI dao=new UserDAOMSI();
		try {
			User user=dao.getUserById(3);
			System.out.println("userid: "+user.getUserid());
			System.out.println("username: "+user.getUsername());
			System.out.println("password: "+user.getPassword());
			System.out.println("nickname: "+user.getNickname());
			System.out.println("email: "+user.getEmail());
			System.out.println("areacode: "+user.getAreacode());
			System.out.println("phone: "+user.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllUser() {
		UserDAOMSI dao=new UserDAOMSI();
		try {
			List<User> users=dao.getAllUser();
			for(int i=0;i<users.size();i++)
			{
				System.out.print("userid: "+users.get(i).getUserid());
				System.out.print("\tusername: "+users.get(i).getUsername());
				System.out.println("\tpassword: "+users.get(i).getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetUserByEmail() {
		UserDAOMSI dao=new UserDAOMSI();
		try {
			User user=dao.getUserByEmail("333@qq.com");
			System.out.println("userid: "+user.getUserid());
			System.out.println("username: "+user.getUsername());
			System.out.println("password: "+user.getPassword());
			System.out.println("nickname: "+user.getNickname());
			System.out.println("email: "+user.getEmail());
			System.out.println("areacode: "+user.getAreacode());
			System.out.println("phone: "+user.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
