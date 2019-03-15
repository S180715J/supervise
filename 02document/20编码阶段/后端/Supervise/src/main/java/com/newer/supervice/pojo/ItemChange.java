package com.newer.supervise.pojo;

import java.io.Serializable;
import java.util.Date;

public class ItemChange implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String itemCode;
	private String itemDetail;
	private Date itemTime;

	public ItemChange() {

	}

	public ItemChange(String itemCode, String itemDetail, Date itemTime) {
		this.itemCode = itemCode;
		this.itemDetail = itemDetail;
		this.itemTime = itemTime;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	@Override
	public String toString() {
		return "ItemChange [itemCode=" + itemCode + ", itemDetail=" + itemDetail + ", itemTime=" + itemTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemCode == null) ? 0 : itemCode.hashCode());
		result = prime * result + ((itemDetail == null) ? 0 : itemDetail.hashCode());
		result = prime * result + ((itemTime == null) ? 0 : itemTime.hashCode());
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
		ItemChange other = (ItemChange) obj;
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
		if (itemTime == null) {
			if (other.itemTime != null)
				return false;
		} else if (!itemTime.equals(other.itemTime))
			return false;
		return true;
	}

}
