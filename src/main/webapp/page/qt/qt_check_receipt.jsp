<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
  a{
	color:#F00;
   }
</style>
</head>
<body>
<%
java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
java.util.Date currentTime = new java.util.Date();//得到当前系统时间
String str_date1 = formatter.format(currentTime); //将日期时间格式化

 %>

<input type="button" value="打  印" onclick="daying();" />
<a ><input type="button" value="返  回" onclick="fanhui();" /></a>
<br />

<table width="800" border="0" align="center">
  <tr>
  <td>&nbsp;</td>
  <td></td>
  <td colspan="2"><h2 style="font-size: 24px">住 宿 登 记 表</h2></td>
  <td></td>
  <td align="center" style="color:#F00; font-size:20px; font-family:Verdana, Geneva, sans-serif"><a style="color: #000">NO:</a> ${check.check_id }</td>
  
  </tr>
  
  <tr>
    <td width="77">店 名</td>
    <td width="159"><a>${hotel.h_name}</a></td>
    <td width="68">房 号</td>
    <td width="127"><a>${check.room_id} </a></td>
    <td width="49">日 期</td>
    <td width="159" ><a> <%=str_date1 %> </a></td>
  </tr>
</table>

<table width="800"  border="1"  cellspacing="0" cellpadding="0" bordercolordark="#FFFFFF" bordercolorlight="#000000" align="center">
  
  <tr>
    <td width="100" height="31">姓 名</td>
    <td width="200"><a>${check.check_name}  </a></td>
    <td width="50">性 别</td>
    <td width="118"><a><c:if test="${check.check_sex=='F'}">男</c:if>
    <c:if test="${check.check_sex=='N'}">女</c:if>
     </a></td>
    <td width="75">来  源</td>
    <td width="138">
    <a>${check.check_source}</a>
    </td>
  </tr>
  <tr>
    <td height="32">客人类型</td>
    <td>${check.check_type}</td>
    <td>房 费</td>
    <td>${check.check_price}</td>
    <td>押 金</td>
    <td><a>100 </a></td>
  </tr>
  <tr>
    <td height="32">身份证号</td>
     <td colspan="5"><a> ${check.id_number} </a></td>
  </tr>
 
  <tr>
    <td height="33">住宿时间</td>
    <td colspan="2"><a> ${check.rtime} </a></td>
    <td colspan="3" rowspan="2"><div align="justify">备注：
        <form id="form1" name="form1" method="post" action="">
        <label for="textarea"></label>
        <textarea name="textarea" id="textarea" cols="45" rows="5"></textarea>
      </form>
    </div></td>
  </tr>
 <tr>
    <td>温馨提示</td>
    <td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为了您的健康和安全，请不要在客房进行黄赌毒。为了您的财产安全，请自行妥善保管好您随身的贵重物品，如有遗失，本酒店概不负责！当您需要酒店服务时，请直接拨打总机号码&ldquo;0&rdquo;，我们随时为您服务！</td>
  </tr>
</table>
<table width="800" border="0" align="center">
  
  <tr>
    <td width="200">旅客签名:</td>
    <td width="200">&nbsp;</td>
    <td width="200">酒店地址：</td>
    <td width="200">${hotel.h_site }</td>
   
  </tr>
</table>

<br>
<br>
<br>
<hr>
<input type="hidden" value="${check.remarke}" id="aaa"/>
<p style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
${check.remarke}</p >
</body>
</html>
