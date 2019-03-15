package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构表实体类
 * 
 * @author W419
 *
 */
public class Organication implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 机构ID
	 */
	private Long orgid;
	/**
	 * 机构编码
	 */
	private String orgcode;
	/**
	 * 机构名称
	 */
	private String orgname;
	/**
	 * 父机构ID
	 */
	private Long parentOrgid;
	/**
	 * 机构ID路径
	 */
	private String idpath;
	/**
	 * 机构名称路径
	 */
	private String namePath;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 职责
	 */
	private String job;
	/**
	 * 操作日期
	 */
	private Date orgTime;
	/**
	 * 排序号
	 */
	private Integer order;

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Long getParentOrgid() {
		return parentOrgid;
	}

	public void setParentOrgid(Long parentOrgid) {
		this.parentOrgid = parentOrgid;
	}

	public String getIdpath() {
		return idpath;
	}

	public void setIdpath(String idpath) {
		this.idpath = idpath;
	}

	public String getNamePath() {
		return namePath;
	}

	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getOrgTime() {
		return orgTime;
	}

	public void setOrgTime(Date orgTime) {
		this.orgTime = orgTime;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Organication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organication(Long orgid, String orgcode, String orgname, Long parentOrgid, String idpath, String namePath,
			String intro, String job, Date orgTime, Integer order) {
		super();
		this.orgid = orgid;
		this.orgcode = orgcode;
		this.orgname = orgname;
		this.parentOrgid = parentOrgid;
		this.idpath = idpath;
		this.namePath = namePath;
		this.intro = intro;
		this.job = job;
		this.orgTime = orgTime;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Organication [orgid=" + orgid + ", orgcode=" + orgcode + ", orgname=" + orgname + ", parentOrgid="
				+ parentOrgid + ", idpath=" + idpath + ", namePath=" + namePath + ", intro=" + intro + ", job=" + job
				+ ", orgTime=" + orgTime + ", order=" + order + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpath == null) ? 0 : idpath.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((namePath == null) ? 0 : namePath.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((orgTime == null) ? 0 : orgTime.hashCode());
		result = prime * result + ((orgcode == null) ? 0 : orgcode.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		result = prime * result + ((orgname == null) ? 0 : orgname.hashCode());
		result = prime * result + ((parentOrgid == null) ? 0 : parentOrgid.hashCode());
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
		Organication other = (Organication) obj;
		if (idpath == null) {
			if (other.idpath != null)
				return false;
		} else if (!idpath.equals(other.idpath))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (namePath == null) {
			if (other.namePath != null)
				return false;
		} else if (!namePath.equals(other.namePath))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (orgTime == null) {
			if (other.orgTime != null)
				return false;
		} else if (!orgTime.equals(other.orgTime))
			return false;
		if (orgcode == null) {
			if (other.orgcode != null)
				return false;
		} else if (!orgcode.equals(other.orgcode))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		if (orgname == null) {
			if (other.orgname != null)
				return false;
		} else if (!orgname.equals(other.orgname))
			return false;
		if (parentOrgid == null) {
			if (other.parentOrgid != null)
				return false;
		} else if (!parentOrgid.equals(other.parentOrgid))
			return false;
		return true;
	}

}
