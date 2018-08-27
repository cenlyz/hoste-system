layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	//创建一个编辑器
 	var editIndex = layedit.build('news_content');
 	form.on("submit(addRoom)",function(data){
 		var room_id=$(".newsName").val();
 		var r = /^[0-9a-zA-Z]{3,6}$/;
 		var p=/^[0-9]{2,4}$/;
 		var t=/^[0-9]{7,11}$/;
 		if(!r.test(room_id)){
 			alert("客房编号输入不合法");
 			return false; 
 		}
 		var room_type=$('.type input[name="type"]:checked ').val();
 		var room_price=$(".room_price").val();
 		if(!p.test(room_price)){
 			alert("客房价格输入不合法");
 			return false; 
 		}

 		var room_discount=$(".room_discount").val();
 		if(room_discount>1||room_discount<=0){
 			alert("客房折扣输入不合法");
 			return false;
 		}
 		var room_state=$('.room_state').val();
 		var room_site=$('.room_site').val();
 		var room_phone=$('.room_phone').val();
 		if(!t.test(room_phone)){
 			alert("客房电话输入不合法");
 			return false; 
 		}
 		var room_describe=$('#news_content').val();
 		params={"room_id":room_id};
 		params.room_type=room_type;
 		params.room_price=room_price;
 		params.room_discount=room_discount;
 		params.room_state=room_state;
 		params.room_site=room_site;
 		params.room_phone=room_phone;
 		params.room_describe=room_describe;
 		console.log(params);
 		var url="../../roomAdd.do";
 		$.getJSON(url,params,function(rs){
 			alert("添加客房成功");
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            top.layer.close(index);
			top.layer.msg("客房添加成功！");
 			layer.closeAll("iframe");
	 		//刷新父页面
	 		parent.location.reload();
 		return false;
 	})
 	})
	
})
