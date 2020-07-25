package com.oocl.parkingsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

  Map<String, String> carsMap;

  int capacity = 10;

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
    carsMap = new HashMap<>();
  }

  public ParkingTicket park(Car car) {
    if (carsMap.size() < capacity) {
      String carId = car.getCarId();
      ParkingTicket parkingTicket = new ParkingTicket(carId,1);
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
        if(parkingTicket == null)
            return "Please provide your parking ticket.";
        if(!carsMap.containsKey(parkingTicket.getTicketId()))
            return "Unrecognized parking ticket.";
        return null;
    }

    public String queryErrorMessage(Car car) {
        if(!(carsMap.size() < capacity))
            return "Not enough position.";
        return null;
    }
}
