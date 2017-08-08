package cn.itcast.crm.web.action;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.SysUserGroupSearch;
import cn.itcast.crm.annotation.Limit;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysUserGroup;
import cn.itcast.crm.service.ISysUserGroupService;
import cn.itcast.crm.util.DataType;
import cn.itcast.crm.web.form.SysUserGroupForm;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SysUserGroupAction extends BaseAction implements ModelDriven<SysUserGroupForm>{
	
	//部门搜索Form通过他的对象可以直接获取页面表单数据
	private SysUserGroupForm sysUserGroupForm = new SysUserGroupForm();
//	//获取部门的业务层
//	ISysUserGroupService sysUserGroupService = 
//			(ISysUserGroupService)ServiceProvinder.getService(ISysUserGroupService.SERVICE_NAME);
	static{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
				
	}
	/**
	 * 点击部门设置走该list
	 * 返回到部门下的list.jsp
	 * @return
	 */
	@Limit(module="group",privilege="list")
	public String list(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		//部门搜索bean
		SysUserGroupSearch sysUserGroupSearch = new SysUserGroupSearch();
		sysUserGroupSearch.setName(sysUserGroupForm.getName());
		//查询所有的数据
		List<SysUserGroup> sysUserGroups = sysUserGroupService.findSysUserGroupByConditionWithNoPage(sysUserGroupSearch);
		//将数据保存在request作用域
		request.setAttribute("sysUserGroups", sysUserGroups);
		//System.out.println(sysUserGroups.size());
		return "list";
	}
	/**
	 * 新增部门页面
	 * 通过action到达add.jsp
	 */
	@Limit(module="group",privilege="add")
	public String add(){
		
		return "add";
	}
	/**
	 * 保存页面表单到数据库
	 * 保存完之后需要重定向action
	 * 需要重新走一遍listaction走过的路径
	 * 否则返回的list.jsp是没有数据的
	 * 目前先不做配置
	 */
	@Limit(module="group",privilege="save")
	public String save(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		/**
		 * 检查模型驱动是否取得数据
		 * 如果表单name的属性与domain对象等等不一致的话
		 * 是无法取得数据的
		 */
//		System.out.println(sysUserGroupForm.getName()); 
//		System.out.println(sysUserGroupForm.getRemark()); 
//		System.out.println(sysUserGroupForm.getPrinciple()); 
//		System.out.println(sysUserGroupForm.getInclument()); 
		SysUserGroup sysUserGroup = new SysUserGroup();
		//设置部门名称
		sysUserGroup.setName(sysUserGroupForm.getName());
		//设置部门备注
		sysUserGroup.setRemark(sysUserGroupForm.getRemark());
		//设置部门负责人
		sysUserGroup.setPrinciple(sysUserGroupForm.getPrinciple());
		//设置部门职能
		sysUserGroup.setInclument(sysUserGroupForm.getInclument());
		//调用部门的service层进行保存
		sysUserGroupService.save(sysUserGroup);
		return "listAction";
	}
	/**
	 * 通过获取id批量删除数据
	 */
	@Limit(module="group",privilege="delete")
	public String delete(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		//获取要删除的ids
		String []ids = (String[])request.getParameterValues("ids");
		/**
		 * 这里要删除的ids字符串数组类型的
		 * 需要写一个工具类DatyType将其转化为整形数组
		 */
		Integer []id = DataType.converterStringArray2IntegerArray(ids);
		//调用部门的service层进行删除
		sysUserGroupService.delete(id);
		/**
		 * 返回listAction重定向到
		 * list查询从数据库查询数据
		 */
		return "listAction";
	}
	/**
	 * 通过该action跳转到部门编辑页面
	 * edit.jsp
	 * 跳转到该页面后最好要进行回显
	 * 
	 * 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="group",privilege="edit")
	public String edit() throws IllegalAccessException, InvocationTargetException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		/**
		 * 点击部门名称时会将部门的id传过来
		 */
		String ids = (String)request.getParameter("id");
		//将id转化为整形
		Serializable id = Integer.parseInt(ids); 
		//通过id查找部门 调用业务层的方法
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup = sysUserGroupService.findSysUserGroupById(id);
		//System.out.println(sysUserGroup.getName());
		//进行部门编辑页面的回显
		if(sysUserGroup != null){
			//后付前  后付钱谐音记忆
			/**
			 * 只有当表单的name字段与domain里相同所有字段
			 * 都最好想domain看齐
			 * 要想进行回显首先需要把普通html标签改为struts2的标签
			 */
			BeanUtils.copyProperties(sysUserGroupForm, sysUserGroup);
		}
		return "edit";
	}
	/**
	 * 在编辑页面进行更新操作
	 * 编辑完成之后还是要跳转到listAction路径重新
	 * 查询一遍
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Limit(module="group",privilege="update")
	public String update() throws IllegalAccessException, InvocationTargetException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//获取部门的业务层
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService)ctx.getBean(ISysUserGroupService.SERVICE_NAME);
		//System.out.println(sysUserGroupForm.getName());
		SysUserGroup sysUserGroup = new SysUserGroup();
		/**
		 * 因为sysUserGroupForm里的id是String类型的
		 */
//		BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
//		//特殊处理  id
//		Integer id = Integer.parseInt(sysUserGroupForm.getId().trim());
//		sysUserGroup.setId(id);
		/**
		 * 保存是按照id保存的通过点击编辑即部门名称
		 * 将id传了过来通过id在editAction中查询
		 * 并进行回显在edit.jsp中设置隐藏的id属性
		 * 这样在更新是有将id得到了
		 */
//		sysUserGroup.setId(Integer.parseInt(sysUserGroupForm.getId().trim()));
//		sysUserGroup.setName(sysUserGroupForm.getName());
//		sysUserGroup.setRemark(sysUserGroupForm.getRemark());
//		sysUserGroup.setPrinciple(sysUserGroupForm.getPrinciple());
//		sysUserGroup.setInclument(sysUserGroupForm.getInclument());
		BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
		//处理id
		sysUserGroup.setId(Integer.parseInt(sysUserGroupForm.getId().trim()));
		//调用业务层进行更新
		sysUserGroupService.updateSysUserGroup(sysUserGroup);
		//走list查询
		return "listAction";
	}
	/**
	 * 在部门下的编辑页面的返回处理
	 * @return
	 */
	public String back(){
		
		return "listAction";
	}
	/**
	 * 部门下的人员设置页面处理
	 */
	public String set(){
		
		return "set";
	}
	/**
	 * 实现模型驱动的方法
	 * 返回form可以直接获取页面表单数据
	 */
	public SysUserGroupForm getModel() {
		
		return sysUserGroupForm;
	}
}
