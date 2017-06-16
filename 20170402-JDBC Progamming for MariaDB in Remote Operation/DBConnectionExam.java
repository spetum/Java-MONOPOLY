import java.sql.*;
public class DBConnectionExam {
	private static final String dbClassName = "org.mariadb.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mariadb://192.168.0.130:3306/employees";
//	private static final String CONNECTION = "jdbc:mariadb://localhost/employees";
//	private static final String CONNECTION = "jdbc:mysql://localhost/employees";
//	private static final String dbClassName = "com.mysql.jdbc.Driver"; // for MySQL 5.5.x
	public static void main(String[] args) throws ClassNotFoundException,SQLException  {
		System.out.println(dbClassName);
		// Class.forName(xxx) loads the jdbc classes and
		// creates a drivermanager class factory
		try {
			Class.forName(dbClassName).newInstance();
			String userName = "pi" ;
			String passWord = "1" ;
			Connection connection = DriverManager.getConnection(CONNECTION, userName, passWord);
			System.out.println("It works !");
			connection.close();
		} catch (Exception e) {
		  System.out.println("JDBC Failed");

		}
    }
}
