package custom;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;

public class CustomDAO {
	private static CustomDAO instance = new CustomDAO();
	
	private CustomDAO() {
	}
	
	public static CustomDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<CustomDTO> getCustomDTOs() {
		ArrayList<CustomDTO> customDTOs = new ArrayList<CustomDTO>();
		String sql = "select * from custom";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				Date joindate = rs.getDate(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);

				// test
				System.out.println(custno);
				
				CustomDTO customDTO = new CustomDTO(custno, custname, phone, address, joindate, grade, city);
				customDTOs.add(customDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
			pstmt = null;
		}
		
		return customDTOs;
		
	}

	public void addCustom(CustomDTO customDTO) {
		String sql = "insert into custom(custno, custname, phone, address, grade, city) values (?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, customDTO.getCustno());
			pstmt.setString(2, customDTO.getCustname());
			pstmt.setString(3, customDTO.getPhone());
			pstmt.setString(4, customDTO.getAddress());
			pstmt.setString(5, customDTO.getGrade());
			pstmt.setString(6, customDTO.getCity());
			
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
			pstmt = null;
		}
		
		
		
	}

	public int getCustno() {
		String sql = "select count(*) from custom";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			return rs.getInt(1) + 100000;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
			pstmt = null;
			
		}
		
		return 0;
	}
}
