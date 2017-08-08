<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>城市新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<style type="text/css">
body {
	padding:10px;
}
</style>
</head>

<body>
<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/sys/cityAction_update.do" onSubmit="return check();">
<input type="hidden" name="pid" value="${city.pid }">
<br>
<div class="control">
	
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="parent.close_window();"><img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' align='absmiddle'>&nbsp;关闭</button>
</div>

<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">基本信息</div>
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
				<td class="red">名称：</td>
				<td><input name="name" type="text" class="input" id="name" style="width:90%"></td>
				<td class="red">拼音码：</td>
				<td><input name="pycode" type="text" class="input" id="pycode" style="width:90%"></td>
			</tr>
			<tr>
				<td>邮政编码：</td>
				<td><input name="postcode" type="text" class="input" id="postcode" style="width:90%"></td>
				<td>区号：</td>
				<td><input name="areacode" type="text" class="input" id="areacode" style="width:90%"></td>
			</tr>
			<tr>
				<td colspan="4" height="5"></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>

<br/>
</form>
</body>
</html>