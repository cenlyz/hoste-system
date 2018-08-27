package cn.lyz.hotle.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Sessioninterceptors implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("Staff");
		Object obj1=session.getAttribute("admin");
		System.out.println("obj="+obj);
		System.out.println("obj1="+obj1);
		if(obj==null && obj1==null){
			//没有登录，重定向到登录界面
			response.sendRedirect("toLogin.do");
			return false;
		}
		//登录了继续向后执行
		return true;
	}

}
