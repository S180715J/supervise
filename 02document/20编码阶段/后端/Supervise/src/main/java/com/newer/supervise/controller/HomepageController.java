package com.newer.supervise.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newer.supervise.model.Page;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.service.HomepageService;

@RestController
public class HomepageController {

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
	public ResponseEntity<?> querypropellingpage(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {

		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.querypropellingpage(page, limit));
		pages.setCount(homepageservice.querypropelling().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);

	}

	@RequestMapping(value = "/queryFirstpage", method = RequestMethod.GET)
	public ResponseEntity<?> queryFirstpage(
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
		Page<Repository> pages = new Page<Repository>();
		pages.setCode(0);
		pages.setData(homepageservice.queryFirstpage(page, limit));
		pages.setCount(homepageservice.queryFirst().size());
		return new ResponseEntity<>(pages, HttpStatus.OK);
	}

	/**
	 * �����쵼���ݶ�Ӧ������id���鿴��������ϸ��Ϣ
	 * 
	 * @param id ����id
	 * @return
	 */
	@GetMapping("leadRepositoryInfo/{id}")
	public ResponseEntity<?> sendRepositoryToPage(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryRespositoryById(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}

	/**
	 * ������ͨԱ����������id���鿴������
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("empRepository/{id}")
	public ResponseEntity<?> empRepository(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.queryEmpRepository(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}

	/**
	 * ���Զ���Ա��������id���鿴������
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("supRepository/{id}")
	public ResponseEntity<?> supRepository(@PathVariable("id") Integer id) {
		Repository repository = homepageservice.querySupRepository(id);
		return new ResponseEntity<Repository>(repository, HttpStatus.OK);
	}

	/**
	 * ҳ�����ԭ����Ϣ(����Ա���쵼)
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
	 * ��������id�����쵼���鿴��ԭ����Ϣ
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
	 * ��������id���Զ���Ա��������
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
