package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection CreateConnection() {
		Connection conn = null;
		// ?useUnicode=true&amp;characterEncoding=utf8
//		String url = "jdbc:mysql://localhost:3306/uploadfile?useUnicode=yes&characterEncoding=UTF-8";
//		String username = "root";
//		String password = "162001";
		String url = "jdbc:mysql://node242777-nguyenthanhson162001.enscaled.sg/id16196925_uploadimg";
		String username = "root";
		String password = "DMRqbk14304";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
