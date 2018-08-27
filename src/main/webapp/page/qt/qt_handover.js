function handover(){
	var name=$("#name").val();
	var phone=$("#phone").val();
	var staff_id=$("#staff_id").val();
	var dmoney=$("#dmoney").val();
	var bmoney=$("#bmoney").val();
	var name2=$("#name2").val();
	var phone2=$("#phone2").val();
	var staff_id2=$("#staff_id2").val();
	var str = /^(((13[0-9]{1})|159|153)+\d{8})$/
	if(name==null||name==""){
		alert("请输入交班人姓名");
		return;
	}
	if(!str.test(phone)){
		alert("请输入有效交班人电话");
		return;
	}
	if(staff_id==null||staff_id==""){
		alert("请输入交班人工号");
		return;
	}
	if(dmoney==null||dmoney==""){
		alert("请输入当前现金");
		return;
	}
	if(bmoney==null||bmoney==""){
		alert("请输入备用金");
		return;
	}
	if(name2==null||name2==""){
		alert("请输入交班人姓名");
		return;
	}
	if(!str.test(phone2)){
		alert("请输入接班人电话");
		return;
	}
	if(staff_id2==null||staff_id2==""){
		alert("请输入接班人工号");
		return;
	}
	var url="gethandover.do";
	var param={"name":name};
	param.phone=phone;
	param.staff_id=staff_id;
	param.dmoney=dmoney;
	param.bmoney=bmoney;
	param.name2=name2;
	param.phone2=phone2;
	param.staff_id2=staff_id2;
	$.getJSON(url,param,function(rs){
		alert(rs.message);
	})
}
