package exWeb;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	// Data Access Object

//	private ArrayList<UserDTO> list = null;
	// 유저 관리가 데이터베이스와 연동되어있어야 한다

//	private UserDAO() {
//		list = new ArrayList<UserDTO>();
//	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

//	public int addUser(UserDTO userDto) {
//		// 중복 아이디 확인 후, list 에 추가
//
//		if (checkDupl(userDto.getId())) {
//			this.list.add(userDto);
//			return this.list.size() - 1;
//		}
//
//		return -1;
//	}
//
//	public boolean checkDupl(String id) {
//		for (UserDTO user : this.list) {
//			if (user.getId().equals(id)) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public boolean checkIdPw(String userId, String userPw) { // 로그인할때 일치하는 아이디&비밀번호가 있는지 확인
//		for (UserDTO userDTO : this.list) {
//			if (userDTO.getId().equals(userId) && userDTO.getPassword().equals(userPw)) {
//				return true;
//			}
//		}
//		return false;
//
//	}

	// 회원추가

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	private String url = "jdbc:mysql://localhost:3306/firstjsp";
	private String user = "root";
	private String password = "987789qq";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkIdPw(String id, String pw) { // 입력받은 id, pw가 제대로 입력됐을때 MySQL에서 검색해서 있다면 반환한다
		try {
			getConnection();
			pstmt = conn.prepareStatement("select id from users where id = '" + id + "' and password = '" + pw + "'");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("값 가져옴");
				return true;
			} else {
				System.out.println("값 못가져옴");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("실행에 실패하");
			return false;
		}
	}

	public boolean checkId(String id) {
		try {
			getConnection();
			pstmt = conn.prepareStatement("select id from users where id = '" + id + "'");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeId(String id, String input_pw) {
		try {
			getConnection();
			String sql = "delete from users where id = '" + id + "' and password = '" + input_pw + "'";
			pstmt = conn.prepareStatement(sql);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제 완료");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
			return false;
		}
	}

//	public boolean insertUser(UserDTO user) { // user를 받아서
//		try {
//			if (!checkId(user.getId())) {
//				getConnection();
//				String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?)";
//				pstmt = conn.prepareStatement(sql);
//
//				Date date = new Date(user.getYear() - 1900, user.getMonth(), user.getDay());
//				Timestamp time = new Timestamp(date.getTime());
//				System.out.println(time);
//
//				pstmt.setString(1, user.getId());
//				pstmt.setString(2, user.getPassword());
//				pstmt.setString(3, user.getName());
//				pstmt.setTimestamp(4,time);
//				pstmt.setInt(5, user.getGender().equals("man") ? 1 : 0);
//				pstmt.setString(6, user.getEmail());
//				pstmt.setString(7, user.getCountry());
//				pstmt.setString(8, user.getMobile());
//
//				pstmt.executeUpdate();
//				return true;
//			}
//
//			return false;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

	public boolean addUser(UserDTO userDto) {
		Date date = new Date(userDto.getYear() - 1900, userDto.getMonth(), userDto.getDay());
		Timestamp birthdate = new Timestamp(date.getTime());

		try {
			this.conn = getConnection();
			String sql = "insert into users values(?, ?, ?, ?, ?, ?, ?, ?)"; // sql은 인덱스 1부터 시작
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setString(3, userDto.getName());
			pstmt.setTimestamp(4, birthdate);
			pstmt.setInt(5, userDto.getGender().equals("man") ? 1 : 0);
			pstmt.setString(6, userDto.getEmail());
			pstmt.setString(7, userDto.getCountry());
			pstmt.setString(8, userDto.getMobile());

			// pstmt (쿼리 날릴) 준비 완료
			System.out.println(pstmt);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("유저 삽입 성공");

			} else {
				System.out.println("유저 삽입 실패");
			}

			pstmt = null;
			conn = null;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}