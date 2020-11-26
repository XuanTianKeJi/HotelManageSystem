package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.RoomDomain;
import entity.Room;
import service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@RequestMapping("/addRoom")
	public String addRoomInit() {
		return "room/addRoom";
	}

	@RequestMapping("/addRoom.do")
	public String addRoom(Room room) {
		RoomDomain roomDomain = room.toRoomDomain();
		
		System.out.println(room.toString());
		
		roomService.addOneRoom(roomDomain);
		
		return "system/success";
	}
	
	@ResponseBody
	@RequestMapping("/roomList.do")
	public Map<String,Object> queryAllRoom() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Room> l = roomService.queryAllRoom();
		 map.put("code",0);
	     map.put("msg","房间列表");
	     map.put("count",l.size());
	     map.put("data",l);
		return map;
	}
	

	@ResponseBody
	@RequestMapping("/roomListPageOn.do")
	public Map<String,Object> queryAllRoomPageOn(String limit,String page) {
		
		
		ArrayList<Room> lAll = roomService.queryAllRoom();
		
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Room> l = roomService.queryAllRoomPageOn(limit,page);
		 map.put("code",0);
	     map.put("msg","房间列表");
	     map.put("count",lAll.size());//注意接口需要传递表中数据的条数
	     map.put("data",l);
		return map;
	}
	@RequestMapping("/roomList")
	public String queryRoomList() {
		return "room/roomList";
	}
	
	
	@RequestMapping("/delRoom.do")
	public String delRoom(String roomId) {
		
		roomService.delOneRoom(roomId);
		return " ";
	}
	@RequestMapping("/updateRoom.do")
	public String updateRoom(String roomId,String filed,String value) {
		
		roomService.updateOneRoom(filed, value, roomId);
		return " ";
	}
}
