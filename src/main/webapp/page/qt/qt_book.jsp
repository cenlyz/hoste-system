<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="${basePath}js/jquery-1.11.1.js"></script>
	<link rel="stylesheet" href="${basePath}css/jquery-ui.css" />
	<script src="${basePath}js/jquery-ui.js"></script>
<div class="c_r_left cr_left" >
	<div class="yu_ding">
		<li >姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input id="book_name" type="text" placeholder="请输入姓名"></li>
		<li >电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input id="book_tel" type="text" placeholder="请输入电话"></li>
		<li>入住时间：<input class="date" id="datepicker" type="text" value="Check In" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Check In';}"></li>
		<li>离店时间：<input class="date1" id="datepicker1" type="text" value="Check Out" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Check Out';}"></li>
		<li>房间类型：
			<select id="book_type"  style="height:29px; width: 250px;">
				<option value="标准单价">标准单价</option>
			</select>
		</li>
		<li>房间数量：
			<select id="book_count"  style="height:29px; width: 250px;">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
		</li>
		<li>预交订金：<input id="book_mon" type="text" value="100"></li>
		<li class="sub"><a id="book_submit" >提&nbsp;交</a></li>
	</div>
	<div class="yd_right">
		<li><img src="${basePath}imgs/a1.jpg"></li>
		<li><img src="${basePath}imgs/a2.jpg"></li>
	</div>
</div>
 <div class="c_r_right k_right">
 	<img alt="" src="${basePath}imgs/yddd.jpg">
 </div>
 		
 <div class="c_bot">
	
	<div class="c_b_right c_b_right_ul">
		<ul id="c_b_right_ul">
		</ul>
	</div>
</div>
<script src="${basePath}qt_js/ri_qi.js"></script>
<script src="${basePath}qt_js/book.js"></script>
    	