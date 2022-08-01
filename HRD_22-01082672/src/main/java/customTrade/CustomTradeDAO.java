package customTrade;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import custom.CustomDTO;
import util.DBManager;

public class CustomTradeDAO {
	private static CustomTradeDAO instance = new CustomTradeDAO();

	private CustomTradeDAO() {
	}

	public static CustomTradeDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ArrayList<CustomTradeDTO> getCustomTradeDTOs(int input_custno) {
		ArrayList<CustomTradeDTO> customTradeDTOs = new ArrayList<CustomTradeDTO>();
		String sql = "select * from customTrade where custno=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input_custno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int custno = rs.getInt(1);
				int salenol = rs.getInt(2);
				int pcost = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);
				String pcode = rs.getString(6);
				Date sdate = rs.getDate(7);

				// test
				System.out.println("DTO : " + price);

				CustomTradeDTO customTradeDTO = new CustomTradeDTO(custno, salenol, pcost, amount, price, pcode, sdate);
				customTradeDTOs.add(customTradeDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
			pstmt = null;
		}

		return customTradeDTOs;
	}

	public void updateCustomTrade(CustomTradeDTO customTradeDTO) {
		String sql = "update customTrade set pcost=?, amount=?, price=?, pcode=?, sdate=? where salenol=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, customTradeDTO.getCustno());
			pstmt.setInt(2, customTradeDTO.getPcost());
			pstmt.setInt(3, customTradeDTO.getAmount());
			pstmt.setInt(4, customTradeDTO.getPrice());
			pstmt.setString(5, customTradeDTO.getPcode());
			pstmt.setDate(6, customTradeDTO.getSdate());
			pstmt.setInt(6, customTradeDTO.getSalenol());
			
			pstmt.execute();
			System.out.println("업데이트 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업데이트 실패");
		} finally {
			conn = null;
			pstmt = null;
		}
	}

	public CustomTradeDTO getCustomTrade(int input_salenol) {
		String sql = "select * from customTrade where salenol=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input_salenol);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int custno = rs.getInt(1);
				int salenol = rs.getInt(2);
				int pcost = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);
				String pcode = rs.getString(6);
				Date sdate = rs.getDate(7);

				CustomTradeDTO customTradeDTO = new CustomTradeDTO(custno, salenol, pcost, amount, price, pcode, sdate);
				return customTradeDTO;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn = null;
			pstmt = null;
		}

		return null;
	}

}
