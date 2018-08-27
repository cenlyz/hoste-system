package cn.lyz.hotle.login.entity;

import java.io.Serializable;

public class Staff implements Serializable {

	private static final long serialVersionUID = -7445656166296932620L;
	private Integer id;
	private String  name;
	private String username;
	private String password;
	private String staff_phone;
	private String staff_site;
	private String staff_sex;
	private String staff_state;
	private String staff_health_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}
	public String getStaff_site() {
		return staff_site;
	}
	public void setStaff_site(String staff_site) {
		this.staff_site = staff_site;
	}
	public String getStaff_sex() {
		return staff_sex;
	}
	public void setStaff_sex(String staff_sex) {
		this.staff_sex = staff_sex;
	}
	public String getStaff_state() {
		return staff_state;
	}
	public void setStaff_state(String staff_state) {
		this.staff_state = staff_state;
	}
	public String getStaff_health_id() {
		return staff_health_id;
	}
	public void setStaff_health_id(String staff_health_id) {
		this.staff_health_id = staff_health_id;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", staff_phone=" + staff_phone + ", staff_site=" + staff_site + ", staff_sex=" + staff_sex
				+ ", staff_state=" + staff_state + ", staff_health_id=" + staff_health_id + "]";
	}
	
}
