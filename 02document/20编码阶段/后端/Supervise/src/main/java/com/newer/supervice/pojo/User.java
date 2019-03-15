package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long userid;
	private String username;
	private String realname;
	private Date hiredate;
	private String edu;
	private String gender;
	private Long orgid;
	private String job;
	private String jobtype;
	private Date optTime;

	public User() {
		
	}

	public User(Long userid, String username, String realname, Date hiredate, String edu, String gender, Long orgid,
			String job, String jobtype, Date optTime) {
		this.userid = userid;
		this.username = username;
		this.realname = realname;
		this.hiredate = hiredate;
		this.edu = edu;
		this.gender = gender;
		this.orgid = orgid;
		this.job = job;
		this.jobtype = jobtype;
		this.optTime = optTime;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
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

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", realname=" + realname + ", hiredate=" + hiredate
				+ ", edu=" + edu + ", gender=" + gender + ", orgid=" + orgid + ", job=" + job + ", jobtype=" + jobtype
				+ ", optTime=" + optTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edu == null) ? 0 : edu.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hiredate == null) ? 0 : hiredate.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobtype == null) ? 0 : jobtype.hashCode());
		result = prime * result + ((optTime == null) ? 0 : optTime.hashCode());
		result = prime * result + ((orgid == null) ? 0 : orgid.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (hiredate == null) {
			if (other.hiredate != null)
				return false;
		} else if (!hiredate.equals(other.hiredate))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (jobtype == null) {
			if (other.jobtype != null)
				return false;
		} else if (!jobtype.equals(other.jobtype))
			return false;
		if (optTime == null) {
			if (other.optTime != null)
				return false;
		} else if (!optTime.equals(other.optTime))
			return false;
		if (orgid == null) {
			if (other.orgid != null)
				return false;
		} else if (!orgid.equals(other.orgid))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
