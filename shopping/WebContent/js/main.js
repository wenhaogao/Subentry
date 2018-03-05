$(function(){
	$("#loginForm").submit(function(){
		var bool=true;
		var userName=$("input[name='userName']").val();
		var userPwd=$("input[name='userPwd']").val();
		if(userName.length<=0){
			bool=false;
			$("#userNameInfo").html("<font color='red'>账号不能为空</font>");
		}
		
		if(userPwd.length<=0){
			bool=false;
			$("#userPwdInfo").html("<font color='red'>密码不能为空</font>");
		}
		return bool;
	});
	
	$("#next").click(function(){
		location.href="loadAll.jsp";
	});
	
	$("#select").click(function(){
		location.href="shopping.jsp";
	});
	
	$(":checkbox[name='allshopping']").change(function(){
		var bool=this.checked;
		$(":checkbox[name='ids']").each(function(){
			this.checked=bool;
		});
	});
	
	$("#shoppingForm").submit(function(){
		var bool=false;
		$(":checkbox[name='ids']").each(function(){
			if(this.checked){
				bool=true;
			}
		});
		if(!bool){
			alert("请选择需要删除的项");
		}
		return bool;
	});
	
	$("#submitOrder").click(function(){
		location.href="submitOrderHandler.jsp";
	});
});