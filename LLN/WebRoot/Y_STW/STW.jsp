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
	<link href="css/STW_css.css" rel="stylesheet" type="text/css" />
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Save for Web Styles (未标题-1 - Slices: 01) -->
	<link  rel="stylesheet" href="css/menu.css" />
<!-- End Save for Web Styles -->
	<style type="text/css">
		.Ymenu_font .BBS{
	color:#999999;}
	</style>
  </head>
  
 <body style="background-color:#FFFFFF;">
 <%
 	request.setCharacterEncoding("UTF-8");
 	/*if(session.getAttribute("username")==null){
 		response.sendRedirect("../index.jsp");
 	}*/
  %>
<!-- Save for Web Slices (未标题-1 - Slices: 01) -->
<div class="Ybody" id="Ybody">
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
		                <li><a href="Y_STW/STW.jsp" class="BBS">视听</a></li>
		                <li><a href="Y_ZYW/ZYW.jsp" >资源</a></li>
		                <li><a href="Y_QJW/QJW.jsp" >全景</a></li>
		            </ul>
	            
        </div>
	</div>
<!--END菜单栏-->	
<!--内容-->	
<div class="Smenu">
	<!--左侧菜单栏-->
	<div class="Smenu_left" id="Smenu_left">
	 <dl>          
	 	<dt>电影类型：</dt>
	 	<dd>
			<ul>
				 <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info">全部</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=动作">动作</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=喜剧">喜剧</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=爱情">爱情</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=科幻">科幻</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=剧情">剧情</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=恐怖">恐怖</a></li>
		        <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=动漫">动漫</a></li>
		         <li><br/>&nbsp;&nbsp;&nbsp;<a href="Movie_Info?movie_types=音乐">音乐</a></li>
		    </ul>
	    </dd>
       </dl>
	</div>
	<!--中间栏-->
	
	<div class="Smenu_center" id="Smenu_center">
		<ul>
		<!-- 用jstl循环输出帖子-->
		 <c:forEach var="mList" items="${STW_list}">
	     	<li class="Ymenu_left_items">
		     	<a href="Movie_play_Info?titles=${mList.titles}">
			     	<u><img src="${mList.img_src}"></u>
			     	<br/>${mList.titles}
		     	</a>
	     	</li>
	     </c:forEach>
	     
	      
	     </ul> 
	</div>
</div>
<!--END内容-->	
    <div style="margin:auto auto 10px auto;float:right;"><a href="Y_STW/STW_add.jsp">后台添加</a></div>
</div>
<!--END_Body内容-->	
<!-- End Save for Web Slices -->
<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
</body>
</html>
