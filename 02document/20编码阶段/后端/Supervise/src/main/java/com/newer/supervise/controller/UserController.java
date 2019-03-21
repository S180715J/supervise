package com.newer.supervise.controller;

import java.util.List;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.Duty;
import com.newer.supervise.pojo.Education;
import com.newer.supervise.pojo.User;

import com.newer.supervise.service.UserService;
import com.newer.supervise.utils.JwtTokenUtil;

/**
 * 用户类控制器
 * 
 * @author 谢灿
 *
 */
@RestController
@RequestMapping("/user")
public class Usercontroller {

	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private JwtTokenUtil jwtToken;
	@Resource(name = "userservice")
	private UserService userService;
	

	/**
	 * 登录验证
	 * 
	 * @param admins
	 * @return
	 */
	@RequestMapping(value = "/logins", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user) {
		log.info("用户输入账号：{}，密码：{}................", user.getUserName(), user.getPassword());
		User user2 = userService.findUsernamAndpwd(user);
		if (user2 != null) {
			// 创建JWT
			String token = jwtToken.createJwt(user);
			log.info("token:" + token);
			log.info("token创建成功" + token);
			log.info("token创建成功" + user2.getUserName());
			return new ResponseEntity<User>(user2, HttpStatus.OK);
		} else {
			log.error("生成token失败");
			return new ResponseEntity<String>("0", HttpStatus.OK);
		}

	}

	/**
	 * 显示所有用户信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<?> pages(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		log.info("开始加载数据.............." );
		Page<User> pages = new Page<User>();
		pages.setCode(0);
		pages.setData(userService.userPage(page, limit));
		pages.setCount(userService.queryUsers().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	/**
	 * 显示单个用户信息
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping(value="/queryuser/{uid}",method=RequestMethod.GET)
	public ResponseEntity<?> queryEmpId(@PathVariable("uid") Integer uid) {
		log.info("开始查询单个员工对象，编号为{}...............", uid);
		User queryUser = userService.queryUser(uid);
		return new ResponseEntity<User>(queryUser, HttpStatus.OK);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/saveuser" ,method=RequestMethod.PUT)
	public ResponseEntity<?> addEmp(@RequestBody User user) {
		log.info("开始创建员工对象，编号为{}...............", user.getUserName());
		Integer userId = user.getUserId();
		User queryUser = userService.queryUser(userId);
		if (queryUser != null) {
			// 用户已存在
			log.info("员工对象创建失败:系统中已存在该编号{}的员工", queryUser.getUserId());
			return new ResponseEntity<>("Not Found:" + userId, HttpStatus.NOT_FOUND);
		}
		/*user.setOptTime(new Date());*/
		int insertUser = userService.InsertUser(user);
		if (insertUser > 0) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmp(@RequestBody User user) {
		log.info("开始修改用户对象，编号为{}...............", user.getUserId());
		Integer userId = user.getUserId();
		User queryUser = userService.queryUser(userId);
		if (queryUser == null) {
			return new ResponseEntity<>("Not Found:" + userId, HttpStatus.NOT_FOUND);
		}
		Integer updateUser = userService.updateUser(queryUser);
		log.info("{}员工修改成功", updateUser);
		if (updateUser > 0) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	/**
	 * 删除用户
	 * 
	 * @param empno
	 * @return
	 */
	@RequestMapping(value = { "deleteuser/{uid}" }, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmp(@PathVariable("uid") Integer uid) {
		log.info("开始删除编号为{}的员工................", uid);
		User queryUser = userService.queryUser(uid);
		log.info("要删除员工为{}的员工................", queryUser);
		if (queryUser == null) {
			
			return new ResponseEntity<>("Not Found:" + uid, HttpStatus.NOT_FOUND);
		}
		Integer deleteUser = userService.deleteUser(uid);
		return new ResponseEntity<String>(deleteUser > 0 ? "ok" : "nodata", HttpStatus.OK);
	}


	@RequestMapping(value = "/duty", method = RequestMethod.GET)
	public ResponseEntity<?> queryDuty() {
		log.info("开始加载职务信息.............." );		
		List<Duty> queryDuty = userService.queryDuty();
		return new ResponseEntity<>(queryDuty, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/education", method = RequestMethod.GET)
	public ResponseEntity<?> queryEducation() {
		log.info("开始加载学历信息.............." );
		List<Education> queryEducation = userService.queryEducation();
		return new ResponseEntity<>(queryEducation, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/duty/{dutyId}", method = RequestMethod.GET)
	public ResponseEntity<?> findDuty(@PathVariable ("dutyId") Integer dutyId) {
		log.info("开始加载职称信息.............." );
		Duty findDuty = userService.findDuty(dutyId);
		return new ResponseEntity<>(findDuty, HttpStatus.OK);

	}
	
}
