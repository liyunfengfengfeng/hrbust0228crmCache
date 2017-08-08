package cn.itcast.crm.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import cn.itcast.bean.ReportBean;
import cn.itcast.crm.dao.IReportDao;

@Repository(IReportDao.SERVICE_NAME)
public class ReportDaoImpl extends CommonDaoImpl<ReportBean> implements IReportDao {

	@SuppressWarnings("unchecked")
	public List<ReportBean> findReportBeans() {
		
		@SuppressWarnings("unused")
		List<ReportBean> list=(List<ReportBean>)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				/*
				 * sql:
				 *   SELECT  grade,COUNT(*) FROM c_company GROUP BY grade
				 * 
				 * Hql:
				 * select o.grade,count(*) from Company o group by  o.grade
				 * 
				 */
				 String hql="select new cn.itcast.bean.ReportBean(o.grade,count(*)) from Company o group by  o.grade";
				 Query query=session.createQuery(hql);
				 List list= query.list();
				 return list;
			}
		});
		
		return list;
	}

}
