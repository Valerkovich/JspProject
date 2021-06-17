package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class SelectUser {
	
	public static List<User> getAllUsers(){
		List<User> userList = new ArrayList<>();
		
		String sqlSelect = "select id, firstname, lastname, email, age from users";
		try (Connection conn = Connect.getConnect();
				Statement st = conn.createStatement();
				ResultSet resultSet = st.executeQuery(sqlSelect);){
				
			while(resultSet.next()) {
				
				Long id = resultSet.getLong(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String email = resultSet.getString(4);
				int age = resultSet.getInt(5);
				userList.add(new User(id,firstName,lastName,email,age));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	public static User getUserById(Long userId) {
		User user = new User();
		String sqlSelect = "select id, firstname, lastname, age from users where id = ?";
		try (Connection conn = Connect.getConnect();
				PreparedStatement st = conn.prepareStatement(sqlSelect);){
				
			st.setLong(1, userId);
			ResultSet resultSet = st.executeQuery();
			while(resultSet.next()) {
			                                     
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				int age = resultSet.getInt("age");
				    
				user.setId(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAge(age);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static User getUserByName(String name) {
		User user = new User();
		String sqlSelect = "select id, firstname, lastname, age from users where firstname = ?";
		try (Connection conn = Connect.getConnect();
				PreparedStatement st = conn.prepareStatement(sqlSelect);){
				
			st.setString(1, name);
			ResultSet resultSet = st.executeQuery();
			while(resultSet.next()) {
                
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				int age = resultSet.getInt("age");
				    
				user.setId(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAge(age);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
