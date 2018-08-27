package cn.lyz.hotle.qt.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Check;
import cn.lyz.hotle.qt.entity.Hotel;
import cn.lyz.hotle.qt.entity.Room;

public interface KefangService {
	List<Room> findRoomObjects(String site);
	List<Room> findRoomSite();
	Room findRoomById(Integer id);
	void insertCheck(Check check);
	void updateRoom( String roomid);
	Map<String, Object> findcheckByIdAndRoom(Integer id, String room_id);
	void updateRoomState(Integer id);
	/** 更新客人入住状态*/
	Check updateChecktate(String room_id,String id);
	/** 查询酒店信息*/
	Hotel findHotel();
	/** 查询所有客房信息*/
	List<Room> findRooms();
	/** 更具客房号查询客房信息*/
	List<Room> findRoomsById(String room_id);
	/** 添加客房信息*/
	void insertRoom(Room room);
	/** 修改客房信息*/
	void updateRoomById(Room room);
	/** 删除客房信息*/
	void roomDelById( Integer id);
	/** 查询预定信息*/
	BookRoom findRoomByRoomId(String room_id);

}
