package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 操作表sys_popedom的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysPopedom implements Serializable{
/**
 * create table sys_popedom
 *	(
 *	popedom_Module varchar(30),#模块名称
 *	popedom_Privilege varchar(30),#操作名称
 *	sort    Integer(11),#排序
 *	popedom_Name varchar(200),#标题
 *	title varchar(200),#提示
 *	remark text,#备注
 *	primary key(popedom_Module,popedom_Privilege)
 *	);
 */
//	private String popedom_Module;//模块名称
//	private String popedom_Privilege;//操作名称
	//该类封装了模块名称与操作名称作为联合主键
	private SysPopedomId id; 
	private Integer sort;//排序
	private String popedom_Name;//标题
	private String title;//提示
	private String remark;//备注
//	public String getPopedom_Module() {
//		return popedom_Module;
//	}
//	public void setPopedom_Module(String popedom_Module) {
//		this.popedom_Module = popedom_Module;
//	}
//	public String getPopedom_Privilege() {
//		return popedom_Privilege;
//	}
//	public void setPopedom_Privilege(String popedom_Privilege) {
//		this.popedom_Privilege = popedom_Privilege;
//	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPopedom_Name() {
		return popedom_Name;
	}
	public void setPopedom_Name(String popedom_Name) {
		this.popedom_Name = popedom_Name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public SysPopedomId getId() {
		return id;
	}
	public void setId(SysPopedomId id) {
		this.id = id;
	}
}
