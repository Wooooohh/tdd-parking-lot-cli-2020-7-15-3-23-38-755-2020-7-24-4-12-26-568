package com.oocl.parkingsystem;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

  Map<String, String> carsMap;

  public ParkingBoy() {
    carsMap = new HashMap<>();
  }

  public ParkingTicket park(Car car) {
    String carId = car.getCarId();
    ParkingTicket parkingTicket = new ParkingTicket(carId);
    String ticketId = parkingTicket.getTicketId();
    carsMap.put(ticketId, carId);
    return parkingTicket;
  }

  public ParkingTicket[] park(Car[] cars){
      ParkingTicket[] tickets = new ParkingTicket[cars.length];
      for(int i = 0; i < cars.length; i++){
          tickets[i] = this.park(cars[i]);
      }
      return tickets;
  }

  public Car fetch(ParkingTicket parkingTicket) {
    String ticketId = parkingTicket.getTicketId();
    String carId = carsMap.get(ticketId);
    if(carId == null)
        return null;
    Car car = new Car(carId);
    return car;
  }

}
