var $;
var btn;
layui.config({
	base : "../../js/"
}).use(['jquery'],function(){
	$ = layui.jquery;
	//获取当前数据
	var ids=parent.currData;
	var i=parent.id
	$("#room_id").val(ids[i].room_id);
	$(".room_price").val(ids[i].room_price);
	$("#type").val(ids[i].room_type);
	var type=ids[i].room_type;
	$(".room_discount").val(ids[i].room_discount);
	$(".room_state").val(ids[i].room_state);
	$(".room_site").val(ids[i].room_site);
	$(".room_phone").val(ids[i].room_phone);
	$(".room_describe").val(ids[i].room_describe);
    $("input[type='radio'][name='type'][value="+type+"]").attr("checked","checked");
	form.render();
	
});





