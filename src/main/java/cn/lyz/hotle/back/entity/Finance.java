package cn.lyz.hotle.back.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Finance {
	private Integer id;
	private Integer year;
	private Integer month;
	private Integer day;
	private String type;
	private String money;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Finance [id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + ", type=" + type
				+ ", money=" + money + ", time=" + time + "]";
	}
	
	

	
	
}
