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
    
    <title>My JSP 'Jplayer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="Y_STW/dist/skin/pink.flag/css/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<link href="css/STW_play_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="Y_STW/lib/jquery.min.js"></script>
<script type="text/javascript" src="Y_STW/dist/jplayer/jquery.jplayer.js"></script>

<!--
	Note that the insertion of jQuery and jPlayer above is optional.
	The Popcorn jPlayer Player Plugin will load jQuery and jPlayer during instancing if not present in the page.
	Having jQuery and jPlayer present in the page avoids asynchronous player instancing.
-->

<script type="text/javascript" src="Y_STW/lib/popcorn.ie8.js"></script>
<script type="text/javascript" src="Y_STW/lib/popcorn.js"></script>
<script type="text/javascript" src="Y_STW/lib/popcorn.player.js"></script>
<script type="text/javascript" src="Y_STW/dist/popcorn/popcorn.jplayer.min.js"></script>
<script type="text/javascript" src="Y_STW/lib/popcorn.subtitle.js"></script>

<style type="text/css">
	.Yiframe{
		
		border-style:inset;
		margin:100px auto;
		width:640px;
		height:auto;
		}
</style>
<script type="text/javascript">
//<![CDATA[

$(document).ready(function(){
	alert("请将你的浏览器调为：『极速模式』");
	var moviePath=document.getElementById("moviePath").value;
	var movietitle=$("#Yplay_left dt").text();
	var movie_img=$("#Yplay_left img")[0].src;
	
	//alert("alert:moviePath="+moviePath+",movietitle="+movietitle);
	var p = Popcorn.jplayer('#jquery_jplayer_1', {
		media: {
			title: movietitle,
			m4v: moviePath,
			ogv: moviePath,
			webmv: moviePath,
			poster: movie_img
		},
		options: {
			swfPath: "../../dist/jplayer",
			supplied: "webmv, ogv, m4v",
			size: {
				width: "640px",
				height: "360px",
				cssClass: "jp-video-360p"
			},
			useStateClassSkin: true,
			autoBlur: false,
			smoothPlayBar: true,
			keyEnabled: true
		}
	})
	.subtitle({
		start: 2,
		end: 6,
		text: "这只是一个免费提供电影赏析的网站"
	})
	.subtitle({
		start: 6,
		end: 10,
		text: "所有本平台播放影视为网络来源"
	})
	.subtitle({
		start: 10,
		end: 15,
		text: "本平台提供优质的电影"
	})
	.subtitle({
		start: 16,
		end: 32,
		text: "Have fun playing with it!"
	});

});
//]]>
</script>
  </head>
  
  <body style="background-color: black;">
  <%
  	request.setCharacterEncoding("UTF-8");
  //String moviePath=request.getParameter("path");
  	//System.out.println("moviePath="+moviePath);
   %>
   <!--通过一个隐藏域给js传电影路径 -->
   <input id="moviePath" type="hidden" value="${movies.movie_src}" />
<!-- 左侧电影简介 -->
   <div id="Yplay_left" class="Yplay_left">
   		<dl>
   			<dt>${movies.titles}</dt>
   			<dd><img src="${movies.img_src}"/></dd>
   			<dd>${movies.movie_description}</dd>
   		</dl>
   </div>
<!-- END左侧电影简介 -->
<!-- 右侧返回 -->
   <div id="Yplay_right" class="Yplay_right">
   		<span><a href="Movie_Info">返回电<br/>影列表</a></span>
   </div>
<!-- END右侧返回 -->
<!-- 中间电影播放区 -->
    <div class="Yiframe" id="Yiframe">
<div id="jp_container_1" class="jp-video jp-video-360p" role="application" aria-label="media player">
	<div class="jp-type-single">
		<div id="jquery_jplayer_1" class="jp-jplayer"></div>
		<div class="jp-gui">
			<div class="jp-video-play">
				<button class="jp-video-play-icon" role="button" tabindex="0">play</button>
			</div>
			<div class="jp-interface">
				<div class="jp-progress">
					<div class="jp-seek-bar">
						<div class="jp-play-bar"></div>
					</div>
				</div>
				<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
				<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
				<div class="jp-details">
					<div class="jp-title" aria-label="title">&nbsp;</div>
				</div>
				<div class="jp-controls-holder">
					<div class="jp-volume-controls">
						<button class="jp-mute" role="button" tabindex="0">mute</button>
						<button class="jp-volume-max" role="button" tabindex="0">max volume</button>
						<div class="jp-volume-bar">
							<div class="jp-volume-bar-value"></div>
						</div>
					</div>
					<div class="jp-controls">
						<button class="jp-play" role="button" tabindex="0">play</button>
						<button class="jp-stop" role="button" tabindex="0">stop</button>
					</div>
					<div class="jp-toggles">
						<button class="jp-repeat" role="button" tabindex="0">repeat</button>
						<button class="jp-full-screen" role="button" tabindex="0">full screen</button>
					</div>
				</div>
			</div>
		</div>
		<div class="jp-no-solution">
			<span>Update Required</span>
			To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
		</div>
	</div>
</div>
</div>
<!-- END中间电影播放区 -->
  </body>
</html>
