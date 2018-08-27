package cn.lyz.hotle.login.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.login.entity.Admin;

@Repository("adminDao")
@MyBatisRepository
public interface AdminDao {
	/** 登陆*/ 
	Admin findAdminByUserName(@Param("username") String username);
	/** 更新信息*/
	int updateAdminUser(Admin admin);
	/***/
	int changePwd(@Param("password") String password,
			@Param("username") String username);
	/** 找回密码*/
	public Admin findByUsername(String id);
}
