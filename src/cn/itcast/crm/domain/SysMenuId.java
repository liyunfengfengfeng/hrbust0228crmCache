package cn.itcast.crm.domain;

import java.io.Serializable;

/**
 * 该类为联合主键的处理方式
 * 
 * @author LIYUNFENG
 * 
 */
@SuppressWarnings("serial")
public class SysMenuId implements Serializable {
	private String menuModule;// 模块名称
	private String menuPrivilege;// 操作名称

	public String getMenuModule() {
		return menuModule;
	}

	public void setMenuModule(String menuModule) {
		this.menuModule = menuModule;
	}

	public String getMenuPrivilege() {
		return menuPrivilege;
	}

	public void setMenuPrivilege(String menuPrivilege) {
		this.menuPrivilege = menuPrivilege;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((menuModule == null) ? 0 : menuModule.hashCode());
		result = prime * result
				+ ((menuPrivilege == null) ? 0 : menuPrivilege.hashCode());
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
		SysMenuId other = (SysMenuId) obj;
		if (menuModule == null) {
			if (other.menuModule != null)
				return false;
		} else if (!menuModule.equals(other.menuModule))
			return false;
		if (menuPrivilege == null) {
			if (other.menuPrivilege != null)
				return false;
		} else if (!menuPrivilege.equals(other.menuPrivilege))
			return false;
		return true;
	}
}
