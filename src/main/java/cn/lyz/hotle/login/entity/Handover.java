package cn.lyz.hotle.login.entity;

public class Handover {
	private String name;
	private String phone;
	private String staff_id;
	private String dmoney;
	private String bmoney;
	private String name2;
	private String phone2;
	private String staff_id2;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getDmoney() {
		return dmoney;
	}
	public void setDmoney(String dmoney) {
		this.dmoney = dmoney;
	}
	public String getBmoney() {
		return bmoney;
	}
	public void setBmoney(String bmoney) {
		this.bmoney = bmoney;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getStaff_id2() {
		return staff_id2;
	}
	public void setStaff_id2(String staff_id2) {
		this.staff_id2 = staff_id2;
	}
	@Override
	public String toString() {
		return "Handover [name=" + name + ", phone=" + phone + ", staff_id=" + staff_id + ", dmoney=" + dmoney
				+ ", bmoney=" + bmoney + ", name2=" + name2 + ", phone2=" + phone2 + ", staff_id2=" + staff_id2 + "]";
	}
	
	
}
