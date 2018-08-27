package cn.lyz.hotle.login.dao;

import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.login.entity.Handover;

@Repository("handoverDao")
@MyBatisRepository
public interface HandoverDao {
	int addHandover(Handover handover);
}
