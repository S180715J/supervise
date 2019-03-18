package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newer.supervise.pojo.Repository;

public interface RepositoryMapper {

	
	List<Repository> searchAnySimilar();
	
	
	List<Repository> queryAllItem(@Param("page")Integer page, @Param("limit")Integer limit);
}
