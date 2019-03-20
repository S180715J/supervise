package com.newer.supervise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.supervise.mapper.ItemProcessMapper;
import com.newer.supervise.pojo.ItemProcess;

/**
 * 事项进程服务层
 * 
 * @author W419
 *
 */
@Service
public class ItemProcessService {

	@Autowired
	private ItemProcessMapper itemMapper;

	/**
	 * 添加初始化信息
	 * @param item
	 * @return
	 */
	public Integer insert(ItemProcess item) {
		return itemMapper.insert(item);
	}
}
