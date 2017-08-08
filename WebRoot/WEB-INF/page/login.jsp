<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@page import="java.net.URLDecoder"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CRM客户关系管理系统</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<style>
.font{color:#000000;font-size:9pt;font-family:"宋体"}
.td{
font-size:9pt;
font-family:"宋体";
height:25px;
}
INPUT{
	background-color: #FFFFFF;
}
body {
	margin:	0px;
}
</style>
<script type="text/javascript">
  function changeCheckNum(){
  /*这里用到的是jquery因为登录页面不需要获取到表单数据
  *所以不用将标签替换为struts2标签
  *
  */
    var checkNumImage_=document.getElementById("checkNumImage");
    checkNumImage_.src="${pageContext.request.contextPath}/image.jsp?timeStamp="+new Date().getTime();
  }
  
  function checkSubmit(){
	    //处理用户名不能为空
	    if($("#name").val().length<=0){
	    	alert('用户名不能为空');
	    	return false;
	    }
	    //处理密码不能为空
	    if($("#password").val().length<=0){
	    	alert('密码不能为空');
	    	return false;
	    }
	    //处理验证码不能为空
	    if($("#checkNum").val().length<=0){
	    	alert('验证码不能为空');
	    	return false;
	    }
	    //可以提交
	    document.form1.submit();
	  }
</script>
</head>
<BODY  topmargin="0" leftmargin="0" onLoad="if (window.location != window.top.location) window.top.location.href=window.location.href; document.all.userName.focus();setUserName();">
<% 
	//处理cookie
	String name = "";
	String password = "";
	Cookie []cookies = request.getCookies();
	if(cookies != null && cookies.length>0){
		for(int i = 0;i<cookies.length;i++){
			//处理用户名
			if("name".equals(cookies[i].getName())){
				name = URLDecoder.decode(cookies[i].getValue(), "utf-8");
			}
			//处理密码
			if("psw".equals(cookies[i].getName())){
				password = cookies[i].getValue();
			}
		}
	}
	System.out.println("name :" + name);
	System.out.println("password :" + password);
%>


<form name="form1" method="post" action="${pageContext.request.contextPath}/sys/sysUserAction_isLogin.do">
<TABLE width="100%" cellpadding="0" cellspacing="0" id="header">
<TR>
	<TD>
	<TABLE height="80" cellpadding="0" cellspacing="0" width="100%">
	<TR>
		<TD width="225"><img src="${pageContext.request.contextPath}/ui/images/ban_1.gif"></TD>
		<TD background="${pageContext.request.contextPath}/ui/images/ban_2.gif">&nbsp;</TD>
		<TD width="181" background="${pageContext.request.contextPath}/ui/images/ban_2.gif"></TD>
	</TR>
	</TABLE>
	</TD>
</TR>
<TR>
	<TD height="119" background="${pageContext.request.contextPath}/ui/images/bg.gif">&nbsp;</TD>
</TR>
<TR>
	<TD height="300">
	<TABLE width="100%" cellpadding="0" cellspacing="0">
	<TR>
		<TD valign="top" align="center"><img src="${pageContext.request.contextPath}/ui/images/logo.png">
		</TD>
		<TD width="44" height="200" background="${pageContext.request.contextPath}/ui/images/line.png">&nbsp;</TD>
		<TD width="540" valign="top">
		  <TABLE width="100%" cellpadding="0" cellspacing="0">
		  <TR>
		  	<TD height="140" valign="top">
			  <font class="font">请输入您的用户名及密码:</font>
			  <br>
           		<font color="#FF0000"></font><br>
			  <TABLE cellpadding="0" cellspacing="0">
			  <TR>
			  	<TD class="td">用户帐号：</TD><TD class="td">
			  	<input name="name" type="text" value="<%=name %>" id="name"/><s:fielderror fieldName="name"/></TD>
			  </TR>
			  <TR>
			  	<TD class="td">登录密码：</TD>
			  	<TD class="td"><input name="password" type="password" value="<%=password %>" id="password"></TD>
			  </TR>
			  <TR>
			  	<TD class="td">验&nbsp;证&nbsp;码：</TD>
			  	<TD class="td"><input name="checkNum" type="text" value="" id="checkNum" style="width: 80"/>
				  	<img id="checkNumImage" src="${pageContext.request.contextPath}/image.jsp" height="19" align="absmiddle" onClick="changeCheckNum()" 
			  	           title="点击换一张" style="cursor:hand"><s:fielderror fieldName="checkNum"/></TD>
			  </TR>
			  <TR>
			  	<TD class="td">记&nbsp;住&nbsp;我：</TD>
			  	<TD class="td"><input name="rememberMe" type="checkbox" id="rememberMe" value="yes" class="checkbox" ></TD>
			  </TR>
			  </TABLE>
			</TD>
		  </TR>
		  <TR>
		  	<TD><img src="${pageContext.request.contextPath}/ui/images/login.png" id="login" 
		  	     onClick="checkSubmit();" style="cursor:hand">
		  	&nbsp;&nbsp;
		  	 	<button style="background: transparent;border:0;" type="reset"><img src="${pageContext.request.contextPath}/ui/images/reset.png"  id="reset" 
		  	      onClick="" style="cursor:hand;background: transparent;border:0;"></button></TD>
		  </TR>
		  </TABLE>
		</TD>
	</TR>
	</TABLE>
	</TD>
</TR>
<TR>
	<TD align="center"><br><a href="http://jwzx.hrbust.edu.cn/" target="_blank">哈尔滨理工大学软件学院</a></TD>
</TR>
<TR>
	<TD height="5">&nbsp;</TD>
</TR>
</TABLE>
</form>
</BODY>
</html>