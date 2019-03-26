package com.newer.supervise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.service.MainService;

/**
 * 首页的控制层
 * 
 * @author W419
 *
 */
@RestController
public class MainController {

	@Autowired
	private MainService mService;

	/**
	 * 得到事项进程表中同一事项的具体数据
	 * 
	 * @param itemCode
	 * @return
	 */
	@GetMapping("main/item_list/{itemCode}")
	private ResponseEntity<?> queryUser(@PathVariable("itemCode") String itemCode) {
		List<ItemProcess> list = mService.queryUser(itemCode);
		if (!list.isEmpty()) {
			return new ResponseEntity<List<ItemProcess>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(0, HttpStatus.OK);
	}
}
