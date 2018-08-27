package cn.lyz.hotle.qt.entity;

import java.io.Serializable;

public class Room implements Serializable{

	private static final long serialVersionUID = 8675369784663827191L;
	private Integer id;
	private String room_id;
	private String room_type;
	private String room_price;
	private String room_site;
	private String room_phone;
	private String room_state;
	private String room_discount;
	private String room_describe;
	private String room_remark;
	private String room_count;
	private Integer book_id;
	
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public String getRoom_count() {
		return room_count;
	}
	public void setRoom_count(String room_count) {
		this.room_count = room_count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getRoom_price() {
		return room_price;
	}
	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}
	public String getRoom_site() {
		return room_site;
	}
	public void setRoom_site(String room_site) {
		this.room_site = room_site;
	}
	public String getRoom_phone() {
		return room_phone;
	}
	public void setRoom_phone(String room_phone) {
		this.room_phone = room_phone;
	}
	public String getRoom_state() {
		return room_state;
	}
	public void setRoom_state(String room_state) {
		this.room_state = room_state;
	}
	public String getRoom_discount() {
		return room_discount;
	}
	public void setRoom_discount(String room_discount) {
		this.room_discount = room_discount;
	}
	public String getRoom_describe() {
		return room_describe;
	}
	public void setRoom_describe(String room_describe) {
		this.room_describe = room_describe;
	}
	public String getRoom_remark() {
		return room_remark;
	}
	public void setRoom_remark(String room_remark) {
		this.room_remark = room_remark;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", room_id=" + room_id + ", room_type=" + room_type + ", room_price=" + room_price
				+ ", room_site=" + room_site + ", room_phone=" + room_phone + ", room_state=" + room_state
				+ ", room_discount=" + room_discount + ", room_describe=" + room_describe + ", room_remark="
				+ room_remark + ", room_count=" + room_count + ", book_id=" + book_id + "]";
	}
	
	
	
	
	
}
