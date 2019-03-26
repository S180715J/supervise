package com.newer.supervise.mapper;
/**
 * 
 * @author 谢灿
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.supervise.pojo.Duty;
import com.newer.supervise.pojo.Education;
import com.newer.supervise.pojo.User;

public interface UserMapper {
	/**
	 * 查询账号和密码（登录）
	 * 
	 * @param user
	 * @return
	 */
	@Select("SELECT  user_id,user_name,`password`,real_name,hiredate,edu_id,org_id,u.duty_id,opt_time,d.duty_name  FROM  `user` u\r\n"
			+ "LEFT  JOIN  duty  d  ON  u.duty_id=d.duty_id  WHERE user_name=#{userName} AND password=#{password}")
	@Results({ @Result(column = "edu_id", property = "education.eid"),
			@Result(column = "duty_id", property = "duty.dutyId"),
			@Result(column = "duty_name", property = "duty.dutyName"),
			@Result(column = "org_id", property = "organization.orgId") })
	User findUsernamAndpwd(User user);

	/**
	 * 判断用户是否已被注册
	 * 
	 * @param username
	 * @return
	 */
	@Select("select user_name from USER where user_name=#{userName}")
	User findUsername(String username);

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO USER (user_name,password,hiredate) VALUES(username=#{user_name},password=#{password},hiredate=#{hiredate})")
	int saveUser(User user);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@Select("SELECT d.duty_name,d.duty_type,e.edu_name,o.org_name,u.* FROM USER AS u LEFT JOIN education AS e ON e.eid=u.edu_id LEFT JOIN duty AS d ON d.duty_id=u.duty_id LEFT JOIN organization AS o ON o.org_id=u.org_id")
	List<User> queryUsers();

	// 所有用户分页

	@Select("SELECT user_id,duty_name,duty_type,edu_name,org_name,user_name,real_name,hiredate FROM `USER` AS u LEFT JOIN education AS e ON e.eid=u.edu_id LEFT JOIN duty AS d ON d.duty_id=u.duty_id LEFT JOIN organization AS o ON o.org_id=u.org_id  LIMIT #{page},#{limit}")
	@Results({ @Result(column = "duty_name", property = "duty.dutyName"),
			@Result(column = "duty_type", property = "duty.dutyType"),
			@Result(column = "edu_name", property = "education.eduName"),
			@Result(column = "org_name", property = "organization.orgName"),
			@Result(column = "user_name", property = "userName"), @Result(column = "real_name", property = "realName"),
			@Result(column = "hiredate", property = "hiredate"), @Result(column = "user_id", property = "userId") })
	List<User> userPage(@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 查询单个员工
	 * 
	 * @param uid
	 * @return
	 */
	@Select("SELECT d.duty_name,d.duty_type,e.edu_name,o.org_name,u.* FROM USER AS u LEFT JOIN education AS e ON e.eid=u.edu_id LEFT JOIN duty AS d ON d.duty_id=u.duty_id LEFT JOIN organization AS o ON o.org_id=u.org_id where u.user_id=#{userId}")
	User queryUser(Integer uid);

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@Update("UPDATE USER SET real_name=#{realName},edu_id=#{education.eid},org_id=#{organization.orgId},duty_id=#{duty.dutyId},opt_time=#{optTime}  WHERE user_id=#{userId}")
	int updateUser(User user);

	/**
	 * 删除员工
	 * 
	 * @param uid
	 * @return
	 */
	@Delete("DELETE FROM USER WHERE user_id=#{uid}")
	int deleteUser(Integer uid);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@Insert("INSERT  INTO USER (user_name,PASSWORD,real_name,hiredate,edu_id,org_id,duty_id,opt_time)VALUES(#{userName},#{password},#{realName},#{hiredate},#{education.eid},#{organization.orgId},#{duty.dutyId},#{optTime});")
	int InsertUser(User user);

	/**
	 * 查询职务
	 * 
	 * @return
	 */
	@Select("select * from duty")
	List<Duty> queryDuty();

	@Select("SELECT  duty_type FROM duty WHERE duty_id=#{dutyId}")
	Duty findDuty(Integer dutyId);

	/**
	 * 查询学历
	 * 
	 * @return
	 */
	@Select("select * from Education")
	List<Education> queryEducation();

}
