package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
	@Select("SELECT  id, b.source_type,a.item_content,a.source_time,a.adverse_company,c.type_name,a.item_type,a.item_statu,d.opt_time   FROM  repository   a\r\n"
			+ "LEFT  JOIN  source  b  ON  a.source_id=b.source_id  \r\n"
			+ "LEFT  JOIN  file_type c  ON  a.file_type=c.type_id\r\n"
			+ "LEFT  JOIN  item_process d ON  a.item_code=d.item_code")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "opt_time", property = "itemCode.optTime") })
	public List<Repository> queryAll();
	
	
	/**
	 * 回显单个数据
	 * 
	 * @return
	 */
	@Select("SELECT  id, b.source_type,a.item_content,a.source_time,a.adverse_company,c.type_name,a.item_type,a.item_statu,d.opt_time   FROM  repository   a\r\n"
			+ "LEFT  JOIN  source  b  ON  a.source_id=b.source_id  \r\n"
			+ "LEFT  JOIN  file_type c  ON  a.file_type=c.type_id\r\n"
			+ "LEFT  JOIN  item_process d ON  a.item_code=d.item_code WHERE id=#{id} ")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "opt_time", property = "itemCode.optTime") })
	public Repository queryOne(Integer id);

	/**
	 * 添加新数据
	 * 
	 * @param rep
	 * @return
	 */
	@Insert("INSERT INTO repository (source_id,source_time,serial_num,file_type,drafter,drafter_phone,item_name,item_code,user_id,adverse_company,secrecy_level,item_content,over_time,feedback,next_feedback,dept_opinion,lead_opinion,item_statu,item_type,remark)  \r\n"
			+ "VALUES(#{sourceId.sourceId},#{sourceTime},#{serialNum},#{fileType.typeId},#{drafter},#{drafterPhone},#{itemName},#{itemCode.itemCode},#{user.userId},#{adverseCompany},#{secrecyLevel.levelId},#{itemContent},#{overTime},#{feedback},#{nextFeedback},#{deptOpinion},#{leadOpinion},#{itemStatu},#{itemType},#{remark})")
	public Integer insert(Repository rep);

}
