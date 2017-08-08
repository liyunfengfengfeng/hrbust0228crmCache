<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>辅助信息-编辑</title>
<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/opform.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/global.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ui/js/win.js" type="text/javascript"></script>
<style> 
body {
	padding:5px;
}
</style>
</head>
<body>
 
      
		<form  method="post" action="${pageContext.request.contextPath}/batchDetailsAction.do?selectName=regionName">
		   <input type="hidden" name="step" value="updateForBatch">
		   <br/>
		
			<div class="control">
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/ui/images/button/baocun.png" border='0' align='absmiddle'>&nbsp;保存</button>
				<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  onClick="do_closed()"><img src="${pageContext.request.contextPath}/ui/images/button/guanbi.png" border='0' align='absmiddle'>&nbsp;关闭</button>
				<font color="red"></font>
			</div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="error">
				<tr>
					<th colspan="3">辅助信息-编辑</th>
				</tr>
				<tr>
					<td width="5%"></td>
					<td width="47%"></td>
					<td width="48%"></td>
				</tr>
			
				<tr>
					<td>1
						<input type="hidden" name="d_id" value="148">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="183">
						<input type="hidden" name="d_remark" value="">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="华南" style="width:100%"></td>
					
					  <td align="center">
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=upForEach&id=148&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shangyi.png" border='0' align='absmiddle'>&nbsp;上移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=downForEach&id=148&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/xiayi.png" border='0' align='absmiddle'>&nbsp;下移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=delete&id=148&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
					  </td>
					
				</tr>
			
				<tr>
					<td>2
						<input type="hidden" name="d_id" value="146">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="149">
						<input type="hidden" name="d_remark" value="">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="华中" style="width:100%"></td>
					
					  <td align="center">
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=upForEach&id=146&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shangyi.png" border='0' align='absmiddle'>&nbsp;上移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=downForEach&id=146&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/xiayi.png" border='0' align='absmiddle'>&nbsp;下移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=delete&id=146&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
					  </td>
					
				</tr>
			
				<tr>
					<td>3
						<input type="hidden" name="d_id" value="178">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="148">
						<input type="hidden" name="d_remark" value="cccccccccccccccc">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="东北" style="width:100%"></td>
					
					  <td align="center">
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=upForEach&id=178&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shangyi.png" border='0' align='absmiddle'>&nbsp;上移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=downForEach&id=178&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/xiayi.png" border='0' align='absmiddle'>&nbsp;下移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=delete&id=178&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
					  </td>
					
				</tr>
			
				<tr>
					<td>4
						<input type="hidden" name="d_id" value="149">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="147">
						<input type="hidden" name="d_remark" value="">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="华东" style="width:100%"></td>
					
					  <td align="center">
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=upForEach&id=149&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shangyi.png" border='0' align='absmiddle'>&nbsp;上移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=downForEach&id=149&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/xiayi.png" border='0' align='absmiddle'>&nbsp;下移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=delete&id=149&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
					  </td>
					
				</tr>
			
				<tr>
					<td>5
						<input type="hidden" name="d_id" value="147">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="146">
						<input type="hidden" name="d_remark" value="">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="华北" style="width:100%"></td>
					
					  <td align="center">
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=upForEach&id=147&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shangyi.png" border='0' align='absmiddle'>&nbsp;上移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=downForEach&id=147&pid=56&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/xiayi.png" border='0' align='absmiddle'>&nbsp;下移</button>
						<button type='button' class='button' onMouseOver="this.className='button_over';" onMouseOut="this.className='button';"  
						   onClick="forward('${pageContext.request.contextPath}/batchDetailsAction.do?step=delete&id=147&selectName=regionName')"><img src="${pageContext.request.contextPath}/ui/images/button/shanchu.png" border='0' align='absmiddle'>&nbsp;删除</button>
					  </td>
					
				</tr>
			
				<tr>
					<td>6
						<input type="hidden" name="d_id" value="">
						<input type="hidden" name="d_pid" value="56">
						<input type="hidden" name="d_sort" value="">
						<input type="hidden" name="d_remark" value="">
						<input type="hidden" name="d_sysFlag" value="N">
					</td>
					<td><input type="text" name="d_value" value="" style="width:100%"></td>
					
				</tr>
			
			</table>
			</form>
	
  

<script type="text/javascript">  
   window.onload=function(){ 
	 window.opener.parentAddOption("regionName",$("input[name=d_value]"));
   }


   function do_closed(){
	   self.close();
   }
   
</script>
</body>
</html>



