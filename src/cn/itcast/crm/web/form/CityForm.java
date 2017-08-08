package cn.itcast.crm.web.form;

import java.io.Serializable;

public class CityForm implements Serializable{
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
	private String id;
	private String name;
	private String pycode;
	private String pid;
	private String postcode;
	private String areacode;

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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
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
