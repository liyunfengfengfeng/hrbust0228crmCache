package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 该类用于处理联合主键的方式
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysPopedomPrivilegeId implements Serializable{
	
	private String roleId;// 权限组编号
	private String popedom_Module;// 模块名称
	private String popedom_Privilege;// 操作名称

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

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
}
