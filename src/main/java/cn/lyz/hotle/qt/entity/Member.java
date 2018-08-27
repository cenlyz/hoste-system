package cn.lyz.hotle.qt.entity;

import java.io.Serializable;

public class Member implements Serializable{
	private static final long serialVersionUID = -2748514271164134840L;
	private Integer id;
	private String m_id;
	private String check_name;
	private String m_state;
	private String check_sex;
	private String check_tel;
	private Double m_price;
	private String m_type;
	private String id_number;
	private Double m_integral;
	private Double m_discount;
	private String m_remark;
	
	
	public String getM_remark() {
		return m_remark;
	}
	public void setM_remark(String m_remark) {
		this.m_remark = m_remark;
	}
	public Double getM_discount() {
		return m_discount;
	}
	public void setM_discount(Double m_discount) {
		this.m_discount = m_discount;
	}
	public Double getM_integral() {
		return m_integral;
	}
	public void setM_integral(Double m_integral) {
		this.m_integral = m_integral;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	public String getCheck_sex() {
		return check_sex;
	}
	public void setCheck_sex(String check_sex) {
		this.check_sex = check_sex;
	}
	public String getCheck_tel() {
		return check_tel;
	}
	public void setCheck_tel(String check_tel) {
		this.check_tel = check_tel;
	}
	public Double getM_price() {
		return m_price;
	}
	public void setM_price(Double m_price) {
		this.m_price = m_price;
	}
	public String getM_type() {
		return m_type;
	}
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", m_id=" + m_id + ", check_name=" + check_name + ", m_state=" + m_state
				+ ", check_sex=" + check_sex + ", check_tel=" + check_tel + ", m_price=" + m_price + ", m_type="
				+ m_type + ", id_number=" + id_number + ", m_integral=" + m_integral + ", m_discount=" + m_discount
				+ "]";
	}
	
	
}
