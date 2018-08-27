package cn.lyz.hotle.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.entity.Vip;
import cn.lyz.hotle.qt.service.KefangService;
import cn.lyz.hotle.qt.service.MemberService;
import cn.lyz.hotle.web.JsonResult;

@Controller

public class MainControoler {
	@Resource(name="kefangServiceImpl")
	KefangService kefang;
	@Resource(name="memberServiceImpl")
	MemberService memberService;
	
	@RequestMapping("mainBack.do")
	public String mainBack(){
		return "admin/index";
	}
	@RequestMapping("roomList.do")
	@ResponseBody
	public JsonResult roomList(){
		List<Room> room=kefang.findRooms();
		return new JsonResult(room);
	}
	
	@RequestMapping("getroomIdList.do")
	@ResponseBody
	public JsonResult getroomIdList(String room_id){
		List<Room> room=kefang.findRoomsById(room_id);
		return new JsonResult(room);
	}
	
	@RequestMapping("roomAdd.do")
	@ResponseBody
	public JsonResult roomAdd(Room room){
		kefang.insertRoom(room);
		return new JsonResult("ok");
	}
	@RequestMapping("roomEdit.do")
	@ResponseBody
	public JsonResult roomEdit(Room room){
		kefang.updateRoomById(room);
		return new JsonResult("ok");
	}
	
	@RequestMapping("roomDel.do")
	@ResponseBody
	public JsonResult roomDel(Integer id){
		System.out.println("id=="+id);
		kefang.roomDelById(id);
		return new JsonResult("ok");
	}
	
	@RequestMapping("queryMainView.do")
	@ResponseBody
	public JsonResult queryMainView(){
		List<Vip> list=memberService.getMemberSearch();
		return new JsonResult(list);
	}
	
}















