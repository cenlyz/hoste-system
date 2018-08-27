package cn.lyz.hotle.qt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.execption.ServiceException;
import cn.lyz.hotle.qt.dao.MemberDao;
import cn.lyz.hotle.qt.entity.Discount;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Vip;
import cn.lyz.hotle.qt.service.MemberService;
import cn.lyz.hotle.web.PageObject;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource(name="memberDao")
	MemberDao dao;

	public List<Member> findMemberObjects(String str) {
		return dao.findMemberObjects(str);
	}

	public void updateMemberState(String m_state,Integer id) {
		if(id==null){
			throw new ServiceException("修改会员id为空");
		}
		if(m_state==null){
			throw new ServiceException("修改会员状态为空");
		}
		Member m=dao.findMemberState(id);
		if(m_state.equals(m.getM_state())){
			throw new ServiceException("会员状态以是"+m_state+"状态无需修改");
		}
		int row = dao.updateMemberState(m_state, id);
		if(row<1){
			throw new ServiceException("修改会员状态失败");
		}
	}

	public void saveMemberObjct(Member m) {
		if(m==null){
			throw new ServiceException("添加会员信息为空");
		}
		m.setM_state("启用");
		if(m.getM_price()<1000.0){
			m.setM_integral(10.0);
		}
		if(m.getM_price()>1000.0){
			m.setM_integral(500.0);
		}
		if(m.getM_price()==1000.0){
			m.setM_integral(100.0);
		}
		String type=m.getM_type();
		if(type!=null){
			Discount dis=dao.getDiscountByType(type);
			m.setM_discount(dis.getDiscount());
		}
		System.out.println(m.getM_integral());
		System.out.println(m.getM_discount());
		int row=dao.saveMemberObjct(m);
		if(row<1){
			throw new ServiceException("添加会员失败");
		}
		
	}

	public Map<String, Object> findPageObjects(String id, String tel, int pageCurrent) {
		PageObject pageObject=new PageObject();
		int pageSize=7;//显示条数
		int startIndex=(pageCurrent-1)*pageSize;
		//获取当前页数据
		List<Member> list=dao.findPageObjects(id, tel, startIndex, pageSize);
		System.out.println("list=="+list);
		int rowCount=dao.getRowCount(id, tel);//获取最大记录条数
		//获取总记录数冰封装分页信息
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//封装到map
		System.out.println(rowCount);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list",list);
		map.put("pageObject", pageObject);
		return  map;
	}

	public List<Vip> getMemberSearch() {
		
		return dao.getMemberSearch();
	}

	public boolean findMemberCount(String m_id) {
		if(m_id==null){
			throw new ServiceException("添加会员ID为空");
		}
		System.out.println("m_id==="+m_id);
		int row=dao.findMemberCount(m_id);
		System.out.println(row);
		if(row<1){
			return true;
		}
		return false;
	}

	public Member getMemberByIdAddTel(String id) {

		return dao.getMemberByIdAddTel(id);
	}

	public void updateDiscount(String type, String discount) {
		if(type==null){
			throw new ServiceException("修改折扣会员类型为空");
		}
		if(discount==null){
			throw new ServiceException("修改折扣为空");
		}
		int row=dao.updateDiscount(type, discount);
		if(row<1){
			throw new ServiceException("修改折扣失败");
		}
		
	}

	
}
