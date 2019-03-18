package com.supervise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.supervise.pojo.Organization;



@Repository
public interface OrgMapper {
	 //查询部门所以信息
	@Select("SELECT org_id,org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date FROM organization")
	public List<Organization > getorg();
	//按org_id查询所有信息
	@Select("SELECT org_id,org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date FROM organization WHERE org_id=#{orgId} ")
	public int getorgID(Integer org_id);
	//新增部门信息
	@Insert("INSERT INTO Organization(org_name,parent_orgid,id_path,name_path,introduction,responsibility,operation_date)VALUES(#{orgName},#{parentOrgid},#{idPath},#{namePath},#{introduction},#{responsibility},#{operationDate})")
	public int insertorg(Organization org);
	//org_id删除部门信息
	@Delete("DELETE FROM Organization WHERE org_id=#{orgId}")
	public int delorg(@Param("orgId")	Integer orgId);
	//修改部门信息
	@Update("UPDATE Organization SET org_name=#{orgName},parent_orgid=#{parentOrgid},id_path=#{idPath},name_path=#{namePath},introduction=#{introduction},responsibility=#{responsibility},operation_date=#{operationDate} WHERE org_id=#{orgId}")
	public int uporg(Organization org);
}
