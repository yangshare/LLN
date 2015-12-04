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
	<script type="text/javascript" src="js/BBS_second_js.js"></script>
	<!-- QQ分享-->
	<script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/sousuo.css">
	<link rel="stylesheet" type="text/css" href="css/Shunde.css">
	<link  rel="stylesheet" href="css/fontcss.css" />
	<link  rel="stylesheet" href="css/BBS_css.css" />
	<link  rel="stylesheet" href="css/BBS_second_css.css" />
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
<form action="message_comment" method="post">
<!--内容区-->	
<div class="BBS_s_Ycontent"><!-- 渐变背景 -->
	<div class="BBS_s_center">
		<div class="BBS_s_title" id="BBS_s_title">
				<div id="BBS_img" class="BBS_img"><img src="http://bbs.shunderen.com/data/attachment/common/16/common_6_icon.jpg" align="left" alt=""></div>
				<div id="BBS_title" class="BBS_title">
					<dl>
						<dt>题目：<a id="BBS_title_titless" href="javascript:void(0);"><c:out value="${titless}"></c:out><input name="titless" type="hidden" value="${titless}"/></a></dt>
						<dd><em>作者: <span class="xi2" style="color:black;"><c:out value="${autherss}"></c:out><input name="autherss" type="hidden" value="${autherss}"/></span></em><em>时间: <span class="xi2" style="color:black;"><c:out value="${timess}"></c:out><input name="timess" type="hidden" value="${timess}"/></span></em></dd>
					</dl>
				</div>
				<div class="BBS_s_comment" id="BBS_s_comment" style="color:black;">
					<c:out value="${contentss}"></c:out>
				</div>
		</div>
<!--展示评论区 -->		
		<div class="BBS_s_content" id="BBS_s_content">
<!-- 用jstl循环输出帖子-->
		 <c:forEach var="mList" items="${list}">
			<div class="BBS_s_contentDiv" id="BBS_s_contentDiv">
				<div class="BBS_s_auther" id="BBS_s_auther">
					<ul>
						<li><span style="color:black;">评论人：</span><c:out value="${mList.username}"></c:out></li>
						<li><span style="color:black;">评论时间：</span><c:out value="${mList.times}"></c:out></li>
					</ul>
				</div>
				<div class="BBS_s_comment" id="BBS_s_comment">
					<c:out value="${mList.contents}"></c:out>
				</div>
				<div class="BBS_s_foot">
					<script type="text/javascript" src="js/QQ_share.js"></script>
				</div>
			</div>
		</c:forEach>
		</div>
<!--END展示评论区 -->	
		
<!-- 发评论区 -->

		
			<div id="BBS_fatie" class="BBS_fatie" style="float:none;width:845px;">
				<div style="background-color: #EDF5FF;">
					<span style="font-size: 1em;font-weight: bold;"><a href="javascript:void(0);" style="color:blue;">= 评论区 =</a></span>
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
							<input type="hidden" name="cursors" value="2"/>
							<input id="BBS_input" type="submit" value="发布" />
					</span>
				</div>
		
			</div>
	
		<!-- END发帖区 -->
	</div>

</div>
<!--END内容区-->	   
</form>
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

<!--返回论坛 -->
	<div id="BBS_s_gobackBBS" class="BBS_s_gobackBBS"><a href="Message_Info">返回<br/>论坛</a></div>
<!--END 返回论坛 -->

<!--END Ybody-->	
</div>

<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
</body>
</html>
