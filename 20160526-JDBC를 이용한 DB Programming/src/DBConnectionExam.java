import java.sql.*;
/* 
 * MS-Access 2007�� Java���� �����ϱ� ���ؼ��� ������ bridge�� ��ġ������Ѵ�.
 * https://www.microsoft.com/ko-kr/download/details.aspx?id=23734
 * 
 * MS-Access 2010�� �������� �ٿ�ε��Ͽ� ��ġ������.
 * https://www.microsoft.com/ko-kr/download/details.aspx?id=13255
 * 32bit�� 64bit������ ���� ���� �� ������ Ȯ���� �ϰ� �ٿ�ε� ����.
 * 
 * 32Bit MS-Access 2007�� JRE�� 32bit���� �Ѵ�.
 * JDBC-ODBC Driver���� ������ JDK 7�̳� JRE 7�� ��ġ�� �ʿ��� �� �ִ�. 
 */
public class DBConnectionExam {
	private static String strConnect =
			"jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb, *.accdb);DBQ=C:\\Clouds\\OneDrive\\2016-01\\�������α׷���\\person.accdb;;";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver" ;
		String url = "jdbc:odbc:Person";
		Connection con = null ;
		Statement stmt = null ;
		
		try {
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, "", "") ; // User�� Password��� ���� ��Ȳ
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
