<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>交班处理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="../../layui/css/layui.css"	media="all" />
<link rel="stylesheet"href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
<link rel="stylesheet" href="../../css/news.css" media="all" />
</head>

<body>
	<form class="layui-form" action="gethandover.do" method="post">
	<hr />交班人信息
		<div class="layui-form-item" style="margin-top: 10px;">
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">姓名</label>
				<div class="layui-input-inline">
					<input type="tel" name="name" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">电话</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px;">
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">工号</label>
				<div class="layui-input-inline">
					<input type="tel" name="staff_id" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<hr />金额
		<div class="layui-form-item" style="margin-top: 10px;">
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">当前金额</label>
				<div class="layui-input-inline">
					<input type="tel" name="dmoney" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">备用金</label>
				<div class="layui-input-inline">
					<input type="text" name="bmoney" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<hr />接班人信息
		<div class="layui-form-item" style="margin-top: 10px;">
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">姓名</label>
				<div class="layui-input-inline">
					<input type="tel" name="name2" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">电话</label>
				<div class="layui-input-inline">
					<input type="text" name="phone2" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item" style="margin-top: 10px;">
			<div class="layui-inline">
				<label class="layui-form-label" style="width: 110px;">工号</label>
				<div class="layui-input-inline">
					<input type="tel" name="staff_id2" lay-verify="required"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button lay-submit class="layui-btn"  lay-filter="handover">立即提交</button>
		    </div>
		</div>
	</form>
</body>
<script type="text/javascript" src="..//..layui/layui.js"></script>
<script type="text/javascript" src="qt_handover.js"></script>
</html>
