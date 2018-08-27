package cn.lyz.hotle.qt.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.login.entity.Handover;
import cn.lyz.hotle.login.entity.Staff;
import cn.lyz.hotle.login.service.HandoverService;
import cn.lyz.hotle.qt.entity.Message;
import cn.lyz.hotle.qt.service.MessageService;
import cn.lyz.hotle.web.JsonResult;

@Controller
@RequestMapping("/handover/")
public class HandoverController {
	@Resource(name="handoverServiceImpl")
	private HandoverService hand;
	@Resource(name="messageServiceImpl")
	private MessageService messageService;
	
	@RequestMapping("handover.do")
	public String handover(){
		return "qt/qt_handover";
	}
	
	@RequestMapping("message.do")
	public String message(){
		return "qt/qt_message";
	}
	
	@RequestMapping("/gethandover.do")
	@ResponseBody
	public JsonResult gethandover(Handover handover){
		System.out.println("handover="+handover);
		hand.addHandover(handover);
		return new JsonResult("ok");
	}
	@RequestMapping("/setMessage.do")
	@ResponseBody
	public JsonResult setMessage(Message message,HttpSession session){
		Staff staff=(Staff) session.getAttribute("Staff");
		String name=staff.getName();
		String username=staff.getUsername();
		message.setName(name);
		message.setUsername(username);
		messageService.insertMessage(message);
		return new JsonResult("ok");
	}
	@RequestMapping("/geMessage.do")
	@ResponseBody
	public JsonResult geMessage(){
		return new JsonResult(messageService.findMessage());
	}
	
	
}
