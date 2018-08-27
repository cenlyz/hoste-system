var $;
var btn;
layui.config({
	base : "../../js/"
}).use(['jquery'],function(){
	$ = layui.jquery;
	//获取当前数据
	var ids=parent.currData;
	var i=parent.id;
	console.log(ids);
	console.log(i);
	$("#goods_name").val(ids[i].goods_name);
	$("#goods_id").val(ids[i].goods_id);
	var type=ids[i].goods_class;
	$("#goods_kc").val(ids[i].goods_kc);
	$("#goods_yu").val(ids[i].goods_yu);
    $("input[type='radio'][name='goods'][value="+type+"]").attr("checked","checked");
	form.render();
	
});





