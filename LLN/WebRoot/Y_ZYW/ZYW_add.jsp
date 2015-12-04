<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>帮帮网</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	
	
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body style="background-color:#FFFFFF;">
 <%
 	request.setCharacterEncoding("UTF-8");
  %>
  <center>
	<form action="Xunlei_Info" method="post">
		<table>
			<caption>插入资源</caption>
			<tr>
				<td>资源标题：</td><td><input name="titles" type="text"/></td>
			</tr>
			
			<tr>
				<td>资源内容：</td><td><textarea name="contents"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="提交"/><input name="actions_add" type="hidden" value="addXunlei"/></td><td><input type="reset" value="重置"/></td>
			</tr>
			
		</table>
		
	</form>
	</center>
</body>
</html>
