/**自定义模块*/
layui.define(['layer','params'], function (exports) {
    var format = {
        parseDate : function( dateString, format ){
        	var year=2000,month=0,day=1,hour=0,minute=0,second=0;
        	format = format ||  "yyyymmdd";
        	var matchArray = format.match( new RegExp(/(yyyy|mm|dd|hh|mi|ss|ms)/gi) );
        	for (var i = 0; i < matchArray.length; i++ ) {
        		var postion =format.indexOf( matchArray[i] );
        		switch (matchArray[i]) {
        			case "yyyy":{
        				year = parseInt( dateString.substr(postion,4), 10 );
        				break;
        			}
        			case "mm":{
        				month = parseInt( dateString.substr(postion,2), 10 )-1;
        				break;
        			}
        			case "dd":{
        				day = parseInt( dateString.substr(postion,2), 10 );
        				break;
        			}
        			case "hh":{
        				hour = parseInt( dateString.substr(postion,2), 10 );
        				break;
        			}
        			case "mi":{
        				minute = parseInt( dateString.substr(postion,2), 10 );
        				break;
        			}
        			case "ss":{
        				second = parseInt( dateString.substr(postion,2), 10 );
        				break;
        			}
        		}
        	}
        	return new Date(year,month,day,hour,minute,second);
        },
        formatDate : function(dateString,inputFormat,outputFormat){
    		if(!inputFormat){
    			inputFormat = "yyyymmdd";
    		}
    		if(!outputFormat){
    			outputFormat = "yyyy-mm-dd";
    		}
    		var currentDate = null;
    		if(dateString){
    			currentDate = this.parseDate(dateString,inputFormat);
    		}else{
    			currentDate = new Date();
    		}
    		
    		var regexp=new RegExp(/(yyyy|yy|mm|dd|hh|mi|ss|ms)/gi);
    		var result = outputFormat.replace(regexp, function(str){
    			switch(str.toLowerCase()){
    			case 'yyyy':
    				return currentDate.getFullYear();
    			case 'yy':
    				return currentDate.getFullYear().toString().substr(2,2);
    			case 'mm':
    				return this.leftPadZero((currentDate.getMonth() + 1).toString(),2);
    			case 'dd':
    				return this.leftPadZero(currentDate.getDate().toString(),2);
    			case 'hh':
    				return this.leftPadZero(currentDate.getHours().toString(),2);
    			case 'mi':
    				return this.leftPadZero(currentDate.getMinutes().toString(),2);
    			case 'ss':
    				return this.leftPadZero(currentDate.getSeconds().toString(),2);
    			case 'ms':
    				return this.leftPadZero(currentDate.getMilliseconds().toString(),3);
    			}
    		}.bind(this));
    		return result;
    	},
    	
    	leftPadZero : function(str,width){
    		var pad = width - str.length;
    		if(pad > 0){
    			return (this.times("0",pad) + str);
    		}
    		return str;
    	},
    	
    	times : function(str,times){
    		if(times < 1){
    			times = 1;
    		}
    		var ret = "";
    		while(times){
    			ret += str;
    			times--;
    		}
    		return ret;
    	},
    	
    	getParamDisplay : function(key,value){
    		var array = layui.params[key];
    		if(!array) return "";
    		for(var i =0 ; i < array.length ; i++){
    			if(array[i].value == value){
    				return array[i].name;
    			}
    		}
    		return value;
    	},
    	getSelect : function( key, selectCode, filter, blankSelect ){
    		var html="";
    		var array = layui.params[key];
    		if ( !array ){
    			alert( "Param: " + key + " not defined!");
    			return null;
    		}
    		if(blankSelect)
    			html += "<option value=''>请选择</option>";
    		
    		for( var i = 0, leng =array.length; i<leng; i++ ){
    			var item = array[i];
    			var value = item.value;
    			var text = item.name;
    			if(filter){
    				if(filter.include(key))
    					continue;
    			}
    			
    			if ( selectCode && selectCode == value ){
    				html += "<option value='"+value+"' selected='selected'>"+text+"</option>";
    			}else{
    				html += "<option value='"+value+"' >"+text+"</option>";
    			}
    		}
    		return html;
    	},
    	getSelectByList : function(array, keyField, valueField, selectCode, filter, blankSelect ){
    		var html="";
    		if ( !array ){
    			alert( "array not defined!");
    			return null;
    		}
    		if(blankSelect)
    			html += "<option value=''>请选择</option>";
    		
    		for( var i = 0, leng =array.length; i<leng; i++ ){
    			var item = array[i];
    			var key = item[keyField];
    			var value = item[valueField];
    			if(filter){
    				if(filter.include(key))
    					continue;
    			}
    			
    			if ( selectCode && selectCode == key ){
    				html += "<option value='"+key+"' selected='selected'>"+value+"</option>";
    			}else{
    				html += "<option value='"+key+"' >"+value+"</option>";
    			}
    		}
    		return html;
    	}
    };
    exports('format', format);
});



