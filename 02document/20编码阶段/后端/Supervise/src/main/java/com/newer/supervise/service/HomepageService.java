package com.newer.supervise.service;
/**
 * 
 * @author Administrator
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.supervise.mapper.HomepageMapper;
import com.newer.supervise.pojo.Repository;


@Service(value="homepageservice")
public class HomepageService {
	
	@Autowired
	public HomepageMapper homepageMapper;
	
	public List<Repository> queryRecentUpdate(){
		return homepageMapper.queryRecentUpdate();
	}
	
	//分页查询最近更新
	public List<Repository> queryRecentUpdatePage(Integer page, Integer limit) {
		return homepageMapper.queryRecentUpdatepage((page-1)*limit, limit);
	}
	//查询推进中事项
	public List<Repository> querypropelling(){
		return homepageMapper.querypropelling();
	}
	
	//分页查询推进中事项
	public List<Repository> querypropellingpage(Integer page, Integer limit) {
		return homepageMapper.querypropellingpage((page-1)*limit, limit);
	}
	
	
	//查询推进中事项
		public List<Repository> queryFirst(){
			return homepageMapper.queryFirst();
		}
		
		//分页查询推进中事项
		public List<Repository> queryFirstpage(Integer page, Integer limit) {
			return homepageMapper.queryFirstpage((page-1)*limit, limit);
		}
	
}
