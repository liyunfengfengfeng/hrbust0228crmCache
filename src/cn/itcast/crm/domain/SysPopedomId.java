package cn.itcast.crm.domain;

import java.io.Serializable;

/**
 * 联合主键的处理方式
 * 
 * @author LIYUNFENG
 * 
 */
@SuppressWarnings("serial")
public class SysPopedomId implements Serializable {
	private String popedom_Module;// 模块名称
	private String popedom_Privilege;// 操作名称

	public String getPopedom_Module() {
		return popedom_Module;
	}

	public void setPopedom_Module(String popedom_Module) {
		this.popedom_Module = popedom_Module;
	}

	public String getPopedom_Privilege() {
		return popedom_Privilege;
	}

	public void setPopedom_Privilege(String popedom_Privilege) {
		this.popedom_Privilege = popedom_Privilege;
	}
	/**
	 * 实现equals 与 hashcode 方法 保证主键的唯一性
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((popedom_Module == null) ? 0 : popedom_Module.hashCode());
		result = prime
				* result
				+ ((popedom_Privilege == null) ? 0 : popedom_Privilege
						.hashCode());
		return result;
	}
	/**
	 * 实现equals 与 hashcode 方法 保证主键的唯一性
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysPopedomId other = (SysPopedomId) obj;
		if (popedom_Module == null) {
			if (other.popedom_Module != null)
				return false;
		} else if (!popedom_Module.equals(other.popedom_Module))
			return false;
		if (popedom_Privilege == null) {
			if (other.popedom_Privilege != null)
				return false;
		} else if (!popedom_Privilege.equals(other.popedom_Privilege))
			return false;
		return true;
	}
}
