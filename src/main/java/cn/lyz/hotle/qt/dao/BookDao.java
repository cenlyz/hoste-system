package cn.lyz.hotle.qt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.lyz.hotle.annotations.MyBatisRepository;
import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Room;

@Repository("bookDao")
@MyBatisRepository
public interface BookDao {
	 List<Room> findBookRoomType();
	 int insertBook(BookRoom bookRoom);
	 /** 查询预定房间类型的数量*/
	 List<Room> findRoomCount(@Param("type") String type);
	 /** 更新预定状态*/
	 int updateRoomID(@Param("roomId") String roomId,@Param("bookId") Integer bookId);
	 
	 int findMaxId();
}
