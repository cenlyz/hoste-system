<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>index.html</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="${basePath}css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${basePath}css/jquery-ui.css" />
    <link rel="stylesheet" href="${basePath}layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${basePath}css/front.css">
    <link rel="stylesheet" type="text/css" href="${basePath}css/qianta.css">
    
    <script src="${basePath}js/jquery-1.11.1.js"></script>
	<script src="${basePath}js/jquery-ui.js"></script>
    <script src="${basePath}js/jquery-3.2.1.min.js"></script>
    
    
    
   
  </head>
  
  <body>
  <!-- top -->
    <div class="top">
    	<%@include file="qt/qt_top.jsp" %>
    </div>
    <!-- 导航栏 -->
    <div class="menu">
    	<%@include file="menu.jsp" %>
    </div>
    <!-- 主体 -->
    <div class=content>
    	<!-- 数据区 -->
    		<%@include file="qt/qt_menu.jsp" %>
    	<!-- 右边区 -->
    	<div class="right">
    		<img alt="" src="imgs/hh.jpg" style="width: 1220px;height: 530px;">
    	</div>
    	
    </div>
    <!-- 版权 -->
    <div class="bot">
        <%@include file="qt/qt_bot.jsp" %>
    </div>
    
    
    
   <!-- 弹出框 -->  
<div class="modal" id="mymodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header  mo_colse">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				<h4 class="modal-title mo_title" >请留下你想说的话</h4>
			</div>
			<div class="modal-body">
				<!-- 弹出窗主体内容 -->
				<div class="mo_content">
					<div class="mo_co_top">
						类型：&nbsp;
						<select class="mo_select" name="">
						<option value="0">请选择</option>
						<option value="1">客房类</option>
						<option value="2">营业类</option>
						<option value="3">事务类</option>
						<option value="4">其他</option>
						</select>
						&nbsp;&nbsp;标题&nbsp;:&nbsp;&nbsp;<input type="text" placeholder="不能超过25个字"/>
					</div>
					<div >
						<textarea  name="" class="mo_co_data" cols="49" rows="7"> 请写下你想说的话!</textarea>
					</div>
					<div></div>
				</div>
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary">保存</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  
    
    
  <!-- Modal(模态框) -->
 <div class="modal fade yyyyyy" id="modal-dialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <!-- 此位置放置具体页面的位置 -->
      <div class="modal-body"></div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary ok">提交</button>
      </div>
    </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- modal -->
	</div>  
    
    
    
    
    
    
  </body>

<script src="${basePath}js/jquery-1.11.1.js"></script>
<script src="${basePath}js/jquery.min.js"></script>
<script src="${basePath}js/bootstrap.min.js"></script>  
</html>

