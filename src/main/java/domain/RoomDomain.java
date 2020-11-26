package domain;

import java.math.BigDecimal;
import java.util.Arrays;

import entity.Room;

public class RoomDomain {
	String RoomId;
	String RoomType;
	String RoomStatus;
	BigDecimal RoomPrice;
	
	
	public RoomDomain() {
		super();
	}

	public RoomDomain(String roomId, String roomType, String roomStatus, BigDecimal roomPrice) {
		super();
		RoomId = roomId;
		RoomType = roomType;
		RoomStatus = roomStatus;
		RoomPrice = roomPrice;
	}

	public String getRoomId() {
		return RoomId;
	}

	public void setRoomId(String roomId) {
		RoomId = roomId;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public String getRoomStatus() {
		return RoomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		RoomStatus = roomStatus;
	}

	public BigDecimal getRoomPrice() {
		return RoomPrice;
	}

	public void setRoomPrice(BigDecimal roomPrice) {
		RoomPrice = roomPrice;
	}
	
	public Room toRoom() {
		return new Room(RoomId,RoomType,RoomStatus,RoomPrice);
	}
	
	public Object[] toArray() {
		return new Object[] {RoomId,RoomType,RoomStatus,RoomPrice};
	}

	@Override
	public String toString() {
		return "RoomDomain [RoomId=" + RoomId + ", RoomType=" + RoomType + ", RoomStatus=" + RoomStatus + ", RoomPrice="
				+ RoomPrice + ", getRoomId()=" + getRoomId() + ", getRoomType()=" + getRoomType() + ", getRoomStatus()="
				+ getRoomStatus() + ", getRoomPrice()=" + getRoomPrice() + ", toRoom()=" + toRoom() + ", toArray()="
				+ Arrays.toString(toArray()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
