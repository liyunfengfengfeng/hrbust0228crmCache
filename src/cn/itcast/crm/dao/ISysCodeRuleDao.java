package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.SysCodeRule;
/**
 * 编码规则表的dao层
 * @author LIYUNFENG
 *
 */
public interface ISysCodeRuleDao extends ICommonDao<SysCodeRule> {
	public static final String SERVICE_NAME = "cn.itcast.crm.dao.impl.SysCodeRuleDaoImpl";
	
}
