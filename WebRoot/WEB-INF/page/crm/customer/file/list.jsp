<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>相关文档</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">

<script language=JavaScript> 
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
		<div id="menuTitle1" style="font-weight:bold">相关文档搜索</div>
	</td>
</tr>
<tr>
<td>
<div id="menu1">	
<form name="form1" method="post" action="file.do">
<input type="hidden" name="method" value="search">
<input type="hidden" name="record_id" value="8">
<input type="hidden" name="back" value="list">
<input type="hidden" name="module" value="company">
<table  width="100%" border="0" cellspacing="5" cellpadding="0">
	<tr>
    	<td width="38%" height="45" nowrap>上传人：
   	    	<input name="handler" type="text" id="handler" value="" style="width:140px"></td>
  	    <td width="39%" nowrap>文档名称：
		  	<input name="file_name" type="text" id="file_name" value="" style="width:140px">
		</td>
  	    <td width="23%" align="center">
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.form1.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
      			<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="goRefresh()"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
			</div>
		</td>
	</tr>
	<tr>
	<td colspan="3">创建时间：
			<input type='text' id='begintime' name='begintime'  class="dateClassStyle"  value='' style='width:120px'>
		  	&nbsp;至&nbsp;
		  	<input type='text' id='endtime' name='endtime'  class="dateClassStyle"  value='' style='width:120px'>
	</td>
	</tr>
</table>
</form>
</div>
</td>
</tr>	
</table>	
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;相关文档列表</h3>
<div class="control">
	  <button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	          onClick="forward('${pageContext.request.contextPath}/crm/customer/file/add.jsp')">
	          <img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
	  <button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	         onClick="delForm('${pageContext.request.contextPath}/crm/customer/file/view.jsp')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
</div>
<!-- list -->
<div class="border">
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
 
	<!-- title -->
	<tr>
    	<td width="7%" class="listViewThS1">
    		<input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();"></td>
  	    <td width="18%" class="listViewThS1">文档名称</td>
  	    <td width="12%" class="listViewThS1">文档类型</td>
		<td width="13%" class="listViewThS1">文档等级</td>
        <td width="14%" class="listViewThS1">上传人</td>
        <td width="18%" class="listViewThS1">创建时间</td>
        <td width="18%" class="listViewThS1">操作</td>
        </tr>
	<tr>
    	<td width="7%">
    	  <input type="checkbox" name="ids" value="3" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td width="18%"><a href="file.do?method=load&id=3">
  	    	0909171429301d533b84959f35.jpg</a></td>
  	    <td width="13%">
  	    	电子文档</td>
        <td width="12%">
        	普通文件</td>
        <td width="14%">
        	系统管理员</td>
        <td width="18%">
        	2010-03-29</td>
        <td width="18%">
        	<a href="javascript:do_download('/doc/company/201003299606637061.jpg','0909171429301d533b84959f35.jpg');">
        	下载</a></td>
        </tr>
	
	
	<tr>
    	<td width="7%">
    	  <input type="checkbox" name="ids" value="2" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td width="18%"><a href="file.do?method=load&id=2">
  	    	0909171429301d533b84959f35.jpg</a></td>
  	    <td width="13%">
  	    	电子文档</td>
        <td width="12%">
        	普通文件</td>
        <td width="14%">
        	系统管理员</td>
        <td width="18%">
        	2010-03-29</td>
        <td width="18%">
        	<a href="javascript:do_download('/doc/company/201003297345618327.jpg','0909171429301d533b84959f35.jpg');">
        	下载</a></td>
        </tr>
	
	
	<tr>
    	<td width="7%">
    	  <input type="checkbox" name="ids" value="1" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td width="18%"><a href="file.do?method=load&id=1">
  	    	jquery-datepick.rar</a></td>
  	    <td width="13%">
  	    	电子文档</td>
        <td width="12%">
        	普通文件</td>
        <td width="14%">
        	系统管理员</td>
        <td width="18%">
        	2010-03-29</td>
        <td width="18%">
        	<a href="javascript:do_download('/doc/company/201003290461121939.rar','jquery-datepick.rar');">
        	下载</a></td>
        </tr>
	
	
</table>
</form>
 
</div>
</body>
</html>
