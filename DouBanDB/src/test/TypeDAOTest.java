package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.TypeDAOMSI;
import bean.Type;

public class TypeDAOTest {

	@Test
	public void testInsertType() {
		Type type=new Type("≤‚ ‘");
		TypeDAOMSI dao=new TypeDAOMSI();
		try {
			dao.insertType(type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateType() {
		Type type=new Type(6,"test");
		TypeDAOMSI dao=new TypeDAOMSI();
		try {
			dao.updateType(type);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteType() {
		TypeDAOMSI dao=new TypeDAOMSI();
		try {
			dao.deleteType(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTypeById() {
		TypeDAOMSI dao=new TypeDAOMSI();
		try {
			Type type=dao.getTypeById(4);
			System.out.println("typeid: "+type.getTypeid());
			System.out.println("typename: "+type.getTypename());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllType() {
		TypeDAOMSI dao=new TypeDAOMSI();
		try {
			List<Type> types=dao.getAllType();
			for(int i=0;i<types.size();i++)
			{
				System.out.print("typeid: "+types.get(i).getTypeid());
				System.out.println("\ttypename: "+types.get(i).getTypename());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
