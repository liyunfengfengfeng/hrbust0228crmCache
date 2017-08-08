package cn.itcast.crm.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.xwork.StringUtils;

import cn.itcast.crm.domain.SysUser;

public class SessionUtils {
/**
 * 处理验证码
 * 比较系统自动生成的验证码与与用户输入的是否一致
 * HttpServletRequest 是action获取页面表单的request
 */
	public static boolean isCheckNum(HttpServletRequest request){
		//验证码在生成时就已经存在了session
		// 将认证码存入SESSION
		//session.setAttribute("CHECK_NUMBER_KEY", sRand);
		//所以需要获取已经存在的session
		HttpSession session = request.getSession(false);
		String CHECK_NUMBER_KEY = (String) session.getAttribute("CHECK_NUMBER_KEY");
		if(StringUtils.isBlank(CHECK_NUMBER_KEY)){
			return false;
		}
		//获取用户输入的验证码
		String checkNum = (String)request.getParameter("checkNum");
		if(StringUtils.isBlank(checkNum)){
			return false;
		}
		//进行相等比较
		return checkNum.equalsIgnoreCase(CHECK_NUMBER_KEY);
	}
	/**
	 * 保存用户的登录信息到session中
	 * @param sysUser
	 * @param request
	 */
     public static void saveSysUser2Session(SysUser sysUser,
		HttpServletRequest request) {
    	 HttpSession session = request.getSession();
    	 if(sysUser != null){
    		 session.setAttribute("sysUser", sysUser);
    	 }
     }
     /**
      * 从session中获取当前登录用户
      * @param request
      * @return
      */
	public static SysUser getSysUserFromSession(HttpServletRequest request) {
		if(request!=null){
			System.out.println("获取当前登录用户的request不为空");
		}
		//获取已经存在的session
		HttpSession session = request.getSession(false);
		SysUser sysUser = null;
		if(session!=null){
			//从session中获取当前登录用户
			sysUser = (SysUser) session.getAttribute("sysUser");
		}
		return sysUser;
	}
}
