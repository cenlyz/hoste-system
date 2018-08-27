$(document).ready(function(){
	getvip();
	doMemberAdd();
	$("#modal-dialog-me").on("click",".ok",doSaveOrUpdate);

});

function getvip(){
	$("#m2").click(function(){
		$("#vip").val("砖石vip");
	});
	$("#m1").click(function(){
		$("#vip").val("黄金vip");
	});	
	$("#m0").click(function(){
		$("#vip").val("普通vip");
	});
}
function doSaveOrUpdate(){
	var params=getInputValues();
	if(params){
		var url="member/addMeber.do";
		$.getJSON(url,params,function(rs){
		//	$(".off").trigger('click');
			if(rs.message){
				if(rs.message=="ok"){
					alert("添加会员成功");
					$("#moform")[0].reset();
//					 $("#modal-dialog").modal("hide");
//					console.log($("#modal-dialog"));
//					$("#modal-dialog").on("hidden.bs.modal",function(){
//						//.ok上移除click事件
//						$(this).off("click",".ok");
//						$(this).removeData("id");
//					});
					$("#member").trigger('click');
					return;
				}
				alert(rs.message);
			}
		});
			
	}
};
//获取文本框的值
function getInputValues(){
	var name=$("#m_name").val();
	var phone=$("#check_tel").val();
	var idnum=$("#id_number").val();
	var mid=$("#m_id").val();
	var sex=$("input[name='check_sex']:checked").val();
	var price=$("input[name='m_price']:checked").val();
	var type=$("#vip").val();
	if(name==null||name==""){
		alert("姓名不能为空");
		return false ;
	}
	if(!(/^1[34578]\d{9}$/.test(phone))){ 
        alert("手机号码有误，请重填");  
        return false; 
    } 
	if(!IdCardValidate(idnum)){
		alert("身份证号码有误");
		return false;
	}
	if(mid==null||mid==""){
		alert("会员号不能为空");
		return false;
	}
	var params={"check_name":name};
	params.check_tel=phone;
	params.id_number=idnum;
	params.m_id=mid;
	params.check_sex=sex;
	params.m_price=price;
	params.m_type=type;
	return params;
	
	
}

function doMemberAdd(){
	var v=$("#m_name").val();
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

	