package cn.lyz.hotle.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lyz.hotle.login.dao.HandoverDao;
import cn.lyz.hotle.login.entity.Handover;
import cn.lyz.hotle.login.service.HandoverService;

@Service
public class HandoverServiceImpl implements HandoverService {

	@Resource(name = "handoverDao")
	private HandoverDao dao;
	
	public void addHandover(Handover handover) {
		if(handover==null){
			throw new RuntimeException("交班信息为空不能插入");
		}
		int row=dao.addHandover(handover);
		if(row<1){
			throw new RuntimeException("交班失败");
		}
	}

}
