package com.ssm.demo.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
public class User implements Serializable {

	private Integer id;
	private String userName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08")
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
