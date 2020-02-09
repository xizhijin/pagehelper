package com.ssm.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ssm.demo.po.User;


public interface UserMapper {

	@Select("select * from tb_user2 where id = #{id}")
	User findUserById(Integer id);

	@Insert("insert into tb_user2(userName, birth) values(#{userName}, #{birth})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public Integer saveUser(User user);
	
	@Select("select * from tb_user2")
	public List<User> findAllUser();
}
