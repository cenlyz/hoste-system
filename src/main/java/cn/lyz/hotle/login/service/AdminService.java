package cn.lyz.hotle.login.service;


import cn.lyz.hotle.login.entity.Admin;

public interface AdminService {
	/** 登陆*/ 
	String findAdminByUserName(String username,String password);
	Admin findAdmin(String username);
	/** 更新信息*/
	String updateAdminUser(Admin admin);
	/** 修改密码*/
	String changePwd(String password,String username);
	/** 找回密码*/
	public Admin findByUsername(String id);
}
