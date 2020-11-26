package entity;

import java.math.BigDecimal;

import domain.RoomDomain;

public class Room {
	String roomId;
	String roomType;
	String roomStatus;
	BigDecimal roomPrice;
	
	
	
	public Room() {
		
	}



	public Room(String roomId, String roomType, String roomStatus, BigDecimal roomPrice) {
		
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomStatus = roomStatus;
		this.roomPrice = roomPrice;
	}



	public String getRoomId() {
		return roomId;
	}



	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}



	public String getRoomType() {
		return roomType;
	}



	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}



	public String getRoomStatus() {
		return roomStatus;
	}



	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}



	public BigDecimal getRoomPrice() {
		return roomPrice;
	}



	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	public RoomDomain toRoomDomain() {
		return new RoomDomain(roomId,roomType,roomStatus,roomPrice);
	}



	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomStatus=" + roomStatus + ", roomPrice="
				+ roomPrice + ", getRoomId()=" + getRoomId() + ", getRoomType()=" + getRoomType() + ", getRoomStatus()="
				+ getRoomStatus() + ", getRoomPrice()=" + getRoomPrice() + "]";
	}



	
	
}
