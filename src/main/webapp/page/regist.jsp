<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>快速注册</title>
</head>
<link rel="stylesheet" href="css/find.css">
<script  src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function userid(){
		var str=$("#r_email").val();//获取输入的值
		//判断输入的值是否符合条件
			//设置<P>style样式为dispaly:block
			$("#r_email").prev().prev().eq(0).attr("style","display: block;");
			var reg=/^\d{11}$/;
			if((/^1[34578]\d{9}$/.test(str))){
			//	var url="check.do";
			//	$.getJSON(url,{"id":str},function(result){
			//		console.log(result);
			//		console.log("12312313131321");
			//	});
				//$('#span1').load("check.do",{"id":str});
				
				$("#r_email").prev().prev().find("i").html("");
				$("#r_email").prev().prev().find("span").attr("class","suc");
				return true;
		}
		$("#r_email").prev().prev().find("i").html("输入的手机号有误");
		$("#r_email").prev().prev().find("span").attr("class","err");
		return false;
	}
	function sfz1(){
		var str=$("#mail_code").val();//获取输入的值
		$("#mail_code").prev().prev().eq(0).attr("style","display: block;");
		var reg=/^\d{17}[0-9X]$/;
		if(str==""){
			$("#mail_code").prev().prev().find("i").html("请输入身份证号码");
			$("#mail_code").prev().prev().find("span").attr("class","err");
			return false;
		}
		if((/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test(str))){
			$("#mail_code").prev().prev().find("i").html("");
			var p=$("#mail_code").prev().prev().find("span").attr("class","suc");
			return true;
		}else{
			$("#mail_code").prev().prev().find("i").html("身份证号码格式不正确");
			$("#mail_code").prev().prev().find("span").attr("class","err");
			return false;
		}
		
	}
	function username(){
		var str=$("#name").val();//获取输入的值
		 $("#name").prev().prev().eq(0).attr("style","display: block;");
		if(str){
			$("#name").prev().prev().find("i").html("");
			$("#name").prev().prev().find("span").attr("class","suc");
			return true;
		}else{
		$("#name").prev().prev().find("i").html("输入姓名不能为空");
	    $("#name").prev().prev().find("span").attr("class","err");
	    return false;
		}
	}
	function pw(){
		var str=$("#new_pwd").val();//获取输入的值
		var pw_reg=/^\w{8,16}$/;
		 $("#new_pwd").prev().prev().eq(0).attr("style","display: block;");
		if(pw_reg.test(str)){
			$("#new_pwd").prev().prev().find("i").html("");
			$("#new_pwd").prev().prev().find("span").attr("class","suc");
			return true;
		}
		$("#new_pwd").prev().prev().find("i").html("输入密码格式有误");
	    $("#new_pwd").prev().prev().find("span").attr("class","err");
	    return false;
	}
	function submit1(){
		var f=document.getElementById("from1");
		if(pw()+username()+sfz1()+userid()==4)
		f.submit();
	}
	$(function(){
		var state='<%=request.getAttribute("state")%>';
		if(state!="null"){
			alert(state);
		}
	});
	
</script>
<body>
<div class="Container">
	<div class="Heard">
		<img src="imgs/hot.png" /> 
	</div>
	<div class=find_pw>
		<a href="find_pw.do?name="> 找回密码</a>
	</div>
	<div class=login>
		<a href="toLogin.do">登&nbsp;&nbsp;陆</a>
	</div>
</div>
<form name="from" id=from1 action="toRegist.do" method="post"  >
	<div class="concent">
		<h1>快速注册</h1>
		<ul class="sendpwd">
		
			<li>
				<p class="error" >
					<span class="suc" id="span1"></span>
					<i></i>
				</p>
				<p>用户账号</p>
				<input id="r_email" name="id" type="text"	placeholder="请输入11位有效电话号码" value="" class="mailbg" onblur="userid(); " >
			</li>
			<li>
				<p class="error" >
					<span class="suc"></span><i></i>
				</p>
				<p>用户姓名</p> 
				<input id="name" type="text" name="name"  placeholder="请输入真实姓名" value=""	class="pwdbg" onblur="username();">
			</li>
			<li>
				<p class="error" >
					<span class="suc"></span>
					<i></i>
				</p>
				<p>身份证号</p> 
				<input id="mail_code" name="sfz" type="text" value="" placeholder="请输入身份证号" class="ryzmbg" onblur="sfz1();"/>
			</li>
			
			<li>
				<p class="error" >
					<span class="suc"></span><i></i>
				</p>
				<p>设置密码</p> <input id="new_pwd" type="password" name="pwd"
				placeholder="请输入密码(8-16位字母、数字、下划线的组合)" class="pwdbg"  onblur="pw();">
			</li>
			<li><a id="findpassword" href="#" onclick="return submit1();">确认注册</a></li>
		</ul>

		
	</div>
</form>
</body>
</html>