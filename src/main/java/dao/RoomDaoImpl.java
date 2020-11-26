package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.RoomDomain;
import entity.Room;
import utils.DBUtil;
@Component
public class RoomDaoImpl implements RoomDao {
	@Autowired
	DBUtil dBUtil;
	
	@Override
	public void addOneRoom(RoomDomain roomDomain) {
		// TODO Auto-generated method stub
		dBUtil.executeProcedure("{call AddOneRoom(?,?,?,?)}", roomDomain.toArray());
	}

	@Override
	public ArrayList<Room> queryAllRoom() {
		// TODO Auto-generated method stub
		ArrayList<Room> list = new ArrayList<Room>();
		ResultSet rs  = dBUtil.executeProcedure("{call SelectAllRooms}");
		try {
			while(rs.next()) {
				list.add(new Room(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	
	}

	@Override
	public ArrayList<Room> queryAllRoomPageOn(String limit, String page) {
		ArrayList<Room> list = new ArrayList<Room>();
		String sql = " SELECT TOP "+limit+ "* FROM Rooms " + 
				" WHERE RoomId" + 
				" NOT IN " + 
				"(SELECT TOP "+String.valueOf(((Integer.valueOf(page)-1)*Integer.valueOf(limit)))+" RoomId FROM Rooms)";
		
		
		
		ResultSet rs  = dBUtil.excuteQuery(sql);
		try {
			while(rs.next()) {
				list.add(new Room(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public void delOneRoom(String roomId) {
		// TODO Auto-generated method stub
		dBUtil.executeProcedure("{call DeleteOneRoom(?)}", new Object[] {roomId});
	}

	@Override
	public void updateOneRoom(String filed, String value,String roomId) {
		// TODO Auto-generated method stub
		String sql;
		if(filed.equals("roomPrice")) {
		sql = "update Rooms set "+filed+" = "+value+" where RoomId = '"+roomId+"'";
		}else {
			sql = "update Rooms set "+filed+" = '"+value+"' where RoomId = '"+roomId+"'";
		}
		dBUtil.excuteUpdate(sql);
	}

}
