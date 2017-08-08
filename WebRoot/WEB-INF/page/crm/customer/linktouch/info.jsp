<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>查看拜访记录</title>
<link  href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.3.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/opform.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

</head>
 
<body>
<form name="ActionForm" method="post" action="linktouch.do" onSubmit="">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	查看拜访记录
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouchlist.do?method=listAll&m_type=customer')"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouchlist.do?method=loadRead&id=0')" disabled><img src="${pageContext.request.contextPath}/ui/images/button/daoshouye.png" border='0' align='absmiddle'>&nbsp;上一个</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouchlist.do?method=loadRead&id=3')"><img src="${pageContext.request.contextPath}/ui/images/button/daoweiye.png" border='0' align='absmiddle'>&nbsp;下一个</button>
</div>
 
<table width="100%" border="0" cellspacing="0" class="tabDetailView">
  <tr>
    <td colspan="4" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">基本信息</div>
	</td>
  </tr>
  <tr>
  	<td>
		<div id="menu1">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">		
			  <tr>
				<td width="16%" class="tabDetailViewDL">联系人：</td>
				<td width="34%" class="tabDetailViewDF">王刚&nbsp;</td>
				<td width="16%" class="tabDetailViewDL">联系方式：</td>
				<td width="34%" class="tabDetailViewDF">登门拜访&nbsp;</td>
			  </tr>
			  <tr>
				<td class="tabDetailViewDL">联系时间：</td>
				<td class="tabDetailViewDF">2010-03-29&nbsp;</td>
				<td class="tabDetailViewDL">联系类别：</td>
				<td class="tabDetailViewDF">二次跟进&nbsp;</td>
			  </tr>
			  <tr>
				<td class="tabDetailViewDL">联系记录：</td>
				<td colspan="3" height="45" class="tabDetailViewDF">与客户签订销售合同，客户咨询产品&nbsp;</td>
			  </tr>
			  <tr>
				<td class="tabDetailViewDL">下次联系时间：</td>
				<td class="tabDetailViewDF">2010-03-31&nbsp;</td>
				<td class="tabDetailViewDL">业务员：</td>
				<td class="tabDetailViewDF">系统管理员&nbsp;</td>
			  </tr>		  
			  <tr>
				<td class="tabDetailViewDL">下次联系目标：</td>
				<td colspan="3" height="45" class="tabDetailViewDF">&nbsp;</td>
			  </tr>
			  <tr>
				<td class="tabDetailViewDL">备注：</td>
				<td colspan="3" height="45" class="tabDetailViewDF">&nbsp;</td>
			  </tr>
		  </table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabDetailView">
  <tr>
    <td colspan="4" class="th_head">
		<div id="menuArrow4" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle4" style="font-weight:bold">其他信息</div>
	</td>
  </tr>
  <tr>
  	<td>
  	<div id="menu4">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="16%" class="tabDetailViewDL">创建人：</td>
			<td width="34%" class="tabDetailViewDF">系统管理员&nbsp;</td>
			<td width="16%" class="tabDetailViewDL">创建时间：</td>
			<td width="34%" class="tabDetailViewDF">2010-03-29 22:01:10&nbsp;</td>
		  </tr>
		  <tr>
			<td class="tabDetailViewDL">修改人：</td>
			<td class="tabDetailViewDF">系统管理员&nbsp;</td>
			<td class="tabDetailViewDL">修改时间：</td>
			<td class="tabDetailViewDF">2010-03-29 22:10:23&nbsp;</td>
		  </tr>
		  <tr>
			<td class="tabDetailViewDL">所属人：</td>
			<td colspan="3" class="tabDetailViewDF">系统管理员</td>
		  </tr>
  		</table>
	</div>
	</td>
	</tr>
</table>
</form>
<br/>
 
</body>
</html>


