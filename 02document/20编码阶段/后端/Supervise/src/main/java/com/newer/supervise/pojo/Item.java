package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 事项关系表实体类
 * 
 * @author W419
 *
 */
public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	/**
	 * 事项编号
	 */
	private String itemCode;
	/**
	 * 事项状态
	 */
	private String itemStatus;
	/**
	 * 事项状态描述
	 */
	private String itemStatusDesc;
	/**
	 * 操作时间
	 */
	private Date optTime;
	/**
	 * 关联用户
	 */
	private User user;
	/**
	 * 关联部门
	 */
	private Organication org;
	/**
	 * 是否为主办部门
	 */
	private String isPrimary;
	/**
	 * 事项明细
	 */
	private String itemDetail;
	/**
	 * 事项变更时间
	 */
	private Date itemTime;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organication getOrg() {
		return org;
	}

	public void setOrg(Organication org) {
		this.org = org;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Date getItemTime() {
		return itemTime;
	}

	public void setItemTime(Date itemTime) {
		this.itemTime = itemTime;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String itemCode, String itemStatus, String itemStatusDesc, Date optTime, User user, Organication org,
			String isPrimary, String itemDetail, Date itemTime) {
		super();
		this.itemCode = itemCode;
		this.itemStatus = itemStatus;
		this.itemStatusDesc = itemStatusDesc;
		this.optTime = optTime;
		this.user = user;
		this.org = org;
		this.isPrimary = isPrimary;
		this.itemDetail = itemDetail;
		this.itemTime = itemTime;
	}

	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", itemStatus=" + itemStatus + ", itemStatusDesc=" + itemStatusDesc
				+ ", optTime=" + optTime + ", user=" + user + ", org=" + org + ", isPrimary=" + isPrimary
				+ ", itemDetail=" + itemDetail + ", itemTime=" + itemTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isPrimary == null) ? 0 : isPrimary.hashCode());
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((itemDetail == null) ? 0 : itemDetail.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + ((itemStatusDesc == null) ? 0 : itemStatusDesc.hashCode());
		result = prime * result + ((itemTime == null) ? 0 : itemTime.hashCode());
		result = prime * result + ((optTime == null) ? 0 : optTime.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Item other = (Item) obj;
		if (isPrimary == null) {
			if (other.isPrimary != null)
				return false;
		} else if (!isPrimary.equals(other.isPrimary))
			return false;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		if (itemDetail == null) {
			if (other.itemDetail != null)
				return false;
		} else if (!itemDetail.equals(other.itemDetail))
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
		if (itemTime == null) {
			if (other.itemTime != null)
				return false;
		} else if (!itemTime.equals(other.itemTime))
			return false;
		if (optTime == null) {
			if (other.optTime != null)
				return false;
		} else if (!optTime.equals(other.optTime))
			return false;
		if (org == null) {
			if (other.org != null)
				return false;
		} else if (!org.equals(other.org))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
