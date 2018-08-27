<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="${basePath}qt_js/member_list.js"></script>
<script src="${basePath}common/page.js"></script>
<body>
	<!-- 右上区 -->
    		<div class="ri_left">
    			<li class="hu_h1" data-toggle='modal' data-target='#denglu'><p><span> 会员添加</span></p></li>
<!--     			<li class="hu_h2"><p><span>黄金会员</span></p></li> -->
<!--     			<li class="hu_h3"><p><span>砖石会员</span></p></li> -->
<!--     			<li class="hu_h4"><p><span>会员列表</span></p></li> -->
    		</div>
    		<!-- 右下区 -->
    		<div class="ri_right">
    			<div class="ri_huiyuan_top">
    				<form action="">
    					<p class="hy_top_p" >请输入你的搜索条件：</p>
    					<table >
    						<tr style="height: 45px;">
    							<td>会员号：<input type="text" class="hy_inpt" name="m_id" id="id" /></td>
    							<td>
    							电话号码：<input type="text" class="hy_inpt" name="check_tel" id="tel" />
    							</td>
    							<td >
    								<input type="button" class="layui-btn " value="搜索" id="search" />
    							</td>
    						</tr>
    						
    					</table>
    				</form>
    			</div>
    			<div class="ri_huiyuan_bot">
    			
    			<table border="1">
    			<thead>
    				<tr class="din_lie">
    					<td>序号</td>
    					<td>会员号</td>
    					<td>姓名</td>
    					<td>电话</td>
    					<td>剩余金额</td>
    					<td>积分</td>
    					<td>会员类型</td>
    					<td>状态</td>
    					<td>操作</td>
    				</tr>
    				</thead>
    				<!-- ajax异步获得,并将数据填充到tbody中 -->
					<tbody id="tbodyId">
    		
    				
    				</tbody>
    				</table>
    			</div>
    			<div class="fenye">
    			<p>
    				<%@include file="../page.jsp" %>
    			</p>
    			</div>
    		</div>
    	</div>
    	
<%@include file="qt_member_mo.jsp" %>
    	
</body>
</html>