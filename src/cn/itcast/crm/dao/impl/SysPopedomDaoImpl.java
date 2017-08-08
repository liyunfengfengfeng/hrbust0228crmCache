package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysPopedomDao;
import cn.itcast.crm.domain.SysPopedom;
/**
 * 操作表
 * 包含对该系统所有的操作
 * 可以进行细粒度的权限控制
 * @author LIYUNFENG
 *
 */
@Repository(ISysPopedomDao.SERVICE_NAME)
public class SysPopedomDaoImpl extends CommonDaoImpl<SysPopedom> implements
		ISysPopedomDao {

	

}
