package com.newer.supervise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.supervise.mapper.OrgMapper;
import com.newer.supervise.pojo.Organization;



@Service
public class OrgService {
	@Autowired
	private OrgMapper orgmapper;
	/**
	 * 查询部门所以信息
	 * @return
	 */
	public List<Organization> getorg(){
		return orgmapper.getorg();
	}
	/**
	 * 按orgid查询所有信息
	 * @param orgid
	 * @return
	 */
	public int getorgID(Integer orgid) {
		return orgmapper.getorgID(orgid);
	}
	/**
	 * 新增部门信息
	 * @param org
	 * @return
	 */
	public int insertorg(Organization org) {
		return orgmapper.insertorg(org);
	}
	/**
	 * 删除部门信息
	 * @param orgid
	 * @return
	 */
	public int delorg(Integer orgid) {
		return orgmapper.delorg(orgid);
	}
	/**
	 * 修改部门信息
	 * @param org
	 * @return
	 */
	public int uporg(Organization org) {
		return orgmapper.uporg(org);
	}
}
