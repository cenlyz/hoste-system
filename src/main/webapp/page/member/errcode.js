var moduleDialogIndex
var tab;
var chan=false;
layui.config({
	base : "../../js/"
}).use(['form','layer','jquery','laypage','common','table','format'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	var bodyTab = layui.bodyTab;
	var table = layui.table;

	
	table.render({
	    elem: '#errcodeList',//绑定页面元素ID
	    url: '../../queryErrcodeListObjects.do',
	    id: 'errocodeTable',//定义表格唯一标示
	    page: true,//开启分页
	    height: 'full-108',//高度满屏
	    limits: [15,30,60,120,240],
	    limit: 15, //默认采用15
	    loading: true,//加载时的进度条
	    even:false,//隔行背景风格
	    request:{
			pageName: 'currentPage',
			limitName: 'pageCount' 
		},
		response:{
			dataName:'commonList',
			countName:'totalCount'
		},
		
	    cols: [[
	      {field: 'code', title: '错误码ID', align:'center',width: 150,sort:true},
	      {field: 'msg', title: '错误码描述',align:'center',width: 200},
	      {field: 'inerface', title: '属于接口',align:'center', width: 200},
	      {field: 'createDate', title: '创建时间',align:'center', width: 170 ,templet: '#dateTpl'},
	      {field: 'author', title: '修改人',align:'center', width: 120},
	      {fixed: 'right', title: '操作', width:220, align:'center', toolbar: '#barTools'}
	    ]]
	 });
	
	//监听工具条
	table.on('tool(errcodeList)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值
	  var tr = obj.tr; //获得当前行 tr 的DOM对象
	  if(layEvent === 'del'){ //删除-------------------------------------------------------------------
		    layer.confirm('确定要删除该规则吗', function(index){
			    layer.close(index);
			    var indexSubmit = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
		    	setTimeout(function(){
			    	layui.common.ajaxRequest("errcodeDel.do",{"code":data.code},function(json){
			    		layer.close(indexSubmit);
			    		var errorBody=json.body;
			    		if(errorBody==null){
			    			 layer.msg("删除失败，请稍后重试");
			    		}
						if(errorBody.errorCode=='0'){
							obj.del();
					        layer.msg("删除成功！",{icon:1});
					        table.reload('errocodeTable', {});
						}else{
							layer.msg(errorBody.errorMsg);
						}
					});
		    	 },1000);
		    });
	  } else if(layEvent === 'edit'){ //编辑-----------------------------------------------------------------
	  
			layui.common.openFramePage({
				title : "修改错误码",
				type : 2,
				content : "editErrcode.html",
				area: ['580px', '500px'], //宽高
				btn: ['保存', '取消'],
				
				yes:function(index, layero){
					var body = layer.getChildFrame('body', index);
					var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
					var flag=iframeWin.checkData();
					
					
					if(flag){
						var editErrcodeData=iframeWin.submitData;
						var sessionData = layui.common.getSessionData("sessionData");
						var userName;
						if(sessionData!=null){
							userName=sessionData.session_userId;
						}
						editErrcodeData.userName=userName;
						if(chan){							
						}else{
							layer.msg("没有修改无法提交");
							return;
						}
						
						try {
							
							var index2 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
							setTimeout(function(){
								layui.common.ajaxRequest("errcodeEdit.do",editErrcodeData,function(json){
									var jsonData=json.body;
									
									if(jsonData==null){
										layer.msg("修改失败请稍后重试");
									}
									if(jsonData.errorCode=='0'){

										top.layer.msg("错误码修改成功！",{icon:1});
										layui.layer.close(index);
										table.reload('errocodeTable', {});
									}else{
										top.layer.msg(jsonData.errorMsg,{icon:5});
									}
									top.layer.close(index2);
								});
							},1000);
						}catch(err){
							top.layer.close(index2);
							top.layer.msg(err.message,{icon:5});

						}
					}
	

				},
				end:function(){
					//table.reload('ruleTable', {});
				}},data);



				
	  }
	});
	//查询
	$(".search_btn").click(function(){

		table.reload('errocodeTable', {
			  where: {
				  code:$(".search_input").val()
			  } //设定异步数据接口的额外参数
		});
	});
	
	$(".search_input").keydown(function(event) {
        if (event.keyCode == 13) {
        	table.reload('errocodeTable', {
  			  where: {
  				code:$(".search_input").val()
  			  } //设定异步数据接口的额外参数
  		});
        }    
    });
		
	//添加应用
	$(".addErrcode_btn").click(function(){
		layui.common.openFramePage({
			title : "添加错误码",
			type : 2,
			content : "addErrcode.html",
			area: ['580px', '500px'], //宽高
			btn: ['保存', '取消'],
			
			yes:function(index, layero){
				var body = layer.getChildFrame('body', index);
				var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				var flag=iframeWin.checkData();
				
				if(flag){
					var errcodeData=iframeWin.submitData;
					var sessionData = layui.common.getSessionData("sessionData");
					var userName;
					if(sessionData!=null){
						userName=sessionData.session_userId;
					}
					errcodeData.author=userName;
					try {
						
						var index2 = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
						setTimeout(function(){
							layui.common.ajaxRequest("errcodeAdd.do",errcodeData,function(json){
								var errorBody=json.body;
								if(errorBody.count>0){
									 layer.msg("添加失败，错误码ID已存在");
									 return;
								}
							
					    		if(errorBody==null){
					    			 layer.msg("添加失败，请稍后重试");
					    		}

								if(errorBody.errorCode=='0'){
									iframeWin.clearForm();

									top.layer.msg("错误码添加成功！",{icon:1});
									layui.layer.close(index);
									table.reload('errocodeTable', {});
								}else{
									top.layer.msg(errorBody.errorMsg,{icon:5});
								}
								top.layer.close(index2);
							});
						},1000);
					}catch(err){
						top.layer.close(index2);
						top.layer.msg(err.message,{icon:5});

					}
				}


			},
			end:function(){
				//table.reload('ruleTable', {});
			}},null);
		
	});
})