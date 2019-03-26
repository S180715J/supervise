package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.supervise.pojo.ItemProcess;

/**
 * 显示主页有关数据的dao层
 * 
 * @author W419
 *
 */
public interface MainMapper {
	/**
	 * 得到事项进程表中同一事项的具体数据 以id的升序排序，方便在页面操作
	 * 
	 * @return
	 */
	@Select("SELECT i.statu_id,u.real_name  FROM  item_process i  LEFT JOIN  `user` u ON  i.user_id =u.user_id  WHERE i.item_code=#{itemCode}  ORDER BY  i.statu_id  ASC")
	@Results({ @Result(column = "real_name", property = "userId.realName") })
	public List<ItemProcess> queryUser(String itemCode);
}
