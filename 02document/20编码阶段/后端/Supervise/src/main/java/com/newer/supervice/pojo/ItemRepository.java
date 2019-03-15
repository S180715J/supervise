package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

public class ItemRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String source;
	private Date sourceTime;
	private String serialNum;
	private String fileType;
	private String drafter;
	private String drafterTel;
	private String itemName;
	private String itemCode;
	private String adverseCompany;
	private String secrity;
	private String itemContent;
	private Date overTime;
	private String callBack;
	private Date nextCalltime;
	private String itemDeptIdea;
	private String leaderIdea;
	private String itemStatus;
	private String remark;

	public ItemRepository() {

	}

	public ItemRepository(Long id, String source, Date sourceTime, String serialNum, String fileType, String drafter,
			String drafterTel, String itemName, String itemCode, String adverseCompany, String secrity,
			String itemContent, Date overTime, String callBack, Date nextCalltime, String itemDeptIdea,
			String leaderIdea, String itemStatus, String remark) {
		this.id = id;
		this.source = source;
		this.sourceTime = sourceTime;
		this.serialNum = serialNum;
		this.fileType = fileType;
		this.drafter = drafter;
		this.drafterTel = drafterTel;
		this.itemName = itemName;
		this.itemCode = itemCode;
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

}
