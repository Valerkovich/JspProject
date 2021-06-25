package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connect {
	public static Connection getConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Test";
            String login = "postgres";
            String password = "12061996";
            Connection conn = DriverManager.getConnection(url, login, password);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
