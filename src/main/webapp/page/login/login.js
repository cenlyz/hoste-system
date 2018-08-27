layui.config({
	base : "js/"
}).use(['form','layer'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
		var url="../../index.do"
		var param=data.field;//获取用户名密码验证码
		console.log(param)
		$.get(url,param,function(rs){
			console.log(rs.message);
			if(rs.message=="ok"){
			layer.msg(
                '登陆成功！<br/>3秒后跳转到登录页',
                {
                    icon: 6,
                    shade: 0.3,
                    end: function () { location.href = "../../index.jsp" }
                });
			}else if(rs.message=="number"){
				layer.msg(
		                '验证码错误',
		                {
		                    icon: 6,
		                    time:1000,
		                    shade: 0.3,
		                });
			}else if(rs.message=="code"){
				layer.msg(
		                '请输入验证码',
		                {
		                    icon: 6,
		                    time:1000,
		                    shade: 0.3,
		                });
			}else if(rs.message=="username"){
				layer.msg(
		                '用户名不存在',
		                {
		                    icon: 6,
		                    time:1000,
		                    shade: 0.3,
		                });
			}else if(rs.message=="password"){
				layer.msg(
		                '密码错误',
		                {
		                    icon: 6,
		                    time:1000,
		                    shade: 0.3,
		                });
			}
		})
		
		return false;
	})
})
