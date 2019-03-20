package com.newer.supervise.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.FileType;
import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.pojo.SecrecyLevel;
import com.newer.supervise.pojo.Source;
import com.newer.supervise.pojo.User;
import com.newer.supervise.service.ItemProcessService;
import com.newer.supervise.service.RepositoryService;

/**
 * 备用库控制层
 * 
 * @author W419
 *
 */
@RestController
public class RepositoryController {

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ItemProcessService itemService;

	@GetMapping("/showSource")
	public ResponseEntity<?> putSourceToPage() {
		List<Source> allSource = repositoryService.getAllSource();
		if (!allSource.isEmpty()) {
			return new ResponseEntity<List<Source>>(allSource, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no_source", HttpStatus.NO_CONTENT);

	}

	@GetMapping("/showFileType")
	public ResponseEntity<?> putFileTypeToPage() {
		List<FileType> allTypes = repositoryService.getAllTypes();
		if (!allTypes.isEmpty()) {
			return new ResponseEntity<List<FileType>>(allTypes, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no_type", HttpStatus.NO_CONTENT);

	}

	@GetMapping("/showLevel")
	public ResponseEntity<?> putLevelToPage() {
		List<SecrecyLevel> allLevel = repositoryService.getAllLevel();
		if (!allLevel.isEmpty()) {
			return new ResponseEntity<List<SecrecyLevel>>(allLevel, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no_level", HttpStatus.NO_CONTENT);

	}

	@GetMapping("/showItem")
	public ResponseEntity<?> itemPaging(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit) {
		List<Repository> allItem = repositoryService.getAllItem(page, limit);
		if (!(allItem.isEmpty())) {
			Page<Repository> currentPage = new Page<>();
			currentPage.setCode(0);
			currentPage.setCount(allItem.size());
			currentPage.setData(allItem);
			return new ResponseEntity<Page<Repository>>(currentPage, HttpStatus.OK);
		}
		return new ResponseEntity<String>("no_items", HttpStatus.NO_CONTENT);
	}

	/**
	 * 查询备用库所有数据
	 * 
	 * @return
	 */
	@GetMapping("/item/list")
	public ResponseEntity<?> queryAll() {
		List<Repository> list = repositoryService.queryAll();
		if (list.isEmpty()) {
			// 如果没查到数据则返回0
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
		return new ResponseEntity<List<Repository>>(list, HttpStatus.OK);
	}

	/**
	 * 添加
	 * 
	 * @param rep
	 * @return
	 */
	@PostMapping("/item/add")
	public ResponseEntity<?> insert(@RequestBody Repository rep) {
		//新增事项时插入事项进程一条数据（之后的审批流程围绕这条数据修改）
		String itemCode = rep.getItemCode().getItemCode();
		User userId = rep.getUser();
		ItemProcess item = new ItemProcess();
		item.setItemCode(itemCode);
		item.setOptTime(new Date());
		item.setUserId(userId);
		
		Integer i = itemService.insert(item);
		if (i>0) {
			Integer insert = repositoryService.insert(rep);
			return new ResponseEntity<Integer>(insert, HttpStatus.OK);
			// 如果i大于0，则插入成功，否则失败
		}
		return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
	}

}
