<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选择权限</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>

<style type="text/css">
<!--
fieldset div {
	float:left;
	width:24%;
	line-height:25px;
	text-align:left;
}
td div {
	float:left;
	width:24%;
	line-height:25px;
	text-align:left;
}
-->
</style>
<script language="javascript">
   function goSelect(id){
      var valueStr=$("#"+id).val();
	  var array=valueStr.split(",");
	  if(array[0] != array[1]){
	     if($("#"+id)[0].checked){
		 	 var supid=array[0]+"_"+array[0];
		 	 $("#"+ supid).attr("checked","checked"); 
		 }else{
		 	 var $jihe=$("input[type='checkbox'][value^="+array[0]+"]:not([value$="+array[0]+"])"); 
			 var flag=false;
			 
			 $jihe.each(function(index,domEle){
				 if(this.checked){
				 	flag=true;
					return;
				 }
			 });
			 
			 if(!flag){
			 	  var supid=array[0]+"_"+array[0];
		 	       $("#"+ supid).attr("checked",null); 
			 }
		 }
	  }
	  
	  if(array[0]==array[1]){
	  	 if($("#"+id)[0].checked){
		     $("input[type='checkbox'][value^="+array[0]+"]").attr("checked","checked");   	
		 }else{
		 	  $("input[type='checkbox'][value^="+array[0]+"]").attr("checked",null); 
		 }
	  }
  }
  
  function SelectAllBox(){
     $("input[type=checkbox][name=popedomModule]").attr("checked","checked");
  }

  function UnSelectAllBox(){
	     $("input[type=checkbox][name=popedomModule]").attr("checked",null);
  }
</script>
</head>

<body>
<s:form name="ActionForm" method="post" action="sysRoleAction_updatePopedom.do" namespace="/sys">
<s:hidden name="roleId" value="%{#request.sysRole.id}" />
<br/>
<div class="control">
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	onMouseOut="this.className='button';"  onClick="SelectAllBox()"><img src="${pageContext.request.contextPath}/ui/images/button/quanbuxz.png" border='0' align='absmiddle'>&nbsp;全部选中</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	onMouseOut="this.className='button';"  onClick="UnSelectAllBox()"><img src="${pageContext.request.contextPath}/ui/images/button/quanbubxz.png" border='0' align='absmiddle'>&nbsp;全部不选中</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	onMouseOut="this.className='button';"  onClick="document.ActionForm.submit();"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" 
	onMouseOut="this.className='button';"  onClick="parent.close();"><img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' align='absmiddle'>&nbsp;关闭</button>
</div>

<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#6A82A8">
	<tr>
		<td align="center" height="25"><span style="color:#FFFFFF; font-weight:bold">操作权限组：${sysRole.getName() }</span></td>
	</tr>
<c:if test="${ ! empty requestScope.sysPopedoms }">
</table>
<div class="border" style="padding:3px">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
			
			<c:forEach items="${requestScope.sysPopedoms }" var="sysPopedomSup">
					<c:if test="${sysPopedomSup.id.popedom_Module==sysPopedomSup.id.popedom_Privilege }">
						<c:forEach items="${requestScope.sysPopedomPrivileges }" var="sysPopedomPrivilege">
							<c:if test="${sysPopedomSup.id.popedom_Module==sysPopedomPrivilege.id.popedom_Module&&sysPopedomSup.id.popedom_Privilege==sysPopedomPrivilege.id.popedom_Privilege }">
								<c:set scope="page" value="checked" var="xxx"/>
							</c:if>
						</c:forEach>
						<fieldset style='padding:5px;clear:left;'>
							<legend><input type='checkbox' class='checkbox' name='popedomModule'   ${xxx }
							   value='${sysPopedomSup.id.popedom_Module },${sysPopedomSup.id.popedom_Privilege}'
							   id='${sysPopedomSup.id.popedom_Module }_${sysPopedomSup.id.popedom_Privilege}' 
							   onClick='goSelect(this.id)'>${sysPopedomSup.popedom_Name }
							</legend>
							 
						<c:remove var="xxx"/>	 
							 
							 
							 
							 
							 
							  <c:forEach items="${requestScope.sysPopedoms }" var="sysPopedomSub">
									<c:if test="${sysPopedomSup.id.popedom_Module==sysPopedomSub.id.popedom_Module
									&&sysPopedomSub.id.popedom_Module!=sysPopedomSub.id.popedom_Privilege }">
									  <c:forEach items="${requestScope.sysPopedomPrivileges }" var="sysPopedomPrivilege">
									  <c:if test="${sysPopedomSub.id.popedom_Module==sysPopedomPrivilege.id.popedom_Module&&sysPopedomSub.id.popedom_Privilege==sysPopedomPrivilege.id.popedom_Privilege }">
									   		<c:set scope="page" value="checked" var="xxx"/>
									   </c:if>
									   
									   </c:forEach>
									    <div><input type='checkbox' class='checkbox' name='popedomModule' ${xxx }
									    value='${sysPopedomSub.id.popedom_Module },${sysPopedomSub.id.popedom_Privilege}'
									    id='${sysPopedomSub.id.popedom_Module }_${sysPopedomSub.id.popedom_Privilege}' 
									    onClick='goSelect(this.id)'>${sysPopedomSub.popedom_Name }</div>
									</c:if>
							 </c:forEach>
							</fieldset>
							
					</c:if>
				</c:forEach>
				<c:remove var="xxx"/>
			</td>
		</tr>
	</table>
</c:if>
</div>
</s:form>
</body>
</html>