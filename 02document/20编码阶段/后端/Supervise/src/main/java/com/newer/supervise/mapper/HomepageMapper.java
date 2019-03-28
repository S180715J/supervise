package com.newer.supervise.mapper;
/**
 * 首页。最近更新，推进中的事项
 * @author Administrator
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.supervise.pojo.ItemProcess;
import com.newer.supervise.pojo.Repository;
import com.newer.supervise.pojo.TaskType;

public interface HomepageMapper {
	/**
	 * 查询最近更新
	 * @return
	 */
	@Select("SELECT r.id , r.item_name,r.org_id,o.org_name,i.sup_statu,i.org_statu,i.staff_statu,i.opt_time,u.`user_id`,u.`user_name` FROM repository r LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN organization o ON r.`org_id`=o.`org_id`LEFT JOIN `user` u ON i.`user_id`=u.`user_id` ")
	
	List<Repository> queryRecentUpdate();
	
	
	@Select("SELECT r.id , r.item_name,r.org_id,o.org_name,i.sup_statu,i.org_statu,i.staff_statu,i.opt_time,u.`user_id`,u.`real_name` FROM repository r LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN organization o ON r.`org_id`=o.`org_id`LEFT JOIN `user` u ON i.`user_id`=u.`user_id` LIMIT #{page},#{limit}")
	@Results({@Result(column= "item_name",property="itemName"),
		@Result(column= "org_id",property="orgId.orgId"),
		@Result(column= "org_name",property="orgId.orgName"),
		@Result(column= "sup_statu",property="itemCode.supStatu"),
		@Result(column= "org_statu",property="itemCode.orgStatu"),
		@Result(column= "staff_statu",property="itemCode.staffStatu"),		
		@Result(column= "opt_time",property="itemCode.optTime"),
		@Result(column= "user_id",property="itemCode.userId.userId"),
		@Result(column= "real_name",property="itemCode.userId.realName"),		
		@Result(column= "item_code",property="itemCode.itemCode"),
		@Result(column= "id",property="id"),
	})
	List<Repository> queryRecentUpdatepage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 查询推进中事项
	 * @return
	 */
	@Select("SELECT r.id , r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,next_feedback FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id`")
	List<Repository> querypropelling();
	
	@Select("SELECT r.id , r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,next_feedback FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id` WHERE r.`item_type`!=2 LIMIT #{page},#{limit}")
	@Results({@Result(column= "item_name",property="itemName"),

		@Result(column= "org_id",property="orgId.orgId"),
		@Result(column= "org_name",property="orgId.orgName"),		
		@Result(column= "over_time",property="overTime"),
		@Result(column= "next_feedback",property="nextFeedback"),	
		@Result(column= "id",property="id"),
		
	})
	List<Repository> querypropellingpage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 首页
	 * @return
	 */
	@Select("SELECT r.id , r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,i.`opt_time` FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id`")
	List<Repository> queryFirst();
	
	@Select("SELECT r.id , r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,i.`opt_time` FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id` WHERE r.`item_type`!=2 LIMIT #{page},#{limit}")
	@Results({@Result(column= "item_name",property="itemName"),

		@Result(column= "org_id",property="orgId.orgId"),
		@Result(column= "org_name",property="orgId.orgName"),		
		@Result(column= "over_time",property="overTime"),
		@Result(column= "opt_time",property="itemCode.optTime"),		
		@Result(column= "id",property="id"),
	})
	List<Repository> queryFirstpage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 根据事项id回显领导所查看的事项内容
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT r.`item_name`,r.`serial_num`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,i.`user_id` AS 'itemCode.userId.userId',r.`user_id` AS 'user.userId',r.`item_content`,r.`remark`,r.`over_time`,r.`feedback`,i.`opt_time`,DATE_ADD(i.`opt_time`,INTERVAL feedback DAY) AS 'nextFeedback' FROM repository r "
			+ "	LEFT JOIN item_process i ON i.`item_code`=r.`item_code` LEFT JOIN `user` z"
			+ "	ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id`"
			+ "	LEFT JOIN organization o ON r.`org_id`=o.`org_id` WHERE r.`id`=#{id}")
	@Results({ @Result(column = "item_name", property = "itemName"),
			@Result(column = "serial_num", property = "serialNum"),
			@Result(column = "org_id", property = "orgId.orgId"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "item_content", property = "itemContent"), @Result(column = "remark", property = "remark"),
			@Result(column = "over_time", property = "overTime"), @Result(column = "feedback", property = "feedback"),
			@Result(column = "opt_time", property = "itemCode.optTime"), })
	Repository queryRespositoryById(Integer id);

	/**
	 * 根据事项id回显员工所查看的事项内容
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT r.`item_name`,t.`type_name` AS 'itemCode.taskType.typeName',r.`serial_num`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,i.`user_id` AS 'itemCode.userId.userId',r.`user_id` AS 'user.userId',r.`item_content`,r.`over_time`,r.`feedback`,i.`opt_time`,DATE_ADD(i.`opt_time`,INTERVAL feedback DAY) AS 'nextFeedback' FROM repository r"
			+ "	LEFT JOIN item_process i ON i.`item_code`=r.`item_code` LEFT JOIN `user` z "
			+ "	ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id`"
			+ "	LEFT JOIN organization o ON r.`org_id`=o.`org_id` LEFT JOIN task_type t"
			+ "	ON t.`task_id`=i.`task_type` WHERE r.`id`=#{id}")
	@Results({ @Result(column = "item_name", property = "itemName"),
			@Result(column = "serial_num", property = "serialNum"),
			@Result(column = "org_id", property = "orgId.orgId"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "item_content", property = "itemContent"),
			@Result(column = "over_time", property = "overTime"), @Result(column = "feedback", property = "feedback"),
			@Result(column = "opt_time", property = "itemCode.optTime"), })
	Repository queryEmpRepository(Integer id);

	/**
	 * 页面回显督办员查看的事项详细信息
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT r.`item_statu`,r.`item_name`,r.`serial_num`,u.`real_name` AS 'user.realName',o.`org_name`,z.`real_name` AS 'itemCode.userId.realName',r.`item_content`,t.`type_name`,r.`over_time`,r.`feedback`,i.`opt_time`,DATE_ADD(over_time,INTERVAL feedback DAY) AS 'nextFeedback' FROM repository r"
			+ "	LEFT JOIN item_process i ON r.`item_code`=i.`item_code` LEFT JOIN `user` z"
			+ "	ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id`"
			+ "	LEFT JOIN organization o ON r.`org_id`=o.`org_id` LEFT JOIN task_type t"
			+ "	ON t.`task_id`=i.`task_type` WHERE r.`id`=5;")
	@Results({ @Result(column = "item_statu", property = "itemStatu"),
			@Result(column = "item_name", property = "itemName"),
			@Result(column = "serial_num", property = "serialNum"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "item_content", property = "itemContent"),
			@Result(column = "type_name", property = "itemCode.taskType.typeName"),
			@Result(column = "over_time", property = "overTime"), @Result(column = "feedback", property = "feedback"),
			@Result(column = "opt_time", property = "itemCode.optTime"), })
	Repository querySupRepository(Integer id);

	/**
	 * 页面回显事项id对应的事项原件信息，供督办员及领导查看
	 * 
	 * @param id 事项id
	 * @return
	 */
	@Select("SELECT s.`source_type`,r.`source_time`,r.`serial_num`,f.`type_name`,r.`drafter`,r.`drafter_phone`,l.`level_name`,o.`org_name`,r.`dept_opinion`,r.`lead_opinion`,r.`item_content`,r.`remark` FROM repository r"
			+ "	LEFT JOIN source s	ON r.`source_id`=s.`source_id` LEFT JOIN file_type f"
			+ "	ON r.`file_type`=f.`type_id` LEFT JOIN secrecy_level l"
			+ "	ON r.`secrecy_level`=l.`level_id` LEFT JOIN organization o"
			+ "	ON r.`org_id`=o.`org_id` WHERE r.`id`=#{id}")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "source_time", property = "sourceTime"),
			@Result(column = "serial_num", property = "serialNum"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "drafter", property = "drafter"),
			@Result(column = "drafter_phone", property = "drafterPhone"),
			@Result(column = "level_name", property = "secrecyLevel.levelName"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "dept_opinion", property = "deptOpinion"),
			@Result(column = "lead_opinion", property = "leadOpinion"),
			@Result(column = "item_content", property = "itemContent"),
			@Result(column = "remark", property = "remark"), })
	Repository querySourceFileInfo(Integer id);

	/**
	 * 根据事项id回显出领导查看的原件信息
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT r.`item_name`,s.`source_type`,r.`source_time`,o.`org_name`,u.`real_name`,r.`over_time`,r.`item_content` FROM repository r"
			+ "	LEFT JOIN source s ON s.`source_id`=r.`source_id`LEFT JOIN organization o"
			+ "	ON o.`org_id`=r.`org_id` LEFT JOIN item_process i"
			+ "	ON i.`user_id`=r.`item_code` LEFT JOIN `user` u ON u.`user_id`=i.`user_id` WHERE r.`id`=#{id}")
	@Results({ @Result(column = "item_name", property = "itemName"),
			@Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "source_time", property = "sourceTime"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "real_name", property = "itemCode.userId.realName"),
			@Result(column = "over_time", property = "overTime"),
			@Result(column = "item_content", property = "itemContent"),
			 })
	Repository queryLeadSourceFileInfo(Integer id);

	
	//查询事项状态
	@Select("SELECT * FROM task_type")
	List<TaskType> queryTaskType ();
	
	//部门更新
	@Update("UPDATE repository SET remark=#{remark} WHERE id=#{id}")
	int Updatedept(Repository Repository);
	
	//查询事项列表
	@Select("SELECT i.opt_time,u.user_id,u.real_name FROM item_process i LEFT JOIN USER u ON u.`user_id`=i.`user_id`")
	List<ItemProcess> queryItemProcess();
		/**
	 * 根据事项id回显督办员待办任务
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT r.`item_name`,s.`source_type` AS 'sourceId.sourceType',r.`source_time`,r.`item_content` FROM repository r LEFT JOIN source s ON s.`source_id`=r.`source_id` WHERE r.`id`=#{id}")
	Repository queryWaitTask(Integer id);
}
