package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 该类为权限组的表的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysRole implements Serializable{
/**
 * create table sys_role(
	id varchar(36),
	remark text,
	name varchar(100) default null,
	primary key(id)
);
 */
	private String id;//权限组编号
	private String remark;//权限组备注
	private String name;//权限组名称
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
