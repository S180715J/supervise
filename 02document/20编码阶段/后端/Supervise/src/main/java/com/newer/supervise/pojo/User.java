package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体类
 * 
 * @author W419
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID
	 */
	private Long userid;
	/**
	 * 用户登录名
	 */
	private String userName;
	/**
	 * 用户真实姓名
	 */
	private String realName;
	/**
	 * 入职日期
	 */
	private Date hireDate;
	/**
	 * 学历
	 */
	private String edu;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 部门
	 */
	private Organication org;
	/**
	 * 职务
	 */
	private String job;
	/**
	 * 职务类别
	 */
	private String jobType;
	/**
	 * 操作日期
	 */
	private Date userTime;

	public User() {

	}

	public User(Long userid, String userName, String realName, Date hireDate, String edu, String gender,
			Organication org, String job, String jobType, Date userTime) {
		this.userid = userid;
		this.userName = userName;
		this.realName = realName;
		this.hireDate = hireDate;
		this.edu = edu;
		this.gender = gender;
		this.org = org;
		this.job = job;
		this.jobType = jobType;
		this.userTime = userTime;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Organication getOrg() {
		return org;
	}

	public void setOrg(Organication org) {
		this.org = org;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", realName=" + realName + ", hireDate=" + hireDate
				+ ", edu=" + edu + ", gender=" + gender + ", org=" + org + ", job=" + job + ", jobType=" + jobType
				+ ", userTime=" + userTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edu == null) ? 0 : edu.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userTime == null) ? 0 : userTime.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		User other = (User) obj;
		if (edu == null) {
			if (other.edu != null)
				return false;
		} else if (!edu.equals(other.edu))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (jobType == null) {
			if (other.jobType != null)
				return false;
		} else if (!jobType.equals(other.jobType))
			return false;
		if (org == null) {
			if (other.org != null)
				return false;
		} else if (!org.equals(other.org))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userTime == null) {
			if (other.userTime != null)
				return false;
		} else if (!userTime.equals(other.userTime))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

}
