<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户资料</title>

<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.3.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/opform.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

<script language="javascript"> 
function parent(obj0){
window.opener.doCustomer2(obj0);
window.close();
}
</script>
 
</head>
 
<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
		<span onClick="">&nbsp;客户资料&nbsp;</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">客户搜索</div>
	</th>
    <th class="th_head" >
		<div align="right" name="base1" id="base1">
            <a class="tabFormAdvLink" href="javascript:showadv(0);">
            <img alt="" src="${pageContext.request.contextPath}/ui/images/advanced_search.gif" border="0" />&nbsp;高级查询</a>
        </div>
		<div style="display:none" align="right" name="adv1" id="adv1">
            <a class="tabFormAdvLink" href="javascript:showadv(1);">
            <img alt="" src="${pageContext.request.contextPath}/ui/images/basic_search.gif" border="0" />&nbsp;基本查询</a>
        </div>
	</th>
  </tr>
  <tr>
	  <td colspan="2">
<form name="form1" method="post" action="customer.do">
<input type="hidden" name="method" value="select">
<input type="hidden" id="isAdvanced0" name="isAdvanced" value="">
<input type="hidden" name="columns" value="name">
<input type="hidden" name="m" value="doCustomer2">
<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
	<tr>
  	    <td width="13%" nowrap>客户性质：</td>
   	    <td width="12%" nowrap><select id='quality' name='quality' style='width:100px'>
<option value='' selected>------</option>
<option value='下属子公司'>下属子公司</option>
<option value='上级主管单位'>上级主管单位</option>
<option value='竞争对手'>竞争对手</option>
<option value='合作伙伴'>合作伙伴</option>
<option value='代理商'>代理商</option>
<option value='供应商'>供应商</option>
<option value='客户'>客户</option>
</select></td>
  	    <td width="13%" nowrap>客户名称：</td>
		<td width="12%" nowrap><input name="name" type="text" id="name" value="" style="width:100px"></td>
		<td width="13%" nowrap>所属人：</td>
		<td width="12%" nowrap><select id='owner_usr' name='owner_usr' style='width:100px'>
<option value='' selected>------</option>
<option value='1'>系统管理员</option>
</select></td>
  	    <td width="25%" align="center">
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.form1.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
      			<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('customer.do?method=select&columns=name&m=doCustomer2')"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
			</div>
		</td>
	</tr>
	<tr>
		<td>拼音码：</td>
		<td><input name="pycode" type="text" id="pycode" value="" style="width:100px"></td>
		<td>电话一：</td>
		<td><input name="tel1" type="text" id="tel1" value="" style="width:100px"></td>
		<td>传真：</td>
		<td><input name="fax" type="text" id="fax" value="" style="width:100px"></td>
	</tr>
</table>
</form>
<form name="form2" method="post" action="customer.do">
<input type="hidden" name="method" value="select">
<input type="hidden" name="columns" value="name">
<input type="hidden" name="m" value="doCustomer2">
<input type="hidden" id="isAdvanced1" name="isAdvanced" value="">
<table width="100%" style="display:none" border="0" cellspacing="0" cellpadding="0" name="adv" id="adv">
	<tr>
    	<td width="13%" nowrap>客户性质：</td>
   	    <td width="12%" nowrap><select id='quality' name='quality' style='width:100px'>
<option value='' selected>------</option>
<option value='下属子公司'>下属子公司</option>
<option value='上级主管单位'>上级主管单位</option>
<option value='竞争对手'>竞争对手</option>
<option value='合作伙伴'>合作伙伴</option>
<option value='代理商'>代理商</option>
<option value='供应商'>供应商</option>
<option value='客户'>客户</option>
</select></td>
  	    <td width="13%" nowrap>客户名称：</td>
		<td width="12%" nowrap><input name="name" type="text" id="name" value="" style="width:100px"></td>
		<td width="13%" nowrap>所属人：</td>
		<td width="12%" nowrap><select id='owner_usr' name='owner_usr' style='width:100px'>
<option value='' selected>------</option>
<option value='1'>系统管理员</option>
</select></td>
  	    <td width="25%" align="center">
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.form2.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('customer.do?method=select&columns=name&m=doCustomer2')"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
			</div>
		</td>
  	</tr>
  	<tr>
		<td>拼音码：</td>
		<td><input name="pycode" type="text" id="pycode" value="" style="width:100px"></td>
		<td>电话一：</td>
		<td><input name="tel1" type="text" id="tel1" value="" style="width:100px"></td>
		<td>传真：</td>
		<td><input name="fax" type="text" id="fax" value="" style="width:100px"></td>
	</tr>
	<tr>
		<td>省份：</td>
		<td><select name="province" id="province" style="width:100px"><option>------</option></select></td>
		<td>城市：</td>
		<td><select name="city" id="city" style="width:100px"><option>------</option></select></td>
		<td>客户等级：</td>
		<td><select id='grade' name='grade' style='width:100px'>
<option value='' selected>------</option>
<option value='放弃客户'>放弃客户</option>
<option value='机会客户'>机会客户</option>
<option value='潜在客户'>潜在客户</option>
<option value='成交客户'>成交客户</option>
<option value='签约客户'>签约客户</option>
<option value='重要客户'>重要客户</option>
</select></td>
	</tr>
	
</table>
</form>
	  </td>
  </tr>
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;客户列表</h3>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="window.close();"><img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' align='absmiddle'>&nbsp;关闭</button>
</div>
<!-- list -->
<div class="border">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="listViewPaginationTdS1">
	<tr>
    	<td width="29%">&nbsp;</td>
  	    <td width="71%" align="right">
		
			共8条&nbsp;&nbsp;首页&nbsp;
上一页&nbsp;
1/1&nbsp;
下一页&nbsp;
末页&nbsp;
<select id='_pj_pages1' name='_pj_pages1' onChange='toPage1()' style='font-size=11px;'><option value='1' selected>第1页</option></select><script>function toPage1() {var _pj_pages = document.getElementById('_pj_pages1').value;var _pj_pageFlag = 'pages';var _pj_url = '/crm/customer/customer.do?m=doCustomer2&columns=name&method=select&pages=1&pageSize=10';var _pj_p_re = new RegExp(_pj_pageFlag+'=\\d+','g');_pj_url = _pj_url.replace(_pj_p_re,_pj_pageFlag+'='+_pj_pages);window.location = _pj_url;}</script><select id='_pj_pagesize1' name='_pj_pagesize1' onChange='changeSize1()' style='font-size=11px;'><option value='10' selected>10条</option><option value='15'>15条</option><option value='20'>20条</option><option value='30'>30条</option><option value='50'>50条</option><option value='100'>100条</option><option value='200'>200条</option></select><script>function changeSize1() {var _pj_pagesize = document.getElementById('_pj_pagesize1').value;var _pj_pagesizeFlag = 'pageSize';var _pj_url = '/crm/customer/customer.do?m=doCustomer2&columns=name&method=select&pages=1&pageSize=10';var _pj_p_re = new RegExp(_pj_pagesizeFlag+'=\\d+','g');_pj_url = _pj_url.replace(_pj_p_re,_pj_pagesizeFlag+'='+_pj_pagesize);window.location = _pj_url;}</script>
		
		</td>
	</tr>
</table>
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="10%" class="listViewThS1">操作</td>
  	    <td width="14%" class="listViewThS1">客户编码</td>
  	    <td width="22%" class="listViewThS1">客户名称</td>
  	    <td width="10%" class="listViewThS1">客户等级</td>
        <td width="10%" class="listViewThS1">省份</td>
        <td width="11%" class="listViewThS1">城市</td>
        <td width="11%" class="listViewThS1">电话一</td>
        <td width="12%" class="listViewThS1">电话二</td>
      </tr>
	<!-- data -->
 
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('eeeee')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100329-005</td>
  	    <td>eeeee</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('北京软通动力软件技术有限公司')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100329-004</td>
  	    <td>北京软通动力软件技术有限公司</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('ttttttt')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100329-002</td>
  	    <td>ttttttt</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('iiiii')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100329-001</td>
  	    <td>iiiii</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('dfdfgfdgd')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100328-003</td>
  	    <td>dfdfgfdgd</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('zxvcdzxvdcv')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100328-002</td>
  	    <td>zxvcdzxvdcv</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('传智播客')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100328-001</td>
  	    <td>传智播客</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
	
	<tr>
    	<td><button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="javascript:parent('dddd')"><img src="${pageContext.request.contextPath}/ui/images/button/xuanze.png" border='0' align='absmiddle'>&nbsp;选择</button></td>
  	    <td>C-20100325-001</td>
  	    <td>dddd</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	    <td>&nbsp;</td>
  	 </tr>
	
 
</table>
</form>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="listViewPaginationTdS1">
	<tr>
    	<td width="29%">&nbsp;</td>
  	    <td width="71%" align="right">
		
			共8条&nbsp;&nbsp;首页&nbsp;
上一页&nbsp;
1/1&nbsp;
下一页&nbsp;
末页&nbsp;
<select id='_pj_pages2' name='_pj_pages2' onChange='toPage2()' style='font-size=11px;'><option value='1' selected>第1页</option></select><script>function toPage2() {var _pj_pages = document.getElementById('_pj_pages2').value;var _pj_pageFlag = 'pages';var _pj_url = '/crm/customer/customer.do?m=doCustomer2&columns=name&method=select&pages=1&pageSize=10';var _pj_p_re = new RegExp(_pj_pageFlag+'=\\d+','g');_pj_url = _pj_url.replace(_pj_p_re,_pj_pageFlag+'='+_pj_pages);window.location = _pj_url;}</script><select id='_pj_pagesize2' name='_pj_pagesize2' onChange='changeSize2()' style='font-size=11px;'><option value='10' selected>10条</option><option value='15'>15条</option><option value='20'>20条</option><option value='30'>30条</option><option value='50'>50条</option><option value='100'>100条</option><option value='200'>200条</option></select><script>function changeSize2() {var _pj_pagesize = document.getElementById('_pj_pagesize2').value;var _pj_pagesizeFlag = 'pageSize';var _pj_url = '/crm/customer/customer.do?m=doCustomer2&columns=name&method=select&pages=1&pageSize=10';var _pj_p_re = new RegExp(_pj_pagesizeFlag+'=\\d+','g');_pj_url = _pj_url.replace(_pj_p_re,_pj_pagesizeFlag+'='+_pj_pagesize);window.location = _pj_url;}</script><script>var isAdvanced = "";if(isAdvanced=="Y"){try{showadv(0);}catch(e){}}</script>
		
		</td>
	</tr>
</table>
</div>
</body>
<script language="javascript"> 
//province_city
var provCity = new Roly.ProvCity();
provCity.init('','');
</script>
</html>

