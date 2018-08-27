var $;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

	
	var ids=parent.currData;
	var i=parent.id;
	var id=ids[i].id;
	var staff_state=ids[i].staff_state;
	$(".name").val(ids[i].name);
	$(".staff_site").val(ids[i].staff_site);
	var type=ids[i].staff_sex;
	$(".staff_username").val(ids[i].username);
	$(".sttaf_health_id").val(ids[i].staff_health_id);
	$(".staff_phone").val(ids[i].staff_phone);
    $("input[type='radio'][name='sex'][value="+type+"]").attr("checked","checked");
	form.render();
	
	
	//创建一个编辑器
 	var editIndex = layedit.build('links_content');
 	var addLinksArray = [],addLinks;
 	form.on("submit(editLinks)",function(data){
 		var url="";
 		var name=$(".name").val();
 		var staff_site=$('.staff_site').val();
 		var username=$(".staff_username").val();
 		var staff_sex=$('.sex input[name="sex"]:checked').val();
 		var sttaf_health_id=$('.sttaf_health_id').val();
 		var staff_phone=$('.staff_phone').val();
 		var r = /^[0-9a-zA-Z]{4,8}$/;
 		if(!r.test(username)){
 			alert("员工号输入有误");
 			return false; 
 		}
 		
 		params={"name":name};
 		params.staff_site=staff_site;
 		params.username=username;
 		params.staff_sex=staff_sex;
 		params.staff_health_id=sttaf_health_id;
 		params.staff_phone=staff_phone;
 		params.staff_state=staff_state;
 		params.id=id;
 		var url="../../staffEdit.do";
 		console.log(params);
 		//弹出loading
 	//	var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
 		 setTimeout(function(){
 		$.getJSON(url,params,function(rs){
 			console.log("json");
 			console.log("msg");
			top.layer.msg("用户添加成功！");
 			layer.closeAll("iframe");
	 		//刷新父页面
	 		parent.location.reload();
	 		console.log("fss");
 		
 		})
 		},1000);
  		return false;
 	
 	})
	
})
