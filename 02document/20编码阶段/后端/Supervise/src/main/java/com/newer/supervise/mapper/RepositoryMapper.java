package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.supervise.pojo.Repository;

public interface RepositoryMapper {

	
	List<Repository> searchAnySimilar();
	
	
	List<Repository> queryAllItem(@Param("page")Integer page, @Param("limit")Integer limit);
	
	/**
	 * 显示备用库所存的所有数据,以备用库的事项编号为级联关系，关联Iten类（事项关系表）的itemStatus，optTime(事项状态，操作时间)属性
	 * 
	 * @return
	 */
	@Select("SELECT b.source_type,a.item_content,a.source_time,a.adverse_company,c.type_name,a.item_type,a.item_statu,d.opt_time   FROM  repository   a\r\n" + 
			"LEFT  JOIN  source  b  ON  a.source_id=b.source_id  \r\n" + 
			"LEFT  JOIN  file_type c  ON  a.file_type=c.type_id\r\n" + 
			"LEFT  JOIN  item_process d ON  a.item_code=d.item_code")
	@Results({ @Result(column = "source_type", property = "sourceId.sourceType"),
			@Result(column = "type_name", property = "fileType.typeName"),
			@Result(column = "opt_time", property = "itemCode.optTime") })
	public List<Repository> queryAll();
}
