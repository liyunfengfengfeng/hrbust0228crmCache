<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://crm.hrbust.tag.checkMenu/" prefix="hrbust" %>
<html>
<head>
 <title>菜单</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/menu/css/jquery.treeview.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/menu/css/screen.css" />
 <script src="${pageContext.request.contextPath}/menu/js/jquery-1.4.2.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/menu/js/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
	$( function() {
		$("#tree").treeview( {
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});
	})
</script>

</head>
<body  ondblclick="ToggleNav();">
<div id="main">
<div id="sidetree">
<div class="treeheader">操作菜单</div>
  
  	
	<div id="sidetreecontrol"><a href="?#">Collapse All</a> | <a href="?#">Expand All</a></div>
		<c:if test="${ ! empty requestScope.sysMenus }">
		
		<ul id="tree">
		<c:forEach items="${requestScope.sysMenus }" var="sysMenu">
		
			<!-- 处理父菜单 -->
			<c:if test="${sysMenu.id.menuModule==sysMenu.id.menuPrivilege }">
			<hrbust:checkMemu privilege="${sysMenu.id.menuPrivilege }" module="${sysMenu.id.menuModule }">
				    <li><img src="${pageContext.request.contextPath}/ui/images/menu/khgl.png" width="17" height="17">
				    <strong>${sysMenu.menuName }</strong>
			</hrbust:checkMemu>
			<!-- 处理子菜单 -->
					<ul>
							<c:forEach items="${requestScope.sysMenus }" var="sysMenuSub">
							
								<c:if test="${sysMenu.id.menuModule==sysMenuSub.id.menuModule 
								&& sysMenuSub.id.menuModule != sysMenuSub.id.menuPrivilege }">
								<hrbust:checkMemu privilege="${sysMenuSub.id.menuPrivilege }" module="${sysMenuSub.id.menuModule }">
						           <li><img src="${pageContext.request.contextPath}/ui/images${sysMenuSub.icon}" width="17" height="17">
						           <a href="${pageContext.request.contextPath}${sysMenuSub.url}" target="rightFrame">${sysMenuSub.menuName }</a></li>
						   		</hrbust:checkMemu>
						   		</c:if>
						   		
						    </c:forEach>       
								
					</ul>
				 </li>
				 
				 </c:if>  
			</c:forEach>	   
		</ul>
		
		</c:if>
	</div>
  	
</div>
<div id="divCollapsedNav" class="navTocColor" style="display:none;width:100%;height:100%;"> 
  <a href="javascript:ToggleNav();" title="展开导航框架" id="linkNavClosed">
      <img src="${pageContext.request.contextPath}/menu/images/toc2.gif" alt="展开导航框架" border="3"></img>
  </a> 
</div>
<script src="${pageContext.request.contextPath}/menu/js/left.js"></script>

</body>
</html>


