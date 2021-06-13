package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.User;

public class UpdateUser {
	
	public static void updateUser(User user) {
		String sqlDelete = "UPDATE users SET firstname = ?, lastname = ?, age = ? WHERE id = ?";
		try (Connection conn = Connect.getConnect();
	            PreparedStatement st = conn.prepareStatement(sqlDelete);){
				
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setInt(3, user.getAge());
			st.setLong(4, user.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
	}
}
