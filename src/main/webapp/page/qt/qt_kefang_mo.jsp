<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script language="JavaScript">
 $(document).ready(function(){
		//初始化所属项目的select列表
		//在模态框的对应按钮上注册事件
		$("#modal-dialog")
		.on("click",".ok",doSaveObject);
		//在模态框隐藏时解除事件的注册
		$("#modal-dialog")
		//hidden.bs.modal为固定写法表示模态框隐藏事件
		.on("hidden.bs.modal",function(){
			//.ok上移除click事件
			$(this).off("click",".ok");
			$(this).removeData("id");
		});
		//判定模态框上是否绑定了id值
		//var id=$("#modal-dialog").data("id");
		//if(id)doFindObjectById();
	});
 		function doSaveObject(){
 			  var check_name=form1.check_name.value.trim();
 	          var check_price=form1.check_price.value.trim();
 	          var id_number=form1.id_number.value.trim();
 	          var check_days=form1.check_days.value.trim();
 	          if(check_name==""||check_name==null||check_name=="null"){
 	             alert("客人姓名不能为空");
 	             return false;
 	          }
 	          if(id_number==""||id_number==null||id_number=="null"){
	             alert("证件号不能为空");
	             return false;
	          }else if(!IdCardValidate(id_number)){
	        	  alert("输入的证件号有误");
	        	  return false;
	          }
 	         if(check_days==""||check_days==null||check_days=="null"){
	             alert("入住天数不能为空");
	             return false;
	          }
	         if(check_price==""||check_price==null||check_price=="null"){
 	             alert("押金不能为空");
 	             return false;
 	          }
	        
	         var url2="kefang/ruzhu.do";
	         var params={"check_name":check_name};
	         params.check_price=check_price;
	         params.id_number=id_number;
	         params.check_days=check_days;
	         params.check_type=form1.check_type.value.trim();
	         params.check_source=form1.check_source.value.trim();
	         params.check_sex=form1.check_sex.value.trim();
	         params.certificate=form1.certificate.value.trim();
	         params.room_type=form1.room_type.value.trim();
	         params.checkru_type=form1.checkru_type.value.trim();
	         params.room_id=form1.room_id.value.trim();
	         params.room_price=form1.room_price.value.trim();
	         params.check_price=form1.check_price.value.trim();
	         console.log(params);
	        
	         $.getJSON(url2,params,function(rs){
	        	 alert(rs.message);
	        			
	        	 
	        	 $("#modal-dialog").modal("hide");
	        	/* var url="kefang.do?t="+Math.random(1000);
     			$(".right").load(url);
     			console.log($(".right")); */
     			$('#kefang').trigger('click');
	         });
 		}
 		
 		
 		var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];    // 加权因子   
 		var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];            // 身份证验证位值.10代表X   
 		function IdCardValidate(idCard) { 
 		    idCard = trim(idCard.replace(/ /g, ""));               //去掉字符串头尾空格                     
 		    if (idCard.length == 15) {   
 		        return isValidityBrithBy15IdCard(idCard);       //进行15位身份证的验证    
 		    } else if (idCard.length == 18) {   
 		        var a_idCard = idCard.split("");                // 得到身份证数组   
 		        if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){   //进行18位身份证的基本验证和第18位的验证
 		            return true;   
 		        }else {   
 		            return false;   
 		        }   
 		    } else {   
 		        return false;   
 		    }   
 		}   
 		/**  
 		 * 判断身份证号码为18位时最后的验证位是否正确  
 		 * @param a_idCard 身份证号码数组  
 		 * @return  
 		 */  
 		function isTrueValidateCodeBy18IdCard(a_idCard) {   
 		    var sum = 0;                             // 声明加权求和变量   
 		    if (a_idCard[17].toLowerCase() == 'x') {   
 		        a_idCard[17] = 10;                    // 将最后位为x的验证码替换为10方便后续操作   
 		    }   
 		    for ( var i = 0; i < 17; i++) {   
 		        sum += Wi[i] * a_idCard[i];            // 加权求和   
 		    }   
 		    valCodePosition = sum % 11;                // 得到验证码所位置   
 		    if (a_idCard[17] == ValideCode[valCodePosition]) {   
 		        return true;   
 		    } else {   
 		        return false;   
 		    }   
 		}   
 		/**  
 		  * 验证18位数身份证号码中的生日是否是有效生日  
 		  * @param idCard 18位书身份证字符串  
 		  * @return  
 		  */  
 		function isValidityBrithBy18IdCard(idCard18){   
 		    var year =  idCard18.substring(6,10);   
 		    var month = idCard18.substring(10,12);   
 		    var day = idCard18.substring(12,14);   
 		    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
 		    // 这里用getFullYear()获取年份，避免千年虫问题   
 		    if(temp_date.getFullYear()!=parseFloat(year)   
 		          ||temp_date.getMonth()!=parseFloat(month)-1   
 		          ||temp_date.getDate()!=parseFloat(day)){   
 		            return false;   
 		    }else{   
 		        return true;   
 		    }   
 		}   
 		  /**  
 		   * 验证15位数身份证号码中的生日是否是有效生日  
 		   * @param idCard15 15位书身份证字符串  
 		   * @return  
 		   */  
 		  function isValidityBrithBy15IdCard(idCard15){   
 		      var year =  idCard15.substring(6,8);   
 		      var month = idCard15.substring(8,10);   
 		      var day = idCard15.substring(10,12);   
 		      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
 		      // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
 		      if(temp_date.getYear()!=parseFloat(year)   
 		              ||temp_date.getMonth()!=parseFloat(month)-1   
 		              ||temp_date.getDate()!=parseFloat(day)){   
 		                return false;   
 		        }else{   
 		            return true;   
 		        }   
 		  }   
 		//去掉字符串头尾空格   
 		function trim(str) {   
 		    return str.replace(/(^\s*)|(\s*$)/g, "");   
 		}  
  </script>
<style >
	.aa{
		display: none;
	}
</style>

</head>


<body >
 
<form name="form1" action="" method="post" >
<table width="90%" border="0" align="center"  >
  <tr>
    <td width="258" height="36"  >姓名
      <input style=" height:25px;width: 85px;" name="check_name" type="text" />
      *</td>
    <td width="252">客人类型 <select name="check_type" style="width:80px; height:25px">
            <option value="散客">散 客</option>
            <option value="团体">团 体</option>
          </select>
    *		  </td>
    <td width="275">
    来源
    <select name="check_source" style="width:80px; height:25px">
            <option value="美团">美 团</option>
            <option value="自主">自 主</option>
           
          </select>
    *</td>
  </tr>
  <tr>
    <td height="32">
	 性别	
     <select name="check_sex" style="width:85px; height:25px">
            <option value="F">男</option>
            <option value="N">女</option>
           
          </select>
	 *</td>
    <td>
	
	证件类型
          
          <select name="certificate" style="width:80px; height:25px">
            <option value="身份证">身份证</option>
            <option value="护 照">护 照</option>
          </select>
          *	</td>
    <td>
	证件号
	 <input  name="id_number" type="text" style="width:150px;"/>*</td>
  </tr>
  <tr>
    <td height="40">
	房型
		 <input type="text" name="room_type" id="roomtype" value="" style="width:85px; "/>*
	 	</td>
    <td>
	入住类型	  
          <select name="checkru_type" style="width:80px; height:25px">
            <option value="普通入住">普通入住</option>
            <option value="午夜入住">午夜入住</option>
			<option value="钟点入住">钟点入住</option>
          </select>
          *	</td>
    <td>

	入住天数
	  <input type="text" name="check_days" value="1" style="width:85px; "/>
	  *	</td>
  </tr>
  <tr>
      <td height="32">客房号 
      
      <input type="text" name="room_id" id="roomid" value=" " style="width:85px; "/>*
      </td>
      <td >客房价格
      <input type="text" name="room_price" id="roomjg" value="" style="width:85px; "/>*
      </td>
      <td>押金 <input type="text" name="check_price" value="200" style="width:85px; "/>*</td>
    
  </tr>
  <script>
  	function tj(){
  		var cz=document.getElementById("cz");
  		cz.className="display: none;";
  				
  		console.log(cz);
  		
  	}
  </script>
  <tr>
  <td colspan="3">
       <input type="button" name=aa value="添加常信息+" onclick="tj();"/>
  </td>
  </tr>
  <tr id="cz" class="aa">
   <td>姓名 <input type="text" name="chname"  style="width:85px; "/>*</td>
   <td> 证件类型 <select name="chtype" style="width:80px; height:25px">
            <option value="1">身份证</option>
            <option value="2">护 照</option>
          </select>*</td>
  <td>证件号 <input type="text" name="chtypeid" value="" style="width:150px; "/>*</td>
  </tr>

   
</table>

</form>