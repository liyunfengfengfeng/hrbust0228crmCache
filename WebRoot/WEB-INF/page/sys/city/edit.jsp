<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>辅助信息</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<style type="text/css">
body {
	padding:10px;
}
</style>
</head>

<body>
<s:form name="ActionForm" method="post" namespace="/sys" action="cityAction_updateCity.do" onSubmit="return check();">
<s:hidden name="id"/>
<s:hidden name="pid"/>
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
				<td>
					<s:textfield name="name" id="name" cssStyle="width:90%" cssClass="input" />
				</td>
				<td class="red">拼音码：</td>
				<td>
					<s:textfield name="pycode" id="pycode"  cssClass="input" cssStyle="width:90%"/>
				</td>
			</tr>
			<tr>
				<td>邮政编码：</td>
				<td>
					<s:textfield name="postcode" id="postcode"  cssClass="input" cssStyle="width:90%"/>
				</td>
				<td>区号：</td>
				<td>
					<s:textfield name="areacode" id="areacode"  cssStyle="width:90%" cssClass="input"/>
				</td>
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
</s:form>
</body>
</html>