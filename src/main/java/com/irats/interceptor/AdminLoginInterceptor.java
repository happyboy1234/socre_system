package com.irats.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.irats.pojo.User;

/**
 * 管理员登录拦截器
 * 拦截不是管理员又想混进来的鬼东西
 *
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取session对象
		HttpSession session = request.getSession();
		//从session中获取user对象
		User user = (User) session.getAttribute("user");
		//判断用户是否登录
		if(user == null) {
			//如果未登录,拦截;并且重定向到登录页面
			response.sendRedirect("/admin");
			return false;
		}
		//如果登录,判断是否为管理员
		//拦截非管理员!不配置这个的话,普通用户可以通过先登录,在复制地址访问后台页面
		if(user.getPower() == 0) {
			//当发现企图这样进来的时候,将其扔回查分页面
			//如果被发现你不是管理员还向进来,我就把session中的user清空
			session.removeAttribute("user");
			response.sendRedirect("/admin");
			return false;
		}
		if(user.getPower() == 1) {
			//为管理员:放行
			return true;
		}
		//未知原因:不放行
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
