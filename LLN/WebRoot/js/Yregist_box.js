
/*jquery编辑区*/
$(function(){
	
		var checkNum=0;
		var flag_num=false;
		var flag_name=false;
		var flag_psw=false;
		  $regId = /^\d{12}$/;//验证数字
		  $regName=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;//验证名字
		  $regPassword=/^[A-Za-z0-9]+$/;//验证密码(忽略大小写)
		  $login=$("#Yregist_box #LoginStat").text();//登陆消息
		  //登陆判断
		  if($login=="登陆成功！"){
			  $(".Yregist").html("<p>"+$login+"</p>");
		  }else if($login==null||$login=="null"){
			 alert("帮帮网欢迎您！");
		  }else{
			  alert($login);
		  }
		/*隐藏注册框*/
			$("#Yregist_button").click(function(){
				$("#Yregist_box").hide();
				
			});
			/*点击注册和登陆打开注册框*/
			$(".Yregist dd").click(function(){
				$("#Yregist_box").show();
				
				
				
				if($login==null||$login=="null"){
					
					$("#Yregist_box #LoginStat").text("认真填写");
				}
			});
/*初验注册框*/
			//验证学号
			$(".Yregist_box #stuid").blur(function checkId(){
				if($(".Yregist_box #stuid").val()==""){
					alert("输入不能为空！");
					$(".Yregist_box #stuid").focus();
					
				}else if(!$regId.test($(".Yregist_box #stuid").val())){
					alert("请正确输入12位学号！例：201310930225");
					$(".Yregist_box #stuid").focus();
				
				}else{
					flag_num=true;
				}
			});
			//验证昵称
			$(".Yregist_box #stuname").blur(function checkName(){
				if(flag_num){
					
					if($(".Yregist_box #stuname").val()==""){
						alert("输入不能为空！");
						$(".Yregist_box #stuname").focus();
						
					}else if(!$regName.test($(".Yregist_box #stuname").val())){
						alert("请正确输入昵称(只包含：中文、字母、数字)！例：例如：老杨、laoyang、lao123等");
						$(".Yregist_box #stuname").focus();
						
					}else{
						flag_name=true;
					}
				}else{
					//alert("昵称flag_name="+flag_name);
					alert("先正确填写学号");
					//checkId();
					
				}
			});
			//验证密码
			$(".Yregist_box #stupassword").blur(function checkPassword(){
				if(flag_num){
					if(flag_name){
						if($(".Yregist_box #stupassword").val()==""){
							alert("输入不能为空！");
							$(".Yregist_box #stupassword").focus();
							
						}else if(!$regPassword.test($(".Yregist_box #stupassword").val())){
							alert("请正确输入密码(只包含：字母、数字)！例：例如：laoyang、lao123等");
							$(".Yregist_box #stupassword").focus();
							
						}else{
							
							flag_psw=true;
						}
					}else{
						alert("先正确填写昵称");
						//checkName();
					}
				}else{
					alert("先正确填写学号");
					//checkId();
					
				}
			});
//提交验证
			$(".Yregist_box #Ysubmit").click(function(){
					if(flag_num&&flag_name&&flag_psw){
						//alert("flag_num="+flag_num+"flag_name="+flag_name+"flag_psw="+flag_psw);
						return true;
					}else{
						//alert("flag_num="+flag_num+"flag_name="+flag_name+"flag_psw="+flag_psw);
						if(!flag_num){
							alert("先正确填写学号");
							return false;
						}else if(!flag_name){
							alert("先正确填写昵称");
							return false;
						}else if(!flag_psw){
							alert("正确填写密码");
							return false;
						}
						
					}
				
			});	
		
		
});


	
