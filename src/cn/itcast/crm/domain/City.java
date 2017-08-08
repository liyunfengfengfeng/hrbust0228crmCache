package cn.itcast.crm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class City implements Serializable{
/**
 * #城市信息表
 *CREATE TABLE  b_city(                                                                                                  
 *id  INT(11) NOT NULL AUTO_INCREMENT   PRIMARY KEY,      #城市编号                                                                          
 *name  VARCHAR(100) DEFAULT NULL,                        #城市名称                                                                
 *pycode  VARCHAR(50) DEFAULT NULL,                       #城市拼音码                                                             
 *pid  INT(11) DEFAULT NULL,                              #省编号                                                              
 *postcode  VARCHAR(50) DEFAULT NULL,                     #邮编                                                             
 *areacode  VARCHAR(50) DEFAULT NULL                      #区号 
 *);
 */
	private Integer id;// 城市编号
	private String name;// 城市名称
	private String pycode;// 拼音码
	private Integer pid;// 省份id
	private String postcode;// 邮政编码
	private String areacode;// 区域编码

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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
}
