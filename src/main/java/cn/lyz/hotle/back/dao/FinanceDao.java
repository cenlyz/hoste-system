package cn.lyz.hotle.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.back.entity.Finance;

@Repository("financeDao")
@MyBatisRepository
public interface FinanceDao {
	List<Finance> findFinanceList(@Param("year") String year,
			@Param("month") String month,
			@Param("day") String day);
	List<Finance> findFinanceTime();
	/** 柱状图报表*/
	List<Finance> findFinanceMonth(@Param("year") Integer year);
	/** 折线图*/
	List<Finance> findFinanceYearMonth(@Param("year") Integer year,
			@Param("month") Integer month);
	/** 添加客房入住金额*/
	int updateFinace(Finance f);
}
