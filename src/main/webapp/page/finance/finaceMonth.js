var form;
var $;
layui.use(['form','layer','common','jquery'],function(){
	form = layui.form();
	
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
	element = layui.element,
	$ = layui.jquery;
	console.log(parent.yearID);
	yearID=parent.yearID;
	mon=parent.mon;
	console.log(parent.mon);
	var typeList={};
	dataMoney={};
	dataMonthArr=[];
	dataArr=[];
	layui.common.ajaxRequest("../../getYearMonth.do",{"year":yearID,"month":mon,asynchronous:false},
			function(rs){
		data=rs.data;
		console.log(data);
		for(var i in data){
			var value=data[i].money;
			var day=data[i].day;
			dataArr.push(day+"号");
			dataMonthArr.push(parseInt(value));
		}
		
		var myChart = echarts.init(document.getElementById('burnMonthCharts'));
		option = {
			    title: {
			        text: yearID+'年'+mon+'月折线图'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['客房收益']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: dataArr
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [
			        {
			            name:'客房收益(元)',
			            type:'line',
			            stack: '总量',
			            data:dataMonthArr
			        }
			    ]
			};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		form.render();
	})
	
	
	
})


