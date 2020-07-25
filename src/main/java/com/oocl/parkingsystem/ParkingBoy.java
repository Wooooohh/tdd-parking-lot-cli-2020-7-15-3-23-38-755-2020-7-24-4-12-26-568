package com.oocl.parkingsystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

  Map<String, String> carsMap;

  int capacity = 10;

    public ParkingBoy() {
    carsMap = new HashMap<>();
  }

  public ParkingTicket park(Car car) {
    if (carsMap.size() < 10) {
      String carId = car.getCarId();
      ParkingTicket parkingTicket = new ParkingTicket(carId);
      String ticketId = parkingTicket.getTicketId();
      carsMap.put(ticketId, carId);
      return parkingTicket;
    }
    return null;
  }

  public ParkingTicket[] park(Car[] cars) {
    ParkingTicket[] tickets = new ParkingTicket[cars.length];
    for (int i = 0; i < cars.length; i++) {
      tickets[i] = this.park(cars[i]);
    }
    return tickets;
  }

  public Car fetch(ParkingTicket parkingTicket) {
    if (parkingTicket == null) return null;
    String ticketId = parkingTicket.getTicketId();
    String carId = carsMap.get(ticketId);
    carsMap.remove(ticketId);
    if (carId == null) return null;
    Car car = new Car(carId);
    return car;
  }

    public String queryErrorMessage(ParkingTicket parkingTicket) {
        String errorMessage = null;
        if(!carsMap.containsKey(parkingTicket.getTicketId())){
            errorMessage = "Unrecognized parking ticket.";
        }
        return errorMessage;
    }
}
