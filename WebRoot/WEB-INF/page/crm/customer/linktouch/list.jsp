<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>联系记录</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
<script type="text/javascript">
function forward(strURL){
    window.location=strURL;
}
</script>
</head>
 
<body>
<table width="100%" border="0" cellspacing="0" class="tabForm">
<tr>
	<td colspan="4" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">联系记录搜索</div>
	</td>
</tr>
<tr>
<td>
<div id="menu1">
<form name="form2" method="post" action="linktouch.do">
<input type="hidden" name="method" value="search">
<input type="hidden" name="c_id" value="8">
<input type="hidden" name="back" value="list">
<table  width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<td width="15%" nowrap>联系人：</td>
   	    <td width="12%" nowrap><input name="linkMan" type="text" id="linkMan" value="" style="width:110px">
		</td>
  	    <td width="15%" nowrap>联系方式：</td>
   	    <td width="12%" nowrap><select id='linkFashion' name='linkFashion' style='width:110px'>
<option value='' selected>------</option>
<option value='他人转达'>他人转达</option>
<option value='通过代理商联系'>通过代理商联系</option>
<option value='登门拜访'>登门拜访</option>
<option value='网络聊天（QQ/MSN）'>网络聊天（QQ/MSN）</option>
<option value='邮寄包裹信笺'>邮寄包裹信笺</option>
<option value='短信留言'>短信留言</option>
<option value='电话传真'>电话传真</option>
</select>
		</td>
		<td width="15%" nowrap>联系类别：</td>
   	    <td width="12%" nowrap><select id='linkType' name='linkType' style='width:110px'>
<option value='' selected>------</option>
<option value='初次接触'>初次接触</option>
<option value='二次跟进'>二次跟进</option>
<option value='对方回馈信息'>对方回馈信息</option>
<option value='合同确认'>合同确认</option>
<option value='洽谈签约'>洽谈签约</option>
<option value='售后服务'>售后服务</option>
<option value='客户回访'>客户回访</option>
<option value='节日问候'>节日问候</option>
</select>
		</td>
  	    <td width="19%" align="center" nowrap>
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.form2.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="goRefresh()"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
			</div>
        </td>
  	</tr>
  	<tr>
		<td>业务员：</td>
		<td><input type='text' id='userName' name='userName' value='' style='width:90px' class='combox-input'><img src='${pageContext.request.contextPath}/ui/images/combox_b.jpg' id='user_nameIMG' width='18' height='20' border='0' align='absmiddle'/><script>var user_name = new Roly.Combox('user_name','user_nameIMG');user_name.addItem('系统管理员');user_name.init();</script>
		</td>
		<td>下次联系目标：</td>
		<td><input name="nextTouchAim" type="text" id="nextTouchAim" value="" style="width:105px">
		</td>
		<td>联系记录：</td>
		<td><input name="content" type="text" id="content" value="" style="width:110px">
		</td>
	</tr>
	<tr>
		<td>业务员部门：</td>
		<td><select id='owner_dpt' name='owner_dpt' style='width:110px'>
<option value='' selected>------</option>
<option value='1'>系统维护部</option>
</select></td>
		<td>联系时间：</td>
		<td><select name='queryTime' id='queryTime' style='width:110px' onChange='changeQueryTime()'>
<option value='' selected>------</option>
<option value='Today'>今天</option>
<option value='CurrentWeek'>本周</option>
<option value='CurrentMonth'>本月</option>
<option value='CurrentSeason'>本季度</option>
<option value='CurrentYear'>本年</option>
<option value='LastWeek'>上周</option>
<option value='LastMonth'>上月</option>
<option value='LastSeason'>上季度</option>
<option value='LastYear'>去年</option>
<option value='CustomTime'>自定义</option>
</select>
		</td>
		<td colspan="3"><div id="CustomTime" style="float:left;display:none;"> 从
				<input type='text' id='beginTime2' name='beginTime' value='2010-02-28' style='width:90px'><img src='${pageContext.request.contextPath}/ui/images/Calendar.gif' name='beginTimeStrIMG2' style='cursor:hand' id='beginTimeStrIMG2' align='absmiddle' alt='选择日期'/><script language='JavaScript'>Calendar.setup({inputField:"beginTime2",ifFormat:"%Y-%m-%d",button:"beginTimeStrIMG2"});</script>
				到
				<input type='text' id='endTime2' name='endTime' value='2010-03-29' style='width:90px'><img src='${pageContext.request.contextPath}/ui/images/Calendar.gif' name='endTimeStrIMG2' style='cursor:hand' id='endTimeStrIMG2' align='absmiddle' alt='选择日期'/><script language='JavaScript'>Calendar.setup({inputField:"endTime2",ifFormat:"%Y-%m-%d",button:"endTimeStrIMG2"});</script>
			</div>
		</td>
	</tr>
</table>
</form>
</div>
</td>
</tr>	
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;联系记录列表</h3>
<div class="control">
  <button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
          onClick="forward('${pageContext.request.contextPath}/crm/customer/linktouch/add.jsp')">
          <img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
  <button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
          onClick="delForm('${pageContext.request.contextPath}/crm/customer/linktouch/view.jsp')">
          <img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
</div>	
<!-- list -->
<div class="border">
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<tr>
    	<td width="3%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();"></td>
   	    <td width="35%" class="listViewThS1">联系记录</td>
        <td width="10%" class="listViewThS1">联系时间</td>
   	    <td width="12%" class="listViewThS1">联系人</td>
		<td width="16%" class="listViewThS1">联系方式</td>
        <td width="12%" class="listViewThS1">业务员</td>
        <td width="12%" class="listViewThS1">下次联系时间</td>
      </tr>
	<tr>
    	<td><input type="checkbox" name="ids" value="2" class="checkbox" onClick="changeCheckCount();"></td>
		<td><a href="linktouch.do?method=load&id=2">与客户签订销售合同，客户咨询产品</a></td>
        <td>2010-03-29</td>
		<td>王刚</td>
		<td>电话传真</td>
        <td>系统管理员</td>
        <td>2010-03-25</td>
  	</tr>
	<tr>
    	<td><input type="checkbox" name="ids" value="1" class="checkbox" onClick="changeCheckCount();"></td>
		<td><a href="linktouch.do?method=load&id=1">与客户签订销售合同，跟客户沟通合同信息</a></td>
        <td>2010-03-29</td>
		<td>张丹枫</td>
		<td>电话传真</td>
        <td>系统管理员</td>
        <td>2010-03-25</td>
  	</tr>
</table>
</form>
 
</div> 
</body>
</html>
