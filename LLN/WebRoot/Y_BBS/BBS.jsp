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
	<!-- 检测输入字数js -->
	<script type="text/javascript" src="js/inputCheck.js"></script>
	<!-- 检测输入js -->
	<script type="text/javascript" src="js/BBS_js.js"></script>
	<link rel="stylesheet" type="text/css" href="css/sousuo.css">
	<link rel="stylesheet" type="text/css" href="css/Shunde.css">
	<link  rel="stylesheet" href="css/fontcss.css" />
	<link  rel="stylesheet" href="css/BBS_css.css" />
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Save for Web Styles (未标题-1 - Slices: 01) -->
	<link  rel="stylesheet" href="css/menu.css" />
<!-- End Save for Web Styles -->
	<script type="text/javascript">
		$(function(){
			$("#Ysou").click(function(){
				$(this).val("");//清空搜索框默认
				
			}).blur(function(){
			var $str=$.trim($(this).val());
				if($str==""){
					$(this).val("键入帖名，搜你的疑惑");
				}
			}
			
			);
		});
	</script>
	<style type="text/css">
		.Ymenu_font .BBS{
	color:#999999;}
	</style>
  </head>
  
 <body style="background-color:#FFFFFF;">
 <%
 	request.setCharacterEncoding("UTF-8");
 	if(session.getAttribute("username")==null){
 		response.sendRedirect("../index.jsp");
 	}
  %>
<!-- Save for Web Slices (未标题-1 - Slices: 01) -->
<div class="Ybody" id="Ybody" style="height:auto;">
<!--菜单栏-->
  <div class="Ymenu">
		<img id="Ymenu_bg_img" src="images/index_01.png" width="1345" height="71" alt="" />
        <div class="Ylogo">
			<img id="Ylogo_img" src="images/LOGO.png" width="74" height="71" alt="" />
		</div>
        <div class="Ymenu_font" id="Ymenu_font">
            <ul>
                 <li><a href="index.jsp" >首页</a></li>
                <li><a href="Message_Info" class="BBS">论坛</a></li>
                <li><a href="Movie_Info" >视听</a></li>
                <li><a href="Y_ZYW/ZYW.jsp" >资源</a></li>
                <li><a href="Y_QJW/QJW.jsp" >全景</a></li>
            </ul>
        </div>
	</div>
<!--END菜单栏-->	
<!--内容-->	
<div class="Ycontent">
	<!--搜索-->
<form action="Message_Info" method="post" class="Ysou_form">
    <div class="Ysou_div">
        <input id="Ysou" name="sousuo" class="Ysou_inp" value="键入帖名，搜你的问题" maxlength="255">
        <input type="submit"  value="试试手气" class="Ysou_btn">
    </div>
</form>
<!--帖子展板-->
<div id="ct" class="wp cl">
	<div id="chart" class="bm bw0 cl">
		<p class="chart z">帖子: <em><c:out value="${messageNum}"></c:out></em><span class="pipe">|</span>会员: <em><c:out value="${userNum}"></c:out></em><span class="pipe">|</span>欢迎您: <em><a href="javascript:void(0);" target="_blank" class="xi2" style="color:#FFCC00"><c:out value="${username}"></c:out></a></em></p>
		<div class="y"></div>
	</div>
<!--[diy=diy_chart]-->
<div id="diy_chart" class="area"></div><!--占位块-->
<div class="mn lgkc">
<div class="fl bm" style="width:900px">
<div class="bm bmw  flg cl">
<!-- 新帖区头 -->
	<div class="bm_h cl">							
		<h2><a href="javascript:void(0);">= 新帖 =</a></h2>
		<div  class="BBS_head_img"></div>
	</div>
<!-- END新帖区头 -->
<!-- 新帖区 -->
	<div id="category_262" class="bm_c" style="background-color:Gray;float:left;margin-left:5px;">

<!-- 用jstl循环输出帖子-->
		 <c:forEach var="mList" items="${BBS_list}">
			<div id="BBS_content" class="BBS_content">
				<div id="BBS_img" class="BBS_img"><img src="http://bbs.shunderen.com/data/attachment/common/16/common_6_icon.jpg" align="left" alt=""></div>
				<div id="BBS_title" class="BBS_title">
					<dl>
						<dt><a href="message_comment?titless=${mList.titles}&autherss=${mList.username}&timess=${mList.times}&cursors=1"><c:out value="${mList.titles}"></c:out></a></dt>
						<dd><em>作者: <span class="xi2"><c:out value="${mList.username}"></c:out></span></em>&nbsp;<em>时间: <span class="xi2" ><c:out value="${mList.times}"></c:out></span></em></dd>
					</dl>
				</div>
			</div>		   		
		</c:forEach>
		
		
		
	</div>
<!-- END新帖区 -->
	
</div>
</div>
</div>
<!-- 发帖区 -->

<form action="Message_Info" method="post">
	<div id="BBS_fatie" class="BBS_fatie">
		<div style="background-color: #EDF5FF;">
			<span style="font-size: 1em;font-weight: bold;"><a href="javascript:void(0);" style="color:blue;">= 发帖区 =</a></span>
		</div>
		<div id="BBS_fatie_title" class="BBS_fatie_title">
			<span>标题：<input name="BBS_Title" type="text" value="请使用11个汉字拟写标题" maxlength="11" width="50px"/>*</span>
		</div>
		<div id="BBS_fatie_content" class="BBS_fatie_content">
				<div>
					<font>
						写入：<input type="text" id="useNum" value="0" size="4" disabled style="text-align:center;border:0;"> 个&nbsp;&nbsp;
						剩余：<input type="text" id="remNum" value="1000" size="4" disabled style="text-align:center;border:0;"> 个 
					</font>
				</div>
			<span>
					<em>内容：</em>
					<textarea name="BBS_Content" id="wordContent" rows="4" cols="100" onkeydown="check(wordContent,useNum,remNum,1000)" onkeyup="check(wordContent,useNum,remNum,1000)"></textarea>
					<input id="BBS_input" type="submit" value="发布" />
			</span>
		</div>

	</div>
</form>
<!-- END发帖区 -->
</div>
<!--END内容-->	   
</div>
<!-- foot -->
<div id="BBS_foot" class="BBS_foot">
	
	 <span>
	 ©2015 Baidu联合BBW
	 <a  href="http://tieba.baidu.com/tb/eula.html" target="_blank">贴吧协议</a><span>|</span>
	 <a href="http://tieba.baidu.com/tb/system.html" target="_blank">吧主制度</a><span>|</span>
	 <a  href="http://tieba.baidu.com/tb/zt/declare/" target="_blank">网络谣言警示</a>
	</span>
</div>
<!--END foot -->


<!--END Ybody-->	
</div>

<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
</body>
</html>
