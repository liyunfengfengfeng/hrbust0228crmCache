package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.bean.ReportBean;

public interface IReportDao extends ICommonDao<ReportBean> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.ReportDaoImpl";

	List<ReportBean> findReportBeans();
}
