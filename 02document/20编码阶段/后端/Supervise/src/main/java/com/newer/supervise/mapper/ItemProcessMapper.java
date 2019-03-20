package com.newer.supervise.mapper;

import org.apache.ibatis.annotations.Insert;

import com.newer.supervise.pojo.ItemProcess;

/**
 * 事项进程dao层
 * @author W419
 *
 */
public interface ItemProcessMapper {
         
	    /**
	     * 当新增事项时，调用此方法，保存事项编号，操作人（领导），创建时间
	     * @param item
	     * @return
	     */
	    @Insert("INSERT INTO item_process (item_code,statu_describe,opt_time,user_id) VALUES(#{itemCode},#{statuDescribe},#{optTime},#{userId.userId})")
	    public Integer insert(ItemProcess item);
}
