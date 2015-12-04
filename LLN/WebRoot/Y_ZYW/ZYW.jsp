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
	<script type="text/javascript" src="js/jquery.1.11.1.min.js"></script>
	<link  rel="stylesheet" href="css/fontcss.css" />
	<link  rel="stylesheet" href="css/ZYW_css.css" />
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link  rel="stylesheet" href="css/menu.css" />
	<script type="text/javascript" src="Y_ZYW/script/ajaxRequest.js"></script>
	<script type="text/javascript" src="Y_ZYW/script/guestbook.js"></script>
	<style type="text/css">
		.Ymenu_font .BBS{
	color:#999999;}
	</style>
  </head>
  
 <body>
<!-- Save for Web Slices (未标题-1 - Slices: 01) -->
<div class="Ybody" id="Ybody" style="background-color: white">
<!--菜单栏-->
  <div class="Ymenu">
		<img id="Ymenu_bg_img" src="images/index_01.png" width="1345" height="71" alt="" />
        <div class="Ylogo">
			<img id="Ylogo_img" src="images/LOGO.png" width="74" height="71" alt="" />
		</div>
        <div class="Ymenu_font" id="Ymenu_font">
            <ul>
                <li><a href="index.jsp" >首页</a></li>
                <li><a href="Message_Info" >论坛</a></li>
                <li><a href="Movie_Info" >视听</a></li>
                <li><a href="Y_ZYW/ZYW.jsp" class="BBS">资源</a></li>
                <li><a href="Y_QJW/QJW.jsp" >全景</a></li>
            </ul>
        </div>
	</div>
<!--END菜单栏-->	
<!--内容-->
<div class="ZYW_center">
	<div class="ZYW_center_left">
		<div class="Xunlei">
			<div class="Xunlei_title">会员福利</div>
			
		
				<div id="Xunlei_body" class="Xunlei_body"></div>
		
		</div>
	</div>
	<div class="ZYW_center_center" id="ZYW_center_center">
		点击左栏，查看资源
	</div>

</div>	
<!--END内容-->	
 <!-- 管理资源 -->   
 	<div class="ZYW_manager"><a href="Y_ZYW/ZYW_add.jsp">管理资源</a></div>
  <!-- 管理资源 -->   
</div>
<!-- End Save for Web Slices -->
<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
</body>
</html>
