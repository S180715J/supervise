package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.supervise.pojo.Source;

public interface SourceMapper {

	@Select("SELECT source_id,source_type FROM source")
	List<Source> getAllSource();
}
