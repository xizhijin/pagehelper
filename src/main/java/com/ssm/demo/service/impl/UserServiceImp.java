package com.ssm.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.demo.mapper.UserMapper;
import com.ssm.demo.po.User;
import com.ssm.demo.service.UserService;


@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Integer saveUser(User user) {
		return userMapper.saveUser(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}

}
