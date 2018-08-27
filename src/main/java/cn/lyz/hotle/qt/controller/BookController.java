package cn.lyz.hotle.qt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.service.BookService;
import cn.lyz.hotle.web.JsonResult;

@Controller
@RequestMapping("/book/")
public class BookController {
	@Resource(name="bookServiceImpl")
	BookService book;
	
	
	@RequestMapping("doSaveBooks.do")
	@ResponseBody
	public JsonResult doSaveBook(BookRoom bookRoom){
		System.out.println(bookRoom);
		book.insertBook(bookRoom);
		return new JsonResult("Ô¤¶¨³É¹¦");
		
	}
	
	@RequestMapping("doBookType.do")
	@ResponseBody
	public JsonResult doBookType(){
		return new JsonResult(book.findBookRoomType());
		
	}
	
	
}
