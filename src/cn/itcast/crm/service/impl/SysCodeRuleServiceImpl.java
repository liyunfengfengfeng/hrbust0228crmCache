package cn.itcast.crm.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.SysCodeRuleSearch;
import cn.itcast.crm.dao.ISysCodeRuleDao;
import cn.itcast.crm.domain.SysCodeRule;
import cn.itcast.crm.service.ISysCodeRuleService;
import cn.itcast.crm.util.DataType;

/**
 * 编码规则表 的业务层 实现类
 * 
 * @author LIYUNFENG
 * 
 */
@Service(ISysCodeRuleService.SERVICE_NAME)
@Transactional(readOnly = true)
public class SysCodeRuleServiceImpl implements ISysCodeRuleService {
	// 获取编码规则表的dao层
	@Resource(name = ISysCodeRuleDao.SERVICE_NAME)
	ISysCodeRuleDao sysCodeRuleDao;

	/**
	 * 该方法用于生成流水号
	 * 
	 * @return
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public String createGlideNumber() {
		String glideNumber = "";
		// 封装查询的条件
		String whereHql = "";
		// 封装查询的条件的数据
		List paramList = new ArrayList();
		whereHql = whereHql + " and o.tabName = ? ";
		paramList.add("c_company");
		// 调用编码规则的dao层获取客户的流水号编码规则
		List<SysCodeRule> sysCodeRules = sysCodeRuleDao
				.findObjectsByConditionWithNoPage(whereHql, paramList);
		if (sysCodeRules == null || sysCodeRules.size() < 1) {
			System.out.println("不能够产生流水线编号");
		}
		System.out.println("sysCodeRules.size()    :" + sysCodeRules.size());
		SysCodeRule sysCodeRule = null;
		if (sysCodeRules.size() == 1) {
			sysCodeRule = sysCodeRules.get(0);
		}
		System.out.println("sysCodeRule.getAvailable()   :" + sysCodeRule.getAvailable());
		// 如果用户是新建的
		if (sysCodeRule != null) {
			if (sysCodeRule.getAvailable().toString().equals("Y")) {
				System.out.println("该用户是新建的");
				//获取需要生成的流水号是几位的
				int bit = sysCodeRule.getGlideBit();
				//生成001类似的流水号后缀
				String glideLast = DataType.createCurrentGlideNumber(bit);
				//获取流水号的前缀
				String glidePre = sysCodeRule.getAreaPrefix();
				//获取流水号的中缀
				String glideMid = DateFormatUtils.format(new java.util.Date(), sysCodeRule.getAreaTime());
				//生成当天的第一单流水号
				glideNumber = glidePre+"-"+glideMid+"-"+glideLast;
				//设置数据库改变avaliable为no因为他已经不是首单了
				sysCodeRule.setAvailable("N");
				//获取下一条流水线的后缀
				String nextGlideLast = DataType.createNextGlideNumber(glideLast);
				sysCodeRule.setNextseq(nextGlideLast);
				//获取当前日期并获取设置到数据库中
				String curDate = DateFormatUtils.format(new java.util.Date(),sysCodeRule.getAreaTime() );
				sysCodeRule.setCurDate(curDate);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleDao.update(sysCodeRule);
			} else if(sysCodeRule.getCurDate().equals(DateFormatUtils.format(new java.util.Date(), sysCodeRule.getAreaTime()))) {
				System.out.println("客户不是新建的但是是同一天的");
				//获取当前的流水号后缀
				String glideLast = sysCodeRule.getNextseq();
				//获取当前流水号的中缀
				String glideMid = DateFormatUtils.format(new java.util.Date(),sysCodeRule.getAreaTime() );
				//获取流水号前缀
				String glidePre = sysCodeRule.getAreaPrefix();
				//生成当天的不是第一条的流水号
				glideNumber = glidePre+"-"+glideMid+"-"+glideLast;
				//获取下一条流水号的后缀
				String nextGlideLast = DataType.createNextGlideNumber(sysCodeRule.getNextseq());
				//获取当前日期
				String curDate = DateFormatUtils.format(new java.util.Date(),sysCodeRule.getAreaTime() );
				//保存下一条流水号 并且重新设置当前日期
				sysCodeRule.setNextseq(nextGlideLast);
				sysCodeRule.setCurDate(curDate);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleDao.update(sysCodeRule);
			}else{
				System.out.println("客户是新建的但是是第二天新建的");
				//获取流水号的位数
				int bit = sysCodeRule.getGlideBit();
				//生成第二天的第一条流水号后缀
				String firstGlideLast = DataType.createCurrentGlideNumber(bit);
				//获取当前的时间 生成第二天的第一条流水号中缀
				String firstGlideMid = DateFormatUtils.format(new java.util.Date(), sysCodeRule.getAreaTime());
				//获取第二天的第一条流水号后缀
				String firstGlidePre = sysCodeRule.getAreaPrefix();
				//生成第二天的第一单流水号
				glideNumber = firstGlidePre+"-"+firstGlideMid+"-"+firstGlideLast;
				
				//获取当前时间
				String curDate = DateFormatUtils.format(new java.util.Date(), sysCodeRule.getAreaTime());
				//获取第二天流水号后缀
				String nextGlideLast = DataType.createNextGlideNumber(firstGlideLast);
				//进行更新
				sysCodeRule.setCurDate(curDate);
				sysCodeRule.setNextseq(nextGlideLast);
				//调用SysCodeRule dao层进行更新实体
				sysCodeRuleDao.update(sysCodeRule);
			}
		}
		return glideNumber;
	}
	/**
	 * 查询所有的编码规则
	 * @return
	 */
	public List<SysCodeRule> findAllCodes(SysCodeRuleSearch sysCodeRuleSearch) {
		//封装查询的条件
		String whereHql = "";
		//封装查询条件的数据
		List paramList = new ArrayList();
		if(sysCodeRuleSearch != null){
			if(StringUtils.isNotBlank(sysCodeRuleSearch.getModule())){
				whereHql = whereHql + " and o.module like ? ";
				paramList.add("%" + sysCodeRuleSearch.getModule().trim() + "%");
			}
		}
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" order by o.id ", " asc ");
		return sysCodeRuleDao.findObjectsByConditionWithNoPage(whereHql, paramList, orderby);
	}
	/**
	 * 保存新添加的编码规则
	 * @param sysCodeRule
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveSysCodeRule(SysCodeRule sysCodeRule) {
		
		sysCodeRuleDao.save(sysCodeRule);
	}
	/**
	 * 批量删除编码规则数据
	 * @param ids
	 */
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSysCodeRulesById(String[] ids) {
		Integer []id = DataType.converterStringArray2IntegerArray(ids);
		sysCodeRuleDao.deleteObjectsByIds(id);
	}

}
