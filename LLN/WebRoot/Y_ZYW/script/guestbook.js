//var url = 'php/service.php';													//设置请求的地址
var url = 'Xunlei_Info';	
var flag=false;
/*
 * 留言本初始化程序
 */
function init()
{
	//document.getElementById('btnSubmit').onclick = submitMessage;				//注册按钮btnSubmit的click事件处理函数为submitMessage函数
	document.getElementById('ZYW_center_center').innerHTML='onLoading...';
	readMessages();																//读取所有历史留言信息
}
/*
 * 读取留言功能模块
 */
function readMessages()
{
	/*
	 * 设置Ajax请求的相关参数和回调函数
	 */
	var options = {
		method:'GET',
		parameters:'action=getall',
		onLoading:function()
		{
			document.getElementById('ZYW_center_center').innerHTML='onLoading...';			//请求过程中显示读取留言的进度提示
		},
		onSuccess:function(x)
		{
			var resBack = x.responseText;
			//alert("onSuccess:yresBack="+resBack);
			try
			{
				var messages = eval('(' + resBack + ')');						//将返回的JSON字符串转换成JavaScript对象
				
				for(var i = 0; i < messages.length; i ++)
				{
					displayMessage(messages[i]);
					
				}
															
			}
			catch(e){alert("遍历responseText异常："+e.message);}
		},
		onFailure:function()
		{
			document.getElementById('ZYW_center_center').innerHTML='加载失败...';
			alert('Request failure.');											//弹出对话框提示请求失败
		}
	}
	ajaxRequest(url,options);													//发送请求
}
/*
 * 显示留言功能模块
 * 函数displayMessage接受一个包含留言数据的对象作为参数，该对象有name、message、postdate属性分别对应留言信息的数据字段
 * 通过解析该对象的数据，创建一条表示留言记录的li元素添加到页面的留言列表中
 */
function displayMessage(data)//显示获取数据到网页
{
	var titles = data.titles;
	
	var date = data.contents;
	
	//alert("titles="+titles+",date="+date);
	
	//资源内容
	if(flag)
	{
		var ZYW_center_center=document.getElementById('ZYW_center_center');
		ZYW_center_center.innerHTML="";
		var div1 = document.createElement('div');	
		div1.innerHTML=titles;
		div1.setAttribute("style", "height:30px;background-color: #a1a1a1;border-bottom: solid #ddd 1px;")
		var div2 = document.createElement('div');	
		var p = document.createElement('p');		
		var dateText = 	document.createTextNode(date);	
		p.appendChild(dateText);											
		div2.appendChild(p);
		ZYW_center_center.appendChild(div1);
		ZYW_center_center.appendChild(div2);
	}else{
		document.getElementById('ZYW_center_center').innerHTML='onLoading...';
		//资源标题
		var Xunlei_body=document.getElementById("Xunlei_body");//获取标题div
		var a= document.createElement('a');	
		a.setAttribute("onclick", "submitMessage('"+titles+"')");
		a.setAttribute("href", "javascript:void(0);");
		var span = document.createElement('span');					
		var nameText = document.createTextNode(titles);				
		span.appendChild(nameText);	
		a.appendChild(span);
		Xunlei_body.appendChild(a);
	}
}
/*
 * 发送留言功能模块
 */
function submitMessage(titles)
{
	//alert("触发了submitMessage");
	flag=true;
//	alert("submitMessage:titles="+titles);
	/*
	 * 设置Ajax请求的相关参数和回调函数
	 */
	var options = {
		method:'GET',
		parameters:'action=lookClick&titles_js=' +titles,
		onLoading:function()
		{
			document.getElementById('ZYW_center_center').innerHTML = 'onLoading...';			//显示发送留言的进度提示
					
		},
		onSuccess:function(x)
		{
			var resBack = x.responseText;
			
			try
			{
				var messages = eval('(' + resBack + ')');						//将返回的JSON字符串转换成JavaScript对象
				
				for(var i = 0; i < messages.length; i ++)
				{
					displayMessage(messages[i]);
					
				}
															
			}
			catch(e){alert("遍历responseText异常："+e.message);}
			
		},
		onFailure:function()
		{	alert('onFailure：action=addnew&titles=' + titles);		
			document.getElementById('ZYW_center_center').innerHTML = '获取失败了，刷新页面试试...';
			alert('Request failure.');											//请求失败时弹出对话框提示请求失败
		}
	}
	ajaxRequest(url,options);													//发送请求
}

window.onload = init;															//页面加载完时初始化留言本程序