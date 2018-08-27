package cn.lyz.hotle.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.login.dao.StaffDao;
import cn.lyz.hotle.login.entity.Staff;
import cn.lyz.hotle.login.service.AppException;
import cn.lyz.hotle.login.service.StaffServiceLogin;

@Service
public class StaffServiceLoginImpl implements StaffServiceLogin {

	@Resource(name = "staffDao")
	private StaffDao dao;

	public String checkLogin(String username, String password) {

		Staff ad = dao.findStaffByUserName(username);
		if (ad == null) {
			/*
			 * 抛出应用异常 （了解） 因为用户错误操作引起的异常 需要明确提示用户采取正确的操作
			 */
			return "username";
		}
		if (!ad.getPassword().equals(password)) {
			return "password";
		}
		return "ok";
	}
	public Staff checkLoginStaff(String username) {
		return dao.findStaffByUserName(username);
		
	}

	
	
	
	public Staff findByUsername(String username) {
		if(username==null){
			throw new RuntimeException("修改密码时查询条件为空");
		}
		return dao.findByUsername(username);
	}

	public void changePwd(String password, Integer id) {
		int row=dao.changePwd(password, id);
		if(row<1){
			throw new RuntimeException("修改密码失败");
		}
		
		
	}

	
}
