<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>填写拜访记录</title>
<link  href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
</head>
 
<body>
<form name="ActionForm" method="post" action="${pageContext.request.contextPath}/crm/customer/linktouch/edit.jsp" onSubmit="return check();">
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="4">
<input type="hidden" name="cid" value="8" >
<input type="hidden" name="shareFlag" value="">
<input type="hidden" name="shareIds" value="">
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouch.do?method=list')"><img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' align='absmiddle'>&nbsp;返回</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouch.do?method=load&id=0')" disabled><img src="${pageContext.request.contextPath}/ui/images/button/daoshouye.png" border='0' align='absmiddle'>&nbsp;上一个</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('linktouch.do?method=load&id=3')"><img src="${pageContext.request.contextPath}/ui/images/button/daoweiye.png" border='0' align='absmiddle'>&nbsp;下一个</button>
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
			<td width="16%" class="red">联系人：</td>
			<td width="34%">
				<input type='text' id='linkMan' name='linkMan' value='王刚' style='width:85%' class='combox-input'><img src='${pageContext.request.contextPath}/ui/images/combox_b.jpg' id='link_manIMG' width='18' height='20' border='0' align='absmiddle'/><script>var link_man = new Roly.Combox('link_man','link_manIMG');link_man.addItem('张丹枫');link_man.addItem('王刚');link_man.addItem('张国立');link_man.addItem('ddd');link_man.init();</script>
			</td>
			<td width="16%">联系方式：</td>
			<td width="34%"><select id='linkFashion' name='linkFashion' style='width:90%'>
				<option value=''>------</option>
				<option value='他人转达'>他人转达</option>
				<option value='通过代理商联系'>通过代理商联系</option>
				<option value='登门拜访' selected>登门拜访</option>
				<option value='网络聊天（QQ/MSN）'>网络聊天（QQ/MSN）</option>
				<option value='邮寄包裹信笺'>邮寄包裹信笺</option>
				<option value='短信留言'>短信留言</option>
				<option value='电话传真'>电话传真</option>
</select><img border='0' align='absmiddle' src='${pageContext.request.contextPath}/ui/images/service.gif' style='cursor:hand' onClick="OpenWin('${pageContext.request.contextPath}/sys/dictionary/batchEditDetails.jsp','',500,300)"></td>
		  </tr>
		  <tr>
			<td class="red">联系时间：</td>
			<td><input type='text' id='linkTime' name='linkTime'  class="dateClassStyle" value='2010-03-29' style='width:90%'></td>
			<td>联系类别：</td>
			<td><select id='linkType' name='linkType' style='width:90%'>
<option value=''>------</option>
<option value='初次接触'>初次接触</option>
<option value='二次跟进' selected>二次跟进</option>
<option value='对方回馈信息'>对方回馈信息</option>
<option value='合同确认'>合同确认</option>
<option value='洽谈签约'>洽谈签约</option>
<option value='售后服务'>售后服务</option>
<option value='客户回访'>客户回访</option>
<option value='节日问候'>节日问候</option>
</select><img border='0' align='absmiddle' src='${pageContext.request.contextPath}/ui/images/service.gif' style='cursor:hand' onClick="OpenWin('${pageContext.request.contextPath}/sys/dictionary/batchEditDetails.jsp','',500,300)"></td>
		  </tr>
		  <tr>
			<td class="red">联系记录：</td>
			<td colspan="3"><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="OpenWin('${pageContext.request.contextPath}/include/chooseDictionary.jsp','',580,400);"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button><textarea name="content" rows="4" id="content" style="width:96%">与客户签订销售合同，客户咨询产品</textarea></td>
		  </tr>
		  <tr>
			<td>下次联系时间：</td>
			<td><input type='text' id='nextTouchDate' name='nextTouchDate'  class="dateClassStyle"  value='2010-03-31' style='width:90%'></td>
			<td>业务员：</td>
			<td>
				<input type='text' id='userName' name='userName' value='系统管理员' style='width:84%' class='combox-input'><img src='${pageContext.request.contextPath}/ui/images/combox_b.jpg' id='user_nameIMG' width='18' height='20' border='0' align='absmiddle'/><script>var user_name = new Roly.Combox('user_name','user_nameIMG');user_name.addItem('系统管理员');user_name.init();</script>
			</td>
		  </tr>		  
		  <tr>
			<td>下次联系目标：</td>
			<td colspan="3">
				<textarea name="nextTouchAim" rows="4" id="nextTouchAim" style="width:96%"></textarea>
			</td>
			</tr>
 
		  <tr>
			<td>备注：</td>
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
			<td width="16%">创建时间：</td>
			<td width="34%"><input name="createTime" class="disabled" readonly value="2010-03-29 22:01:10" type="text"
			    id="createTime" style="width:90%">    </td>
		  </tr>
		  <tr>
			<td>修改人：</td>
			<td>
				<input type="hidden" name="updater" value="系统管理员">
				<input name="updater2" type="text" readonly id="updater2" value="系统管理员" class="disabled" style="width:90%"></td>
			<td>修改时间：</td>
			<td>
			<input type="hidden" name="updateTime" value="2010-03-29 22:01:25">
			<input name="updateTimeStr2" class="disabled" readonly value="2010-03-29 22:01:10" type="text" id="updateTimeStr2" style="width:90%"></td>
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
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
<br/>
</body>
</html>


