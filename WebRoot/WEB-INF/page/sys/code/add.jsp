<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>

<script language="javascript">
function check() {
	var f = document.ActionForm;
	var msgs = ""
		+ checkNull(f.module,"模块名称")
		+ checkNull(f.area_prefix,"编码前缀")
		+ checkNull(f.tab_name,"数据库表名");
	_first_check_col = "";
	if(msgs == "")
		return true;
	else {
		alert(msgs);
		return false;
	}
}
function preview() {
	var prefix = encodeURI(document.ActionForm.area_prefix.value);
	if(prefix == "") {
		alert("请输入编码前缀!");
		document.ActionForm.area_prefix.focus();
		return false;
	}
	var timeForm = document.ActionForm.area_time;
	var time = "";
	for(var i=0;i<timeForm.length;i++) {
		var temp = timeForm[i];
		if(temp.checked) {
			time = temp.value;
		}
	}
	var glide = document.ActionForm.glide_bit.value;
	var url = "preview.jsp?area_prefix="+prefix+"&area_time="+time+"&glide_bit="+glide;
	OpenWin(url,'',500,200);
}
</script>
</head>

<body>
<s:form name="ActionForm" method="post" action="codeAction_save.do" namespace="/sys" onSubmit="return check();">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	编码规则-新建
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="preview()"><img src="${pageContext.request.contextPath}/ui/images/button/yulan.png" border='0' align='absmiddle'>&nbsp;预览</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('rule.do?method=list')"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
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
				<td class="red">模块名称：</td>
				<td>
					<s:textfield name="module" id="module" cssStyle="width:90%" cssClass="input"/>
				</td>
				<td class="red">数据库表名：</td>
				<td>
					<s:textfield name="tabName" id="tabName" cssStyle="width:90%" cssClass="input"/>
				</td>
			</tr>
			<tr>
				<td class="red">编码前缀：</td>
				<td>
					<s:textfield name="areaPrefix" id="areaPrefix" cssStyle="width:90%" cssClass="input"/>
				</td>
				<td class="red">流水位：</td>
				<td>
					<s:if test="%{#request.gildeBits != null}">
						<s:select list="%{#request.gildeBits}"
						name="glideBit" id="glideBit"
						listKey="value" listValue="value"
						cssStyle="width:90%;"
						headerKey="" headerValue="----">
						
						
						</s:select>
					</s:if>
				</td>
			</tr>
			<tr>
				<td class="red">日期位：</td>
				<td colspan="3">
					<s:if test="%{#request.areaTimes != null}">
					<s:radio list="%{#request.areaTimes}"
					name="areaTime" id="areaTime"
					listKey="value" listValue="value"
					cssClass="radio">
					
					</s:radio>
					</s:if>
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</s:form>

</body>
</html>