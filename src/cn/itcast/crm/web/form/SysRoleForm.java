package cn.itcast.crm.web.form;

import java.io.Serializable;
/**
 * 模型驱动需要的权限组Form类
 * @author LIYUNFENG
 *
 */
public class SysRoleForm implements Serializable{
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
