package cn.lyz.hotle.login.service.impl;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.login.dao.AdminDao;
import cn.lyz.hotle.login.entity.Admin;
import cn.lyz.hotle.login.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDao")
	private AdminDao dao;

	
	public String findAdminByUserName(String username, String password) {
		Admin admin=dao.findAdminByUserName(username);
		System.out.println(admin);
		if(admin==null){
			return "username";
		}
		if(!admin.getPassword().equals(password)){
			return "password";
		}else{
			return "ok";
		}
	}
	
	public Admin findAdmin(String username) {
			return dao.findAdminByUserName(username);
	}

	public String updateAdminUser(Admin admin) {
		if(admin==null){
			throw new RuntimeException("修改信息内容为空");
		}
		int row=dao.updateAdminUser(admin);
		if(row<1){
			return "error";
		}
		return "ok";
	}

	public String changePwd(String password, String username) {
		if(username==null){
		throw new RuntimeException("修改用户账号为空");
		}
		int row = dao.changePwd(password, username);
		if(row<1){
			return "error";
		}
		return "ok";
	}

	public Admin findByUsername(String username) {
		if(username==null){
			throw new RuntimeException("修改用户账号为空");
			}
		return dao.findByUsername(username);
	}

}
