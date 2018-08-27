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
 	var editIndex = layedit.build('links_content');
 	var addLinksArray = [],addLinks;
 	form.on("submit(addLinks)",function(data){
 		var url="../../goodsEdit.do";
 		var goods_name=$("#goods_name").val();
 		var param={"goods_name":goods_name};
 		param.goods_id=$("#goods_id").val();
 		param.goods_class=$('#goods_type input[name="goods"]:checked ').val();
 		param.goods_kc=$("#goods_kc").val();
 		param.goods_yu=$("#goods_yu").val();
 		$.getJSON(url,param,function(rs){
 			if(rs.message!=null){
 			var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 	            top.layer.close(index);
 				top.layer.msg("修改成功！");
 	 			layer.closeAll("iframe");
 		 		//刷新父页面
 		 		parent.location.reload();
 	 		return false;
 			}else{
 				top.layer.msg("修改失败！");
 			}
 		});
 		
 	})
	
})
