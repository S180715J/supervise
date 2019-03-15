package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 备用库(事项)表实体类
 * 
 * @author W419
 *
 */
public class ItemRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 事项id
	 */
	private Long id;
	/**
	 * 事项来源
	 */
	private String source;
	/**
	 * 来源时间
	 */
	private Date sourceTime;
	/**
	 * 原流水号
	 */
	private String serialNum;
	/**
	 * 文件类型
	 */
	private String fileType;
	/**
	 * 原拟稿人
	 */
	private String drafter;
	/**
	 * 原件联系电话
	 */
	private String drafterTel;
	/**
	 * 事项名称
	 */
	private String itemName;
	/**
	 * 事项编号(关联事项关系表)
	 */
	private Item item;
	/**
	 * 对方单位
	 */
	private String adverseCompany;
	/**
	 * 密级
	 */
	private String secrity;
	/**
	 * 事项内容
	 */
	private String itemContent;
	/**
	 * 应办结时间
	 */
	private Date overTime;
	/**
	 * 反馈频率
	 */
	private String callBack;
	/**
	 * 下次反馈时间
	 */
	private Date nextCalltime;
	/**
	 * 部门意见
	 */
	private String itemDeptIdea;
	/**
	 * 领导批示
	 */
	private String leaderIdea;
	/**
	 * 事项状态
	 */
	private String itemStatus;
	/**
	 * 备注
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getDrafter() {
		return drafter;
	}

	public void setDrafter(String drafter) {
		this.drafter = drafter;
	}

	public String getDrafterTel() {
		return drafterTel;
	}

	public void setDrafterTel(String drafterTel) {
		this.drafterTel = drafterTel;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Item getItem() {
		return item;
	}

	public void setItemCode(Item  item) {
		this.item = item;
	}

	public String getAdverseCompany() {
		return adverseCompany;
	}

	public void setAdverseCompany(String adverseCompany) {
		this.adverseCompany = adverseCompany;
	}

	public String getSecrity() {
		return secrity;
	}

	public void setSecrity(String secrity) {
		this.secrity = secrity;
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

	public String getCallBack() {
		return callBack;
	}

	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}

	public Date getNextCalltime() {
		return nextCalltime;
	}

	public void setNextCalltime(Date nextCalltime) {
		this.nextCalltime = nextCalltime;
	}

	public String getItemDeptIdea() {
		return itemDeptIdea;
	}

	public void setItemDeptIdea(String itemDeptIdea) {
		this.itemDeptIdea = itemDeptIdea;
	}

	public String getLeaderIdea() {
		return leaderIdea;
	}

	public void setLeaderIdea(String leaderIdea) {
		this.leaderIdea = leaderIdea;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ItemRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemRepository(Long id, String source, Date sourceTime, String serialNum, String fileType, String drafter,
			String drafterTel, String itemName, Item  item, String adverseCompany, String secrity,
			String itemContent, Date overTime, String callBack, Date nextCalltime, String itemDeptIdea,
			String leaderIdea, String itemStatus, String remark) {
		super();
		this.id = id;
		this.source = source;
		this.sourceTime = sourceTime;
		this.serialNum = serialNum;
		this.fileType = fileType;
		this.drafter = drafter;
		this.drafterTel = drafterTel;
		this.itemName = itemName;
		this.item= item;
		this.adverseCompany = adverseCompany;
		this.secrity = secrity;
		this.itemContent = itemContent;
		this.overTime = overTime;
		this.callBack = callBack;
		this.nextCalltime = nextCalltime;
		this.itemDeptIdea = itemDeptIdea;
		this.leaderIdea = leaderIdea;
		this.itemStatus = itemStatus;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ItemRepository [id=" + id + ", source=" + source + ", sourceTime=" + sourceTime + ", serialNum="
				+ serialNum + ", fileType=" + fileType + ", drafter=" + drafter + ", drafterTel=" + drafterTel
				+ ", itemName=" + itemName + ", itemCode=" + item + ", adverseCompany=" + adverseCompany
				+ ", secrity=" + secrity + ", itemContent=" + itemContent + ", overTime=" + overTime + ", callBack="
				+ callBack + ", nextCalltime=" + nextCalltime + ", itemDeptIdea=" + itemDeptIdea + ", leaderIdea="
				+ leaderIdea + ", itemStatus=" + itemStatus + ", remark=" + remark + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adverseCompany == null) ? 0 : adverseCompany.hashCode());
		result = prime * result + ((callBack == null) ? 0 : callBack.hashCode());
		result = prime * result + ((drafter == null) ? 0 : drafter.hashCode());
		result = prime * result + ((drafterTel == null) ? 0 : drafterTel.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemContent == null) ? 0 : itemContent.hashCode());
		result = prime * result + ((itemDeptIdea == null) ? 0 : itemDeptIdea.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + ((leaderIdea == null) ? 0 : leaderIdea.hashCode());
		result = prime * result + ((nextCalltime == null) ? 0 : nextCalltime.hashCode());
		result = prime * result + ((overTime == null) ? 0 : overTime.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((secrity == null) ? 0 : secrity.hashCode());
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((sourceTime == null) ? 0 : sourceTime.hashCode());
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
		ItemRepository other = (ItemRepository) obj;
		if (adverseCompany == null) {
			if (other.adverseCompany != null)
				return false;
		} else if (!adverseCompany.equals(other.adverseCompany))
			return false;
		if (callBack == null) {
			if (other.callBack != null)
				return false;
		} else if (!callBack.equals(other.callBack))
			return false;
		if (drafter == null) {
			if (other.drafter != null)
				return false;
		} else if (!drafter.equals(other.drafter))
			return false;
		if (drafterTel == null) {
			if (other.drafterTel != null)
				return false;
		} else if (!drafterTel.equals(other.drafterTel))
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemContent == null) {
			if (other.itemContent != null)
				return false;
		} else if (!itemContent.equals(other.itemContent))
			return false;
		if (itemDeptIdea == null) {
			if (other.itemDeptIdea != null)
				return false;
		} else if (!itemDeptIdea.equals(other.itemDeptIdea))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		if (leaderIdea == null) {
			if (other.leaderIdea != null)
				return false;
		} else if (!leaderIdea.equals(other.leaderIdea))
			return false;
		if (nextCalltime == null) {
			if (other.nextCalltime != null)
				return false;
		} else if (!nextCalltime.equals(other.nextCalltime))
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
		if (secrity == null) {
			if (other.secrity != null)
				return false;
		} else if (!secrity.equals(other.secrity))
			return false;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (sourceTime == null) {
			if (other.sourceTime != null)
				return false;
		} else if (!sourceTime.equals(other.sourceTime))
			return false;
		return true;
	}

}
