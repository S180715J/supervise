package com.newer.supervise.pojo;
/**
 * 事项进程
 * @author W419
 *
 */

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer statuId;
	private String itemCode;
	private String statuDescribe;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date optTime;
	private User userId;

	public Integer getStatuId() {
		return statuId;
	}

	public void setStatuId(Integer statuId) {
		this.statuId = statuId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getStatuDescribe() {
		return statuDescribe;
	}

	public void setStatuDescribe(String statuDescribe) {
		this.statuDescribe = statuDescribe;
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public ItemProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemProcess(Integer statuId, String itemCode, String statuDescribe, Date optTime, User userId) {
		super();
		this.statuId = statuId;
		this.itemCode = itemCode;
		this.statuDescribe = statuDescribe;
		this.optTime = optTime;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ItemProcess [statuId=" + statuId + ", itemCode=" + itemCode + ", statuDescribe=" + statuDescribe
				+ ", optTime=" + optTime + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((optTime == null) ? 0 : optTime.hashCode());
		result = prime * result + ((statuDescribe == null) ? 0 : statuDescribe.hashCode());
		result = prime * result + ((statuId == null) ? 0 : statuId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ItemProcess other = (ItemProcess) obj;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		if (optTime == null) {
			if (other.optTime != null)
				return false;
		} else if (!optTime.equals(other.optTime))
			return false;
		if (statuDescribe == null) {
			if (other.statuDescribe != null)
				return false;
		} else if (!statuDescribe.equals(other.statuDescribe))
			return false;
		if (statuId == null) {
			if (other.statuId != null)
				return false;
		} else if (!statuId.equals(other.statuId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
