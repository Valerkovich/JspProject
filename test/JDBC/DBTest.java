package JDBC;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.User;

public class DBTest {
	
	@Before
	public void addUser() {
		User user = new User();
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setEmail("Test@test.test");
		user.setAge(1);
		
		InsertUser.addUser(user);
	}
	
	@After
	public void deleteUser() {
		DeleteUser.deleteUserByName("Test");
	}
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
	public void getUserByNameTest() {
		User user = SelectUser.getUserByName("Test");
		Assert.assertNotNull(user.getId());

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
	
	@Test
	public void updateUserTest() {
		User user = SelectUser.getUserByName("Test");
		
		user.setLastName("Update Test");
		
		UpdateUser.updateUser(user);
		
		User userUpdate = SelectUser.getUserByName("Test");
		
		Assert.assertTrue(user.getId() == userUpdate.getId());
		Assert.assertFalse(user.getLastName() == userUpdate.getLastName());
	}
	
	@Test
	public void deleteUserTest() {
		List<User> usersStart = SelectUser.getAllUsers();
		int amountUserInStart = usersStart.size();
		
		DeleteUser.deleteUserByName("Test");
		
		List<User> usersEnd = SelectUser.getAllUsers();
		int amountUserInEnd = usersEnd.size();
		
		Assert.assertTrue(amountUserInStart > amountUserInEnd);
	}
	
	
	
}
