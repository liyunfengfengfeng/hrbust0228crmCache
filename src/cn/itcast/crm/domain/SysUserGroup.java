package cn.itcast.crm.domain;
/**
 * 建立部门表的po对象
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysUserGroup implements java.io.Serializable{
/**
 *create table sys_user_group(
 *id Integer not null auto_increment,
 *remark text,
 *name varchar(100) not null,
 *principle varchar(50) not null,
 *inclument varchar(200) not null,
 *primary key(id)
 *);
 */
	private Integer id;      //部门编号
	private String remark;   //备注
	private String name;     //部门名称
	private String principle;//负责人
	private String inclument;//部门职能
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
