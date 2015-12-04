
/*jquery编辑区*/
$(function(){
	$(".QJW_center a").click(function(){
		$("#Ybody").hide();
		$(".ShowDiv embed").attr("src",$(this).parent().prev().attr("src")+"");
		$(".ShowDiv").show();
		
		//alert("获取内容："+$(this).parent().prev().attr("src"));
	});
	$(".ShowDiv a").click(function(){
		$("#Ybody").show();
		$(".ShowDiv").hide();
	});
});


	
