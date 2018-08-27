<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>找回密码</title>
</head>
<link rel="stylesheet" href="css/find.css">
<link rel="stylesheet" href="layui/css/layui.css" media="all" />
<script  src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function user1(){
		var str=$("#r_email").val();//获取输入的值
		//判断输入的值是否符合条件
			var reg=/^[0-9a-zA-Z]{6}$/;
			//设置<P>style样式为dispaly:block
			$("#r_email").prev().prev().eq(0).attr("style","display: block;");
			console.log(str);
			if((/^1[34578]\d{9}$/.test(str))){
				$("#r_email").prev().prev().find("i").html("");
				$("#r_email").prev().prev().find("span").attr("class","suc");
				return true;
		}
		$("#r_email").prev().prev().find("i").html("输入的员工号/号码有误");
		$("#r_email").prev().prev().find("span").attr("class","err");
		return false;
	}
	function id6(){
		var str=$("#mail_code").val();//获取输入的值
		var d=parseInt(str.substring(0,2));//截取前两位判断不能大于31
		$("#mail_code").prev().prev().eq(0).attr("style","display: block;");
		var reg=/^[0-9a-zA-Z]{5}$/;
		if(reg.test(str)){
			$("#mail_code").prev().prev().find("i").html("");
			var p=$("#mail_code").prev().prev().find("span").attr("class","suc");
			return true;
		}
		$("#mail_code").prev().prev().find("i").html("输入验证码格式有误");
		$("#mail_code").prev().prev().find("span").attr("class","err");
		return false;
	}
	function pw1(){
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
	function pw2(){
		var rstr=$("#rnew_pwd").val();//获取输入的值
		var str=$("#new_pwd").val();//获取输入的值
		$("#rnew_pwd").prev().prev().eq(0).attr("style","display: block;");
		if(rstr==str){
			$("#rnew_pwd").prev().prev().find("i").html("");
			$("#rnew_pwd").prev().prev().find("span").attr("class","suc");
			return true;
		}
		$("#rnew_pwd").prev().prev().find("i").html("输入两次密码不一致");
	    $("#rnew_pwd").prev().prev().find("span").attr("class","err");
	    return false;
	}
	function submit1(){
		var f=document.getElementById("from1");
		if(pw2()+pw1()+id6()+user1()==4)
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
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	int pand=3;
	if(request.getParameter("pand")!=null){
		pand=Integer.parseInt(request.getParameter("pand"));
	}
%>
<div class="Container">
	<div class="Heard">
		<img src="imgs/hot.png" /> 
	</div>
	<div class=find_pw>
		<a href="page/find_pw.do?name="> 找回密码</a>
	</div>
	<div class=login>
		<a href="login.html">登&nbsp;&nbsp;陆</a>
	</div>
</div>
<div><input id=pand1 type="hidden" value="<%=pand%>"></div>
<form name="from" id=from1 action="find_pw.do" method="post"  >
	<div class="concent">
		<h1>找回密码</h1>
		<ul class="sendpwd">
		
			<li>
				<p class="error" >
					<span class="suc"></span>
					<i></i>
				</p>
				<p>用户账号</p>
				<input id="r_email" name="id" type="text"	placeholder="请输入员工号/手机号" value="${id}" class="mailbg" onblur="user1(); " >
			</li>
			<li>
				  <button class="layui-btn layui-btn-xs layui-btn-normal" lay-submit="" lay-filter="yan">获取验证码</button>
				  <img src="checkcode.do" border="1" onclick="this.src='checkcode.do?'+Math.random()"/>
			</li>
			<li>
				<p class="error" >
					<span class="suc"></span>
					<i></i>
				</p>
				<p>验证码</p> 
				<input id="mail_code" name="number_id" type="text" value="" placeholder="请输入验证码" class="ryzmbg" onblur="id6();"/>
			</li>
			<li>
				<p class="error" >
					<span class="suc"></span><i></i>
				</p>
				<p>设置密码</p> 
				<input id="new_pwd" type="password" name="pw"  placeholder="请输入密码" value=""
				class="pwdbg" onblur="pw1();">
			</li>
			<li>
				<p class="error" >
					<span class="suc"></span><i></i>
				</p>
				<p>确认密码</p> <input id="rnew_pwd" type="password" value=""
				placeholder="请再次输入密码" class="pwdbg"  onblur="pw2();">
			</li>
			<li><a id="findpassword" href="#" onclick="return submit1();">确认重置密码</a></li>
		</ul>

		<ul class="returnsucc" style="display: none;">
			<li><p class="repwds">密码重置成功 !</p></li>
			<li><a class="relogin">返回登录页</a></li>
		</ul>
	</div>
</form>
<script type="text/javascript" src="layui/layui.js"></script>
</body>
</html>