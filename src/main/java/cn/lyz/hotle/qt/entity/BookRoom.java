package cn.lyz.hotle.qt.entity;

import java.io.Serializable;
import java.util.Date;

public class BookRoom implements Serializable{

	private static final long serialVersionUID = 4826437040949427301L;
	private Integer id;
	private String check_name;
	private String check_tel;
	private Date check_in;
	private Date check_out;
	private String book_room;
	private String book_type;
	private String book_mony;
	private Integer book_count;
	
	
	
	public Integer getBook_count() {
		return book_count;
	}
	public void setBook_count(Integer book_count) {
		this.book_count = book_count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getCheck_tel() {
		return check_tel;
	}
	public void setCheck_tel(String check_tel) {
		this.check_tel = check_tel;
	}
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	public String getBook_room() {
		return book_room;
	}
	public void setBook_room(String book_room) {
		this.book_room = book_room;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public String getBook_mony() {
		return book_mony;
	}
	public void setBook_mony(String book_mony) {
		this.book_mony = book_mony;
	}
	@Override
	public String toString() {
		return "BookRoom [id=" + id + ", check_name=" + check_name + ", check_tel=" + check_tel + ", check_in="
				+ check_in + ", check_out=" + check_out + ", book_room=" + book_room + ", book_type=" + book_type
				+ ", book_mony=" + book_mony + ", book_count=" + book_count + "]";
	}
	
	
	
}
