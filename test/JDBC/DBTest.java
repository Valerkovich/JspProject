package JDBC;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import domain.User;

public class DBTest {
	
	@Test
	public void checkConnect() {
		Connection conn = Connect.getConnect();
		Assert.assertTrue(conn!=null);
	}
	
	@Test
	public void getAllUsersTest() {
		List<User> users = SelectUser.getAllUsers();
		for(User user: users) {
			Assert.assertNotNull(user.getId());
		}
	}
	
	@Test
	public void insertUserTest() {
		List<User> usersStart = SelectUser.getAllUsers();
		int amountUserInStart = usersStart.size();
		
		User user = new User();
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmail("Test@test.test");
		user.setAge(1);
		
		InsertUser.addUser(user);
		
		List<User> usersEnd = SelectUser.getAllUsers();
		int amountUserInEnd = usersEnd.size();
		
		Assert.assertTrue(amountUserInStart < amountUserInEnd);
	}
	
}
