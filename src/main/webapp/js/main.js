layui.config({
	base : "js/"
}).use(['form','element','layer','common','jquery'],function(){
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element,
		$ = layui.jquery;
	var typeList={};
	dataType={};
	dataTypeArr=[];
	dataArr=[];
	setTimeout(function(){
		layui.common.ajaxRequest("queryMainView.do",{},function(json){
			data=json.data;
			console.log(data);

			for(var i in data){
				var value=data[i].count;
				var name=data[i].type;
				dataType={"value":value,"name":name};
				dataArr.push(dataType);
				dataTypeArr.push(name);
				if(name=="普通vip"){
					$(".puAll span").text(value);
				}
				if(name=="黄金vip"){
					$(".hjAll span").text(value);
				}
				if(name=="砖石vip"){
					$(".zsAll span").text(value);
				}
			}
			
			var myChart = echarts.init(document.getElementById('burnDownCharts'));
			option = {
				    title : {
				        text: '会员饼状图',
				        subtext: '实时更新',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				        data: dataTypeArr
				    },
				    series : [
				        {
				            name: '会员',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:dataArr,
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};

			
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
			
		})
	})
	
	
	
	$(".panel a").on("click",function(){
		window.parent.addTab($(this));
	})

	//动态获取文章总数和待审核文章数量,最新文章
	$.get("json/newsList.json",
		function(data){
			var waitNews = [];
			$(".allNews span").text(data.length);  //文章总数
			for(var i=0;i<data.length;i++){
				var newsStr = data[i];
				if(newsStr["newsStatus"] == "待审核"){
					waitNews.push(newsStr);
				}
			}
			$(".waitNews span").text(waitNews.length);  //待审核文章
			//加载最新文章
			var hotNewsHtml = '';
			for(var i=0;i<5;i++){
				hotNewsHtml += '<tr>'
		    	+'<td align="left">'+data[i].newsName+'</td>'
		    	+'<td>'+data[i].newsTime+'</td>'
		    	+'</tr>';
			}
			$(".hot_news").html(hotNewsHtml);
		}
	)

	//图片总数
	$.get("json/images.json",
		function(data){
			$(".imgAll span").text(data.length);
		}
	)



	//数字格式化
	$(".panel span").each(function(){
		$(this).html($(this).text()>9999 ? ($(this).text()/10000).toFixed(2) + "<em>万</em>" : $(this).text());	
	})

	
	
	
	
	
	

	
	
	
	
	
	
	



})
