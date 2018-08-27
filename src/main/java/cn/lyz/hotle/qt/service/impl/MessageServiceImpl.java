package cn.lyz.hotle.qt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.qt.dao.MessageDao;
import cn.lyz.hotle.qt.entity.Message;
import cn.lyz.hotle.qt.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Resource(name="messageDao")
	MessageDao dao;

	public void insertMessage(Message message) {
		if(message==null){
			throw new RuntimeException("√ª”–¡Ù—‘ƒ⁄»›");
		}
		int row=dao.insertMessage(message);
		if(row<1){
			throw new RuntimeException("ÃÌº”¡Ù—‘ ß∞‹");
		}
		
	}

	public Message findMessage() {
		
		return dao.findMessage();
	}
	
}
