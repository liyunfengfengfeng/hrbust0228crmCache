package cn.itcast.bean;
/**
 * 用于系统用户下面list.jsp页面的根据条件搜索
 * @author LIYUNFENG
 *
 */
public class SysUserSearch {
	private String name;// 用户名
	private String cnName;// 中文名
	private Integer groupId;// 所属部门
	private String status;// 状态
	private String password;// 密码
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
