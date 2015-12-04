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
	<form action="Movie_Info" method="post">
		<table>
			<caption>插入电影信息</caption>
			<tr>
				<td>标题：</td><td><input name="titles" type="text"/></td>
			</tr>
			<tr>
				<td>图片路径：</td><td><input name="img_src" type="text"/></td>
			</tr>
			<tr>
				<td>电影路径：</td><td><input name="movie_src" type="text"/></td>
			</tr>
			<tr>
				<td>电影描述：</td><td><textarea name="movie_descrip"></textarea></td>
			</tr>
			<tr>
				<td>电影类型：</td>
				<td>
					<select name="movie_type">
						 <option value ="动作">动作</option>
						  <option value ="喜剧">喜剧</option>
						  <option value="爱情">爱情</option>
						  <option value="科幻">科幻</option>
						  <option value ="剧情">剧情</option>
						  <option value="恐怖">恐怖</option>
						  <option value="动漫">动漫</option>
						   <option value="音乐">音乐</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/><input name="actions" type="hidden" value="addMovie"/></td><td><input type="reset" value="重置"/></td>
			</tr>
			<tr><td><a href="Movie_Info">返回视听</a></td></tr>
		</table>
		
	</form>
	</center>
</body>
</html>
