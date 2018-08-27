package cn.lyz.hotle.back.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.back.entity.Trade;

public interface TradeService {
	/** ¿â´æ²éÑ¯*/
	List<Trade> findTradeObjects();
	/** Ä£ºý²éÑ¯*/
	List<Trade> findTradeByIdObjects( String goods_id);
	/** ÐÞ¸Ä¿â´æ*/
	void editGoods(Trade trade);
	/** Ìí¼Ó¿â´æ*/
	void addGoods(Trade trade);
	/** ¸ü¾ßIDÉ¾³ý¿â´æ*/
	void delGoodsById(@Param("id") Integer id);
}
