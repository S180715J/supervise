package com.newer.supervise.pojo;

import java.io.Serializable;

/**
 * 学历类
 * 
 * @author 周裕杰
 *
 */
public class Education implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer eid;		// 学历id
	private String eduName;		// 学历名称
	
	public Education() {
		
	}
	public Education(Integer eid, String eduName) {
		this.eid = eid;
		this.eduName = eduName;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	@Override
	public String toString() {
		return "Education [eid=" + eid + ", eduName=" + eduName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eduName == null) ? 0 : eduName.hashCode());
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
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
		Education other = (Education) obj;
		if (eduName == null) {
			if (other.eduName != null)
				return false;
		} else if (!eduName.equals(other.eduName))
			return false;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		return true;
	}
	
}
