<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="data">
<ul>
<!-- 	<li><a href="#">回到首页</a></li> -->
	<li><a id="load_book">预定</a></li>
	<li><a id="kefang">客房</a></li>
	<li><a id="member">会员</a></li>
	<li><a id="message">留言</a></li>
	<li><a id="handover">交班</a></li>
</ul>
</div>
<script type="text/javascript">
$('#load_book').click(function(){
	var url="book.do?t="+Math.random(1000);
	$(".right").load(url);
});
$('#kefang').click(function(){
	var url="kefang.do?t="+Math.random(1000);
	$(".right").load(url);
});
$('#member').click(function(){
	var url="member/member.do?t="+Math.random(1000);
	$(".right").load(url);
});
$('#handover').click(function(){
	var url="page/qt/qt_handover.html?t="+Math.random(1000);
	$(".right").load(url);
});
$('#message').click(function(){
	var url="handover/message.do?t="+Math.random(1000);
	$(".right").load(url);
});
</script>
