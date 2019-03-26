package com.newer.supervise.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.supervise.pojo.ItemProcess;

/**
 * 事项进程dao层
 * 
 * @author W419
 *
 */
public interface ItemProcessMapper {

	/**
	 * 调用此方法，保存事项编号，操作人，操作时间
	 * 
	 * @param item
	 * @return
	 */
	@Insert("INSERT INTO item_process (item_code,statu_describe,opt_time,user_id,sup_statu,org_statu,staff_statu) VALUES(#{itemCode},#{statuDescribe},#{optTime},#{userId.userId},#{supStatu},#{orgStatu},#{staffStatu})")
	public Integer insert(ItemProcess item);

	/**
	 * 修改事项进程表中所有事项编号
	 * 
	 * @param itemCode
	 * @param id
	 * @return
	 */
	@Update("UPDATE item_process SET  item_code=#{itemCode}   WHERE item_code=#{oldCode}")
	public Integer update(@Param("itemCode") String itemCode, @Param("oldCode") String oldCode);

	/**
	 * 查找得到最后的时间
	 * 
	 * @param item
	 * @return
	 */
	@Select("SELECT item_code,MAX(opt_time)  FROM  item_process  WHERE item_code=#{itemCode}")
	public ItemProcess selectTime(String itemCode);

	/**
	 * 更改事项进程表操作数据
	 * 
	 * @return
	 */
	@Update("UPDATE  item_process  SET  statu_describe=#{statuDescribe} ,opt_time=#{optTime}, sup_statu=#{supStatu},org_statu=#{orgStatu},staff_statu=#{staffStatu} WHERE  item_code=#{itemCode} AND user_id=#{userId.userId}  ")
	public Integer updateStatu(ItemProcess item);

}
