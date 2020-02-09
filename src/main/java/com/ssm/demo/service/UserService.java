package com.ssm.demo.service;

import java.util.List;

import com.ssm.demo.po.User;

public interface UserService {

	User findUserById(Integer id);

	Integer saveUser(User user);
	
	List<User> findAllUser();
}
