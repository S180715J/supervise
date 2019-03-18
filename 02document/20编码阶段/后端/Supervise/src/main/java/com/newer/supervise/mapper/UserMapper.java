package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newer.supervise.pojo.User;

public interface UserMapper {

	@Select("SELECT user_id,user_name,`password`,real_name,d.`duty_id`,duty_name,duty_type FROM `user` u LEFT JOIN duty d ON u.`duty_id`=d.`duty_id` WHERE d.`duty_type`='公司领导'")
	@Results({ @Result(column = "duty_id", property = "duty.dutyId"),
			@Result(column = "duty_name", property = "duty.dutyName"),
			@Result(column = "duty_type", property = "duty.dutyType"), })
	List<User> queryLeaders();
}
