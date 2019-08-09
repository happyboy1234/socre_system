package com.irats.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.irats.pojo.User;
import com.irats.service.UserService;
import com.irats.utils.E3Result;
import com.irats.utils.RandomValidateCode;


/**
 * 登录Controller
 * @author IrAts
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Value("${SUPER_ADMIN}")
	private String SUPER_ADMIN;
	public static final String RANDOMCODEKEY = "randomcode_key";//放到session中验证码的key
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public E3Result toIndex(String username,String password,String ucheckcode,HttpSession session) {
		//判断验证码是否正确
		String checkCode = (String) session.getAttribute(RANDOMCODEKEY);
		if(!ucheckcode.toLowerCase().equals(checkCode.toLowerCase())) {
			return E3Result.build(201, "验证码错误");
		}
		E3Result e3Result = userService.login(username,password);
		//确认用户登录信息是否正确
		//正确
		if(e3Result.getStatus() == 200) {
			User user = (User) e3Result.getData();
			//如果不是管理员,直接返回失败
			if(user.getPower() == 0) {
				return E3Result.build(201, "登录失败,请联系管理员开通评分权限");
			}
			//是管理员,登陆成功,向session域中添加用户信息
			session.setAttribute("user", user);
			return e3Result;
		}
		return e3Result;
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/logout")
	public String exist(HttpSession session) {
		//session过期,重新登录
		if(session == null) {
			return "redirect:/admin";
		}
		//session不存在用户
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "redirect:/admin";
		}
		//退出登录
		if(user != null) {
			session.removeAttribute("user");
		}
		return "redirect:/admin";
	}
	
	/**
	 * AJAX检测用户名是否重复
	 * @param registername
	 * @return
	 */
	@RequestMapping("/user/checkname")
	@ResponseBody
	public E3Result checkName(String registername) {
		E3Result e3Result = E3Result.build(201, "出现未知错误");
		try {
			registername = new String(registername.getBytes("iso8859-1"),"utf-8");
			e3Result = userService.findUserByName(registername);
			if(e3Result.getData() != null) {
				return E3Result.build(201, "用户名已被占用");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return E3Result.build(201, "字符转换出现错误");
		}
		return e3Result;
	}

	
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/user/doRegister",method=RequestMethod.POST)
	@ResponseBody
	public E3Result register(String username,String password) {
		//再次检测用户名有没有被占用
		E3Result checkE3Result = checkName(username);
		if(checkE3Result.getStatus() != 200) {
			return checkE3Result;
		}
		
		//调用service注册用户
		E3Result e3Result = userService.addUser(username,password);
		//不管成功还是失败都返回
		return e3Result;
	}
	
	/**
	 * 获取用户列表
	 * 前端分页
	 * @param username
	 * @return
	 */
	@RequestMapping("/user/user-list")
	@ResponseBody
	public List<User> listUser(String username) {
		//对用户名重编码
		if(StringUtils.isNotBlank(username)) {
			try {
				username = new String(username.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		List<User> list = userService.getUserListPage(username);
		return list;
	}
	
	/**
	 * 删除用户
	 * @param usernames
	 * @return
	 */
	@RequestMapping("/user/deleteUser")
	@ResponseBody
	public E3Result deleteUser(String usernames) {
		E3Result e3Result = userService.deleteUser(usernames);
		return e3Result;
	}

	/**
	 * 修改用户权限
	 * @param username
	 * @param power
	 * @return
	 */
	@RequestMapping(value="/user/modifyUserPower",method=RequestMethod.POST)
	@ResponseBody
	public E3Result modifyUserPower(String username,String newpower,HttpSession session) {
		if(username.equals(SUPER_ADMIN)) {
			return E3Result.build(201, "您无权对"+ SUPER_ADMIN +"进行修改");
		}
		//不是管理员无权对权限进行修改
		User user = (User) session.getAttribute("user");
		if(user.getPower() != 1) {
			return E3Result.build(201, "您无权对用户权限进行修改");
		}
		//调用服务对权限进行修改
		int newpower_int = Integer.parseInt(newpower);
		E3Result e3Result = userService.changeUserPower(username,newpower_int);
		//修改成功后判断是否是修改自己
		if(user.getUsername().equals(username)) {
			//是则将数据更新并放回session
			user.setPower(newpower_int);
			session.setAttribute("user", user);
		}
		return e3Result;
	}
	
	/**
	 * 修改密码
	 * @param oldpassword
	 * @param newpassword
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/changePassword",method=RequestMethod.POST)
	@ResponseBody
	public E3Result changePassword(String oldpassword,String newpassword,HttpSession session) {
		User user = (User) session.getAttribute("user");
		/*if(user.getUsername().equals(SUPER_ADMIN)) {
			return E3Result.build(201, "无权修改Admin的密码");
		}*/
		//验证密码是否相同,匹配则可以改密码
		if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(oldpassword.getBytes()))) {
			//密码不匹配
			return E3Result.build(201, "原密码错误,不能修改密码!");
		}
		//匹配,将密码写入user
		user.setPassword(DigestUtils.md5DigestAsHex(newpassword.getBytes()));
		//调用服务修改密码
		userService.changeUserPassword(user);
		session.setAttribute("user", user);
		return E3Result.ok();
	}
	
	/**
	 * 修改用户名
	 * @param newusername
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/user/changeUsername",method=RequestMethod.POST)
	@ResponseBody
	public E3Result changeUsername(String newusername,String password,HttpSession session) {
		//获取用户信息
		User user = (User) session.getAttribute("user");
		//判断是否为超级管理员
		if(SUPER_ADMIN.equals(user.getUsername())) {
			return E3Result.build(201, "对不起,无法修改"+ SUPER_ADMIN +"的用户名");
		}
		//再次确认用户名未被占用
		E3Result checkE3Result = userService.findUserByName(newusername);
		if(checkE3Result.getData() != null) {
			//被占用,返回错误
			return E3Result.build(201, "用户名已被占用");
		}
		//未被占用,判断密码
		String prepassword = user.getPassword();
		try {
			//判断密码是否正确
			if(prepassword.equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
				//正确
				user.setUsername(newusername);
				userService.changeUsername(user);
				session.setAttribute("user", user);
				return E3Result.ok();
			}else {
				return E3Result.build(201, "密码错误!请重新输入");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return E3Result.build(201, "修改失败,请稍后再试");
	}
	
	
	@RequestMapping("/user/goto_edit")
	public String gotoEdit(String username,String power,HttpServletRequest request) {
		try {
			username = new String(username.getBytes("iso8859-1"), "utf-8");
			request.setAttribute("username", username);
			request.setAttribute("power", power);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "/score/editpage/power_edit";
	}
	
	
	/**
	 * 获取生成验证码显示到 UI 界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value="/user/checkCode")
	public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
		//设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
}
