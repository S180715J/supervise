package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.supervise.pojo.SecrecyLevel;

public interface SecrecyLevelMapper {

	/**
	 * 查询所有的保密等级
	 * 
	 * @return
	 */
	@Select("SELECT level_id,level_name FROM secrecy_level")
	List<SecrecyLevel> queryAllLevel();
}
