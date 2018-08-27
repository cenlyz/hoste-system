var $;
var datas={};
var _this;
var currData;
var id;
var form;
layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage;
		$ = layui.jquery;

	//加载页面数据
		var yyyy=$("#yyyy").val();
		var mm=$("#mm").val();
		var dd=$("#dd").val();
		parma={"year":yyyy};
		parma.month=mm;
		parma.day=dd;
		console.log(parma);
		$.get("../../getMoneyList.do",parma, function(rs){
			data=rs.data;
			FinanceList(data);
		})

	
	//查询
	$(".search_btn").click(function(){
		var yyyy=$("#yyyy").val();
		var mm=$("#mm").val();
		var dd=$("#dd").val();
		parma={"year":yyyy};
		parma.month=mm;
		parma.day=dd;
		console.log($(".search_input").val() != '');
		var newArray = [];
		if($(".search_input").val() != ''){
			$.get("../../getMoneyList.do",parma,function(rs){
				data=rs.data;
				console.log(data);
				FinanceList(data);
			})
			return false;
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	
	function FinanceList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = newsData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				
				for(var i=0;i<currData.length;i++){
					var _currentDateStr = currData[i].toString();
					var n=i+1;
					var _currentDateStr = currData[i].toString();
					dataHtml += '<tr>'
						+'<td>'+n+'</td>'
				    	+'<td align="left">'+currData[i].year+'</td>'
				    	+'<td>'+(currData[i].month==null?"":currData[i].month)+'</td>'
				    	+'<td>'+(currData[i].day==null?"":currData[i].day)+'</td>'
				    	+'<td>'+(currData[i].type==null?"":currData[i].type)+'</td>'
				    	+'<td>'+currData[i].money+'</td>'
				    	+'</tr>';
					
				}
			}else{
				dataHtml = '<tr><td colspan="9">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 31; //每页出现的数据量
		if(that){
			newsData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(newsData.length/nums),
			jump : function(obj){
				$(".news_content").html(renderDate(newsData,obj.curr));
				$('.news_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})

