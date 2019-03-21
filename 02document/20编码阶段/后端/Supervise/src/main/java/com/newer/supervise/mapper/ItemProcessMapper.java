package com.newer.supervise.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
	    
	    /**
	     * 修改事项进程表中事项编号
	     * @param itemCode
	     * @param id
	     * @return
	     */
	    @Update("UPDATE item_process SET  item_code=#{itemCode}   WHERE statu_id=#{id}")
	    public Integer update(@Param("itemCode")String itemCode,@Param("id")Integer id);
}
