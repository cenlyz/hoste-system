
var tab;
var table;
var $;
var data;
var inputList;
var outputList;
var form;
layui.config({
	base : "../../js/"
}).use(['form','layer','jquery','laypage','common','table','format'],function(){
	form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
	common= layui.common;
	$ = layui.jquery;
	var bodyTab = layui.bodyTab;
	table = layui.table;

	
	
	layui.common.ajaxRequest("queryInterfaceMapping.do",{id:id},function(json){
		//layer.close(index);
		json=json.body;
		if(json.errorCode=='0'){
			
			
			
			
		}else{
			layer.msg(json.errorMessage);
		}
	});
	
	
})




	
