package cn.itcast.bean;

public class ReportBean {
	
	private String type;
	private Long count;

	public ReportBean() {
	}
	
	public ReportBean(String type, Long count) {
		this.type = type;
		this.count = count;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

}
