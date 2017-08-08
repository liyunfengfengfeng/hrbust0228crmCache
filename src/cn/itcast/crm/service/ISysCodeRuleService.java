package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.bean.SysCodeRuleSearch;
import cn.itcast.crm.domain.SysCodeRule;

/**
 * 编码规则表
 * 的业务层
 * @author LIYUNFENG
 *
 */
public interface ISysCodeRuleService {
	public static final String SERVICE_NAME = "cn.itcast.crm.service.impl.SysCodeRuleServiceImpl";
	/**
	 * 该方法用于生成流水号
	 * @return
	 */
	public String createGlideNumber();
	/**
	 * 查询所有的编码规则
	 * @return
	 */
	public List<SysCodeRule> findAllCodes(SysCodeRuleSearch sysCodeRuleSearch);
	/**
	 * 保存新添加的编码规则
	 * @param sysCodeRule
	 */
	public void saveSysCodeRule(SysCodeRule sysCodeRule);
	/**
	 * 批量删除编码规则数据
	 * @param ids
	 */
	public void deleteSysCodeRulesById(String[] ids);
}
