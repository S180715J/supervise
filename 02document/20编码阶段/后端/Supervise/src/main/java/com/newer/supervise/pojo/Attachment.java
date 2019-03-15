package com.newer.supervise.pojo;

import java.io.Serializable;

/**
 * 附件表实体类（文件）
 * @author W419
 *
 */
public class Attachment implements Serializable {
	    
	
	private static final long serialVersionUID = 1L;
		/**
	     * 资源ID
	     */
        private Long id;
        /**
         * 附件名称
         */
        private String name;
        /**
         * 附件名称路径
         */
        private String path;
        /**
         * 关联事项表
         */
        private Item  item;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public Item getItem() {
			return item;
		}
		public void setItem(Item item) {
			this.item = item;
		}
		public Attachment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Attachment(Long id, String name, String path, Item item) {
			super();
			this.id = id;
			this.name = name;
			this.path = path;
			this.item = item;
		}
		@Override
		public String toString() {
			return "Attachment [id=" + id + ", name=" + name + ", path=" + path + ", item=" + item + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((path == null) ? 0 : path.hashCode());
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
			Attachment other = (Attachment) obj;
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
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (path == null) {
				if (other.path != null)
					return false;
			} else if (!path.equals(other.path))
				return false;
			return true;
		}
        
        
}
