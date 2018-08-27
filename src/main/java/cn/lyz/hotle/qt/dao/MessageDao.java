package cn.lyz.hotle.qt.dao;

import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.Message;

@Repository("messageDao")
@MyBatisRepository
public interface MessageDao {
	/** ÃÌº”¡Ù—‘*/
	int insertMessage(Message message);
	/** ≤È—Ø¡Ù—‘*/
	Message findMessage();
}
