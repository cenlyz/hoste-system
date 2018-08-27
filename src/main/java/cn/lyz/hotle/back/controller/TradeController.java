package cn.lyz.hotle.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.back.entity.Trade;
import cn.lyz.hotle.back.service.TradeService;
import cn.lyz.hotle.web.JsonResult;

@Controller
public class TradeController {
	@Resource(name="tradeServiceImpl")
	TradeService service;
	
	@RequestMapping("getTradesList.do")
	@ResponseBody
	public JsonResult getTradesList(){
		List<Trade> list=service.findTradeObjects();
		return new JsonResult(list);
	}
	
	@RequestMapping("getTradesListById.do")
	@ResponseBody
	public JsonResult getTradesListById(String goods_id){
		System.out.println("====="+goods_id);
		List<Trade> list=service.findTradeByIdObjects(goods_id);
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@RequestMapping("goodsAdd.do")
	@ResponseBody
	public JsonResult goodsAdd(Trade trade){
		service.addGoods(trade);
		return new JsonResult("ok");
	}
	
	@RequestMapping("goodsEdit.do")
	@ResponseBody
	public JsonResult goodsEdit(Trade trade){
		service.editGoods(trade);
		return new JsonResult("ok");
	}
	
	@RequestMapping("delGoodsById.do")
	@ResponseBody
	public JsonResult delGoodsById(Integer id){
		service.delGoodsById(id);
		return new JsonResult("ok");
	}
	
	
	
	
	
}
