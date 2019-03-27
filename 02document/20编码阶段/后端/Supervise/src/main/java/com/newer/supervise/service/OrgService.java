package com.newer.supervise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.supervise.mapper.OrgMapper;
import com.newer.supervise.pojo.Organization;
import com.newer.supervise.pojo.User;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000)
public class OrgService {

	@Autowired
	private OrgMapper orgmapper;

	/**
	 * 分页查询当前页面的部门信息
	 * 
	 * @param limit 查询条数
	 * @param page  当前页码
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = true)
	public List<Organization> getorg(Integer page, Integer limit) {
		return orgmapper.getorg((page - 1) * limit, limit);
	}

	/**
	 * 按orgid查询对应部门的所有信息
	 * 
	 * @param orgid
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = true)
	public Organization getorgID(Integer orgid) {
		return orgmapper.getorgID(orgid);
	}

	/**
	 * 新增部门
	 * 
	 * @param org
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = false)
	public Integer insertorg(Organization org) {
		return orgmapper.insertorg(org);
	}

	/**
	 * 根据id删除部门信息
	 * 
	 * @param orgid
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = false)
	public Integer delorg(Integer orgid) {
		return orgmapper.delorg(orgid);
	}

	/**
	 * 修改部门信息
	 * 
	 * @param org
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = false)
	public Integer uporg(Organization org) {
		return orgmapper.uporg(org);
	}

	/**
	 * 查询部门总数
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = true)
	public Integer getCount() {
		return orgmapper.queryCountOfDept();
	}

	/**
	 * 查询部门路径信息
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5000, readOnly = true)
	public List<Organization> queryParentPath() {
		return orgmapper.queryParentPath();
	}

	/**
	 * 查询所有的部门名称用于初始化在页面，供督办员选择牵头部门
	 * 
	 * @return
	 */
	public List<Organization> queryAllOrgName() {
		return orgmapper.queryAllOrgName();
	}

	/**
	 * 根据部门编号查出从属于该部门的员工,用于部门指定负责人
	 * 
	 * @param orgId		部门编号
	 * @return
	 */
	public List<User> queryUserByOrgid(Integer orgId) {
		return orgmapper.queryUserBelongToSelf(orgId);
	}
}
