package cn.lyz.hotle.back.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.login.entity.Staff;

public interface StaffService {
	/** 查询所有用户*/
	List<Staff> findStaffs();
	 /** 更具用户名查询*/
	 List<Staff> findUserName( String username);
	 /** 添加用户*/
	 void insertStaff(Staff staff);
	 /** 删除用户*/
	 void staffDelId(Integer id);
	 /** 批量删除*/
	 void staffDelIds(String[] ids);
	 /** 修改用户*/
	 void editStaff(Staff staff);
}
