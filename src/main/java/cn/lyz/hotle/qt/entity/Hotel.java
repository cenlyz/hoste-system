package cn.lyz.hotle.qt.entity;

import java.io.Serializable;

public class Hotel implements Serializable {

	private static final long serialVersionUID = -5901259343037182159L;
	private Integer id;
	private String h_name;
	private String h_tel;
	private String h_site;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getH_tel() {
		return h_tel;
	}
	public void setH_tel(String h_tel) {
		this.h_tel = h_tel;
	}
	public String getH_site() {
		return h_site;
	}
	public void setH_site(String h_site) {
		this.h_site = h_site;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", h_name=" + h_name + ", h_tel=" + h_tel + ", h_site=" + h_site + "]";
	}
	
	
}
