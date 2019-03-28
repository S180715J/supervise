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

@Service(value = "homepageservice")
public class HomepageService {

	@Autowired
	public HomepageMapper homepageMapper;

	public List<Repository> queryRecentUpdate() {
		return homepageMapper.queryRecentUpdate();
	}

	// 分页查询最近更新
	public List<Repository> queryRecentUpdatePage(Integer page, Integer limit) {
		return homepageMapper.queryRecentUpdatepage((page - 1) * limit, limit);
	}

	// 查询推进中事项
	public List<Repository> querypropelling() {
		return homepageMapper.querypropelling();
	}

	// 分页查询推进中事项
	public List<Repository> querypropellingpage(Integer page, Integer limit) {
		return homepageMapper.querypropellingpage((page - 1) * limit, limit);
	}

	// 查询推进中事项
	public List<Repository> queryFirst() {
		return homepageMapper.queryFirst();
	}

	// 分页查询推进中事项
	public List<Repository> queryFirstpage(Integer page, Integer limit) {
		return homepageMapper.queryFirstpage((page - 1) * limit, limit);
	}

	/**
	 * 根据事项id查出对应事项的详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Repository queryRespositoryById(Integer id) {
		return homepageMapper.queryRespositoryById(id);
	}

	/**
	 * 根据事项id回显员工所查看的事项
	 * 
	 * @param id
	 * @return
	 */
	public Repository queryEmpRepository(Integer id) {
		return homepageMapper.queryEmpRepository(id);
	}

	/**
	 * 根据事项id回显督办员所查看的数据
	 * 
	 * @param id
	 * @return
	 */
	public Repository querySupRepository(Integer id) {
		return homepageMapper.querySupRepository(id);
	}

	/**
	 * 查询原件信息用于页面回显(督办员查看)
	 * 
	 * @param id
	 * @return
	 */
	public Repository querySourceFileInfo(Integer id) {
		return homepageMapper.querySourceFileInfo(id);
	}

	/**
	 * 根据事项id查询对应事项的原件信息，用于回显给领导页面查看
	 * 
	 * @param id
	 * @return
	 */
	public Repository queryLeadSourceFileInfo(Integer id) {
		return homepageMapper.queryLeadSourceFileInfo(id);
	}

	/**
	 * 根据事项id回显督办员待办任务
	 * 
	 * @param id
	 * @return
	 */
	public Repository queryWaitTask(Integer id) {
		return homepageMapper.queryWaitTask(id);
	}

}
