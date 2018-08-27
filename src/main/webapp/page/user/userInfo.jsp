<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人资料--酒店后台管理模板</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/user.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form">
		<div class="user_left">
			<div class="layui-form-item">
			    <label class="layui-form-label">用户名</label>
			    <div class="layui-input-block">
			    	<input type="text" value=${admin.username } disabled class="layui-input layui-disabled username">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">用户组</label>
			    <div class="layui-input-block">
			    	<input type="text" value=${admin.group } disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">真实姓名</label>
			    <div class="layui-input-block">
			    	<input type="text" value=${admin.name } placeholder="请输入真实姓名" lay-verify="required" class="layui-input realName">
			    </div>
			</div>
			<div class="layui-form-item" pane="">
			    <label class="layui-form-label">性别</label>
			    <div class="layui-input-block userSex">
			    	<c:if test="${admin.sex=='男' }">
			    	
			    	</c:if>
			    	<input type="radio" name="sex" value="男" title="男" <c:if test="${admin.sex=='男' }">checked=""</c:if>>
	     			<input type="radio" name="sex" value="女" title="女" <c:if test="${admin.sex=='女' }">checked=""</c:if>>
	     			<input type="radio" name="sex" value="保密" title="保密" <c:if test="${admin.sex=='保密' }">checked=""</c:if>>
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">手机号码</label>
			    <div class="layui-input-block">
			    	<input type="tel" value=${admin.phone } placeholder="请输入手机号码" lay-verify="required|phone" class="layui-input userPhone">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">出生年月</label>
			    <div class="layui-input-block">
			    	<input type="text" value=<fmt:formatDate type="date" value="${admin.year}" dateStyle="default"	/> placeholder="请输入出生年月" lay-verify="required|date" onclick="layui.laydate({elem: this,max: laydate.now()})" class="layui-input userBirthday">
			    </div>
			</div>
			<div class="layui-form-item userAddress">
			    <label class="layui-form-label">家庭住址</label>
			    <div class="layui-input-inline">
	                <select name="province" lay-filter="province" id="province">
	                    <option value="">请选择省</option>
	                </select>
	            </div>
	            <div class="layui-input-inline">
	                <select name="city" lay-filter="city" disabled id="city">
	                    <option value="">请选择市</option>
	                </select>
	            </div>
	            <div class="layui-input-inline">
	                <select name="area" lay-filter="area" disabled id="area">
	                    <option value="">请选择县/区</option>
	                </select>
	            </div>
			</div>

			<div class="layui-form-item">
			    <label class="layui-form-label">邮箱</label>
			    <div class="layui-input-block">
			    	<input type="text" value=${admin.email } placeholder="请输入邮箱" lay-verify="required|email" class="layui-input userEmail">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">自我评价</label>
			    <div class="layui-input-block">
			    	<textarea placeholder="请输入内容" class="layui-textarea myself">
			    	${admin.appraiser }
			    	</textarea>
			    </div>
			</div>
		</div>
		<div class="user_right">
			<input type="file" name="userFace" class="layui-upload-file" lay-title="掐指一算，我要换一个头像了">
			<p></p>
			<img src="" class="layui-circle" id="userFace">
		</div>
		<div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="address.js"></script>
	<script type="text/javascript" src="user.js"></script>
</body>
</html>