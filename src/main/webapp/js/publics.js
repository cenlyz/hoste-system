/**自定义模块*/
layui.define(['layer','jquery','common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;

    var publics = {
    	getBranch : function(branchData,callback){
	    	if(layui.common.isNull(branchData)){
	    		branchData = {level:0};
	    	}
//	    	window.sessionStorage.setItem("current_branch_data",JSON.stringify(branchData));
			var func = function(index,layero){
				var body = layer.getChildFrame('body',index);
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					callback({branchId:body.find('#branchId').val(),branchName:body.find('#branchName').val()});
				}
				layer.close(index);
			};
			layui.common.openFramePage({
				title : "选择机构",
				type : 2,
				area: ['100%','100%'], //宽高
				skin:'layui-popWin',
				content : "../system/branch_tree.html",
				area: ['100%', '100%'],
				btn:['确定','取消'],
				yes: func
			},branchData);
    	},
   
    	addAuth:function(id){
    		if(layui.common.isNull(id)){
    			id="#authId";

	    	}
    		var func = function(index,layero){
				var body = layer.getChildFrame('body',index);
				layui.common.ajaxRequest("queryAuthList.do",{currentPage:'1',pageCount:'100'},function(json){
					var authList = [];
					$.each(json.data,function(indxe,item){
						authList.push({value:item.authId,name:item.authName});
					});
					$(id).empty();
					$(id).append(format.getSelectByList(authList,"value","name",body.find('#authId').val()));
					form.render();
				});
				layer.close(index);
			};
	    	var index = layer.open({
				title : "添加认证",
				type : 2,
				content : "../assets/addAuth.html",
				area: ['50%', '500px'],
				cancel: func
			});
    	},
    	getModule : function(branchId,callback){
	    	if(layui.common.isNull(branchId)){
	    		layer.alert('请先选择所属机构', {icon: 8});
	    		return;
	    	}
	    	var params = {branchId:branchId};
			var func = function(index,layero){
				var body = layer.getChildFrame('body',index);
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					var module = JSON.parse(body.find('input[type="radio"][name="module"]:checked').val());
					callback(module);
				}
				layer.close(index);
			};
			layui.common.openFramePage({
				title : "选择模块",
				type : 2,
				skin:'layui-popWin',
				content : "../system/module_tree.html",
				area: ['100%', '100%'],
				btn:['确定','取消'],
				yes: func
			},params);
    	},
    	getUser : function(callback){
			var func = function(index,layero){
			/*	var body = layer.getChildFrame('body',index);
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					var data = window.sessionStorage.getItem("current_edit_db_data");
					if(!layui.common.isNull(data)){
						callback(JSON.parse(data));
					}
					
				}
				layer.close(index);*/
				var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				var value = iframeWin.selectValue;
				if(layui.common.isNull(value)){
					layer.msg("请选择用户",{icon:8});
					return;
				}
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					callback(value);
				}
				layui.layer.close(index);
			};
			layui.common.openFramePage({
				title : "选择用户",
				type : 2,
				skin:'layui-popWin',
				content : "../scrum/selectUser.html",
				area: ['100%', '100%'],
				btn:['确定','取消'],
				yes: func
			});
    	
    	},
    	getDataBase : function(callback){
			var func = function(index,layero){
			/*	var body = layer.getChildFrame('body',index);
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					var data = window.sessionStorage.getItem("current_edit_db_data");
					if(!layui.common.isNull(data)){
						callback(JSON.parse(data));
					}
					
				}
				layer.close(index);*/
				var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				var value = iframeWin.selectValue;
				if(layui.common.isNull(value)){
					layer.msg("请选择数据库",{icon:8});
					return;
				}
				if(!layui.common.isNull(callback) && typeof callback == 'function'){
					callback(value);
				}
				layui.layer.close(index);
			};
			layui.common.openFramePage({
				title : "选择数据库",
				type : 2,
				skin:'layui-popSize',
				content : "../test/selectDataBase.html",
				area: ['100%', '100%'],
				btn:['确定','取消'],
				yes: func
			});
    	
    	}
    	
    };
    exports('publics', publics);
});



