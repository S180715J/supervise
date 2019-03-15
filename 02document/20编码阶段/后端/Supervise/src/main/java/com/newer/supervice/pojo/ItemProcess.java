package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

public class ItemProcess implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemCode;
	private String itemStatus;
	private String itemStatusDesc;
	private Date optTime;
	private Long userId;

	public ItemProcess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemProcess(String itemCode, String itemStatus, String itemStatusDesc, Date optTime, Long userId) {
		super();
		this.itemCode = itemCode;
		this.itemStatus = itemStatus;
		this.itemStatusDesc = itemStatusDesc;
		this.optTime = optTime;
		this.userId = userId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemStatusDesc() {
		return itemStatusDesc;
	}

	public void setItemStatusDesc(String itemStatusDesc) {
		this.itemStatusDesc = itemStatusDesc;
	}

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ItemProcess [itemCode=" + itemCode + ", itemStatus=" + itemStatus + ", itemStatusDesc=" + itemStatusDesc
				+ ", optTime=" + optTime + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + ((itemStatusDesc == null) ? 0 : itemStatusDesc.hashCode());
		result = prime * result + ((optTime == null) ? 0 : optTime.hashCode());
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
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		if (itemStatusDesc == null) {
			if (other.itemStatusDesc != null)
				return false;
		} else if (!itemStatusDesc.equals(other.itemStatusDesc))
			return false;
		if (optTime == null) {
			if (other.optTime != null)
				return false;
		} else if (!optTime.equals(other.optTime))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
