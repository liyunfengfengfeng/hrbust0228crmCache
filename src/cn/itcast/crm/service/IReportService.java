package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.bean.ReportBean;

public interface IReportService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.ReportServiceImpl";
	/**
	 * 查询所有的报表信息
	 * @return
	 */
	List<ReportBean> findReportBeans();
}
