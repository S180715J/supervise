package com.newer.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.newer.supervise.pojo.Organization;

public interface OrgMapper {

	/**
	 * 分页查询机构信息
	 * 
	 * @param limit
	 * @param page
	 * 
	 * @return
	 */
	@Select("SELECT * FROM organization LIMIT #{page},#{limit}")
	public List<Organization> getorg(Integer page, Integer limit);

	/**
	 * 按org_id查询该机构所有信息
	 * 
	 * @param org_id
	 * @return 根据org_id查询到的机构对象
	 */
	@Select("SELECT org_id,org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date FROM organization WHERE org_id=#{orgId} ")
	public Organization getorgID(Integer org_id);

	/**
	 * 添加一个机构
	 * 
	 * @param org
	 * @return 添加结果
	 */
	@Insert("INSERT INTO Organization(org_id,org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date)VALUES(#{orgId},#{orgName},#{parentOrgid},#{idPath},#{namePath},#{introduction},#{responsibility},#{operationDate})")
	public Integer insertorg(Organization org);

	/**
	 * 根据org_id删除部门信息
	 * 
	 * @param orgId
	 * @return 删除结果
	 */
	@Delete("DELETE FROM organization WHERE org_id=#{orgId}")
	public Integer delorg(@Param("orgId") Integer orgId);

	/**
	 * 根据机构父id删除机构
	 * 
	 * @param parentId 机构父id
	 * @return
	 */
	@Delete("DELETE FROM organization WHERE parent_id = #{parentOrgid}")
	Integer deleteByParentId(@Param("parentOrgid") Integer parentOrgid);

	/**
	 * 修改部门信息
	 * 
	 * @param org
	 * @return 修改结果
	 */
	@Update("UPDATE Organization SET org_name=#{orgName},parent_orgid=#{parentOrgid},id_path=#{idPath},name_path=#{namePath},introduction=#{introduction},responsibility=#{responsibility},operation_date=#{operationDate} WHERE org_id=#{orgId}")
	public Integer uporg(Organization org);

	/**
	 * 查询部门个数
	 * 
	 * @return
	 */
	@Select("SELECT COUNT(1) FROM organization")
	Integer queryCountOfDept();

	/**
	 * 查询父机构的路径
	 * 
	 * @return
	 */
	@Select("SELECT org_id,org_name,parent_orgid,id_path,name_path FROM organization")
	List<Organization> queryParentPath();
	
	/**
	 * 根据父机构id查询下属机构
	 * 
	 * @param orgid
	 * @return
	 */
	@Select("SELECT * FROM organization WHERE parent_orgid = #{orgid}")
	List<Organization> queryOrgByParentId(@Param("orgid")Integer orgid);
}
