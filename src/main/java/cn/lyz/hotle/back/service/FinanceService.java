package cn.lyz.hotle.back.service;

import java.util.List;


import cn.lyz.hotle.back.entity.Finance;

public interface FinanceService {
	/** 查询报表*/
	List<Finance> findFinanceList( String year,String month, String day);
	/** 图形报表*/
	List<Finance> findFinanceTime();
	/** 柱状图报表*/
	List<Finance> findFinanceMonth( Integer year);
	/** 折线图
	 * @throws Exception */
	List<Finance> findFinanceYearMonth(Integer year, Integer month) throws Exception;
}
