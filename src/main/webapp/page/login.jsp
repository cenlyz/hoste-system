<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"> </script>
<script type="text/javascript">

     //检查帐号的格式onblur="checkCode();失去光标事件
	function checkCode(){
		var user=document.getElementById("user").value;
		//检查帐号的格式
		var reg=/^\d{11}$/;
		var span=document.getElementById("user_msg");
		if(reg.test(user)){
			span.className="ok";
			return true;
		}
		reg=reg=/^\d{6}$/;
		if(reg.test(user)){
			span.className="ok";
			return true;
		}else{
			span.className="error";
			return false;
		}
		
	}
	function checkPwd(){
		var pw=document.getElementById("pw").value;
		var pw_span=document.getElementById("pw_msg")
		var pw_reg=/^\w{8,16}$/;
		if(pw_reg.test(pw)){
			pw_span.className="ok";
			return true;
		}else{
			pw_span.className="error";
			return false;
		}
	}
	function submit1(){
		return true;
	}
	function find_pw(){
		var user=document.getElementById("user").value;
		window.location.href="findpw.do";
	}
</script>
<style type="text/css">
	.ok{
		display: inline-block;
		width: 14px;
		height: 14px;
		margin-right: 8px;
		vertical-align: middle;
		background: url(img/ok.png) 0  no-repeat;
		font-style: normal;
	}
	.error{
	    display: inline-block;
		width: 14px;
		height: 14px;
		margin-right: 8px;
		vertical-align: middle;
		background: url(img/delete.png) 0  no-repeat;
		font-style: normal;
	}
	table{
		padding:100px 10px;
		padding-top:20px;
	    width:396px;
		margin: 0 auto;
		margin-top:100px;
		margin-right:100px;
		background-color: rgba(0, 0, 0, 0.6);
		font-style: normal;
	}
	input{
		width: 280px;
		height: 30px;
	}
	span{
		width: 30px;
	}
	.denglu{
		display: block;
		height: 40px;
		line-height: 40px;
		text-align: center;
		border-radius: 3px;
		font-size: 16px;
		background-color: #31b0d5;
		color: #fff;
		text-decoration: none;
		cursor: pointer;
	}
	body{
		background-image:url("img/denglu.jpg");
		color: #eee;
	}
	a{
		color: red;
		text-decoration: none;
		cursor: pointer;
	}
	a:hover{
		text-decoration: underline;
	}
	img{
		cursor: pointer;
	}
</style>
</head>

<body>

	<form name="ff"  action="login.do" method="post" onsubmit="return checkCode()+checkPwd()+submit1()==3;">
		<table  >
			<tr>
				<td align="center" colspan="3" style="height: 50px;">酒店前台登录</td>
			</tr>
			<tr>
				<td style="height: 15px;"></td>
				<td style="font-size: 14px; color: red;" align="right"><a href="page/login/login.html">>>后台登陆</a></td>
				<td></td>
			</tr>
			<tr>
				<td style="width: 50px;">帐号&nbsp;:</td>
				<td style="width: 280px;" ><input id=user  type="text" name="id" placeholder="请输入帐号(6为员工号或者电话号码)"  onblur="checkCode();" 
				value="<%=request.getParameter("id")==null?"":request.getParameter("id") %>"/>
				</td>
				<td style="width: 26px;"><span  id="user_msg" > </span></td>
			</tr>
			<tr>
				<td style="height: 15px;"></td>
				<td align="right" style="color: red;">
				${state}
				</td>
				<td></td>
			</tr>
			<tr>
				<td>密码&nbsp;:</td>
				<td><input type="password" name="pwd" placeholder="请输入密码(8-16位字母、数字、下划线的组合)"  id=pw  onblur="checkPwd();" />
					
				</td>
				<td><span  id="pw_msg"></span></td>
			</tr>
			<tr>
				<td style="height: 25px;"></td>
				<td align="right" style="font-size: 12px;">
				<a onclick="find_pw();">忘记密码</a>
				</td>
				<td></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td></td> -->
<!-- 				<td colspan="2"> -->
				
<!-- 				<img src="checkcode.do" border="1" onclick="this.src='checkcode.do?'+Math.random()"/> -->
<!-- 				<input type="text" style="width: 80px; height: 20px;" name="number">  -->
<%-- 				${yan} --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td></td>
				<td><input type="submit" value="登录"  class="denglu"></td>
			</tr>
		</table>
	</form>
</body>
</html>