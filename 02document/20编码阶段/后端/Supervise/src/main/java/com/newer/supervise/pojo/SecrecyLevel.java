package com.newer.supervise.pojo;

import java.io.Serializable;

/**
 * 保密等级类
 * 
 * @author 周裕杰
 *
 */
public class SecrecyLevel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String levelId; // 等级id
	private String levelName; // 等级名称

	public SecrecyLevel() {

	}

	public SecrecyLevel(String levelId, String levelName) {
		this.levelId = levelId;
		this.levelName = levelName;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Override
	public String toString() {
		return "SecrecyLevel [levelId=" + levelId + ", levelName=" + levelName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((levelId == null) ? 0 : levelId.hashCode());
		result = prime * result + ((levelName == null) ? 0 : levelName.hashCode());
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
		SecrecyLevel other = (SecrecyLevel) obj;
		if (levelId == null) {
			if (other.levelId != null)
				return false;
		} else if (!levelId.equals(other.levelId))
			return false;
		if (levelName == null) {
			if (other.levelName != null)
				return false;
		} else if (!levelName.equals(other.levelName))
			return false;
		return true;
	}

}
