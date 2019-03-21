package com.newer.supervise.service;

import java.util.List;

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
	public List<Repository> queryAll() {
		return repositoryMapper.queryAll();
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
}
