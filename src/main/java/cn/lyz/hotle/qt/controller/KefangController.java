package cn.lyz.hotle.qt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.service.KefangService;
import cn.lyz.hotle.qt.service.MemberService;
import cn.lyz.hotle.web.JsonResult;

@Controller
@RequestMapping("/kefang/")
public class KefangController {
	
	@Resource(name="kefangServiceImpl")
	KefangService kefang;
	@Resource(name="memberServiceImpl")
	MemberService memberService;
	
	
	@RequestMapping("doRoomSite.do")
	@ResponseBody
	public JsonResult doRoomSite(){
		return new JsonResult(kefang.findRoomSite());
	}
	
	@RequestMapping("doRoomType.do")
	@ResponseBody
	public JsonResult doRoomType(String room_site){
		return new JsonResult(kefang.findRoomObjects(room_site));
	}
	
	@RequestMapping("shuUI.do")
	@ResponseBody
	public JsonResult shuUI(Integer id){
		
		return new JsonResult(kefang.findRoomById(id));
	}
	
	@RequestMapping("yuding.do")
	@ResponseBody
	public JsonResult yuding(String RoomId){
		System.out.println(kefang.findRoomByRoomId(RoomId));
		return new JsonResult(kefang.findRoomByRoomId(RoomId));
	}
	
	
	@RequestMapping("editUI.do")
	public String editUI(){
		return "qt/qt_kefang_mo";
	}
	
	@RequestMapping("receipt.do")
	public String receipt(String room_id,String id,HttpServletRequest request){
		Check check=kefang.updateChecktate(room_id,id);
		Hotel hotel=kefang.findHotel();
		//添加判断入住类型
		request.setAttribute("hotel", hotel);
		request.setAttribute("check", check);
		return "qt/qt_check_receipt";
	}
	
	@RequestMapping("ruzhu.do")
	@ResponseBody
	public JsonResult ruzhu(Check check){
		kefang.insertCheck(check);
		kefang.updateRoom(check.getRoom_id());
		return new JsonResult("操作成功");
	}
	
	@RequestMapping("dokefangInRoom.do")
	@ResponseBody
	public JsonResult dokefangInRoom(String room_id,Integer id ){
		return new JsonResult(kefang.findcheckByIdAndRoom(id,room_id));
	}
	
	@RequestMapping("doKefangRoomState.do")
	@ResponseBody
	public JsonResult doKefangRoomState(Integer id ){
		kefang.updateRoomState(id);
		return new JsonResult("客房状态更新成功");
	}
	
	@RequestMapping("getmember.do")
	@ResponseBody
	public JsonResult getmember(String id ){
		if(id==null || id==""){
			return new JsonResult("idnull");
		}
		Member m=memberService.getMemberByIdAddTel(id);
		return new JsonResult(m);
	}
	
	
	
	
	
	
}
