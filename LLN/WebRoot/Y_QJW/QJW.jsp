<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/QJW_js.js"></script>
	<link  rel="stylesheet" href="css/fontcss.css" />
	
	<!--图片播放器-->
	<link rel="stylesheet" href="Y_QJW/css/example.css">
    <link rel="stylesheet" href="Y_QJW/css/font-awesome.min.css">  
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link  rel="stylesheet" href="css/menu.css" />
	<link  rel="stylesheet" href="css/QJW_css.css" />
	<style type="text/css">
		.Ymenu_font .BBS{
	color:#999999;}
	</style>
  </head>
  
 <body>
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
                <li><a href="Movie_Info" >视听</a></li>
                <li><a href="Y_ZYW/ZYW.jsp" >资源</a></li>
                <li><a href="Y_QJW/QJW.jsp" class="BBS">全景</a></li>
            </ul>
        </div>
	</div>
<!--END菜单栏-->	
<!--内容-->	
<!-- 图片播放器 -->
	<div class="container_title">文理风采</div>
	<div class="container">
	
	    <div id="slides">
	      <img src="images/WenliSchool/IMG_0444.JPG" alt="Photo by BBW">
	      <img src="images/WenliSchool/IMG_2774.JPG" alt="Photo by BBW">
	      <img src="images/WenliSchool/IMG_0447.JPG" alt="Photo by BBW">
	      <img src="images/WenliSchool/IMG_0448.JPG" alt="Photo by BBW">
	      <img src="images/WenliSchool/IMG_0449.JPG" alt="Photo by BBW">
	      <img src="images/WenliSchool/IMG_2778.JPG" alt="Photo by BBW">
	      <a href="#" class="slidesjs-previous slidesjs-navigation"><i class="icon-chevron-left"></i></a>
	      <a href="#" class="slidesjs-next slidesjs-navigation"><i class="icon-chevron-right"></i></a>
	    </div>
	    
    </div>
<!-- END图片播放器 -->
<!-- 全景图区 -->
	<div class="QJW_center_title">全景风采</div>
	<div class="QJW_center">
		<div>
			<embed width="100%" height="100%" src="images/panoramic/gemingguangchang_out.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
					达州革命广场
				</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/hongjunting_out.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
				达州红军亭</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/yuanzheng_out.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
				达州元媜雕像</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/manyou_out.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">	
				漫游1</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/erjiaolou.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
				文理二教楼前</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/penquan.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
				莲湖校区</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/pingpangtai.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">	
				南坝校区</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/renmingongyuan.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">
				人民公园</a>
			</span>
		</div>
		<div>
			<embed width="100%" height="100%" src="images/panoramic/santumanyou.swf" type="application/x-shockwave-flash"></embed>
			<span>
				<img alt="放大" src="images/fangdajing.png" width="20px" height="15px" title="放大">
				<a href="javascript:void(0);">	
				漫游2</a>
			</span>
		</div>
	</div>

<!-- END全景图区 -->
<!--END内容-->	
<!-- foot -->    
	<div class="QJW_foot">©2015 声明：本网站全景图均由站长制作，所有解释权归站长</div>
<!-- END foot -->   

</div>
<!-- 展台 -->
	<div class="ShowDiv">
		<span><a href="javascript:void(0);" title="关闭">close</a></span>
		<embed width="100%" height="100%" src="images/panoramic/manyou_out.swf" type="application/x-shockwave-flash"></embed>
		
	</div>
<!--END 展台 -->
<!-- End Save for Web Slices -->
<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
<!-- 图片播放器js -->
  <script src="Y_QJW/js/jquery.slides.min.js"></script>
  <!-- SlidesJS Required: Initialize SlidesJS with a jQuery doc ready -->
  <script>
    $(function() {
      $('#slides').slidesjs({
        width: 800,
        height: 450,
        navigation: false
      });

     
    });
  </script>
  <!-- End SlidesJS Required -->
</body>
</html>
