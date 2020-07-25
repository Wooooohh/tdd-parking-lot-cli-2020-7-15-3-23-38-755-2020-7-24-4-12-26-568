package com.oocl.parkingsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

  Map<String, String> carsMap;

  int totalCapacity;

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
    carsMap = new HashMap<>();
    for(ParkingLot parkingLot : parkingLots){
      totalCapacity += parkingLot.getCapacity();
    }
  }

  public ParkingTicket park(Car car) {
    if (carsMap.size() < totalCapacity) {
      for(ParkingLot parkingLot : parkingLots){
        if (!parkingLot.isFull()) {
          String carId = car.getCarId();
          ParkingTicket parkingTicket = new ParkingTicket(carId, parkingLot.getLotId(), 1);
          String ticketId = parkingTicket.getTicketId();
          carsMap.put(ticketId, carId);
          parkingLot.putCar(car);
          return parkingTicket;
        }
      }
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
        if(!(carsMap.size() < totalCapacity))
            return "Not enough position.";
        return null;
    }
}
