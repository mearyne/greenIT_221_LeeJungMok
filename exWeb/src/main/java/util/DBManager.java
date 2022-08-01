package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

	// DBManager.getConnection();
	// ㄴ 외부 클래스에서 디비연동이 필요할때
	// ㄴ 이것만 쓰면 바로 DB연동이 가능해진다
	public static Connection getConnection(String database) {
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/";
		String sqlUser = "root";
		String sqlPassword = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url + database, sqlUser, sqlPassword);

			System.out.println("연결 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
			return null;
		}

	}

}
