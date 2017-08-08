package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 建立菜单权限表的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysMenuPrivilege implements Serializable{
/**
 * CREATE TABLE sys_menu_privilege
 *(
 *   roleId         VARCHAR(36),     #权限组编号
 *   menuModule     VARCHAR(30),     #模块名称
 *   menuPrivilege  VARCHAR(30),     #操作名称
 *   PRIMARY KEY(roleId,menuModule,menuPrivilege)
 *)
 */
	private SysMenuPrivilegeId id;//联合主键id

	public SysMenuPrivilegeId getId() {
		return id;
	}

	public void setId(SysMenuPrivilegeId id) {
		this.id = id;
	}

	
}
