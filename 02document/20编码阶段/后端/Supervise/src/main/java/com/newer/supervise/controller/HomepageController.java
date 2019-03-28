package com.newer.supervise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.service.HomepageService;

@RestController
public class HomepageController {

	@Resource(name = "homepageservice")
	private HomepageService homepageservice;
	
	@RequestMapping(value="/queryRecentUpdate",method=RequestMethod.GET)
	public ResponseEntity<?> queryRecentUpdate(){
		List<Repository> queryRecentUpdate = homepageservice.queryRecentUpdate();
		return  new ResponseEntity<>(queryRecentUpdate,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/queryRecentUpdatepage", method = RequestMethod.GET)
	public ResponseEntity<?> pages(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.queryRecentUpdatePage(page, limit));
		pages.setCount(homepageservice.queryRecentUpdate().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/querypropellingpage", method = RequestMethod.GET)
	public ResponseEntity<?> querypropellingpage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.querypropellingpage(page, limit));
		pages.setCount(homepageservice.querypropelling().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/queryFirstpage", method = RequestMethod.GET)
	public ResponseEntity<?> queryFirstpage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.queryFirstpage(page, limit));
		pages.setCount(homepageservice.queryFirst().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	
}
