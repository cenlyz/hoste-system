package cn.lyz.hotle.qt.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Room;

@Repository("kefangDao")
@MyBatisRepository
public interface KefangDao {
	/** 查询所有客房信息*/
	List<Room> findRoomObjects(@Param("room_site") String room_site);
	/** 查询所有客房的所在的楼层信息*/
	List<Room> findRoomSite();
	/** 查询所有客房信息*/
	List<Room> findRooms();
	/** 更具id查询客房信息*/
	Room findRoomById(@Param("id") Integer id);
	/** 更具客房号查询客房信息*/
	List<Room> findRoomsById(@Param("room_id") String room_id);
	/** 更具客房号查询预定信息*/
	BookRoom findRoomByRoomId(@Param("room_id") String room_id);
	/** 添加客人入住信息*/
	
	int insertCheck(Check check);
	/** 更新客房为入住状态*/
	int updateRoom(@Param("room_id") String room_id);
	/** 查询当前客房入住客人信息*/
	Check findcheckByIdAndRoom(@Param("room_id") String room_id);
	/** 更具id更新房间状态为空房状态*/
	int updateRoomState(@Param("id") Integer id);
	/** 更具客房号更新房间为空房状态*/
	int updateRoomIdState(@Param("room_id") String room_id);
	/** 客人退房对更新Check*/
	int updateChecktate(@Param("room_id") String room_id,@Param("time") Date time);
	/** 查询酒店信息*/
	Hotel findHotel();
	/** 添加客房信息*/
	int insertRoom(Room room);
	/** 修改客房信息*/
	int updateRoomById(Room room);
	/** 删除客房信息*/
	int roomDelById(@Param("id") Integer id);
	/** 查询入住时间 和入住的价格*/
	Check findChecktimeAndMoney(@Param("room_id") String room_id);

}
