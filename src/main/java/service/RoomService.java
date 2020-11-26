package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoomDaoImpl;
import domain.RoomDomain;
import entity.Room;

@Service
public class RoomService {
	
	@Autowired
	RoomDaoImpl roomDaoImpl;
	
	public void addOneRoom(RoomDomain roomDomain) {
		roomDaoImpl.addOneRoom(roomDomain);
	}
	public ArrayList<Room> queryAllRoomPageOn(String limit,String page){
		return roomDaoImpl.queryAllRoomPageOn(limit,page);
	}
	public ArrayList<Room> queryAllRoom(){
		return roomDaoImpl.queryAllRoom();
	}
	public void delOneRoom(String roomId) {
		// TODO Auto-generated method stub
		roomDaoImpl.delOneRoom(roomId);
	}
	public void updateOneRoom(String filed, String value,String roomId) {
		// TODO Auto-generated method stub
		roomDaoImpl.updateOneRoom(filed,value,roomId);
	}
}
