layui.config({
	base : "js/"
}).use(['form','layer'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	
	form.on("submit(yan)",function(data){
		layer.msg('发送成功' ,{icon: 6, shade: 0.3});
		var url="../../checkcode.do";
		
		return false;
	})
})