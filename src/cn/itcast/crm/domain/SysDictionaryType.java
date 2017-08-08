package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 类型信息表
 * 该表是用来存储下拉列表里的数据
 * 从该表中查的迭代到前台页面
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class SysDictionaryType implements Serializable{
/**
 * CREATE TABLE `sys_dictionary_type` (
 * `id` INT(11) NOT NULL AUTO_INCREMENT,             #编号
 * `sort` INT(11) DEFAULT NULL,                      #排序序号  该值初始值等id的值(上移 下移)********
 * `remark` TEXT,                                    #备注
 * `code`  VARCHAR(100) DEFAULT NULL,                #类型唯一标识
 * `value` VARCHAR(200) DEFAULT NULL,                #细节名称例如(东北,华北),
 * `sysFlag` CHAR(1) DEFAULT NULL,                   #是否有效  'N' 表示删除掉    'Y' 可用
 *  PRIMARY KEY  (`id`)
 * )
 */
	private Integer id; // #编号
	private Integer sort; // #排序序号 该值初始值等id的值(上移 下移)********
	private String remark; // #备注
	private String code; // #类型唯一标识
	private String value; // #细节名称例如(东北,华北),
	private String sysFlag; // #是否有效 'N' 表示删除掉 'Y' 可用

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}
}
