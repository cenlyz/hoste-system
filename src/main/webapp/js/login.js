layui.config({
	base : "js/"
}).use(['form','layer','common','carousel'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(window).width()>700){
			$(".login").css("left","70px");
			$(".login").css("right","65%");
		}else{
			$(".login").css("left",0);
			$(".login").css("right",0);
		}
		
	}).resize();
	
	layui.use('carousel', function(){
	  var carousel = layui.carousel;
	  //建造实例
	  carousel.render({
	    elem: '#login_carousel'
	    ,width: '100%' //设置容器宽度
	    ,arrow: 'always' //始终显示箭头
	    ,height:'564px'
	  });
	});
	
	//登录按钮事件
	form.on("submit(login)",function(data){
		//弹出loading
        var loginLoading = top.layer.msg('登陆中，请稍候', {icon: 16, time: false, shade: 0.8});
        //记录ajax请求返回值
        var ajaxReturnData = null;

        //登陆验证
        $.ajax({
            url: layui.common.getAddr('userSign.do'),
            type: 'post',
            async: false,
            data: data.field,
            dataType:'json',
            success: function (data) {
                ajaxReturnData = data.body;
            },
            error: function (data) {
            	layui.common.errorMsg('后台异常，请稍后再试');
            }
        });
        //登陆成功
        if(ajaxReturnData){
        	 if (ajaxReturnData.errorCode == 0) {
             	var sessionData = {
                 		/*'session_userId':ajaxReturnData.userNumber,
                 		'session_loginName':ajaxReturnData.userId,
                 		'session_userBranchId':ajaxReturnData.branchId,
                 		'session_userName':ajaxReturnData.userName,
                 		'session_userBranchLevel':ajaxReturnData.level,
                 		'session_sex':ajaxReturnData.userSex,
                 		'session_mobileNo':ajaxReturnData.mobileNo,
                 		'session_telephone':ajaxReturnData.telephone,
                 		'session_email':ajaxReturnData.email,
                 		'session_branchName':ajaxReturnData.branchName,
                 		'session_userFace':ajaxReturnData.userFace,
                 		'session_remarks':ajaxReturnData.remarks*/
             			'session_userId':ajaxReturnData.userId,
                 		'session_userName':ajaxReturnData.name,
                 		'session_sex':ajaxReturnData.sex,
                 		'session_mobileNo':ajaxReturnData.mobileNo,
                 		'session_email':ajaxReturnData.email,
                 		'session_userFace':ajaxReturnData.userFace
                 	};
             	window.sessionStorage.setItem("sessionData",JSON.stringify(sessionData));
                 window.location.href=layui.common.getAddr('welcome.do');
                 top.layer.close(loginLoading);
                 return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
             } else {
                 top.layer.close(loginLoading);
                 layui.common.errorMsg('['+ajaxReturnData.errorCode+']'+ajaxReturnData.errorMsg);
                 return false;//阻止表单跳转。如果需要表单跳转，去掉这段即可。
             }
        }
       
        return false;
	});
});
