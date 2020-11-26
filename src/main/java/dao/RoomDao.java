package dao;

import java.util.ArrayList;

import domain.RoomDomain;
import entity.Room;

public interface RoomDao {
	public void addOneRoom(RoomDomain roomDomain);
	public void delOneRoom(String roomId);
	public void updateOneRoom(String filed,String value,String roomId);
	public ArrayList<Room> queryAllRoom();
	public ArrayList<Room> queryAllRoomPageOn(String limit,String page);
	
}
