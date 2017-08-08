<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>联系人修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
</head>
 
<body>
 
<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/crm/customer/linkman/edit.jsp" onSubmit="return check();">
<input type="hidden" name="id" value="3">
<input type="hidden" name="cid" value="8">
<input type="hidden" name="method" value="update">
<input type="hidden" name="shareFlag" value="">
<input type="hidden" name="shareIds" value="">
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linkman.do?method=list')"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linkman.do?method=load&id=0')" disabled><img src="${pageContext.request.contextPath}/ui/images/button/daoshouye.png" border='0' align='absmiddle'>&nbsp;上一个</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linkman.do?method=load&id=2')"><img src="${pageContext.request.contextPath}/ui/images/button/daoweiye.png" border='0' align='absmiddle'>&nbsp;下一个</button>
</div>
 
	<font color="red">保存成功！</font>
 
<table width="100%" border="0" cellspacing="0" class="tabForm">
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
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>		
		  <tr>
			<td class="red">姓名：</td>
			<td><input name="name" type="text" id="name" style="width:90%" value="张国立" onChange="getPycode(this.value);"></td>
			<td>性别：</td>
			<td><select name='sex' id='sex' style='width:90%'>
<option value=''>------</option>
<option value='男' selected>男</option>
<option value='女'>女</option>
</select></td>
		  </tr>
		  <tr>
			<td>编码：</td>
			<td><input name="code" type="text" id="code" style="width:90%" value="MAN-20100329-003"></td>
			<td>拼音码：</td>
			<td><input name="pycode" type="text" id="pycode" style="width:90%" value="zgl" readonly class="disabled"></td>
		  </tr>
		  <tr>
			<td>出生日期：</td>
			<td><input type='text' id='birthday' name='birthday' class="dateClassStyle" value='' style='width:90%'></td>
			<td>传真：</td>
			<td><input name="fax" type="text" id="fax" style="width:90%" value=""></td>
		  </tr>
		  <tr>
			<td>部门：</td>
			<td><input name="department" type="text" id="department" style="width:90%" value=""></td>
			<td>职务：</td>
			<td><input name="duty" type="text" id="duty" style="width:90%" value=""></td>
		  </tr>
		  <tr>
			<td>办公电话：</td>
			<td><input name="officeTel" type="text" id="officeTel" style="width:90%" value=""></td>
			<td>家庭电话：</td>
			<td><input name="homeTel" type="text" id="homeTel" style="width:90%" value=""></td>
		  </tr>
		  <tr>
			<td>手机：</td>
			<td><input name="mobile" type="text" id="mobile" style="width:90%" value=""></td>
			<td>是否主联系人：</td>
			<td><input type='radio' name='mainFlag' id='mainFlag' value='Y' class='radio'>是<input type='radio' name='main_flag' id='main_flag' value='N' class='radio' checked>否</td>
		  </tr>
		  <tr>
			<td>电子邮件：</td>
			<td><input name="email" type="text" id="email" style="width:90%" value=""></td>
			<td>邮政编码：</td>
			<td><input name="postcode" type="text" id="postcode" style="width:90%" value=""></td>
		  </tr>
		  <tr>
			<td>QQ号：</td>
			<td><input name="imNum" type="text" id="imNum" style="width:90%" value=""></td>
			<td>QQ昵称：</td>
			<td><input name="imName" type="text" id="imName" style="width:90%" value=""></td>
		  </tr>
		  <tr>
			<td valign="top">联系地址：</td>
			<td colspan="3"><input name="address" type="text" id="address" style="width:96%" value=""></td>
		  </tr>
		  <tr>
			<td valign="top">其他联系：</td>
			<td colspan="3"><input name="otherLink" type="text" id="otherLink" style="width:96%" value=""></td>
		  </tr>
		  <tr>
			<td valign="top">爱好：</td>
			<td colspan="3"><textarea name="hobby" rows="4" id="hobby" style="width:96%"></textarea></td>
		  </tr>
		  <tr>
			<td valign="top">忌讳：</td>
			<td colspan="3"><textarea name="taboo" rows="4" id="taboo" style="width:96%"></textarea></td>
		  </tr>
		  <tr>
			<td valign="top">备注：</td>
			<td colspan="3"><textarea name="remark" rows="4" id="remark" style="width:96%"></textarea></td>
		  </tr>
		  </table>
		</div>
	</td>
  </tr>
</table>
 
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <td colspan="4" class="th_head">
		<div id="menuArrow2" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle2" style="font-weight:bold">其他信息</div>
	</td>
  </tr>
  <tr>
  	<td>
  	<div id="menu2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="16%">创建人：</td>
			<td width="34%"><input name="creater" type="text" class="disabled" id="creater" value="系统管理员" style="width:90%" readonly></td>
			<td width="16%">创建日期：</td>
			<td width="34%"><input name="createTime" class="disabled" readonly value="2010-03-29 17:34:29" type="text" id="create_time" style="width:90%">    </td>
		  </tr>
		  <tr>
			<td>修改人：</td>
			<td>
				<input type="hidden" name="updater" value="系统管理员">
				<input name="updater2" type="text" readonly id="updater2" value="系统管理员" class="disabled" style="width:90%"></td>
			<td>修改日期：</td>
			<td>
			<input type="hidden" name="updateTime" value="2010-03-29 17:34:46">
			<input name="updateTimeStr2" class="disabled" readonly value="2010-03-29 17:34:29" type="text" id="updateTimeStr2" style="width:90%"></td>
		  </tr>
		  <tr>
			<td>所属人：</td>
			<td>
			<input name="ownerUser" type="hidden" value="1">
			<input name="ownerName" type="text" id="ownerName" class="disabled" style="width:90%" readonly value="系统管理员">
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
  		</table>
	</div>
	</td>
	</tr>
</table>
<br>
</form>
</body>
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
</html>

