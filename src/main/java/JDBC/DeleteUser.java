package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
	
	public static void deleteUserById(Long id) {
		String sqlDelete = "DELETE FROM users WHERE id = ?;";
		try (Connection conn = Connect.getConnect();
	            PreparedStatement st = conn.prepareStatement(sqlDelete);){
				
			st.setLong(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
	}
}
