<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>
<head>
<title>便利帖子</title>

<style type="text/css">
#scribble-pad {
       margin-left:auto;
       margin-right:auto;  
       height: 475px;
       width: 475px;
       background-image:url(imgs/stickynote_proc.jpg);
       background-repeat: no-repeat;
}  

#scribble {
      white-space: pre-wrap;       /* css-3 */
      white-space: -moz-pre-wrap;  /* Mozilla, since 1999 */
      white-space: -pre-wrap;      /* Opera 4-6 */
      white-space: -o-pre-wrap;    /* Opera 7 */
      word-wrap: break-word;       /* Internet Explorer 5.5+ */
      
      padding: 120px 100px 100px 75px;
      color: #486891;
      font-family:  Arial,sans-serif;
      font-size: 130%;
      font-style: italic; 
      font-weight:bold; 
      line-height: 1.5em;  
      border: 0px solid ; 
}

.c-link {
      color: #486891;
      font-family:  Arial,sans-serif;
      font-size: 95%;
      font-weight:bold; 
      text-decoration: none;         
}
</style>



<script type="text/javascript">
$(document).ready(function(){
	var url="handover/geMessage.do";
	$.getJSON(url,function(rs){
		  console.log(rs.data.message);
		  document.getElementById('scribble').innerHTML = rs.data.message;
	}) 
})

function storeUserScribble(id) {
  var scribble = document.getElementById('scribble').innerHTML;
  localStorage.setItem('userScribble',scribble);
}

function getUserScribble() {
  if ( localStorage.getItem('userScribble')) {
    var scribble = localStorage.getItem('userScribble');
  }
  else {
    var scribble = '你有事请在这留言... 并且你也可以在这写下你的日记一直保留下来哦!。。。。。。。。  管理员：刘备';
  }
  document.getElementById('scribble').innerHTML = scribble;
}

function clearLocal() {
  clear: localStorage.clear(); 
  return false;
}
</script>

</head>
<body>

<a class="c-link" onclick='javascript:clearLocal();'>清除留言</a>

<div id="scribble-pad"><div id="scribble" contenteditable="true"  onKeyUp="storeUserScribble(this.id);"></div></div>


<script>
  getUserScribble();
  $('#scribble').blur(function(){
	  var url="handover/setMessage.do";
	  var scribble = document.getElementById('scribble').innerHTML;
	  
	  $.getJSON(url,{"message":scribble},function(){
		  
	  })  
  })
</script>

</body>
</html>
