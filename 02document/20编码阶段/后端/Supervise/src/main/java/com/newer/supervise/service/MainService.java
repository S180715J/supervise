package com.newer.supervise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.supervise.mapper.MainMapper;
import com.newer.supervise.pojo.ItemProcess;

/**
 * 对首页数据操作的服务层
 * 
 * @author W419
 *
 */
@Service
public class MainService {

	@Autowired
	private MainMapper mapper;

	/**
	 * 得到事项进程表中同一事项的具体数据
	 * 
	 * @param itemCode
	 * @return
	 */
	public List<ItemProcess> queryUser(String itemCode) {
		return mapper.queryUser(itemCode);
	}
}
