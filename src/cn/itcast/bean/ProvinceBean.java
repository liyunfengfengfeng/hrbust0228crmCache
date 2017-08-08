package cn.itcast.bean;

public class ProvinceBean {
/**
 * #省份信息表表编码“B_Province”为在传统数据库创建的表名，这里我们采用 前缀_名称
 *CREATE TABLE b_province (                                                                                            
 *   id      INT(11)       NOT NULL AUTO_INCREMENT  ,   #省编号                                                                          
 *   name    VARCHAR(100)  DEFAULT NULL,                 #省名称                                                                             
 *   pycode  VARCHAR(50)   DEFAULT NULL,    #拼音码
 *   primary key(id)              
 *)
 */
	private String id;
	private String name;
	private String pycode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}
}
