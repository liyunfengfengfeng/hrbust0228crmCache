package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.ReportBean;
import cn.itcast.crm.dao.IReportDao;
import cn.itcast.crm.service.IReportService;
@Service(IReportService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ReportServiceImpl implements IReportService {
	/**
	 * 查询所有的报表信息
	 */
	@Resource(name=IReportDao.SERVICE_NAME)
	private IReportDao reportDao;
	
	public List<ReportBean> findReportBeans() {
		List<ReportBean> list=reportDao.findReportBeans();
		return list;
	}

}
