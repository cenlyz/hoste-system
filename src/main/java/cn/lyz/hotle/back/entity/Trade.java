package cn.lyz.hotle.back.entity;

import java.io.Serializable;

public class Trade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String goods_id;
	private String goods_name;
	private String goods_kc;
	private String goods_yu;
	private String goods_class;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_kc() {
		return goods_kc;
	}
	public void setGoods_kc(String goods_kc) {
		this.goods_kc = goods_kc;
	}
	public String getGoods_yu() {
		return goods_yu;
	}
	public void setGoods_yu(String goods_yu) {
		this.goods_yu = goods_yu;
	}
	public String getGoods_class() {
		return goods_class;
	}
	public void setGoods_class(String goods_class) {
		this.goods_class = goods_class;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_kc=" + goods_kc
				+ ", goods_yu=" + goods_yu + ", goods_class=" + goods_class + "]";
	}
	
	
}
