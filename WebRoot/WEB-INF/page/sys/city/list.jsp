<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>城市资料</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script type="text/javascript">
 function forward(strURL){
     window.location=strURL;
 }
 function onChangeSelect(){
 	
 	document.getElementById("method").value=document.getElementById("pid").value;
 }
 function new_add(){
    
    document.SearchForm.action="${pageContext.request.contextPath}/sys/cityAction_add.do";
 	document.SearchForm.submit();
 }
 function del_Form(){
 	document.ActionForm.action="${pageContext.request.contextPath}/sys/cityAction_delete.do";
 	document.ActionForm.submit();
 }
</script>
</head>

<body>
<div id="popshow" style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr style='background-color:#6A82A8;'>
		<th width='80%' height="25" align='left' onMouseDown=initializedragie(popshow) style="cursor:move" onselectstart="return false">
		<font color='#FFFFFF'>&nbsp;详细信息</font>
		</th>
		<td align='right' onselectstart="return false">	
			<a href='#' onClick="close_window();">
			<img src="${pageContext.request.contextPath}/ui/images/xpclose.jpg" width="20" height="20" border="0" onClick="" align="absmiddle"></a>
		</td>
	</tr>
	<tr>
		<td colspan="2" onselectstart="return false">
		<div id='gedit'></div>
		</td>
	</tr>
</table>
<iframe src="javascript:false" style="position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-1; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)'; frameborder='0';"></iframe>
</div>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	城市资料
</div>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;城市资料搜索</h3>
<form name="SearchForm" method="post" action="${pageContext.request.contextPath}/sys/cityAction_list.do">
<input type="hidden" name="method" id="method" >
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm" name="base" id="base">

	<tr>
    	<td width="38%" height="45" nowrap>省份：
		<s:if test="%{#request.provinces != null}">  	    	
			<s:select list="%{#request.provinces}"
			
			listKey="id" listValue="name"
			id='pid' name='pid'
			cssStyle="width:140px"
			onChange='onChangeSelect();'>
			</s:select>
         </s:if>    
		</td>
  	    <td width="39%" nowrap>&nbsp;</td>
  	    <td width="23%" align="center">
		<div class="control">
		<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.SearchForm.submit();">
		<img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align="middle">&nbsp;搜索</button>
      	<button class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="">
      	<img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align="middle">&nbsp;清空</button>
		</div>
		</td>
	</tr>
</table>
</form>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;城市资料列表</h3>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="new_add();"><img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="del_Form();"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('${pageContext.request.contextPath}/sys/cityAction_refresh.do')"><img src="${pageContext.request.contextPath}/ui/images/button/shuaxin.png" border='0' align='absmiddle'>&nbsp;刷新</button>
</div>
<!-- list -->
<div class="border">
<form name="ActionForm" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="7%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();">   	  		</td>
  	    <td width="33%" class="listViewThS1">名称</td>
  	    <td width="30%" class="listViewThS1">拼音码</td>
  	    <td width="15%" class="listViewThS1">邮政编码</td>
  	    <td width="15%" class="listViewThS1">区号</td>
        </tr>
	<!-- data -->

	
	<c:if test="${ ! empty requestScope.citys }">
		<c:forEach items="${requestScope.citys }" var="city">
	<tr>
		
    	<td><input type="checkbox" name="ids" value="${city.id }" class="checkbox" onClick="changeCheckCount();"></td>
  	    <td><a href="#" onClick="OpenDiv('${pageContext.request.contextPath}/sys/cityAction_edit.do?id=${city.id }')">${city.name }</a></td>
		<td>${city.pycode }</td>
		<td>${city.postcode }</td>
		<td>${city.areacode }</td>
		</tr>
		</c:forEach>
	</c:if>
</table>
</form>
 
</div>
</body>
</html>