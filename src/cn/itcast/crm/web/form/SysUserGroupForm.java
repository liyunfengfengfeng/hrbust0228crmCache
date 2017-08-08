package cn.itcast.crm.web.form;

import java.io.Serializable;

/**
 * 用于接收页面用户输入的数据 通过传递利用模型驱动
 * 
 * @author LIYUNFENG
 * 
 */
public class SysUserGroupForm implements Serializable{
	private String id; // 部门编号
	private String remark; // 备注
	private String name; // 部门名称
	private String principle;// 负责人
	private String inclument;// 部门职能

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

	public String getPrinciple() {
		return principle;
	}

	public void setPrinciple(String principle) {
		this.principle = principle;
	}

	public String getInclument() {
		return inclument;
	}

	public void setInclument(String inclument) {
		this.inclument = inclument;
	}
}
