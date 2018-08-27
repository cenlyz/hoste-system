package cn.lyz.hotle.qt.entity;

public class Message {
	private Integer id;
	private String message;
	private String name;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	@Override
	public String toString() {
		return "message [id=" + id + ", message=" + message + ", name=" + name + ", username=" + username + "]";
	}
	
	
}
