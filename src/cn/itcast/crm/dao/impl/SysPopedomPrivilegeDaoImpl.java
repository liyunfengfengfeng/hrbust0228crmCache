package cn.itcast.crm.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.crm.dao.ISysPopedomPrivilegeDao;
import cn.itcast.crm.domain.SysPopedomPrivilege;
/**
 * 该表存储每一个权限组拥有的什么权限
 * 而每一个用户对应一个权限组
 * @author LIYUNFENG
 *
 */
@Repository(ISysPopedomPrivilegeDao.SERVICE_NAME)
public class SysPopedomPrivilegeDaoImpl extends CommonDaoImpl<SysPopedomPrivilege> implements
		ISysPopedomPrivilegeDao {

	
}
