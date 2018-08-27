package cn.lyz.hotle.login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lyz.hotle.login.entity.Admin;
import cn.lyz.hotle.login.entity.Handover;
import cn.lyz.hotle.login.entity.Staff;
import cn.lyz.hotle.login.service.AdminService;
import cn.lyz.hotle.login.service.HandoverService;
import cn.lyz.hotle.login.service.StaffServiceLogin;
import cn.lyz.hotle.web.JsonResult;

@Controller
public class LoginController {
	
	@Resource(name="staffServiceLoginImpl")
	private StaffServiceLogin loginImpl;
	@Resource(name="adminServiceImpl")
	private AdminService service;
	@Resource(name="handoverServiceImpl")
	private HandoverService hand;
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/qt_index.do")
	public String qt_index(){
		return "qt_index";
	}
	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
//		String number1=request.getParameter("number");
//		String number2=(String)session.getAttribute("number");
//		if(!number1.equals(number2)){
//			request.setAttribute("yan", "验证码不正确");
//			return "login";
//		}
		
		//将登录处理分发给业务层的对象来处理
		String str=loginImpl.checkLogin(id, pwd);
		if("username".equals(str)){
			request.setAttribute("state", "用户名不存在");
			return "login";
		}
		if("password".equals(str)){
			request.setAttribute("state", "密码错误，请重新输入");
			return "login";
		}
		session.setAttribute("Staff", loginImpl.checkLoginStaff(id));
		//登录成功，重定向到首页
		return "redirect:qt_index.do";
	}
	
	@RequestMapping("/book.do")
	public String book(HttpServletRequest request){
		request.setAttribute("aherf", "预定");
		return "qt/qt_book";
	}
	
	@RequestMapping("/kefang.do")
	public String kefang(HttpServletRequest request){
		request.setAttribute("aherf", "客房");
		return "qt/qt_kefang";
	}
	
	@RequestMapping("/index.do")
	@ResponseBody
	public JsonResult index(String username,String password,String code,HttpSession session){
		String state=service.findAdminByUserName(username, password);
		String number2=(String)session.getAttribute("number");
		if(code==null){
			return new JsonResult("code");
		}
		if(!code.equals(number2)){
			return new JsonResult("number");
		}
	    if("username".equals(state)){
			return new JsonResult("username");
		}else if("password".equals(state)){
			return new JsonResult("password");
		}
		Admin admin= service.findAdmin(username);
		session.setAttribute("admin", admin);
		return new JsonResult("ok");
		
	}
	@RequestMapping("/userAddOrEdit.do")
	@ResponseBody
	public JsonResult userAddOrEdit(Admin admin,HttpSession session){
		String state=service.updateAdminUser(admin);
		admin= service.findAdmin(admin.getUsername());
		session.setAttribute("admin", admin);
		return new JsonResult(state);
	}
	@RequestMapping("/changePwd.do")
	@ResponseBody
	public JsonResult changePwd(String password,String username,HttpSession session){
		String state=service.changePwd(password, username);
		Admin admin= service.findAdmin(username);
		session.setAttribute("admin", admin);
		return new JsonResult(state);
	}
	
	@RequestMapping("/findPwd.do")
	@ResponseBody
	public JsonResult findPwd(String password,String username){
		String state=service.changePwd(password, username);
		return new JsonResult(state);
	}
	
	@RequestMapping("/find_pw.do")
	public String find_pw(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("id");
		String number_id=request.getParameter("number_id");
		String pwd=request.getParameter("pw");
		
		Admin admin=new Admin();
		admin=service.findByUsername(username);
		String number2=(String)session.getAttribute("number");
		
		if(admin==null){
			request.setAttribute("state", "该帐号不存在");
			return "find_pw";
			
		}
		if(!number_id.equals(number2)){
			request.setAttribute("state", "验证码有误");
			return "find_pw";
		}
		admin.setPassword(pwd);
		service.changePwd(pwd, admin.getUsername());
		request.setAttribute("state", "密码修改成功");
		return "find_pw";
	}
	
	

	@RequestMapping("/findpw.do")
	public String findpw(){
		return "findpw";
	}
			
	@RequestMapping("/findpwjsp.do")
	public String findpwjsp(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("id");
		String number_id=request.getParameter("number_id");
		String pwd=request.getParameter("pw");
		Staff staff=loginImpl.findByUsername(username);
		String number2=(String)session.getAttribute("number");
		if(staff==null){
			request.setAttribute("state", "该帐号不存在");
			return "findpw";
			
		}
		if(!number_id.equals(number2)){
			request.setAttribute("state", "验证码有误");
			return "findpw";
		}
		loginImpl.changePwd(pwd, staff.getId());
		request.setAttribute("state", "密码修改成功");
		return "findpw";
	}
	
	
	
	/**
	 * 用来输出验证码图片
	 * @throws IOException 
	 */
	@RequestMapping("/checkcode.do")
	public void checkcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/**
		 * 绘图 
		 */
		//先创建一个画布（内存映像对象）
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g=image.getGraphics();
		//给画笔设置颜色
		g.setColor(new Color(255,255,255));
		//给画布设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//给画笔设置颜色
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//设置字体   (字体 风格 大小)
		g.setFont(new Font(null, Font.BOLD|Font.ITALIC, 20));
		//在画布上绘图
		String number="";
		for(int i=0;i<5;i++){
			if(r.nextInt(10)%3==0){
				number +=(char) (Math.random() * 26 +'A')+"";
			}else if(r.nextInt(10)%3==1){
				number +=(char) (Math.random() * 26 +'a')+"";
			}else{
				number +=r.nextInt(10)+"";
			}
		}
		//将验证码绑定到session对象
		HttpSession session=request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 5, 25);
		//加干扰线
		for(int i=0;i<8;i++){
			 g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			 g.drawLine(r.nextInt(80),r.nextInt(80),r.nextInt(30), r.nextInt(30));
		 }
		/**
		 * 将图片压缩，然后输出
		 */
		//设置content-type
		response.setContentType("image/jpeg");
		//获得字节输出流（图片是二进制数据）
		OutputStream os=response.getOutputStream();
		//将原始图片（image）按照指定算法压缩(ipeg)
		//然后将压缩之后得到的字节写入response对象
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
		
	}
	
}
	
	
	




