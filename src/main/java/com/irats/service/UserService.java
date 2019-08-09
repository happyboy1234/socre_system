package com.irats.service;

import java.util.List;

import com.irats.pojo.User;
import com.irats.utils.E3Result;

public interface UserService {
	List<User> getUserListPage(String username);

	E3Result login(String username,String password);

	E3Result findUserByName(String registername);

	E3Result addUser(String username, String password);

	E3Result deleteUser(String usernames);

	E3Result changeUserPower(String username, int power);

	void changeUserPassword(User user);

	void changeUsername(User user);

}
