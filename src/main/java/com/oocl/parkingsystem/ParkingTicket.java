package com.oocl.parkingsystem;

public class ParkingTicket {

  private String ticketId;

  private int parkingLotId;

  public ParkingTicket(String carId, int parkingLotId) {
    ticketId = carId + "park";
    this.parkingLotId = parkingLotId;
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
}
