 $(function() {
	 $("#datepicker").datepicker({
		 onSelect:function(dateText,inst){
			 $("#datepicker1").datepicker("option","minDate",dateText);
		 }
	 });
	 $("#datepicker1").datepicker({
		 onSelect:function(dateText,inst){
			 $("#datepicker").datepicker("option","maxDate",dateText);
		 }
	 });
 });