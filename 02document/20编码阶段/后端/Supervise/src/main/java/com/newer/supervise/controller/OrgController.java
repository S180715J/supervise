package com.supervise.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supervise.pojo.Organization;
import com.supervise.service.OrgService;

@RestController
public class OrgController {
	@Autowired
	private OrgService orgservice;
	/**
	 * 查询所有部门信息
	 * @return
	 */
	@GetMapping("/org")
	public ResponseEntity<?> getorg(){
		List<Organization> org=orgservice.getorg();
		if(org.size()==0) {
			return new ResponseEntity<>("0",HttpStatus.OK);
		}
		return new ResponseEntity<List<Organization>>(org,HttpStatus.OK);
	}
	/**
	 * 按orgid查询所有信息
	 */
	@GetMapping("/org/{orgid}")
	public ResponseEntity<?> getorgID(@PathVariable("orgid")Integer orgid){
		int org=orgservice.getorgID(orgid);
		return new ResponseEntity<>(org,HttpStatus.OK);
	}
	/**
	 * 新增部门信息
	 * @param org
	 * @return
	 */
	@PostMapping("/insertorg")
	public ResponseEntity<?> insertorg(@RequestBody Organization org){
		int i=orgservice.insertorg(org);
		return new ResponseEntity<>(i,HttpStatus.OK);
	}
	/**
	 * 删除部门信息
	 * @param orgid
	 * @return
	 */
	@DeleteMapping("/delete/{orgid}")
	public ResponseEntity<?> delorg(@PathVariable("orgid")Integer orgid){
		int i=orgservice.delorg(orgid);
		if(i>0) {
			return new ResponseEntity<>("ok",HttpStatus.OK );
		}
		return new ResponseEntity<>("file",HttpStatus.EXPECTATION_FAILED);
	}
	@PutMapping("/update")
	public ResponseEntity<?> uporg(@RequestBody Organization org){
		int i=orgservice.uporg(org);
		return new ResponseEntity<>(i,HttpStatus.OK );
	}
} 
