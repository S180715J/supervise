package com.newer.supervise.pojo;

import java.io.Serializable;

/**
 * 任务进展类
 * 
 * @author 周裕杰
 *
 */
public class TaskType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer taskId;
	private String typeName;

	public TaskType() {

	}

	public TaskType(Integer taskId, String typeName) {
		this.taskId = taskId;
		this.typeName = typeName;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "TaskType [taskId=" + taskId + ", typeName=" + typeName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		TaskType other = (TaskType) obj;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

}
