
/*jquery编辑区*/
$(function(){
	
		var checkNum=0;
		  //$regId = /^\d{12}$/;//验证数字
		  $regName=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;//验证名字
		  //$regPassword=/^[A-Za-z0-9]+$/;//验证密码(忽略大小写)
		 var i=0;var checkNum=0;
		 var flag=false;
/*初验发帖框*/
			
			//验证发帖内容
			$("#wordContent").blur(checkName=function(){
				if($("#wordContent").val()==""){
					alert("内容输入不能为空！");
					$("#wordContent").focus();
					
				}/*else if(!$regName.test($("#wordContent").val())){
					alert("请正确输入(只包含：中文、字母、数字)！例：例如：老杨、laoyang、lao123等");
					$("#wordContent").focus();
					
				}*/else{
					flag=true;
				}
			});
			//验证标题
			$("#BBS_fatie_title input").blur(checkPassword=function(){
				var arr=new Array();
				arr=$("#BBS_title a");
				
				
				if($("#BBS_fatie_title input").val()==""){
					alert("标题输入不能为空！");
					$("#BBS_fatie_title input").focus();
					
				}/*else if(!$regName.test($("#BBS_fatie_title input").val())){
					alert("请正确输入(只包含：中文、字母、数字)！例：例如：老杨、laoyang、lao123等");
					$("#BBS_fatie_title input").focus();
					
				}*/else{
					i=0;
					while(i<=arr.length){
						
						if($("#BBS_fatie_title input").val()==arr[i].innerHTML){
							alert("帖名已存在！");
							
							$("#BBS_fatie_title input").focus();
							
							break;
							
						}else if(i==arr.length){
							
							
							flag=true;
							
						}
						i++;
						
						
					} 
					
					
				}
			});
//提交验证
			$("#BBS_input").click(function(){
				flag=false;
				//alert(flag);
				var arr=new Array();
				arr=$("#BBS_title a");
				
				
				if($("#BBS_fatie_title input").val()==""){
					alert("标题输入不能为空！");
					$("#BBS_fatie_title input").focus();
					
				}/*else if(!$regName.test($("#BBS_fatie_title input").val())){
					alert("请正确输入(只包含：中文、字母、数字)！例：例如：老杨、laoyang、lao123等");
					$("#BBS_fatie_title input").focus();
					
				}*/else{
					i=0;
					while(i<=arr.length){
						
						if($("#BBS_fatie_title input").val()==arr[i].innerHTML){
							alert("帖名已存在！");
							
							$("#BBS_fatie_title input").focus();
							
							break;
							
						}else if(i==arr.length){
							
							
							if($("#wordContent").val()==""){
								alert("内容输入不能为空！");
								$("#wordContent").focus();
								
							}/*else if(!$regName.test($("#wordContent").val())){
								alert("请正确输入(只包含：中文、字母、数字)！例：例如：老杨、laoyang、lao123等");
								$("#wordContent").focus();
								
							}*/else if($("#chart a").html()==""){
								alert("请返回首页登陆后才能发帖");
								
							}else{
									
									flag=true;
							}
							
						}
						i++;
						flag=false;
						
					} 
					
					
				}
				
					
						
				
				return flag;
				
			});	
		
		
});


	
