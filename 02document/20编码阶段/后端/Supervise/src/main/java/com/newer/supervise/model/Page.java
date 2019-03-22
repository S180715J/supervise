package com.newer.supervise.model;

import java.io.Serializable;
import java.util.List;

/**
 * 该类为分页模型类<br>
 * 所有属性均为layUI分页所必须项<br>
 * 泛型可方便使用者自定义类型，所有分页均可通过传入具体类型而完成<br>
 * 注意：编写分页方法者需传递参数page(当前页码),limit(限制条数)<br>
 * 参数page和limit可通过在controller层使用@RequestParam获得<br>
 * 示例:@RequestParam(value="page",required=false,defaultValue="1")<br>
 * @RequestParam(value="limit",required=false,defaultValue="5")<br>
 * 注意：value值不可改变，为layUI所定义参数！<br>
 * 
 * @author 周裕杰
 * @ @param <T>
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	private String msg;
	private Integer count;
	private List<T> data;

	public Page() {
		
	}

	public Page(Integer code, String msg, Integer count, List<T> data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Page [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
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
		Page<?> other = (Page<?>) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}

}
