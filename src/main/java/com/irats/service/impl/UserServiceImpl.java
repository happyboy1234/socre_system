package com.irats.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.irats.dao.IUserDao;
import com.irats.pojo.User;
import com.irats.service.UserService;
import com.irats.utils.E3Result;

/**
 * 用户处理Service
 * @author IrAts
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserDao userdao;
	@Value("${SUPER_ADMIN}")
	private String SUPER_ADMIN;

	/**
	 * 登录
	 */
	@Override
	public E3Result login(String username, String password) {
		//调取dao层获取用户信息
		User user = userdao.selectUserByName(username);
		//判断用户是否存在
		//不存在
		if(user == null) {
			return E3Result.build(201, "用户名不存在");
		}
		//用户名存在则判断密码是否正确
		if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			//密码不匹配
			return E3Result.build(201, "密码错误,请检查用户名或密码");
		}
		//用户明和密码均正确
		//返回正确
		return E3Result.ok(user);
	}

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public E3Result findUserByName(String username) {
		User user = userdao.selectUserByName(username);
		return E3Result.ok(user);
	}

	/**
	 * 注册
	 */
	@Override
	public E3Result addUser(String username, String password) {
		//新建用户
		User user = new User();
		//密码加密
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		//补全属性
		user.setPassword(md5Password);
		user.setUsername(username);
		//权限: 0:学生 1:老师(管理员)
		//一般注册时默认为0
		user.setPower(0);
		//调用dao层实现数据插入
		userdao.insertUser(user);
		if(user.getId() > 0) {
			//插入成功
			//返回成功
			return E3Result.ok(user);
		}
		//插入失败
		return E3Result.build(201, "网络出现问题,请检查您的网络");
		
	}

	/**
	 * 获取用户列表
	 */
	@Override
	public List<User> getUserListPage(String username) {
		User user = new User();
		user.setUsername(username);
		List<User> list = userdao.getUserListPage(user);
		return list;
	}

	@Override
	public E3Result deleteUser(String ids) {
		String[] usernames = ids.split(",");
		E3Result e3Result = E3Result.ok();
		for (String username : usernames) {
			//无法删除该用户
			if(!username.equals(SUPER_ADMIN)) {
				userdao.deleteUserById(username);
			}else {
				e3Result = E3Result.build(201,"只删除了" + SUPER_ADMIN + "以外的用户,您无权删除" + SUPER_ADMIN);
			}
		}
		return e3Result;
	}

	@Override
	public E3Result changeUserPower(String username, int power) {
		User user = new User();
		user.setUsername(username);
		user.setPower(power);
		userdao.updateUserPower(user);
		return E3Result.ok();
	}

	@Override
	public void changeUserPassword(User user) {
		userdao.updateUserPassword(user);
		
	}

	@Override
	public void changeUsername(User user) {
		userdao.updateUsername(user);
	}


}
