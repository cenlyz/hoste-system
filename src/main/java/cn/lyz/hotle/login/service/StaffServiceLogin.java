package cn.lyz.hotle.login.service;


import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.login.entity.Staff;

public interface StaffServiceLogin {
	public String checkLogin(String username,String password);
	public Staff checkLoginStaff(String username);
	 /** ÐÞ¸ÄÃÜÂë*/
	 void changePwd( String password, Integer id);
	 Staff findByUsername(String username);

}
