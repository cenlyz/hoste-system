$(document).ready(function(){
	doGetTypeObjects();
});
$('#load_book').click(function(){
	doGetTypeObjects();
});
function doGetTypeObjects(){
	var url="book/doBookType.do";
	$.getJSON(url,function(result){
		setTableBodyRows(result.data);
		setTableBodyCount(result.data);
	});
}
//显示房间类型
function setTableBodyRows(result){
	var type=$('#book_type');
	type.empty();
	for(var i in result){
	type.append('<option value='+result[i].room_type+'>'+result[i].room_type+'</option>');
	}
	
}
//显示房间剩余数量
function setTableBodyCount(result){
	var ul=$('#c_b_right_ul');
	ul.empty();
	for(var i in result){
		ul.append('<li><p></p><p></p><p>'+result[i].room_type+'</p><p>剩余'+result[i].room_count+'间</p></li>');
	}
	
}


$('#book_name').blur(function(){
	var val=$('#book_name').val();
	if(val==""){
		alert("请输入姓名");
		return;
	}
});
$('#book_tel').blur(function(){
	var str=$('#book_tel').val();
	if(!(/^1[34578]\d{9}$/.test(str))){
		alert("请输入有效电话号码");
		return;
	}
});
$('#book_count').click(function(){
	var str=$('#book_count').val();
	$('#book_mon').val(str*100);
});

$('#book_submit').click(function(){
	var url="book/doSaveBooks.do";
	var name=$('#book_name').val();
	if(name==""){
		alert("请输入姓名");
		return;
	}
	var params={"check_name":name};
	var tel=$('#book_tel').val();
	if(!(/^1[34578]\d{9}$/.test(tel))){
		alert("请输入有效电话号码");
		return;
	}
	params.check_tel=tel;
	var cin=$('#datepicker').val();
	if(cin=="Check In"||cin==""){
		alert("请选择预定日期");
		return;
	}
		
	params.check_in=cin;
	var cout=$('#datepicker1').val();
	if(cout=="Check Out"||cout==""){
		alert("请选择退房日期");
		return;
	}
	params.check_out=cout;
	params.book_type=$('#book_type').val();
	params.book_count=$('#book_count').val();
	params.book_mony=$('#book_mon').val();
	//json  get请求 服务器返回数据时执行
	$.getJSON(url,params,function(result){
		//将数据显示在table  tbody中
		alert(result.message);
	});
});