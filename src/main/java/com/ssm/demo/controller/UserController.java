package com.ssm.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.demo.po.User;
import com.ssm.demo.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/insertUser")
	@ResponseBody
	public User insertUser(User user) {
		userService.saveUser(user);
		User resultUser = userService.findUserById(user.getId());		
		return resultUser;
	}
	
	/**
	 * @param startPage
	 * @param pageSize
	 * @return
	 * http://localhost:8080/pagehelper/getAllUser?startPage=2&pageSize=5
	 */
	@RequestMapping("/getAllUser")
	@ResponseBody
	public PageInfo<User> getAllUser(@RequestParam(required = false, defaultValue = "1") Integer startPage, @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
		//有一点一定要注意就是获取数据的代码一定是在调用startPage的下一行，才能进行有效的分页
		PageHelper.startPage(startPage, pageSize);
		List<User> userList = new ArrayList<>();
		userList = userService.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		return pageInfo;
	}
}
