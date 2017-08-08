package cn.itcast.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.ISysPopedomDao;
import cn.itcast.crm.domain.SysPopedom;
import cn.itcast.crm.service.ISysPopedomService;
/**
 * 操作表的业务层
 * 包含对该系统所有的操作
 * 可以进行细粒度的权限控制
 * @author LIYUNFENG
 *
 */
@Service(ISysPopedomService.SERVICE_NAME)
@Transactional(readOnly=true)
public class SysPopedomServiceImpl implements ISysPopedomService {
	//获取功能表的业务层 
	@Resource(name=ISysPopedomDao.SERVICE_NAME)
	ISysPopedomDao sysPopedomDao;
	/**
	 * 查询系统所具有的所有功能
	 * 获取操作表(功能表的所有功能)
	 * @return
	 */
	public List<SysPopedom> findAllPopedom() {
		
		return sysPopedomDao.findAllPopedom();
	}
	
}
