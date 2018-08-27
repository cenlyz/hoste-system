/**自定义模块*/
layui.define(['layer','jquery','common'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;

    var scan = {
    	getBranch : function(branchData,callBack){
    	if(layui.common.isNull(branchData)){
    		branchData = {level:0};
    	}
    	
    	window.sessionStorage.setItem("current_branch_data",JSON.stringify(branchData));
		var func = function(index,layero){
			var body = layer.getChildFrame('body',index);
			$('#branchId').val(body.find('#branchId').val());
			$('#branchName').val(body.find('#branchName').val());
			layer.close(index);
			if(callBack && typeof callBack==="function"){
				//eval(callBack());
				callBack();
			}
			
		};
    	var index = layer.open({
			title : "选择机构",
			type : 2,
			content : "../system/branch_tree.html",
			area: ['450px', '450px'],
			btn:['确定','取消'],
			yes: func
		});
    }
    };
    exports('scan', scan);
});



