package com.irats.dao;

import java.util.List;

import com.irats.pojo.User;

public interface IUserDao {

	User selectUserByName(String username);

	void insertUser(User user);

	List<User> selectAllUser();

	List<User> getUserListPage(User user);

	void deleteUserById(String username);

	void updateUserPower(User user);

	void updateUserPassword(User user);

	void updateUsername(User user);

}
