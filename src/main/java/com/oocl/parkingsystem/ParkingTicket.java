package com.oocl.parkingsystem;

public class ParkingTicket {

  private String ticketId;

  public ParkingTicket(String carId) {
    ticketId = carId + "park";
  }

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }
}
