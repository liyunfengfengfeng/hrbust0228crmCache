package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.crm.dao.ICommonDao;
import cn.itcast.crm.domain.SysMenu;
import cn.itcast.crm.domain.SysPopedom;
import cn.itcast.crm.domain.SysPopedomPrivilege;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.util.GenericClass;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		ICommonDao<T> {
	//获取泛型类型 得到的entityClass就是.class的形式
	Class entityClass = GenericClass.getGenericClass(this.getClass());
	/**
	 * 注入sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setSessionFactoryDI(SessionFactory sessionFactory) {
		/**
		 * 调用父类的setSessionFactory(SessionFactory sessionFactory)
		 * 方法,因为父类定义该方法为final不可以再进行重写
		 */
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 保存实体
	 * 
	 * @param sysUserGroup
	 */
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	/**
	 * 通过id查找实体
	 * @param id
	 * @return
	 */
	public T find(Serializable id) {
		//这里需要通过反射获取该类的泛型类型为了方便这里写了一个工具类
		
		
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	/**
	 * 通过id批量删除数据
	 * @param ids
	 */
	public void deleteObjectsByIds(Serializable[] ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				T entity = (T) this.getHibernateTemplate().get(entityClass, id);
				this.getHibernateTemplate().delete(entity);
			}
		}
		
	}
	/**
	 * 更新实体
	 * @param sysUserGroup
	 */
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}
	/**
	 * 删除集合包括删除了集合中的所有实体
	 * @param list
	 */
	public void deleteCollection(Collection<T> entities) {
		this.getHibernateTemplate().deleteAll(entities);
		
	}
	/**
	 * 依据条件查询所有的数据
	 * @param whereHql 封装查询的条件
	 * @param paramList封装查询条件的数据
	 * @param orderby  排序
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			List paramList, LinkedHashMap<String, String> orderby) {
		//查询的hql语句  
		String hql = "select o from " + entityClass.getSimpleName() + " o where 1=1 ";
		//补上要查询的条件
		if(StringUtils.isNotBlank(whereHql)){
			hql = hql + whereHql;
			System.out.println(hql);
		}
		//处理排序语句
		String orderBy = buildOrderBy(orderby);
		if(StringUtils.isNotBlank(orderBy)){
			hql = hql + orderBy;
			System.out.println(hql);
		}
		final String fhql = hql;
		final List fParamList = paramList;
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(fhql);
//				for(int i = 0;i<fParamList.size();i++){
//					query.setParameter(i, fParamList.get(i));
//				}
				setParam(query,fParamList);
				return query.list();
			}
		});
		return list;
	}
	/**
	 * 对查询的条件补充数据
	 * @param query
	 * @param fParamList
	 */
	protected void setParam(Query query, List fParamList) {
			if(fParamList!=null && fParamList.size()>0){
				for(int i = 0;i<fParamList.size();i++){
					query.setParameter(i, fParamList.get(i));
				}	
		    }
	}

	/**
	 * 组装排序语句
	 * @param orderby
	 * @return
	 */
	private String buildOrderBy(LinkedHashMap<String, String> orderby) {
		StringBuffer buf = new StringBuffer("");
		if(orderby != null){
			for(Map.Entry<String, String> em:orderby.entrySet()){
				buf.append(em.getKey()).append(em.getValue()).append(",");
			}
			//删除最后一个分号
			buf.deleteCharAt(buf.length()-1);
		}
		return buf.toString();
	}
	/**
	 * 查找所有的部门
	 * 没有限制条件
	 * 以用于在人事管理页面下的list.jsp的部门
	 * 下拉列表里进行迭代
	 * @return
	 */
	public List<T> findObjectsByConditionWithNoPage() {
		
		return this.findObjectsByConditionWithNoPage(null, null, null);
	}
	/**
     * 用于检查登录名及密码
     * @param whereHql
     * @param paramList
     * @return
     */
	public List<T> findObjectsByConditionWithNoPage(String whereHql,
			List paramList) {
		
		return this.findObjectsByConditionWithNoPage(whereHql, paramList, null);
	}
	/**
	 * 查询系统具备的所有功能
	 * @return
	 */
	public List<T> findAllPopedom() {
		
		return this.findObjectsByConditionWithNoPage();
	}
	/**
	 * 查询当前roleId所对应的数据
	 * 删除之
	 * @param whereHql
	 * @param paramList
	 * @return
	 */
	public List<T> findSysPopedomsByRoleId(String whereHql, List paramList) {
		
		return this.findObjectsByConditionWithNoPage(whereHql, paramList, null);
	}
	/**
	 * 在操作权限组功能表中找到所有的roleId对应的数据
	 * 用于进行回显
	 * @param whereHql
	 * @param paramList
	 * @return
	 */
	public List<T> findSysPopedomPrivilegesByRoleId(
			String whereHql, List paramList) {
		return this.findObjectsByConditionWithNoPage(whereHql, paramList, null);
	}
	//带排序的查找
	public List<T> findObjectsByConditionWithNoPage(
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return this.findObjectsByConditionWithNoPage(null, null, orderby);
	}
}
