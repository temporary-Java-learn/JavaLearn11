package admin.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	public static void close(Connection connection,Statement statement,ResultSet resultSet) throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
		if(statement!=null)
		{
			statement.close();
		}
		connection.close();
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phone?useUnicode=true&characterEncoding=utf8","root","password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			try {
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=phone","SA","123456");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		return conn;
	}
}

