import java.sql.*;

class jdbc {
	public static void main(String argv[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance ();
			System.out.println("jdbc 드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			String url = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8"; //"jdbc:mysql://localhost/mysql";
			Connection con = DriverManager.getConnection(url,"root","berryhorse");
			System.out.println("mysql 접속 성공");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select user from user where user = 'root'");
			System.out.println("Got result:");

			while(rs.next()) {
				String no= rs.getString(1);
				String tblname  = rs.getString(1);
				System.out.println(" no = " + no);
				System.out.println(" tblname= "+ tblname);
			}

			stmt.close();
			con.close();
		} catch(java.lang.Exception ex) {
			ex.printStackTrace();
		}
	}
}
