<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="${basePath}css/front.css">
    <script src="${basePath}qt_js/kefang.js"></script>
<!-- 右边区 -->
    	<div class="right ">
    		<div class="c_r_left cr_left cr_left_gai" style="overflow:auto;" id="qt_kefang">
	    		
	    	
    		</div>
    		<div class="c_r_right k_right cr_left_gai">
    			<div class="k_right_js">
    				<ul>
    					<li class="k_right_js_li1"><p>房间解锁</p></li>
    					<hr>
    					<li style="margin-top: 10px;">房&nbsp;&nbsp;间&nbsp;号：<span id="check_k_li1"></span></li>
    					<li style="margin-top: 10px;">房间楼层：<span id="check_k_li2"></span></li>
    					<li style="margin-top: 10px;">客人姓名：<span id="check_k_li3"></span></li>
    					<li style="margin-top: 10px;">入住时间：<span id="check_k_li4"></span></li>
    					<li style="margin-top: 10px;">押&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金：<span id="check_k_li5"></span></li>
    					<li style="margin-top: 10px;">预住天数：<span id="check_k_li6"></span></li>
    					<li style="margin-top: 10px;">当前入住天数：<span id="check_k_li7"></span></li>
    					<li style="margin-top: 10px;"><button type="button" class="btn btn-info" onclick="return tf();">点击退房</button></li>
    				</ul>
    				<br>
    				<p style="margin: 0 0 5px;">颜色表示：</p>
    				<ul class=" c_k_ul1 ">
		    			<li class="qt_li0"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;空房</li>
		    			<li class="qt_li1"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已入住</li>
		    			<li class="qt_li2"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未打扫</li>
		    			<li class="qt_li3"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已预定</li>
		    		</ul>
		    		</div>
    			</div>
    		
    		</div>
    </div>