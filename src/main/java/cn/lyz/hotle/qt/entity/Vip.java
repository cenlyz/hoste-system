package cn.lyz.hotle.qt.entity;

public class Vip {
	private Integer count;
	private String type;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vip [count=" + count + ", type=" + type + "]";
	}
	
	
}
