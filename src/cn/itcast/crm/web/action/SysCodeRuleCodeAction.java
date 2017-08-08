package cn.itcast.crm.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bean.SysCodeRuleSearch;
import cn.itcast.crm.container.ServiceProvinder;
import cn.itcast.crm.domain.SysCodeRule;
import cn.itcast.crm.domain.SysDictionaryType;
import cn.itcast.crm.service.ISysCodeRuleService;
import cn.itcast.crm.service.ISysDictionaryTypeService;
import cn.itcast.crm.util.DataType;
import cn.itcast.crm.web.form.SysCodeRuleCodeForm;

@SuppressWarnings("serial")
public class SysCodeRuleCodeAction extends BaseAction implements ModelDriven<SysCodeRuleCodeForm>{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	//实例化form
	SysCodeRuleCodeForm sysCodeRuleCodeForm = new SysCodeRuleCodeForm();
	//获取编码规则的业务层
	ISysCodeRuleService sysCodeRuleService = 
			(ISysCodeRuleService)ctx.getBean(ISysCodeRuleService.SERVICE_NAME);
	
	//获取下拉列表框的业务层
	ISysDictionaryTypeService sysDictionaryTypeService = 
			(ISysDictionaryTypeService)ctx.getBean(ISysDictionaryTypeService.SERVICE_NAME);
	/**
	 * 到编码规则页面
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String list() throws IllegalAccessException, InvocationTargetException{
		//获取封装搜索条件的javabean
		SysCodeRuleSearch sysCodeRuleSearch = new SysCodeRuleSearch();
		BeanUtils.copyProperties(sysCodeRuleSearch, sysCodeRuleCodeForm);
		List<SysCodeRule> sysCodeRules = sysCodeRuleService.findAllCodes(sysCodeRuleSearch);
//		for(SysCodeRule sysCodeRule:sysCodeRules){
//			System.out.println("sysCodeRule.getModule()     :" + sysCodeRule.getModule());
//		}
		request.setAttribute("sysCodeRules", sysCodeRules);
		return "list";
	}
	/**
	 * 处理新建编码规则
	 */
	public String  add(){
		//调用业务层查询所有的流水号
		List<SysDictionaryType> gildeBits = sysDictionaryTypeService.findAllGlideBits();
//		for(SysDictionaryType gildeBit : gildeBits){
//			System.out.println("gildeBit.getValue()     :" + gildeBit.getValue());
//		}
		request.setAttribute("gildeBits", gildeBits);
		//调用业务层查询所有的日期号
		List<SysDictionaryType> areaTimes = sysDictionaryTypeService.findAllAreaTimes();
//		for(SysDictionaryType areaTime : areaTimes){
//			System.out.println("areaTime.getValue()     :" + areaTime.getValue());
//		}
		request.setAttribute("areaTimes", areaTimes);
		return "add";
	}
	/**
	 * 更新编码规则信息
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public String save() throws IllegalAccessException, InvocationTargetException{
		//创建编码规则对象
		SysCodeRule sysCodeRule = new SysCodeRule();
		//从vo拷贝到po
		BeanUtils.copyProperties(sysCodeRule, sysCodeRuleCodeForm);
		//处理流水号
		if(StringUtils.isNotBlank(sysCodeRuleCodeForm.getGlideBit())){
			sysCodeRule.setGlideBit(Integer.parseInt(sysCodeRuleCodeForm.getGlideBit()));
		}
		//处理预览格式     currentCode
		//处理流水号前缀
		String glideNumPre = sysCodeRuleCodeForm.getAreaPrefix();
		//System.out.println("glideNumPre      :" + glideNumPre);
		//处理流水号中缀
		String glideNumMid = DateFormatUtils.format(new java.util.Date(), sysCodeRuleCodeForm.getAreaTime());
		//System.out.println("glideNumMid      :" + glideNumMid);
		//处理流水号后缀
		String glideNumLas=  DataType.createCurrentGlideNumber(Integer.parseInt(sysCodeRuleCodeForm.getGlideBit()));
		//System.out.println("glideNumLas      :" + glideNumLas);
		//拼凑当前的流水号
		String currentCode = glideNumPre+"-"+glideNumMid+"-"+glideNumLas;
		//处理流水号的预览模式
		sysCodeRule.setCurrentCode(currentCode);
		//调用业务层进行保存数据
		sysCodeRuleService.saveSysCodeRule(sysCodeRule);
		return "listAction";
	}
	/**
	 * 处理编码信息的删除
	 */
	public String delete(){
		//获取要删除的编码数据id
		String []ids = (String[])request.getParameterValues("ids");
		//检查要删除的数据
//		for(String id : ids){
//			System.out.println("id is    :" + id);
//		}
		//调用编码规则业务层进行删除
		sysCodeRuleService.deleteSysCodeRulesById(ids);
		return "listAction";
	}
	/**
	 * 编码规则表的模型驱动的处理
	 */
	public SysCodeRuleCodeForm getModel() {
		// TODO Auto-generated method stub
		return sysCodeRuleCodeForm;
	}
}
