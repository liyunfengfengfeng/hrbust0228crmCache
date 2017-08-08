package cn.itcast.crm.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 该类为系统用户表的po类
 * 
 * @author LIYUNFENG
 * 
 */
@SuppressWarnings({ "unused", "serial" })
public class SysUser implements Serializable {
	/**
	 * create table sys_user(
	 *id Integer(11) not null auto_increment;//编号
	 *creator varchar(100) default null;//创建人
	 *createTime varchar(100) default null;//创建时间
	 *updater varchar(100) default null;//修改人
	 *updateTime varchar(100) default null;//修改时间
	 *remark text default null;//备注
	 *name varchar(150) default null;//用户名
	 *cnName varchar(100) default null;//中文名
	 *password varchar(100) default null;//密码
	 *address varchar(200) default null;//家庭地址
	 *telephone varchar(20) default null;//家庭电话
	 *email varchar(100) default null;//电子邮件
	 *beginDate date default null;//起始有效期
	 *endDate date default null;//终止有效期
	 *roleId varchar(36) default null;//权限组id   外键
	 *groupId Integer default null;//所属部门                    外键
	 *accessFileLevel varchar(100) default null;//未命名
	 *status varchar(10) default null;//状态
	 *commendPeople varchar(100) default null;//推荐人
	 *moveTelephone varchar(20) default null;//移动电话
	 *nowAddress varchar(200) default null;//现住宅地址
	 *nowTelephone varchar(20) default null;//现住宅电话
	 *identityCode varchar(30) default null;//身份证号码
	 *insuranceCode varchar(50) default null;//社会保险号
	 *instancePeople varchar(100) default null;//紧急联系人
	 *instanceTelephone varchar(30) default null;//紧急联系电话
	 *sex varchar(10) default null;//性别
	 *birthday date default null;//出生日期
	 *workerType varchar(100) default null;//职员类别
	 *work varchar(100) default null;//职务
	 *workTime date default null;//入职时间
	 *highSchool varchar(200) default null;//最高学历
	 *finishSchool varchar(100) default null;//毕业学校
	 *finishSchoolTime date default null;//毕业时间
	 *conSoleName varchar(100) default null;//配偶姓名
	 *youngerName varchar(100) default null;//子女姓名
	 *officeTelephone varchar(20) default null;//办公电话
	 *consoleTelephone varchar(20) default null;//配偶电话
	 *consoleCompany varchar(100) default null;//配偶工作单位
	 *strongSuit text default null;//偏好特长
	 *commuNicate text default null;//信息沟通
	 *bringUp text default null;//培训情况
	 *organiZation  text default null;//组织能力
	 *analise text default null;//分析能力
	 *planning text default null;//计划能力
	 *emploder text default null;//人员开发 
	 *primary key(id)
	 *);
	 */
	private Integer id;// 编号
	private String creator;// 创建人
	private String createTime;// 创建时间
	private String updater;// 修改人
	private String updateTime;// 修改时间
	private String remark;// 备注
	private String name;// 用户名
	private String cnName;// 中文名
	private String password;// 密码
	private String address;// 家庭地址
	private String telephone;// 家庭电话
	private String email;// 电子邮件
	private Date beginDate;// 起始有效期
	private Date endDate;// 终止有效期
	private SysRole sysRole;// 权限组id 外键roleId            多个用户对应一个权限组
	private SysUserGroup sysUserGroup;// 所属部门 外键groupId  多个用户对应一个部门
	private String accessFileLevel;// 未命名                                                 
	private String status;// 状态
	private String commendPeople;// 推荐人
	private String moveTelephone;// 移动电话
	private String nowAddress;// 现住宅地址
	private String nowTelephone;// 现住宅电话
	private String identityCode;// 身份证号码
	private String insuranceCode;// 社会保险号
	private String instancePeople;// 紧急联系人
	private String instanceTelephone;// 紧急联系电话
	private String sex;// 性别
	private Date birthday;// 出生日期
	private String workerType;// 职员类别
	private String work;// 职务
	private Date workTime;// 入职时间
	private String highSchool;// 最高学历
	private String finishSchool;// 毕业学校
	private Date finishSchoolTime;// 毕业时间
	private String conSoleName;// 配偶姓名
	private String youngerName;// 子女姓名
	private String officeTelephone;// 办公电话
	private String consoleTelephone;// 配偶电话
	private String consoleCompany;// 配偶工作单位
	private String strongSuit;// 偏好特长
	private String commuNicate;// 信息沟通
	private String bringUp;// 培训情况
	private String organiZation;// 组织能力
	private String analise;// 分析能力
	private String planning;// 计划能力
	private String emploder;// 人员开发
	private String relation;//人际关系
	private String avocation;//业余爱好
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public SysUserGroup getSysUserGroup() {
		return sysUserGroup;
	}

	public void setSysUserGroup(SysUserGroup sysUserGroup) {
		this.sysUserGroup = sysUserGroup;
	}

	public String getAccessFileLevel() {
		return accessFileLevel;
	}

	public void setAccessFileLevel(String accessFileLevel) {
		this.accessFileLevel = accessFileLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommendPeople() {
		return commendPeople;
	}

	public void setCommendPeople(String commendPeople) {
		this.commendPeople = commendPeople;
	}

	public String getMoveTelephone() {
		return moveTelephone;
	}

	public void setMoveTelephone(String moveTelephone) {
		this.moveTelephone = moveTelephone;
	}

	public String getNowAddress() {
		return nowAddress;
	}

	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}

	public String getNowTelephone() {
		return nowTelephone;
	}

	public void setNowTelephone(String nowTelephone) {
		this.nowTelephone = nowTelephone;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public String getInstancePeople() {
		return instancePeople;
	}

	public void setInstancePeople(String instancePeople) {
		this.instancePeople = instancePeople;
	}

	public String getInstanceTelephone() {
		return instanceTelephone;
	}

	public void setInstanceTelephone(String instanceTelephone) {
		this.instanceTelephone = instanceTelephone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getWorkerType() {
		return workerType;
	}

	public void setWorkerType(String workerType) {
		this.workerType = workerType;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	public String getFinishSchool() {
		return finishSchool;
	}

	public void setFinishSchool(String finishSchool) {
		this.finishSchool = finishSchool;
	}

	public Date getFinishSchoolTime() {
		return finishSchoolTime;
	}

	public void setFinishSchoolTime(Date finishSchoolTime) {
		this.finishSchoolTime = finishSchoolTime;
	}

	public String getConSoleName() {
		return conSoleName;
	}

	public void setConSoleName(String conSoleName) {
		this.conSoleName = conSoleName;
	}

	public String getYoungerName() {
		return youngerName;
	}

	public void setYoungerName(String youngerName) {
		this.youngerName = youngerName;
	}

	public String getOfficeTelephone() {
		return officeTelephone;
	}

	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}

	public String getConsoleTelephone() {
		return consoleTelephone;
	}

	public void setConsoleTelephone(String consoleTelephone) {
		this.consoleTelephone = consoleTelephone;
	}

	public String getConsoleCompany() {
		return consoleCompany;
	}

	public void setConsoleCompany(String consoleCompany) {
		this.consoleCompany = consoleCompany;
	}

	public String getStrongSuit() {
		return strongSuit;
	}

	public void setStrongSuit(String strongSuit) {
		this.strongSuit = strongSuit;
	}

	public String getCommuNicate() {
		return commuNicate;
	}

	public void setCommuNicate(String commuNicate) {
		this.commuNicate = commuNicate;
	}

	public String getBringUp() {
		return bringUp;
	}

	public void setBringUp(String bringUp) {
		this.bringUp = bringUp;
	}

	public String getOrganiZation() {
		return organiZation;
	}

	public void setOrganiZation(String organiZation) {
		this.organiZation = organiZation;
	}

	public String getAnalise() {
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public String getPlanning() {
		return planning;
	}

	public void setPlanning(String planning) {
		this.planning = planning;
	}

	public String getEmploder() {
		return emploder;
	}

	public void setEmploder(String emploder) {
		this.emploder = emploder;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAvocation() {
		return avocation;
	}

	public void setAvocation(String avocation) {
		this.avocation = avocation;
	}

}
