var $;
var common;
var publics;
var form;
var $form;
var submitData={};
layui.config({
}).use(['form','layer','jquery','upload','common'],function(){
	form = layui.form(),
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	laypage = layui.laypage;
	$ = layui.jquery;
	$form = $('form');
	common = layui.common;
	var upload = layui.upload;

});

function checkData(){
	submitData={};

	var vip=$(".type").val();
	console.log(vip);
	var discount=$(".discount").val();
	if(discount==null ||discount=="" ||discount>1 ||discount<0){
		top.layer.msg("请填写正确的折扣");
		return false;
	}

	
	submitData.type=vip;
	submitData.discount=discount;
	console.log(submitData);
	return true;
	
}

function clearForm(){
	
	$form.find('input[name=erc_inerface]').val("");
	
	$form.find('[name=erc_msg]').val("");
	
	form.render();
}




