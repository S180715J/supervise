package com.newer.supervise.mapper;
/**
 * 首页。最近更新，推进中的事项
 * @author Administrator
 *
 */

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.newer.supervise.pojo.Repository;

public interface HomepageMapper {
	/**
	 * 查询最近更新
	 * @return
	 */
	@Select("SELECT r.item_name,r.org_id,o.org_name,i.sup_statu,i.org_statu,i.staff_statu,i.opt_time,u.`user_id`,u.`user_name` FROM repository r LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN organization o ON r.`org_id`=o.`org_id`LEFT JOIN `user` u ON i.`user_id`=u.`user_id` ")
	
	List<Repository> queryRecentUpdate();
	
	
	@Select("SELECT r.item_name,r.org_id,o.org_name,i.sup_statu,i.org_statu,i.staff_statu,i.opt_time,u.`user_id`,u.`real_name` FROM repository r LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN organization o ON r.`org_id`=o.`org_id`LEFT JOIN `user` u ON i.`user_id`=u.`user_id` LIMIT #{page},#{limit}")
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
	})
	List<Repository> queryRecentUpdatepage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 查询推进中事项
	 * @return
	 */
	@Select("SELECT r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,next_feedback FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id`")
	List<Repository> querypropelling();
	
	@Select("SELECT r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,next_feedback FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id` WHERE r.`item_type`!=2 LIMIT #{page},#{limit}")
	@Results({@Result(column= "item_name",property="itemName"),

		@Result(column= "org_id",property="orgId.orgId"),
		@Result(column= "org_name",property="orgId.orgName"),		
		@Result(column= "over_time",property="overTime"),
		@Result(column= "next_feedback",property="nextFeedback"),		
		
	})
	List<Repository> querypropellingpage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 首页
	 * @return
	 */
	@Select("SELECT r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,i.`opt_time` FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id`")
	List<Repository> queryFirst();
	
	@Select("SELECT r.`item_name`,u.`real_name` AS 'user.realName',z.`real_name` AS 'itemCode.userId.realName',r.`org_id`,o.`org_name`,r.`user_id`,i.`user_id`,r.`over_time`,i.`opt_time` FROM repository r  LEFT JOIN item_process i ON r.`id`=i.`item_code` LEFT JOIN `user` z ON z.`user_id`=i.`user_id` LEFT JOIN `user` u ON u.`user_id`=r.`user_id` LEFT JOIN organization o ON r.`org_id`=o.`org_id` WHERE r.`item_type`!=2 LIMIT #{page},#{limit}")
	@Results({@Result(column= "item_name",property="itemName"),

		@Result(column= "org_id",property="orgId.orgId"),
		@Result(column= "org_name",property="orgId.orgName"),		
		@Result(column= "over_time",property="overTime"),
		@Result(column= "opt_time",property="itemCode.optTime"),		
		
	})
	List<Repository> queryFirstpage(@Param("page") Integer page, @Param("limit") Integer limit);

}
