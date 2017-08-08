package cn.itcast.crm.dao;

import java.util.List;

import cn.itcast.crm.domain.SysUser;

public interface ISysUserDao extends ICommonDao<SysUser> {
    public final static String SERVICE_NAME = "cn.itcast.crm.dao.impl.SysUserDaoImpl";
   
}
