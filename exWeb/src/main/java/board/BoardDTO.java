package board;

import java.sql.Timestamp;

public class BoardDTO {
	private int no;
	private int code;
	private String title;
	private String contents;
	private int viewCnt;
	private int likeCnt;
	private Timestamp createAt;
	private Timestamp modified;

	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt, Timestamp createAt,
			Timestamp modified) {
		super();
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createAt = createAt;
		this.modified = modified;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}
