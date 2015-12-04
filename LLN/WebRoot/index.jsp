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
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="js/jquery.1.11.1.min.js"></script>
	<script type="text/javascript" src="js/Yregist_box.js"></script>
	<link  rel="stylesheet" href="css/fontcss.css" />
	<!--	
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Save for Web Styles (未标题-1 - Slices: 01) -->
	<link  rel="stylesheet" href="css/menu.css" />
<!-- End Save for Web Styles -->
<script type="text/javascript">
	/*jquery编辑区*/
	$(function(){//不登陆不跳转
			$("#Ymenu_font a").click(function(){
				if($("#LoginName").text()!="null"){
					if($(this).text()=="论坛"){
						
						$(this).attr('href',"Message_Info"); 
					}else if($(this).text()=="视听"){
						
						$(this).attr('href',"Movie_Info"); 
					}else if($(this).text()=="资源"){
						
						$(this).attr('href',"Y_ZYW/ZYW.jsp"); 
					}else if($(this).text()=="全景"){
						
						$(this).attr('href',"Y_QJW/QJW.jsp"); 
					}
				}else{
					alert("请登陆后访问！");
				}
			});
		});
</script>
	<style type="text/css">
		.Ymenu_font .BBS{
			
			color:#999999;
		}
	</style>
  </head>
  
 <body style="background-color:#FFFFFF;">
 <%
 	request.setCharacterEncoding("UTF-8");
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
                <li><a href="index.jsp" class="BBS">首页</a></li>
                <li><a  href="javascript:void(0);" >论坛</a></li>
                <li><a href="javascript:void(0);" >视听</a></li>
                <li><a href="javascript:void(0);" >资源</a></li>
                <li><a href="javascript:void(0);" >全景</a></li>
               
            </ul>
            <div class="Yregist">
            	<dl>
		         <dd><span>登陆</span></dd>
		         <dd><span>注册</span></dd>
	            </dl>
	        </div>
        </div>
	</div>
<!--END菜单栏-->	

<!--图片上文字-->
	<div class="Ycenter_font">
   		<p><span><strong>帮帮网✄</strong><br /><u>打造属于您的交流平台！</u></span></p>
    </div>
    <div class="Yregist_box" id="Yregist_box" style="display: none;">
    	<form action="User_Info" method="post">
    		<table>
    			<caption>ID-CARD</caption><button  id="Yregist_button" style="color:white;font-size: 20px;">×</button>
    			
    			<tr>
	    			<td>文理学号：</td>
	    			<td><input id="stuid" type="text" name="stuid" value="例如：201310930225" maxlength="12"/></td>
	    			<td><span style="color:red;">*</span></td>
    			</tr>
    			<tr>
	    			<td>昵&hearts;称：</td>
	    			<td><input id="stuname" type="text" name="stuname" value="例如：老杨、laoyang、lao123" maxlength="12"/></td>
	    			<td><span style="color:red;">*</span></td>
    			</tr>
    			<tr>
	    			<td>密&clubs;码：</td>
	    			<td><input id="stupassword" type="text" name="stupassword" value="例如：yang123456" maxlength="12"/></td>
	    			<td><span style="color:red;">*</span></td>
    			</tr>
    			<tr>
	    			<td><input id="Ysubmit" type="submit" value="提交" /></td>
	    			<td></td>
	    			<td><input type="reset" value="重置" /></td>
				</tr>
				<tr>
					<td></td>
	    			<td id="LoginStat"><%=session.getAttribute("messages") %></td>
	    			<td></td>
				</tr>
				<tr>
					<td></td>
	    			<td id="LoginName"><span  style="display:none"><%=session.getAttribute("username") %></span></td>
	    			<td></td>
				</tr>
    		</table>
    	</form>
    </div>
<!--END图片上文字-->
    
</div>
<!-- End Save for Web Slices -->
<!-- LOGO变色js -->
<script type="text/javascript" src="js/LOGO.js"></script>
<script type="text/javascript">
<!--			
/*纯js编辑区*/
	//根据刷新来变换背景图片
	var nums=Math.round(Math.random()*10);
	switch(nums){
		case 1:Ybody.style.backgroundImage="url(images/bg1.jpg)";break;
		case 2:Ybody.style.backgroundImage="url(images/bg2.jpg)";break;
		case 3:Ybody.style.backgroundImage="url(images/bg3.jpeg)";break;
		case 4:Ybody.style.backgroundImage="url(images/bg4.jpg)";break;
		case 5:Ybody.style.backgroundImage="url(images/bg5.jpg)";break;
		case 6:Ybody.style.backgroundImage="url(images/bg6.jpg)";break;
		default:Ybody.style.backgroundImage="url(images/bg3.jpeg)";break;
		}
	
-->
</script>
</body>
</html>
