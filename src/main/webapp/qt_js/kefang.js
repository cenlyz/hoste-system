$(document).ready(function(){
	doGetRoomSite();
});
$('#kefang').click(function(){
	doGetRoomSite();
});
function doGetRoomSite(){
	var url="kefang/doRoomSite.do";
	$.ajaxSetup({
		async:false
	});
	$.getJSON(url,function(result){
		setTableBodyRooms(result.data);
	});
}
function setTableBodyRooms(result){
	var div1=$('#qt_kefang');
	div1.empty();//清楚该区域的内容
	for(var i in result){//循环遍历返回结果
	var div2=$('<div class="c_r_left k_left"></div>');
	var p=$('<p>'+result[i].room_site+'</p>');
	var url="kefang/doRoomType.do";
	var params={"room_site":result[i].room_site};
	var ul=$('<ul class="c_ul c_k_ul"></ul>');
	$.getJSON(url,params,function(rs){//异步请求客房信息
		var data=rs.data;
		for(var n in data){
			console.log((data[n].room_price)*(data[n].room_discount));
			var li=$("<li  onclick='f"+data[n].room_state+"(this)' class='btn btn-primary btn-lg qt_li"+data[n].room_state+"'>"
					+data[n].room_type+
					"<p>"+data[n].room_id+"/"+((data[n].room_price)*(data[n].room_discount))+"元</p></li>")
		li.data("id",data[n].id);
		li.data("room",data[n].room_id);
		ul.append(li);
		}
	});
	div2.append(p);
	div2.append(ul);
	div1.append(div2);
	}
}
function f2(btn){
	var url="kefang/doKefangRoomState.do";
	var trId=$(btn).data("id");
	var params={"id":trId};
	if (confirm("确定更新客房状态吗")==true){ 
	$.getJSON(url,params,function(rs){
		
		$('#kefang').trigger('click');
	});
}
	
}

//入住信息查看
function f1(btn){
	var url="kefang/dokefangInRoom.do";
	var room_id=$(btn).data("room");
	var trId=$(btn).data("id");
	var params={"room_id":room_id};
	params.id=trId;
	//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	//mapper.setDateFormat(fmt); 
	$.getJSON(url,params,function(rs){
		$("#check_k_li1").html(rs.data.check.room_id);
		$("#check_k_li2").html(rs.data.room.room_site);
		$("#check_k_li3").html(rs.data.check.check_name);
		$("#check_k_li4").html(new Date(rs.data.check.check_in_time).toLocaleDateString());
		$("#check_k_li5").html(rs.data.check.check_price+"元" );
		$("#check_k_li6").html(rs.data.check.check_days+"天");
		var dd=(new Date()-rs.data.check.check_in_time)/24/60/60/1000;
		$("#check_k_li7").html(Math.round(dd)+"天");
	});
}

//预定
function f3(btn){
	
	RoomId=$(btn).data("room");
	$.getJSON("kefang/yuding.do",{"RoomId":RoomId},function(rs){
		if (confirm("改客房已被《"+rs.data.check_name+"》预定\n\n点击确定入住")==true){ 
		doShowEditDialog(btn);
		}
	})
}

//客人入住
function f0(btn){
	doShowEditDialog(btn)
}
function doShowEditDialog(btn){
	var title;
	title="添加入住信息"
	var trId=$(btn).data("id");
	//2.将id值绑定到模态框
	var url="kefang/editUI.do"
	 //异步加载url
	$("#modal-dialog .modal-body").load(url,function(){
	 //更新模态框标题
	 $(".modal-title").html(title);
	 //显示模态框
	 $("#modal-dialog").modal("show");
	 var url1="kefang/shuUI.do";
	 	$.getJSON(url1,{"id":trId},function(rs){
	 		var data=rs.data;
	 		$("#roomtype").val(data.room_type);
	 		$("#roomid").val(data.room_id);
	 		$("#roomjg").val(data.room_price*data.room_discount);
	 	});
	});
}
function tf(){
	var room_id=$("#check_k_li1").html();
	var day=$("#check_k_li6").html();
	console.log("day="+day);
	if(room_id==null||room_id==""){
		alert("请选择要退的客房");
		return;
	}
	var msg = "您真的确定要退房吗？\n\n请输入会员号或者电话号码！"; 
	var str=prompt(msg);

	
	if(str!=null){
			$.ajaxSettings.async = false;
			$.getJSON("kefang/getmember.do",{"id":str},function(rs){
		 		var data=rs.data;
		 		console.log(rs);
		 		if(rs.message=="idnull"){
		 			console.log("aaaa");
		 			var url="kefang/receipt.do?t="+Math.random(1000);
		 			 $(".right").load(url,{"room_id":room_id,"id":str});
		 			 return true;
		 		}
		 		if(data==null && rs.message=="OK" ){
		 			console.log("bbbbb");
		 			alert("该会员不存在");
		 			return false;
		 		}
		 		if(data.m_state=="禁用"){
		 			alert("该会员已被禁用");
		 			return false;
		 		}
		 		console.log("cccc");
		 		var url="kefang/receipt.do?t="+Math.random(1000);
	 			 $(".right").load(url,{"room_id":room_id,"id":str});
	 			 return true;
		 		
			});
	}
	
	
}
function fanhui(){
	var url="kefang.do?t="+Math.random(1000);
	$(".right").load(url);

}
function daying(){
	alert("请连接打印机");
}




