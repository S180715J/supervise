package com.newer.supervise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newer.supervise.mapper.FileTypeMapper;
import com.newer.supervise.mapper.ItemProcessMapper;
import com.newer.supervise.mapper.RepositoryMapper;
import com.newer.supervise.mapper.SecrecyLevelMapper;
import com.newer.supervise.mapper.SourceMapper;
import com.newer.supervise.pojo.FileType;
import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.pojo.SecrecyLevel;
import com.newer.supervise.pojo.Source;
import com.newer.supervise.pojo.User;

/**
 * 备用库的服务层
 * 
 * @author W419
 *
 */
@Service
public class RepositoryService {

	@Autowired
	private SourceMapper sourceMapper;

	@Autowired
	private FileTypeMapper fileTypeMapper;

	@Autowired
	private SecrecyLevelMapper levelMapper;

	@Autowired
	private RepositoryMapper repositoryMapper;

	@Autowired
	private ItemProcessMapper itemMapper;

	/**
	 * 获取所有的事项来源
	 * 
	 * @return
	 */
	public List<Source> getAllSource() {
		return sourceMapper.getAllSource();
	}

	/**
	 * 获取所有的文件类型
	 * 
	 * @return
	 */
	public List<FileType> getAllTypes() {
		return fileTypeMapper.queryAllTypes();
	}

	/**
	 * 获取所有的保密等级
	 * 
	 * @return
	 */
	public List<SecrecyLevel> getAllLevel() {
		return levelMapper.queryAllLevel();
	}

	/**
	 * 获取所有备用库事项（分页）
	 * 
	 * @return
	 */
	public List<Repository> getAllItem(Integer page, Integer limit) {
		return repositoryMapper.queryAllItem((page - 1) * limit, limit);
	}

	/**
	 * 查询所有的备用库数据
	 * 
	 * @return
	 */
	@Transactional
	public List<Repository> queryAll() {
		//
		List<Repository> queryAll = repositoryMapper.queryAll();

		return queryAll;
	}

	/**
	 * 添加新事项
	 * 
	 * @param rep
	 * @return
	 */
	public Integer insert(Repository rep) {
		return repositoryMapper.insert(rep);
	}

	/**
	 * 查询单个,用于修改回显,立项回显
	 * 
	 * @param id
	 * @return
	 */
	public Repository queryOne(Integer id) {
		return repositoryMapper.queryOne(id);
	}

	/**
	 * 修改
	 * 
	 * @param rep
	 * @return
	 */
	@Transactional
	public Integer update(Repository rep, String oldCode) {
		String itemCode = rep.getItemCode().getItemCode();
		itemMapper.update(itemCode, oldCode);

		return repositoryMapper.update(rep);
	}

	/**
	 * 查事项名称，事项编号的重复
	 * 
	 * @param rep
	 * @return
	 */
	public Integer selectEquals(Repository rep) {
		return repositoryMapper.selectEquals(rep);
	}

	/**
	 * 修改时查重
	 * 
	 * @param rep
	 * @return
	 */
	public Integer updateEquals(Repository rep) {
		return repositoryMapper.updateEquals(rep);
	}

	/**
	 * 得到最后的操作时间
	 * 
	 * @param itemCode
	 * @return
	 */
	public ItemProcess selectTime(String itemCode) {
		return itemMapper.selectTime(itemCode);
	}

	/**
	 * 保存事项进程记录
	 * 
	 * @param itemCode
	 * @param userId
	 * @return
	 */
	@Transactional
	public Integer updateType(Integer id, Integer itemType) {
		
		//先判断是否立过项,即事项类型item_type是否为0（用回显单个方法）
		Repository queryOne = repositoryMapper.queryOne(id);
		if (queryOne.getItemType() != 0) {
			return -1;
		}
		return repositoryMapper.updateType(id,itemType);
	}

	/**
	 * 模糊查询
	 * 
	 * @param rep
	 * @return
	 */
	public List<Repository> queryDim(Repository rep) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer sourceId = rep.getSourceId().getSourceId();
		String itemName = rep.getItemName();
		String serialNum = rep.getSerialNum();
		Date sourceTime = rep.getSourceTime();
		Date optTime = rep.getItemCode().getOptTime();
		Integer itemStatu = rep.getItemStatu();
		Integer itemType = rep.getItemType();
		Integer typeId = rep.getFileType().getTypeId();
		Integer orgId = rep.getOrgId().getOrgId();

		if (sourceId != null && !sourceId.equals(-1)) {
			map.put("sourceId", sourceId);
		}
		if (itemName != null && !itemName.equals("")) {
			map.put("itemName", itemName);
		}
		if (serialNum != null && !serialNum.equals("")) {
			map.put("serialNum", serialNum);
		}
		if (sourceTime != null) {
			map.put("sourceTime", sourceTime);
		}
		if (optTime != null) {
			map.put("optTime", optTime);
		}
		if (itemStatu != null && !itemStatu.equals(-1)) {
			map.put("itemStatu", itemStatu);
		}
		if (itemType != null && !itemType.equals(-1)) {
			map.put("itemType", itemType);
		}
		if (typeId != null && !typeId.equals(-1)) {
			map.put("typeId", typeId);
		}
		if (orgId != null && !orgId.equals(-1)) {
			map.put("orgId", orgId);
		}

		return repositoryMapper.queryDim(map);
	}

	/**
	 * 修改备用库表的状态
	 * 
	 * @param statu
	 * @param id
	 * @return
	 */
	public Integer updateStatu(Integer statu, Integer id) {
		return repositoryMapper.updateStatu(statu, id);
	}

	/**
	 * 批量修改
	 * 
	 * @param id
	 * @param statu
	 * @return
	 */
	public Integer updateArray(Integer[] arr, Integer statu) {
		return repositoryMapper.updateArray(arr, statu);
	}

	/**
	 * 初始化领导信息
	 * 
	 * @return
	 */
	public List<User> showLeader() {
		return repositoryMapper.showLeader();
	}

	/**
	 * 领导审批通过，在审批意见中指定牵头部门，根据id所对应的事项将领导审批意见添加入数据库
	 * 
	 * @param opinion
	 * @param id
	 * @return
	 */
	public Integer leadPass(String opinion, Integer id) {
		return repositoryMapper.leadPass(opinion, id);
	}

	/**
	 * 领导退回id所对应的事项，将退回意见加入至数据库中，同时修改该事项的状态为退回
	 * 
	 * @param opinion
	 * @param id
	 * @return
	 */
	public Integer leadRefuse(String opinion, Integer id) {
		return repositoryMapper.leadRefuse(opinion, id);
	}

	/**
	 * 督办员查看事项id所对应事项的领导意见
	 * 
	 * @param id
	 * @return
	 */
	public String queryOpinion(Integer id) {
		return repositoryMapper.queryLeadOpinion(id);
	}
}
