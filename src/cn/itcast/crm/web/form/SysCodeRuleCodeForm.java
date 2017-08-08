package cn.itcast.crm.web.form;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SysCodeRuleCodeForm implements Serializable{
	private String id;// #编号
	private String module;// #模块名称(固定)
	private String areaPrefix;// #编码前缀(可变)
	private String areaTime;// #日期位(可变)
	private String glideBit;// #流水位(可变)
	private String currentCode;// #预览(显示的提供看的)
	private String tabName;// #表名(固定)
	private String available;// #是否有效(Y和N两个值,如果是保存是Y
								// ,如果"#编码前缀,#日期位,#流水位中有一个发生变化则修改为Y)
	private String nextseq;// #下次产生的序号
	private String curDate;// #序号对应的日期(yyyyMMdd)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAreaPrefix() {
		return areaPrefix;
	}

	public void setAreaPrefix(String areaPrefix) {
		this.areaPrefix = areaPrefix;
	}

	public String getAreaTime() {
		return areaTime;
	}

	public void setAreaTime(String areaTime) {
		this.areaTime = areaTime;
	}

	public String getGlideBit() {
		return glideBit;
	}

	public void setGlideBit(String glideBit) {
		this.glideBit = glideBit;
	}

	public String getCurrentCode() {
		return currentCode;
	}

	public void setCurrentCode(String currentCode) {
		this.currentCode = currentCode;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getNextseq() {
		return nextseq;
	}

	public void setNextseq(String nextseq) {
		this.nextseq = nextseq;
	}

	public String getCurDate() {
		return curDate;
	}

	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}
}
