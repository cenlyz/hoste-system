package cn.lyz.hotle.qt.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Check implements Serializable{
	
	private static final long serialVersionUID = 6475993293823451252L;
	private Integer check_id;
	private String check_name;
	private String check_type;
	private String check_source;
	private String certificate;
	private String id_number;
	private String check_sex;
	private String company;
	private Integer company_phone;
	private Integer check_phone;
	private Integer people_number;	
	private String room_id;
	private String room_type;
	private Double room_discount;
	private Double room_price;
	private Double check_price;
	private Integer check_days;
	private Integer check_state;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date check_in_time;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date check_out_time;
	private String checkru_type;
	private String rtime;
	private String remarke;
	
	
	
	public String getRemarke() {
		return remarke;
	}
	public void setRemarke(String remarke) {
		this.remarke = remarke;
	}
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getCheckru_type() {
		return checkru_type;
	}
	public void setCheckru_type(String checkru_type) {
		this.checkru_type = checkru_type;
	}
	public Integer getCheck_id() {
		return check_id;
	}
	public void setCheck_id(Integer check_id) {
		this.check_id = check_id;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getCheck_type() {
		return check_type;
	}
	public void setCheck_type(String check_type) {
		this.check_type = check_type;
	}
	public String getCheck_source() {
		return check_source;
	}
	public void setCheck_source(String check_source) {
		this.check_source = check_source;
	}
	
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getCheck_sex() {
		return check_sex;
	}
	public void setCheck_sex(String check_sex) {
		this.check_sex = check_sex;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(Integer company_phone) {
		this.company_phone = company_phone;
	}
	public Integer getCheck_phone() {
		return check_phone;
	}
	public void setCheck_phone(Integer check_phone) {
		this.check_phone = check_phone;
	}
	public Integer getPeople_number() {
		return people_number;
	}
	public void setPeople_number(Integer people_number) {
		this.people_number = people_number;
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
	public Double getRoom_discount() {
		return room_discount;
	}
	public void setRoom_discount(Double room_discount) {
		this.room_discount = room_discount;
	}
	public Double getRoom_price() {
		return room_price;
	}
	public void setRoom_price(Double room_price) {
		this.room_price = room_price;
	}
	public Double getCheck_price() {
		return check_price;
	}
	public void setCheck_price(Double check_price) {
		this.check_price = check_price;
	}
	public Integer getCheck_days() {
		return check_days;
	}
	public void setCheck_days(Integer check_days) {
		this.check_days = check_days;
	}
	public Integer getCheck_state() {
		return check_state;
	}
	public void setCheck_state(Integer check_state) {
		this.check_state = check_state;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCheck_in_time() {
		return check_in_time;
	}
	public void setCheck_in_time(Date check_in_time) {
		this.check_in_time = check_in_time;
	}
	public Date getCheck_out_time() {
		return check_out_time;
	}
	public void setCheck_out_time(Date check_out_time) {
		this.check_out_time = check_out_time;
	}
	@Override
	public String toString() {
		return "Check [check_id=" + check_id + ", check_name=" + check_name + ", check_type=" + check_type
				+ ", check_source=" + check_source + ", certificate=" + certificate + ", id_number=" + id_number
				+ ", check_sex=" + check_sex + ", company=" + company + ", company_phone=" + company_phone
				+ ", check_phone=" + check_phone + ", people_number=" + people_number + ", room_id=" + room_id
				+ ", room_type=" + room_type + ", room_discount=" + room_discount + ", room_price=" + room_price
				+ ", check_price=" + check_price + ", check_days=" + check_days + ", check_state=" + check_state
				+ ", check_in_time=" + check_in_time + ", check_out_time=" + check_out_time + ", checkru_type="
				+ checkru_type + "]";
	}
	
	
	
	
	
	
}
