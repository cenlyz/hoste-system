var form;
var yearID;
var mon;
var typeList={};
var dataMoney={};
var dataMonthArr=[];
var dataArr=[];
var myChart;
var $;
	layui.use(['form','layer','common','jquery'],function(){
		form = layui.form();
		
		var layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element,
		$ = layui.jquery;

	
	var myDate= new Date(); 
	var startYear=myDate.getFullYear()-30;//起始年份 
	var dataHtml="<select name='yearId'  id='yearId' lay-filter='yearId'> ";
//	var insert=$("#yearId");
//	insert.empty();
	for (var i=myDate.getFullYear();i>=startYear;i--){ 
		dataHtml += '<option value="'+i+'">'+i+'年</option> '
		
	}
	document.form1.yearId.outerHTML = dataHtml + "</select>";
	form.render();
	yearID=myDate.getFullYear();
	myChartView();
	form.on('select(yearId)', function(data){
		dataMonthArr=[];
		var center=$('#yearId').val();
		yearID=center;
		zhuView(center);
	});
	form.render();
	zhuView(yearID);
	
	
	
	
})



function zhuView(yearID){

	layui.common.ajaxRequest("../../getMoneyMonth.do",{"year":yearID,asynchronous:false}, function(rs){
		data=rs.data;
		console.log(data);
		for(var i in data){
			var value=data[i].money;
			var month=data[i].month;
			dataArr.push(month+"月");
			dataMonthArr.push(parseInt(value));
		}
		
		myChart.setOption({
			series:[{
				data:dataMonthArr
			}]
			,title: {
		        text: yearID+'年利润柱状图'
		    },
		})
				
	})
	
	
}
function myChartView(){
	myChart= echarts.init(document.getElementById('burnDownCharts'));
	option = {
			title: {
		        text: yearID+'年利润柱状图'
		    },
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis : [
	        {
	            type : 'category',
	            data : ['1月' ,'2月' , '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'营业额(元)',
	            type:'bar',
	            barWidth: '60%',
	            data:dataMonthArr
	        }
	    ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
	
	myChart.on('click', function (params) {
	    var name=params.name;
	    console.log(name);
	    mon=name.substring(0,name.indexOf("月"));
	    console.log(mon);
				var index = layui.layer.open({
					title : "添加客房",
					type : 2,
					content : "finaceMonth.html",
					success : function(layero, index){
						setTimeout(function(){
							layui.layer.tips('点击此处返回room列表', '.layui-layer-setwin .layui-layer-close', {
								tips: 3
							});
						},500)
					}
				})			
				layui.layer.full(index);
			})
	form.render();
}