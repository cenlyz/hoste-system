package cn.lyz.hotle.qt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.back.dao.FinanceDao;
import cn.lyz.hotle.back.entity.Finance;
import cn.lyz.hotle.qt.dao.KefangDao;
import cn.lyz.hotle.qt.dao.MemberDao;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.service.KefangService;

@Service
public class KefangServiceImpl implements KefangService {
	@Resource(name="kefangDao")
	KefangDao kefangDao;
	@Resource(name="memberDao")
	MemberDao memberDao;
	
	@Resource(name="financeDao")
	FinanceDao financeDao;
	public List<Room> findRoomObjects(String site) {
		if(site==null){
			throw new RuntimeException("该楼层客房为空");
		}
		return kefangDao.findRoomObjects(site);
	}
	public List<Room> findRoomSite() {
		return kefangDao.findRoomSite();
	}
	public Room findRoomById(Integer id) {
		if(id==null){
			throw new RuntimeException("查询客房id为空");
		}
		return kefangDao.findRoomById(id);
	}
	public void insertCheck(Check check) {
		if(check==null){
			throw new RuntimeException("入住信息为空");
		}
		check.setCheck_in_time(new Date());
		int row=kefangDao.insertCheck(check);
		if(row<1){
			throw new RuntimeException("入住操作失败为空");
		}
		
		
	}
	public void updateRoom(String roomid) {
		if(roomid==null){
			throw new RuntimeException("修改客房号为空");
		}
		int row = kefangDao.updateRoom(roomid);
		if(row<1){
			throw new RuntimeException("客房状态更改失败");
		}
		
	}
	public Map<String,Object> findcheckByIdAndRoom(Integer id,String room_id) {
		if(room_id==null){
			throw new RuntimeException("查询客房信息客房号为空");
		}
		if(id==null){
			throw new RuntimeException("查询客房id为空");
		}
		Check check=kefangDao.findcheckByIdAndRoom(room_id);
		Room room=kefangDao.findRoomById(id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("check", check);
		map.put("room", room);
		
		return map;
	}
	public void updateRoomState(Integer id) {
		if(id==null){
			throw new RuntimeException("更新客房id为空");
		}
		int row=kefangDao.updateRoomState(id);
		if(row<1){
			throw new RuntimeException("客房状态更改失败");
		}
		
	}
	public Check updateChecktate(String room_id,String id) {
		if(room_id==null){
			throw new RuntimeException("修改客房号为空");
		}
		Double discount=1.0;
		Double price=0.0;
		Double m_integral=0.0;

		Check c=kefangDao.findChecktimeAndMoney(room_id);//查询入住时间 和入住的价格
		Double money = c.getRoom_price();
		Date time = c.getCheck_in_time();
		Date time1=new Date();
		//计算实际入住的天数
		int day =  (int) Math.ceil((time1.getTime()-time.getTime())/24/60/60/1000);
		double money1 = (day+1)*money;
		Finance f=new Finance();
		f.setType("客房");
		f.setMoney(money1+"");
		f.setTime(time1);
		Calendar cal = Calendar.getInstance();
		int day1 = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		f.setYear(year);
		f.setMonth(month);
		f.setDay(day1);
		financeDao.updateFinace(f);// 添加客房入住金额
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.format(time);
		Check CheckImpl=kefangDao.findcheckByIdAndRoom(room_id);//查询当前客房入住客人信息
		
	
		//判断会员金额是否充足
		int con=1;
		if(id!=null || id!=""){
			Member member = memberDao.getMemberByIdAddTel(id);
			discount=member.getM_discount();//获取会员的折扣
			price = member.getM_price();
			m_integral = member.getM_integral();
			if(price<(money1*discount)){
				CheckImpl.setRemarke("会员金额不足，会员抵扣金额 "+price+"元，还需支付金额 "+((money1*discount)-price)+"元，本次积分"+(int)((money1*discount)/10)+" 当前积分 "+(m_integral+(int)((money1*discount)/10)));
				con = memberDao.updatePriceById(id, 0.0, (m_integral+(int)((money1*discount)/10)));
			}
			if(price >=(money1*discount)){
				CheckImpl.setRemarke("会员抵扣金额 "+(money1*discount)+"元，剩余金额 "+(price-(money1*discount))+"元，本次积分"+(int)((money1*discount)/10)+" 当前积分 "+(m_integral+(int)((money1*discount)/10)));
				con = memberDao.updatePriceById(id, (price-(money1*discount)), (m_integral+(int)((money1*discount)/10)));
			}
			if(con <1){
				throw new RuntimeException("会员价格更新失败");
			}
		}
		CheckImpl.setCheck_price(money1*discount);//设置结算金额
		System.out.println("money1*discount=="+money1*discount);
		System.out.println(CheckImpl.getRemarke());
		CheckImpl.setRtime(formatter.format(time));//转化入住时间格式
		int row=kefangDao.updateChecktate(room_id, new Date());
		int row1=kefangDao.updateRoomIdState(room_id);
		if(row<1&&row1<1){
			throw new RuntimeException("退房失败");
		}
		return CheckImpl;
	}
	
	
	public Hotel findHotel() {
		
		return kefangDao.findHotel();
	}
	public List<Room> findRooms() {
		return kefangDao.findRooms();
	}
	public List<Room> findRoomsById(String room_id) {
		
		return kefangDao.findRoomsById(room_id);
	}
	public void insertRoom(Room room) {
		if(room==null){
			throw new RuntimeException("添加客房信息为空");
		}
		int row = kefangDao.insertRoom(room);
		if(row<1){
			throw new RuntimeException("客房信息添加失败");
		}
		
	}
	public void updateRoomById(Room room) {
		if(room==null){
			throw new RuntimeException("修改客房信息为空");
		}
		int row = kefangDao.updateRoomById(room);
		if(row<1){
			throw new RuntimeException("客房信息修改失败");
		}
	}
	public void roomDelById(Integer id) {
		if(id==null){
			throw new RuntimeException("删除客房id为空");
		}
		int row=kefangDao.roomDelById(id);
		if(row<1){
			throw new RuntimeException("客房信息删除失败");
		}
		
	}
	
	public BookRoom findRoomByRoomId(String room_id) {
		if(room_id==null){
			throw new RuntimeException("查看预定客人信息客房号为空");
		}
		return kefangDao.findRoomByRoomId(room_id);
	}
}
