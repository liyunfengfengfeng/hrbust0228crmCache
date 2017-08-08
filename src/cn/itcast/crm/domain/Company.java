package cn.itcast.crm.domain;

import java.io.Serializable;
import java.sql.Date;
/**
 * 该类为客户表的po类
 * @author LIYUNFENG
 *
 */
@SuppressWarnings("serial")
public class Company implements Serializable{
/**
 * #客户信息表  
 *  CREATE TABLE `c_company` (
 *	  `id` int(11) NOT NULL auto_increment,             #编号
 *	  `code` varchar(50) default NULL,                  #客户编码
 *	  `name` varchar(100) NOT NULL,                     #客户名称
 *	  `pycode` varchar(100) default NULL,               #拼音码
 *	  `grade` varchar(100) default NULL,                #客户等级(下拉)
 *	  `regionName` varchar(100) default NULL,           #区域名称(东北  西北  华北)(下拉)
 *	  `source` varchar(100) default NULL,               #客户来源(下拉)
 *	  `trade` varchar(100) default NULL,                #所属行业(下拉)
 *	  `scale` varchar(100) default NULL,                #公司规模(下拉)
 *	  `province` varchar(50) default NULL,              #省份(下拉)
 *	  `city` varchar(50) default NULL,                  #城市(下拉)
 *	  `postcode` varchar(50) default NULL,              #邮政编码
 *	  `address` varchar(200) default NULL,              #联系地址
 *	  `email` varchar(100) default NULL,                #电子邮件
 *	  `web` varchar(200) default NULL,                  #公司网站
 *	  `tel1` varchar(50) default NULL,                  #电话一
 *	  `fax` varchar(50) default NULL,                   #传真
 *	  `mobile` varchar(50) default NULL,                #手机
 *	  `tel2` varchar(50) default NULL,                  #电话二
 *	  `nextTouchDate` DATE default NULL,                #下次联系时间
 *	  `quality` varchar(100) default NULL,              #客户性质(下拉)
 *	  `remark` text,                                    #备注
 *	  `dealin` varchar(100) default NULL,               #经营范围(下拉)
 *	  `kind` varchar(100) default NULL,                 #企业性质(下拉)
 *	  `artificialPerson` varchar(50) default NULL,      #法人代表
 *	  `registeMoney` varchar(50) default NULL,          #注册资金
 *	  `bank` varchar(100) default NULL,                 #开户银行
 *	  `account` varchar(100) default NULL,              #银行账户
 *	  `taxCode` varchar(100) default NULL,              #公司税号
 *	  `creater` varchar(50) default NULL,               #创建人    --本条记录的添加者(添加的用户名)
 *	  `createTime` varchar(19) default NULL,            #创建日期  ---
 *	  `updater` varchar(50) default NULL,               #修改人    --本条记录的修改者(中间可能发生多次变更)
 *	  `updateTime`  varchar(19) default NULL,           #修改日期  ---
 *	  
 *	  `ownerUser` int(11) NOT NULL,                     #所属人ID(外键)-----	  
 *	  `dispensePerson` varchar(50) default NULL,        #所属人名称  分配人(经手人变更给的人)----
 *	  `dispenseDate` varchar(19)   default NULL,        #分配日期(经手人变更的日期)-----
 *	  
 *	  `shareFlag` char(1) default NULL,                 #共享标志 Y(共享)和N(不共享)
 *	  `shareIds` varchar(500) default NULL,             #共享ID客户资料共享给业务人员 格式 #人事编号#人事编号...例如(#12#11#)
 *       PRIMARY KEY  (`id`)
 *)
 *
 *#设置外键约束
 *alter table c_company
 *add CONSTRAINT `c_company_ibfk_2` FOREIGN KEY (`ownerUser`) REFERENCES `sys_user` (`id`)
 */
	private Integer id;//#编号
	private String code;//#客户编码
	private String name;//#客户名称
	private String pycode;//#拼音码
	private String grade;//#客户等级(下拉)
	private String regionName;//#区域名称(东北  西北  华北)(下拉)
	private String source;//#客户来源(下拉)
	private String trade;//#所属行业(下拉)
	private String scale;//#公司规模(下拉)
	private String province;//#省份(下拉)
	private String city;//#城市(下拉)
	private String postcode;//#邮政编码
	private String address;//#联系地址
	private String email;//#电子邮件
	private String web;//#公司网站
	private String tel1;//#电话一
	private String fax;//#传真
	private String mobile;//#手机
	private String tel2;//#电话二
	private Date nextTouchDate;//#下次联系时间
	private String quality;//#客户性质(下拉)
	private String remark;//#备注
	private String dealin;//#经营范围(下拉)
	private String kind;//#企业性质(下拉)
	private String artificialPerson;//#法人代表
	private String registeMoney;//#注册资金
	private String bank;//#开户银行
	private String account;//#银行账户
	private String taxCode;//#公司税号
	private String creater;//#创建人    --本条记录的添加者(添加的用户名)
	private String createTime;//#创建日期  ---
	private String updater;//#修改人    --本条记录的修改者(中间可能发生多次变更)
	private String updateTime;//#修改日期  ---
	private Integer ownerUser;//#所属人ID(外键)-----
	private String dispensePerson;//#所属人名称  分配人(经手人变更给的人)----
	private String dispenseDate;//#分配日期(经手人变更的日期)-----
	private String shareFlag;//#共享标志 Y(共享)和N(不共享)
	private String shareIds;//#共享ID客户资料共享给业务人员 格式 #人事编号#人事编号...例如(#12#11#)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public Date getNextTouchDate() {
		return nextTouchDate;
	}

	public void setNextTouchDate(Date nextTouchDate) {
		this.nextTouchDate = nextTouchDate;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDealin() {
		return dealin;
	}

	public void setDealin(String dealin) {
		this.dealin = dealin;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getArtificialPerson() {
		return artificialPerson;
	}

	public void setArtificialPerson(String artificialPerson) {
		this.artificialPerson = artificialPerson;
	}

	public String getRegisteMoney() {
		return registeMoney;
	}

	public void setRegisteMoney(String registeMoney) {
		this.registeMoney = registeMoney;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(Integer ownerUser) {
		this.ownerUser = ownerUser;
	}

	public String getDispensePerson() {
		return dispensePerson;
	}

	public void setDispensePerson(String dispensePerson) {
		this.dispensePerson = dispensePerson;
	}

	public String getDispenseDate() {
		return dispenseDate;
	}

	public void setDispenseDate(String dispenseDate) {
		this.dispenseDate = dispenseDate;
	}

	public String getShareFlag() {
		return shareFlag;
	}

	public void setShareFlag(String shareFlag) {
		this.shareFlag = shareFlag;
	}

	public String getShareIds() {
		return shareIds;
	}

	public void setShareIds(String shareIds) {
		this.shareIds = shareIds;
	}
}
