
/*jquery编辑区*/
$(function(){
	
		var checkNum=0;
		  //$regId = /^\d{12}$/;//验证数字
		  $regName=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;//验证名字
		  //$regPassword=/^[A-Za-z0-9]+$/;//验证密码(忽略大小写)
		if($.trim($("#BBS_s_content").html())=="<!-- 用jstl循环输出帖子-->"){
			alert("终于有人来评论了！");
		}
		
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
					return true;
				}
			});
			
			
//提交验证
			$("#BBS_input").click(function(){
				if(checkName){
					return true;
				}else{
					return false;
				}
				
					
				
				
			});	
		
});


	
