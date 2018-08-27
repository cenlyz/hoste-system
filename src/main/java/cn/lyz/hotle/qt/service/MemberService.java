package cn.lyz.hotle.qt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;

public interface MemberService {
	/** 查询所有会员*/
	List<Member> findMemberObjects(String str);
	/** 修改会员状态*/
	void updateMemberState(String m_state, Integer id);
	/** 添加会员*/
	void saveMemberObjct(Member m);
	/**分页查询方法*/
	Map<String,Object> findPageObjects(String m_id, String check_tel, int pageCurrent);
	
	/** 查询所有会员*/
	List<Vip> getMemberSearch();
	/** 查询会员ID是否存在*/
	boolean findMemberCount(String m_id);
	/** 查询会员是否存在*/
	Member getMemberByIdAddTel(String id);
	/** 更新会员折扣*/
	void updateDiscount( String type,  String discount);
}
