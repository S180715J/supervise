package com.newer.supervise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.supervise.mapper.UserMapper;
import com.newer.supervise.pojo.User;

/**
 * 用户服务层
 * 
 * @author 周裕杰
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询职位为公司领导的用户
	 * 
	 * @return
	 */
	public List<User> queryLeader() {
		return userMapper.queryLeaders();
	}
}
