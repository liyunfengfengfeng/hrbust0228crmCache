<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>联系人列表</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

</head>
 
<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	<span id="menu_selected" class="menu_selected">联系人列表</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">联系人搜索</div>
	</th>
   
  </tr>
  <tr>
	  <td colspan="2">
<form name="form1" method="post" action="linkmanlist.do">
<input type="hidden" name="method" value="searchAll">
<input type="hidden" name="mtype" value="customer">
<input type="hidden" id="isAdvanced0" name="isAdvanced" value="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
	<tr>
  	    <td width="12%" nowrap>姓名：</td>
   	    <td width="15%" nowrap><input name="name" type="text" id="name" value="" style="width:110px"></td>
  	    <td width="12%" nowrap>手机：</td>
		<td width="15%" nowrap><input name="mobile" type="text" id="mobile" value="" style="width:110px"></td>
		<td width="12%" nowrap>QQ号：</td>
		<td width="15%" nowrap><input name="imNum" type="text" id="imNum" value="" style="width:110px"></td>
  	    <td width="19%" align="center">
		<div class="control">
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.form1.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="goRefresh()"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
		</div>
		</td>
	</tr>
	<tr>
		<td>客户名称：</td>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="100%"><input name="c_company" type="text" id="c_company" value="" style="width:100%"></td>
                <td width="21"><img src="${pageContext.request.contextPath}/ui/images/lookup.gif" width="21" height="19" style="cursor:hand" onClick="OpenWin('${pageContext.request.contextPath}/crm/customer/include/customerSelect.jsp')"></td>
              </tr>
            </table>
		</td>
		<td>QQ昵称：</td>
		<td><input name="imName" type="text" id="imName" value="" style="width:110px"></td>
		<td>办公电话：</td>
		<td><input name="officeTel" type="text" id="officeTel" value="" style="width:110px"></td>
	</tr>
	<tr>
		<td>家庭电话：</td>
		<td><input name="homeTel" type="text" id="homeTel" value="" style="width:110px"></td>
		<td>电子邮件：</td>
		<td><input name="email" type="text" id="email" value="" style="width:110px"></td>
		<td>所属人：</td>
		<td><select id='ownerUser' name='ownerUser' style='width:110px'>
				<option value='' selected>------</option>
				<option value='1'>系统管理员</option>
            </select>
        </td>
	</tr>
</table>
</form>
	  </td>
  </tr>
</table>
 
 
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;联系人列表</h3>
<!-- list -->
<div class="border">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
  	    <td width="4%" class="listViewThS1"><input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();"></td>
  	    <td width="16%" class="listViewThS1">姓名</td>
  	    <td width="8%" class="listViewThS1">性别</td>
  	    <td width="12%" class="listViewThS1">手机</td>
  	    <td width="20%" class="listViewThS1">客户名称</td>
        <td width="10%" class="listViewThS1">部门</td>
        <td width="10%" class="listViewThS1">职务</td>
        <td width="10%" class="listViewThS1">电子邮件</td>
        <td width="10%" class="listViewThS1">办公电话</td>
        </tr>
	<!-- data -->
 
	
	
	
	<tr>
  	    <td><input type="checkbox" name="ids" value="4" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="${pageContext.request.contextPath}/crm/customer/linkman/info.jsp">ddd</a></td>
  	    <td>男</td>
  	    <td>&nbsp;</td>
  	    <td><a href="javascript:forward('${pageContext.request.contextPath}/crm/customer/base/main.jsp')">北京软通动力软件技术有限公司</a></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
	
	
	
	<tr>
  	    <td><input type="checkbox" name="ids" value="3" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="linkmanlist.do?method=loadRead&id=3&m_type=customer">张国立</a></td>
  	    <td>男</td>
  	    <td>&nbsp;</td>
  	    <td><a href="javascript:forward('/crm/customer/std/main.jsp?back=list&isFrom=cvisit&id=8')">北京软通动力软件技术有限公司</a></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
	
	
	
	<tr>
  	    <td><input type="checkbox" name="ids" value="2" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="linkmanlist.do?method=loadRead&id=2&m_type=customer">王刚</a></td>
  	    <td>男</td>
  	    <td>&nbsp;</td>
  	    <td><a href="javascript:forward('/crm/customer/std/main.jsp?back=list&isFrom=cvisit&id=8')">北京软通动力软件技术有限公司</a></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
	
	
	
	<tr>
  	    <td><input type="checkbox" name="ids" value="1" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="linkmanlist.do?method=loadRead&id=1&m_type=customer">张丹枫</a></td>
  	    <td>男</td>
  	    <td>&nbsp;</td>
  	    <td><a href="javascript:forward('/crm/customer/std/main.jsp?back=list&isFrom=cvisit&id=8')">北京软通动力软件技术有限公司</a></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
	
</table>
 
</div>
</body>
</html>
