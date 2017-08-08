<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则修改</title>
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
<form name="ActionForm" method="post" action="rule.do" onSubmit="return check();">
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="10">
<input type="hidden" name="current_code" value="PTYPE-20071015-001">
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	编码规则-修改
</div>
<br>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="if(check()) document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
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
				<td><input name="module" type="text" class="disabled" id="module" style="width:90%" value="商品类别" readonly></td>
				<td class="red">数据库表名：</td>
				<td><input name="tab_name" type="text" class="disabled" id="tab_name" style="width:90%" value="b_product_type" readonly></td>
			</tr>
			<tr>
				<td class="red">编码前缀：</td>
				<td>
					<input name="area_prefix" type="text" class="input" id="area_prefix" style="width:90%" value="PTYPE">
				</td>
				<td class="red">流水位：</td>
				<td><select name='glide_bit' id='glide_bit' style='width:90%'>
<option value=''>------</option>
<option value='3' selected>3</option>
<option value='4'>4</option>
<option value='5'>5</option>
<option value='6'>6</option>
<option value='7'>7</option>
<option value='8'>8</option>
<option value='9'>9</option>
<option value='10'>10</option>
</select></td>
			</tr>
			<tr>
				<td class="red">日期位：</td>
				<td colspan="3">
					<input type='radio' name='area_time' id='area_time' value='yyyyMMdd' class='radio' checked>yyyyMMdd<input type='radio' name='area_time' id='area_time' value='yyyy-MM-dd' class='radio'>yyyy-MM-dd<input type='radio' name='area_time' id='area_time' value='yyyyMM' class='radio'>yyyyMM<input type='radio' name='area_time' id='area_time' value='yyyy-MM' class='radio'>yyyy-MM<input type='radio' name='area_time' id='area_time' value='yyyy' class='radio'>yyyy<input type='radio' name='area_time' id='area_time' value='NULL' class='radio'>无
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</form>

</body>
</html>