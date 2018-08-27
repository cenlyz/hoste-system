package cn.lyz.hotle.login.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.login.entity.Admin;
import cn.lyz.hotle.login.entity.Staff;

@Repository("staffDao")
@MyBatisRepository
public interface StaffDao {
	/** 登陆*/ 
	Staff findStaffByUserName(@Param("username") String username);

	 /** 查询所有用户*/
	 List<Staff> findStaffs();
	 /** 更具用户名查询*/
	 List<Staff> findUserName(@Param("username") String username);
	 /** 添加用户*/
	 int insertStaff(Staff staff);
	 /** 删除用户*/
	 int staffDelId(@Param("id") Integer id);
	 /** 批量删除*/
	 void staffDelIds(@Param("ids") String[] ids);
	 /** 修改用户*/
	 int editStaff(Staff staff);
	 /** 修改密码*/
	 int changePwd(@Param("password") String password,@Param("id") Integer id);
	 Staff findByUsername(@Param("username") String username);
	 
}
