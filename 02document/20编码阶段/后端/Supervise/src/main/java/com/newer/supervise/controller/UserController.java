package com.newer.supervise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.pojo.User;
import com.newer.supervise.service.UserService;

/**
 * 用户类控制器
 * 
 * @author 周裕杰
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 将领导数据发送到页面
	 * 
	 * @return
	 */
	@GetMapping("/showLeader")
	public ResponseEntity<?> sendLeadersToPage(){
		List<User> leader = userService.queryLeader();
		if (!(leader.isEmpty())) {
			return new ResponseEntity<List<User>>(leader, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no_leader",HttpStatus.NO_CONTENT);
		}
	}
}
