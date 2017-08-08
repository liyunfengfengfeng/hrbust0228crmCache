<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员修改</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/popshow.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>

<!--处理日期 开始 -->
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css" type="text/css">
<!--处理日期结束  -->
<script type="text/javascript">
	//返回上一界面
	function go_Back(){
		document.form1.action="sysUserAction_back.do";
		document.form1.submit();
	}
	//到更新密码页面
	//function update_Pass(){
	//	document.form1.action="sysUserAction_load.do";
	//    document.form1.submit();
	//}
</script>
</head>

<body>
<s:form name="form1" method="post" action="sysUserAction_update.do"  namespace="/sys">
<!-- 在回显时已经将id传了所来 -->
<s:hidden  name="id"/>
<div class="mtitle">
	<div class="mtitle-row">&nbsp;</div>
	人员-修改
</div>
<br>
<div class="control">
   
   <!-- 组织修改密码的链接在回显复制给vo时id就有值了 -->
   <s:url value="/sys/sysUserAction_load.do" var="url">
       <s:param name="id" value="id"></s:param>
       <s:param name="name" value="name"></s:param>
       <s:param name="cnName" value="cnName"></s:param>
   </s:url>
   
   
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="document.forms[0].submit();">
	        <img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' 
	        align='absmiddle'>&nbsp;保存</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="OpenDiv('<s:property value="#url"/>')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/xgmm.png" border='0' 
	        align='absmiddle'>&nbsp;修改密码</button>
	<button disabled="disabled" type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	        onClick="OpenWin('/sys/user/user.do?method=print&id=12')">
	        <img src="${pageContext.request.contextPath}/ui/images/button/dayin.png" border='0' 
	        align='absmiddle' >&nbsp;打印</button>
	<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
	       onClick="go_Back()">
	       <img src="${pageContext.request.contextPath}/ui/images/button/fanhui.png" border='0' 
	       align='absmiddle'>&nbsp;返回</button>
</div>

<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow1" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle1" style="font-weight:bold">基本信息</div>
	</th>
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
				<td class="red">用户名：</td>
				<td><s:textfield  name="name"  id="name"  cssClass="disabled" cssStyle="width:90%"  readonly="true"/></td>
				<td class="red">中文名：</td>
				<td>
				   <s:textfield  name="cnName"  id="cnName"  cssClass="input" cssStyle="width:90%"/>
				</td>
			</tr>
			<tr>
				<td class="red">密码：</td>
				<td><s:password name="password" showPassword="true" id="password" cssClass="disabled" 
				cssStyle="width:90%"  readonly="true"/></td>
				<td>推荐人：</td>
				<td><s:textfield  name="commendPeople"  cssClass="input" id="commendPeople" cssStyle="width:90%"/></td>
			</tr>
<tr>
				<td>移动电话：</td>
				<td><s:textfield  name="moveTelephone"  cssClass="input" id="moveTelephone" cssStyle="width:90%"/></td>
				<td>电子邮件：</td>
				<td><s:textfield  name="email"  cssClass="input" id="email" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>家庭地址：</td>
				<td><s:textfield  name="address"  cssClass="input" id="address" cssStyle="width:90%"/></td>
				<td>家庭电话：</td>
				<td><s:textfield  name="telephone"  cssClass="input" id="telephone" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>现住宅地址：</td>
				<td><s:textfield  name="nowAddress"  cssClass="input" id="nowAddress" cssStyle="width:90%"/></td>
				<td>现住宅电话：</td>
				<td><s:textfield  name="nowTelephone"  cssClass="input" id="nowTelephone" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>身份证号码：</td>
				<td><s:textfield  name="identityCode"  cssClass="input" id="identityCode" cssStyle="width:90%"/></td>
				<td>社会保险号：</td>
				<td><s:textfield  name="insuranceCode"  cssClass="input" id="insuranceCode" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>紧急联系人：</td>
				<td><s:textfield  name="instancePeople"  cssClass="input" id="instancePeople" cssStyle="width:90%"/></td>
				<td>紧急联系电话：</td>
				<td><s:textfield  name="instanceTelephone"  cssClass="input" id="instanceTelephone" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>起始有效期：</td>
				<td><s:textfield  name="beginDate"  cssClass="dateClassStyle" id="beginDate" cssStyle="width:90%"/></td>
				<td>终止有效期：</td>
				<td><s:textfield  name="endDate"  cssClass="dateClassStyle" id="endDate" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td class="red">操作权限组：</td>
				<td>
					<!-- 处理权限组下拉列表框 -->
					<s:if test="%{#request.sysRoles != null}">
						<s:select list="%{#request.sysRoles}"
							name="roleId" id="roleId"
							listKey="id" listValue="name">
						
						</s:select>
					</s:if>
               </td>
					<td class="red">所属部门：</td>
				<td>
				 	<!-- 处理部门下拉列表框 -->
				 	<s:if test="%{#request.sysUserGroups != null}">
				 		<s:select list="%{#request.sysUserGroups}"
				 		name="groupId" id="groupIds"
				 		listKey="id" listValue="name">
				 		
				 		</s:select>
				 	</s:if>
                </td>
			</tr>
			<tr>
				<td class="red">状态：</td>
				<td>
				<s:radio list="#{'Y':'启用','N':'停用'}"  name="status" id="status"  
				         listKey="key" listValue="value" value="%{'Y'}"/>
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow2" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle2" style="font-weight:bold">详细信息</div>
	</th>
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
				<td>性别：</td>
				<td>
				<s:radio list="{'男','女'}"  name="sex" id="sex" cssClass="radio"  value="%{'男'}"/></td>
				<td>出生日期：</td>
				<td><s:textfield  name="birthday"  cssClass="dateClassStyle" id="birthday" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>职员类别：</td>
				<td><s:radio list="{'全职','兼职'}"  name="personnelType" id="personnelType" cssClass="radio"  value="%{'全职'}"/></td>
				<td>职务：</td>
				<td><s:textfield  name="work"  cssClass="input" id="work" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><s:textfield  name="workTime"  cssClass="dateClassStyle" id="workTime" cssStyle="width:90%"/></td>
				<td>最高学历：</td>
				<td><s:textfield  name="highSchool"  cssClass="input" id="highSchool" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>毕业学校：</td>
				<td><s:textfield  name="finishSchool"  cssClass="input" id="finishSchool" cssStyle="width:90%"/></td>
				<td>毕业时间：</td>
				<td><s:textfield  name="finishSchoolTime"  cssClass="dateClassStyle" id="finishSchoolTime" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶姓名：</td>
				<td><s:textfield  name="conSoleName"  cssClass="input" id="conSoleName" cssStyle="width:90%"/></td>
				<td>子女姓名：</td>
				<td><s:textfield  name="youngerName"  cssClass="input" id="youngerName" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>办公电话：</td>
				<td><s:textfield  name="officeTelephone"  cssClass="input" id="officeTelephone" cssStyle="width:90%"/></td>
				<td>配偶电话：</td>
				<td><s:textfield  name="consoleTelephone"  cssClass="input" id="consoleTelephone" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>业余爱好：</td>
				<td colspan="3"><s:textfield  name="avocation"  cssClass="input" id="avocation" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>配偶工作单位：</td>
				<td colspan="3"><s:textfield  name="consoleCompany"  cssClass="input" id="consoleCompany" cssStyle="width:90%"/></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td colspan="3"><s:textarea name="remark" id="remark" rows="3" cssStyle="width:96%" /></td>
		    </tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow3" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle3" style="font-weight:bold">职业技能</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu3">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>			
			<tr>
				<td>偏好特长：</td>
				<td><s:textarea name="strongSuit" id="strongSuit" rows="3" cssStyle="width:90%" /></td>
				<td>信息沟通：</td>
				<td><s:textarea name="commuNicate" id="commuNicate" rows="3" cssStyle="width:90%" /></td>
			</tr>
			<tr>
				<td>培训情况：</td>
				<td><s:textarea name="bringUp" id="bringUp" rows="3" cssStyle="width:90%" /></td>
				<td>组织能力：</td>
				<td><s:textarea name="organiZation" id="organiZation" rows="3" cssStyle="width:90%" /></td>
			</tr>
			<tr>
				<td>分析能力：</td>
				<td><s:textarea name="analise" id="analise" rows="3" cssStyle="width:90%" /></td>
				<td>计划能力：</td>
				<td><s:textarea name="planning" id="planning" rows="3" cssStyle="width:90%" /></td>
			</tr>
			<tr>
				<td>人员开发：</td>
				<td><s:textarea name="emploder" id="emploder" rows="3" cssStyle="width:90%" /></td>
				<td>人际关系：</td>
				<td><s:textarea name="relation" id="relation" rows="3" cssStyle="width:90%" /></td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" class="tabForm">
  <tr>
    <th colspan="4" align="left" class="th_head">
		<div id="menuArrow4" style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center;float:left;">&nbsp;</div>
		<div id="menuTitle4" style="font-weight:bold">系统信息</div>
	</th>
  </tr>
  <tr>
  	<td>
		<div id="menu4">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="16%"></td>
				<td width="34%"></td>
				<td width="16%"></td>
				<td width="34%"></td>
			</tr>
				<tr>
				<td>创建人：</td>
				<td><s:textfield  name="creator"  cssClass="disabled" id="creator"  readonly="true"/></td>
				<td>创建时间：</td>
				<td><s:textfield  name="createTime"  cssClass="disabled" id="createTime" readonly="true"/></td>
			</tr>
			<tr>
				<td>修改人：</td>
				<td>
				  <s:hidden name="updaterStr"  />
				  <s:textfield  name="updater"  cssClass="disabled" id="updater" readonly="true"/>
				</td>
				<td>修改时间：</td>
				<td>
				  <s:hidden name="updateTimeStr"  />
				  <s:textfield  name="updateTime"  cssClass="disabled" id="updateTime" readonly="true"/>
				</td>
			</tr>
  		</table>
		</div>
	</td>
  </tr>
</table>
<br>
</s:form>
<script src="${pageContext.request.contextPath}/ui/js/menu.js" type="text/javascript"></script>
<div id="popshow" style='border:1px solid #6A82A8;width=650px;position: absolute; visibility: hidden; left: 0; top: 0; z-index: 10;'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr style='background-color:#6A82A8;'>
		<th width='80%' height="25" align='left' onMouseDown="initializedragie(popshow)" style="cursor:move" onselectstart="return false">
		<font color='#FFFFFF'>&nbsp;修改密码</font>
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

</body>
</html>