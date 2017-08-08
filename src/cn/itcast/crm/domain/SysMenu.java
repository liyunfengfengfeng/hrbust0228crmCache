package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 菜单表
 * 存储该系统具有的所有的菜单
 * 菜单表的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysMenu implements Serializable{
/**
 * CREATE TABLE sys_menu
 *(
 *   menuModule     VARCHAR(30),                              #模块名称
 *   menuPrivilege  VARCHAR(30),                              #操作名称 
 *   sort           INTEGER(11),                              #排序字段              
 *   menuName       VARCHAR(200),                             #中文名称
 *   title          VARCHAR(200),                             #标题
 *   url            VARCHAR(200),                             #链接路径
 *   target         VARCHAR(20),                              #目标框架
 *   icon           VARCHAR(20),                              #使用的图标
 *   remark         TEXT,                                     #说明
 *   PRIMARY KEY(menuModule,menuPrivilege)
 *)  
 */
	private SysMenuId id;
	private Integer sort;// 排序
	private String menuName;// 菜单名称
	private String title;// 提示
	private String url;// 链接
	private String target;// 目标框架
	private String icon;// 图片的位置
	private String remark;// 备注

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysMenuId getId() {
		return id;
	}

	public void setId(SysMenuId id) {
		this.id = id;
	}
}
