package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 机构类
 * 
 * @author 周裕杰
 *
 */
public class Organization implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer orgId;				// 机构id
	private String orgName;				// 机构名称
	private Integer parentOrgid;		// 父机构id
	private String idPath;				// 机构id代表的路径
	private String namePath;			// 机构名称路径
	private String introduction;		// 机构简介
	private String responsibility;		// 机构职责
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operationDate;			// 对该机构的操作时间(增删改查)

	public Organization() {
		
	}

	public Organization(Integer orgId, String orgName, Integer parentOrgid, String idPath, String namePath,
			String introduction, String responsibility, Date operationDate) {
		this.orgId = orgId;
		this.orgName = orgName;
		this.parentOrgid = parentOrgid;
		this.idPath = idPath;
		this.namePath = namePath;
		this.introduction = introduction;
		this.responsibility = responsibility;
		this.operationDate = operationDate;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getParentOrgid() {
		return parentOrgid;
	}

	public void setParentOrgid(Integer parentOrgid) {
		this.parentOrgid = parentOrgid;
	}

	public String getIdPath() {
		return idPath;
	}

	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}

	public String getNamePath() {
		return namePath;
	}

	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName + ", parentOrgid=" + parentOrgid + ", idPath="
				+ idPath + ", namePath=" + namePath + ", introduction=" + introduction + ", responsibility="
				+ responsibility + ", operationDate=" + operationDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPath == null) ? 0 : idPath.hashCode());
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((namePath == null) ? 0 : namePath.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((parentOrgid == null) ? 0 : parentOrgid.hashCode());
		result = prime * result + ((responsibility == null) ? 0 : responsibility.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (idPath == null) {
			if (other.idPath != null)
				return false;
		} else if (!idPath.equals(other.idPath))
			return false;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (namePath == null) {
			if (other.namePath != null)
				return false;
		} else if (!namePath.equals(other.namePath))
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (parentOrgid == null) {
			if (other.parentOrgid != null)
				return false;
		} else if (!parentOrgid.equals(other.parentOrgid))
			return false;
		if (responsibility == null) {
			if (other.responsibility != null)
				return false;
		} else if (!responsibility.equals(other.responsibility))
			return false;
		return true;
	}

}
