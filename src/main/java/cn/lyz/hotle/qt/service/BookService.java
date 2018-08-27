package cn.lyz.hotle.qt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.lyz.hotle.qt.entity.BookRoom;
import cn.lyz.hotle.qt.entity.Room;

public interface BookService {
	/**查询客房类型*/
	 List<Room> findBookRoomType();
	 /**客房预定*/
	 void insertBook(BookRoom bookRoom);

}
