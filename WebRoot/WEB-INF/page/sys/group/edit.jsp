<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script language="javascript">
	function check() {
		document.form1.submit();
	}
</script>
</head>

<body>
<s:form name="form1" method="post" action="sysUserGroupAction_update.do" namespace="/sys">
<!-- 把id设为struts隐藏标签这样保存时才能按照id保存 -->
<s:hidden name="id"/>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	部门修改
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="check()"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="document.form2.submit()"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
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
				<td class="red">部门名称</td>
				<td>
					<s:textfield name="name" id="name" cssClass="input" cssStyle="width:90%"/>
				</td>
				<td>部门负责人</td>
				<td>
					<s:textfield name="principle" id="principal" cssClass="input" cssStyle="width:90%"/>
				</td>
			</tr>
			<tr>
				<td height="40" valign="top">部门职能</td>
				<td colspan="3">
								<s:textarea name="inclument" id="incumbent" cssStyle="width:96%" rows="3"/>
				</td>
			</tr>
			<tr>
				<td height="40" valign="top">备注</td>
				<td colspan="3">
								<s:textarea name="remark" rows="3" id="remark" cssStyle="width:96%"/>
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</s:form>
<s:form name="form2" method="post" action="sysUserGroupAction_back.do" namespace="/sys">
</s:form>
</body>
</html>