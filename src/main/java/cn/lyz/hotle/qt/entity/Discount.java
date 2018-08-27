package cn.lyz.hotle.qt.entity;

import java.io.Serializable;

public class Discount implements Serializable{
	private static final long serialVersionUID = -557835475620990693L;
	private Integer id;
	private String type ;
	private Double discount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Discount [id=" + id + ", type=" + type + ", discount=" + discount + "]";
	}
	
}
