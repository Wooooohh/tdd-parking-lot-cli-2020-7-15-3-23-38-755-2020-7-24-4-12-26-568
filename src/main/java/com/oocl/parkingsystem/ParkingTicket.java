package com.oocl.parkingsystem;

public class ParkingTicket {

  private String ticketId;

  private int parkingLotId;

  private int position;

  private int parkingBoyId;

  public ParkingTicket(String carId, int parkingLotId, int position, int parkingBoyId) {
    ticketId = carId + "park" + parkingLotId;
    this.parkingLotId = parkingLotId;
    this.position = position;
    this.parkingBoyId = parkingBoyId;
  }

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  public int getParkingLotId() {
    return parkingLotId;
  }

  public void setParkingLotId(int parkingLotId) {
    this.parkingLotId = parkingLotId;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getParkingBoyId() {
    return parkingBoyId;
  }

  public void setParkingBoyId(int parkingBoyId) {
    this.parkingBoyId = parkingBoyId;
  }
}
