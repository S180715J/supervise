package com.newer.supervise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.pojo.TaskType;
import com.newer.supervise.pojo.User;
import com.newer.supervise.service.HomepageService;

@RestController
public class HomepageController {
	Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name = "homepageservice")
	private HomepageService homepageservice;

	@RequestMapping(value = "/queryRecentUpdate", method = RequestMethod.GET)
	public ResponseEntity<?> queryRecentUpdate() {
		List<Repository> queryRecentUpdate = homepageservice.queryRecentUpdate();
		return new ResponseEntity<>(queryRecentUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/queryRecentUpdatepage", method = RequestMethod.GET)
	public ResponseEntity<?> pages(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {

		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.queryRecentUpdatePage(page, limit));
		pages.setCount(homepageservice.queryRecentUpdate().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/querypropellingpage", method = RequestMethod.GET)
	public ResponseEntity<?> querypropellingpage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.querypropellingpage(page, limit));
		pages.setCount(homepageservice.querypropelling().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
	
	//分页查询首页
	@RequestMapping(value = "/queryFirstpage", method = RequestMethod.GET)
	public ResponseEntity<?> queryFirstpage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit	) {
		
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.queryFirstpage(page, limit));
		pages.setCount(homepageservice.queryFirst().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}
/**
	 * 回显领导根据对应的事项id所查看的事项详细信息
	 * 
	 * @param id 事项id
	 * @return
	 */
	@GetMapping("leadRepositoryInfo/{id}")
	public ResponseEntity<?> sendRepositoryToPage(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryRespositoryById(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}	
	//查询部门事项信息
	@RequestMapping("querydeptInfo/{id}")
	public ResponseEntity<?> queryRespositoryById(@PathVariable("id") Integer id){
		Repository queryRespositoryById = homepageservice.queryRespositoryById(id);
		return new ResponseEntity<Repository>(queryRespositoryById,HttpStatus.OK);
	}
		/**
	 * 回显普通员工根据事项id所查看的事项
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("empRepository/{id}")
	public ResponseEntity<?> empRepository(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryEmpRepository(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}
	//查询所有事项进展
	@RequestMapping(value="/queryTaskType" ,method=RequestMethod.GET)
	public ResponseEntity<?> queryTaskType(){
		List<TaskType> queryTaskType = homepageservice.queryTaskType();
		return new ResponseEntity<List<TaskType>>(queryTaskType,HttpStatus.OK);
	}
	
	//部门更新进展
	
	@RequestMapping(value="/Updatedept" ,method=RequestMethod.PUT)
	public ResponseEntity<?> Updatedept(@RequestBody Repository repository){		
		Integer updatedept = homepageservice.Updatedept(repository);
		log.info("{}员工修改成功", updatedept);
		if (updatedept > 0) {
			return new ResponseEntity<Repository>(repository, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Repository>(repository, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 页面回显原件信息(督办员、领导)
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("supFileInfo/{id}")
	public ResponseEntity<?> supSourceFileInfo(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.querySourceFileInfo(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}
		/**
	 * 回显督办员根据事项id所查看的数据
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("supRepository/{id}")
	public ResponseEntity<?> supRepository(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.querySupRepository(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}

	//查询所有事项进展
	@RequestMapping(value="/queryItemProcess" ,method=RequestMethod.GET)
	public ResponseEntity<?> queryItemProcess(){
		List<ItemProcess> queryItemProcess = homepageservice.queryItemProcess();
		return new ResponseEntity<List<ItemProcess>>(queryItemProcess,HttpStatus.OK);
	}
	
	
	/**
	 * 根据事项id回显领导所查看的原件信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("leadFileInfo/{id}")
	public ResponseEntity<?> leadSourceFileInfo(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryLeadSourceFileInfo(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}
		/**
	 * 根据事项id回显督办员待办任务
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("waitTask/{id}")
	public ResponseEntity<?> waitTask(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryWaitTask(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}
}
