package board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("BoardVO")
public class BoardVO {

	private int num;
	private String  writer;
	private String title;
	private String images;
	private Timestamp regDate;
	private String content;
	private String email;
	private String password;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BoardVO() {}
	
	public BoardVO(String title, String images, String content,
			String writer, String pass, Timestamp redgate) {
		super();
		this.title=title;
		this.images=images;
		this.content=content;
		this.writer=writer;
		this.regDate=redgate;
		
		
		
	}
	
}
