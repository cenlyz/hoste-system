package cn.lyz.hotle.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.back.entity.Finance;
import cn.lyz.hotle.back.service.FinanceService;
import cn.lyz.hotle.web.JsonResult;

@Controller
public class FinanceController {
	@Resource(name="financeServiceImpl")
	FinanceService service;
	
	@RequestMapping("getMoneyList.do")
	@ResponseBody
	public JsonResult getMoneyList(String year, String month, String day){
		System.out.println(year+"=="+month+"=="+day);
		List<Finance> list=service.findFinanceList(year, month, day);
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@RequestMapping("getMoneyTime.do")
	@ResponseBody
	public JsonResult getMoneyTime(){
		List<Finance> list=service.findFinanceTime();
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@RequestMapping("getMoneyMonth.do")
	@ResponseBody
	public JsonResult getMoneyMonth(Integer year){
		List<Finance> list=service.findFinanceMonth(year);
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@RequestMapping("getYearMonth.do")
	@ResponseBody
	public JsonResult getYearMonth(Integer year , Integer month) throws Exception{
		List<Finance> list=service.findFinanceYearMonth(year, month);
		System.out.println(list);
		return new JsonResult(list);
	}
}
