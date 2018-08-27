package cn.lyz.hotle.login.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Admin implements Serializable {
	private static final long serialVersionUID = 8784804227854013230L;
	private int id;
	private String username;
	private String password;
	private Integer state;
	private String group;
	private String name;
	private String sex;
	private String phone;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date year;
	private String site;
	private String email;
	private String appraiser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAppraiser() {
		return appraiser;
	}
	public void setAppraiser(String appraiser) {
		this.appraiser = appraiser;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state + ", group="
				+ group + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", year=" + year + ", site=" + site
				+ ", email=" + email + ", appraiser=" + appraiser + "]";
	}
	
	
	

}
