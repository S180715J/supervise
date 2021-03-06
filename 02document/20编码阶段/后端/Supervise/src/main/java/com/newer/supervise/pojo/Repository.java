package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 备用库实体类
 * 
 * @author 周裕杰
 *
 */
public class Repository implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; // 事项id
	private Source sourceId; // 督办来源
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sourceTime; // 来源时间
	private String serialNum; // 流水号
	private FileType fileType; // 文件类型
	private String drafter; // 拟稿人
	private String drafterPhone; // 拟稿人电话
	private String itemName; // 事项名称
	private ItemProcess itemCode; // 事项编号
	private User user; // 批示人(公司领导)
	private Organization orgId; //来源部门
	private SecrecyLevel secrecyLevel; // 保密等级
	private String itemContent; // 事项内容
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date overTime; // 结束时间
	private Integer feedback; // 反馈频率(以数字代表小时)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date nextFeedback; // 下次反馈时间
	private String deptOpinion; // 部门意见
	private String leadOpinion; // 领导批示
	private Integer itemStatu; // 事项状态(0为已删除,1为未删除)
	private Integer itemType; // 事项类型(0:新增 1:同步 2:退回)
	private String remark; // 备注

	public Repository() {

	}

	public Repository(Integer id, Source sourceId, Date sourceTime, String serialNum, FileType fileType, String drafter,
			String drafterPhone, String itemName, ItemProcess itemCode, User user, Organization orgId,
			SecrecyLevel secrecyLevel, String itemContent, Date overTime, Integer feedback, Date nextFeedback,
			String deptOpinion, String leadOpinion, Integer itemStatu, Integer itemType, String remark) {
		this.id = id;
		this.sourceId = sourceId;
		this.sourceTime = sourceTime;
		this.serialNum = serialNum;
		this.fileType = fileType;
		this.drafter = drafter;
		this.drafterPhone = drafterPhone;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.user = user;
		this.orgId = orgId;
		this.secrecyLevel = secrecyLevel;
		this.itemContent = itemContent;
		this.overTime = overTime;
		this.feedback = feedback;
		this.nextFeedback = nextFeedback;
		this.deptOpinion = deptOpinion;
		this.leadOpinion = leadOpinion;
		this.itemStatu = itemStatu;
		this.itemType = itemType;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Repository [id=" + id + ", sourceId=" + sourceId + ", sourceTime=" + sourceTime + ", serialNum="
				+ serialNum + ", fileType=" + fileType + ", drafter=" + drafter + ", drafterPhone=" + drafterPhone
				+ ", itemName=" + itemName + ", itemCode=" + itemCode + ", user=" + user + ", orgId=" + orgId
				+ ", secrecyLevel=" + secrecyLevel + ", itemContent=" + itemContent + ", overTime=" + overTime
				+ ", feedback=" + feedback + ", nextFeedback=" + nextFeedback + ", deptOpinion=" + deptOpinion
				+ ", leadOpinion=" + leadOpinion + ", itemStatu=" + itemStatu + ", itemType=" + itemType + ", remark="
				+ remark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptOpinion == null) ? 0 : deptOpinion.hashCode());
		result = prime * result + ((drafter == null) ? 0 : drafter.hashCode());
		result = prime * result + ((drafterPhone == null) ? 0 : drafterPhone.hashCode());
		result = prime * result + ((feedback == null) ? 0 : feedback.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((itemContent == null) ? 0 : itemContent.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemStatu == null) ? 0 : itemStatu.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((leadOpinion == null) ? 0 : leadOpinion.hashCode());
		result = prime * result + ((nextFeedback == null) ? 0 : nextFeedback.hashCode());
		result = prime * result + ((orgId == null) ? 0 : orgId.hashCode());
		result = prime * result + ((overTime == null) ? 0 : overTime.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((secrecyLevel == null) ? 0 : secrecyLevel.hashCode());
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((sourceTime == null) ? 0 : sourceTime.hashCode());
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
		Repository other = (Repository) obj;
		if (deptOpinion == null) {
			if (other.deptOpinion != null)
				return false;
		} else if (!deptOpinion.equals(other.deptOpinion))
			return false;
		if (drafter == null) {
			if (other.drafter != null)
				return false;
		} else if (!drafter.equals(other.drafter))
			return false;
		if (drafterPhone == null) {
			if (other.drafterPhone != null)
				return false;
		} else if (!drafterPhone.equals(other.drafterPhone))
			return false;
		if (feedback == null) {
			if (other.feedback != null)
				return false;
		} else if (!feedback.equals(other.feedback))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		if (itemContent == null) {
			if (other.itemContent != null)
				return false;
		} else if (!itemContent.equals(other.itemContent))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemStatu == null) {
			if (other.itemStatu != null)
				return false;
		} else if (!itemStatu.equals(other.itemStatu))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (leadOpinion == null) {
			if (other.leadOpinion != null)
				return false;
		} else if (!leadOpinion.equals(other.leadOpinion))
			return false;
		if (nextFeedback == null) {
			if (other.nextFeedback != null)
				return false;
		} else if (!nextFeedback.equals(other.nextFeedback))
			return false;
		if (orgId == null) {
			if (other.orgId != null)
				return false;
		} else if (!orgId.equals(other.orgId))
			return false;
		if (overTime == null) {
			if (other.overTime != null)
				return false;
		} else if (!overTime.equals(other.overTime))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (secrecyLevel == null) {
			if (other.secrecyLevel != null)
				return false;
		} else if (!secrecyLevel.equals(other.secrecyLevel))
			return false;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceTime == null) {
			if (other.sourceTime != null)
				return false;
		} else if (!sourceTime.equals(other.sourceTime))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Source getSourceId() {
		return sourceId;
	}

	public void setSourceId(Source sourceId) {
		this.sourceId = sourceId;
	}

	public Date getSourceTime() {
		return sourceTime;
	}

	public void setSourceTime(Date sourceTime) {
		this.sourceTime = sourceTime;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getDrafter() {
		return drafter;
	}

	public void setDrafter(String drafter) {
		this.drafter = drafter;
	}

	public String getDrafterPhone() {
		return drafterPhone;
	}

	public void setDrafterPhone(String drafterPhone) {
		this.drafterPhone = drafterPhone;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemProcess getItemCode() {
		return itemCode;
	}

	public void setItemCode(ItemProcess itemCode) {
		this.itemCode = itemCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organization getOrgId() {
		return orgId;
	}

	public void setOrgId(Organization orgId) {
		this.orgId = orgId;
	}

	public SecrecyLevel getSecrecyLevel() {
		return secrecyLevel;
	}

	public void setSecrecyLevel(SecrecyLevel secrecyLevel) {
		this.secrecyLevel = secrecyLevel;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public Integer getFeedback() {
		return feedback;
	}

	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}

	public Date getNextFeedback() {
		return nextFeedback;
	}

	public void setNextFeedback(Date nextFeedback) {
		this.nextFeedback = nextFeedback;
	}

	public String getDeptOpinion() {
		return deptOpinion;
	}

	public void setDeptOpinion(String deptOpinion) {
		this.deptOpinion = deptOpinion;
	}

	public String getLeadOpinion() {
		return leadOpinion;
	}

	public void setLeadOpinion(String leadOpinion) {
		this.leadOpinion = leadOpinion;
	}

	public Integer getItemStatu() {
		return itemStatu;
	}

	public void setItemStatu(Integer itemStatu) {
		this.itemStatu = itemStatu;
	}

	public Integer getItemType() {
		return itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
