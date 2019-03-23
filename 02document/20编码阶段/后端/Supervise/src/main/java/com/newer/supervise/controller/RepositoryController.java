package com.newer.supervise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.FileType;
import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.pojo.SecrecyLevel;
import com.newer.supervise.pojo.Source;
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
			return new ResponseEntity<Integer>(0, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Repository>>(list, HttpStatus.OK);
	}

	/**
	 * 查询单个,用于修改回显,立项回显
	 * 
	 * @return
	 */
	@GetMapping("/item/one/{id}")
	public ResponseEntity<?> queryOne(@PathVariable("id") Integer id) {
		Repository one = repositoryService.queryOne(id);
		if (one == null) {
			// 如果没查到数据则返回0
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
		return new ResponseEntity<Repository>(one, HttpStatus.OK);
	}

	/**
	 * 添加
	 * 
	 * @param rep
	 * @return
	 */
	@PostMapping("/item/add")
	public ResponseEntity<?> insert(@RequestBody Repository rep) {
		// 查事项名称，事项编号的重复
		Integer e = repositoryService.selectEquals(rep);
		// 如果e>0,则数据存在,否则执行else下的代码
		if (e != null) {
			// 这里的返回判断有重复的则返回-1
			return new ResponseEntity<Integer>(-1, HttpStatus.NO_CONTENT);
		} else {
			Integer insert = repositoryService.insert(rep);
			// 这里的返回判断添加事项(备用库)是否成功
			return new ResponseEntity<Integer>(insert, HttpStatus.OK);
		}
	}

	/**
	 * 修改
	 * 
	 * @param rep
	 * @return
	 */
	@PutMapping("/item/update/{oldCode}")
	public ResponseEntity<?> update(@RequestBody Repository rep, @PathVariable("oldCode") String oldCode) {
		// 查事项名称，事项编号的重复
		Integer e = repositoryService.updateEquals(rep);
		// 如果e>0,则数据存在,否则执行else下的代码
		if (e != null) {
			// 这里的返回判断有重复的则返回-1
			return new ResponseEntity<Integer>(-1, HttpStatus.OK);
		} else {
			Integer i = repositoryService.update(rep, oldCode);
			System.out.println(i);
			// 这里的返回判断添加事项(备用库)是否成功
			return new ResponseEntity<Integer>(i, HttpStatus.OK);
		}
	}

	/**
	 * 得到最后操作时间
	 * 
	 * @param itemCode
	 * @return
	 */
	@GetMapping("/item/Time/{itemCode}")
	public ResponseEntity<?> selectTime(@PathVariable("itemCode") String itemCode) {
		ItemProcess item = repositoryService.selectTime(itemCode);
		if (item != null) {
			return new ResponseEntity<ItemProcess>(item, HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(0, HttpStatus.OK);
	}

	/**
	 * 立项时保存事项进程表记录
	 * 
	 * @param itemCode
	 * @param userId
	 * @return
	 */
	@PostMapping("/item/addItem")
	public ResponseEntity<?> insertItem(@RequestParam("itemCode") String itemCode,
			@RequestParam("userId") Integer userId) {
		Integer i = repositoryService.insertItem(itemCode, userId);
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}

	/**
	 * 模糊查询
	 * 
	 * @param rep
	 * @return
	 */
	@PostMapping("/item/dim")
	public ResponseEntity<?> queryDim(@RequestBody Repository rep) {
		List<Repository> list = repositoryService.queryDim(rep);
		if (list.isEmpty()) {
			// 如果没查到数据则返回0
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
		return new ResponseEntity<List<Repository>>(list, HttpStatus.OK);
	}

	/**
	 * 修改备用库状态
	 * 
	 * @param statu
	 * @param id
	 * @return
	 */
	@PutMapping("/item/statu")
	public ResponseEntity<?> updateStatu(@RequestParam("statu") Integer statu, @RequestParam("id") Integer id) {
		Integer i = repositoryService.updateStatu(statu, id);
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}

	/**
	 * 批量修改
	 * 
	 * @return
	 */
	@PutMapping("/item/updateArray")
	public ResponseEntity<?> updateArray(@RequestBody Integer[] arr) {
		Integer i = repositoryService.updateArray(arr, 0);
		return new ResponseEntity<Integer>(i, HttpStatus.OK);
	}
}
