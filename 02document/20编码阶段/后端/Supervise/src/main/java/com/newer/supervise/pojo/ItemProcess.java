package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 事项进程
 * 
 * @author W419
 *
 */
public class ItemProcess implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer statuId;// 保存进程记录id
	private String itemCode;// 事项编号
	private String statuDescribe;// 状态描述
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date optTime;// 操作时间
	private User userId;// 操作人
	private Integer supStatu;// 0:未完成 1:已完成 2:退回 督办员操作
	private Integer orgStatu;// 0:未完成 1:已完成 2:退回 督办员操作
	private Integer staffStatu;// 0:未完成 1:已完成 2:退回 督办员操作
	private TaskType taskType; // 事项进展

	public ItemProcess() {

	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public ItemProcess(Integer statuId, String itemCode, String statuDescribe, Date optTime, User userId,
			Integer supStatu, Integer orgStatu, Integer staffStatu, TaskType taskType) {
		this.statuId = statuId;
		this.itemCode = itemCode;
		this.statuDescribe = statuDescribe;
		this.optTime = optTime;
		this.userId = userId;
		this.supStatu = supStatu;
		this.orgStatu = orgStatu;
		this.staffStatu = staffStatu;
		this.taskType = taskType;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

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

	public Integer getSupStatu() {
		return supStatu;
	}

	public void setSupStatu(Integer supStatu) {
		this.supStatu = supStatu;
	}

	public Integer getOrgStatu() {
		return orgStatu;
	}

	public void setOrgStatu(Integer orgStatu) {
		this.orgStatu = orgStatu;
	}

	public Integer getStaffStatu() {
		return staffStatu;
	}

	public void setStaffStatu(Integer staffStatu) {
		this.staffStatu = staffStatu;
	}

	@Override
	public String toString() {
		return "ItemProcess [statuId=" + statuId + ", itemCode=" + itemCode + ", statuDescribe=" + statuDescribe
				+ ", optTime=" + optTime + ", userId=" + userId + ", supStatu=" + supStatu + ", orgStatu=" + orgStatu
				+ ", staffStatu=" + staffStatu + ", taskType=" + taskType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((optTime == null) ? 0 : optTime.hashCode());
		result = prime * result + ((orgStatu == null) ? 0 : orgStatu.hashCode());
		result = prime * result + ((staffStatu == null) ? 0 : staffStatu.hashCode());
		result = prime * result + ((statuDescribe == null) ? 0 : statuDescribe.hashCode());
		result = prime * result + ((statuId == null) ? 0 : statuId.hashCode());
		result = prime * result + ((supStatu == null) ? 0 : supStatu.hashCode());
		result = prime * result + ((taskType == null) ? 0 : taskType.hashCode());
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
		if (orgStatu == null) {
			if (other.orgStatu != null)
				return false;
		} else if (!orgStatu.equals(other.orgStatu))
			return false;
		if (staffStatu == null) {
			if (other.staffStatu != null)
				return false;
		} else if (!staffStatu.equals(other.staffStatu))
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
		if (supStatu == null) {
			if (other.supStatu != null)
				return false;
		} else if (!supStatu.equals(other.supStatu))
			return false;
		if (taskType == null) {
			if (other.taskType != null)
				return false;
		} else if (!taskType.equals(other.taskType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
