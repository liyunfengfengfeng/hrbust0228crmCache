package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 该类为sys_popedom_privilege的po类
 * 首先通过sys_popedom表中迭代出系统具有的
 * 所有功能然后再保存在sys_popedom_privilege中
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysPopedomPrivilege implements Serializable{
/**
 * create table sys_popedom_privilege(
 *	roleId varchar(36) default null,#权限组编号
 *	popedom_Module varchar(30),#模块名称
 *	popedom_Privilege varchar(30),#操作名称
 *	primary key(roleId,popedom_Module,popedom_Privilege)
 *);    
 */
	//处理联合主键的方式
	private SysPopedomPrivilegeId id;

	public SysPopedomPrivilegeId getId() {
		return id;
	}
	
	public void setId(SysPopedomPrivilegeId id) {
		this.id = id;
	}
}
