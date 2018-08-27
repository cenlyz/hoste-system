package cn.lyz.hotle.back.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.back.entity.Trade;

@Repository("tradeDao")
@MyBatisRepository
public interface TradeDao {
	/** ¿â´æ²éÑ¯*/
	List<Trade> findTradeObjects();
	/** Ä£ºý²éÑ¯*/
	List<Trade> findTradeByIdObjects(@Param("goods_id") String goods_id);
	/** ÐÞ¸Ä¿â´æ*/
	int editGoods(Trade trade);
	/** Ìí¼Ó¿â´æ*/
	int addGoods(Trade trade);
	/** ¸ü¾ßIDÉ¾³ý¿â´æ*/
	int delGoodsById(@Param("id") Integer id);
}
