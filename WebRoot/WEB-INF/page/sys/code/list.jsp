<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编码规则</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script type="text/javascript">
 function forward(strURL){
     window.location=strURL;
 }
</script>
</head>

<body>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	<span class="menu_selected">编码规则</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tabForm">
  <tr>
    <th class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">编码规则搜索</div>
	</th>
    <th class="th_head" >
	</th>
  </tr>
  <tr>
	  <td colspan="2">
<s:form name="SearchForm" method="post" action="codeAction_list.do">

<table width="100%" border="0" cellspacing="0" cellpadding="0" name="base" id="base">
	<tr>
    	<td width="38%" nowrap>模块名称：
    		<s:textfield name="module" id="module" value="" cssStyle="width:140px"/>
    	</td>
  	    <td width="39%" nowrap>&nbsp;</td>
  	    <td width="23%" align="center">
		<div class="control">
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.SearchForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/sousuo.png" border='0' align='absmiddle'>&nbsp;搜索</button>
		<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('rule.do?method=search')"><img src="${pageContext.request.contextPath}/ui/images/button/qingkong.png" border='0' align='absmiddle'>&nbsp;清空</button>
		</div>
		</td>
	</tr>
</table>
</s:form>
	  </td>
  </tr>
</table>
<br>
<h3><img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png" border="0">&nbsp;编码规则列表</h3>

<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="forward('${pageContext.request.contextPath}/sys/codeAction_add.do')"><img src="${pageContext.request.contextPath}/ui/images/button/xinjian.png" border='0' align='absmiddle'>&nbsp;新建</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
</div>

<!-- list -->
<div class="border">
<s:form name="ActionForm" method="post" action="codeAction_delete.do" namespace="/sys">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="PowerTable" class="PowerTable">
	<!-- title -->
	<tr>
    	<td width="7%" class="listViewThS1">
   	    <input type="checkbox" name="checkall" value="" class="checkbox" onClick="CheckAll(this.checked);changeCheckCount();">   	  		</td>
  	    <td width="22%" class="listViewThS1">模块名称</td>
  	    <td width="21%" class="listViewThS1">编码前缀</td>
  	    <td width="19%" class="listViewThS1">日期位</td>
  	    <td width="15%" class="listViewThS1">流水位</td>
		<td width="16%" class="listViewThS1">预览</td>
	</tr>
	<!-- data -->

	<c:if test="${! empty requestScope.sysCodeRules }">
		<c:forEach items="${requestScope.sysCodeRules }" var="sysCodeRule">
	<tr>
    	<td>
    	  <input type="checkbox" name="ids" value="${sysCodeRule.id }" class="checkbox" 
		  onClick="changeCheckCount();">
		</td>
  	   
		<td><a href="edit.jsp">
			${sysCodeRule.module }</a></td>
		<td>${sysCodeRule.areaPrefix }</td>
		<td>${sysCodeRule.areaTime }</td>
		<td>${sysCodeRule.glideBit }</td>
		<td>${sysCodeRule.currentCode }</td>
	</tr>
		</c:forEach>
	</c:if>
	
	

</table>
</s:form>
 
</div>

</body>
</html>