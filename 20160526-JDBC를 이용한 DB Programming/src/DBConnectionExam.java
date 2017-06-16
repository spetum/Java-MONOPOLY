import java.sql.*;
/* 
 * MS-Access 2007을 Java에서 접근하기 위해서는 일종의 bridge를 설치해줘야한다.
 * https://www.microsoft.com/ko-kr/download/details.aspx?id=23734
 * 
 * MS-Access 2010은 다음에서 다운로드하여 설치해주자.
 * https://www.microsoft.com/ko-kr/download/details.aspx?id=13255
 * 32bit와 64bit버전이 따로 있을 수 있으니 확인을 하고 다운로드 하자.
 * 
 * 32Bit MS-Access 2007은 JRE가 32bit여야 한다.
 * JDBC-ODBC Driver문제 때문에 JDK 7이나 JRE 7을 설치가 필요할 수 있다. 
 */
public class DBConnectionExam {
	private static String strConnect =
			"jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=C:\\Clouds\\OneDrive\\2016-01\\응용프로그래밍\\person.accdb;;";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver" ;
		String url = "jdbc:odbc:Person";
		Connection con = null ;
		Statement stmt = null ;
		
		try {
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, "", "") ; // User와 Password모두 없는 상황
			//con = DriverManager.getConnection(url) ;
			//con = DriverManager.getConnection(strConnect, "","");
			stmt = con.createStatement();
			System.out.println("Success to connect Database\n");
		} catch (Exception e) {
			System.out.println("Can not connect Database\n");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (stmt != null) stmt.close() ;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
