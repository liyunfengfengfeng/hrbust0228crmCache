package cn.itcast.crm.domain;

import java.io.Serializable;
/**
 * 该类为省份表的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class Province implements Serializable{
/**
* #省份信息表表编码“B_Province”为在传统数据库创建的表名，这里我们采用 前缀_名称
*CREATE TABLE b_province (                                                                                            
*   id      INT(11)       NOT NULL AUTO_INCREMENT  PRIMARY KEY,      #省编号                                                                          
*   name    VARCHAR(100)  DEFAULT NULL,                 #省名称                                                                             
*   pycode  VARCHAR(50)   DEFAULT NULL                  #拼音码
*)
*/
	private Integer id;// #省编号
	private String name;// #省名称
	private String pycode;// #拼音码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
