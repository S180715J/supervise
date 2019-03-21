package com.newer.supervise.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
	    @Insert("INSERT INTO item_process (item_code,statu_describe,opt_time,user_id,sup_statu,org_statu,staff_statu) VALUES(#{itemCode},#{statuDescribe},#{optTime},#{userId.userId},,,,)")
	    public Integer insert(ItemProcess item);
	    
	    /**
	     * 修改事项进程表中事项编号
	     * @param itemCode
	     * @param id
	     * @return
	     */
	    @Update("UPDATE item_process SET  item_code=#{itemCode}   WHERE item_code=#{oldCode}")
	    public Integer update(@Param("itemCode")String itemCode,@Param("oldCode")String oldCode);
	    
	    /**
	     * 查找得到最后的时间
	     * @param item
	     * @return
	     */
	    @Select("SELECT item_code,MAX(opt_time)  FROM  item_process  WHERE item_code=#{itemCode}")
	    public ItemProcess  selectTime(String itemCode);
}
