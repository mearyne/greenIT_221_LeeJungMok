package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

import exWeb.UserDTO;
import util.DBManager;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 게시글 mysql에 올리기
	public void addBoard(BoardDTO boardDto) { // boardWriteFormPro.jsp 에서 받아온 값들을 MySQL에 올린다
		try {
			conn = DBManager.getConnection("firstJsp");
			String addBoard_sql = "insert into board values (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(addBoard_sql);

			pstmt.setInt(1, boardDto.getNo());
			pstmt.setInt(2, boardDto.getCode());
			pstmt.setString(3, boardDto.getTitle());
			pstmt.setString(4, boardDto.getContents());
			pstmt.setInt(5, boardDto.getViewCnt());
			pstmt.setInt(6, boardDto.getLikeCnt());
			pstmt.setTimestamp(7, boardDto.getCreateAt());
			pstmt.setTimestamp(8, boardDto.getModified());

			pstmt.execute();
			System.out.println("게시글 업로드 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시글 업로드 실패");
		} finally {
			try {
				conn = null;
				rs = null;
				pstmt = null;
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	// 랜덤 코드 얻기
	public int randCode() { // 게시글을 추가할때 이 메소드를 사용해서 랜덤코드를 얻는다
		Random rand = new Random();
		while (true) {
			int rCode = rand.nextInt(8999) + 1000; // 1000 ~ 9999 중의 랜덤한 숫자
			if (bringBoardData(rCode) != null) {
				return rCode;
			}
		}

	}

	// 코드를 통해서 게시글 얻기
	public BoardDTO bringBoardData(int searchCode) { // use to bring Board data
		try {
			conn = DBManager.getConnection("firstJsp");
			String findCode_sql = "select * from board where code = " + searchCode;
			pstmt = conn.prepareStatement(findCode_sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("mysql에서 코드와 일치하는 데이터를 찾았습니다");

				int no = rs.getInt(1);
				int code = rs.getInt(2);
				String title = rs.getString(3);
				String contents = rs.getString(4);
				int viewCnt = rs.getInt(5);
				int likeCnt = rs.getInt(6);
				Timestamp createAt = rs.getTimestamp(7);
				Timestamp modified = rs.getTimestamp(8);

				BoardDTO user = new BoardDTO(no, code, title, contents, viewCnt, likeCnt, createAt, modified);
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("중복코드 찾는 과정에서 오류 발생");
		} finally {
			conn = null;
			pstmt = null;
			rs = null;
		}
		System.out.println("mysql에서 코드와 일치하는 데이터를 찾지 못했습니다");
		return null;

	}

	// 모든 코드정보를 배열에 저장시키기
	public ArrayList<Integer> bringAllCode() { // 모든 게시글에 대한 코드정보를 불러옴. bringBoardData메소드에 적용할 예정
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			conn = DBManager.getConnection("firstJsp");
			String findAllCode_sql = "select code from board";
			pstmt = conn.prepareStatement(findAllCode_sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(rs.getInt(1));
			}

			System.out.println("전체코드 불러오기 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전체코드 불러오기 실패");
		}

		return arr;
	}

	public void clickLike(int code) {
		try {

			BoardDTO boardData = bringBoardData(code);
			int likeNum = boardData.getLikeCnt() + 1;

			// TEST
			System.out.println("likeNum : " + likeNum);

			// UPDATE board SET viewCnt = 12 WHERE code= 2222;
			conn = DBManager.getConnection("firstJsp"); // 아래로 내린게 무슨 의미가 있지? conn = null이 되기 때문에 아래로 내려줘야한다
			String updateLikeCnt_sql = "UPDATE board SET likeCnt = " + likeNum + " WHERE code= " + code;
			pstmt = conn.prepareStatement(updateLikeCnt_sql);
			pstmt.execute();

			System.out.println("like 업데이트 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("like 업데이트 실패");
		}

	}

}
