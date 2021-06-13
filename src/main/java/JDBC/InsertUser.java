package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.User;

public class InsertUser {
	
	public static void addUser(User user) {
		String sqlInsert = "insert into users "
				+ "(firstname, lastname, age) values (?,?,?)";
		try (Connection conn = Connect.getConnect();
	            PreparedStatement st = conn.prepareStatement(sqlInsert);){
				
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setInt(3, user.getAge());
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
