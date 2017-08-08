<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>相关文档新建</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

</head>
 
<body>
 
<form action="${pageContext.request.contextPath}/crm/customer/file/edit.jsp" method="post" enctype="multipart/form-data" name="ActionForm" onSubmit="return check();">
<input type="hidden" name="method" value="add">
<input type="hidden" name="recordId" value="8">
<input type="hidden" name="module" value="company">
<input type="hidden" name="fileName" value="">
<input type="hidden" name="filePath" value="">
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('file.do?method=list')"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
</div>
 
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
			<td class="red">上传文件：</td>
			<td colspan="3">
				<input type="file" name="file" style="width:96%">
			</td>
			</tr>
		  <tr>
			<td>文档等级：</td>
			<td><select id='fileGrade' name='fileGrade' style='width:90%'>
<option value='' selected>------</option>
<option value='普通文件'>普通文件</option>
<option value='机密文件'>机密文件</option>
</select><img border='0' align='absmiddle' src='${pageContext.request.contextPath}/ui/images/service.gif' style='cursor:hand' onClick="OpenWin('/sys/dictionary/detail.do?method=popeController&oid=file_grade&pid=13','',500,300)"></td>
			<td>文档类型：</td>
			<td><select id='fileType' name='fileType' style='width:90%'>
<option value='' selected>------</option>
<option value='电子文档'>电子文档</option>
<option value='书面文档'>书面文档</option>
</select><img border='0' align='absmiddle' src='${pageContext.request.contextPath}/ui/images/service.gif' style='cursor:hand' onClick="OpenWin('/sys/dictionary/detail.do?method=popeController&oid=file_type&pid=14','',500,300)"></td>
		  </tr>
		  <tr>
			<td>上传人：</td>
			<td>
				<input name="handler" type="text" id="handler" style="width:90%" value="系统管理员">
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td valign="top">文档说明：</td>
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
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>
		  <tr>
				<td>创建人：</td>
				<td><input name="creator" type="text" class="disabled" id="creator" style="width:90%" value="系统管理员" readonly></td>
				<td>创建时间：</td>
				<td><input name="createTimeStr" type="text" class="disabled" style="width:90%" id="createTimeStr" value="2010-03-29 22:46:40" readonly></td>
			</tr>
			<tr>
				<td>修改人：</td>
				<td><input name="updater" type="text" class="disabled" id="updater" style="width:90%" value="系统管理员" readonly></td>
				<td>修改时间：</td>
				<td><input name="updateTimeStr" type="text" class="disabled" style="width:90%" id="updateTimeStr" value="2010-03-29 22:46:40" readonly></td>
			</tr>
		  <tr>
			<td>所属人：</td>
			<td>
			<input name="owner_usr" type="hidden" value="1">
			<input name="owner_name" type="text" id="owner_name" class="disabled" style="width:90%" readonly value="系统管理员">
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
  		</table>
	</div>
	</td>
	</tr>
</table>
</form>
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
</body>
</html>
