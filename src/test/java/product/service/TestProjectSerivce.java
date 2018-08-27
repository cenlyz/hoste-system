package product.service;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lyz.hotle.back.entity.Finance;
import cn.lyz.hotle.back.service.FinanceService;
import cn.lyz.hotle.back.service.StaffService;
import cn.lyz.hotle.login.entity.Staff;
import cn.lyz.hotle.login.service.StaffServiceLogin;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Member;
import cn.lyz.hotle.qt.entity.Room;
import cn.lyz.hotle.qt.service.BookService;
import cn.lyz.hotle.qt.service.KefangService;
import cn.lyz.hotle.qt.service.MemberService;


public class TestProjectSerivce {
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml");
	}
	
	@Test
	public void test1(){
		String ids="1,2,2,2,4,2,";
		     
	    String[] is=ids.split(",");
		System.out.println(is);
		for (int i = 0; i < is.length; i++) {
			System.out.println("id="+is[i]);
		}
	}
	
	
	@Test
	public void testFindYearMonth() throws Exception{
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		FinanceService s=ctx.getBean("financeServiceImpl",FinanceService.class);
		//执行ProjectService对象的findObjects方法
		s.findFinanceYearMonth(2016, 1);
		//验证结果是否正确
		//输出执行结果
	}
	
	@Test
	public void testBookCoint(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		BookService s=ctx.getBean("bookServiceImpl",BookService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		BookRoom b=new BookRoom();
		b.setBook_count(2);
		b.setBook_type("单人间");
		s.insertBook(b);
		//验证结果是否正确
		//输出执行结果
	}
	
	@Test
	public void testFinanceTime(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		FinanceService s=ctx.getBean("financeServiceImpl",FinanceService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Finance> list=s.findFinanceTime();
		//验证结果是否正确
		//输出执行结果
		System.out.println(list);
	}
	
	@Test
	public void testFinanceObjects(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		FinanceService s=ctx.getBean("financeServiceImpl",FinanceService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Finance> list=s.findFinanceList("2017", "12","");
		//验证结果是否正确
		//输出执行结果
		System.out.println(list);
	}
	
	@Test
	public void testStaffObjects(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		StaffService s=ctx.getBean("staffServiceImpl",StaffService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Staff> list=s.findStaffs();
		//验证结果是否正确
		//输出执行结果
		System.out.println(list);
	}
	
	@Test
	public void testfindPageObjects(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		MemberService s=ctx.getBean("memberServiceImpl",MemberService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		Map<String,Object> list=s.findPageObjects("", "", 1);
		//验证结果是否正确
		//输出执行结果
	}
	
	@Test
	public void testFindMemberObject(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		MemberService s=ctx.getBean("memberServiceImpl",MemberService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Member> list=s.findMemberObjects("禁用");
		//验证结果是否正确
		//输出执行结果
		System.out.println(list);
	}
	
	@Test
	public void testFindObject(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		StaffServiceLogin s=ctx.getBean("staffServiceLoginImpl",StaffServiceLogin.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		s.checkLogin("100101", "123456789");
		//验证结果是否正确
		//输出执行结果
	}
	@Test
	public void testBookRoonType(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		BookService s=ctx.getBean("bookServiceImpl",BookService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Room> book=s.findBookRoomType();
		//验证结果是否正确
		//输出执行结果
		for(Room r:book)
		System.out.println(r.getRoom_type());
	}
	
	@Test
	public void testRoomObjects(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		KefangService s=ctx.getBean("kefangServiceImpl",KefangService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Room> book=s.findRoomObjects("1F");
		//验证结果是否正确
		//输出执行结果
		for(Room r:book)
		System.out.println(r);
	}
	
	@Test
	public void testRoomSite(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		KefangService s=ctx.getBean("kefangServiceImpl",KefangService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		List<Room> book=s.findRoomSite();
		//验证结果是否正确
		//输出执行结果
		for(Room r:book)
		System.out.println(r.getRoom_site());
	}
	
	@Test
	public void findRoomById(){
		//获得ProjectService对象
		System.out.println("ctx="+ctx);
		KefangService s=ctx.getBean("kefangServiceImpl",KefangService.class);
		//执行ProjectService对象的findObjects方法
		System.out.println("s="+s);
		Room book=s.findRoomById(1);
		//验证结果是否正确
		//输出执行结果
		System.out.println(book);
	}
	
	
	
	
	
	@After
	public void destory(){
		ctx.close();
	}
	
}
