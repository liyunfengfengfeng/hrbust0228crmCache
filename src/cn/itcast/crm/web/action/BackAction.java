package cn.itcast.crm.web.action;

import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class BackAction extends BaseAction{
	/**
	 * 退出
	 * @return
	 */
	public String back(){
		HttpSession session = request.getSession();
		session.invalidate();
		return "back";
	}
	

}
