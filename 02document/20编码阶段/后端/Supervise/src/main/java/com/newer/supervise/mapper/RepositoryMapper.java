package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.supervise.pojo.Repository;

/**
 * 备用库DAO层
 * 
 * @author W419
 *
 */
public interface RepositoryMapper {

	List<Repository> searchAnySimilar();

	List<Repository> queryAllItem(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 显示备用库所存的所有数据,以备用库的事项编号为级联关系
	 * 
	 * @return
	 */
	@Select("SELECT  id,item_name, b.source_type,a.item_content,a.source_time,o.org_name,c.type_name,a.item_type,a.item_statu,a.item_code  FROM  repository   a\r\n"
			+ "LEFT  JOIN  source  b  ON  a.source_id=b.source_id  \r\n"
			+ "LEFT  JOIN  file_type c  ON  a.file_type=c.type_id \r\n"
			+ "LEFT  JOIN  organization o  ON  a.org_id=o.org_id  ORDER  BY id ASC")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "item_code", property = "itemCode.itemCode") })
	public List<Repository> queryAll();

	/**
	 * 回显单个数据
	 * 
	 * @return
	 */
	@Select("SELECT a.id,s.source_type,a.source_time,a.serial_num,f.type_name,a.drafter,a.drafter_phone,a.item_name,a.item_code,u.real_name,u.duty_id,o.org_name,sl.level_name,a.item_content  FROM  repository  a \r\n"
			+ "LEFT JOIN source  s  ON  a.source_id=s.source_id \r\n"
			+ "LEFT JOIN file_type f ON a.file_type=f.type_id \r\n"
			+ "LEFT JOIN item_process i  ON a.item_code=i.item_code \r\n"
			+ "LEFT JOIN `user`  u   ON  a.user_id=u.duty_id \r\n"
			+ "LEFT JOIN  organization o  ON a.org_id=o.org_id \r\n"
			+ "LEFT JOIN  secrecy_level sl ON a.secrecy_level=sl.level_id  WHERE id=1")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "item_code", property = "itemCode.itemCode"),
			@Result(column = "real_name", property = "user.realName"),
			@Result(column = "duty_id", property = "user.duty.dutyId"),
			@Result(column = "org_name", property = "orgId.orgName"),
			@Result(column = "level_name", property = "secrecyLevel.levelName"), })
	public Repository queryOne(@Param("id") Integer id);

	/**
	 * 查事项名称，事项编号的重复问题
	 * 
	 * @param rep
	 * @return
	 */
	@Select("SELECT  item_name,item_code FROM  repository  WHERE  item_name=#{itemName} OR item_code=#{itemCode.itemCode}")
	public Integer selectEquals(Repository rep);

	/**
	 * 修改时查重
	 * 
	 * @return
	 */
	@Select("SELECT id, item_name,item_code FROM  repository  WHERE id!=#{id} AND (item_name=#{itemName} OR item_code=#{itemCode.itemCode}) ")
	public Integer updateEquals(Repository rep);

	/**
	 * 添加新数据
	 * 
	 * @param rep
	 * @return
	 */
	@Insert("INSERT INTO repository (source_id,source_time,serial_num,file_type,drafter,drafter_phone,item_name,item_code,user_id,org_id,secrecy_level,item_content,over_time,feedback,next_feedback,dept_opinion,lead_opinion,item_statu,item_type,remark)  \r\n"
			+ "VALUES(#{sourceId.sourceId},#{sourceTime},#{serialNum},#{fileType.typeId},#{drafter},#{drafterPhone},#{itemName},#{itemCode.itemCode},#{user.userId},#{orgId.orgId},#{secrecyLevel.levelId},#{itemContent},#{overTime},#{feedback},#{nextFeedback},#{deptOpinion},#{leadOpinion},#{itemStatu},#{itemType},#{remark})")
	public Integer insert(Repository rep);

	/**
	 * 修改
	 * 
	 * @param rep
	 * @return
	 */
	@Update("UPDATE repository SET item_name=#{itemName}, item_code=#{itemCode.itemCode}, user_id=#{user.userId}, remark=#{remark}  WHERE  id=#{id} ")
	public Integer update(Repository rep);

}
