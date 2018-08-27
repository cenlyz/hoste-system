package cn.lyz.hotle.qt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.Discount;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;
@Repository("memberDao")
@MyBatisRepository
public interface MemberDao {
	/** 查询所有会员*/
	List<Member > findMemberObjects(@Param("str") String str);
	/** 更具id查询会员状态*/
	Member findMemberState(@Param("id") Integer id);
	/** 修改会员状态*/
	int updateMemberState(@Param("m_state") String m_state,@Param("id") Integer id);
	/** 添加会员*/
	int saveMemberObjct(Member m);
	int getRowCount(@Param("m_id")String m_id,//会员号
			@Param("check_tel") String check_tel);
	/**
	 * name,//用户输入的项目名
	 * valid,//用户输入的状态
	 * startIndex,//分页起始位置
	 * pageSize     //显示条数
	 */
	List<Member> findPageObjects(
			@Param("m_id")String m_id,//会员号
			@Param("check_tel") String check_tel,//电话号码
			@Param("startIndex")int startIndex,//分页起始位置
			@Param("pageSize")int pageSize     //显示条数
			);
	List<Vip> getMemberSearch();
	/** 查询会员ID是否存在*/
	int findMemberCount(@Param("m_id")String m_id);
	/** 查询会员是否存在及相关信息*/
	Member getMemberByIdAddTel(@Param("id") String id);
	/** 获取该会员的折扣*/
	Discount getDiscountByType(@Param("type") String type);
	/** 根据会员号或者tel更新会员金额*/
	int updatePriceById(@Param("id") String id,@Param("price") Double price,@Param("m_integral") Double m_integral);
	/** 更新会员折扣*/
	int updateDiscount(@Param("type") String type, @Param("discount") String discount);
}
