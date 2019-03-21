package com.newer.supervise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.supervise.mapper.UserMapper;
import com.newer.supervise.pojo.Duty;
import com.newer.supervise.pojo.Education;
import com.newer.supervise.pojo.User;

/**
 * 
 * @author 谢灿
 *
 */
@Service(value = "userservice")
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	public User findUsernamAndpwd(User user) {
		return userMapper.findUsernamAndpwd(user);
	}

	/**
	 * 判断用户是否已被注册
	 * 
	 * @param username
	 * @return true：用户名可用。false：用户名不可用。
	 */
	public User checkUserName(String username) {
		User findUserName = userMapper.findUsername(username);
		return findUserName;
	}

	/**
	 * 注册
	 * 
	 * @param user
	 *            保存用户名和密码
	 */
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
	public int saveUser(User user) {
		return userMapper.saveUser(user);
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<User> queryUsers() {
		return userMapper.queryUsers();
	}

	// 查询所有用户信息(分页)
	public List<User> userPage(Integer page, Integer limit) {
		return userMapper.userPage((page-1)*limit, limit);
	}

	/**
	 * 查询单个用户
	 * 
	 * @return
	 */
	public User queryUser(Integer uid) {
		return userMapper.queryUser(uid);
	}

	//修改
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
	public int  updateUser(User user){
		return userMapper.updateUser(user);
	}
	
	//删除
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
	public int deleteUser(Integer uid) {
		return userMapper.deleteUser(uid);
	}
	
	//添加
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED) // Propagation事务传播行为
	public int InsertUser(User user) {
		return userMapper.InsertUser(user);
	}
	
	
	public List<Duty> queryDuty(){
		return userMapper.queryDuty();
	}
	
	
	public List<Education> queryEducation(){
		return userMapper.queryEducation();
	}
	
	public Duty findDuty(Integer dutyId) {
		return userMapper.findDuty(dutyId);
	}
	
}
