package cn.lyz.hotle.back.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.back.dao.FinanceDao;
import cn.lyz.hotle.back.entity.Finance;
import cn.lyz.hotle.back.service.FinanceService;

@Service("financeServiceImpl")
public class FinanceServiceImpl implements FinanceService {
	@Resource(name="financeDao")
	FinanceDao dao;

	public List<Finance> findFinanceList(String year, String month, String day) {
		return dao.findFinanceList(year, month, day);
	}

	public List<Finance> findFinanceTime() {
		List<Finance> list=dao.findFinanceTime();
		Map<String, Object> map=new HashMap<String, Object>();
		for(Finance f:list){
			if(f.getType()==null){
				
			}else{
				System.out.println(f.getType());
				map.put("time", f.getTime());
				map.put("type",f.getType() );
				
				
			}
		}
		System.out.println(map);
		System.out.println(list);
		return null;
	}

	public List<Finance> findFinanceMonth(Integer year) {
		List<Finance> list=dao.findFinanceMonth(year);
		List<Finance> list2=new ArrayList<Finance>();
		int i=0;
       for(int n=0;n<list.size();n++){
    	   ++i;
     	  while (i!=list.get(n).getMonth()) {//往集合里面添加没有的月份
           Finance f=new Finance();
      	   f.setMoney("0");
      	   list2.add(f);
 			i++;
 		}
     	 list2.add(list.get(n));
       }
		return list2;
	}

	public List<Finance> findFinanceYearMonth(Integer year, Integer month) throws Exception {
		if(year==null){
			throw new RuntimeException("显示年份为空");
		}
        if(month==null){
        	throw new RuntimeException("显示月份为空");
		}
        List<Finance> list=dao.findFinanceYearMonth(year, month);
        List<Finance> list2=new ArrayList<Finance>();
       int i=0;
       for(int n=0;n<list.size();n++){
    	   ++i;
     	  while (i!=list.get(n).getDay()) {//往集合里面添加没有的月份
               Finance f=new Finance();
      	   f.setDay(i);f.setMoney("0");
      	   list2.add(f);
 			i++;
 		}
     	 list2.add(list.get(n));
       }
	   return list2;
	}
	
    public static int getDaysOfMonth(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
    }  
}
