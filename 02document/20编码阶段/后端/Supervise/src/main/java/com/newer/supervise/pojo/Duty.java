package com.newer.supervise.pojo;

/**
 * 职务类
 * 
 * @author 周裕杰
 *
 */
public class Duty {

	private Integer dutyId;		// 职务id
	private String dutyName;	// 职务名称
	private String dutyType;	// 职务类别

	public Duty() {

	}

	public Duty(Integer dutyId, String dutyName, String dutyType) {
		this.dutyId = dutyId;
		this.dutyName = dutyName;
		this.dutyType = dutyType;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getDutyType() {
		return dutyType;
	}

	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}

	@Override
	public String toString() {
		return "Duty [dutyId=" + dutyId + ", dutyName=" + dutyName + ", dutyType=" + dutyType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dutyId == null) ? 0 : dutyId.hashCode());
		result = prime * result + ((dutyName == null) ? 0 : dutyName.hashCode());
		result = prime * result + ((dutyType == null) ? 0 : dutyType.hashCode());
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
		Duty other = (Duty) obj;
		if (dutyId == null) {
			if (other.dutyId != null)
				return false;
		} else if (!dutyId.equals(other.dutyId))
			return false;
		if (dutyName == null) {
			if (other.dutyName != null)
				return false;
		} else if (!dutyName.equals(other.dutyName))
			return false;
		if (dutyType == null) {
			if (other.dutyType != null)
				return false;
		} else if (!dutyType.equals(other.dutyType))
			return false;
		return true;
	}

}
