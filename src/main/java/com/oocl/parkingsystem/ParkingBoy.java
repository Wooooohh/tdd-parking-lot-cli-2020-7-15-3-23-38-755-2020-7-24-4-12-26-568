package com.oocl.parkingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoy {

  protected Map<String, String> carsMap;

  protected int totalCapacity;

  protected List<ParkingLot> parkingLots;

  public ParkingBoy(){
    parkingLots = new ArrayList<>();
  }

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
          return putCar(parkingLot, car);
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
    Car car = parkingLots.get(parkingTicket.getParkingLotId()-1).getCar(parkingTicket.getPosition()-1);
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

    public ParkingTicket putCar(ParkingLot parkingLot, Car car){
      String carId = car.getCarId();
      parkingLot.putCar(car);
      ParkingTicket parkingTicket = new ParkingTicket(carId, parkingLot.getLotId(), parkingLot.getPosition());
      String ticketId = parkingTicket.getTicketId();
      carsMap.put(ticketId, carId);
      return parkingTicket;

    }
}
