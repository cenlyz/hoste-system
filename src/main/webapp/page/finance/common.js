/**自定义模块*/
layui.define(['layer','element'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;
    var element = layui.element;
    var common = {

        /**错误msg提示 */
        errorMsg:function (text) {
           top.layer.msg(text, {icon: 5});
        	//top.layer.alert(text, {icon: 2});
        },
        /**成功 msg提示 */
        successMsg:function (text) {
            top.layer.msg(text, {icon: 6});
        },
        /**ajax Confirm 对话框*/
        confirmMsg: function (title, text, url,param) {
            layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定', '取消'],
                btnAlign: 'c',
                anim:1,
                icon: 3
            }, function () {
                $.ajax({
                    url : url,
                    type : 'post',
                    async: false,
                    data : param,
                    success : function(data) {
                        if(data.returnCode == 0000){
                            top.layer.msg(data.returnMessage, {icon: 6});
                            location.reload();
                        }else{
                            top.layer.msg(data.returnMessage,{icon: 5});
                        }
                    },error:function(data){

                    }
                });

            }, function () {

            })

        },
        /**弹出层*/
        openPage:function (title,url,width,height) {

            var index = layui.layer.open({
                title : '<i class="larry-icon larry-bianji3"></i>'+title,
                type : 2,
                skin : 'layui-layer-molv',
                content : url,
                area: [width, height],
                resize:false,
                anim:1,
                success : function(layero, index){

                }
            });
        },
        /**退出*/
        logOut: function (title, text, url, type, dataType, data, callback) {
            parent.layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定退出系统', '不，我点错了！'],
                btnAlign: 'c',
                icon: 3
            }, function () {
                location.href = url;
            }, function () {
               
            });
        },
        getSessionData:function(key){
        	return JSON.parse(window.sessionStorage.getItem("sessionData"));
        },
        getSessionByKey:function(key){
        	return JSON.parse(window.sessionStorage.getItem("sessionData"))[key];
        },
        getAddr:function(url){
        	return url;
        },
        getMessageHeader:function(){
        	var date = new Date();
        	var channelDate = date.getFullYear().toString()+(date.getMonth()+1).toString()+date.getDate().toString();
        	var channelTime = date.getHours().toString()+date.getMinutes().toString()+date.getSeconds().toString();
        	header = {
        		type:type,
        		versionNo:'0.1',
        		clientIP:'0.0.0.0.',
        		channelCode:'UT',
        		channelDate:channelDate,
        		channelTime:channelTime,
        		securityFlag:'0',
        		macCode:'',
        		macValue:'',
        		packageType:'00',
        		rf:'JSON',
        		transCode:'001',
        		transId:new Date().format("yyyymmddhhmiss")+Math.uuid(8)
        	};
        	
        },
        requestModel:function(url,params,success,options){
        	var config = {type: 'post',async: true,dataType:'json'};
        	var joptions = $.extend(config,options);
        	joptions.url = this.getAddr(url);
        	joptions.data = {
        			head:this.getMessageHeader(),
        			body:params
        		};
        	joptions.success = success;
        	 $.ajax(joptions);
        },
        ajaxRequest:function(url,params,success,options){
        	var config = {type: 'post',async: true,dataType:'json'};
        	var joptions = $.extend(config,options);
        	joptions.url = this.getAddr(url);
        	joptions.data = params;
//        	var call = function(json){
//        		if(json.errorCode == 'UT20000'){
//        			window.location.href="page/sessionTimeOut.html";
//        		}else{
//        			success(json);
//        		}
//        	};
        	joptions.success = success;
        	 $.ajax(joptions);
        },
        isNull:function(string){
        	if(string == undefined || string == '' || string == null || string == 'null' ){
        		return true;
        	}
        	return false;
        },
        /**
         * 在tab上新建一个窗口打开
         * 支持params对象传递参数
         */
        openTabPage:function(object,params){
        	var win = object.clone();
        	var url = win.attr("data-url");
        	if(params !=null){
        		win.attr("data-url",url+"?dataContent="+encodeURIComponent(JSON.stringify(params)));
        	}
        	var tab = window.parent.tab;
        	tab.tabAdd(win);
        },
        
        /**
         * 弹出ifram层窗口
         * 支持params对象传递参数
         */
        openFramePage:function (options,params,isTop) {
        	var url = options.content;
        	
        	if(params !=null){
        		options.content = url+"?dataContent="+encodeURIComponent(JSON.stringify(params));
        	}
        	if(isTop){
        		return parent.layer.open(options);
        	}
            return layui.layer.open(options);
        },
        
        /**
         * 获取上下文参数值
         */
        getContentData:function(){
        	var params = null;
        	var reg = new RegExp("(^|&)dataContent=([^&]*)(&|$)");
    	    var r = window.location.search.substr(1).match(reg);
    	    if(r != null)
    	    	params = eval('(' + decodeURIComponent(r[2]) + ')'); 
    	    return params;
        },
        
        unescapeHTML:function(str) {
        	return str.replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&amp;/g,'&').replace(/&quot;/g,'"').replace(/&apos;/g,"'");
        }
    };
    exports('common', common);
});



