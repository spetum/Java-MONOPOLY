import java.sql.* ;

public class SelectExam_MariaDB {
//	private static final String dbClassName = "org.mariadb.jdbc.Driver";
//	private static final String CONNECTION = "jdbc:mariadb://localhost/employees";
//	private static final String CONNECTION = "jdbc:mariadb://192.168.0.130:3306/employees";
	public static void main(String[] args) {
		// JDBC-ODBC Declaration Routine
		String driver = "org.mariadb.jdbc.Driver" ;
		String url = "jdbc:mariadb://192.168.0.130:3306/employees";
		Connection con = null ;
		Statement stmt = null ;
		ResultSet rs = null ;
		String sql = "Select * from namelist " ;
		
		try {			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, "pi", "1") ; // setting User and Password
	
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("Seq#\tempNo\t\tName\t\taddress\t\tphone1\t\t\tphone2\t\t\tMemo\tgroupName");
			while (rs.next()){
				System.out.print(rs.getLong("seq")+"\t\t");
				System.out.print(rs.getLong("empNo")+"\t");
				System.out.print(rs.getString("name")+"\t\t");
				System.out.print(rs.getString("Addr")+"\t");
				System.out.print(rs.getString("Phone1")+"\t");
				System.out.print(rs.getString("Phone2")+"\t");
				System.out.print(rs.getString("Memo")+"\t");
				System.out.print(rs.getString("groupName")+"\n");
			}
		}catch (Exception e) {
			System.out.println("Cannot connect Database : ");
			e.printStackTrace();
		} finally {
			try {
				if (rs !=null) rs.close();
				if (con != null) con.close();
				if (stmt != null) stmt.close() ;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
