package junit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.SysUserGroupSearch;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.dao.ISysUserGroupDao;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;



public class TestHibernate {
	/**
	 * 想部门表中插入数据 测试hibernate是否安装成功
	 * sys_user_group
	 */
	@Test
	public void save(){
		Configuration config = new  Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("财务部");
		sysUserGroup.setRemark("今天年终发奖金");
		sysUserGroup.setPrinciple("陆小凤");
		sysUserGroup.setInclument("负责工资发放");
		session.save(sysUserGroup);
		session.getTransaction().commit();
		session.close();
	}
	/**
	 * 测试spring是否安装成功
	 * 向部门表中添加一条数据
	 */
	@Test
	public void save2(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//这里该使用DAO层了
		ISysUserGroupDao IsysUserGroup = (ISysUserGroupDao)ctx.getBean(ISysUserGroupDao.SERVICE_NAME);
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("销售部");
		sysUserGroup.setRemark("今年的销售业绩较往年有大幅度提升");
		sysUserGroup.setPrinciple("梁朝伟");
		sysUserGroup.setInclument("销售电脑");
		//dao层直接保存数据
		IsysUserGroup.save(sysUserGroup);
	}
	//接下来是要丰富dao层操作数据库的方法
	/**
	 * 测试封装的spring容器是否好使
	 * 通过id查找数据
	 */
	@Test
	public void find(){
		//利用封装的spring容器获取dao层
		ISysUserGroupDao IsysUserGroup = 
				(cn.itcast.crm.dao.ISysUserGroupDao) ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
		Serializable id = 1;
		SysUserGroup sysUserGroup = IsysUserGroup.find(id);
		System.out.println("部门的名称:" + sysUserGroup.getName());
		System.out.println("部门的负责人:" + sysUserGroup.getPrinciple());
		System.out.println("部门的职能:" + sysUserGroup.getInclument());
		System.out.println("部门的备注:" + sysUserGroup.getRemark());
	}
	/**
	 * 通过id批量删除数据
	 * 通过业务层调用dao层
	 */
	@Test
	public void delete(){
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService 
		= (ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		Serializable []ids = {1,2};
		sysUserGroupService.deleteObjectsByIds(ids);
	}
	/**
	 * 通过id更新部门表中的数据
	 */
	@Test
	public void update(){
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("人事部");
		sysUserGroup.setRemark("你被开除了");
		sysUserGroup.setPrinciple("马云");
		sysUserGroup.setInclument("负责开除员工");
		sysUserGroup.setId(3);
		//利用封装的spring容器获取dao层
		ISysUserGroupDao IsysUserGroup = 
					(cn.itcast.crm.dao.ISysUserGroupDao) ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
		IsysUserGroup.update(sysUserGroup);
	}
	/**
	 * 通过删除集合来删除数据
	 */
	@Test
	public void delete2(){
		SysUserGroup sysUserGroup3 = new SysUserGroup();
		sysUserGroup3.setId(3);
		SysUserGroup sysUserGroup4 = new SysUserGroup();
		sysUserGroup4.setId(4);
		SysUserGroup sysUserGroup5 = new SysUserGroup();
		sysUserGroup5.setId(5);
		Collection<SysUserGroup> list = new ArrayList<SysUserGroup>();
		list.add(sysUserGroup3);
		list.add(sysUserGroup4);
		list.add(sysUserGroup5);
		//利用封装的spring容器获取dao层
		ISysUserGroupDao IsysUserGroup = 
				(cn.itcast.crm.dao.ISysUserGroupDao) ServiceProvinder.getService(ISysUserGroupDao.SERVICE_NAME);
		IsysUserGroup.deleteCollection(list);
	}
	/**
	 * 通过条件查询部门表中的数据
	 */
	@Test
	public void findSysUserGroupByConditionWithNoPage(){
		//获取部门的service层
		ISysUserGroupService sysUserGroupService = 
				(ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
		//封装部门的搜索的条件
		SysUserGroupSearch sysUserGroupSearch = new SysUserGroupSearch();
		sysUserGroupSearch.setName("部");
		//将查询的数据返回一个集合
		List <SysUserGroup> SysUserGroups = 
				sysUserGroupService.findSysUserGroupByConditionWithNoPage(sysUserGroupSearch);
		System.out.println("list SysUserGroups is:" + SysUserGroups.size());
		//迭代数据
		for(SysUserGroup sysUserGroup:SysUserGroups){
			System.out.println("sysUserGroup.getId() :" + sysUserGroup.getId());
			System.out.println("sysUserGroup.getInclument() :" + sysUserGroup.getInclument());
			System.out.println("sysUserGroup.getPrinciple() :" + sysUserGroup.getPrinciple());
			System.out.println("sysUserGroup.getRemark() :" + sysUserGroup.getRemark());
			System.out.println("sysUserGroup.getName() :" + sysUserGroup.getName());
		}
	}
}
