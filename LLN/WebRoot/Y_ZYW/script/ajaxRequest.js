/*
 * 函数名：getTransport
 * 功能：根据不同的浏览器采用不同的方法自动创建XMLHttpRequest对象并返回，如果浏览器不支持XMLHttpRequest，则返回undefined
 */
function getTransport()
{
	var versions = [
		function()
		{ // Firefox, Opera 8.0+, Safari
			
			return new XMLHttpRequest();
			
		},
		function()
		{ // Internet Explorer
			
			return	new ActiveXObject('Msxml2.XMLHTTP');
		

		},
		function()
		{
		
			return	new ActiveXObject('Microsoft.XMLHTTP');
		}
	];
	var request;
	for(var i = 0; i < versions.length; i ++)
	{
		var lambda = versions[i];
		try
		{
			request = lambda();
			break;
		}
		catch(e){}
	}
	return request;
}

/*
 * 函数名：ajaxRequest
 * 功能：根据用户指定的URL，方法，参数，HTTP头，以及回调函数，自动创建XMLHttpRequest对象并发送请求。
 * 参数介绍：
 * 			url：请求的URL地址，字符串型
 *			options：参数集合，对象类型，其成员均为可选，成员为：
 *							method:发送请求的方法，可以为GET或POST，字符串型
 *							parameters:需要发送的数据，字符串型，其形式为："a=1&b=2&c=3"
 *							headers:需要发送的HTTP头信息。对象类型。其每一个属性为一个头信息。属性名为头信息的名称，属性值为头信息的内容。
 *							onLoading:在请求开始时执行的函数
 *							onComplete:在请求完成时执行的函数
 *							onSuccess:在请求成功时执行的函数
 *							onFailure:在请求失败时指定的函数
 */
function ajaxRequest(url,options)
{
	var request = getTransport();										//创建XMLHttpRequest对象
	if(typeof request == 'undefined')									//如果request为undefined，则抛出异常，说明当前浏览器不支持XMLHttpRequest,并退出函数
	{
		throw new Error('Your browser does not support XMLHttpRequest');
		return;
	}
	var url = url;
	var method = (options.method || 'POST').toUpperCase();				//获取提交方式，默认为POST
	if(method != 'GET' && method != 'POST')							
	{
		method = 'POST';
	}
	var parameters = options.parameters || null;						//需要提交的参数，默认为null
	//alert("ajaxRequest的parameters="+parameters);
	var headers = options.headers || {};								//需要发送的HTTP头信息，是一个对象，其成员包含了头信息的名称和值的信息
	var onLoadingEventHandler = options.onLoading || function(){};		//在请求开始时执行的函数，由用户指定，默认为一个空函数
	var onCompleteEventHandler = options.onComplete || function(){};	//在请求完成时执行的函数，由用户指定，默认为一个空函数
	var onSuccessEventHandler = options.onSuccess || function(){};		//在请求成功时执行的函数，由用户指定，默认为一个空函数
	var onFailureEventHandler = options.onFailure || function(){};		//在请求失败时执行的函数，由用户指定，默认为一个空函数
	if(method == 'GET' && parameters != null)							//如果提交方式被指定为GET，则将parameters的内容拼接到URL中，并将parameters的设置为null
	{
		if(url.indexOf('?') > -1)
		{
			url += '&' + parameters;
		}
		else
		{
			url += '?' + parameters;
		}
		parameters = null;
	}
	//alert("url为："+url);
	request.open(method,url,true);										//初始化XMLHttpRequest对象
	request.setRequestHeader('contentType','application/x-www-form-urlencoded');
	for(var name in headers)											//设置由用户指定的HTTP头信息
	{
		request.setRequestHeader(name,headers[name]);	
	}
	request.onreadystatechange = function()								//注册XMLHttpRequest对象的readystatechange事件处理函数
	{
		if(request.readyState == 1)										//当readyState等于1时，表示请求开始，将当前XMLHttpRequest对象作为其参数调用onLoadingEventHandler函数。
		{
			onLoadingEventHandler(request);
		}
		if(request.readyState == 4)										//当readyState等于4时，表示请求完成，将当前XMLHttpRequest对象作为其参数调用onCompleteEventHandler函数。
		{
			onCompleteEventHandler(request);
			//alert("request.status="+request.status);
			if(request.status && request.status >= 200 && request.status < 300)
			{
				onSuccessEventHandler(request);							//当HTTP状态码大于等于200小于300时，表示请求成功，这时将当前XMLHttpRequest对象作为其参数调用onSuccessEventHandler函数。
			}
			else
			{
				onFailureEventHandler(request);							//否则表示请求失败，这时将当前XMLHttpRequest对象作为其参数调用onFailureEventHandler函数。
			}
		}
	}
	request.send(parameters);											//发送请求
}