package com.newer.supervise.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.Organization;
import com.newer.supervise.service.OrgService;

@RestController
public class OrgController {

	@Autowired
	private OrgService orgservice;
	

	/**
	 * 分页查询机构信息
	 * 
	 * @return
	 */
	@GetMapping("/orgPaging")
	public ResponseEntity<?> getorg(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
		List<Organization> list = orgservice.getorg(page, limit);
		if (!(list.size() == 0 || list.isEmpty())) {
			Page<Organization> orgPage = new Page<Organization>();
			orgPage.setCode(0);
			orgPage.setCount(orgservice.getCount());
			orgPage.setData(list);
			return new ResponseEntity<Page<Organization>>(orgPage, HttpStatus.OK);
		}
		return new ResponseEntity<>("no_org", HttpStatus.OK);
	}
	

	/**
	 * 按orgid查询对应机构的所有信息
	 */
	@GetMapping("/org/{orgid}")
	public ResponseEntity<?> getorgID(@PathVariable("orgid") Integer orgid) {
		Organization org = orgservice.getorgID(orgid);
		if (org != null) {
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no_org", HttpStatus.NO_CONTENT);
	}
	

	/**
	 * 新增机构
	 * 
	 * @param org
	 * @return
	 */
	@PostMapping("/insertorg")
	public ResponseEntity<?> insertorg(@RequestBody Organization org) {
		if (org != null) {
			org.setOperationDate(new Date());
			Integer i = orgservice.insertorg(org);
			if (i > 0) {
				return new ResponseEntity<String>("added", HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<String>("failed", HttpStatus.OK);
	}
	

	/**
	 * 删除部门信息
	 * 
	 * @param orgid
	 * @return
	 */
	@DeleteMapping("/delete/{orgid}")
	public ResponseEntity<?> delorg(@PathVariable("orgid") Integer orgid) {
		Integer i = orgservice.delorg(orgid);
		if (i > 0) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
		return new ResponseEntity<>("file", HttpStatus.EXPECTATION_FAILED);
	}
	

	/**
	 * 更新部门信息
	 * 
	 * @param org
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<?> uporg(@RequestBody Organization org) {
		if (org != null) {
			Integer uporg = orgservice.uporg(org);
			if (uporg > 0) {
				return new ResponseEntity<String>("updated", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("failed", HttpStatus.PRECONDITION_FAILED);
	}
	

	/**
	 * 将机构路径发送至页面
	 * 
	 * @return
	 */
	@GetMapping("org")
	public ResponseEntity<?> sendParentPathToPage() {
		List<Organization> parentPath = orgservice.queryParentPath();
		if (parentPath.isEmpty()) {
			return new ResponseEntity<String>("no_path", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Organization>>(parentPath, HttpStatus.OK);
	}
}
