<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户查重设置</title>

<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.3.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/opform.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

<script language="javascript"> 
function showBackMessage() {
 
}
 
// DOM2
if ( typeof window.addEventListener != "undefined" )
	window.addEventListener( "load", showBackMessage, false );
 
// IE 
else if ( typeof window.attachEvent != "undefined" ) {
	window.attachEvent( "onload", showBackMessage );
}
 
else {
	document.onreadystatechange = function() {
		if(document.readyState=="complete") {
			showBackMessage();
		}
	}
}
</script>
<script language="javascript"> 
function check() {
	return confirm("您确定保存吗？");
}
function goRun() {
	var url = "../../../loading.jsp?url=/crm/customer/rule/rule.do?method=run";
	OpenWin(url,"",500,400);
}
function isShowStatus(boundValue) {
	if(boundValue=="仅客户"){
		document.getElementById("searchStatus").style.display="";
		//document.all.searchStatus.style.display = "";
	}else{
		document.getElementById("searchStatus").style.display="none";
		//document.all.searchStatus.style.display = "none";
	}
}
</script>
<style type="text/css"> 
<!--
div.checkbox {
	float:left;
	width:24%;
	text-align:left;
}
div.h {
	height:25px;
}
-->
</style>
</head>
<body>
<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/crm/customer/rule/rule.jsp" onSubmit="return check();">
<input type="hidden" name="method" value="save">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	客户查重设置
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="if(check()) document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
</div>
 
<!-- 客户资料查重 开始 -->
 
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">查重策略</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu1">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>		
			<tr>
				<td>策略名称：</td>
				<td class="red"><input type="hidden" name="id_4" value="customer_CheckRepeat">
				客户资料查重</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td height="40">可查重客户属性：</td>
				<td colspan="3">
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="name"
			checked
		>
		客户名称	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="fax"
			
		>
		传真	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="tel1"
			checked
		>
		电话一	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="tel2"
			
		>
		电话二	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="mobile"
			
		>
		手机	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="email"
			
		>
		电子邮件	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="web"
			checked
		>
		公司网站	
	</div>
 
	<div class="checkbox">
		<input name="repeat_property" type="checkbox" class="checkbox" value="address">
		联系地址	
	</div>
 
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
 
</body>
</html>
