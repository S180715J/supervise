package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newer.supervise.pojo.FileType;

public interface FileTypeMapper {

	/**
	 * 查找所有的文件类型
	 * 
	 * @return
	 */
	@Select("SELECT type_id,type_name FROM file_type")
	List<FileType> queryAllTypes();
}
