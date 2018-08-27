$(document).ready(function(){
	doGetObjects();
	$("#search").on("click",doQueryObjects);
});
/**点击查询按钮时执行此方法*/
function doQueryObjects(){
	var url="member/getMemberSearch.do";
	//1.初始化当前页码数据
	$("#pageId").data("pageCurrent",1);
	//2.更据查询数据
	doGetObjects();
}
//搜索
function doGetObjects(){
	debugger
	var url="member/getMemberSearch.do";
	var m_id=$("#id").val();
	var tel=$("#tel").val();
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent) pageCurrent=1;
	var params={"pageCurrent": pageCurrent};
	params.m_id=m_id;
	params.check_tel=tel;
	
	$.getJSON(url,params,function(result){
		doInitProjectMemberList(result.list);//map中的key对应的值
		setPageNation(result.pageObject);
	});
}
//显示会员列表
function doGetProjectMember(){
	var url="member/doGetProjectMember.do";
	//ajax-get-->(考虑编码:tomcat一般会做一个修改)
	$.getJSON(url,function(result){
		if(result.state==1){//SUCCESS
		doInitProjectMemberList(result.data);
		}else{//ERROR(业务异常)
		alert(result.message);
		}
	});
}
function doInitProjectMemberList(result){
	//1.获得tbody对象
	//debugger
	var tBody=$('#tbodyId');
	//2.迭代数据集result
	tBody.empty();//清空tBody
	for(var i in result){
	//2.1构建一个tr
		var tr=$("<tr class='din_dat'></tr>");
		var rs=result[i];
		tr.data("id",rs.id);
	//2.2构建每行td
		//将firstTd字符串中的[id]替换为一个具体指
	//2.3在td对象内容填充具体数据
		var tds= '<td>'+i+'</td>'
				+'<td>'+rs.m_id+'</td>'
				+'<td>'+rs.check_name+'</td>'
				+'<td>'+rs.check_tel+'</td>'
				+'<td>'+rs.m_price+'</td>'
				+'<td>'+rs.m_integral+'</td>'
				+"<td>"+rs.m_type+"</td>"
				+'<td><div class="layui-btn-group">'
				+'<button id="me-stop'+rs.id+'"  class="layui-btn layui-btn-xs '+(rs.m_state=="禁用"?'me-bj-color':'')+'">'+rs.m_state+'</button>'
				+'</div></td>'
				+'<td><div class="layui-btn-group">'
				+'<button class="layui-btn layui-btn-xs me-bj-color" onclick="me_stop(this);">禁用</button>'
				 +' <button class="layui-btn layui-btn-xs" onclick="me_start(this);">启用</button>'
				+'</div></td>';
	//2.4将td添加到tr对象中
		tr.append(tds);	
	//2.5将tr追加到tbody中
		tBody.append(tr);
	}
}
//禁用
function me_stop(btn){
	var url="member/doStateStop.do";
	var id=$(btn).parent().parent().parent().data("id");
	var ids="me-stop"+id;
	var params={"id":id};
	params.m_state="禁用";
	$.getJSON(url,params,function(rs){
//			alert(rs.message);
		$("#"+ids).html("禁用");
		$("#"+ids).attr("class","layui-btn layui-btn-xs me-bj-color");
	});
}
//启用
function me_start(bts){
	var url="member/doStateStop.do";
	var id=$(bts).parent().parent().parent().data("id");
	var ids="me-stop"+id;
	var params={"id":id};
	params.m_state="启用";
	$.getJSON(url,params,function(rs){
//		alert(rs.message);
		$("#"+ids).html("启用");
		$("#"+ids).attr("class","layui-btn layui-btn-xs ");
	});
}



































