package cn.lyz.hotle.back.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.back.service.StaffService;
import cn.lyz.hotle.login.entity.Staff;
import cn.lyz.hotle.web.JsonResult;

@Controller
public class StaffController {
	@Resource(name="staffServiceImpl")
	StaffService service;
	
	@RequestMapping("getStaffsList.do")
	@ResponseBody
	public JsonResult getStaffsList(){
		List<Staff> list=service.findStaffs();
		return new JsonResult(list);
	}
	@RequestMapping("getStaffsUsername.do")
	@ResponseBody
	public JsonResult getStaffsUsername(String username){
		System.out.println(username);
		return new JsonResult(service.findUserName(username));
	}
	
	@RequestMapping("staffAdd.do")
	@ResponseBody
	public JsonResult staffAdd(Staff staff){
		service.insertStaff(staff);
		return new JsonResult("ok");
	}
	@RequestMapping("StaffDelId.do")
	@ResponseBody
	public JsonResult StaffDelId(Integer id){
		service.staffDelId(id);
		return new JsonResult("ok");
	}
	
	@RequestMapping("AllStaffById.do")
	@ResponseBody
	public JsonResult AllStaffById(String ids){
		String[] is=ids.split(",");
		System.out.println(is);
		service.staffDelIds(is);
		return new JsonResult("ok");
	}
	
	
	@RequestMapping("staffEdit.do")
	@ResponseBody
	public JsonResult staffEdit(Staff staff){
		System.out.println("staff="+staff);
		service.editStaff(staff);
		return new JsonResult("ok");
	}
	
	
}
